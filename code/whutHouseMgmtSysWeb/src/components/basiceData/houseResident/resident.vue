<template>
    <div class="third-container">
    <!-- 面包屑导航 -->      
    <div class="warp-breadcrum">   
               <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>住房登记</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 --> 
    <div class="warp-body">
      <!-- 工具栏 -->    
      <div class="toolbal">      
      </div>
      <!-- 信息区 --> 
      <div class="main-data">    
          <!-- 个人信息区 -->
          <div class="before-info">
              <div class="personal-info">
                  <el-table :data="personalInfo">
                    <el-table-column label=""></el-table-column>
                    <el-table-column label=""></el-table-column>                   
                  </el-table>
              </div>
          </div>
      </div>
    </div>
    </div>
</template>

<script type="text/ecmascript-6">
 export default {
   data() {
     return {
personalInfo:[]
     }

   },
   components: {

   }
 }
</script>

<style scoped lang="scss">
.main-data{
    display: flex;
    flex-direction: column;
    .before-info{
        display: flex;
        flex-direction: row;
        width: 100%;
        height: 30%;
        background-color: rgb(118, 129, 129);
    .personal-info{
        width: 40%;
        height: 100%;
        background-color: aquamarine;
    }}
}
 
</style>
