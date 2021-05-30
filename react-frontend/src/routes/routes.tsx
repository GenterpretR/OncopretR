import AllOutIcon from "@material-ui/icons/AllOut";
import DashboardIcon from "@material-ui/icons/Dashboard";
import React from "react";
import Album from "../component/Album";
import { BulkRNATasks } from "../component/BulkRNA/BulkRNAtasks";
import { BulkRNAWorkflow } from "../component/BulkRNA/BulkRNAworkflow";
import { BarChartComponent, ScatterPlotComponent } from "../component/charts";
import Checkout from "../component/checkout/Checkout";
import Dashboard from "../component/Dashboard";
import Deposits from "../component/Deposits";
import { Home } from "../component/HomeComponent";
import Pricing from "../component/pricing";
import { SignIn } from "../component/SignIn";
import { SignUp } from "../component/SignUp";
import { UserList } from "../component/UserList";

export const dashboardRoutes = [
  {
    path: "/signin",
    name: "Sign In",
    icon: <DashboardIcon></DashboardIcon>,
    component: <SignIn></SignIn>,
    layout: "/signin",
  },
  {
    path: "/SignUp",
    name: "SignUp",
    icon: <DashboardIcon></DashboardIcon>,
    component: <SignUp></SignUp>,
    layout: "/signup",
  },
  {
    path: "/dashboard",
    name: "Dashboard",
    icon: <DashboardIcon></DashboardIcon>,
    component: <Dashboard></Dashboard>,
    layout: "/dashboard",
  },
  {
    path: "/admin",
    name: "admin",
    icon: <AllOutIcon></AllOutIcon>,
    component: <Dashboard></Dashboard>,
    layout: "/admin",
  },
  {
    path: "/dashboard/checkout",
    name: "/dashboard/checkout",
    icon: <AllOutIcon></AllOutIcon>,
    component: <Checkout></Checkout>,
    layout: "/admin",
  },
  {
    path: "/",
    name: "Sign In",
    icon: <DashboardIcon></DashboardIcon>,
    component: <SignIn></SignIn>,
    layout: "/",
  },
];
export const secondaryRoutes = [
  // {
  //   path: "/dashboard/home",
  //   name: "/dashboard/home",
  //   icon: <AllOutIcon></AllOutIcon>,
  //   component: <Charts></Home>,
  //   layout: "/dashboard/home",
  // },
  {
    path: "/dashboard/home",
    name: "/dashboard/home",
    icon: <AllOutIcon></AllOutIcon>,
    component: (
      <React.Fragment>
        <ScatterPlotComponent></ScatterPlotComponent>
        <BarChartComponent></BarChartComponent>
      </React.Fragment>
    ),
    layout: "/dashboard/home",
  },
  {
    path: "/dashboard/BulkRNATasks",
    name: "/dashboard/BulkRNATasks",
    icon: <AllOutIcon></AllOutIcon>,
    component: <BulkRNATasks></BulkRNATasks>,
    layout: "/dashboard/BulkRNATasks",
  },
  {
    path: "/dashboard/BulkRNAWorkflow",
    name: "/dashboard/BulkRNAWorkflow",
    icon: <AllOutIcon></AllOutIcon>,
    component: <BulkRNAWorkflow></BulkRNAWorkflow>,
    layout: "/dashboard/BulkRNAWorkflow",
  },

  {
    path: "/dashboard/charts",
    name: "/dashboard/checkout",
    icon: <AllOutIcon></AllOutIcon>,
    component: (
      <React.Fragment>
        <ScatterPlotComponent></ScatterPlotComponent>
        <BarChartComponent></BarChartComponent>
      </React.Fragment>
    ),
    layout: "/dashboard/checkout",
  },
  {
    path: "/dashboard/pricing",
    name: "/dashboard/pricing",
    icon: <AllOutIcon></AllOutIcon>,
    component: <Pricing></Pricing>,
    layout: "/dashboard/pricing",
  },
  {
    path: "/dashboard/album",
    name: "/dashboard/album",
    icon: <AllOutIcon></AllOutIcon>,
    component: <Album></Album>,
    layout: "/dashboard/album",
  },
  {
    path: "/dashboard/deposits",
    name: "/dashboard/deposits",
    icon: <AllOutIcon></AllOutIcon>,
    component: <Deposits></Deposits>,
    layout: "/dashboard/deposits",
  },
  {
    path: "/dashboard/userlist",
    name: "/dashboard/userlist",
    icon: <AllOutIcon></AllOutIcon>,
    component: <UserList></UserList>,
    layout: "/dashboard/userlist",
  },
];
