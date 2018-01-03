<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>租赁参数</el-breadcrumb-item>
        <el-breadcrumb-item>选房选项</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" @click="addFormVisible = true">新增设置</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="rentOptionData" class="table" v-loading="listLoading" height="string">
          <el-table-column type="expand" label="住房规则">
            <template slot-scope="props">
              <el-form label-position="top" inline>
                <el-form-item label="住房规则">
                  <span>{{props.row.rentSelRules }}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column prop="rentTimeBegin" label="开始时间" sortable align="center"></el-table-column>
          <el-table-column prop="rentTimeRanges" label="结束时间" sortable align="center"></el-table-column>
          <el-table-column prop="rentIsOpenSel" label="是否开启" sortable align="center" :formatter="transfOpenStatus"></el-table-column>
          <el-table-column prop="rentSelValReq" label="所需积分" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="200" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="delectRentEvent(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
    <!-- 新增表单 -->
    <el-dialog title="新增选房设置" :visible.sync="addFormVisible" v-loading="submitLoading">
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto>
        <el-form-item label="所需积分" prop="rentSelValReq">
          <el-input v-model="addFormBody.rentSelValReq" placeholder="请输入积分" style="width:350px"></el-input>
        </el-form-item>
        <el-form-item label="选房时间" prop="timeRanges">
          <el-date-picker v-model="addFormBody.timeRanges" type="daterange" align="right" :picker-options="pickerOptions" unlink-panels
            range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="选房规则" prop="rentSelRules">
          <el-input type="textarea" :autosize="{minRows:3,maxRows:6}" placeholder="请输入内容" v-model="addFormBody.rentSelRules" style="width:350px">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit">提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑选房选项" :visible.sync="modifyFormVisible" v-loading="modifyLoading" width="35%">
      <el-form :model="modifyFromBody" label-width="100px" ref="modifyFrom" :rules="rules">
        <el-form-item label="所需积分" prop="rentSelValReq">
          <el-input v-model="modifyFromBody.rentSelValReq" placeholder="请输入积分" style="width:350px"></el-input>
        </el-form-item>
        <el-form-item label="选房时间" prop="timeRanges">
          <el-date-picker v-model="modifyFromBody.timeRanges" type="daterange" align="right" :picker-options="pickerOptions" unlink-panels
            range-separator="至" start-placeholder="开始日期" end-placeholder="结束日期" value-format="yyyy-MM-dd">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="选房规则" prop="rentSelRules">
          <el-input type="textarea" :autosize="{minRows:3,maxRows:6}" placeholder="请输入内容" v-model="modifyFromBody.rentSelRules" style="width:350px">
          </el-input>
        </el-form-item>
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
    getRentParamAboutEvent,
    putRentParamAboutStaff,
    deleteRentParamAboutEvent,
    postRentParamAboutEvent
  } from '@/api/api'
  import common from '@/common/util.js'
  export default {
    data() {
      // 正则验证
      const validateNum = (rule, value, callback) => {
        const RULES = /^\d+$/
        if (value == null) {
          callback(new Error('所需积分不能为空'))
        } else if (!RULES.test(value)) {
          callback(new Error('输入值必须为非负整数'))
        } else {
          callback()
        }
      }
      return {
        popoverVisible: false,
        // 用户令牌
        access_token: '',
        // 表格数据
        rentOptionData: [],
        listLoading: false,
        totalNum: 1,
        page: 1,
        size: 10,

        // 表单规则验证
        rules: {
          rentSelValReq: [{
              required: true,
              message: '所需积分不能为空',
              trigger: 'blur'
            },
            {
              validator: validateNum,
              trigger: 'blur'
            }
          ],
        },

        //编辑表单相关数据
        modifyFormVisible: false,
        modifyLoading: false,
        modifyFromBody: {
          rentSelValReq: '',
          timeRanges: '',
          rentTimeBegin: '',
          rentTimeRanges: '',
          rentSelRules: '',
        },

        // 新增表单相关数据
        submitLoading: false,
        addFormVisible: false,
        addFormBody: {
          timeRanges: '',
          rentSelValReq: '',
          rentTimeBegin: '',
          rentTimeRanges: '',
          rentSelRules: '',
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
    // 计算属性
    computed: {
      timeRanges() {
        return this.addFormBody.timeRanges
      }
    },
    // 监听
    watch: {
      //  addFormBody : {
      //     handler: function (newval) {
      //       console.log(newval)
      //     },
      //     deep:true
      //  },
      timeRanges(newval) {
        this.addFormBody.rentTimeBegin = newval[0]
        this.addFormBody.rentTimeRanges = newval[1]
      }
    },
    // 生命周期调用
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
        getRentParamAboutEvent(param).then((res) => {
          this.rentOptionData = res.data.data.data.list
          this.totalNum = res.data.data.data.total
          this.listLoading = false
        }).catch((err) => {
          console.log(err)
        })
      },
      // 转换开启状态
      transfOpenStatus(row) {
        return common.transfOpenStatus(row)
      },
      //显示编辑
      showModifyDialog(index, row) {
        if (row.rentIsOpenSel == true) {
          this.modifyFormVisible = true
          this.modifyFromBody = Object.assign({}, row)
          this.selectRowIndex = index
        } else {
          this.$message({
            message: '已过选房阶段，不可编辑',
            type: 'warning'
          })
        }

        //console.log(this.selectRowIndex)
      },
      //编辑提交
      modifySubmit() {
        this.$refs['modifyFrom'].validate((valid) => {
          if (valid) {
            this.modifyLoading = true
            let param = Object.assign({}, this.modifyFromBody)
            putRentParamAboutStaff(param).then((res) => {
              common.statusinfo(this, res.data)
              this.modifyLoading = false
              this.modifyFormVisible = false
              this.getList()
            })
          }
        })
      },
      // 新增提交
      addSubmit() {
        this.$refs['addForm'].validate((valid) => {
          if (valid) {
            this.submitLoadinga = true
            let param = Object.assign({}, this.addFormBody)
            postRentParamAboutEvent(param).then((res) => {
              // 公共提示方法
              common.statusinfo(this, res.data)
              this.$refs['addForm'].resetFields()
              this.submitLoading = false
              this.addFormVisible = false
              this.getList()
            })
          }
        })
      },
      // 删除功能
      delectRentEvent(index, row) {
        this.$confirm('此操作将删除该历史记录', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let param = row.rentEventId
          this.listLoading = true
          deleteRentParamAboutEvent(param).then((res) => {
            // 公共提示方法
            common.statusinfo(this, res.data)
            this.getList()
          }).catch((err) => {
            console.log(err)
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
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
