<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修评价占比分析  </strong>
    </div>
    <div class="chart" ref="pageView"></div>
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
        // title: {
        //           text: '雷达图'
        //       },
        tooltip: {},
        legend: {
          orient: "vertical",
          top: '5%',
          left: '5%',
          itemWidth: 12,
          itemHeight: 12,
          // data: ["维修评价", "实际开销"],
           data: ["维修评价"],          
          textStyle: {
            color: "#000"
          }
        },
        radar: {
          radius: "70%",
          center:['50%','45%'],
          splitNumber: 8,
          axisLine: {
            lineStyle: {
              color: "#000",
              opacity: 0.2
            }
          },
          splitLine: {
            lineStyle: {
              color: "#000",
              opacity: 0.2
            }
          },
          splitArea: {
            areaStyle: {
              color: "rgba(127,95,132,.3)",
              opacity: 1,
              shadowBlur: 45,
              shadowColor: "rgba(0,0,0,.5)",
              shadowOffsetX: 0,
              shadowOffsetY: 15
            }
          },
          indicator: [
            {
              name: "较好",
              max: 6000
            },
            {
              name: "一般",
              max: 16000
            },
            {
              name: "较差",
              max: 30000
            },
            {
              name: "很满意",
              max: 35000
            },
            {
              name: "不满意",
              max: 50000
            },
            {
              name: "无评价",
              max: 25000
            }
          ]
        },
        series: [
          {
            name: "预算 vs 开销",
            type: "radar",
            symbolSize: 0,
            areaStyle: {
              normal: {
                shadowBlur: 13,
                shadowColor: "rgba(0,0,0,.2)",
                shadowOffsetX: 0,
                shadowOffsetY: 10,
                opacity: 1
              }
            },
            data: [
              {
                value: [5000, 7000, 12000, 11000, 15000, 14000],
                name: "维修评价"
              },
              // {
              //   value: [2500, 12000, 8000, 8500, 12000, 12000],
              //   name: "实际开销"
              // }
            ]
          }
        ],
        color: ["#ef4b4c", "#b1eadb"],
        //   backgroundColor: {
        //       type: 'radial',
        //       x: 0.4,
        //       y: 0.4,
        //       r: 0.35,
        //       colorStops: [{
        //           offset: 0,
        //           color: '#895355' // 0% 处的颜色
        //       }, {
        //           offset: .4,
        //           color: '#593640' // 100% 处的颜色
        //       }, {
        //           offset: 1,
        //           color: '#39273d' // 100% 处的颜色
        //       }],
        //       globalCoord: false // 缺省为 false
        //   },
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
