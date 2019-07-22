<template>
  <div class="card"
       :style="{height:height,width:width}">
    <div class="title">
      <strong>周维修处理情况分析</strong>
    </div>
    <div class="chart"
         ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
let _ = require("underscore");
import { getFixContentCount } from "@/api/dataAnalysis";
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
    this.getDate();
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
    getDate () {
      this.chart.showLoading();
      let roleId = this.$store.getters.roleId
      getFixContentCount(roleId).then(res => {
        const fixData = res.data.data.data;
        // console.log(fixData);
        this.chart.setOption({
          xAxis: { data: fixData[3].data },
          series: [
            {
              name: "审核量",
              type: "bar",
              data: fixData[1].data
            },
            {
              name: "拒绝量",
              type: "bar",
              data: fixData[0].data
            },
            {
              name: "申请量",
              type: "line",
              yAxisIndex: 1,
              data: fixData[2].data
            }
          ]
        });
        this.chart.hideLoading();
      });
    },
    setOptions ({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            crossStyle: {
              color: "#999"
            }
          }
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar"] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: ["审核量", "拒绝量", "申请量"]
        },
        xAxis: [
          {
            type: "category",
            axisPointer: {
              type: "shadow"
            }
          }
        ],
        yAxis: [
          {
            type: "value",
            name: "处理量",
            max: 5,
            position: "left"
          },
          {
            type: "value",
            name: "申请量",
            max: 10,
            position: "right"
          }
        ],
        series: [
          {
            name: "审核量",
            type: "bar",
          },
          {
            name: "拒绝量",
            type: "bar",
          },
          {
            name: "申请量",
            type: "line",
            yAxisIndex: 1,
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart () {
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
