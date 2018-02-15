<template>
  <el-table :data="houseRel" border stripe class="table" height="string" v-loading="listLoading">
    <el-table-column prop="staffName" width="90" align="center" label="姓名"></el-table-column>
    <el-table-column prop="houseRel" width="70" align="center" label="关系"></el-table-column>
    <el-table-column prop="address" align="center" label="地址"></el-table-column>
    <el-table-column label="操作" width="180" align="center">
      <template slot-scope="scope">
        <el-button type="warning" size="mini" @click="removeLog(scope.$index,scope.row)">解除</el-button>
        <el-button type="danger" size="mini"  @click="deleteLog(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script type="text/ecmascript-6">
import {
  getStaffHouseRel,
  removeResidentLog,
  deleteResidentLog
} from "@/api/api";
import common from "@/common/util.js";
export default {
  data() {
    return {
      // 住房关系填充
      houseRel: [],
      listLoading: false
    };
  },
  components: {},
  computed: {
    isResident() {
      return this.$store.state.residentSuccess;
    }
  },
  // 监听
  watch: {
    $route() {
      this.getList();
      //console.log(this.staffID);
    },
    isResident() {
      this.getList();
    }
  },
  created() {
    this.getList();
  },
  methods: {
    // 获取单一员工
    getList() {
      this.personalInfo = [];
      this.listLoading = true;
      let param = {};
      let staffID = this.$route.params.id;
      getStaffHouseRel(staffID, param)
        .then(res => {
          this.houseRel = res.data.data.data;
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 解除关系
    removeLog(index, row) {
      this.$confirm("此操作将解除该关系", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.residentId;
          this.listLoading = true;
          removeResidentLog(param)
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
    // 删除关系
    deleteLog(index, row) {
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
    }
  }
};
</script>

<style scoped lang="scss">

</style>
