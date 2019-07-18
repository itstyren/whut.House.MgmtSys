<template>
  <div class="card"
       :style="{height:height,width:width}">
    <div class="title">
      <strong>入住率分析</strong>
    </div>
    <div class="chart"
         ref="structPie"></div>
  </div>
</template>

<script>
const color = ['#3fb1e3', '#6be6c1', '#626c91', '#a0a7e6', '#c4ebad', '#96dee8']
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
import { postHouseRecordCampus } from "@/api/dataAnalysis.js";
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
    filtersData: {
      type: Object,
      default: {}
    }
  },
  data () {
    return {
      chart: null
    };
  },
  mounted () {
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
    chartData: {
      deep: true,
      handler (val) {
        this.setOptions(val);
      }
    }
  },
  methods: {
    getData () {
      if (arguments[0] !== undefined) var data = arguments[0];
      else var data = {};
      let roleId = this.$store.getters.roleId
      this.chart.showLoading();
      postHouseRecordCampus(data, roleId).then(res => {
        let _series = [];
        res.data.data.data.forEach((data, index) => {
          // console.log(data)
          _series.push({
            name: data.name,
            data: [
              {
                value: data.data[0].value,
                name: data.data[0].name,
                label: {
                  normal: {
                    formatter: "{d} %",
                    textStyle: {
                      fontSize: 18
                    }
                  }
                }
              },
              {
                value: data.data[1].value,
                name: data.data[1].name,
                label: {
                  normal: {
                    formatter: `\n${data.name}`,
                    textStyle: {
                      color: "#555",
                      fontSize: 13
                    }
                  }
                },
                itemStyle: {
                  normal: {
                    color: "#aaa"
                  },
                  emphasis: {
                    color: "#aaa"
                  }
                }
              }
            ]
          });
        });
        this.chart.setOption({
          series: _series
        });
        this.chart.hideLoading();
      });
    },
    setOptions ({ expectedData, actualData } = {}) {
      this.chart.setOption({
        tooltip: {},
        series: [
          {
            type: "pie",
            radius: ["40%", "70%"],
            center: ["10%", "50%"],
            label: {
              normal: {
                position: "center"
              }
            }
          },
          {
            type: "pie",
            radius: ["40%", "70%"],
            center: ["30%", "50%"],
            color: "#ddd",
            label: {
              normal: {
                position: "center"
              }
            }
          },

          {
            type: "pie",
            radius: ["40%", "70%"],
            center: ["50%", "50%"],
            label: {
              normal: {
                position: "center"
              }
            }
          },
          {
            type: "pie",
            radius: ["40%", "70%"],
            center: ["70%", "50%"],
            label: {
              normal: {
                position: "center"
              }
            }
          },
          {
            type: "pie",
            radius: ["40%", "70%"],
            center: ["90%", "50%"],
            label: {
              normal: {
                position: "center"
              }
            }
          }
        ],
        animationDuration: 2800,
        animationEasing: "cubicInOut"
      });
    },
    initChart () {
      this.chart = echarts.init(this.$refs.structPie);
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
