<template>
  <div>
    <el-form :model="groupForm"
             :rules="rules"
             label-width="6em"
             ref="groupForm">
      <el-form-item label="名称："
                    prop="group_name">
        <el-input v-model="groupForm.group_name"
                  maxlength="10"
                  clearable
                  placeholder="请输入用户组名称"
                  show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="描述："
                    prop="desc">
        <el-input type="textarea"
                  class="group-textarea"
                  placeholder="请输入内容"
                  v-model="groupForm.desc"
                  clearable
                  maxlength="100"
                  show-word-limit></el-input>
      </el-form-item>
      <!-- 单选框 -->
      <el-form-item label="状态："
                    prop="state">
        <el-radio-group v-model="groupForm.state">
          <el-radio :label="true">启用</el-radio>
          <el-radio :label="false">禁用</el-radio>
        </el-radio-group>
      </el-form-item>
      <!-- 权限列表 -->
      <el-form-item label="权限列表："
                    prop="userRouters">
        <el-input placeholder="输入关键字进行过滤"
                  clearable
                  class="permission-search-input"
                  v-model="filterText">
        </el-input>
        <el-tree :data="groupForm.userRouters"
                 show-checkbox
                 node-key="name"
                 :default-expanded-keys="['allPermission']"
                 :filter-node-method="filterTree"
                 :props="defaultProps"
                 ref="permissionTree">
        </el-tree>
      </el-form-item>
    </el-form>
    <!-- 提交取消功能按钮 -->
    <div slot="footer"
         class="dialog-footer">
      <el-button @click="handleAuthDialogVisiable">取 消</el-button>

      <el-button type="primary"
                 @click="handleSumbitForm">提 交</el-button>
    </div>
  </div>
</template>
<script>
import { generateTitle } from "@/utils/i18n";
import userRouters from './userRouters'
import { addAuth, editAuth } from '@/api/permission'

export default {
  props: {
    id: Number,
    group_name: { type: String, default: '' },
    desc: { type: String, default: '' },
    state: { type: Boolean, default: true },
    checkedKeys: { type: Array, default: () => [] },
    AddOrEdit: {
      type: String,
      default: '',
      required: true
    }
  },
  data () {
    return {
      groupForm: {
        group_name: '',
        desc: '',
        state: true,
        userRouters: [{
          name: 'allPermission',
          children: userRouters
        }]
      },
      defaultProps: {
        children: 'children',
        label: (data, node) => {
          return this.generateTitle(data.name)
        }
      },
      // 校验规则
      rules: {
        group_name: [
          { required: true, message: '请输入用户组名称', trigger: 'blur' },
          { min: 1, max: 10, message: '长度在 1 到 10 个字符', trigger: 'blur' }
        ],
        desc: [
          { required: true, message: '请描述该用户组', trigger: 'blur' },
          { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
        ],
        desc: [
          { required: true, message: '请描述该用户组', trigger: 'blur' },
          { min: 1, max: 100, message: '长度在 1 到 100 个字符', trigger: 'blur' }
        ],
      },
      filterText: '',
    }
  },
  watch: {
    group_name (val) {
      this.groupForm.group_name = val
    },
    desc (val) {
      this.groupForm.desc = val
    },
    state (val) {
      this.groupForm.state = val
    },
    checkedKeys: {
      handler: function (val, oldVal) {
        this.$refs.permissionTree.setCheckedKeys(this.recursiveCheckedKeys(val));
      },
      deep: true
    },
    filterText (val) {
      this.$refs.permissionTree.filter(val);
    }
  },
  methods: {
    // 遍历二叉树，递归
    recursiveCheckedKeys (arr) {
      let app = this
      let newArr = []
      // 判断路由表数组是否为空
      if (arr.length !== 0) {
        arr.forEach(val => {
          // 判断此节点是否为父节点
          if (typeof val.children !== 'undefined') {
            newArr.push(...app.recursiveCheckedKeys(val.children))
          } else {
            newArr.push(val.name)
          }
        })
      }
      return newArr
    },
    // 寻找节点的嫡系
    getUserRouters (node) {
      let app = this
      var data = JSON.parse(JSON.stringify(node.data))
      // 如果该节点没有被勾选
      if (!node.checked) {
        // 如果该节点没有勾选且是一个父节点
        if (node.indeterminate) {
          data.children = []
          node.childNodes.forEach(childNode => {
            let child = app.getUserRouters(childNode)
            if (child) {
              data.children.push(child)
            }
          })
          return data
          // 如果该节点没有勾选且不是一个父节点
        } else {
          return
        }
        // 如果该节点勾选了
      } else {
        return data
      }
    },
    // Tree控件的筛选方法
    filterTree (value, data, node) {
      if (!value) return true;
      return node.label.indexOf(value) !== -1;
    },
    // 对话框底部的取消按钮
    handleAuthDialogVisiable () {
      this.$emit('close-dialog', false)
    },

    // 提交对话框的表单
    handleSumbitForm () {
      let app = this
      let firstNode = this.$refs.permissionTree.getNode('allPermission')
      let newRouters = []
      firstNode.childNodes.forEach(childNode => {
        let data = app.getUserRouters(childNode)
        if (data) {
          newRouters.push(data)
        }
      })
      let groupForm = this.groupForm
      groupForm.userRouters = newRouters
      // 如果对话框就是添加用户组
      if (app.AddOrEdit === 'add') {
        addAuth(groupForm).then(res => {
          console.log("添加用户组-响应：", res);
          let status = res.data.data.data.status
          let msg = res.data.data.data.msg
          this.$message({
            type: status,
            message: msg
          })
        })
      }
      // 如果对话框是修改用户组的话
      if (app.AddOrEdit === 'edit') {
        groupForm.id = app.id
        editAuth(groupForm).then(res => {
          console.log("修改用户组-响应：", res);
          let status = res.data.data.data.status
          let msg = res.data.data.data.msg
          this.$message({
            type: status,
            message: msg
          })
        })
      }
      app.handleAuthDialogVisiable()

    },
    //  引入翻译函数
    generateTitle
  },
}
</script>
<style lang="scss" scoped>
.dialog-footer {
  width: 70%;
  height: 100%;
  margin: 0 auto;
  display: flex;
  display: -webkit-flex;
  justify-content: space-around;
}
</style>
