<template>
  <el-table :data="houseRel" border  stripe class="table" height="string" v-loading="listLoading">
    <el-table-column prop="staffName"  width="100" align="center" label="姓名"></el-table-column>
    <el-table-column prop="houseRel" width="80" align="center" label="关系"></el-table-column>
    <el-table-column prop="address" align="center" label="地址"></el-table-column>    
  </el-table>
</template>

<script type="text/ecmascript-6">
import { getStaffHouseRel } from "@/api/api";
export default {
  data() {
    return {
      // 住房关系填充
      houseRel: [],
      listLoading: false
    };
  },
  components: {},
  // 监听
  watch: {
    $route() {
      this.getList();
      //console.log(this.staffID);
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
    }
  }
};
</script>

<style scoped lang="scss">

</style>
