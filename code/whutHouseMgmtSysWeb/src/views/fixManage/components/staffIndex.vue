<template>
  <aside :class="{showSidebar:!isCollapse}">
    <!-- 展开关闭按钮 -->
    <div class="asid-button">
      <el-input v-model="searchText"
                placeholder="输入职工搜索"
                class="filter"></el-input>
    </div>
    <!-- 主菜单 -->
    <el-tree class="aside-tree"
             v-loading="listLoading"
             ref="staffTree"
             element-loading-text="加载中"
             element-loading-spinner="el-icon-loading"
             element-loading-background="rgba(0, 0, 0, 0.8)"
             :data="depData"
             :props="props"
             :default-expand-all="expandAll"
             :render-content="renderContent"
             @node-click="nodeClick"></el-tree>
  </aside>
</template>

<script type="text/ecmascript-6">
import { getDept, getDeptsByInput } from "@/api/basiceData";
let _ = require("underscore");
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
      // 部门信息加职工
      depData: [],
      props: {
        label: (data, node) => {
          return node.level == 1 ? node.data.staffParamName : node.data.name
        },
        children: 'staffModels',
      },
      accordion: true,
      expandAll: false
    };
  },
  created () {
    this.getList();
    this.$watch('searchText', _.debounce((newVal, oldVal) => {
      if (newVal !== oldVal) {
        this.getStaffByNoOrName(newVal)
      }
    }, 1000, false))
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
    getList () {
      this.listLoading = true;
      let param = {};
      let num = 0;
      getDept(param)
        .then(res => {
          this.depData = res.data.data.deptData;
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 根据职工号和姓名搜索员工
    getStaffByNoOrName (text) {
      this.listLoading = true;
      this.expandAll = true
      getDeptsByInput(text).then(res => {
        let deptData = res.data.data.deptData;
        this.depData = deptData.filter(item => {
          return item.staffModels.length !== 0
        })
        this.listLoading = false;
      })

    },
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
