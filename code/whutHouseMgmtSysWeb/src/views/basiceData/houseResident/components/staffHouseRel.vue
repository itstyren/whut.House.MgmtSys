<template>
<div class="card" :style="{height:height,width:width}">
  <el-table :data="houseRel"  stripe class="table" height="string" v-loading="listLoading">
    <el-table-column prop="staffName" width="90" align="center" label="姓名"></el-table-column>
    <el-table-column prop="houseRel" width="70" align="center" label="关系">
      <template slot-scope="scope">
        <el-popover v-if="scope.row.houseRel=='购买'" trigger="hover" placement="top">
          <p>购房款: {{ scope.row.staffBuyAccount }}</p>
          <p>维修基金: {{ scope.row.staffFixFund }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium" type="info">{{ scope.row.houseRel }}</el-tag>
          </div>
        </el-popover>
        <el-tag size="medium" v-else type="success">{{ scope.row.houseRel }}</el-tag>
      </template>
    </el-table-column>
    <el-table-column prop="address" align="center" label="地址"></el-table-column>
    <el-table-column label="操作" width="180" align="center">
      <template slot-scope="scope">
        <el-button type="warning" size="mini" @click="removeLog(scope.$index,scope.row)">解除</el-button>
        <el-button type="danger" size="mini" @click="deleteLog(scope.$index,scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getStaffHouseRel,
  removeResidentLog,
  deleteResidentLog
} from "@/api/basiceData";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      // 住房关系填充
      houseRel: [],
      listLoading: false
    };
  },
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "350px"
    },
        staffId: {
      type: Number
    }
  },
  computed: {
    isResident() {
      return this.$store.state.residentSuccess;
    }
  },
  // 监听
  watch: {
    staffId(newVal) {
      this.getList();
    },
    isResident() {
      this.getList();
    }
  },
  methods: {
    // 获取单一员工
    getList() {
      this.personalInfo = [];
      this.listLoading = true;
      let param = {};
      let staffID = this.staffId;
      getStaffHouseRel(param, staffID)
        .then(res => {
          this.houseRel = res.data.data.data;
          res.data.data.outSchoolHouse.forEach(item => {
            this.houseRel.push(item);
          });
          // this.houseRel.concat(res.data.data.outSchoolHouse)
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
    }
  }
};
</script>

<style scoped lang="scss">
.card{
  padding: 3px;
}
</style>
