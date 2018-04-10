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
  },
  watch: {
    filtersData(newVal) {
      this.getData(newVal);
    }
  },
  methods: {
    getData() {},
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
          data: [
            "服装鞋包",
            "家用电器",
            "居家生活",
            "美食厨房",
            "美妆洗护",
            "母婴用品",
            "其他",
            "手机数码",
            "书籍",
            "运动户外",
            "珠宝饰品"
          ]
        },
        series: [
          {
            name: "类目",
            type: "pie",
            radius: "70%",
            center: ["50%", "50%"],
            data: [
              {
                value: 412,
                name: "服装鞋包",
              },
              {
                value: 480,
                name: "家用电器",
              },
              {
                value: 622,
                name: "居家生活",
              },
              {
                value: 168,
                name: "美食厨房",
              },
              {
                value: 207,
                name: "美妆洗护",
              },
              {
                value: 9,
                name: "母婴用品",
              },
              {
                value: 43,
                name: "其他",
              },
              {
                value: 1403,
                name: "手机数码",
              },
              {
                value: 6272,
                name: "书籍",
              },
              {
                value: 12,
                name: "运动户外",
              },
              {
                value: 371,
                name: "珠宝饰品",
              }
            ],
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
