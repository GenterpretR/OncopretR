import {
  Button,
  Grid,
  Table,
  TableBody,
  TableCell,
  TableRow,
  TextField,
} from "@material-ui/core";
import { Autocomplete } from "@material-ui/lab";
import axios from "axios";
// import _ from "lodash";
import { withSnackbar } from "notistack";
import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import { failureToast, successToast } from "../../util/util";
import Title from "../Title";

export function BulkRNAWorkflowComponent(props: any) {
  // const [loading, setLoading] = React.useState<boolean>(false);
  const [drugList, setDrugList] = React.useState<any>("");
  const history = useHistory();
  const fileRef: any = React.createRef();
  const drugRef: any = React.createRef();

  const [parsedJson, setParsedJson] = React.useState<any>([]);
  // const [columns, setColumns] = React.useState<any>([]);
  const loadCSV = () => {
    console.log(fileRef);
    if (fileRef.current.files && fileRef.current.files.length > 0) {
      // setLoading(true);
      const file = fileRef.current.files[0];
      const reader = new FileReader();
      reader.onload = (evt: any) => {
        const bstr = evt.target.result;
        const jsonData = csvJSON(bstr);
        // const columns = _.keys(jsonData[0]).map((k: any) => {
        //   return { title: k, field: k };
        // });
        // setColumns(columns);
        setParsedJson(jsonData);
        // setLoading(false);
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
    console.log(drugRef);
    const formData = new FormData();
    const user = JSON.parse(sessionStorage.getItem("user") || "{roles:[]}");
    const drugs = drugRef.current.innerText?.split("\n");
    drugs?.splice(0, 1);
    formData.append("file", fileRef.current.files[0]);
    formData.append("userId", user.id);
    formData.append("selectedDrugs", drugs?.join());
    axios
      .post("/api/v1/bulkRNA/create-new-job", formData)
      .then((response: any) => {
        props.enqueueSnackbar(
          "Csv uploaded successfully for job",
          successToast
        );
        history.push("/dashboard/BulkRNATasks");
        // setTaskList(response.data);
      })
      .catch((reponse: any) => {
        props.enqueueSnackbar("Failed to upload the CSV", failureToast);
      });
  };
  const fetchDrugList = () => {
    axios
      .get("/api/v1/bulkRNA/drugs")
      .then((response: any) => {
        setDrugList(response.data);
      })
      .catch((reponse: any) => {
        props.enqueueSnackbar(reponse.error, failureToast);
      });
  };
  useEffect(() => {
    fetchDrugList();
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  return (
    <React.Fragment>
      <Grid container justify="center">
        <Grid item xs={3}>
          <Title>Bulk RNA workflow</Title>
        </Grid>
        <Grid item xs={3}>
          <TextField
            inputRef={fileRef}
            type="file"
            aria-label="Upload CSV"
            onChange={() => loadCSV()}
          ></TextField>
        </Grid>
        <Grid item xs={3}>
          <Autocomplete
            id="drug-list"
            options={drugList}
            size="small"
            getOptionLabel={(option: any) => option.smiles}
            multiple
            ref={drugRef}
            style={{ minWidth: 300 }}
            renderInput={(params) => (
              <TextField {...params} label="Drugs List" variant="outlined" />
            )}
          />
        </Grid>
        <Grid item xs={3} style={{ textAlign: "right" }}>
          <Button
            size="small"
            variant="contained"
            color="primary"
            onClick={() => uploadCSV()}
            disabled={parsedJson.length === 0}
          >
            Upload Data for Job Processing
          </Button>
        </Grid>
        {parsedJson.length > 0 && (
          <Grid item xs={12} style={{ overflow: "auto", marginTop: "15px" }}>
            <Table size="small" aria-label="a dense table">
              <TableBody>
                {parsedJson.map((row: any) => {
                  const columns = Object.keys(row);
                  return (
                    <TableRow key={row.id}>
                      {columns.map((column: any) => (
                        <TableCell align="right">{row[column]}</TableCell>
                      ))}
                    </TableRow>
                  );
                })}
              </TableBody>
            </Table>

            {/* <MaterialTable
              isLoading={loading}
              columns={columns}
              data={parsedJson}
              options={{
                search: false,
                filtering: false,
                grouping: false,
                selection: false,
                sorting: false

              }}
              title="Selected Data"
            /> */}
          </Grid>
        )}
      </Grid>
    </React.Fragment>
  );
}
export const BulkRNAWorkflow = withSnackbar(BulkRNAWorkflowComponent);
