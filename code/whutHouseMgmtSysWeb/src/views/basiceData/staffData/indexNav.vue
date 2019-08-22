<template>
  <div class="second-container">
    <aside>
      <scroll-bar>
        <!-- 展开关闭按钮 -->
        <div class="filter-button">
          <el-input v-model="searchText"
                    placeholder="输入职工搜索"
                    class="filter"></el-input>
        </div>
        <!-- 主菜单 -->
        <el-tree class="aside-tree"
                 v-loading="listLoading"
                 ref="staffTree"
                 accordion
                 lazy
                 :props="props"
                 :load="handleLoadNodeData"
                 :render-content="renderContent"
                 @node-click="nodeClick"></el-tree>
      </scroll-bar>
    </aside>
    <section :class="{'special-container':staffShow,'main-container':!staffShow}">
      <transition mode="out-in">
        <router-view :dep-data="depData"></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import { getAllDept, getSimpleStaffInfo } from "@/api/basiceData";
import ScrollBar from "@/components/ScrollBar";
import * as types from "../../../store/mutation-types";
export default {
  data () {
    return {
      // 树控件需要的
      listLoading: false,
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
  components: {
    ScrollBar
  },
  created () {
    // this.getAllDept()
  },
  computed: {
    staffShow () {
      return this.$store.state.app.staffShow;
    }
  },
  watch: {
    // 监听输入值
    // filterText (val) {
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
      //加载部门
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
      // 加载员工
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
    // 节点被点击时的回调
    nodeClick (object, node, component) {
      //点击部门时展开
      if (node.level == 1) {
        this.$store.commit("SET_STAFF_SHOW", false);
        this.$router.push({
          path: "/basic/staff/byDept/" + object.staffParamId
        });
      }
      // 点击员工时跳转到员工详情
      else {
        this.$store.commit("SET_STAFF_SHOW", true);
        this.$store.commit(types.STAFF_MODIFY, false);
        this.$router.push({
          path: "/basic/staff/byId/" + object.id
        });
      }
    },
    // 根据职工号和姓名搜索员工
    getStaffByNoOrName () {
      getStaffByNoOrName(params).then(res => {
        this.staffData = res.data.data.data.list

      })
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";
.second-container {
  background-color: $background-grey;
}
.special-container {
  background-color: $background-grey;
}
</style>
