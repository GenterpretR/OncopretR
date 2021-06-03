import { Grid } from "@material-ui/core";
import axios from "axios";
import React, { useEffect } from "react";
import { useParams } from "react-router-dom";
import {
  failureToast,
  //  successToast
} from "../../util/util";
import { ScatterPlotComponent } from "../charts";

export function BulkRNAWorkflowResult(props: any) {
  // const [loading, setLoading] = React.useState<boolean>(false);
  const [result, setResult] = React.useState<any>("");
  let { id } = useParams<any>();

  // const [parsedJson, setParsedJson] = React.useState<any>([]);
  // const [columns, setColumns] = React.useState<any>([]);
  const fetchTaskResult = (taskId: any) => {
    axios
      .get("/api/v1/bulkRNA/jobs/results/" + taskId)
      .then((response: any) => {
        try {
          setResult(JSON.parse(JSON.parse(JSON.parse(response.data.result))));
        } catch (e: any) {}
      })
      .catch((reponse: any) => {
        props.enqueueSnackbar(reponse.error, failureToast);
      });
  };
  useEffect(() => {
    fetchTaskResult(id);
  }, []); // eslint-disable-line react-hooks/exhaustive-deps
  console.log(result);
  return (
    <React.Fragment>
      <Grid container>
        <Grid item xs={12} style={{ overflowWrap: "break-word" }}>
          <ScatterPlotComponent data={result}> </ScatterPlotComponent>
          {JSON.stringify(result)}
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
