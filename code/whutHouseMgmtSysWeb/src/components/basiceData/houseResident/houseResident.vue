<template>
  <div class="components">
    <div class="form-feader">
      <span>房屋登记</span>
    </div>
    <div class="from-body">
    <el-form :model="residentFrom" inline>
      <div class="row">
        <el-form-item label="职工">
          <el-input v-model="residentFrom.staffName" :readonly="true"></el-input>
        </el-form-item>
        <el-form-item label="关系" class="from-label">
          <el-select v-model="residentFrom.houseRel" placeholder="请选择房屋关系">
            <el-option v-for="status in statusData" :key="status.houseParamId" :value="status.houseParamId" :label="status.houseParamName"></el-option>
          </el-select>
        </el-form-item>

      </div>
      <div class="row">
        <el-form-item label="住房">
          <el-input v-model="residentFrom.staffId" placeholder="请选择" :disabled="false"></el-input>
        </el-form-item>

        <el-form-item label="时间" class="from-label">
          <el-date-picker v-model="residentFrom.joinTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
        <el-form-item>
          <el-button type="">重置</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="">登记</el-button>
        </el-form-item>
      </div>
    </el-form>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getHouseParam } from "@/api/api";
export default {
  data() {
    return {
      // 提交表单的数据
      residentFrom: {
        staffName: ""
      },
      // 表格数据
      statusData: [],
      listLoading: false
    };
  },
  components: {},
  // 监听
  watch: {
    $route() {
      this.getStaffName();
    }
  },
  created() {
    this.getStaffName();
    this.getList();
  },
  methods: {
    getStaffName() {
      //console.log(this.$store.state.residentStaffData.label);
      this.residentFrom.staffName = this.$store.state.residentStaffData.label;
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
  .form-feader {
    width: 20%;
    display: flex;
    align-items: center;
    justify-content: space-around;
    .span {
      font-family: "Helvetica Neue", Helvetica, Arial, "PingFang SC", "Hiragino Sans GB", "Heiti SC", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
    }
  }
  .from-body {
    position: relative;
    display: flex;
    flex-direction: column;
    flex: 1;
    //flex: 1;
    .row {
      display: flex;
      justify-content: left;
      .from-label {
        margin-left: 50px;
      }
    }
  }
}
</style>
