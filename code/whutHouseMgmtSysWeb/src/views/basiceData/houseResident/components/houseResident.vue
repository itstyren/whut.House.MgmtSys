<template>
  <div class="components card" v-loading="listLoading" :style="{height:height,width:width}">
    <el-form :model="residentForm" label-width="120px" :rules="rules" ref="residentForm">
      <el-row  type="flex" justify="center" align="middle" >
        <el-col :span="6" >
          <el-form-item label="职工姓名" prop="staffId">
            <el-input v-model="residentForm.staffId"  size="small" :readonly="true"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="11">
          <el-form-item label="住房地址" prop="houseId">
            <el-input v-model="residentForm.houseId"  size="small" placeholder="请选择" :readonly="true">
              <el-button slot="append" icon="el-icon-search" @click="dialogVisible"></el-button>
            </el-input>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row type="flex" justify="center" align="middle" >
        <el-col :span="6" >
          <el-form-item label="房屋关系" class="from-label"  prop="houseRel">
            <el-select v-model="residentForm.houseRel"  size="small" placeholder="请选择">
              <el-option v-for="status in statusData" :key="status.houseParamId" :value="status.houseParamId" :label="status.houseParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="登记时间" class="from-label" prop="bookTime">
            <el-date-picker v-model="residentForm.bookTime" size="small" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="2" :offset="2">
            <el-button style="margin-bottom:10px"  size="small" @click="resetForm">重置</el-button>
        </el-col>            
            <el-col :span="1" >
            <el-button style="margin-bottom:10px" type="primary" size="small" @click="houseResident">登记</el-button>
            </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
import { putHouseRegister } from "@/api/basiceData";
import { getHouseParam } from "@/api/sysManage";
import * as types from "@/store/mutation-types";
import utils from "@/utils/index.js";
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
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "350px"
    },
    selectHouse:{
      type:String
    },
    selectHouseId:{
type:Number
    }
  },
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
          let array = [];
          for (const status of this.statusData) {
            array.push(status.houseParamName);
          }
          let flag = utils.arrayindexOf(array, "空闲");
          this.statusData.splice(flag, 1);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 重置
    resetForm() {
      this.residentForm = {};
      this.residentForm.staffId = this.$store.state.residentStaffData.label;
    },
    // 住房登记提交
    houseResident() {
      this.$refs["residentForm"].validate(valid => {
        if (valid) {
          let staffName = this.residentForm.staffId;
          this.$confirm(`此操作将登记职工【${staffName}】的住房关系`, "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          })
            .then(() => {
              let param = {
                bookTime: this.residentForm.bookTime,
                house: this.selectHouseId,
                houseRel: this.residentForm.houseRel,
                staffId: this.$store.state.residentStaffData.id
              };
              this.listLoading = true;
              putHouseRegister(param)
                .then(res => {
                  // 公共提示方法
                  utils.statusinfo(this, res.data);
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
    },
    dialogVisible() {
      this.$store.dispatch("setSeachHouse", true);
    }
  }
};
</script>

<style scoped lang="scss">
.components {
  padding-top: 10px;
  .el-form-item {
    margin-bottom: 10px;
  }
}
</style>
