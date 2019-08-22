<template>
  <aside :class="{showSidebar:!isCollapse}">
    <!-- 展开关闭按钮 -->
    <div class="asid-button">
      <el-input v-model="filterText"
                placeholder="输入职工搜索"
                class="filter"></el-input>
    </div>
    <!-- 主菜单 -->
    <el-tree v-loading="listLoading"
             ref="staffTree"
             accordion
             lazy
             :props="props"
             :load="handleLoadNodeData"
             :render-content="renderContent"
             @node-click="nodeClick"></el-tree>
  </aside>
</template>

<script type="text/ecmascript-6">
import { getAllDept, getSimpleStaffInfo } from "@/api/basiceData";

export default {
  data () {
    return {
      isCollapse: false,
      // 树控件需要的
      listLoading: false,
      // 部门信息加职工
      allDept: [],
      //搜索一名员工
      searchText: "",
      props: {
        label: 'name',
        // children: 'zones',
        isLeaf: 'leaf'
      }
    };
  },
  created () {
    this.getList();
  },
  watch: {
    // 监听输入值
    // filterText(val) {
    //   this.$refs.staffTree.filter(val);
    // }
  },
  methods: {
    //折叠
    collapse: function () {
      this.isCollapse = !this.isCollapse;
    },

    // 渲染函数
    renderContent (h, { node, data, store }) {
      // console.log(node);
      if (node.level == 1) {
        return (
          <span>
            <span>
              <span>
                {" "}
                <my-icon icon-class="bumen" />
                <span class="label">{node.label}</span>{" "}
              </span>
            </span>
          </span>
        );
      } else {
        return (
          <span>
            <span>
              <span>
                {" "}
                <my-icon icon-class="account" />
                <span class="label">{node.label}</span>{" "}
              </span>
            </span>
          </span>
        );
      }
    },
    // 懒加载部门的员工姓名和Id
    handleLoadNodeData (node, resolve) {
      if (node.level == 0) {
        getAllDept()
          .then(res => {
            if (res.data.data.data.length === 0) return resolve([])
            let data = res.data.data.data
            if (data.length) {
              data.forEach(item => {
                item.name = item.staffParamName
              })
            }
            return resolve(data)
          })
      }
      if (node.data) {
        getSimpleStaffInfo(node.data.staffParamId)
          .then(res => {
            if (res.data.data.data.length === 0) return resolve([])
            let data = res.data.data.data.slice(0, 500)
            if (data.length) {
              data.forEach(item => {
                item.leaf = true
              });
            }
            resolve(data)
          })
      }
      resolve([])
    },
    // 筛选函数
    // filterNode (value, data) {
    //   if (!value) return true;
    //   return data.label.indexOf(value) !== -1;
    // },
    // 节点被点击时的回调
    nodeClick (object, node, component) {
      //console.log(node);
      if (node.level == 1) {
        return
      } else if (node.level == 2) {
        this.$emit("emit-staff", object);
      }
    }
  }
};
</script>

<style scoped lang="scss">
aside {
  .asid-button {
    margin: 10px auto 10px;
    width: 70%;
  }
  .el-input__inner {
    background: #4a5064;
  }
  > .el-tree {
    height: auto;
  }

  span {
    padding-left: 20px;
  }
}
</style>
