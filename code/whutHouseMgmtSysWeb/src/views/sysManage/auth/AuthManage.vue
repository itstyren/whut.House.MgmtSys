<template>
  <div class="content-wrapper">
    <el-scrollbar style="height:100%;">
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
                         @click="dialogVisible = true"
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
                    :select-on-indeterminate="false"
                    @select="handleSelectEvent"
                    @selection-change="selectionChangeEvent"
                    v-loading="listLoading">
            <el-table-column type="selection"
                             width="55">
            </el-table-column>
            <el-table-column label="编号"
                             width="90"
                             prop="id"></el-table-column>
            <el-table-column label="用户组名称"
                             prop="group_name"></el-table-column>
            <el-table-column label="描述"
                             prop="desc"></el-table-column>
            <el-table-column label="状态"
                             prop="state"
                             :formatter="stateFormatter"></el-table-column>
            <el-table-column label="创建时间"
                             prop="add_time"></el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button type="primary"
                           size="mini"
                           icon="el-icon-edit"
                           @click="handleEditAuth(scope.row.id,scope.row.group_name)"
                           circle></el-button>
              </template>
            </el-table-column>
          </el-table>

          <el-pagination layout="total, prev, pager, next, sizes, jumper"
                         :current-page.sync="currentPage"
                         @size-change="sizeChangeEvent"
                         @current-change="currentChangeEvent"
                         :page-size="pageSize"
                         :page-sizes="[10,15,20,25,30]"
                         :total="tableData.length">
          </el-pagination>
        </div>
        <el-dialog title="操作提示"
                   :visible.sync="dialogVisible"
                   width="30%">
          <span>确定删除当前选中项吗？一旦删除，则属于其用户组的特殊权限也随之删除。</span>
          <span slot="footer"
                class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="danger"
                       @click="handleDelMultRow">删 除</el-button>
          </span>
        </el-dialog>

        <!-- 操作用户组的对话框 -->

        <el-dialog :visible.sync="AuthDialogVisiable"
                   custom-class="el-form-group"
                   width="35%"
                   top="8vh"
                   center>
          <h2 slot="title"
              v-if="AuthFormAddOrEdit==='add'">新增用户组</h2>
          <h2 slot="title"
              v-if="AuthFormAddOrEdit==='edit'">修改用户组</h2>
          <!-- 编辑用户组信息的表单 -->
          <auth-form v-if="AuthDialogVisiable&&AuthFormAddOrEdit==='add'"
                     :AddOrEdit='AuthFormAddOrEdit'
                     @close-dialog="handleCloseDialog"></auth-form>
          <auth-form v-if="AuthDialogVisiable&&AuthFormAddOrEdit==='edit'"
                     :AddOrEdit='AuthFormAddOrEdit'
                     :id="editAuthMsg.id"
                     :group_name="editAuthMsg.group_name"
                     :desc="editAuthMsg.desc"
                     :state="editAuthMsg.state"
                     :checkedKeys="editAuthMsg.userRouters"
                     @close-dialog="handleCloseDialog"></auth-form>

        </el-dialog>

      </div>
    </el-scrollbar>
  </div>
</template>

<script>
import { getAuthList, delAuthList, addAuth, getOneAuth, editAuth } from '@/api/permission'
import AuthForm from './editAuth'
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
      dialogVisible: false,
      AuthDialogVisiable: false,
      AuthFormAddOrEdit: '',
      currentPage: 1,
      pageSize: 10,
      tableData: [],
      tableChecked: [],//选中项
      editAuthMsg: {}
    };
  },
  // 所以Props，methods,data和computed的初始化都是在beforeCreated和created之间完成的。
  created () {
    this.getTableData()
  },

  computed: {
    // 前端式分页
    tableData2 () {
      return this.tableData.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
    }
  },
  methods: {
    // 获取表格数据
    getTableData () {
      let that = this
      that.listLoading = true
      // let params = {
      //   page: that.currentPage,
      //   size: that.pageSize
      // }
      getAuthList().then(res => {
        that.tableData = res.data.data.data.list
        that.listLoading = false
      }).catch(err => {
        that.$message.error(err)
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
      let authNameList = this.tableChecked.map(item => item.id)
      delAuthList(authNameList).then(res => {
        this.getTableData()
        this.listLoading = false
        this.$message({
          showClose: true,
          message: res.data.data.data.msg,
          type: 'success'
        });
      }).catch(err => {
        this.$message.error(err)
      })
    },
    // 删除再次确认
    handleDelMultRow () {
      let app = this
      app.$confirm('请三思而后行，确认删除？')
        .then(_ => {
          app.delSelection()
          app.dialogVisible = false
        })
        .catch(_ => { app.dialogVisible = false });
    },
    // 新增用户组
    handleAddUserGroup () {
      this.AuthDialogVisiable = true
      this.AuthFormAddOrEdit = 'add'
    },
    // 获取某一组用户组信息
    getOneAuthMsg (data) {
      getOneAuth(data).then(res => {
        this.editAuthMsg = res.data.data.data.data
      })
    },
    // 打开修改某一用户组信息的对话框，并获取该用户组信息
    handleEditAuth (id, group_name) {
      this.AuthDialogVisiable = true
      this.AuthFormAddOrEdit = 'edit'
      let data = {
        id: id,
        groupName: group_name
      }
      this.getOneAuthMsg(data)
    },
    // 取消按钮关闭对话框
    handleCloseDialog (boolean) {
      this.AuthDialogVisiable = false
    },
    // 格式化state状态字段的内容
    stateFormatter (row, column, cellValue, index) {
      return row.state ? '启用' : '禁用'
    },
    handleSelectEvent (selection, row) {
      console.log("勾选中：selection:", selection);
      console.log("row:", row);

    }
  },
}
</script>

<style scoped lang="scss">
.content-wrapper {
  width: 100%;
  height: 100%;
  overflow-y: auto;
  overflow-x: hidden;
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
