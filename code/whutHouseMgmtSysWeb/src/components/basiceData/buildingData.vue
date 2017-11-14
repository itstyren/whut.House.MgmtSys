<template>
<el-row class="warp">
  <el-row>
  <el-col :span="24" class="warp-breadcrum">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }"><b>首页</b></el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>楼栋管理</el-breadcrumb-item>
      </el-breadcrumb>
  </el-col>
  <el-card>
  <el-col :span="24" class="warp-main">
    <!-- 工具栏 -->
    <el-col :span="24" class="toolBar" >    
      <el-form :inline="true" style="margin-bottom:15px">
          <el-select v-model="selectRegion" placeholder="请选择区域">
            <el-option v-for="region of regionData" :key="region.id"></el-option>
          </el-select>
        <el-button type="primary" @click="addFormVisible = true" style="margin-left:20px;" >新增区域楼栋</el-button>
      </el-form>
    </el-col>
    <!-- 表格区 -->
    <el-col :span="24">
      <el-table  :data="regionData"  style="width:100%" v-loading="listLoading" > 
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
        <el-table-column prop="AccountName" label="区域" sortable align="center" ></el-table-column>
        <el-table-column prop="OrgName" label="描述" sortable align="center" ></el-table-column>
        <el-table-column label="操作" width="300" align="center">
          <template slot-scope="scope">
            <el-button  size="small" @click="showModifyDialog(scope.$index,scope.row)" >编辑</el-button>
            <el-button type="danger" size="small"  @click="delectAccTch(scope.$index,scope.row)" >删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-col>
    <!-- 下方工具条 -->
    <el-col :span="24">
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent" :page-size="size" :page-sizes="[10,15,20,25,30]":total="totalNum">
      </el-pagination>
    </el-col> 
  </el-col>      
  </el-card>
  </el-row>
</el-row>
</template>

<script type="text/ecmascript-6">
 export default {
   data() {
     return {
       // 表格数据
       regionData: [],
       listLoading:false,

       selectRowIndex:'',
       totalNum:0,
       page:1,
       size:10,
       //已选择的区域id
       selectRegion:'',
     }

   },
   components: {

   }
 }
</script>

<style scoped lang="scss">

 
</style>
