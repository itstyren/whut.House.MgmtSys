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
            <el-row style="margin:0 10px 0 -10px;" :gutter="20">
              <el-col :span="8">
                <el-row>
                  <num-list :filters-data="filtersData"></num-list>
                </el-row>
                <el-row>
                  <struct-pie :filters-data="filtersData"></struct-pie>
                </el-row>
              </el-col>
              <el-col :span="16">
                <el-row>
                  <layout-bar :filters-data="filtersData"></layout-bar>
                </el-row>
                <el-row :gutter="20">
                  <el-col :span="12">
                    <status-pie :filters-data="filtersData"></status-pie>
                  </el-col>
                  <el-col :span="12">
                <occupancy-rate :filters-data="filtersData"></occupancy-rate>                    
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
            <el-row style="margin:0 10px 0 -10px;" :gutter="20">
              <el-col :span="24">
<house-record-table :filters-data="filtersData"></house-record-table>
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
import wuhanmMap from "./components/map";
import layoutBar from "./components/layoutBar";
import structPie from "./components/structPie.vue";
import occupancyRate from "./components/occupancyRate1.vue";
import numList from "./components/numList.vue";
import statusPie from "./components/statusPie.vue";
import houseRecordTable from "./components/houseRecordTable.vue";
export default {
  data() {
    return {
      filtersData: {}
    };
  },
  components: {
    houseFilter,
    wuhanmMap,
    layoutBar,
    houseRecordTable,
    structPie,
    occupancyRate,
    numList,
    statusPie
  },
  methods: {
    // 多重查找查询
    queryHandle(data) {
      this.filtersData = data;
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
}
</style>
