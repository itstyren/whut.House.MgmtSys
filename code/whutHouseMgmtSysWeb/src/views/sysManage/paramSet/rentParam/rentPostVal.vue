<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>租赁参数</el-breadcrumb-item>
        <el-breadcrumb-item>职务分</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-popover ref="addPopver" width="160" placement="top" v-model="popoverVisible">
          <p class="margin:0">请在职工参数中新增职务，此处不可新增职务</p>
          <div style="text-align: right; margin:0">
            <el-button type="primary" size="mini" @click="popoverVisible=false">确定</el-button>
          </div>
        </el-popover>
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" v-popover:addPopver>新增职务</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="PostValData" class="table" v-loading="listLoading" height="string">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
          <el-table-column prop="staffParamName" label="职务" sortable align="center"></el-table-column>
          <el-table-column prop="staffParamVal" label="职务分" sortable align="center"></el-table-column>
          <el-table-column prop="staffParamSpouseVal" label="配偶职务分" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination background layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
    <!-- 编辑表单 -->
    <el-dialog title="编辑职务分" class="paramDialog" :visible.sync="modifyFormVisible" v-loading="modifyLoading" width="35%">
      <el-form :model="modifyFromBody" label-width="100px" ref="modifyFrom" :rules="rules">
        <el-row>
          <el-col :span="20">
            <el-form-item label="职务" prop="staffParamName">
              <el-input v-model="modifyFromBody.staffParamName" :disabled="true"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="职务分" prop="staffParamVal">
              <el-input v-model="modifyFromBody.staffParamVal" placeholder="请输入职务分"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="配偶职务分" prop="staffParamSpouseVal">
              <el-input v-model="modifyFromBody.staffParamSpouseVal" placeholder="请输入配偶职务分"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" modifyFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="modifySubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import {
    getRentParamAboutStaff,
    putRentParamAboutStaff
  } from '@/api/sysManage'
  import utils from '@/utils/index.js'
  export default {
    data() {
      // 正则验证
      const validateNum = (rule, value, callback) => {
        const RULES = /^\d+$/
        if (value == null) {
          callback(new Error('请输入面积'))
        } else if (!RULES.test(value)) {
          callback(new Error('输入值必须为非负整数'))
        } else {
          callback()
        }
      }
      return {
        popoverVisible: false,
        paramClass: '11',
        // 表格数据
        PostValData: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10,

        // 表单规则验证
        rules: {
          staffParamSpouseVal: {
            validator: validateNum,
            trigger: 'blur'
          }
        },

        //编辑表单相关数据
        modifyFormVisible: false,
        modifyLoading: false,
        modifyFromBody: {
          staffParamName: '',
          staffParamVal: '',
          staffParamSpouseVal: ''

        },

      }

    },
    mounted() {
      this.getList()
    },
    methods: {
      // 获取职工职务
      getList() {
        this.listLoading = true
        let param = {
          page: this.page,
          size: this.size
        }
        // http请求
        getRentParamAboutStaff(param, this.paramClass).then((res) => {
          this.PostValData = res.data.data.data.list
          this.totalNum = res.data.data.data.total
          this.listLoading = false
        }).catch((err) => {
          console.log(err)
        })
      },
      //显示编辑
      showModifyDialog(index, row) {
        this.modifyFormVisible = true
        this.modifyFromBody = Object.assign({}, row)
        this.selectRowIndex = index
        //console.log(this.selectRowIndex)
      },
      //编辑提交
      modifySubmit() {
        this.$refs['modifyFrom'].validate((valid) => {
          if (valid) {
            this.modifyLoading = true
            let param = Object.assign({}, this.modifyFromBody)
            putRentParamAboutStaff(param).then((res) => {
              utils.statusinfo(this, res.data)
              this.modifyLoading = false
              this.modifyFormVisible = false
              this.getList()
            })
          }
        })
      },
      //更换每页数量
      SizeChangeEvent(val) {
        this.size = val;
        this.getList();
      },
      //页码切换时
      CurrentChangeEvent(val) {
        this.page = val;
        this.getList();
      }
    }
  }

</script>

<style scoped lang="scss">


</style>
