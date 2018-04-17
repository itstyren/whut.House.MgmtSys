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
            <el-breadcrumb-item>住房补贴查询统计</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
              <staff-filter @query-staff="queryStaff"></staff-filter>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-tabs v-model="activeName" type="border-card" style="margin:10px 10px 10px">
              <el-tab-pane name="query">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 年度补贴 </span>
                <keep-alive>
                  <!-- 年度补贴 -->
                  <div v-if="activeName=='query'" class="table-tabs">
                    <el-table :data="monetarySubData" class="table" height="string" v-loading="listLoading">
                      <el-table-column prop="year" label="年度" sortable align="center" ></el-table-column>
                      <el-table-column prop="staffNo" label="职工号" sortable align="center" ></el-table-column>
                      <el-table-column prop="staffName"  label="姓名" align="center" > </el-table-column>
                      <el-table-column prop="staffName"  label="职工部门" align="center" > </el-table-column>
                      <el-table-column prop="staffName"  label="职称" align="center" > </el-table-column>
                      <el-table-column prop="staffName"  label="职务" align="center" > </el-table-column>
                      <el-table-column prop="annualSal"  label="年度工资" align="center" > </el-table-column>
                      <el-table-column prop="subsidies"  label="补贴金额" align="center" > </el-table-column>
                      <el-table-column prop="remark"  label="备注" align="center" > </el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
                      :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="count">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 一次性补贴 </span>
                <keep-alive>
                  <!-- 一次性补贴 -->
                  <div v-if="activeName=='count'" class="table-tabs">
                    <el-table :data="lumpMonetarySubData" class="table" height="string" v-loading="listLoading1">
                      <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                      <el-table-column prop="staffName"  label="姓名" align="center"> </el-table-column>
                      <el-table-column prop="oneTimeSubsidy" label="补偿金额" align="center"></el-table-column>
                      <el-table-column prop="oneTimeSubYear" label="发放时间"  align="center"></el-table-column>                                           
                      <el-table-column prop="remark" label="备注" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent1" @current-change="currentChangeEvent1"
                      :page-size="size1" :page-sizes="[10,15,20,25,30]" :total="totalNum1">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  postStaffMultiplyHouse,
  postStaffMultiplyHouseNum
} from "@/api/dataAnalysis";
import {
  postAllStaffMonetarySub,
  postAllStaffLumpMonetarySub
} from "@/api/monetarySub";
import utils from "@/utils/index.js";
import staffFilter from "@/views/tools/staffFilter";
export default {
  data() {
    return {
      queryForm: {},
      listLoading: false,
      activeName: "query",
      monetarySubData: [],
      lumpMonetarySubData: [],
      listLoading: false,
      listLoading1: false,
      totalNum: 0,
      page: 1,
      size: 10,
      totalNum1: 0,
      page1: 1,
      size1: 10
    };
  },
  // 过滤器的哈希表
  filters: {
    statusFilter(status) {
      const statusMap = {
        租赁: "info",
        私有: "warning",
        购买: "success"
      };
      return statusMap[status];
    }
  },
  components: { staffFilter },
  created() {
    this.getMonetarySub();
    this.getLumpMonetarySub();
  },
  methods: {
    getMonetarySub() {
      this.listLoading = false;
      let params = {
        page: this.page,
        size: this.size
      };
      postAllStaffMonetarySub(params).then(res => {
        // console.log(res.data.data);
        this.monetarySubData = res.data.data.data.list;
        // console.log(this.houseData)
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      });
    },
    getLumpMonetarySub() {
      this.listLoading = false;
      let params = {
        page: this.page1,
        size: this.size1
      };
      postAllStaffLumpMonetarySub(params).then(res => {
        console.log(res.data.data.data);
        this.totalNum1 = res.data.data.data.total;
        this.lumpMonetarySubData = res.data.data.data.list;
      });
    },
    queryStaff(data) {
      console.log(data);
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getMonetarySub();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getMonetarySub();
    },
    //更换每页数量1
    sizeChangeEvent1(val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.getLumpMonetarySub();
    },
    //页码切换时1
    currentChangeEvent1(val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.getLumpMonetarySub();
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  .toolbar {
    .el-form-item {
      margin-bottom: 5px;
    }
  }
  .card {
    padding: 10px;
  }
  .table-tabs {
    height: 62vh;
    padding-bottom: 40px;
    position: relative;
  }
}
</style>
