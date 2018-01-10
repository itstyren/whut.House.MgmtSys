<template>
  <div class="second-container">
    <aside :class="{showSidebar:!isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button">
       <el-input v-model="filterText" placeholder="输入职工搜索" class="filter"></el-input>
      </div>
            <!-- 主菜单 -->
            <el-tree v-loading="listLoading" ref="staffTree" :data="depData" :render-content="renderContent" :filter-node-method="filterNode" @node-expand="nodeExpand"></el-tree>
    </aside>
        <section class="main-container">
      <!-- 需要长时间存活的 -->
      <transition>
        <keep-alive>
          <router-view v-if="$route.meta.keepAlive"></router-view>
        </keep-alive>
      </transition>
      <!-- 不需要长时间保存的 -->
      <transition mode="out-in">
        <router-view v-if="!$route.meta.keepAlive"></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import { getDept } from "@/api/api";
export default {
  data() {
    return {
      isCollapse: false,
      // 树控件需要的
      listLoading:false,
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
          console.log(this.depData);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 渲染函数
    renderContent(h, { node, data, store }) {
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
    },
    // 筛选函数
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点展开时获取
    nodeExpand(value, node, component) {
      console.log(value)
      this.$router.push({
        path: '/basic/staff/byDept/'+value.id
      });
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
