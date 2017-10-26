<template>
<!-- 左侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic"><h1>住房类型参数</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >    
    <el-form :inline="true" style="margin-bottom:15px">
      <el-button type="primary" @click="addFormVisible = true" >新增类型</el-button>
    </el-form>
  </el-col>
  <!-- 表格区域 -->
  <el-col :span="24">
    <el-table :data="typeData" border style="width:100%" v-loading="listLoading">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
      <el-table-column prop="houseType" label="住房类型" sortable align="center" ></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope" >
            <el-button  size="small" >编辑</el-button>
            <el-button type="danger" size="small"  >删除</el-button>
          </template>
        </el-table-column>      
    </el-table>
  </el-col>
</el-col>
</template>

<script type="text/ecmascript-6">
 export default {
   data() {
     return {
       // 用户令牌
       access_token:'',
       // 表格数据
       typeData: [
         {houseType:'任天宇的南4'}
       ],
       listLoading:false,

       //编辑表单相关数据
       modifyFormVisible:false,
       modifyLoading:false,
     }

   },
   components: {

   },
   methods:{
     //显示编辑
     showModifyDialog (index,row) {

       },

    //删除功能
    delectType(){

    }

   }
 }
</script>

<style scoped lang="scss">

 
</style>
