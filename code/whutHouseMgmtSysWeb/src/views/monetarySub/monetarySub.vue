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
            <el-breadcrumb-item>货币化补贴</el-breadcrumb-item>
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
            <el-tabs v-model="activeName"
                     type="border-card"
                     style="margin:10px 10px 10px">
              <el-tab-pane name="query">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 年度补贴
                </span>
                <keep-alive>
                  <!-- 年度补贴 -->
                  <div v-if="activeName=='query'"
                       class="table-tabs">
                    <el-table :data="monetarySubData"
                              class="table"
                              height="string"
                              v-loading="listLoading">
                      <el-table-column prop="year"
                                       label="年度"
                                       sortable
                                       align="center"></el-table-column>
                      <el-table-column prop="staffNo"
                                       label="职工号"
                                       sortable
                                       align="center"></el-table-column>
                      <el-table-column prop="staffName"
                                       label="姓名"
                                       align="center"> </el-table-column>
                      <el-table-column prop="deptName"
                                       label="职工部门"
                                       align="center"> </el-table-column>
                      <el-table-column prop="titleName"
                                       label="职称"
                                       align="center"> </el-table-column>
                      <el-table-column prop="postName"
                                       label="职务"
                                       align="center"> </el-table-column>
                      <el-table-column prop="annualSal"
                                       label="年度工资"
                                       align="center"> </el-table-column>
                      <el-table-column prop="subsidies"
                                       label="补贴金额"
                                       align="center"> </el-table-column>
                      <el-table-column prop="remark"
                                       label="备注"
                                       align="center"> </el-table-column>
                    </el-table>
                    <el-pagination background
                                   layout="total, prev, pager, next, sizes, jumper"
                                   @size-change="sizeChangeEvent"
                                   @current-change="currentChangeEvent"
                                   :page-size="size"
                                   :page-sizes="[10,15,20,25,30]"
                                   :total="totalNum">
                    </el-pagination>
                    <div class="bottom-tool">
                      <export-popover :download-loading="downloadLoading"
                                      @export="exportHandle"></export-popover>
                    </div>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="count">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 一次性补贴
                </span>
                <keep-alive>
                  <!-- 一次性补贴 -->
                  <div v-if="activeName=='count'"
                       class="table-tabs">
                    <el-table :data="lumpMonetarySubData"
                              class="table"
                              height="string"
                              v-loading="listLoading1">
                      <el-table-column prop="staffNo"
                                       label="职工号"
                                       sortable
                                       align="center"></el-table-column>
                      <el-table-column prop="staffName"
                                       label="姓名"
                                       align="center"> </el-table-column>
                      <el-table-column prop="deptName"
                                       label="职工部门"
                                       align="center"> </el-table-column>
                      <el-table-column prop="oneTimeSubsidy"
                                       label="补偿金额"
                                       align="center"></el-table-column>
                      <el-table-column prop="oneTimeSubYear"
                                       label="发放时间"
                                       align="center"></el-table-column>
                      <el-table-column prop="remark"
                                       label="备注"
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
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  postAllStaffMonetarySub,
  postAllStaffLumpMonetarySub
} from "@/api/monetarySub";
import utils from "@/utils/index.js";
import staffFilter from "@/views/tools/staffFilter";
import exportPopover from "@/components/exportPopover";
export default {
  data () {
    return {
      downloadLoading: false,
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
      size1: 10,
      filterData: {}
    };
  },
  components: { staffFilter, exportPopover },
  created () {
    this.getMonetarySub();
    this.getLumpMonetarySub();
  },
  watch: {
    filterData (newVal) {
      this.getMonetarySub();
      this.getLumpMonetarySub();
    }
  },
  methods: {
    getMonetarySub () {
      this.listLoading = false;
      let params = {
        page: this.page,
        size: this.size
      };
      postAllStaffMonetarySub(params, this.filterData).then(res => {
        this.monetarySubData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      });
    },
    getLumpMonetarySub () {
      this.listLoading = false;
      let params = {
        page: this.page1,
        size: this.size1
      };
      postAllStaffLumpMonetarySub(params, this.filterData).then(res => {
        // console.log(res.data.data.data);
        this.totalNum1 = res.data.data.data.total;
        this.lumpMonetarySubData = res.data.data.data.list;
      });
    },
    queryStaff (data) {
      // console.log(data);
      this.filterData = data
    },
    // 处理导出情况
    exportHandle (exportType) {
      if (exportType == 1) this.handleDownload();
      else {
        let param = {
          page: 1,
          size: 9999
        };
        let data = Object.assign({}, this.filterData);
        postAllStaffMonetarySub(param, data).then(res => {
          const values = res.data.data.data.list;
          this.handleDownload(values);
        });
      }
    },
    // 导出
    handleDownload (values) {
      let filename = "年度补贴查询表";
      this.downloadLoading = true;
      import("@/vendor/Export2Excel").then(excel => {
        const tHeader = [
          "年度",
          "职工号",
          "姓名",
          "职工部门",
          "职称",
          "职务",
          "年度工资",
          "补贴金额",
          "备注"
        ];
        const filterVal = [
          "year",
          "staffNo",
          "staffName",
          "deptName",
          "titleName",
          "postName",
          "annualSal",
          "subsidies",
          "remark"
        ];
        let list = [];
        if (arguments.length == 0) list = this.monetarySubData;
        else list = arguments[0];
        const data = this.formatJson(filterVal, list); // 用于自行洗数据
        excel.export_json_to_excel(tHeader, data, filename);
        this.downloadLoading = false;
      });
    },
    formatJson (filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => v[j])
      );
    },
    // 更换每页数量
    sizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.getMonetarySub();
    },
    //页码切换时
    currentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.getMonetarySub();
    },
    //更换每页数量1
    sizeChangeEvent1 (val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.getLumpMonetarySub();
    },
    //页码切换时1
    currentChangeEvent1 (val) {
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
    & > .bottom-tool {
      position: absolute;
      bottom: -4px;
      left: 15px;
    }
  }
}
</style>
