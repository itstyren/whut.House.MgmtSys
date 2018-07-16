<template>
  <div class="page">
    <div class="step-bar ">
      <div class="_card">
      <ZanSteps v-bind="{ steps: steps }" />
      </div>
    </div>
    <!-- 基础信息区块 -->
    <div class="fix-apply">
        <div class="_card" :hidden="stepOne">
          <zan-field v-bind="Object.assign({}, handleFunctions, base.accountID)" :disabled="true" :value="baseUserInfo.id" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.name)" :disabled="true" :value="baseUserInfo.name" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.zheng)" :disabled="true" :value="baseUserInfo.code" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.sex)" :disabled="true" :value="baseUserInfo.sex" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.zhiwu)" :disabled="true" :value="baseUserInfo.titleName" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.danwei)" :disabled="true" :value="baseUserInfo.deptName" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.tel)" :value="baseUserInfo.tel" />
          <zan-field v-bind="Object.assign({}, handleFunctions, base.email)" :value="baseUserInfo.email" />
        </div>
        <!-- 选择住房区块 -->
        <div class="_card" :hidden="stepTwo">
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">选择住房</div>
            <picker mode="selector" class="zan-field__input zan-cell__bd" :range="houseBase.address" :value="houseBase.selectIndex" @change="seletHouseChange">
              {{ houseBase.address[houseBase.selectIndex] }}
            </picker>
          </div>
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseID)" :disabled="true" :value="houseInfo.id" />
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseType)" :disabled="true" :value="houseInfo.typeName"
          />
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseAddress)" :disabled="true" :value="houseInfo.address"
          />
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseArea)" :disabled="true" :value="houseInfo.usedArea"
          />
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseStatus)" :disabled="true" :value="houseInfo.statusName"
          />
          <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseUsedArea)" :disabled="true" :value="houseInfo.usedArea"
          />
        </div>
        <!-- 填写原因提交区块 -->
        <div class="_card" :hidden="stepThree">
            <div class="zan-cell zan-field">
              <div class="zan-cell__hd zan-field__title">填写原因</div>
              <textarea v-model="hireBase.description" style="height: 3.3em"  placeholder="请详细描述您的住房困难及要求，谢谢！" />
          </div>
        </div>
      </div>
    <!-- 按钮区域 -->
    <div class="button-area">
      <button class="left-button" v-if="step!=1" @click="btnStepBackClick" :class="{'zan-btn':true,'zan-btn--warn':true}">上一步</button>
      <button class="right-button" v-if="step!=3" @click="btnStepNextClick" :class="{'zan-btn':true,'zan-btn--primary':true}">下一步</button>
      <button class="right-button" v-else @click="checkSubmit" :class="{'zan-btn':true,'zan-btn--primary':true}">提交</button>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import ZanSteps from "@/components/zan/steps";
import ZanField from "@/components/zan/field";
import { getStaffInfo, getFixParam, postFixApply } from "@/api";
export default {
  data() {
    return {
      baseUserInfo: [],
      houseInfo: [],
      houseList: [],
      step: 1,
      stepOne: false,
      stepTwo: true,
      stepThree: true,
      steps: [
        {
          current: true,
          done: false,
          text: "基本信息"
        },
        {
          done: false,
          current: false,
          text: "信息确认"
        },
        {
          done: false,
          current: false,
          text: "填写原因"
        }
      ],
      // 基础信息页组件信息
      base: {
        accountID: {
          title: "职工号",
          componentId: "accountID"
        },
        name: {
          title: "姓名",
          componentId: "name"
        },
        zheng: {
          title: "身份证号",
          inputType: "number",
          componentId: "zheng"
        },
        sex: {
          title: "性别",
          componentId: "sex"
        },
        zhiwu: {
          title: "职务",
          componentId: "zhiwu"
        },
        danwei: {
          title: "单位",
          componentId: "danwei"
        },

        tel: {
          title: "联系电话",
          inputType: "number",
          placeholder: "请输入手机号",
          componentId: "tel"
        },
        email: {
          title: "邮箱",
          placeholder: "请输入邮箱",
          componentId: "email"
        }
      },
      // 住房选择页组件信息
      houseBase: {
        address: [],
        selectIndex: 0,
        houseID: {
          title: "住房号",
          componentId: "houseID"
        },
        houseType: {
          title: "住房类型",
          componentId: "houseType"
        },
        houseAddress: {
          title: "住房地址",
          componentId: "houseAddress"
        },
        houseArea: {
          title: "住房面积",
          componentId: "houseArea"
        },
        houseStatus: {
          title: "产权关系",
          componentId: "houseStatus"
        },
        houseUsedArea: {
          title: "使用面积",
          componentId: "houseUsedArea"
        }
      },
      hireBase: {
        fixParam: [
          {
            fixParamName: ""
          }
        ],
        selectIndex: 0,
        description: "",
        fixContentId: ""
      },
      handleFunctions: {
        handleZanFieldChange: this.handleZanFieldChange,
        handleZanFieldFocus: this.handleZanFieldFocus,
        handleZanFieldBlur: this.handleZanFieldBlur
      },
      zanDialog: {
        name: "",
        show: false,
        title: "",
        content: "",
        buttons: [],
        buttonsShowVertical: true,
        res: {}
      }
    };
  },
  components: {
    ZanSteps,
    ZanField
  },
  mounted() {
    this.step=1
    wx.showLoading({
      title: "加载中"
    });
    // 这个不能用created方法
    this.baseUserInfo = this.$store.state.userinfo;
    let staffID = this.$store.state.userinfo.id;
    // 获取用户的住房信息
    getStaffInfo(staffID).then(res => {
      try {
        if (res.data.data.listHouseGetApply.length === 0) {
          this.houseBase.address.push("暂无住房");
        } else {
          this.houseList = res.data.data.listHouseGetApply;
          var _list = [];
          this.houseList.forEach(element => {
            _list.push(element.address);
          });
          this.houseBase.address = _list;
          this.houseInfo = this.houseList[0];
        }
      } catch (error) {
        wx.showModal({
          title: "提示",
          content: "无住房，不可申请维修",
          success: function(res) {
            if (res.confirm) {
              const url = "../index/main";
              wx.switchTab({
                url
              });
            } else if (res.cancel) {
              const url = "../index/main";
              wx.switchTab({
                url
              });
            }
          }
        });
      }
    });
    getFixParam({}, 16).then(res => {
      this.hireBase.fixParam = res.data.data.list;
      this.hireBase.fixContentId = this.hireBase.fixParam[0].fixParamId;
      wx.hideLoading();
    });
  },
  methods: {
    handleZanFieldChange(e) {
      const { componentId, target, detail } = e;
    },

    handleZanFieldFocus(e) {
      const { componentId, target, detail } = e;
    },

    handleZanFieldBlur(e) {
      const { componentId, target, detail } = e;
    },
    // 点击下一步
    btnStepNextClick() {
      if (this.step == 1) {
        this.step++;
        this.steps[1].done = true;
        this.steps[1].current = true;
        (this.stepOne = true), (this.stepTwo = false), (this.stepThree = true);
      } else if (this.step == 2) {
        this.step++;
        this.steps[2].done = true;
        this.steps[2].current = true;
        (this.stepOne = true), (this.stepTwo = true), (this.stepThree = false);
      }
    },
    btnStepBackClick() {
      if (this.step == 3) {
        this.step--;
        this.steps[2].done = false;
        this.steps[2].current = false;
        (this.stepOne = true), (this.stepTwo = false), (this.stepThree = true);
      } else if (this.step == 2) {
        this.step--;
        this.steps[1].done = false;
        this.steps[1].current = false;
        (this.stepOne = false), (this.stepTwo = true), (this.stepThree = true);
      }
    },
    pageClose() {
      this.step = 1;
      this.stepOne = false;
      this.stepTwo = true;
      this.stepThree = true;
    },
    // 用户选择住房改变
    seletHouseChange(e) {
      this.houseBase.selectIndex = e.target.value;
      this.houseInfo = this.houseList[e.target.value];
    },
    // 选择维修信息改变
    seletFixParamChange(e) {
      this.hireBase.selectIndex = e.target.value;
      this.hireBase.fixContentId = this.hireBase.fixParam[
        e.target.value
      ].fixParamId;
    },
    // 提交申请验证
    checkSubmit() {
      let _this = this;
      wx.showModal({
        title: "提示",
        content: "确认提交",
        success: function(res) {
          if (res.confirm) {
            _this.addSubmit();
          } else if (res.cancel) {
            console.log("用户点击取消");
          }
        }
      });
    },
    // 提交维修申请
    addSubmit() {
      wx.showLoading({
        title: "加载中"
      });
      let applyForm = {
        description: this.hireBase.description,
        email: this.baseUserInfo.email,
        fixContentId: this.hireBase.fixContentId,
        houseId: this.houseInfo.id,
        phone: this.baseUserInfo.tel,
        staffId: this.$store.state.userinfo.id
      };
      postFixApply(applyForm).then(res => {
        wx.hideLoading();
        wx.showToast({
          title: "提交成功",
          icon: "success",
          duration: 2500
        });
        setTimeout(() => {
          const url = "../index/main";
          wx.switchTab({
            url
          });
        }, 2500);
      });
    }
  }
};
</script>

<style scoped lang="scss">
.fix-apply{
  margin: 0 10px;
}
.step-bar{
  margin:0 10px;
  ._card{
    height: 30px;
  }
}
</style>
