<template>
  <div class="dashboard-admin">
    <el-row :gutter="14">
      <el-col :span="6"
              class="col-height">
        <el-row class="row-height-23">
          <info-card></info-card>
        </el-row>
        <el-row class="row-height-44">
          <todo-list></todo-list>
        </el-row>
        <el-row class="row-height-33">
          <flowmeter height="100%"></flowmeter>
        </el-row>
      </el-col>
      <el-col :span="18"
              class="col-height">
        <!-- 每日业务 -->
        <pannel-group class="row-height-10"></pannel-group>
        <!-- 快速通道 -->
        <el-row class="row-height-27">
          <channel class="pag-view"></channel>
        </el-row>

        <el-row class="row-height-28">
          <!-- 周维修类型统计 -->
          <el-col :span="11">
            <fix-pie :height="'35.84vh'"></fix-pie>
          </el-col>
          <!-- 近7天访问量 -->
          <el-col :span="12"
                  style="float:right;">
            <page-view :height="'35.84vh'"></page-view>
          </el-col>
        </el-row>
        <!-- 周维修处理情况分析 -->
        <el-row>
          <el-col class="fix-bar">
            <fix-bar :height="'42.24vh'"></fix-bar>
          </el-col>
        </el-row>
      </el-col>
    </el-row>

  </div>
</template>

<script type="text/ecmascript-6">
import infoCard from "../components/infoCard";
import pannelGroup from "../components/pannelGroup";
import todoList from "./components/todoList";
import pageView from "./components/pageView";
import fixPie from "./components/fixPie";
import fixBar from "./components/fixBar";
import flowmeter from "./components/flowmeter";
import channel from './components/channel'
export default {
  data () {
    return {};
  },
  components: {
    infoCard,
    pannelGroup,
    todoList,
    pageView,
    fixPie,
    fixBar,
    flowmeter,
    channel
  }
};
</script>

<style scoped lang="scss">
.card {
  margin: 0 !important;
}
.dashboard-admin {
  .el-row {
    margin-bottom: 17px;
  }
}
.col-height {
  height: 128vh;
}
// .row-margin-10 {
//   margin-bottom: 20px;
// }
.row-height-10 {
  height: 10%;
}
.row-height-23 {
  height: 23%;
}
.row-height-27 {
  height: 27%;
}
.row-height-28 {
  height: 28%;
}
.row-height-33 {
  height: 33%;
}
.row-height-44 {
  height: 44%;
}
</style>
