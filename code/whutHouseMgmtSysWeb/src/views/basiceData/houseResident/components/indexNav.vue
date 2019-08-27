<template>
  <aside>
    <div class="scroll-container">
      <div class="scroll-wrapper">
        <div class="asid-button">
          <el-input v-model="searchText"
                    placeholder="输入职工搜索"
                    class="filter"></el-input>
        </div>
        <!-- 主菜单 -->
        <!-- 全部职工的时候的tree控件 -->
        <el-tree v-if="isAllStaffShow"
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

      </div>
    </div>
  </aside>
</template>

<script type="text/ecmascript-6">
import { getDept, getDeptsByInput } from "@/api/basiceData";
let _ = require("underscore");

import * as types from "../../../../store/mutation-types";
import ScrollBar from "@/components/ScrollBar";
export default {
  data () {
    return {
      isCollapse: false,
      // 树控件需要的
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
  watch: {

  },
  methods: {
    //折叠
    collapse: function () {
      this.isCollapse = !this.isCollapse;
    },
    // 获取部门信息包括职工
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

    },

    // 节点被点击时的回调
    nodeClick (object, node, component) {
      if (node.level == 1) {
        return;
      } else if (node.level == 2) {
        this.$store.commit(types.RESIDENT_STAFF, object);
        this.$emit('select-staff', object)
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
  .scroll-container {
    position: relative;
    width: 100%;
    height: 100%;
    background-color: #373d41;
    .scroll-wrapper {
      top: 0px;
      position: absolute;
      width: 100% !important;
    }
  }
}
</style>
