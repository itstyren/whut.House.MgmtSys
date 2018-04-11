<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修类型趋势变动</strong>
    </div>
    <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
// import { postHouseParamCount } from "@/api/dataAnalysis.js";
require("echarts/theme/macarons"); // echarts theme
let _ = require("underscore");
import { postFixTypeRecord } from "@/api/dataAnalysis.js";
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
    this.getData()
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
      postFixTypeRecord(data).then(res => {
        console.log(res.data.data)
        const data=res.data.data
        let _series=[]
        data.data.forEach(v => {
          console.log(v)
          _series.push(
            {
            name: v.name,
            type: "line",
            stack: "总量",
            areaStyle: { normal: {} },
            data:v.data
          },
          )
        });
        this.chart.setOption({
          legend:{
            data:data.ContentName
          },
          xAxis:[{
            data:data.dataString
          }],
          series:_series
        });
        this.chart.hideLoading();
      });
    },
    setOptions({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {
          trigger: "axis"
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "5%",
          top: "8%",
          containLabel: true
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
          }
        ],
        yAxis: [
          {
            type: "value"
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
