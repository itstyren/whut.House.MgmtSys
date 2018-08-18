<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>入住率分析</strong>
    </div>
    <div class="chart" ref="structPie"></div>
  </div>
</template>

<script>
const color = [
  "#3fb1e3",
  "#6be6c1",
  "#626c91",
  "#a0a7e6",
  "#c4ebad",
  "#96dee8"
];
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import { postHouseRecordCampus } from "@/api/dataAnalysis.js";
let _ = require("underscore");
export default {
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "350px"
    },
    filtersData: {
      type: Object,
      default: {}
    }
  },
  data() {
    return {
      chart: null
    };
  },
  mounted() {
    this.initChart();
    this.getData();
    if (this.autoResize) {
      this.__resizeHanlder = _.debounce(() => {
        if (this.chart) {
          this.chart.resize();
        }
      }, 100);
      window.addEventListener("resize", this.__resizeHanlder);
    }
  },
  watch: {
    filtersData(newVal) {
      this.getData(newVal);
    }
  },
  methods: {
    getData() {
      if (arguments[0] !== undefined) var data = arguments[0];
      else var data = {};
      this.chart.showLoading();
      postHouseRecordCampus(data).then(res => {
        let _series = [];
        res.data.data.data.forEach((data, index) => {
          // console.log(data)
          _series.push({
            data: data.data
          });
           _series[index].data[0].name=res.data.data.name[index]
          _series[index].data[1].itemStyle = {
            normal: {
              color: "rgba(0,0,0,0)",
              label: { show: false },
              labelLine: { show: false }
            },
            emphasis: {
              color: "rgba(0,0,0,0)"
            }
          };
        });
        console.log(_series)
        this.chart.setOption({
            legend:{
                data:res.data.data.name
            },
          series:_series
        });
        this.chart.hideLoading();
      });
    },
    setOptions({ expectedData, actualData } = {}) {
      var dataStyle = {
        normal: {
          label: { show: false },
          labelLine: { show: false },
          shadowBlur: 20,
          shadowColor: "rgba(40, 40, 40, 0.1)"
        }
      };
      var placeHolderStyle = {
        normal: {
          color: "rgba(0,0,0,0)",
          label: { show: false },
          labelLine: { show: false }
        },
        emphasis: {
          color: "rgba(0,0,0,0)"
        }
      };
      this.chart.setOption({
        //backgroundColor: "#f4f2e3",
        color: ["#85b6b2", "#6d4f8d", "#cd5e7e", "#e38980", "#f7db88"],
        tooltip: {
          show: true,
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          itemGap: 12,
          orient: "vertical",
          left: "5%",
          data: ["余家头北区", "余家头南区", "东院校区", "西院校区", "鉴湖校区"]
        },
        series: [
          {
            name: "区域入住率",
            type: "pie",
            clockWise: false,
            radius: ["85%", "75%"],
            center: ["60%", "45%"],
            itemStyle: dataStyle,
            hoverAnimation: false,

            // data: [
            //   {
            //     value: 300,
            //     name: "余家头北区"
            //   },
            //   {
            //     value: 100,
            //     name: "invisible",
            //     itemStyle: placeHolderStyle
            //   }
            // ]
          },
          {
            name: "区域入住率",
            type: "pie",
            clockWise: false,
            radius: ["75%", "65%"],
            center: ["60%", "45%"],
            itemStyle: dataStyle,
            hoverAnimation: false,

            // data: [
            //   {
            //     value: 150,
            //     name: "余家头南区"
            //   },
            //   {
            //     value: 60,
            //     name: "invisible",
            //     itemStyle: placeHolderStyle
            //   }
            // ]
          },
          {
            name: "区域入住率",
            type: "pie",
            clockWise: false,
            hoverAnimation: false,
            radius: ["65%", "55%"],
            center: ["60%", "45%"],
            itemStyle: dataStyle,

            // data: [
            //   {
            //     value: 80,
            //     name: "东院校区"
            //   },
            //   {
            //     value: 50,
            //     name: "invisible",
            //     itemStyle: placeHolderStyle
            //   }
            // ]
          },
          {
            name: "区域入住率",
            type: "pie",
            clockWise: false,
            hoverAnimation: false,
            radius: ["55%", "45%"],
            center: ["60%", "45%"],
            itemStyle: dataStyle,

            // data: [
            //   {
            //     value: 45,
            //     name: "西院校区"
            //   },
            //   {
            //     value: 30,
            //     name: "invisible",
            //     itemStyle: placeHolderStyle
            //   }
            // ]
          },
          {
            name: "区域入住率",
            type: "pie",
            clockWise: false,
            hoverAnimation: false,
            radius: ["45%", "35%"],
            center: ["60%", "45%"],
            itemStyle: dataStyle,

            // data: [
            //   {
            //     value: 30,
            //     name: "鉴湖校区"
            //   },
            //   {
            //     value: 30,
            //     name: "invisible",
            //     itemStyle: placeHolderStyle
            //   }
            // ]
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart() {
      this.chart = echarts.init(this.$refs.structPie);
      this.setOptions(this.chartData);
    }
  }
};
</script>


<style scoped lang="scss">
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: -10px;
    z-index: 1;
    left: 1%;
    right: 1%;
  }
}

.chart {
  margin-top: 30px;
  height: calc(100% - 55px);
}
</style>
