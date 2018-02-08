<template>
    <aside :class="{showSidebar:!isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button">
        <el-input v-model="filterText" placeholder="输入职工搜索" class="filter"></el-input>
      </div>
      <!-- 主菜单 -->
      <el-tree v-loading="listLoading" ref="staffTree" :data="depData" :render-content="renderContent" :filter-node-method="filterNode"
        @node-click="nodeClick"></el-tree>
    </aside>
</template>

<script type="text/ecmascript-6">
import { getDept } from "@/api/api";
export default {
  data() {
    return {
      isCollapse: false,
      // 树控件需要的
      listLoading: false,
      // 部门信息加职工
      depData: [],
      filterText: ""
    };
  },
  created() {
    this.getList();
  },
  watch: {
    // 监听输入值
    filterText(val) {
      this.$refs.staffTree.filter(val);
    }
  },
  methods: {
    //折叠
    collapse: function() {
      this.isCollapse = !this.isCollapse;
    },
    // 获取部门信息包括职工
    getList() {
      this.listLoading = true;
      let param = {};
      let num = 0;
      getDept(param)
        .then(res => {
          let deptData = res.data.data.deptData;
          deptData.forEach(dept => {
            this.depData.push({
              id: dept.staffParamId,
              label: dept.staffParamName,
              children: []
            });
            dept.staffModels.forEach(staff => {
              this.depData[num].children.push({
                id: staff.id,
                label: staff.name
              });
            });
            num++;
          });
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 渲染函数
    renderContent(h, { node, data, store }) {
      // console.log(node);
      if (node.level == 1) {
        return (
          <span>
            <span>
              <span>
                {" "}
                <svg class="icon" aria-hidden="true">
                  <use xlinkHref="#icon-bumen" />
                </svg>
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
                <svg class="icon" aria-hidden="true">
                  <use xlinkHref="#icon-account" />
                </svg>
                <span class="label">{node.label}</span>{" "}
              </span>
            </span>
          </span>
        );
      }
    },
    // 筛选函数
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点被点击时的回调
    nodeClick(object, node, component) {
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
    width: 250px;
    height: auto;
  }

  span {
    padding-left: 20px;
  }
}
</style>
