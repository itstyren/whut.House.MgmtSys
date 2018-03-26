<template>
<div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>周访问量</strong>
    </div>
  <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import { getVisitCapacity } from "@/api/dataAnalysis";
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
        xAxis: {
          type: "category",
          data: ["周一", "周二", "周三", "周四", "周五", "周六", "周天"],
          boundaryGap: false
        },
        yAxis: {
          axisTick: {
            show: false
          }
        },
        series: [
          {
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: "line",
            areaStyle: {}
          }
        ],
        grid: {
          left: 10,
          right: 20,
          bottom: 20,
          top: 30,
          containLabel: true
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross"
          },
          padding: [5, 10]
        },
        smooth: 0.2,
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
    width: 98%;
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
  height: calc(100% - (10px + 5px) * 2);
}
</style>
