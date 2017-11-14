<template>
<el-row class="warp">
  <el-row>
  <el-col :span="24" class="warp-breadcrum">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }"><b>首页</b></el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>区域管理</el-breadcrumb-item>
      </el-breadcrumb>
  </el-col>
  </el-row>
 <!-- 下方主内容 -->
 <el-card>
  <el-col :span="24" class="warp-main">
    <!-- 工具栏 -->
    <el-col :span="24" class="toolBar" >    
      <el-form :inline="true" style="margin-bottom:15px">
        <el-button type="primary" @click="addFormVisible = true" >新增区域</el-button>
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
    <!-- 新增表单 -->
    <el-dialog title="新增区域" :visible.sync="addFormVisible" v-loading="submitLoading" width="35%">
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto style="padding-left: 10%;">
        <el-form-item label="区域名" prop="AccountID">
          <el-input v-model="addFormBody.AccountID" placeholder="请输入区域"  style="width:300px"  ></el-input>
        </el-form-item>  
        <el-form-item label="描述" prop="AccountName">
          <el-input  type="textarea" :autosize="{minRows:2,maxRows:4}" v-model="addFormBody.AccountName" placeholder="请输入描述"  style="width:300px" ></el-input>
        </el-form-item>       
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" >提交</el-button>
      </div>
    </el-dialog>  
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

       // 新增教师表单规则验证
       rules:{
         AccountID:[
           {required: true, message: '请输入账号' , trigger: 'blur'}
         ],
         AccountName:[
           {required: true, message: '请输入姓名' , trigger: 'blur' },
           {pattern: /^[\u4e00-\u9fa5]{1,6}$/,message:'请输入1-6位汉字',trigger:'blur'}
         ],
         Tel:[
           {required: true, message: '请输入电话' , trigger: 'blur' },
          {pattern: /^1\d{10}$/, message: '电话号码格式有误！', trigger: 'blur'}
           
         ]
         
       },

      // 新增表单相关数据
       submitLoading:false,       
       addFormVisible: false,
       addFormBody:{
         AccountName:'',
         AccountID:'',
         RoleID:'',
         OrgID:'',
         Tel:''
       },
     }

   },
   components: {

   },
   methods: {
    //更换每页数量
    SizeChangeEvent(val){
        this.loading=true;
        this.size = val;
        this.getList();
        PubMethod.logMessage(this.page + "   " + this.size);
    },
    //页码切换时
    CurrentChangeEvent(val){
        this.loading=true;
        this.page = val;
        this.getList();
        PubMethod.logMessage(this.page + "   " + this.size);
    }       
   }
 }
</script>

<style scoped lang="scss">

 
</style>
