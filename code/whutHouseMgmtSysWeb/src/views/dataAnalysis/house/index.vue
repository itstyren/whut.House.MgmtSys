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
            <house-filter @query-house="queryHandle"></house-filter>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-row style="margin:0 10px 0 -10px;" :gutter="20" >
              <el-col :span="10">
                <el-row>
                  <num-list></num-list>                  
                </el-row>
                <el-row>
                   <struct-pie :filters-data="filtersData"></struct-pie>
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
                   <house-bar></house-bar>               
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
  import houseBar from './components/houseBar'
  import regionBar from './components/regionBar.vue'
  import structPie from './components/structPie.vue'
  import occupancyRate from './components/occupancyRate.vue'
  import numList from './components/numList.vue'
  import statusPie from './components/statusPie.vue'
  export default {
    data() {
      return {
        filtersData:{}
      };
    },
    components: {
      houseFilter,
      wuhanmMap,
      houseBar,
      regionBar,
      structPie,
      occupancyRate,
      numList,statusPie,
    },
    methods: {
            // 多重查找查询
      queryHandle(data) {
this.filtersData=data
      },
    }
  }

</script>

<style scoped lang="scss">
  @import "../../../styles/variables.scss";

  .second-container {
    background-color: $background-grey;
  }

</style>
