<template>
  <el-table :data="houseRel" border stripe class="table" height="string" v-loading="listLoading"  @cell-click="cellClick">
    <el-table-column prop="address"  align="center" label="地址"></el-table-column>
    <el-table-column prop="houseRel" width="70" align="center" label="关系"></el-table-column>
    <el-table-column prop="layoutName"  width="80" align="center" label="住房类型"></el-table-column>
    <el-table-column prop="layoutName" width="80" align="center" label="户型"></el-table-column>
    <el-table-column prop="usedArea"  width="80" align="center" label="使用面积"></el-table-column>
    <el-table-column prop="bookTime"  width="100" align="center" label="时间"></el-table-column>

  </el-table>
</template>

<script type="text/ecmascript-6">
import { getStaff } from "@/api/basiceData";
export default {
  data() {
    return {
      listLoading: false
    };
  },
  computed: {
    houseRel() {
      return this.$store.state.fixHouselist;
    }
  },
  methods: {
    cellClick(row, column, cell, event) {
      let selectHouseName = `【${row.layoutName}】,【${row.layoutName}】,${
        row.address
      }`;
      let selectHouse = {
        name: selectHouseName,
        id: row.houseId
      };
      this.$emit("select-house", selectHouse);
    }
  }
};
</script>

<style scoped lang="scss">
.table {
  height: 100%;
}
</style>
