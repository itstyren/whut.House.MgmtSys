<template>
<div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>周维修处理情况分析</strong>
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
          trigger: "axis",
          axisPointer: {
            type: "cross"
          }
        },
        grid: {
          right: "7%"
        },
        toolbox: {
          feature: {
            saveAsImage: { show: true }
          },
          right: "20"
        },
        legend: {
          data: ["待处理", "已处理","已拒绝", "申请量"]
        },
        xAxis: [
          {
            type: "category",
            data: ["周一", "周二", "周三", "周四", "周五", "周六", "周天"]
          }
        ],
        yAxis: [
          {
            type: "value",
            name: "个数",
            position: "left"
          }
        ],
        series: [
          {
            name: "待处理",
            type: "bar",
            data: [2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 23]
          },
          {
            name: "已处理",
            type: "bar",
            data: [2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 23]
          },
                    {
            name: "已拒绝",
            type: "bar",
            data: [3, 7, 2, 23, 31, 40, 20]
          },
          {
            name: "申请量",
            type: "line",
            data: [21.6, 52.9, 94.0, 26.4, 38.7, 70.7, 21]
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
