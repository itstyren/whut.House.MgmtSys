<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>房屋结构占比</strong>
    </div>
    <div class="chart" ref="structPie"></div>
  </div>
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
let _ = require("underscore");
import { getHouseParamCount } from "@/api/dataAnalysis";
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
      let params = {
        paramTypeId: 1
      };
     if(arguments[0]!==undefined)
      var data = arguments[0];
      else var data={}
      this.chart.showLoading();
      getHouseParamCount(params, data).then(res => {
        this.chart.setOption({
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
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [
          {
            name: "结构占比",
            type: "pie",
            radius: [30, "85%"],
            center: ["50%", "45%"],
            roseType: "radius",
            //color: ['#f2c955', '#00a69d', '#46d185', '#ec5845'],
            label: {
              normal: {
                textStyle: {
                  fontSize: 14
                },
                formatter: function(param) {
                  return param.name + ":\n" + Math.round(param.percent) + "%";
                }
              }
            },
            labelLine: {
              normal: {
                smooth: true,
                lineStyle: {
                  width: 2
                }
              },
              smooth: 0.2,
              length: 10,
              length2: 20
            },
            itemStyle: {
              normal: {
                shadowBlur: 30,
                shadowColor: "rgba(0, 0, 0, 0.1)"
              }
            },

            animationType: "scale",
            animationEasing: "elasticOut",
            animationDelay: function(idx) {
              return Math.random() * 200;
            }
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart() {
      this.chart = echarts.init(this.$refs.structPie, "macarons");
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
