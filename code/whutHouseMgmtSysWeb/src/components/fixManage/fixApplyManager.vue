<template>
  <div class="second-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修申请管理</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbal">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-table :data="fixFormData" class="table" height="string" v-loading="listLoading">
              <el-table-column type="selection" width="55"></el-table-column>
              <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
              <el-table-column prop="fixContentName" label="维修类型" sortable align="center"></el-table-column>
              <el-table-column prop="applyTime" label="申请时间"  sortable align="center"></el-table-column>
              <el-table-column prop="acceptState" label="受理状态"  align="center"></el-table-column>
              <el-table-column prop="staffName" label="申请人"  align="center"></el-table-column>
              <el-table-column prop="postName" label="职称"  align="center"></el-table-column>
              <el-table-column prop="titleName" label="职务"  align="center"></el-table-column>
              <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
              <el-table-column label="操作" width="250" align="center">
                <template slot-scope="scope">
                  <el-button type="infor" size="small" @click="ReAccept(scope.$index,scope.row)">重受理</el-button>
                  <el-button type="primary" size="small" @click="ReAgree(scope.$index,scope.row)">重审核</el-button>
                  <el-button type="danger" size="small" @click="delectFixForm(scope.$index,scope.row)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
          <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
            :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getFixForm, getReAccept, getReAgree } from "@/api/api";
import common from "@/common/util.js";

export default {
  data() {
    return {
      //表格需要的
      fixFormData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10
    };
  },
  created() {
    this.getList();
  },
  components: {},
  methods: {
    // 获取列表
    getList() {
      this.listLoading = true;
      let param = {
        // page: this.page,
        // size: this.size
      };
      getFixForm(param)
        .then(res => {
          // console.log(res.data.data)
          this.fixFormData = res.data.data.data;
          //this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 表单重新受理
    ReAccept(index, row) {
      this.$confirm("此操作将对该表单重受理", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.id;
          this.listLoading = true;
          getReAccept(param)
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
            message: "已取消操作"
          });
        });
    },
    // 表单重新审核
    ReAgree(index, row) {
      this.$confirm("此操作将对该表单重审核", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.id;
          this.listLoading = true;
          getReAgree(param)
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
            message: "已取消操作"
          });
        });
    },
    delectFixForm(index, row) {},
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
