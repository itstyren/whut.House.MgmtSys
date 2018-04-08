<template>
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>统计分析</el-breadcrumb-item>
            <el-breadcrumb-item>维修分析</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
              <fix-form-filter  @query-fix="queryHandle"></fix-form-filter>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
          </div>
        </div>
      </div>
    </section>
</template>

<script type="text/ecmascript-6">
import fixFormFilter from "@/views/tools/fixFormFilter";
export default {
  data() {
    return {
      filtersData: []
    };
  },
  components: {
    fixFormFilter
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
