<template>
  <div class="dashboard-admin">
    <el-row :gutter="14">
      <!-- 首页左侧 -->
      <el-col :span="6"
              class="col-height">
        <!-- 个人信息 -->
        <el-row class="row-height-23">
          <info-card></info-card>
        </el-row>
        <!-- 工作清单 -->
        <el-row class="row-height-42">
          <todo-list></todo-list>
        </el-row>
        <!-- 服务器负载量 -->
        <!-- <el-row class="row-height-33">
          <flowmeter height="100%"></flowmeter>
        </el-row> -->
      </el-col>
      <!-- 首页右侧 -->
      <el-col :span="18"
              class="col-height">
        <!-- 每日业务 -->
        <pannel-group class="row-height-10"></pannel-group>
        <!-- 快速通道 -->
        <el-row class="row-height-27">
          <channel class="pag-view"></channel>
        </el-row>

        <el-row class="row-height-28">
          <!-- 近7天访问量 -->
          <el-col :span="15">
            <page-view :height="'33.5vh'"></page-view>
          </el-col>
          <!-- 入住率分析 -->
          <el-col :span="8"
                  style="float:right;">
            <occupancy-rate :height="'33.5vh'"></occupancy-rate>

          </el-col>
          <!-- 周维修类型统计 -->
          <!-- <el-col :span="11">
            <fix-pie :height="'33.5vh'"></fix-pie>
          </el-col> -->

        </el-row>
        <!-- 周维修处理情况分析 -->
        <!-- <el-row>
          <el-col class="fix-bar">
            <fix-bar :height="'42.24vh'"></fix-bar>
          </el-col>
        </el-row> -->
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
import occupancyRate from "@/views/dataAnalysis/house/components/occupancyRate1.vue";

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
    channel,
    occupancyRate
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
.row-height-42 {
  height: 42%;
}
</style>
