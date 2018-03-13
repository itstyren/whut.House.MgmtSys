<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>住房登记</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
      </div>
      <!-- 信息区 -->
      <div class="main-data">
        <!-- 个人信息区 -->
        <el-row class="before-info" >
          <el-col :span="11" class="personal-info card">
            <personal-info-table></personal-info-table>
          </el-col>
          <el-col :span="12" class="house-rel card">
            <staff-house-rel></staff-house-rel>
          </el-col>
        </el-row>
        <!-- 住房登记区 -->
        <el-row class="house-resident card">
          <el-col :span="24">
            <house-resident :select-house="selectHouseName" :select-house-id="selectHouseId" @dialog-visible="actionDialog"></house-resident>
          </el-col>
        </el-row>
        <!-- 房屋查询区 -->
        <el-row  class="conditionalQuery card">
          <el-col :span="24" style="height:75%" >
                <el-row>
              <el-form :model="simpleQueryForm" :inline="true">
                  <el-col :span="4" :offset="1">
                    <el-form-item label="住房类型">
                      <el-select v-model="simpleQueryForm.houseType" size="small" style="width:120px" :clearable="true" placeholder="全部结构">
                        <el-option v-for="struct in houseStruct" :key="struct.houseParamId" :value="struct.houseParamName" :label="struct.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="使用状况">
                      <el-select v-model="simpleQueryForm.useStatus" size="small" style="width:120px" :clearable="true" placeholder="全部状态">
                        <el-option v-for="status in statusData" :key="status.houseParamId" :value="status.houseParamName" :label="status.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="6">
                    <el-form-item label="住房区域">
                      <el-select v-model="simpleQueryForm.houseZone" size="small" style="width:220px" :clearable="true" placeholder="全部区域">
                        <el-option v-for="region in regionDataWithBuilding" :key="region.id" :value="region.name" :label="region.name"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="5">
                    <el-form-item label="楼栋">
                      <el-select v-model="simpleQueryForm.building" size="small" style="width:170px" :clearable="true" placeholder="全部房屋">
                        <el-option v-for="building in buildingData" :key="building.id" :value="building.name" :label="building.name"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-button type="primary" @click="simpleQuery " size="small">筛选</el-button>
                    <el-button type="primary" @click="simpleQuery " size="small">详细查找</el-button>
                  </el-col>   
              </el-form>
               </el-row>
            <!-- 查询相应区 -->
              <div class="query-table">
              <el-table :data="houseData" class="table" height="string" v-loading="listLoading" @cell-click="cellClick">
                <el-table-column prop="houseNo" label="住房号" sortable width="90" align="center"></el-table-column>
                <el-table-column prop="houseSort" label="住房类型" sortable width="140" align="center"></el-table-column>
                <el-table-column prop="houseType" label="户型" sortable width="120" align="center"></el-table-column>
                <el-table-column prop="useStatus" label="状态" sortable width="90" align="center"></el-table-column>
                <el-table-column prop="address" label="地址" align="center"></el-table-column>
                <el-table-column prop="zoneName" label="所属区域" align="center"></el-table-column>
                <el-table-column prop="buildingName" label="所属楼栋" align="center"></el-table-column>
              </el-table>
              </div>
          </el-col>
        </el-row>
      </div>
    </div>
    <!-- 详细查找表单 -->
    <seach-house :select-form-visible="dialogVisible" @select-house="selectHouse"></seach-house>
  </div>
</template>

<script type="text/ecmascript-6">
  import personalInfoTable from "./components/personalInfoTable";
  import staffHouseRel from "./components/staffHouseRel";
  import houseResident from "./components/houseResident";
  import seachHouse from "@/views/tools/seachHouse";
  import utils from "@/utils/index.js";
  import {
    getRegionWithBuildings,
    getHouseByMultiCondition
  } from "@/api/basiceData";
  import {
    getHouseParam
  } from "@/api/sysManage";
  export default {
    data() {
      return {
        // 最下面查找需要的相关
        simpleQueryForm: {
          houseZone: "",
          building: "",
          useStatus: "",
          houseType: ""
        },
        regionDataWithBuilding: [],
        buildingData: [],
        statusData: [],
        houseStruct: [],
        listLoading: false,
        //表格相应区域
        houseData: [],
        selectHouseName: "",
        selectHouseId: "",
        dialogVisible: false
      };
    },
    // 组件信息
    components: {
      //个人信息区域
      personalInfoTable,
      staffHouseRel,
      houseResident,
      seachHouse
    },
    // 计算属性
    computed: {
      selectRegion() {
        return this.simpleQueryForm.houseZone;
      }
    },
    watch: {
      // 监听选项的变动
      selectRegion(newval) {
        // console.log("1");
        for (var region of this.regionDataWithBuilding) {
          if (region.name == newval) this.buildingData = region.buildingList;
        }
      }
    },
    created() {
      this.getRegionWithBuilding();
      this.getHouseParam();
    },
    // 方法集合
    methods: {
      // 获取查询时候的房屋参数
      getHouseParam() {
        this.listLoading = true;
        let param = {};
        // http请求
        // 房屋状态3 住房结构4
        getHouseParam(param, 3)
          .then(res => {
            this.statusData = res.data.data.data.list;
            //console.log(this.statusData);
          })
          .catch(err => {
            console.log(err);
          });
        // http请求
        // 房屋状态3 住房结构4
        getHouseParam(param, 4)
          .then(res => {
            this.houseStruct = res.data.data.data.list;
            this.listLoading = false;
          })
          .catch(err => {
            console.log(err);
          });
      },
      // 获取区域信息包括楼栋
      getRegionWithBuilding() {
        this.listLoading = true;
        let param = {
          // page: this.page,
          // size: this.size
        };
        getRegionWithBuildings(param)
          .then(res => {
            this.regionDataWithBuilding = res.data.data.data;
            this.regionDataWithBuilding.forEach(region => {
              let flag = region.name.indexOf("（");
              if (flag != -1) {
                region.name = region.name.substring(0, flag);
              }
            });
            this.listLoading = false;
          })
          .catch(err => {
            console.log(err);
          });
      },
      // 登记从组件相应
      actionDialog() {
        this.dialogVisible = true;
      },
      // 从详细查找组件传递
      selectHouse(data) {
        this.selectHouseName = data[0];
        this.selectHouseId = data[1];
      },
      // 简单的查询
      simpleQuery() {
        for (let query in this.simpleQueryForm) {
          if (this.simpleQueryForm[query] == "")
            delete this.simpleQueryForm[query];
        }
        let param = this.simpleQueryForm;
        this.listLoading = true;
        getHouseByMultiCondition(param).then(res => {
          // 公共提示方法
          utils.statusinfo(this, res.data);
          this.listLoading = false;
          this.houseData = res.data.data.data;
          //console.log(res.data.data.data)
        });
      },
      cellClick(row, column, cell, event) {
        this.selectHouseName = `【${row.houseSort}】,【${row.houseType}】,${
        row.address
      }`;
        this.selectHouseId = row.houseId;
      }
    }
  };

</script>

<style scoped lang="scss">
  .main-data {
    .before-info {
      height: 30vh;
      .personal-info{
        height: 100%;
      }
      .house-rel{
        height: 100%;
      }
    }
    .house-resident {
      margin-top: 20px;
      position: relative;
      height: 20vh;
    }
    .conditionalQuery {
      position: relative;
      padding: 20px 0;
      height: 40vh;
      margin-bottom: 50px;
      .el-form-item{
        margin-bottom: 5px;
      }
      .query-table {
        height: 100%;
        .el-table__body-wrapper {
          overflow-x: hidden;
        }
      }
    }
  }

</style>
