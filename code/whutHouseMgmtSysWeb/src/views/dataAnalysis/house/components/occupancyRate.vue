<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>入住率分析</strong>
    </div>
    <div class="chart" ref="structPie"></div>
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
        tooltip: {},
        series: [
          {
            name: "南湖校区",
            type: "pie",
            radius: ["40%", "70%"],
            center: ["50%", "50%"],
            color: "#00EE76",
            label: {
              normal: {
                position: "center"
              }
            },
            data: [
              {
                value: 69,
                name: "申请注销数",
                label: {
                  normal: {
                    formatter: "{d} %",
                    textStyle: {
                      fontSize: 18
                    }
                  }
                },
              },
              {
                value: 133,
                name: "其他类型数",
                label: {
                  normal: {
                    formatter: "\n南湖校区",
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
          },
          {
            name: "东院校区",
            type: "pie",
            radius: ["40%", "70%"],
            center: ["10%", "50%"],
            color: "#FF4500",
            label: {
              normal: {
                position: "center"
              }
            },
            data: [
              {
                value: 38,
                name: "吊销注销数",
                label: {
                  normal: {
                    formatter: "{d} %",
                    textStyle: {
                      fontSize: 18
                    }
                  }
                },
                tooltip: {
                  trigger: "item",
                  formatter:
                    "{a} <br/>计算公式:占比率=({b}/注销总数)*100%<br/> 吊销注销数 : {c}"
                }
              },
              {
                value: 164,
                name: "其他类型数",
                label: {
                  normal: {
                    formatter: "\n东院校区",
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
          },
          {
            name: "到期注销",
            type: "pie",
            radius: ["40%", "70%"],
            center: ["30%", "50%"],
            color: "#473C8B",
            label: {
              normal: {
                position: "center"
              }
            },
            data: [
              {
                value: 95,
                name: "到期注销数",
                label: {
                  normal: {
                    formatter: "{d} %",
                    textStyle: {
                      fontSize: 18
                    }
                  }
                },
                tooltip: {
                  trigger: "item",
                  formatter:
                    "{a} <br/>计算公式:占比率=({b}/注销总数)*100%<br/> 到期注销数 : {c}"
                }
              },
              {
                value: 107,
                name: "其他类型数",
                label: {
                  normal: {
                    formatter: "\n余家头校区",
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
          },
                    {
            name: "南湖校区",
            type: "pie",
            radius: ["40%", "70%"],
            center: ["70%", "50%"],
            color: "#00EE76",
            label: {
              normal: {
                position: "center"
              }
            },
            data: [
              {
                value: 69,
                name: "申请注销数",

                label: {
                  normal: {
                    formatter: "{d} %",
                    textStyle: {
                      fontSize: 18
                    }
                  }
                },
                tooltip: {
                  trigger: "item",
                  formatter:
                    "{a} <br/>计算公式:占比率=({b}/注销总数)*100%<br/> 申请注销数 : {c}"
                }
              },
              {
                value: 133,
                name: "其他类型数",
                label: {
                  normal: {
                    formatter: "\n南湖校区",
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
          },
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
