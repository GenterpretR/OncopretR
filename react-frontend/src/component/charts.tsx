import * as React from "react";
import * as Highcharts from "highcharts";
import HighchartsReact from "highcharts-react-official";

const options1: any = {
  chart: {
    type: "scatter",
    zoomType: "xy",
  },
  title: {
    text: "",
  },
  subtitle: {
    text: "",
  },
  xAxis: {
    title: {
      text: "Sample",
    },
    startOnTick: true,
    endOnTick: true,
    showLastLabel: true,
  },
  yAxis: {
    title: {
      text: "",
    },
  },
  legend: {
    layout: "vertical",
    align: "left",
    verticalAlign: "top",
    x: 100,
    y: 70,
    floating: true,
    borderWidth: 1,
  },
  plotOptions: {
    scatter: {
      marker: {
        radius: 5,
        states: {
          hover: {
            enabled: true,
            lineColor: "rgb(100,100,100)",
          },
        },
      },
      states: {
        hover: {
          marker: {
            enabled: false,
          },
        },
      },
      tooltip: {
        headerFormat: "<b>{series.name}</b><br>",
        pointFormat: "{point.x} cm, {point.y} kg",
      },
    },
  },
  series: [
    {
      name: "AVERAGE",
      color: "rgba(223, 83, 83, .5)",
      data: [],
    },
    {
      name: "MIN",
      color: "rgba(119, 152, 191, .5)",
      data: [],
    },
    {
      name: "MAX",
      color: "rgba(66, 223, 91, .5)",
      data: [],
    },
  ],
};

const options2: any = {
  chart: {
    type: "bar",
  },
  title: {
    text: "Stacked bar chart",
  },
  xAxis: {
    // categories: ["Apples", "Oranges", "Pears", "Grapes", "Bananas"],
  },
  yAxis: {
    min: 0,
    title: {
      text: "Total fruit consumption",
    },
  },
  legend: {
    // reversed: true,
  },
  plotOptions: {
    series: {
      stacking: "normal",
    },
  },
  series: [
    {
      data: [7, 0, 0, 0, 0],
    },
    {
      data: [0, 2, 0, 0, 0],
    },
    {
      data: [0, 0, 9, 0, 0],
    },
    {
      data: [0, 0, 0, 4, 0],
    },
    {
      data: [0, 0, 0, 0, 10],
    },
  ],
};
export const ScatterPlotComponent = (props: any) => {
  debugger;
  if (props.data) {
    options1.series[0].data = Object.values(props.data.AVG);
    options1.series[1].data = Object.values(props.data.MIN);
    options1.series[2].data = Object.values(props.data.MAX);
    return (
      <div>
        <HighchartsReact highcharts={Highcharts} options={options1} />
      </div>
    );
  } else {
    return <div></div>;
  }
};
export const BarChartComponent = (props: any) => {
  return (
    <div>
      <HighchartsReact highcharts={Highcharts} options={options2} {...props} />
    </div>
  );
};
