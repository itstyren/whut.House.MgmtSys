<template>
<div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>周维修处理情况分析</strong>
    </div>
  <div class="chart" ref="map"></div>
  </div>
</template>

<script>
import echarts from "echarts";
require("echarts/theme/macarons"); // echarts theme
let _ = require("underscore");
let wuhanMap=require('../../../../assets/WuHan.json')
echarts.registerMap('武汉', wuhanMap)
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
        tooltip: {
            trigger: 'item',
            formatter: '{b}<br/>{c} (p / km2)'
        },
        toolbox: {
            show: true,
            orient: 'vertical',
        },
        series: [
            {
                name: '住房分布图',
                type: 'map',
                mapType: '武汉', // 自定义扩展图表类型
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
            }
        ]
      });
    },
    initChart() {
      this.chart = echarts.init(this.$refs.map, "macarons");
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
