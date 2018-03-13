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
            <el-breadcrumb-item>基础数据</el-breadcrumb-item>
            <el-breadcrumb-item>数据导入</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <upload-excel-component @on-selected-file='selected'></upload-excel-component>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card import-data">
            <el-table :data="tableData" class="table" border height="string" highlight-current-row>
              <el-table-column v-for='item of tableHeader' width="120" align="center" :prop="item" :label="item" :key='item'>
              </el-table-column>
            </el-table>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
  import UploadExcelComponent from "@/components/UploadExcel/index.vue";

  export default {
    name: "uploadExcel",
    components: {
      UploadExcelComponent
    },
    data() {
      return {
        tableData: [],
        tableHeader: []
      };
    },
    methods: {
      selected(data) {
        this.tableData = data.results;
        console.log(this.tableData)
        this.tableHeader = data.header;
      }
    }
  };

</script>

<style scoped lang="scss">
.import-data{
  margin-top: 20px;
   height: 60vh;
}
</style>
