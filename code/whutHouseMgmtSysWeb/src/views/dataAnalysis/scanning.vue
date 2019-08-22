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
            <el-breadcrumb-item>多套住房核对</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar card">
            <el-form :model="queryForm"
                     label-width="100px">
              <el-row>
                <el-col :span="8"
                        :push="2">
                  <el-form-item label="住房类型">
                    <el-select v-model="queryForm.houseTypeId"
                               :clearable="true"
                               placeholder="所有类型">
                      <el-option v-for="v in typeData"
                                 :key="v.houseParamId"
                                 :value="v.houseParamId"
                                 :label="v.houseParamName"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8"
                        :push="2">
                  <el-form-item label="职工类别">
                    <el-select v-model="queryForm.staffTypeId"
                               :clearable="true"
                               placeholder="所有类别">
                      <el-option v-for="v in classData"
                                 :key="v.staffParamId"
                                 :value="v.staffParamId"
                                 :label="v.staffParamName"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="2"
                        :push="3">
                  <el-button type="primary"
                             @click="multiplyQuery">查询</el-button>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-tabs v-model="activeName"
                     type="border-card"
                     style="margin:10px 10px 10px">
              <el-tab-pane name="query">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 多套查询
                </span>
                <keep-alive>
                  <!-- 多套查询 -->
                  <div v-if="activeName=='query'"
                       class="table-tabs">
                    <el-table :data="houseRelData"
                              class="table"
                              height="55vh"
                              @cell-click="handleClikHouse"
                              v-loading="listLoading">
                      <el-table-column prop="staffNo"
                                       label="职工号"
                                       sortable
                                       align="center"
                                       width="90"></el-table-column>
                      <el-table-column prop="staffName"
                                       label="姓名"
                                       align="center"
                                       width="90"> </el-table-column>
                      <el-table-column prop="staffDeptName"
                                       label="工作部门"
                                       align="center"
                                       width="120"></el-table-column>
                      <el-table-column prop="staffSpouseName"
                                       label="配偶姓名"
                                       align="center"
                                       width="90"></el-table-column>
                      <el-table-column prop="bookTime"
                                       label="登记时间"
                                       align="center"
                                       width="120"></el-table-column>
                      <el-table-column prop="houseRel"
                                       label="住房关系"
                                       align="center"
                                       width="90">
                        <template slot-scope="scope">
                          <el-tag :type="scope.row.houseRel | statusFilter">{{scope.row.houseRel}}</el-tag>
                        </template>
                      </el-table-column>
                      <el-table-column prop="address"
                                       label="住房地址"
                                       class-name="address-cursor"
                                       align="center"></el-table-column>
                      <el-table-column prop="staffTypeName"
                                       label="职工类别"
                                       align="center"
                                       width="120"></el-table-column>
                      <el-table-column prop="houseTypeName"
                                       label="住房类型"
                                       align="center"
                                       width="120"></el-table-column>
                    </el-table>
                    <el-pagination background
                                   layout="total, prev, pager, next, sizes, jumper"
                                   @size-change="sizeChangeEvent"
                                   @current-change="currentChangeEvent"
                                   :page-size="size"
                                   :page-sizes="[10,15,20,25,30]"
                                   :total="totalNum">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="count">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 多套统计
                </span>
                <keep-alive>
                  <!-- 多套统计 -->
                  <div v-if="activeName=='count'"
                       class="table-tabs">
                    <el-table :data="countData"
                              class="table"
                              height="55vh"
                              v-loading="listLoading1">
                      <el-table-column prop="staffNo"
                                       label="职工号"
                                       sortable
                                       align="center"></el-table-column>
                      <el-table-column prop="staffName"
                                       label="姓名"
                                       align="center"> </el-table-column>
                      <el-table-column prop="staffTypeName"
                                       label="职工类别"
                                       align="center"></el-table-column>
                      <el-table-column prop="staffSpouseName"
                                       label="配偶姓名"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseNum"
                                       label="住房套数"
                                       align="center"></el-table-column>
                    </el-table>
                    <el-pagination background
                                   layout="total, prev, pager, next, sizes, jumper"
                                   @size-change="sizeChangeEvent1"
                                   @current-change="currentChangeEvent1"
                                   :page-size="size1"
                                   :page-sizes="[10,15,20,25,30]"
                                   :total="totalNum1">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
      </div>
      <house-detail-dialog :show.sync="showDialog"
                           :houseId.sync="houseId"></house-detail-dialog>
    </section>

  </div>
</template>

<script type="text/ecmascript-6">
import { getHouseParam, getStaffParam } from "@/api/sysManage";
import { postStaffMultiplyHouse, postStaffMultiplyHouseNum } from "@/api/dataAnalysis";
import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'

export default {
  components: {
    HouseDetailDialog
  },
  data () {
    return {
      queryForm: {},
      listLoading: false,
      typeData: [],
      classData: [],
      activeName: "query",
      houseRelData: [],
      countData: [],
      listLoading: false,
      listLoading1: false,
      totalNum: 0,
      page: 1,
      size: 10,
      totalNum1: 0,
      page1: 1,
      size1: 10,
      houseId: 0,
      showDialog: false
    };
  },
  // 过滤器的哈希表
  filters: {
    statusFilter (status) {
      const statusMap = {
        租赁: "info",
        私有: 'warning',
        购买: "success"
      };
      return statusMap[status];
    }
  },
  created () {
    this.initGet();
    this.multiplyQuery()
  },
  methods: {
    initGet () {
      this.listLoading = true;
      let param = {
        size: 999
      };
      // 类型为1
      getHouseParam(param, 1)
        .then(res => {
          this.typeData = res.data.data.data.list;

          // 类别为8
          getStaffParam(param, 8)
            .then(res => {
              this.classData = res.data.data.data.list;
              this.listLoading = false;
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(err => {
          console.log(err);
        });
    },
    multiplyQuery () {
      this.listLoading = true;
      let params = {
        page: this.page,
        size: this.size
      };
      let data = Object.assign({}, this.queryForm);
      postStaffMultiplyHouse(params, data)
        .then(res => {
          // console.log(res.data.data.data.list);
          this.houseRelData = res.data.data.data.list
          this.totalNum = res.data.data.data.total
          this.listLoading = false
          this.listLoading1 = true
          postStaffMultiplyHouseNum(params, data).then(res => {
            // console.log(res.data.data.data)
            this.countData = res.data.data.data
            this.totalNum1 = res.data.data.data.total
            this.listLoading1 = false
          })
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 更换每页数量
    sizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.multiplyQuery();
    },
    //页码切换时
    currentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.multiplyQuery();
    },
    //更换每页数量1
    sizeChangeEvent1 (val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.multiplyQuery();
    },
    //页码切换时1
    currentChangeEvent1 (val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.multiplyQuery();
    },
    // 点击地址弹开对话框
    handleClikHouse (row, column, cell, event) {
      if (column.property === "address") {
        this.showDialog = true
        this.houseId = row.houseId
      }
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  // background-color: $background-grey;
  .toolbar {
    margin-top: 15px;
    .el-form-item {
      margin-bottom: 5px;
    }
  }
  .card {
    padding: 10px;
  }
  .table-tabs {
    height: 60vh;
    padding-bottom: 40px;
    position: relative;
  }
}
</style>
