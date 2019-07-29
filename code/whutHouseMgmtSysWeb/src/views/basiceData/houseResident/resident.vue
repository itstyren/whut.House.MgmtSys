<template>
  <div class="second-container">
    <inde-nav @select-staff="selectStaff"></inde-nav>
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>基础数据</el-breadcrumb-item>
            <el-breadcrumb-item>住房关系管理</el-breadcrumb-item>
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
            <el-row style="margin:0 10px 0 -10px;"
                    :gutter="20">
              <el-col :span="10">
                <personal-info-table :staff-id="staffId"
                                     :height="'30vh'"></personal-info-table>
              </el-col>
              <el-col :span="14">
                <staff-house-rel :staff-id="staffId"
                                 :height="'30vh'"></staff-house-rel>
              </el-col>
            </el-row>
            <!-- 住房登记区 -->
            <el-row style="margin:0 10px 0 -10px;"
                    :gutter="20">
              <el-col :span="24">
                <house-resident :height="'120px'"
                                :staff-id="staffId"
                                :select-house="selectHouseName"
                                :select-house-id="selectHouseId"></house-resident>
              </el-col>
            </el-row>
            <!-- 职工与住房的关系表格 -->
            <el-row class="conditionalQuery card">
              <el-col :span="24"
                      style="height:75%">
                <div class="query-table">
                  <el-table :data="houseRelData"
                            class="table"
                            height="string"
                            @cell-click="handleClikHouse"
                            v-loading="listLoading">
                    <el-table-column prop="houseNo"
                                     label="住房号"
                                     sortable
                                     width="90"
                                     align="center"></el-table-column>
                    <el-table-column prop="houseTypeName"
                                     label="住房类型"
                                     sortable
                                     width="140"
                                     align="center"></el-table-column>
                    <el-table-column prop="houseRelName"
                                     label="关系"
                                     sortable
                                     width="120"
                                     align="center"></el-table-column>
                    <el-table-column prop="usedArea"
                                     label="使用面积"
                                     sortable
                                     width="120"
                                     align="center"></el-table-column>
                    <el-table-column prop="bookTime"
                                     label="入住时间"
                                     align="center"></el-table-column>
                    <el-table-column prop="expireTime"
                                     label="退出时间"
                                     align="center"></el-table-column>
                    <el-table-column prop="address"
                                     label="地址"
                                     align="center"></el-table-column>
                    <el-table-column prop="payType"
                                     label="缴费方式"
                                     align="center"
                                     :formatter="payTypeColFormat"></el-table-column>
                    <el-table-column label="操作"
                                     width="180"
                                     align="center">
                      <template slot-scope="scope">
                        <el-button type="danger"
                                   size="mini"
                                   @click="handleDelRel(scope.$index,scope.row)">删除</el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </div>
              </el-col>
            </el-row>
          </div>
        </div>
        <!-- 详细查找表单 -->
        <seach-house @select-house="selectHouse"></seach-house>
      </div>
    </section>
    <house-detail-dialog :show.sync="showDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import indeNav from './components/indexNav'
import personalInfoTable from "./components/personalInfoTable";
import staffHouseRel from "./components/staffHouseRel";
import houseResident from "./components/houseResident";
import seachHouse from "@/views/tools/seachHouse";
import HouseDetailDialog from '@/components/OneHouseData'

import utils from "@/utils/index.js";
import {
  getRegionWithBuildings,
  getHouseByMultiCondition,
  getAllHouseRelByStaffId,
  getOneHouseData
} from "@/api/basiceData";
import {
  getHouseParam
} from "@/api/sysManage";
export default {
  data () {
    return {
      regionDataWithBuilding: [],
      buildingData: [],
      statusData: [],
      houseStruct: [],
      listLoading: false,
      staffId: -1,
      //职工与住房关系的表格填充数据
      houseRelData: [],
      selectHouseName: "",
      selectHouseId: "",
      // 是否显示住房详情的对话框
      showDialog: false,
      houseId: 0,
      // 缴租方式的代号
      payTypes: [
        {
          id: 0,
          typeName: '无需缴费'
        },
        {
          id: 1,
          typeName: '自行缴费'
        },
        {
          id: 2,
          typeName: '工资代扣'
        }
      ],
    };
  },
  // 组件信息
  components: {
    //个人信息区域
    personalInfoTable,
    staffHouseRel,
    houseResident,
    seachHouse,
    indeNav,
    HouseDetailDialog
  },
  // 计算属性
  computed: {
  },
  watch: {
    // 监听选项的变动
    selectRegion (newval) {
      // console.log("1");
      for (var region of this.regionDataWithBuilding) {
        if (region.name == newval) this.buildingData = region.buildingList;
      }
    }
  },
  created () {
    this.getRegionWithBuilding();
    this.getHouseParam();
  },
  mounted () {

  },
  // 方法集合
  methods: {
    selectStaff (object) {
      this.staffId = object.id
      this.getAllHouseRelByStaffId(this.staffId)
    },
    // 获取查询时候的房屋参数
    getHouseParam () {
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
    getRegionWithBuilding () {
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
    // 从详细查找组件传递
    selectHouse (data) {
      this.selectHouseName = data[0];
      this.selectHouseId = data[1];
    },
    // 根据职工号staffId获取与其所有相关的住房关系数据
    getAllHouseRelByStaffId () {
      this.listLoading = true
      getAllHouseRelByStaffId(this.staffId).then(res => {
        this.houseRelData = res.data.data.data
      })
      this.listLoading = false
    },
    cellClick (row, column, cell, event) {

      this.selectHouseName = `【${row.houseSort}】,【${row.houseType}】,${
        row.address
        }`;
      this.selectHouseId = row.houseId;
    },
    // 点击地址弹开对话框
    handleClikHouse (row, column, cell, event) {
      if (column.property === "address") {
        this.showDialog = true
        this.houseId = row.houseId
      }
    },
    // 删除历史住房纪录
    handleDelRel (index, row) {
      // 删除关系
      this.$confirm("此操作将删除该关系", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.residentId;
          this.listLoading = true;
          deleteResidentLog(param)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.getList();
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    // 缴租方式的代号替换：0：无需缴费。1：自行缴费。2：工资代扣
    payTypeColFormat (row, column, cellValue, index) {
      let value = ''
      this.payTypes.forEach(item => {
        if (item.id == cellValue) {
          value = item.typeName
        }
      })
      return value
    }
  }
};

</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  .main-data {
    .conditionalQuery {
      position: relative;
      padding: 20px 0;
      height: 50vh;
      margin-bottom: 50px;
      .el-form-item {
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
}
</style>
