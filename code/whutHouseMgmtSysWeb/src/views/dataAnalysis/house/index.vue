<template>
  <div class="second-container">
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>统计分析</el-breadcrumb-item>
            <el-breadcrumb-item>住房分析</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <house-filter></house-filter>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-row style="margin:0 10px 0 -10px;" :gutter="20" >
              <el-col :span="10">
                <el-row>
                  <num-list></num-list>                  
                </el-row>
                <el-row>
                   <struct-pie></struct-pie>
                </el-row>
                <el-row>
                    <status-pie></status-pie>
                </el-row>
              </el-col>
              <el-col :span="14">
                <el-row>
                  <region-bar :height="'718px'"></region-bar>
                </el-row>
                <el-row>
                    <status-pie></status-pie>                  
                </el-row>
              </el-col>
            </el-row>
            <el-row style="margin:0 10px 0 -10px;" :gutter="20" >
              <el-col :span="24">
                <occupancy-rate></occupancy-rate>
              </el-col>
            </el-row>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import houseFilter from "@/views/tools/houseFilter";
  import wuhanmMap from './components/map'
  import statusPie from './components/statusPie'
  import regionBar from './components/regionBar.vue'
  import structPie from './components/structPie.vue'
  import occupancyRate from './components/occupancyRate.vue'
  import numList from './components/numList.vue'
  export default {
    data() {
      return {};
    },
    components: {
      houseFilter,
      wuhanmMap,
      statusPie,
      regionBar,
      structPie,
      occupancyRate,
      numList
    }
  };

</script>

<style scoped lang="scss">
  @import "../../../styles/variables.scss";

  .second-container {
    background-color: $background-grey;
  }

</style>
