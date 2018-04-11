<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修评价词云分析</strong>
    </div>
    <div class="chart" ref="pageView"></div>
  </div>
</template>

<script>
import echarts from "echarts";
require('echarts-wordcloud');
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
       tooltip: {},
    series: [{
        type: 'wordCloud',
        gridSize: 20,
        sizeRange: [12, 50],
        rotationRange: [0, 0],
        shape: 'circle',
        textStyle: {
            normal: {
                color: function() {
                    return 'rgb(' + [
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160),
                        Math.round(Math.random() * 160)
                    ].join(',') + ')';
                }
            },
            emphasis: {
                shadowBlur: 10,
                shadowColor: '#333'
            }
        },
        data: [{
            name: '反馈很快',
            value: 10000,
            textStyle: {
                normal: {
                    color: 'black'
                },
                emphasis: {
                    color: 'red'
                }
            }
        }, {
            name: '态度很好',
            value: 6181
        }, {
            name: '提前预约',
            value: 4386
        }, {
            name: '及时沟通',
            value: 4055
        }, {
            name: '技术不好',
            value: 2467
        }, {
            name: '效果不佳',
            value: 2244
        }, {
            name: '和预期相同',
            value: 1898
        }, {
            name: '返工',
            value: 1484
        }, {
            name: '很满意',
            value: 1112
        }, {
            name: '来的很及时',
            value: 965
        }, {
            name: '操作规范',
            value: 847
        }, {
            name: '安排及时',
            value: 582
        }, {
            name: '投诉无用',
            value: 555
        }, {
            name: '业务水平高',
            value: 550
        }, {
            name: '完成的不错',
            value: 462
        }, {
            name: '我觉得还行',
            value: 366
        }, {
            name: '还行',
            value: 360
        }, {
            name: 'Serena Williams',
            value: 282
        }, {
            name: 'NCAA baseball tournament',
            value: 273
        }, {
            name: 'Point Break',
            value: 265
        }]
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
