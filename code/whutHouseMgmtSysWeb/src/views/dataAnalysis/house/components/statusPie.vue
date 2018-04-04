<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>房屋状态占比</strong>
    </div>
    <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
import { postHouseParamCount } from "@/api/dataAnalysis.js";
require("echarts/theme/macarons"); // echarts theme
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
    autoResize: {
      type: Boolean,
      default: true
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
    if (this.autoResize) {
      this.__resizeHanlder = _.debounce(() => {
        if (this.chart) {
          this.chart.resize();
        }
      }, 100);
      window.addEventListener("resize", this.__resizeHanlder);
    }
    this.getData();
  },
  watch: {
    filtersData(newVal) {
      this.getData(newVal);
    }
  },
  methods: {
    getData() {
      let params = {
        paramTypeId: 3
      };
      if (arguments[0] !== undefined) var data = arguments[0];
      else var data = {};
      this.chart.showLoading();
      postHouseParamCount(params, data).then(res => {
        // console.log(res.data.data)
        this.chart.setOption({
          legend: {
            data: res.data.data.name
          },
          series: {
            data: res.data.data.content
          }
        });
        this.chart.hideLoading();
      });
    },
    setOptions({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
          left: "20px",
          orient: "vertical",
          show: true,
          x: "left",
          data: []
        },
        series: [
          {
            name: "住房状态",
            type: "pie",
            radius: ["30%", "65%"],
            center: ["55%", "50%"],
            labelLine: {
              normal: {
                length: 20,
                length2: 70,
                lineStyle: {
                  color: "#333"
                }
              }
            },
            label: {
              normal: {
                formatter: "{b|{b}}{a|{d}%}\n\n",
                borderWidth: 20,
                borderRadius: 4,
                // shadowBlur:3,
                // shadowOffsetX: 2,
                // shadowOffsetY: 2,
                // shadowColor: '#999',
                padding: [0, -70],
                rich: {
                  a: {
                    color: "#333",
                    fontSize: 12,
                    lineHeight: 20
                  },
                  b: {
                    fontSize: 12,
                    lineHeight: 20,
                    color: "#333"
                  }
                }
              }
            },
            data: []
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart() {
      this.chart = echarts.init(this.$refs.pageView, "macarons");
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
