<template>
<div>
<!-- 右侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic" ><h1>租金选项设置</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >

  </el-col>
  <!-- 表格区域 -->
  <el-card  class="rentalCard">
      <div slot="header">
          <span>当前设置</span>
          <el-button type="text"style="float:right; padding:3px 0">点击设置</el-button>
      </div>
      <el-table :data="rentalData"  style="width:100%" v-loading="listLoading" max-height="450">
        <el-table-column label="参数名" prop="param" align="center"></el-table-column>
        <el-table-column label="参数值" prop="paramVal" align="center"></el-table-column>
      </el-table>
  </el-card>
</el-col>
</div>
</template>

<script type="text/ecmascript-6">

export default {
   data() {
     return {
         rentalData:[
             {
                 param:'新老职工时间分界点',
                 paramVal:'2'
             },
             {
                 param:'老职工优惠比例',
                 paramVal:'32'
             },
             {
                 param:'老职工优惠比例',
                 paramVal:'32'
             }, 
             {
                 param:'新职工优惠比例',
                 paramVal:'32'
             },
             ]
     }
   },
   mounted () {
   },
   methods:{
   }
 }
</script>

<style scoped lang="scss">
.rentalCard{
    width: 80%;
    height: 400px;
    margin: 100px auto;
    padding: 200px auto;

.rentalCard-text{
    margin: 10px 50px;
}}
</style>
