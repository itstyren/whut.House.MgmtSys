<template>
  <div class="content-wrapper">
    <div style="height:100%;padding:10px;">
      <!-- 面包屑导航 -->
      <div class="warp-breadcrum">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">
            <b>首页</b>
          </el-breadcrumb-item>
          <el-breadcrumb-item>系统管理</el-breadcrumb-item>
          <el-breadcrumb-item>权限管理</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <div class="card"
           :style="{height:height}">
        <div class="title">
          <strong>用户组列表</strong>
        </div>
        <div class="table"
             ref="pageView">
          <div class="table-edit">
            <div class="left-actions">
              <el-button type="primary"
                         icon="el-icon-plus"
                         @click="handleAddUserGroup"
                         round>新增用户组</el-button>
            </div>
            <div class="right-actions">
              <el-button type="info"
                         :disabled="tableChecked.length===0"
                         @click="delDialogVisible = true"
                         round>删除<span v-if="tableChecked.length!==0"> {{tableChecked.length}} 个</span></el-button>
              <div class="search-input-wrapper">
                <el-input placeholder="搜索"
                          v-model="searchText"></el-input>
              </div>
              <el-popover style="text-align: left"
                          trigger="hover"
                          placement="left-start">
                <h3>操作提示</h3>
                <ul class="action-tips">
                  <li><span>分组名称：</span>
                    <p>用户组名称，用于表示具有相同操作权限的用户群体。</p>
                  </li>
                  <li><span>描述：</span>
                    <p>用户组的详细描述。</p>
                  </li>
                  <li><span>状态：</span>
                    <p>用户组的启用/禁用状态，若禁用，用户将无法获得该用户组的操作权限。</p>
                  </li>
                  <li><span>创建时间：</span>
                    <p>用户组初次创建的时间。</p>
                  </li>
                  <li><span>操作：</span>
                    <p>编辑用户组信息以及操作权限。</p>
                  </li>
                </ul>
                <!-- </div> -->
                <i class="el-icon-question icon-question-font"
                   slot="reference"></i>
              </el-popover>
            </div>
          </div>
          <el-table :data="tableData2"
                    style="width:100%"
                    ref="authTable"
                    height='55vh'
                    :select-on-indeterminate="false"
                    @selection-change="selectionChangeEvent"
                    v-loading="listLoading">
            <el-table-column type="selection"
                             width="55">
            </el-table-column>
            <el-table-column label="编号"
                             width="90"
                             prop="id"></el-table-column>
            <el-table-column label="用户组名称"
                             prop="groupName"></el-table-column>
            <el-table-column label="属性"
                             prop="property"></el-table-column>
            <el-table-column label="描述"
                             prop="remark"></el-table-column>
            <el-table-column label="状态"
                             prop="state"
                             :formatter="stateFormatter"></el-table-column>
            <el-table-column label="创建时间"
                             prop="addTime"></el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button type="primary"
                           size="mini"
                           icon="el-icon-edit"
                           @click="handleEditAuth(scope.row.id,scope.row.groupName)"
                           circle></el-button>
              </template>
            </el-table-column>
          </el-table>

          <el-pagination background
                         layout="total, prev, pager, next, sizes, jumper"
                         :current-page.sync="currentPage"
                         @size-change="sizeChangeEvent"
                         @current-change="currentChangeEvent"
                         :page-size="pageSize"
                         :page-sizes="[10,15,20,25,30]"
                         :total="tableData.length">
          </el-pagination>
        </div>
        <el-dialog title="操作提示"
                   :visible.sync="delDialogVisible"
                   width="30%">
          <span>确定删除当前选中项吗？一旦删除，则属于其用户组的特殊权限也随之删除。</span>
          <span slot="footer"
                class="dialog-footer">
            <el-button @click="delDialogVisible = false">取 消</el-button>
            <el-button type="danger"
                       @click="handleDelMultRow">删 除</el-button>
          </span>
        </el-dialog>
        <!-- 操作用户组的对话框 -->
        <el-dialog :visible.sync="AuthDialogVisiable"
                   custom-class="el-form-group"
                   top="8vh"
                   center>
          <h2 slot="title"
              v-if="AuthFormAddOrEdit==='add'">新增用户组</h2>
          <h2 slot="title"
              v-if="AuthFormAddOrEdit==='edit'">修改用户组</h2>
          <!-- 编辑用户组信息的表单 -->
          <auth-form v-if="AuthDialogVisiable"
                     :AddOrEdit='AuthFormAddOrEdit'
                     :groupForm="groupFormData"
                     @close-dialog="handleCloseDialog"
                     @authList-change="authListChange"></auth-form>

        </el-dialog>
      </div>
    </div>
  </div>
</template>

<script>
import { getAuthList, delAuthList, addAuth, getOneAuth, editAuth } from '@/api/auth'
import AuthForm from './editAuth'
import userRouters from './userRouters'
import { numberToCampus } from "@/utils/auth"

export default {
  components: { AuthForm },
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "fit-content"
    }
  },
  data () {
    return {
      searchText: '',
      listLoading: false,
      delDialogVisible: false,
      AuthDialogVisiable: false,
      AuthFormAddOrEdit: '',
      currentPage: 1,
      pageSize: 10,
      tableData: [],
      tableChecked: [],//选中项
      groupFormData: {},
    };
  },
  // 所以Props，methods,data和computed的初始化都是在beforeCreated和created之间完成的。
  created () {
    this.getTableData()
    this.$store.dispatch("getCampusNumber")
  },

  computed: {
    // 前端式分页
    tableData2 () {
      return this.tableData.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
    },
    campusList () {
      return this.$store.getters.campusList
    }
  },
  methods: {
    // 获取用户组列表
    getTableData () {
      let app = this
      app.listLoading = true
      // app.tableData = []
      // let params = {
      //   page: that.currentPage,
      //   size: that.pageSize
      // }
      getAuthList().then(res => {
        app.tableData = res.data.data.data
        app.listLoading = false
      }).catch(err => {
        app.listLoading = false
        app.$message.error(err)
      })
    },
    // 一页总条数
    sizeChangeEvent (val) {
      this.pageSize = val;
      this.currentPage = 1;
    },
    // 跳转到某一页
    currentChangeEvent (val) {
      this.currentPage = val;
    },
    // 当前选中项
    selectionChangeEvent (selection) {
      this.tableChecked = selection
    },
    // 批量删除行
    delSelection () {
      this.listLoading = true
      let authNameList = this.tableChecked.map(item => item.groupName)
      delAuthList(authNameList).then(res => {
        this.getTableData()
        this.$message1({
          showClose: true,
          message: res.data.message,
          type: res.data.status
        });
      }).catch(err => {
        this.$message1.error(err)
      })
      this.listLoading = false
    },
    // 删除再次确认
    handleDelMultRow () {
      let app = this
      app.$confirm('请三思而后行，确认删除？')
        .then(_ => {
          app.delSelection()
          app.delDialogVisible = false
        })
        .catch(_ => { app.delDialogVisible = false });
    },
    // 新增用户组
    handleAddUserGroup () {
      this.groupFormData = {
        groupName: '',
        remark: '',
        state: true,
        property: '职工',
        manageCampus: []
      }
      this.AuthFormAddOrEdit = 'add'
      this.AuthDialogVisiable = true
    },
    // 打开修改某一用户组信息的对话框，并获取该用户组信息
    handleEditAuth (id) {
      this.getOneAuthMsg(id).then(() => {
        this.AuthFormAddOrEdit = 'edit'
        this.AuthDialogVisiable = true
      }).catch(err => this.$message1.error(err))
    },
    // 获取某一组用户组信息
    getOneAuthMsg (id) {
      return new Promise((resolve, reject) => {
        getOneAuth(id).then(res => {
          if (res.data.status === 'success') {
            let data = res.data.data.data
            data.checkedKeys = data.userRouters
            data.manageCampus = numberToCampus(data.manageCampus, this.campusList.id, this.campusList.name)
            delete data.userRouters
            this.groupFormData = data
            resolve()
          } else {
            reject(new Error('获取该用户组信息失败，无法操作！'))
          }
        })
      })
    },
    // 取消按钮关闭对话框
    handleCloseDialog (boolean) {
      this.AuthDialogVisiable = false
    },
    // 格式化state状态字段的内容
    stateFormatter (row, column, cellValue, index) {
      return row.state ? '启用' : '禁用'
    },
    // 更新表格
    authListChange () {
      setTimeout(() => this.getTableData(), 100)
    }
  },
}
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";
.content-wrapper {
  width: 100%;
  height: 100%;
  overflow: hidden;
  background-color: $background-grey;
}
.card {
  margin: 20px;
}
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: -10px;
    z-index: 1;
    left: 1%;
    right: 1%;
  }
}

.table {
  margin-top: 30px;
  height: calc(100% - 55px);
  padding: 30px;
}
.table-edit {
  text-align: right;
  padding-bottom: 20px;
}

.left-actions {
  display: inline-block;
  float: left;
}
.right-actions {
  padding-right: 40px;
}
.icon-question-font {
  font-size: 1.6vw;
}
.search-input-wrapper {
  display: inline-block;
  margin-left: 5px;
}
.action-tips {
  li {
    line-height: 10px;
    span {
      font-weight: 900;
    }
    p {
      display: inline-block;
    }
  }
}
.el-form-group {
  h2 {
    display: block;
    font-size: 1.5em;
    margin-block-start: 0em;
    margin-block-end: 0em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    font-weight: bold;
  }
}
.el-scrollbar__wrap {
  overflow-x: hidden;
}
</style>
