<template>
<div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>周维修类型统计</strong>
    </div>
  <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
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
    }
  },
  data() {
    return {
      chart: null,
      data: [820, 932, 901, 934, 1290, 1330, 1320]
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
  },
  watch: {
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val);
      }
    }
  },
  methods: {
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
          data: ["窗户", "漏水", "没电", "太小了", "跟南湖宿舍一样"]
        },
        series: [
          {
            name: "维修类型",
            type: "pie",
            radius: ["30%", "55%"],
            center: ["60%", "50%"],
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
            data: [
              { value: 135, name: "窗户" },
              { value: 1048, name: "漏水" },
              { value: 251, name: "没电" },
              { value: 147, name: "太小了" },
              { value: 102, name: "跟南湖宿舍一样" }
            ]
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
    width: 100%;
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
