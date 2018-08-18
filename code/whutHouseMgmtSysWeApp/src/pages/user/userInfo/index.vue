<template>
  <div class="page">
    <div class="_card fix-detail ">
      <div class="title">
        <span>个人信息</span>
      </div>
      <div class="content">
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.name)" :disabled="true" v-model.lazy="paramBase.formData.name"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.deptName)" :disabled="true" v-model.lazy="paramBase.formData.deptName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.titleName)" :disabled="true" v-model.lazy="paramBase.formData.titleName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.postName)" :disabled="true" v-model.lazy="paramBase.formData.postName"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.tel)" :disabled="true" v-model.lazy="paramBase.formData.tel" />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.email)" :disabled="true" v-model.lazy="paramBase.formData.email" />
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import ZanField from "@/components/zan/field";
  import {
    getStaff
  } from "@/api";
  export default {
    data() {
      return {
        staffID: "",
        params: {},
        // 表单控件
        paramBase: {
          address: [],
          selectIndex: 0,
          formData: {},
          name: {
            title: "姓名",
            componentId: "name"
          },
          deptName: {
            title: "部门",
            componentId: "deptName"
          },
          titleName: {
            title: "职称",
            componentId: "titleName"
          },
          postName: {
            title: "职务",
            componentId: "postName"
          },
          tel: {
            title: "手机",
            componentId: "tel"
          },
          email: {
            title: "邮箱",
            email: "email"
          }
        }
      };
    },
    components: {
      ZanField
    },
    mounted() {
      this.staffID = this.$store.state.userinfo.id;
      this.getParam();
    },
    methods: {
      // 获取年度补贴具体参数
      getParam() {
                        wx.showLoading({
                title: "请稍后"
              });
        getStaff(this.staffID).then(res => {
                wx.hideLoading();
          this.paramBase.formData = res.data.data;

        });
      }
    }
  };

</script>

<style scoped lang="scss">
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

</style>
