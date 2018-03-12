<template>
<div>
                  <el-popover ref="exportPopover" placement="bottom-start" v-model="exportVisible" title="导出文件" width="200" trigger="click">
                    <el-radio v-model="exportType" label=1>当前页</el-radio>
                    <el-radio v-model="exportType" label=2>全部页</el-radio>
                    <div style="text-align: right; margin-top: 5px">
                      <el-button size="mini" type="text" @click="exportVisible = false">取消</el-button>
                      <el-button type="primary" size="mini" @click="exportHandle">确定</el-button>
                    </div>
                  </el-popover>
                   <el-button type="primary" v-popover:exportPopover :loading="downloadLoading">导出</el-button>
                   </div>
</template>

<script>
export default {
  name: "export-popover",
  data () {
      return {
          exportVisible:false,
          exportType:'1',
      }
  },
  props: {
downloadLoading:{
          type: Boolean,
      default: false
}
  },
  methods: {
      exportHandle(){
          this.$emit("export",this.exportType)
      }
  }
};
</script>

<style scoped>

</style>
