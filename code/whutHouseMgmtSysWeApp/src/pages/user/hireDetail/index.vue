<template>
  <div class="page">
    <div class="_card fix-detail ">
      <div class="title">
        <span>租赁申请</span>
      </div>
      <div class="content">
        <zan-field v-bind="Object.assign({}, handleFunctions, hireBase.applyTime)" :disabled="true" v-model.lazy="hireBase.formData.applyTime"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, hireBase.hireState)" :disabled="true" v-model.lazy="hireBase.formData.hireState"
        />
        <zan-field  v-bind="Object.assign({}, handleFunctions, hireBase.address)" :disabled="true" v-model.lazy="hireBase.formData.address"
        />
      </div>
    </div>
  </div>
</template>
<script type="text/ecmascript-6">
import ZanField from "@/components/zan/field";
import { getComponentByTag } from "@/utils/helper";
import { putFixComment } from "@/api";
export default {
  data() {
    return {
      canSubmit: false,
      isComment: false,
      // 表单控件
      hireBase: {
        address: [],
        selectIndex: 0,
        formData: {},
        applyTime: {
          title: "申请时间",
          componentId: "applyTime"
        },
        hireState: {
          title: "处理状态",
          hireState: "hireState"
        },
        address: {
          title: "预分配地址",
          componentId: "address",
          type:'textarea'
        }
      }
    };
  },
  components: {
    ZanField,
  },
  mounted() {
    // console.log(wx.getStorageSync("hireForm"))
    this.hireBase.formData = wx.getStorageSync("hireForm")[0];
  },
  methods: {}
};
</script>
<style scoped lang="scss">
.page {
  padding-top: 20px;
  .fix-detail {
    display: flex;
    flex-direction: column;
    font-size: 16px;
    .title {
      text-align: center;
      color: #6fafea;
    }
    .content {
      margin-top: 15px;
    }
  }
}
</style>
