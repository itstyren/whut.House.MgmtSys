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
          <div class="personal-info card" >
          <personal-info-table></personal-info-table>
          </div>
          <div class="house-rel card">
            <staff-house-rel></staff-house-rel>
          </div>
        </div>
        <!-- 住房登记区 -->
        <div class="house-resident card">
          <house-resident :select-house="selectHouse" :select-house-id="selectHouseId"></house-resident>
        </div>
        <!-- 房屋查询区 -->
        <div class="conditionalQuery card" >
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
        </div>
      </div>
    </div>
    <!-- 详细查找表单 -->
    <el-dialog title="多条件查找"></el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import personalInfoTable from "./components/personalInfoTable";
import staffHouseRel from "./components/staffHouseRel";
import houseResident from "./components/houseResident";
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
      selectHouse: "",
      selectHouseId: ""
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
    simpleQuery() {
      for (let query in this.simpleQueryForm) {
        if (this.simpleQueryForm[query] == "")
          delete this.simpleQueryForm[query];
      }
      let param = this.simpleQueryForm;
      this.listLoading = true;
      getHouseByMultiCondition(param).then(res => {
        // 公共提示方法
        common.statusinfo(this, res.data);
        this.listLoading = false;
        this.houseData = res.data.data.data;
        //console.log(res.data.data.data)
      });
    },
    cellClick(row, column, cell, event) {
      this.selectHouse = `【${row.houseSort}】,【${row.houseType}】,${
        row.address
      }`;
      this.selectHouseId = row.houseId;
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
    height: 30%;
    .personal-info {
      width: 31%;
      height: 100%;
    }
    .house-rel {
      width: 65%;
      height: 100%;
    }
  }
  .house-resident {
    padding-top: 10px;
    margin-top: 20px;
    position: relative;
    width: 98%;
    height: 18%;
  }
  .conditionalQuery {
    position: relative;
    padding-top: 20px;
    width: 98%;
    height: 40%;
    text-align: center;
    .query-table{
      overflow: auto;
      position: absolute;
      top:25%;
      bottom: 5px;
      left: 5px;
      right: 2px;
      .el-table__body-wrapper{
        overflow-x: hidden;
      }
    }
  }
}
</style>
