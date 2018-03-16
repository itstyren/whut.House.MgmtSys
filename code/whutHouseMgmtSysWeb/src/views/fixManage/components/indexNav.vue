<template>
    <aside>
      <!-- 展开关闭按钮 -->
      <div class="filter-button">
        <el-input v-model="filterText" placeholder="输入关键词搜索" class="filter"></el-input>
      </div>
      <!-- 主菜单 -->
      <el-tree v-loading="listLoading" ref="fixTree" :data="fixData" :render-content="renderContent" :filter-node-method="filterNode"
        @node-click="nodeClick"></el-tree>
    </aside>
</template>

<script type="text/ecmascript-6">
import { getFixAccept, getFixAgree } from "@/api/fixManage";
export default {
  data() {
    return {
      // 树控件需要的
      listLoading: false,
      filterText: "",
      fixData: []
    };
  },
  // 获取父组件传递的数据
  props: {
    fixStatus: {
      type: String,
      default: "hangding"
    },
    isSubmit: {
      type: Boolean
    }
  },
  created() {
    //console.log(this.fixStatus)
    if (this.fixStatus == "hangding") this.getHandingList();
    else this.getReviewList();
  },
  watch: {
    // 监听输入值
    filterText(val) {
      this.$refs.fixTree.filter(val);
    },
    isSubmit(newVal) {
      this.fixData = [];
      if (this.fixStatus == "hangding") this.getHandingList();
      else this.getReviewList();
    }
  },
  methods: {
    // 获取所有需要受理信息
    getHandingList() {
      this.listLoading = true;
      let param = {};
      // 获取未受理的
      getFixAccept(param,0)
        .then(res => {
          let fixData = res.data.data.data;
          this.fixData.push({
            id: 0,
            label: "待受理业务",
            children: []
          });
          fixData.forEach(data => {
            this.fixData[0].children.push({
              id: data.fixContentId,
              label: data.fixContentName + "【" + data.staffName + "】",
              content: data,
              status: false
            });
          });
          // 获取已经受理的
          getFixAccept(param,1)
            .then(res => {
              let fixData = res.data.data.data;
              this.fixData.push({
                id: 1,
                label: "已受理业务",
                children: []
              });
              fixData.forEach(data => {
                this.fixData[1].children.push({
                  id: data.fixContentId,
                  label: data.fixContentName + "【" + data.staffName + "】",
                  content: data,
                  status: true
                });
              });
              this.listLoading = false;
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(err => {
          console.log(err);
        });
    },
    getReviewList() {
      this.listLoading = true;
      let param = {};
      // 获取未受理的
      getFixAgree(param,0)
        .then(res => {
          let fixData = res.data.data.data;
          this.fixData.push({
            id: 0,
            label: "待审核业务",
            children: []
          });
          fixData.forEach(data => {
            this.fixData[0].children.push({
              id: data.fixContentId,
              label: data.fixContentName + "【" + data.staffName + "】",
              content: data,
              status: false
            });
          });
          // 获取已经受理的
          getFixAgree(param,1)
            .then(res => {
              let fixData = res.data.data.data;
              this.fixData.push({
                id: 1,
                label: "已审核业务",
                children: []
              });
              fixData.forEach(data => {
                this.fixData[1].children.push({
                  id: data.fixContentId,
                  label: data.fixContentName + "【" + data.staffName + "】",
                  content: data,
                  status: true
                });
              });
              this.listLoading = false;
            })
            .catch(err => {
              console.log(err);
            });
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
                <span class="label" style="font-size:13px;">{node.label}</span>{" "}
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
        this.$emit("emit-form", object);
      }
    }
  }
};
</script>

<style scoped lang="scss">

</style>
