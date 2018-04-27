<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>住房户型及使用率分析</strong>
    </div>
    <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
import { postHouseRecordLayout } from "@/api/dataAnalysis.js";
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
    chartData: {
      deep: true,
      handler(val) {
        this.setOptions(val);
      }
    }
  },
  methods: {
    getData() {
      if (arguments[0] !== undefined) var data = arguments[0];
      else var data = {};
      this.chart.showLoading();
      postHouseRecordLayout(data).then(res => {
        this.chart.setOption({
          xAxis: [
            {
              data: res.data.data.name
            }
          ],
          series:[{
              data:res.data.data.proportion
          },{
              data:res.data.data.number
          }]
        });
        this.chart.hideLoading();
      });
    },
    setOptions({ expectedData, actualData } = {}) {
      this.chart.setOption({
        title: {
          //text: '2000-2016年中国汽车销量及增长率'
        },
        tooltip: {
          trigger: "axis",
          formatter: '入住率: {c0}%<br />{b1}: {c1}间'
        },
        toolbox: {
          feature: {
            dataView: {
              show: true,
              readOnly: false
            },
            restore: {
              show: true
            },
            saveAsImage: {
              show: true
            }
          }
        },
        grid: {
          containLabel: true,
          bottom:'8%',
          left:'5%',
          right:'5%'
        },
        legend: {
          data: ["入住率", "入住量"]
        },
        xAxis: [
          {
            type: "category",
            axisTick: {
              alignWithLabel: true
            },
            axisLabel:{
                interval:0,
                rotate:0,
            }
          }
        ],
        yAxis: [
          {
            type: "value",
            name: "入住率",
            position: "right",
            axisLabel: {
              formatter: "{value} %"
            }
          },
          {
            type: "value",
            name: "入住量",
            position: "left"
          }
        ],
        series: [
          {
            name: "入住率",
            type: "line",
            stack: "总量",
            label: {
              normal: {
                //show: true,
                position: "top"
              }
            },
            lineStyle: {
              normal: {
                width: 3,
                shadowColor: "rgba(0,0,0,0.4)",
                shadowBlur: 10,
                shadowOffsetY: 10
              }
            },
          },
          {
            name: "入住量",
            type: "bar",
            yAxisIndex: 1,
            stack: "总量",
            label: {
              normal: {
                show: true,
                position: "top"
              }
            },
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
