<template>
<div>
<!-- 右侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic"><h1>职工类别参数</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >    
    <el-form :inline="true" style="margin-bottom:15px">
      <el-button type="primary" @click="addFormVisible = true" >新增类别</el-button>
    </el-form>
  </el-col>
  <!-- 表格区域 -->
  <el-col :span="24">
    <el-table :data="classData" border style="width:100%" v-loading="listLoading" max-height="450">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
      <el-table-column prop="staffParamName" label="职工类别" sortable align="center" ></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope" >
            <el-button  size="small" @click="showModifyDialog(scope.$index,scope.row)" >编辑</el-button>
            <el-button type="danger" size="small" @click="delectClass(scope.$index,scope.row)" >删除</el-button>
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
    <el-dialog title="新增职工类别" :visible.sync="addFormVisible" v-loading="submitLoading" >
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto>
        <el-form-item label="职工类别" prop="staffParamName">
          <el-input v-model="addFormBody.staffParamName" placeholder="请输入职工类别"  ></el-input>
        </el-form-item>     
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" >提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑职工类别" :visible.sync="modifyFormVisible" v-loading="modifyLoading">
      <el-form :model="modifyFromBody" label-width="80px" ref="modifyFrom" :rules="rules" >
        <el-form-item label="职工类别" prop="staffParamName"  >
          <el-input v-model="modifyFromBody.staffParamName" placeholder="请输入职工类别"  ></el-input>
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
import {getStaffParam,deleteStaffParam,postStaffParam,putStaffParam} from '@/api/api'
import common from '@/common/util.js'
export default {
   data() {
     return {
       paramClass:'8',
       // 用户令牌
       access_token:'',
       // 表格数据
       classData: [
       ],
       listLoading:false,
       totalNum:1,
       page:1,
       size:10,

       // 表单规则验证
       rules:{
         staffParamName:{
           required: true, message: '职工类别不能为空' , trigger: 'blur' 
         },
       },

       //编辑表单相关数据
       modifyFormVisible:false,
       modifyLoading:false,
       modifyFromBody:{
         staffParamName:''
       },
      
      // 新增表单相关数据
       submitLoading:false,       
       addFormVisible: false,
       addFormBody:{
         staffParamName:''
       }
     }

   },
   mounted () {
     this.getList()
   },
   methods:{
     // 获取职工职务
     getList(){
       this.listLoading=true
       let param = {
         page : this.page,
         size : this.size
       }
       // http请求
       getStaffParam(param,this.paramClass).then((res)=>{
         this.classData=res.data.data.data
         this.listLoading=false
       }).catch((err)=>{
         console.log(err)
       })
     },
    // 删除功能
    delectClass(index,row){
      this.$confirm('此操作将删除该职称','提示',{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>{
        let param=row.staffParamId
        this.listLoading=true
        deleteStaffParam(param).then((res)=>{
          // 公共提示方法
          common.statusinfo(this,res.data)
          this.getList()
          }).catch((err)=>{
            console.log(err)
            })
        }).catch(()=>{
          this.$message({
            type: 'info',
            message:'已取消删除'
          });
        });
      },
      // 新增提交
      addSubmit(){
        this.$refs['addForm'].validate((valid)=>{
          if(valid){
            this.submitLoadinga=true
            let param=Object.assign({},this.addFormBody)
            param.paramTypeId=this.paramClass                 
            postStaffParam(param).then((res)=>{
              // 公共提示方法
              common.statusinfo(this,res.data)
              this.$refs['addForm'].resetFields()
              this.submitLoading=false
              this.addFormVisible=false
              this.getList()
            })
          }
        })
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
      this.$refs['modifyFrom'].validate((valid)=>{
        if(valid){
          this.modifyLoading=true
          let param=Object.assign({},this.modifyFromBody)
          putStaffParam(param).then((res)=>{
            common.statusinfo(this,res.data)
            this.modifyLoading=false
            this.modifyFormVisible=false
            this.getList()
          })
        }
      })
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
