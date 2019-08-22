<template>
  <aside>
    <scroll-bar>
      <!-- 展开关闭按钮 -->
      <div class="filter-button">
        <el-input v-model="filterText"
                  placeholder="输入关键词搜索"
                  class="filter"></el-input>
      </div>
      <!-- 主菜单 -->
      <el-tree v-loading="listLoading"
               ref="hireTree"
               :data="hireData"
               :render-content="renderContent"
               :filter-node-method="filterNode"
               @node-click="nodeClick"></el-tree>

    </scroll-bar>
  </aside>
</template>

<script type="text/ecmascript-6">
import { getHireAccept, getHireAgree, getHireApprove, getHireContract } from "@/api/leaseManage";
import ScrollBar from "@/components/ScrollBar";
export default {
  data () {
    return {
      // 树控件需要的
      listLoading: false,
      filterText: "",
      hireData: []
    };
  },
  components: {
    ScrollBar
  },
  // 获取父组件传递的数据
  props: {
    hireStatus: {
      type: String,
      default: "accept"
    },
    isSubmit: {
      type: Boolean
    }
  },
  created () {
    //console.log(this.hireStatus)
    if (this.hireStatus == "accept") this.getHandingList();
    else if (this.hireStatus == "agree") {
      this.getReviewList();
    } else if (this.hireStatus == "approve") this.getApprove();
    else this.getContract();
  },
  watch: {
    // 监听输入值
    filterText (val) {
      this.$refs.hireTree.filter(val);
    },
    isSubmit (newVal) {
      this.hireData = [];
      if (this.hireStatus == "accept") this.getHandingList();
      else if (this.hireStatus == "agree") {
        this.getReviewList();
      } else if (this.hireStatus == "approve") this.getApprove();
      else this.getContract();
    }
  },
  methods: {
    // 获取所有需要受理信息
    getHandingList () {
      this.listLoading = true;
      let param = {};
      // 获取未受理的
      getHireAccept(param, 0)
        .then(res => {
          let hireData = res.data.data.data;
          this.hireData.push({
            id: 0,
            label: "待受理业务",
            children: []
          });
          hireData.forEach(data => {
            this.hireData[0].children.push({
              id: data.id,
              label: "【" + data.name + "】" + data.applyTime,
              content: data,
              status: false
            });
          });
          // 获取已经受理的
          getHireAccept(param, 1)
            .then(res => {
              let hireData = res.data.data.data;
              this.hireData.push({
                id: 1,
                label: "已受理业务",
                children: []
              });
              hireData.forEach(data => {
                this.hireData[1].children.push({
                  id: data.id,
                  label: "【" + data.name + "】" + data.applyTime,
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
    // 获取需要审核的信息
    getReviewList () {
      this.listLoading = true;
      let param = {};
      // 获取未受理的
      getHireAgree(param, 0)
        .then(res => {
          let hireData = res.data.data.data;
          this.hireData.push({
            id: 0,
            label: "待审核业务",
            children: []
          });
          hireData.forEach(data => {
            this.hireData[0].children.push({
              id: data.id,
              label: "【" + data.name + "】" + data.applyTime,
              content: data,
              status: false
            });
          });
          // 获取已经受理的
          getHireAgree(param, 1)
            .then(res => {
              let hireData = res.data.data.data;
              this.hireData.push({
                id: 1,
                label: "已审核业务",
                children: []
              });
              hireData.forEach(data => {
                this.hireData[1].children.push({
                  id: data.id,
                  label: "【" + data.name + "】" + data.applyTime,
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
    // 获取需要审批的信息
    getApprove () {
      this.listLoading = true;
      let param = {};
      // 获取审批的
      getHireApprove(param, 0)
        .then(res => {
          let hireData = res.data.data.data;
          this.hireData.push({
            id: 0,
            label: "待审批业务",
            children: []
          });
          hireData.forEach(data => {
            this.hireData[0].children.push({
              id: data.id,
              label: "【" + data.name + "】" + data.applyTime,
              content: data,
              status: false
            });
          });
          // 获取已经受理的
          getHireApprove(param, 1)
            .then(res => {
              let hireData = res.data.data.data;
              this.hireData.push({
                id: 1,
                label: "已审批业务",
                children: []
              });
              hireData.forEach(data => {
                this.hireData[1].children.push({
                  id: data.id,
                  label: "【" + data.name + "】" + data.applyTime,
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
    // 获取合同信息
    getContract () {
      this.listLoading = true;
      let param = {};
      // 获取审批的
      getHireContract()
        .then(res => {
          let hireData = res.data.data.data;
          this.hireData.push({
            id: 0,
            label: "待签订业务",
            children: []
          });
          hireData.forEach(data => {
            this.hireData[0].children.push({
              id: data.id,
              label: "【" + data.name + "】" + data.applyTime,
              content: data,
              status: false
            });
          });
          this.listLoading = false
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 渲染函数
    renderContent (h, { node, data, store }) {
      // console.log(node);
      if (node.level == 1) {
        return (
          <span>
            <span>
              <span>

                <my-icon icon-class="bumen" />
                <span class="label">{node.label}</span>
              </span>
            </span>
          </span>
        );
      } else {
        return (
          <span>
            <span>
              <span>

                <span class="label" style="font-size:13px;">{node.label}</span>
              </span>
            </span>
          </span>
        );
      }
    },
    // 筛选函数
    filterNode (value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },
    // 节点被点击时的回调
    nodeClick (object, node, component) {
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
