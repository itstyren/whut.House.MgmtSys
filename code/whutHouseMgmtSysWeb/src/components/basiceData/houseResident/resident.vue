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
      <div class="toolbal">
      </div>
      <!-- 信息区 -->
      <div class="main-data">
        <!-- 个人信息区 -->
        <div class="before-info">
          <personal-info-table></personal-info-table>
          <div class="house-rel">
            <staff-house-rel></staff-house-rel>
          </div>
        </div>
        <!-- 住房登记区 -->
        <div class="house-resident">
          <house-resident :select-house="selectHouse" :select-house-id="selectHouseId"></house-resident>
        </div>
        <!-- 房屋查询区 -->
        <div class="conditionalQuery">
          <div class="tool">
            <el-form :model="simpleQueryForm" :inline="true">
              <el-form-item label="住房类型">
                <el-select v-model="simpleQueryForm.houseType" size="small" style="width:150px" :clearable="true" placeholder="全部结构">
                  <el-option v-for="struct in houseStruct" :key="struct.houseParamId" :value="struct.houseParamName" :label="struct.houseParamName"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="使用状况">
                <el-select v-model="simpleQueryForm.useStatus" size="small" style="width:150px" :clearable="true" placeholder="全部状态">
                  <el-option v-for="status in statusData" :key="status.houseParamId" :value="status.houseParamName" :label="status.houseParamName"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="住房区域">
                <el-select v-model="simpleQueryForm.houseZone" size="small" :clearable="true" placeholder="全部区域">
                  <el-option v-for="region in regionDataWithBuilding" :key="region.id" :value="region.name" :label="region.name"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="楼栋">
                <el-select v-model="simpleQueryForm.building" size="small" :clearable="true" placeholder="全部房屋">
                  <el-option v-for="building in buildingData" :key="building.id" :value="building.name" :label="building.name"></el-option>
                </el-select>
              </el-form-item>
              <el-button type="primary" @click="simpleQuery " size="small">筛选</el-button>
              <el-button type="primary" @click="simpleQuery " size="small">详细查找</el-button>
            </el-form>
          </div>
        </div>
        <!-- 查询相应区 -->
        <div class="queryTable">
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
      </div>
    </div>
    <!-- 详细查找表单 -->
    <el-dialog title="多条件查找"></el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import personalInfoTable from "./personalInfoTable";
  import staffHouseRel from "./staffHouseRel";
  import houseResident from "./houseResident";
  import common from "@/common/util.js";
  import {
    getHouseParam,
    getRegionWithBuildings,
    getHouseByMultiCondition
  } from "@/api/api";
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
        selectHouse:'',
        selectHouseId:'',
      };
    },
    // 组件信息
    components: {
      //个人信息区域
      personalInfoTable,
      staffHouseRel,
      houseResident
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
        for (var region of this.regionDataWithBuilding) {
          if (region.name == newval) this.buildingData = region.buildingList;
        }
      },
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
      simpleQuery() {
        for (let query in this.simpleQueryForm) {
          if (this.simpleQueryForm[query] == "")
            delete this.simpleQueryForm[query];
        }
        let param = this.simpleQueryForm;
        this.listLoading = true
        getHouseByMultiCondition(param).then(res => {
          // 公共提示方法
          common.statusinfo(this, res.data);
          this.listLoading = false;
          this.houseData = res.data.data.data
          //console.log(res.data.data.data)
        });
      },
      cellClick(row, column, cell, event) {
        this.selectHouse=`【${row.houseSort}】,【${row.houseType}】,${row.address}`
        this.selectHouseId=row.houseNo
      }
    }
  };

</script>

<style scoped lang="scss">
  .main-data {
    display: flex;
    flex-direction: column;
    position: relative;
    .before-info {
      //position: absolute;
      display: flex;
      flex-direction: row;
      width: 100%;
      height: 35%;
      .personal-info {
        width: 30%;
        height: 100%;
        background-color: aquamarine;
      }
      .house-rel {
        flex: 1;
      }
    }
    .house-resident {
      position: relative;
      width: 100%;
      height: 20%;
      background-color: #eee;
            border-top: 1px solid #000;
            border-bottom: 1px solid #000;  
    }
    .conditionalQuery {
            border-bottom: 1px solid #000;      
      padding-top: 20px;
      width: 100%;
      height: auto;
      background-color: #eee;
      .tool {
        text-align: center;
      }
    }
    .queryTable {
      flex: 1;
      width: 100%;
      background-color: #eee;
    }
  }

</style>
