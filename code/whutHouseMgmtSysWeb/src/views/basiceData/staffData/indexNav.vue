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
        <!-- 全部职工的时候的tree控件 -->
        <el-tree v-show="isAllStaffShow"
                 class="aside-tree"
                 v-loading="allStaffListLoading"
                 element-loading-text="加载中"
                 element-loading-spinner="el-icon-loading"
                 element-loading-background="rgba(0, 0, 0, 0.8)"
                 ref="AllStaffTree"
                 accordion
                 :data="allStaffData"
                 :props="props"
                 :render-content="renderContent"
                 @node-click="nodeClick"></el-tree>
        <!-- 部分职工的时候的tree控件 -->

        <el-tree v-show="!isAllStaffShow"
                 class="aside-tree"
                 v-loading="partStaffListLoading"
                 element-loading-text="加载中"
                 element-loading-spinner="el-icon-loading"
                 element-loading-background="rgba(0, 0, 0, 0.8)"
                 ref="PartStaffTree"
                 :default-expand-all="true"
                 :data="partStaffData"
                 :props="props"
                 :render-content="renderContent"
                 @node-click="nodeClick"></el-tree>
      </scroll-bar>
    </aside>
    <section :class="{'special-container':staffShow,'main-container':!staffShow}">
      <transition mode="out-in">
        <router-view :dep-data="isAllStaffShow?allStaffData:partStaffData"></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import ScrollBar from "@/components/ScrollBar";
import { getDept, getDeptsByInput } from "@/api/basiceData";
let _ = require("underscore");
import * as types from "../../../store/mutation-types";
export default {
  data () {
    return {
      // 是否显示全部员工的tree控件
      isAllStaffShow: true,
      // 树控件需要的
      allStaffListLoading: false,
      partStaffListLoading: false,
      //搜索一名员工
      searchText: "",
      // 全部员工
      allStaffData: [],
      //搜索到的部分员工
      partStaffData: [],
      props: {
        label: (data, node) => {
          return node.level == 1 ? node.data.staffParamName : node.data.name
        },
        children: 'staffModels',
      },
    };
  },
  components: {
    ScrollBar
  },
  created () {
    this.getList();
    this.$watch('searchText', _.debounce((newVal, oldVal) => {
      // 假如搜索框是空的就搜索全部员工
      if (newVal == '') {
        this.isAllStaffShow = true
        this.getList()
      } else {
        this.isAllStaffShow = false
        this.getStaffByNoOrName(newVal)
      }
    }, 1000, false))
  },
  computed: {
    staffShow () {
      return this.$store.state.app.staffShow;
    }
  },
  watch: {
  },
  methods: {
    // 初始化数据
    getList () {
      this.allStaffListLoading = true;
      let param = {};
      let num = 0;
      getDept(param)
        .then(res => {
          this.allStaffData = res.data.data.deptData;
          this.allStaffListLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
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
    getStaffByNoOrName (text) {
      this.partStaffListLoading = true;
      getDeptsByInput(text).then(res => {
        let deptData = res.data.data.deptData;
        this.partStaffData = deptData.filter(item => {
          return item.staffModels.length !== 0
        })
        this.partStaffListLoading = false;
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
