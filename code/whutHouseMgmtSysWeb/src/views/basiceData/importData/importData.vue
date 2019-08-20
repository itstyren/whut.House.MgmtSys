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
            <el-breadcrumb-item>数据导入导出</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <el-row :gutter="20">
              <el-col :span="14">
                <upload-excel-component @on-selected-file='selected'></upload-excel-component>
              </el-col>
              <el-col :span="10">
                <el-row>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="staffDownload">职工模板下载</el-button>
                  </el-col>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="handleSalaryExport">工资模板下载</el-button>
                  </el-col>

                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="houseRelDownload">住户模板下载</el-button>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="regionDownload">区域模板下载</el-button>
                  </el-col>

                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="buildingDownload">楼栋模板下载</el-button>
                  </el-col>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="primary"
                               size="small"
                               @click="houseDownload">房屋模板下载</el-button>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="success"
                               size="small"
                               @click="handleStaffExport">职工数据导出</el-button>
                  </el-col>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="success"
                               size="small"
                               @click="handleHouseExport">住房数据导出</el-button>
                  </el-col>
                  <el-col :span="4"
                          class="btn-m">
                    <el-button type="success"
                               size="small"
                               @click="handleHouseUseExport">住房使用情况导出</el-button>
                  </el-col>

                </el-row>
                <div class="save-button">
                  <el-radio v-model="uploadType"
                            label="1">职工</el-radio>
                  <el-radio v-model="uploadType"
                            style="margin-right:10px"
                            label="区域">区域</el-radio>
                  <el-radio v-model="uploadType"
                            style="margin-right:10px"
                            label="楼栋">楼栋</el-radio>
                  <el-radio v-model="uploadType"
                            style="margin-right:10px"
                            label="2">住房</el-radio>
                  <el-radio v-model="uploadType"
                            style="margin-right:10px"
                            label="3">住户关系</el-radio>
                  <el-radio v-model="uploadType"
                            style="margin-right:10px"
                            label="工资">工资</el-radio>
                  <el-button type="success"
                             size="small"
                             :disabled="isFull"
                             @click="unpload">确认并导入</el-button>
                </div>
              </el-col>
            </el-row>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card import-data">
              <el-table v-loading="uploadLoading"
                        :data="tableData"
                        class="table"
                        border
                        height="string"
                        highlight-current-row>
                <el-table-column v-for='item of tableHeader'
                                 width="120"
                                 align="center"
                                 :prop="item"
                                 :label="item"
                                 :key='item'>
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
  getStaff,
  getHouse,
  postStaffImport,
  postHouseImport,
  postHouseRelImport,
  postRegionImport,
  postBuildingImport,
  postSalaryImport,
  getStaffListByMultiCondition
} from "@/api/basiceData";
import utils from "@/utils/index.js";
import {
  postHouseStaffRecord
} from "@/api/dataAnalysis.js";

export default {
  name: "uploadExcel",
  components: {
    UploadExcelComponent
  },
  data () {
    return {
      tableData: [],
      tableHeader: [],
      itemFile: {},
      fileName: '',
      uploadLoading: false,
      uploadType: "1",
      isFull: true,
      houseUseData: [],
      staffData: [],
      houseData: [],
      basiceUrl: this.BASE_URL
    };
  },
  methods: {
    selected (data, itemFile) {
      console.log(itemFile)
      this.fileName = itemFile.name
      // console.log(data.results[0].备注)
      this.tableData = data.results;
      this.itemFile = itemFile;
      //console.log(this.itemFile);
      this.tableHeader = data.header;
      this.isFull = false;
    },
    staffDownload () {
      window.location.href = `${this.basiceUrl}/dataImport/staffDownLoad`;
    },
    regionDownload () {
      window.location.href = `${this.basiceUrl}/dataImport/regionDownLoad`;

    },
    buildingDownload () {
      window.location.href = `${this.basiceUrl}/dataImport/buildingDownLoad`;

    },
    houseDownload () {
      window.location.href = `${this.basiceUrl}/dataImport/houseDownLoad`;
    },
    houseRelDownload () {
      window.location.href = `${this.basiceUrl}/dataImport/residentDownLoad`;
    },
    handleSalaryExport () {
      window.location.href = `${this.basiceUrl}/dataImport/salaryDownLoad`;
    },
    unpload () {
      this.uploadLoading = true;
      var formData = new FormData();
      if (this.uploadType == "1") {
        formData.append("staffFile", this.itemFile, this.fileName);
        postStaffImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      }
      else if (this.uploadType == "2") {
        formData.append("houseFile", this.itemFile, this.fileName);
        postHouseImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      }
      else if (this.uploadType == "3") {
        formData.append("residentFile", this.itemFile, this.fileName);
        postHouseRelImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
          //console.log(res)
        });
      }
      else if (this.uploadType == "区域") {
        formData.append("regionFile", this.itemFile, this.fileName);
        postRegionImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
        });
      }
      else if (this.uploadType == "楼栋") {
        formData.append("buildingFile", this.itemFile, this.fileName);
        postBuildingImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
        });
      }
      else if (this.uploadType == "工资") {
        formData.append("salaryFile", this.itemFile, this.fileName);
        postSalaryImport(formData).then(res => {
          utils.statusinfo(this, res.data);
          this.uploadLoading = false;
        });
      }
    },
    //获取住房使用情况数据
    getHouseUseData () {
      if (!this.houseUseData.length) {
        let roleId = this.$store.getters.roleId
        let params = {
          page: 1,
          size: 9999
        };
        return new Promise((resolve, reject) => {
          postHouseStaffRecord(params, {}, roleId).then(res => {
            this.houseUseData = res.data.data.data.list;
            resolve(this.houseUseData)
          }).catch(err => reject(err))
        })
      }
      return Promise.resolve(this.houseUseData)
    },

    //获取职工数据
    getStaffData () {
      if (!this.staffData.length) {
        let params = {
          page: 1,
          size: 9999
        };
        return new Promise((resolve, reject) => {
          //请求全部员工
          getStaffListByMultiCondition(params, {}).then(res => {
            this.staffData = res.data.data.data.list;
            for (let i = 0, len = this.staffData.length; i < len; i++) {
              let familyCode = this.staffData[i].familyCode
              if (Boolean(familyCode) > 0) {
                getStaff({}, familyCode).then(res => {
                  let spouse = res.data.data.data
                  this.staffData[i].spouseCode = spouse.code
                  this.staffData[i].spouseDept = spouse.deptName
                  this.staffData[i].spouseName = `${spouse.no}-${spouse.name}`
                  this.staffData[i].spousePostName = spouse.postName
                  this.staffData[i].spouseTitleName = spouse.titleName
                })
              }
            }
            resolve(this.staffData)
          }).catch(err => reject(err))
        })
      }
      return Promise.resolve(this.staffData)
    },

    //获取住房使用情况数据
    getHouseData () {
      if (!this.houseData.length) {
        return new Promise((resolve, reject) => {
          getHouse().then(res => {
            this.houseData = res.data.data.data.list;
            resolve(this.houseData)
          }).catch(err => reject(err))
        })
      }
      return Promise.resolve(this.houseData)
    },

    // 导出住房使用情况
    handleHouseUseExport () {
      this.getHouseUseData().then(data => {
        let filename = "住房使用情况"
        let tHeader = ["住房号", "所属校区", "地址", "住房户型", "住房类型", "使用状态", "使用面积", "现住户", "所在部门", "入住时间"]
        let filterVal = ["no", "campusName", "address", "layoutName", "typeName", "statusName", "buildArea", "staffName", "staffDeptName", "bookTime"]
        let excelData = this.formatJson(filterVal, data)
        import("@/vendor/Export2Excel").then(excel => {
          excel.export_json_to_excel(tHeader, excelData, filename);
        });
      })
    },
    // 二维数组
    formatJson (filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => v[j])
      )
    },
    // 导出职工数据
    handleStaffExport () {
      this.getStaffData().then(data => {
        let filename = "职工数据"
        let tHeader = ["职工编号", "姓名", "性别", "婚姻状况", "身份证号", "联系电话", "所属用户组", "职称", "职务", "职工类别", "工作状态", "工作部门", "学历", "参加工作时间", "来校工作时间", "离退休时间", "货币化补偿金", "购买校内房", "购房款", "配偶单位性质", "配偶姓名", "配偶身份证号", "配偶职称", "配偶职务", "配偶工作部门"]
        let filterVal = ["no", "name", "sex", "marriageState", "code", "tel", "groupName", "titleName", "postName", "typeName", "statusName", "deptName", "eduQualifications", "joinTime", "firstJobTime", "retireTime", "compensate", "isOwnPriHouse", "buyAccount", 'spouseKindName', "spouseName", "spouseCode", "spouseTitleName", "spousePostName", "spouseDept"]
        let excelData = this.formatJson(filterVal, data)
        import("@/vendor/Export2Excel").then(excel => {
          excel.export_json_to_excel(tHeader, excelData, filename);
        });
      })

    },
    // 导出住房数据

    handleHouseExport () {
      this.getHouseData().then(data => {
        let filename = "住房数据"
        const tHeader = ["住房编号", "校区", "住房类型", "住房户型", "住房结构", "建筑面积", "使用面积", "占地面积", "地址", "所属区域", "所属楼栋", "产权证号", "月租租金", "竣工时间", "备注"]
        const filterVal = ["no", "campusName", "typeName", "layoutName", "structName", "buildArea", "usedArea", "basementArea", "address", "regionName", "buildingName", "proId", "rental", "finishTime", "remark"]
        let excelData = this.formatJson(filterVal, data)
        import("@/vendor/Export2Excel").then(excel => {
          excel.export_json_to_excel(tHeader, excelData, filename);
        });
      })
    },
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
  .save-button {
    // position: absolute;
    bottom: 0;
  }
}
.download-button {
  display: flex;
  justify-content: space-between;
}
.btn-m {
  margin: 8px;
}
</style>
