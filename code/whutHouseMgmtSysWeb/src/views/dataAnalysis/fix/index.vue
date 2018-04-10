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
            <el-row style="margin:0 10px 0 -10px;" :gutter="20">
              <el-col :span="14">
                <fix-type-line :filters-data="filtersData" :height="'370px'"></fix-type-line>
              </el-col>
              <el-col :span="10" >
                <fix-type-bar :filters-data="filtersData" :height="'370px'"></fix-type-bar>
              </el-col>
            </el-row>
            <el-row style="margin:0 10px 0 -10px;" :gutter="20">
              <el-col :span="8">
                <word-cloud :filters-data="filtersData"></word-cloud>
              </el-col>
              <el-col :span="8">
                <comment-radar :filters-data="filtersData"></comment-radar>
              </el-col>
                  <el-col :span="8">
                <num-list :filters-data="filtersData"></num-list>
              </el-col>
            </el-row>    
            <el-row style="margin:0 10px 0 -10px;" :gutter="20">
              <el-col :span="24">
                <fix-comment-table :filters-data="filtersData"></fix-comment-table>
              </el-col>
            </el-row>                    
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import fixFormFilter from "@/views/tools/fixFormFilter";
import fixTypeLine from './components/fixTypeLine'
import fixTypeBar from './components/fixTypeBar'
import numList from './components/numList'
import wordCloud from './components/wordcloud'
import commentRadar from './components/commentRadar'
import fixCommentTable from './components/fixCommentTable'
export default {
  data() {
    return {
      filtersData: {}
    };
  },
  components: {
    fixFormFilter,fixTypeLine,numList,wordCloud,commentRadar,fixTypeBar,fixCommentTable
  },
  methods: {
    // 多重查找查询
    queryHandle(data) {
      this.filtersData = data;
      console.log(this.filtersData)
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
