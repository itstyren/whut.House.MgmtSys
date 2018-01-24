<template>
  <div class="components">
    <el-form :model="residentFrom" inline>

      <div class="row">
        <el-form-item label="职工">
          <el-input v-model="residentFrom.staffName" :readonly="true"></el-input>
        </el-form-item>
        <el-form-item label="住房">
          <el-input v-model="residentFrom.staffId" placeholder="请选择" disabled="false"></el-input>
        </el-form-item>
      </div>
    </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data() {
      return {
        residentFrom
      };
    },
    components: {}
  };

</script>

<style scoped lang="scss">


</style>
