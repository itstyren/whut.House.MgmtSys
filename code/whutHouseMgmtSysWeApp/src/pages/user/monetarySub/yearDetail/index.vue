<template>
  <div class="page">
    <div class="_card fix-detail ">
      <div class="title">
        <span>本年度补贴计算</span>
      </div>
      <div class="content">
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.annualSal)" :disabled="true" v-model.lazy="paramBase.formData.annualSal"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.join)" :disabled="true" v-model.lazy="paramBase.formData.join"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.staffParamHouseArea)" :disabled="true" v-model.lazy="paramBase.formData.staffParamHouseArea"
        />
        <zan-field  v-bind="Object.assign({}, handleFunctions, paramBase.usedArea)" :disabled="true"
          v-model.lazy="paramBase.formData.usedArea" />
        <zan-field  v-bind="Object.assign({}, handleFunctions, paramBase.areaNotUpToStandard)"
          :disabled="true" v-model.lazy="paramBase.formData.areaNotUpToStandard" />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.subsidies)" :disabled="true" v-model.lazy="paramBase.formData.subsidies"
        />
        <zan-field v-bind="Object.assign({}, handleFunctions, paramBase.promoteSub)" :disabled="true" v-model.lazy="paramBase.formData.promoteSub"
        />
      </div>
    </div>
    <div class="_card formula ">
      <strong>核算标准：</strong>
      <span>逐月住房补贴(元)=职工月工资总额×1.2806×20％÷职工住房补贴面积标准×未达标面积</span>
      <br />
      <span>老职工职务晋升补贴(元)＝698×(新职务住房补贴面积标准一原职务住房补贴面积标准)</span>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import ZanField from "@/components/zan/field";
  import {
    getStaffMonetaryParameter
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
          annualSal: {
            title: "年度工资",
            componentId: "annualSal"
          },
          join: {
            title: "入职时间",
            componentId: "join"
          },
          staffParamHouseArea: {
            title: "面积标准",
            componentId: "staffParamHouseArea"
          },
          usedArea: {
            title: "已购面积",
            componentId: "usedArea"
          },
          areaNotUpToStandard: {
            title: "差额面积",
            componentId: "areaNotUpToStandard"
          },
          subsidies: {
            title: "实发补贴",
            subsidies: "subsidies"
          },
          promoteSub: {
            title: "晋升补贴",
            promoteSub: "promoteSub"
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
        getStaffMonetaryParameter(this.staffID).then(res => {
          // console.log(res.data);
          this.paramBase.formData = res.data.data;
          if (this.paramBase.formData.oldStaff) {
            this.paramBase.formData.join = "99年之前";
          } else {
            this.paramBase.formData.join = "99年之后";
          }
          this.params = res.data.data;
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

  .formula {
    strong {
      font-weight: 600
    }
    span {
      font-size: 14px;
    }
  }

</style>
