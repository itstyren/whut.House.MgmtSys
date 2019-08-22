<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>职工管理</el-breadcrumb-item>
        <el-breadcrumb-item>{{depName}}</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar card"
           style="margin-left:10px;">
        <el-form :model="queryOption"
                 :inline="true"
                 :rules="queryRules"
                 label-width="100px"
                 ref="queryForm">
          <el-form-item label="部门"
                        prop="deptId">
            <el-select v-model="queryOption.deptId"
                       :clearable="true"
                       @clear="clearDept"
                       placeholder="所有部门"
                       style="width:250px"
                       @change="selectDeptChange">
              <el-option v-for="dept in depData"
                         :key="dept.id"
                         :value="dept.id"
                         :label="dept.label"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="姓名"
                        prop="staff">
            <el-select v-model="queryOption.staffId"
                       :clearable="true"
                       placeholder="全部职工"
                       style="width:250px">
              <el-option v-for="staff in staffData"
                         :key="staff.id"
                         :value="staff.id"
                         :label="staff.label"></el-option>
            </el-select>
          </el-form-item>
          <el-button type="primary"
                     @click="getList(queryOption)">查询</el-button>
          <el-form-item>
            <el-button type="primary"
                       @click="addStaff()">新增员工</el-button>
          </el-form-item>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <div class="card"
             style="height:95%">
          <el-table :data="deptStaffData"
                    class="table"
                    height="93%"
                    v-loading="listLoading">
            <el-table-column type="selection"
                             width="45"></el-table-column>
            <el-table-column prop="no"
                             label="职工号"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="name"
                             label="姓名"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="sex"
                             label="性别"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="marriageState"
                             label="婚姻状况"
                             width="120"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="titleName"
                             label="职称"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="postName"
                             label="职务"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="statusName"
                             label="工作状态"
                             width="120"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="groupName"
                             label="用户组"
                             sortable
                             align="center"></el-table-column>
            <el-table-column label="操作"
                             width="350"
                             align="center">
              <template slot-scope="scope">
                <el-button size="small"
                           @click="showDetailDialog(scope.$index,scope.row)">详情</el-button>
                <el-button type="success"
                           size="small"
                           @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
                <el-button type="warning"
                           size="small"
                           @click="resetStaffPwd(scope.$index,scope.row)">重置</el-button>
                <el-button type="danger"
                           size="small"
                           @click="delectStaff(scope.$index,scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination background
                         layout="total, prev, pager, next, sizes, jumper"
                         @size-change="SizeChangeEvent"
                         @current-change="CurrentChangeEvent"
                         :page-size="size"
                         :page-sizes="[10,15,20,25,30]"
                         :total="totalNum">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getSingleDept,
  getStaff,
  deleteStaffData,
  putResetStaffPwd,
  getStaffListByMultiCondition
} from "@/api/basiceData";
import {
  checkNum,
  checkNULL
} from "@/assets/function/validator";
import utils from "@/utils/index.js";
import * as types from "../../../store/mutation-types";
export default {
  data () {
    return {
      // 表格数据
      deptStaffData: [],
      depName: "",
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,
      //查询需要的数据
      staffData: [],
      // 查询选项
      queryOption: {
        deptId: "",
        staffId: ""
      },
      // 查询表达验证规则
      queryRules: {}
    };
  },
  // 获取父组件传递的数据
  props: ["depData"],
  computed: {
    selectDept () {
      return this.queryOption.deptId;
    },
    addSelectRegion () {
      return this.addFormBody.deptId || this.detailData.deptId;
    }
  },
  // 监听
  watch: {
    // 监听选项的变动
    selectDept (newval) {
      for (var dept of this.depData) {
        if (dept.id == newval) this.staffData = dept.children;
      }
    },
    // 监听路由
    $route (newVal) {
      this.getList({ deptId: newVal.params.id });
    }
  },
  created () {
    this.getList(this.queryOption);
  },
  // 方法集合
  methods: {
    //选择的区域变化时
    selectDeptChange (dept) {
      this.queryOption.staffId = "";
      this.staffData = dept.buildingList;
    },
    getList (queryData) {
      this.listLoading = true;
      this.deptStaffData = [];
      let param = {
        page: this.page,
        size: this.size
      }
      let data = Object.assign({}, queryData)
      //请求一个部门的员工
      if (data.deptId) {
        //请求一个员工
        if (data.staffId) {
          getStaff(param, data.staffId)
            .then(res => {
              this.deptStaffData.push(res.data.data.data)
              this.depName = this.deptStaffData.deptName
              this.totalNum = 1
              utils.statusinfo(this, res.data);
              this.listLoading = false;
            })
          return
        }
        getSingleDept(param, data.deptId)
          .then(res => {
            this.deptStaffData = res.data.data.data.list;
            this.totalNum = res.data.data.data.total;
            this.depName = this.deptStaffData[0].deptName
            utils.statusinfo(this, res.data);
            this.listLoading = false;
          })
        return
      }

      //请求全部员工
      getStaffListByMultiCondition(param, {}).then(res => {
        utils.statusinfo(this, res.data);
        this.deptStaffData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      }).then(() => {
        this.depName = '所有员工'
      })
    },
    // // 清空搜索的区域时
    clearDept () {
      this.queryOption.staffId = "";
    },
    // 显示详情页面
    showDetailDialog (index, row) {
      // this.$store.commit(types.STAFF_DATA, row);
      this.$store.commit(types.STAFF_MODIFY, false);
      this.$store.commit('SET_STAFF_SHOW', true)
      this.$router.push({
        path: `/basic/staff/byId/${row.id}`
      });
    },
    //切换到编辑
    showModifyDialog (index, row) {
      // this.$store.commit(types.STAFF_DATA, row);
      this.$store.commit(types.STAFF_MODIFY, true);
      this.$store.commit('SET_STAFF_SHOW', true)
      this.$router.push({
        path: `/basic/staff/byId/${row.id}`
      });
    },
    // 切换到新增页面
    addStaff () {
      this.$router.push({
        path: `/basic/staff/add`
      });
    },
    // 重置密码
    resetStaffPwd (index, row) {
      this.$confirm(`此操作将重置职工【${row.name}】的系统密码`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = {};
          let staffId = row.id;
          this.listLoading = true;
          putResetStaffPwd(param, staffId)
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
          this.$message1({
            type: "info",
            message: "已取消重置"
          });
        });
    },
    // 删除功能
    delectStaff (index, row) {
      this.$confirm("此操作将删除该职工", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.id;
          this.listLoading = true;
          deleteStaffData(param)
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
          this.$message1({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    //更换每页数量
    SizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    }
  }
};

</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";

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
}
</style>
