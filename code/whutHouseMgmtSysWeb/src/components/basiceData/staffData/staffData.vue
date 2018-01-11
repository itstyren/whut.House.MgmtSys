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
  import {
    getSingleDept,
    deleteStaffData
  } from "@/api/api";
  import common from "@/common/util.js";
  export default {
    data() {
      return {
        // 表格数据
        deptStaffData: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10
      };
    },
    components: {},
    // 监听
    watch: {
      $route: "getList"
    },
    created() {
      this.getList();
    },
    methods: {
      // 获取列表
      getList() {
        this.listLoading = true;
        let param = {
          page: this.page,
          size: this.size
        };
        let staffID = this.$route.params.id;
        getSingleDept(param, staffID)
          .then(res => {
            this.deptStaffData = res.data.data.data;
            this.totalNum = res.data.data.data.total;
            // console.log(res.data.data.list)
            this.listLoading = false;
          })
          .catch(err => {
            console.log(err);
          });
      },
      // 显示详情页面
      showDetailDialog(index, row) {},
      //显示编辑
      showModifyDialog(index, row) {},
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
