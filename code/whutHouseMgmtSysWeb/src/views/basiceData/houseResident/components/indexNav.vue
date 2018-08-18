<template>
    <aside>
        <scroll-bar>
      <!-- 展开关闭按钮 -->
      <div class="filter-button">
        <el-input v-model="filterText" placeholder="输入职工搜索" class="filter"></el-input>
      </div>
      <!-- 主菜单 -->
      <el-tree v-loading="listLoading" ref="staffTree" :data="depData" :render-content="renderContent" :filter-node-method="filterNode"
        @node-click="nodeClick"></el-tree>
        </scroll-bar>
    </aside>
</template>

<script type="text/ecmascript-6">
import { getDept } from "@/api/basiceData";
import * as types from "../../../../store/mutation-types";
import ScrollBar from "@/components/ScrollBar";
export default {
  data() {
    return {
      // 树控件需要的
      listLoading: false,
      // 部门信息加职工
      depData: [],
      filterText: ""
    };
  },
  components: {
    ScrollBar
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
    // 筛选函数
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点被点击时的回调
    nodeClick(object, node, component) {
      //console.log(node);
      if (node.level == 1) {
        return;
      } else if (node.level == 2) {
        this.$store.commit(types.RESIDENT_STAFF, object);
        this.$emit('select-staff',object)
      }
    }
  }
};
</script>

<style scoped lang="scss">

</style>
