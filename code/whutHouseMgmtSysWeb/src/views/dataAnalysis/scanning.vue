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
            <el-breadcrumb-item>多套住房分析</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <el-form :model="queryForm" label-width="100px">
              <el-row>
                <el-col :span="4">
                  <el-form-item label="住房类型">
                    <el-select v-model="queryForm.houseTypeId" :clearable="true" placeholder="所有类型">
                      <el-option v-for="v in typeData" :key="v.houseParamId" :value="v.houseParamId" :label="v.houseParamName"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="职工类别">
                    <el-select v-model="queryForm.staffTypeId" :clearable="true" placeholder="所有类别">
                      <el-option v-for="v in classData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="2" :offset="1">
                  <el-button type="primary" @click="multiplyQuery">查询</el-button>
                </el-col>
              </el-row>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-tabs v-model="activeName" type="border-card" style="margin:10px 10px 10px">
              <el-tab-pane name="query">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 多套查询 </span>
                <keep-alive>
                  <!-- 多套查询 -->
                  <div v-if="activeName=='query'" class="table-tabs">
                    <el-table :data="queryData" class="table" height="string" v-loading="listLoading">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                      <el-table-column label="姓名" sortable align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.staffName }}</p>
                            <p>来校工作时间: {{ scope.row.joinTime }}</p>
                            <p>预计退休时间: {{ scope.row.retireTime }}</p>
                            <div slot="reference" class="name-wrapper">
                              <el-tag size="medium" type="info">{{ scope.row.staffName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                      <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                      <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                      <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                      <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
                      <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                      <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                      <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
                      :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="count">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 多套统计 </span>
                <keep-alive>
                  <!-- 多套统计 -->
                  <div v-if="activeName=='count'" class="table-tabs">
                    <el-table :data="countData" class="table" height="string" v-loading="listLoading1">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                      <el-table-column label="姓名" sortable align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.staffName }}</p>
                            <p>来校工作时间: {{ scope.row.joinTime }}</p>
                            <p>离退休时间: {{ scope.row.retireTime }}</p>
                            <div slot="reference" class="name-wrapper">
                              <el-tag size="medium" type="info">{{ scope.row.staffName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                      <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                      <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                      <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                      <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
                      <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                      <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                      <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
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
import { getHouseParam, getStaffParam } from "@/api/sysManage";
import { postStaffMultiplyHouse } from "@/api/dataAnalysis";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      queryForm: {},
      listLoading: false,
      typeData: [],
      classData: [],
      activeName: "query",
      queryData: [],
      countData: [],
      listLoading: false,
      listLoading1: false,
      totalNum: 1,
      page: 1,
      size: 10,
      totalNum1: 1,
      page1: 1,
      size1: 10
    };
  },
  components: {},
  created() {
    this.initGet();
  },
  methods: {
    initGet() {
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
    multiplyQuery() {
      this.listLoading = true;
      let params = {
        page: this.page,
        size: this.size
      };
      let data = Object.assign({}, this.queryForm);
      postStaffMultiplyHouse(params, data)
        .then(res => {
          this.listLoading = false;
          console.log(res.data.data);
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    },
    //更换每页数量1
    sizeChangeEvent1(val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.getList1();
    },
    //页码切换时1
    currentChangeEvent1(val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.getList1();
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
    height: 65vh;
    padding-bottom: 40px;
    position: relative;
  }
}
</style>
