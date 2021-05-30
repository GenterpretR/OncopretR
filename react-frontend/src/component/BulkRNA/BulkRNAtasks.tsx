import { Button, Grid } from "@material-ui/core";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import axios from "axios";
import { withSnackbar } from "notistack";
import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import { failureToast } from "../../util/util";
import Title from "../Title";
export function BulkRNATasksComponent(props: any) {
  const [userList, setUserList] = React.useState<any>([]);
  const history = useHistory();
  const user = JSON.parse(sessionStorage.getItem("user") || "{roles:[]}");

  const fetchTaskList = () => {
    axios
      .get("/api/v1/bulkRNA/tasks/" + user.id)
      .then((response: any) => {
        setUserList(response.data);
      })
      .catch((reponse: any) => {
        props.enqueueSnackbar(reponse.error, failureToast);
      });
  };
  //   const activateAccount = (user: any) => {
  //     axios
  //       .get("/api/v1/admin/user/activate/" + user.id)
  //       .then((response: any) => {
  //         props.enqueueSnackbar("User activated", successToast);
  //         fetchUserList();
  //       })
  //       .catch((reponse: any) => {
  //         props.enqueueSnackbar("reponse.error", successToast);
  //       });
  //   };
  //   const deActivateAccount = (user: any) => {
  //     axios
  //       .get("/api/v1/admin/user/deactivate/" + user.id)
  //       .then((response: any) => {
  //         props.enqueueSnackbar("User Deactivated", successToast);
  //         fetchUserList();
  //       })
  //       .catch((reponse: any) => {
  //         props.enqueueSnackbar(reponse.error, failureToast);
  //       });
  //   };
  //   const deleteAccount = (user: any) => {
  //     axios
  //       .get("/api/v1/admin/user/deleteUser/" + user.id)
  //       .then((response: any) => {
  //         props.enqueueSnackbar("User Deleted", successToast);
  //         fetchUserList();
  //       })
  //       .catch((reponse: any) => {
  //         props.enqueueSnackbar(reponse.error, failureToast);
  //       });
  //   };
  const navigateToWorkflow = () => {
    history.push("/dashboard/BulkRNAWorkflow");
  };
  useEffect(() => {
    fetchTaskList();
  }, []); // eslint-disable-line react-hooks/exhaustive-deps

  return (
    <React.Fragment>
      <Grid container>
        <Grid item xs={6}>
          <Title>Bulk RNA workflow</Title>
        </Grid>
        <Grid item xs={6} style={{ textAlign: "right" }}>
          <Button
            size="small"
            variant="contained"
            color="primary"
            style={{ marginBottom: "10px" }}
            onClick={() => navigateToWorkflow()}
          >
            Create A Task +
          </Button>
        </Grid>
      </Grid>

      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell align="left">S.No</TableCell>
            <TableCell align="center">Name</TableCell>
            <TableCell align="center">Create Date</TableCell>
            <TableCell align="center">Link to Results</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {userList.length > 0 ? (
            userList?.map((row: any) => (
              <TableRow key={row.id}>
                <TableCell align="left">{row.id}</TableCell>
                <TableCell align="center">{row.jobname}</TableCell>
                <TableCell align="center">
                  {row.createDate.substring(0, 10)}
                </TableCell>
                <TableCell align="center">{row.username}</TableCell>
              </TableRow>
            ))
          ) : (
            <TableRow>
              <TableCell colSpan={4} style={{ textAlign: "center" }}>
                {"No Jobs to display"}
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </React.Fragment>
  );
}
export const BulkRNATasks = withSnackbar(BulkRNATasksComponent);
