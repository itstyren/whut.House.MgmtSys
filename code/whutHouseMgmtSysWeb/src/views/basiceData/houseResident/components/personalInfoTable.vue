<template >
<div class="card" :style="{height:height,width:width}">
  <el-table :data="personalInfo"   stripe   class="table" height="string" v-loading="listLoading">
    <el-table-column prop="index"   align="center" label="信息项"></el-table-column>
    <el-table-column prop="value"   align="center" label="信息值"></el-table-column>
  </el-table>
  </div>
</template>

<script type="text/ecmascript-6">
import { getStaff } from "@/api/basiceData";
export default {
  data() {
    return {
      personalInfo: [],
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
    }
  },
  // 监听
  watch: {
    $route() {
      this.getList();
      //console.log(this.staffID);
    }
  },
  created() {
    if (this.$route.params.id != undefined) this.getList();
  },
  methods: {
    // 获取单一员工
    getList() {
      this.personalInfo = [];
      this.listLoading = true;
      let param = {};
      var staffID = this.$route.params.id;
      getStaff(param, staffID)
        .then(res => {
          let resData = res.data.data.data;
          // console.log(resData);
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
          //console.log(this.personalInfo)
          this.deptStaffData = res.data.data.data;
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

</style>
