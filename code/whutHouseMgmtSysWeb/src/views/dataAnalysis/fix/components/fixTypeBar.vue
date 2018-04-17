<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修类型比例</strong>
    </div>
    <div class="chart" ref="fixType"></div>
  </div>
</template>

<script>
import echarts from "echarts";
// import { postHouseParamCount } from "@/api/dataAnalysis.js";
require("echarts/theme/macarons"); // echarts theme
let _ = require("underscore");
import { postFixTypeBar } from "@/api/dataAnalysis.js";
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
      postFixTypeBar(data).then(res => {
        const data=res.data.data
        console.log(data)
        this.chart.setOption({
         legend:{
           data:data.name
         },
         series:{
           data:data.data
         }
        });
        this.chart.hideLoading();
      });
    },
    setOptions({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {d}%"
        },
        legend: {
          orient: "vertical",
          left: "6%",
          top: "3%",
        },
        series: [
          {
            name: "维修类型",
            type: "pie",
            radius: "70%",
            center: ["55%", "45%"],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart() {
      this.chart = echarts.init(this.$refs.fixType, "macarons");
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
