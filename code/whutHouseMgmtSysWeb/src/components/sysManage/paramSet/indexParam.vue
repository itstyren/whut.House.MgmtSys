<template>
<el-row >
  <el-col :span="24" class="warp-breadcrum">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }"><b>首页</b></el-breadcrumb-item>
        <el-breadcrumb-item>系统管理</el-breadcrumb-item>
        <el-breadcrumb-item>参数设置</el-breadcrumb-item>
      </el-breadcrumb>
  </el-col>
  <!-- 下方搜索框 -->
  <el-row>
    <el-col :span="6">
      <el-form :inline="true" style="margin-bottom:15px">
        <el-input placeholder="输入参数关键词" v-model="filterText" icon="search"></el-input>
        </el-form>
    </el-col>
  </el-row>
  <!-- 主体内容区域 -->
  <el-row type="flex">
    <el-col :span="6">
      <el-tree :data="paramData" :props="props"></el-tree>
      </el-col>
  </el-row>
</el-row>
</template>

<script type="text/ecmascript-6">
 export default {
    watch: {
      filterText(val) {
        this.$refs.tree2.filter(val);
      }
    },
   data() {
     return {
       filterText:'',
       paramData:[
         {
           label:'1',
           children:[{
             label:'2',
             children:{
               label:'3'
             }
           }]
         }
       ],
       props:{
         children: 'children',
         label: 'label'
        }
     }

   },
   components: {

   }
 }
</script>

<style scoped lang="scss">

 
</style>
