<template>
<div>
<!-- 右侧主要内容 -->
<el-col :span="24" class="right-main">
  <el-col :span="24" class="topic" ><h1>选房选项设置</h1></el-col>
  <!-- 工具条 -->
  <el-col :span="24" class="toolBar" >
    <el-form :inline="true" style="margin-bottom:15px">
      <el-button type="primary" @click="addFormVisible = true" >新增设置</el-button>
    </el-form>
  </el-col>
  <!-- 表格区域 -->
  <el-card>
  <el-col :span="24">
    <el-table :data="PostValData" :border="false" style="width:100%" v-loading="listLoading" height="400">
      <!-- <el-table-column type="selection" width="55"></el-table-column> -->
      <el-table-column type="expand" label="住房规则">
        <template slot-scope="props">
          <el-form label-position="top" inline>
            <el-form-item label="住房规则">
              <span>{{props.row.rentSelRules }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>  
      <el-table-column prop="rentTimeBegin" label="开始时间" sortable align="center" ></el-table-column>
      <el-table-column prop="rentTimeRanges" label="结束时间" sortable align="center" ></el-table-column>
      <el-table-column prop="rentSelValReq" label="所需积分" sortable align="center" ></el-table-column>  
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope" >
            <el-button  size="small" @click="showModifyDialog(scope.$index,scope.row)" >编辑</el-button>
            <el-button type="danger" size="small" @click="delectRentEvent(scope.$index,scope.row)" >删除</el-button>            
          </template>
        </el-table-column>      
    </el-table>
  </el-col>
  <!-- 下方工具条 -->
  <el-col :span="24" >
    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent" :page-size="size" :page-sizes="[10,15,20,25,30]":total="totalNum" >
    </el-pagination>
  </el-col>
  </el-card>
</el-col>
    <!-- 新增表单 -->
    <el-dialog title="新增选房设置" :visible.sync="addFormVisible" v-loading="submitLoading" >
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto>
        <el-form-item label="所需积分" prop="rentSelValReq">
          <el-input v-model="addFormBody.rentSelValReq" placeholder="请输入积分" style="width:350px" ></el-input>
          <span>{{addFormBody.rentTimeBegin}}</span>
        </el-form-item>
        <el-form-item label="选房时间" prop="rentTimeBegin">
          <el-date-picker v-model="addFormBody.rentTimeBegin" type="daterange" align="right" :picker-options="pickerOptions"
                 unlink-panels range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item> 
        <el-form-item label="选房规则" prop="rentSelRules">
          <el-input type="textarea" :autosize="{minRows:3,maxRows:6}" placeholder="请输入内容" v-model="addFormBody.rentSelRules" style="width:350px" > </el-input>          
        </el-form-item>     
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit" >提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑职务分" :visible.sync="modifyFormVisible" v-loading="modifyLoading" width="35%">
      <el-form :model="modifyFromBody" label-width="100px" ref="modifyFrom" :rules="rules" >
        <el-form-item label="职务类别" prop="staffParamName"  >
          <el-input v-model="modifyFromBody.staffParamName" :disabled="true"   ></el-input>
        </el-form-item>
        <el-form-item label="享受面积" prop="staffParamHouseArea"  >
          <el-input  v-model="modifyFromBody.staffParamHouseArea" placeholder="请输入享受面积"  ></el-input>
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
import {getRentParamAboutEvent,putRentParamAboutStaff,deleteRentParamAboutEvent} from '@/api/api'
import common from '@/common/util.js'
export default {
   data() {
       // 正则验证
       const validateNum = (rule, value, callback)=>{
           const RULES=/^\d+$/
           if(value==null){
               callback(new Error('所需积分不能为空'))
               }else if(!RULES.test(value)) {
                   callback(new Error('输入值必须为非负整数'))
            }else {
                callback()
                }
            }
     return {
       popoverVisible:false,
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
         rentSelValReq:[
           {required: true, message: '所需积分不能为空' , trigger: 'blur' },
           {validator:validateNum , trigger:'blur'}
           ],
         rentTimeBegin:[
           {required: true, message: '选房时间为必选' , trigger: 'blur' },
         ]
       },

       //编辑表单相关数据
       modifyFormVisible:false,
       modifyLoading:false,
       modifyFromBody:{
         staffParamName:'',
         staffParamHouseArea:''
       },
       
       // 新增表单相关数据
       submitLoading:false,       
       addFormVisible: false,
       addFormBody:{
         rentSelValReq:'',
         rentTimeBegin:'',
         rentSelRules:''    
       },
       // 日期自动设置范围
       pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              end.setTime(start.getTime() + 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              end.setTime(start.getTime() + 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              end.setTime(start.getTime() + 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
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
       getRentParamAboutEvent(param).then((res)=>{
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
    // 删除功能
    delectRentEvent(index,row){
      this.$confirm('此操作将删除该历史记录','提示',{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>{
        let param=row.rentEventId
        this.listLoading=true
        deleteRentParamAboutEvent(param).then((res)=>{
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
