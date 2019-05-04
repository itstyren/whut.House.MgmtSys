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
            <div class="download-button">
              <el-button type="primary" size="small" @click="staffDownload">职工模板下载</el-button>
              <el-button type="primary" size="small" @click="houseDownload">房屋模板下载</el-button>
              <el-button type="primary" size="small" @click="houseRelDownload">住户模板下载</el-button>
            </div>
            <div class="save-buttomn">
              <el-radio v-model="uploadType" label="1">职工</el-radio>
              <el-radio v-model="uploadType" style="margin-right:10px" label="2">住房</el-radio>
              <el-radio v-model="uploadType" style="margin-right:10px" label="3">住户关系</el-radio>
              <el-button type="success" size="small" :disabled="isFull" @click="unpload">确认并导入</el-button>
            </div>
            <upload-excel-component @on-selected-file='selected'></upload-excel-component>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card import-data">
              <el-table v-loading="uploadLoading" :data="tableData" class="table" border height="string" highlight-current-row>
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
import {
  postStaffImport,
  postHouseImport,
  postHouseRelImport
} from "@/api/basiceData";
import utils from "@/utils/index.js";
var basiceUrl = "http://172.16.65.105:8080/whutHouseMgmtReposity/dataImport/";
// var basiceUrl='http://118.126.117.96:8080/whutHouseMgmtReposity/dataImport/'
  // var baseURL= 'http://120.78.226.24:8080/whutHouseMgmtRepositydataImport/'
// var   baseURL= 'https://www.terryren.com/whutHouseMgmtReposity'// api的base_url

export default {
  name: "uploadExcel",
  components: {
    UploadExcelComponent
  },
  data() {
    return {
      tableData: [],
      tableHeader: [],
      itemFile: {},
      fileName:'',
      uploadLoading: false,
      uploadType: "1",
      isFull: true
    };
  },
  methods: {
    selected(data, itemFile) {
      console.log(itemFile)
      this.fileName=itemFile.name
      // console.log(data.results[0].备注)
      this.tableData = data.results;
      this.itemFile = itemFile;
      //console.log(this.itemFile);
      this.tableHeader = data.header;
      this.isFull = false;
    },
    staffDownload() {
      window.location.href = `${basiceUrl}staffDownLoad`;
    },
    houseDownload() {
      window.location.href = `${basiceUrl}houseDownLoad`;
    },
    houseRelDownload() {
      window.location.href = `${basiceUrl}residentDownLoad`;
    },
    unpload() {
      this.uploadLoading = true;
      var formData = new FormData();
      if (this.uploadType == "1") {
        formData.append("staffFile", this.itemFile, this.fileName);
        postStaffImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      } else if (this.uploadType == "2") {
        formData.append("houseFile", this.itemFile, this.fileName);
        postHouseImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      } else {
        formData.append("residentFile", this.itemFile, this.fileName);
        postHouseRelImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      }
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";

.second-container {
  // background-color: $background-grey;
  .import-data {
    margin-top: 20px;
    height: 60vh;
  }

  .download-button {
    position: absolute;
    top: 50px;
    right: 30px;
  }

  .save-buttomn {
    position: absolute;
    top: 150px;
    right: 30px;
  }
}
</style>
