<template>
  <div class="components" v-loading="listLoading">
    <div class="form-header">
      <span>住房登记</span>
    </div>
    <div class="from-body">
      <el-form :model="residentForm" inline :rules="rules" ref="residentForm">
        <div class="row">
          <el-form-item label="职工" prop="staffId">
            <el-input v-model="residentForm.staffId" style="width:200px"  :readonly="true"></el-input>
          </el-form-item>
          <el-form-item label="住房" prop="houseId">
            <el-input v-model="residentForm.houseId" style="width:470px"  placeholder="请选择" :readonly="true"></el-input>
          </el-form-item>
        </div>
        <div class="row">
          <el-form-item label="关系" class="from-label" prop="houseRel">
            <el-select v-model="residentForm.houseRel" style="width:200px"  placeholder="请选择">
              <el-option v-for="status in statusData" :key="status.houseParamId" :value="status.houseParamId" :label="status.houseParamName"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="时间" class="from-label" prop="bookTime">
            <el-date-picker v-model="residentForm.bookTime" style="width:200px"  placeholder="请选择日期" format="yyyy-MM-dd"
              value-format="yyyy-MM-dd"></el-date-picker>
          </el-form-item>
          <el-form-item>
            <el-button type="" >重置</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="houseResident" >登记</el-button>
          </el-form-item>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getHouseParam, putHouseRegister } from "@/api/api";
import * as types from "../../../store/mutation-types";
import common from "@/common/util.js";
export default {
  data() {
    return {
      // 提交表单的数据
      residentForm: {
        houseId: "",
        staffId: ""
      },
      // 表格数据
      statusData: [],
      listLoading: false,
      // 验证规则
      rules: {
        staffId: {
          required: true,
          message: "请选择职工"
        },
        houseId: {
          required: true,
          message: "请选择住房"
        },
        houseRel: {
          required: true,
          message: "请选择关系"
        },
        bookTime: {
          required: true,
          message: "请登记日期"
        }
      }
    };
  },
  // 获取父组件传递的数据
  props: ["selectHouse", "selectHouseId"],
  components: {},
  // 监听
  watch: {
    $route() {
      this.getStaffName();
    },
    selectHouse(newVal) {
      this.residentForm.houseId = newVal;
    }
  },
  created() {
    this.getStaffName();
    this.getList();
  },
  methods: {
    getStaffName() {
      //console.log(this.$store.state.residentStaffData.label);
      this.residentForm.staffId = this.$store.state.residentStaffData.label;
    },
    // 获取房屋状态
    getList() {
      this.listLoading = true;
      let param = {};
      // http请求
      getHouseParam(param, 3)
        .then(res => {
          this.statusData = res.data.data.data.list;
          //console.log(this.statusData);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 住房登记提交
    houseResident() {
      this.$refs["residentForm"].validate(valid => {
        if (valid) {
          let staffName = this.residentForm.staffId;
          this.residentForm.houseId = this.selectHouseId;
          this.residentForm.staffId = this.$store.state.residentStaffData.id;
          this.$confirm(`此操作将登记职工【${staffName}】的住房关系`, "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          })
            .then(() => {
              let param = this.residentForm;
              this.listLoading = true;
              putHouseRegister(param)
                .then(res => {
                  // 公共提示方法
                  common.statusinfo(this, res.data);
                  this.listLoading = false;
                  this.$store.commit(types.RESIDENT_SUCCESS);
                  this.$refs["residentForm"].resetFields();
                })
                .catch(err => {
                  console.log(err);
                });
            })
            .catch(() => {
              this.$message({
                type: "info",
                message: "已取消登记"
              });
            });
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
.components {
  position: absolute;
  top: 10px;
  left: 20px;
  right: 20px;
  bottom: 25px;
  display: flex;
  flex-direction: row;
  .form-header {
    width: 20%;
    display: flex;
    align-items: center;
    justify-content: space-around;
    .span {
      font-family: "Helvetica Neue", Helvetica, Arial, "PingFang SC",
        "Hiragino Sans GB", "Heiti SC", "Microsoft YaHei", "WenQuanYi Micro Hei",
        sans-serif;
    }
  }
  .from-body {
    position: relative;
    display: flex;
    flex-direction: column;
    flex: 1; //flex: 1;
    padding-left: 0%;
    .row {
      display: flex;
      justify-content: left;
      .el-form-item {
        //margin-bottom: px;
        margin-left: 20px;
      }
      .from-label {
      }
    }
  }
}
</style>
