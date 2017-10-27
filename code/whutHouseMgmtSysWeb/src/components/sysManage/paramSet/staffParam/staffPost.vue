<template>
<div>
<!-- 右侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic"><h1>职务参数</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >    
    <el-form :inline="true" style="margin-bottom:15px">
      <el-button type="primary" @click="addFormVisible = true" >新增职务</el-button>
    </el-form>
  </el-col>
  <!-- 表格区域 -->
  <el-col :span="24">
    <el-table :data="typeData" border style="width:100%" v-loading="listLoading">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
      <el-table-column prop="staffPost" label="职务名" sortable align="center" ></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope" >
            <el-button  size="small" @click="showModifyDialog(scope.$index,scope.row)" >编辑</el-button>
            <el-button type="danger" size="small"  >删除</el-button>
          </template>
        </el-table-column>      
    </el-table>
  </el-col>
  <!-- 下方工具条 -->
  <el-col :span="24" >
    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent" :page-size="size" :page-sizes="[10,15,20,25,30]":total="totalNum" >
    </el-pagination>
  </el-col>
</el-col>
    <!-- 新增表单 -->
    <el-dialog title="新增职务名称" :visible.sync="addFormVisible" v-loading="submitLoading" >
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto>
        <el-form-item label="职务名称" prop="staffPost">
          <el-input v-model="addFormBody.staffPost" placeholder="请输入职务名称"  ></el-input>
        </el-form-item>     
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" >提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑职务名称" :visible.sync="modifyFormVisible" v-loading="modifyLoading">
      <el-form :model="modifyFromBody" label-width="80px" ref="modifyFrom" :rules="rules" >
        <el-form-item label="职务名称" prop="staffPost"  >
          <el-input v-model="modifyFromBody.staffPost" placeholder="请输入职务名称"  ></el-input>
        </el-form-item>   
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" modifyFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="modifySubmit" >提交</el-button>
      </div>     
    </el-dialog>
</div>
</template>

<script type="text/ecmascript-6">
export default {
   data() {
     return {
       // 用户令牌
       access_token:'',
       // 表格数据
       typeData: [
         {staffPost:'图书馆爸爸'}
       ],
       listLoading:false,
       totalNum:1,
       page:1,
       size:10,

       // 表单规则验证
       rules:{
         staffPost:{
           required: true, message: '职务名称不能为空' , trigger: 'blur' 
         },
       },

       //编辑表单相关数据
       modifyFormVisible:false,
       modifyLoading:false,
       modifyFromBody:{
         staffPost:''
       },
      
      // 新增表单相关数据
       submitLoading:false,       
       addFormVisible: false,
       addFormBody:{
         staffPost:''
       }
     }

   },
   components: {

   },
   methods:{
    //删除功能
    delectType(){

    },
    // 新增提交
    addSubmit(){

    },
    //显示编辑
    showModifyDialog (index,row) {
      this.modifyFormVisible=true
      this.modifyFromBody= Object.assign({},row)
      this.selectRowIndex=index
      //console.log(this.selectRowIndex)
    },
    //编辑提交
    modifySubmit(){

    },
    //更换每页数量
    SizeChangeEvent(val){
        this.size = val;
        //this.getList();
        PubMethod.logMessage(this.page + "   " + this.size);
    },
    //页码切换时
    CurrentChangeEvent(val){
        this.page = val;
        //this.getList();
        PubMethod.logMessage(this.page + "   " + this.size);
    }
   }
 }
</script>

<style scoped lang="scss">

 
</style>
