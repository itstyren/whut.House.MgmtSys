<template>
  <div class="staffForm-filter card"
       v-loading="listLoading">
    <el-form :model="queryForm"
             label-width="80px">
      <el-row>
        <el-col :span="4">
          <el-form-item label="职工部门">
            <el-select v-model="queryForm.deptId"
                       size="small"
                       :clearable="true"
                       placeholder="全部部门">
              <el-option v-for="v in staffDept"
                         :key="v.staffParamId"
                         style="text-align:center"
                         :value="v.staffParamId"
                         :label="v.staffParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="3">
          <el-form-item label="职工职务">
            <el-select v-model="queryForm.postId"
                       size="small"
                       :clearable="true"
                       placeholder="全部职务">
              <el-option v-for="v in staffPost"
                         :key="v.staffParamId"
                         style="text-align:center"
                         :value="v.staffParamId"
                         :label="v.staffParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="职工职称">
            <el-select v-model="queryForm.titleId"
                       size="small"
                       :clearable="true"
                       placeholder="全部职称">
              <el-option v-for="v in staffTitle"
                         :key="v.staffParamId"
                         :value="v.staffParamId"
                         :label="v.staffParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="3">
          <el-form-item label="职工类别">
            <el-select v-model="queryForm.typeId"
                       size="small"
                       :clearable="true"
                       placeholder="全部类别">
              <el-option v-for="v in staffType"
                         :key="v.staffParamId"
                         style="text-align:center"
                         :value="v.staffParamId"
                         :label="v.staffParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="起止时间">
            <el-row>
              <el-col :span="10">
                <el-date-picker v-model="tempData.yearStart"
                                type="year"
                                size="small"
                                align="center"
                                placeholder="起始"
                                value-format="yyyy-MM-dd"></el-date-picker>
              </el-col>
              <el-col style=" text-align: center;"
                      :span="4">
                <span>至</span>
              </el-col>
              <el-col :span="10">
                <el-date-picker v-model="tempData.yearEnd"
                                type="year"
                                size="small"
                                align="center"
                                placeholder="终止"
                                value-format="yyyy-MM-dd"></el-date-picker>
              </el-col>
            </el-row>
          </el-form-item>
        </el-col>
        <el-col :span="4"
                class="horizontalCenter">
          <el-button type="danger"
                     size="small"
                     @click="resseting">重置</el-button>
          <el-button type="primary"
                     size="small"
                     @click="queryHandle">查询</el-button>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getStaffParam
} from "@/api/sysManage";
export default {
  data () {
    return {
      queryForm: {},
      listLoading: false,
      staffDept: [],
      staffPost: [],
      staffTitle: [],
      staffType: [],
      tempData: {}
    };
  },
  created () {
    this.initalGet();
  },
  methods: {
    initalGet () {
      this.listLoading = true;
      let params = {
        page: 1,
        size: 999
      };
      getStaffParam(params, 5).then(res => {
        this.staffDept = res.data.data.data.list;
        this.listLoading = false;
      });
      getStaffParam(params, 6).then(res => {
        this.staffPost = res.data.data.data.list;
        this.listLoading = false;
      });
      getStaffParam(params, 7).then(res => {
        this.staffTitle = res.data.data.data.list;
        this.listLoading = false;
      });
      getStaffParam(params, 8).then(res => {
        this.staffType = res.data.data.data.list;
        this.listLoading = false;
      });
    },
    queryHandle () {
      let tempData = this.tempData;
      if (
        tempData.hasOwnProperty("startTime") &&
        tempData.hasOwnProperty("endTime")
      ) {
        this.queryForm.timeRange = {
          endTime: tempData.endTime,
          startTime: tempData.startTime
        };
      }
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") {
          delete this.queryForm[v];
        }
      }
      const data = Object.assign({}, this.queryForm);
      this.$emit("query-staff", data);
    },
    // 重置查询表单
    resseting () {
      this.queryForm = {};
    }
  }
};

</script>

<style scoped lang="scss">
.card {
  padding: 10px;
}

.staffForm-filter {
  .el-form-item {
    margin-bottom: 5px;
  }
}
.horizontalCenter {
  display: flex;
  justify-content: center;
}
</style>
