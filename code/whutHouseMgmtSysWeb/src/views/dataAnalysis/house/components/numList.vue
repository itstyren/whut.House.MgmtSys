<template>
  <div class="card numList" :style="{height:height,width:width}">
    <div class="title">
      <strong>数据分析</strong>
    </div>
    <div class="content">
      <el-row>
        <el-col :span="1">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="8">
          <span>总建筑面积</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="23213" :duration="3200"></count-to>
          </span>
          <span>平方米</span>
        </el-col>
        <el-col :span="1" :offset="2">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="10">
          <span>总使用面积</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="21234.4" :duration="3200"></count-to>
          </span>
          <span>平方米</span>
        </el-col>
      </el-row>
      <!-- ***** -->
      <el-row style="margin-top:20px">
        <el-col :span="1">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="8">
          <span> 空闲套数</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="200" :duration="3200"></count-to>
          </span>
          <span>套</span>
        </el-col>
        <el-col :span="1" :offset="2">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="10">
          <span> 入住套数</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="5436" :duration="3200"></count-to>
          </span>
          <span>套</span>
        </el-col>
      </el-row>
      <!-- **** -->
      <el-row style="margin-top:20px">
        <el-col :span="1">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="8">
          <span> 空闲面积</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="27254" :duration="3200"></count-to>
          </span>
          <span>平方米 </span>
        </el-col>
        <el-col :span="1" :offset="2">
          <my-icon icon-class="dian"></my-icon>
        </el-col>
        <el-col :span="10">
          <span> 入住面积</span>
          <span>
            <count-to class="card-panel-num" :startVal="0" :endVal="431706" :duration="3200"></count-to>
          </span>
          <span>平方米 </span>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import countTo from "vue-count-to";

  export default {
    data() {
      return {};
    },
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
    components: {
      countTo
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

  .content {
    margin-top: 15px;
    padding: 20px;
    span {
      font-size: 16px;
      font-weight: 600;
      .card-panel-num {
        color: red;
      }
    }
  }

  .chart {
    margin-top: 30px;
    height: calc(100% - 55px);
  }

</style>
