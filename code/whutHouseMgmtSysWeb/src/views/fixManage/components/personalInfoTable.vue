<template>
  <el-table :data="personalInfo" border  stripe class="table" height="string" v-loading="listLoading">
    <el-table-column prop="index"  align="center" label="信息项"></el-table-column>
    <el-table-column prop="value"  align="center" label="信息值"></el-table-column>
  </el-table>
</template>

<script type="text/ecmascript-6">
import { getStaff } from "@/api/basiceData";
import { getFixStaffById, getFixStaffByName } from "@/api/fixManage";
import utils from "@/utils/index.js";
import * as types from "../../../store/mutation-types";
export default {
  data() {
    return {
      personalInfo: [],
      listLoading: false
    };
  },
  // 传递的属性
  props: {
    queryData: {
      type: Object
    }
  },
  // 监听
  watch: {
    queryData: {
      handler: function(queryData) {
        this.getStaff(queryData.param, queryData.type);
      },
      deep: true
    }
  },
  methods: {
    // 根据id或姓名获取职工信息
    // 0代表id查，1代表姓名查
    getStaff(param, type) {
      if (type == 0) var getMethod = getFixStaffById;
      else {
        var getMethod = getFixStaffByName;
        param = encodeURI(param);
        param = encodeURI(param);
      }
      this.personalInfo = [];
      this.listLoading = true;
      getMethod(param)
        .then(res => {
          if (res.data.status != "error") {
            let resData = res.data.data.data;
            this.$store.commit(types.FIX_GETHOUSE, resData.houseList);
            utils.statusinfo(this, res.data);
            this.personalInfo.push(
              {
                index: "姓名",
                value: resData.name
              },
              {
                index: "职工编号",
                value: resData.no
              },
              {
                index: "性别",
                value: resData.sex
              },
              {
                index: "婚姻状况",
                value: resData.marriageState
              },
              {
                index: "职称",
                value: resData.titleName
              },
              {
                index: "职务",
                value: resData.postName
              },
              {
                index: "职工类别",
                value: resData.typeName
              },
              {
                index: "工作状态",
                value: resData.statusName
              },
              {
                index: "工作部门",
                value: resData.deptName
              },
              {
                index: "联系电话",
                value: resData.tel
              },
              {
                index: "配偶姓名",
                value: resData.spouseName
              },
              {
                index: "配偶职称",
                value: resData.spouseTitleName
              },
              {
                index: "配偶职务",
                value: resData.spousePostName
              }
            );
            this.listLoading = false;
                    let selectStaff={
                      name:resData.name,
                      id:resData.staffId
                    }
        this.$emit('select-staff',selectStaff)
          } else {
            utils.statusinfo(this, res.data);
            this.listLoading = false;
          }
        }

        )
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style scoped lang="scss">

</style>
