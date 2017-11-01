<template>
<div>
<!-- 右侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic"><h1>职称分参数</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >
    <el-popover ref="addPopver" width="160" placement="top" v-model="popoverVisible">
      <p class="margin:0">请在职工参数中新增职称，此处不可新增职称</p>
      <div style="text-align: right; margin:0">
        <el-button type="primary" size="mini" @click="popoverVisible=false">确定</el-button>
      </div>
    </el-popover>    
    <el-form :inline="true" style="margin-bottom:15px">
      <el-button type="primary" v-popover:addPopver >新增职称</el-button>
    </el-form>
  </el-col>
  <!-- 表格区域 -->
  <el-col :span="24">
    <el-table :data="PostValData" border style="width:100%" v-loading="listLoading" max-height="450">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
      <el-table-column prop="staffParamName" label="职工类别" sortable align="center" ></el-table-column>
      <el-table-column prop="staffParamVal" label="职称分" sortable align="center" ></el-table-column>
      <el-table-column prop="staffParamSpouseVal" label="配偶职称分" sortable align="center" ></el-table-column>
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope" >
            <el-button  size="small" @click="showModifyDialog(scope.$index,scope.row)" >编辑</el-button>
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
    <!-- 编辑表单 -->
    <el-dialog title="编辑职称分" :visible.sync="modifyFormVisible" v-loading="modifyLoading" width="35%">
      <el-form :model="modifyFromBody" label-width="100px" ref="modifyFrom" :rules="rules" >
        <el-form-item label="职工类别" prop="staffParamName"  >
          <el-input v-model="modifyFromBody.staffParamName" :disabled="true"   ></el-input>
        </el-form-item>
        <el-form-item label="职称分" prop="staffParamVal"  >
          <el-input v-model="modifyFromBody.staffParamVal" placeholder="请输入职称分"  ></el-input>
        </el-form-item>   
        <el-form-item label="配偶职称分" prop="staffParamSpouseVal"  >
          <el-input v-model="modifyFromBody.staffParamSpouseVal" placeholder="请输入配偶职称分"  ></el-input>
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
import {getRentParamAboutStaff,putRentParamAboutStaff} from '@/api/api'
import common from '@/common/util.js'
export default {
   data() {
       // 正则验证
       const validateNum = (rule, value, callback)=>{
           const RULES=/^\d+$/
           if(value==null){
               callback(new Error('请输入面积'))
               }else if(!RULES.test(value)) {
                   callback(new Error('输入值必须为非负整数'))
            }else {
                callback()
                }
            }        
     return {
       popoverVisible:false,
       paramClass:'12',
       // 用户令牌
       access_token:'',
       // 表格数据
       PostValData: [],
       listLoading:false,
       totalNum:1,
       page:1,
       size:10,

       // 表单规则验证
       rules:{
         staffParamSpouseVal:{validator:validateNum , trigger:'blur'},
         staffParamSpouseVal:{validator:validateNum , trigger:'blur'}
       },

       //编辑表单相关数据
       modifyFormVisible:false,
       modifyLoading:false,
       modifyFromBody:{
         staffParamName:'',
         staffParamVal:'',
         staffParamSpouseVal:''

       },
      
     }

   },
   mounted () {
     this.getList()
   },
   methods:{
     // 获取职工职称
     getList(){
       this.listLoading=true
       let param = {
         page : this.page,
         size : this.size
       }
       // http请求
       getRentParamAboutStaff(param,this.paramClass).then((res)=>{
         this.PostValData=res.data.data.data.list
         this.totalNum=res.data.data.data.total
         this.listLoading=false
       }).catch((err)=>{
         console.log(err)
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
          putRentParamAboutStaff(param).then((res)=>{
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
        this.getList();
    },
    //页码切换时
    CurrentChangeEvent(val){
        this.page = val;
        this.getList();
    }
   }
 }
</script>

<style scoped lang="scss">

 
</style>
