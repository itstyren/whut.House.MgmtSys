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
        <el-breadcrumb-item>部门</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
        <el-form :model="queryOption" :inline="true" :rules="queryRules" ref="queryForm">
            <el-form-item label="部门" prop="deptId">
              <el-select v-model="queryOption.deptId" :clearable="true" @clear="clearDept" placeholder="所有部门" style="width:200px" @change="selectDeptChange">
                <el-option v-for="dept in depData" :key="dept.id" :value="dept.id" :label="dept.label"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="姓名" prop="staff">  
              <el-select v-model="queryOption.staffId" :clearable="true" @clear="clearStaff" placeholder="全部职工" style="width:200px">
                <el-option v-for="staff in staffData" :key="staff.id" :value="staff.id" :label="staff.label"></el-option>
              </el-select>
            </el-form-item>
            <el-button type="primary" @click="queryData">查询</el-button>
          <el-form-item>
            <el-button type="primary" @click="addStaff()">新增员工</el-button>
          </el-form-item>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="deptStaffData" class="table" height="string" v-loading="listLoading">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="no" label="职工号" sortable align="center"></el-table-column>
          <el-table-column prop="name" label="姓名" sortable align="center"></el-table-column>
          <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
          <el-table-column prop="marriageState" label="婚姻状况" sortable align="center"></el-table-column>
          <el-table-column prop="postName" label="职称" sortable align="center"></el-table-column>
          <el-table-column prop="titleName" label="职务" sortable align="center"></el-table-column>
          <el-table-column prop="statusName" label="工作状态" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="300" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showDetailDialog(scope.$index,scope.row)">详情</el-button>
              <el-button type="success" size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="warning" size="small" @click="showModifyDialog(scope.$index,scope.row)">重置</el-button>             
              <el-button type="danger" size="small" @click="delectStaff(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getSingleDept, getStaff, deleteStaffData } from "@/api/api";
import { checkNum, checkNULL } from "@/assets/function/validator";
import common from "@/common/util.js";
import * as types from "../../../store/mutation-types";
export default {
  data() {
    return {
      // 表格数据
      deptStaffData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,
      //查询需要的数据
      staffData: [],
      queryStatus: 0, //0 代表列表查，1代表全部，2代表区域查，3代表楼栋查
      // 查询选项
      queryOption: {
        deptId: "",
        staffId: ""
      },
      // 查询表达验证规则
      queryRules: {
        deptId: {
          validator: checkNULL,
          trigger: "change"
        }
      }
    };
  },
  // 获取父组件传递的数据
  props: ["depData"],
  components: {},
  computed: {
    selectDept() {
      return this.queryOption.deptId;
    },
    addSelectRegion() {
      return this.addFormBody.deptId || this.detailData.deptId;
    }
  },
  // 监听
  watch: {
    // 监听选项的变动
    selectDept(newval) {
      for (var dept of this.depData) {
        if (dept.id == newval) this.staffData = dept.children;
      }
    },
    // 监听路由
    $route() {
      this.queryStatus = 0;
      this.getList();
    }
  },
  created() {
    this.getList();
  },
  // 方法集合
  methods: {
    //选择的区域变化时
    selectDeptChange(dept) {
      this.staffData = dept.buildingList;
    },
    // 清空搜索的区域时
    clearDept() {
      this.queryStatus = 1;
      this.queryOption.staffId = "";
    },
    // 清空搜索的楼栋时
    clearStaff() {
      this.queryStatus = 2;
    },

    // 判定查询的类型
    queryData() {
      this.$refs["queryForm"].validate(valid => {
        if (valid) {
          if (this.queryOption.deptId == "") {
            this.queryStatus = 1;
            //this.getList();
          } else if (this.queryOption.staffId == "") {
            this.queryStatus = 2;
            this.getList();
          } else {
            this.queryStatus = 3;
            this.getList();
          }
        }
      });
    },
    // 获取列表
    getList() {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      // 在这里判断执行哪种查询方法
      if (this.queryStatus == 0) {
        var switchFunction = getSingleDept;
        var queryID = this.$route.params.id;
      } else if (this.queryStatus == 1) var switchFunction = getHouse;
      else if (this.queryStatus == 2) {
        var switchFunction = getSingleDept;
        var queryID = this.queryOption.deptId;
      } else {
        var switchFunction = getStaff;
        var queryID = this.queryOption.staffId;
      }
      switchFunction(param, queryID)
        .then(res => {
          if (this.queryStatus == 3) {
            this.deptStaffData = [];
            this.deptStaffData[0] = res.data.data.data;
          } else this.deptStaffData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 显示详情页面
    showDetailDialog(index, row) {
      this.$store.commit(types.STAFF_DATA, row);
      this.$store.commit(types.STAFF_MODIFY, false);
      this.$router.push({
        path: `/basic/staff/byId/${row.id}`
      });
    },
    //切换到编辑
    showModifyDialog(index, row) {
      this.$store.commit(types.STAFF_DATA, row);
      this.$store.commit(types.STAFF_MODIFY, true);
      this.$router.push({
        path: `/basic/staff/byId/${row.id}`
      });
    },
    // 切换到新增页面
    addStaff(){
      this.$router.push({
        path: `/basic/staff/add`
      });
    },
    // 删除功能
    delectStaff(index, row) {
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
              common.statusinfo(this, res.data);
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
    //更换每页数量
    SizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    }
  }
};
</script>

<style scoped lang="scss">

</style>
