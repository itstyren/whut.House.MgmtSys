<template>
  <div class="card"
       :style="{height:height}">
    <div class="title">
      <strong>当前服务器负载率</strong>
    </div>
    <div class="chart"
         ref="flowmeter"></div>
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
  data () {
    return {
      chart: null
    };
  },
  mounted () {
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
      handler (val) {
        this.setOptions(val);
      }
    }
  },
  methods: {
    setOptions ({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {
          formatter: "{a} <br/>{b} : {c}%"
        },
        series: [
          {
            name: "当前服务器负载率",
            type: "gauge",
            detail: { formatter: "{value}%" },
            data: [{ value: 21, name: "负载率" }]
          }
        ]
      });
    },
    initChart () {
      this.chart = echarts.init(this.$refs.flowmeter, "macarons");
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
