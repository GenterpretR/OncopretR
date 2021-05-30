import { Button, Grid, TextField } from "@material-ui/core";
import axios from "axios";
import _ from "lodash";
import MaterialTable from "material-table";
import { withSnackbar } from "notistack";
import React from "react";
import { useHistory } from "react-router-dom";
import { failureToast, successToast } from "../../util/util";
import Title from "../Title";

export function BulkRNAWorkflowComponent(props: any) {
  const [loading, setLoading] = React.useState<boolean>(false);
  const history = useHistory();

  const fileRef: any = React.createRef();
  const [parsedJson, setParsedJson] = React.useState<any>([]);
  const [columns, setColumns] = React.useState<any>([]);
  const loadCSV = () => {
    console.log(fileRef);
    if (fileRef.current.files && fileRef.current.files.length > 0) {
      setLoading(true);
      const file = fileRef.current.files[0];
      const reader = new FileReader();
      reader.onload = (evt: any) => {
        const bstr = evt.target.result;
        const jsonData = csvJSON(bstr);
        const columns = _.keys(jsonData[0]).map((k: any) => {
          return { title: k, field: k };
        });
        setColumns(columns);
        setParsedJson(jsonData);
        setLoading(false);
      };
      reader.readAsBinaryString(file);
    }
  };
  const csvJSON = (csv: any) => {
    const lines = csv.split("\n");
    const result = [];
    const headers = lines[0].split(",");

    for (let i = 1; i < lines.length; i++) {
      if (!lines[i]) continue;
      const obj: any = {};
      const currentline = lines[i].split(",");

      for (let j = 0; j < headers.length; j++) {
        obj[headers[j]] = currentline[j];
      }
      result.push(obj);
    }
    return result;
  };
  const uploadCSV = () => {
    const formData = new FormData();
    const user = JSON.parse(sessionStorage.getItem("user") || "{roles:[]}");

    formData.append("file", fileRef.current.files[0]);
    formData.append("userId", user.id);
    axios
      .post("/api/v1/bulkRNA/upload", formData)
      .then((response: any) => {
        props.enqueueSnackbar("Csv uploaded succesffuly for job", successToast);
        history.push("/dashboard/BulkRNATasks");
        // setTaskList(response.data);
      })
      .catch((reponse: any) => {
        props.enqueueSnackbar("Failed to upload the CSV", failureToast);
      });
  };

  return (
    <React.Fragment>
      <Grid container justify="center">
        <Grid item xs={4}>
          <Title>Bulk RNA workflow</Title>
        </Grid>
        <Grid item xs={4}>
          {" "}
          <TextField
            inputRef={fileRef}
            type="file"
            aria-label="Upload CSV"
            onChange={() => loadCSV()}
          ></TextField>
        </Grid>
        <Grid item xs={4} style={{ textAlign: "right" }}>
          {parsedJson.length > 0 && (
            <Button
              size="small"
              variant="contained"
              color="primary"
              onClick={() => uploadCSV()}
            >
              Upload Data for Job Processing
            </Button>
          )}
        </Grid>
        {parsedJson.length > 0 && (
          <Grid item xs={12}>
            <MaterialTable
              isLoading={loading}
              columns={columns}
              data={parsedJson}
              title="Selected Data"
            />
          </Grid>
        )}
        {/* <div
          style={{ width: "100vw", maxWidth: "100vw", maxHeight: "60vh" }}
        ></div> */}
      </Grid>
    </React.Fragment>
  );
}
export const BulkRNAWorkflow = withSnackbar(BulkRNAWorkflowComponent);
