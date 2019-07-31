<template>
  <div class="card"
       :style="{height:height,width:width}">
    <el-table :data="houseRel"
              stripe
              class="table"
              height="string"
              @cell-click="handleClikHouse"
              v-loading="listLoading">
      <el-table-column prop="staffName"
                       width="100"
                       align="center"
                       label="姓名"></el-table-column>
      <el-table-column prop="houseRel"
                       width="100"
                       align="center"
                       label="关系">
        <template slot-scope="scope">
          <el-popover v-if="scope.row.houseRel=='购买'"
                      trigger="hover"
                      placement="top">
            <p>购房款: {{ scope.row.staffBuyAccount }}</p>
            <p>维修基金: {{ scope.row.staffFixFund }}</p>
            <div slot="reference"
                 class="name-wrapper">
              <el-tag size="medium"
                      type="info">{{ scope.row.houseRel }}</el-tag>
            </div>
          </el-popover>
          <el-tag size="medium"
                  v-else
                  type="success">{{ scope.row.houseRel }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column prop="address"
                       align="center"
                       class-name="address-cursor"
                       label="地址">
      </el-table-column>
      <el-table-column label="操作"
                       width="180"
                       align="center">
        <template slot-scope="scope">
          <el-button type="warning"
                     size="mini"
                     @click="removeLog(scope.$index,scope.row)">解除</el-button>
          <!-- <el-button type="danger" size="mini" @click="deleteLog(scope.$index,scope.row)">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>
    <house-detail-dialog :show.sync="showDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>

</template>

<script type="text/ecmascript-6">
import {
  getStaffHouseRel,
  removeResidentLog,
  getOneHouseData
} from "@/api/basiceData";
import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'
export default {
  components: {
    HouseDetailDialog
  },
  data () {
    return {
      // 住房关系填充
      houseRel: [],
      listLoading: false,
      houseId: 0,
      showDialog: false
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
    isResident () {
      return this.$store.state.residentSuccess;
    }
  },
  // 监听
  watch: {
    staffId (newVal) {
      this.getList();
    },
    isResident () {
      this.getList();
    }
  },
  methods: {
    // 获取单一员工
    getList () {
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
    removeLog (index, row) {
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
              this.$emit("remove-resident-success")
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消解除"
          });
        });
      setTimeout(() => {
        this.listLoading = false;
      }, 0)
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
.card {
  padding: 3px;
}
</style>
