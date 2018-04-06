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
import { getFixNameByDay, getFixContentByDay } from "@/api/dataAnalysis.js";
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
    getData() {
    },
    setOptions({ expectedData, actualData } = {}) {
      this.chart.setOption({
  title: {
        //text: '2000-2016年中国汽车销量及增长率'
    },
    tooltip: {
        trigger: 'axis'
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
        containLabel: true
    },
    legend: {
        data: ['入住率','入住量']
    },
    xAxis: [{
        type: 'category',
        axisTick: {
            alignWithLabel: true
        },
        data: ['2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015','2016']
    }],
    yAxis: [{
        type: 'value',
        name: '入住率',
        min: 0,
        max: 50,
        position: 'right',
        axisLabel: {
            formatter: '{value} %'
        }
    }, {
        type: 'value',
        name: '入住量',
        min: 0,
        max: 3000,
        position: 'left'
    }],
    series: [{
        name: '入住率',
        type: 'line',
        stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top',
                }
            },
        lineStyle: {
                normal: {
                    width: 3,
                    shadowColor: 'rgba(0,0,0,0.4)',
                    shadowBlur: 10,
                    shadowOffsetY: 10
                }
            },
        data: [1,13,37,35,15,13,25,21,6,45,32,2,4,13,6,4,11]
    }, {
        name: '入住量',
        type: 'bar',
        yAxisIndex: 1,
        stack: '总量',
            label: {
                normal: {
                    show: true,
                    position: 'top'
                }
            },
        data: [209,236,325,439,507,576,722,879,938,1364,1806,1851,1931,2198,2349,2460,2735]
    }],
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
