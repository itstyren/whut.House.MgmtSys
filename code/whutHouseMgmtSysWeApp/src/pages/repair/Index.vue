<template>
<div class="container">

  <!-- <div class="doc-title zan-hairline--bottom">维修申请</div> -->
  <div class="zan-panel">
    <form>

    <div class="zan-cell">
        <div class="zan-cell__bd">
            <ZanSteps v-bind="{ steps: steps }"/>
        </div>
    </div>
    <!-- 基础信息区块 -->
    <div class="zan-panel" :hidden="stepOne">
      <zan-field v-bind="Object.assign({}, handleFunctions, base.accountID)" :disabled="true" :value="baseUserInfo.id"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.name)" :disabled="true" :value="baseUserInfo.name"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.zheng)" :disabled="true" :value="baseUserInfo.code"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.sex)" :disabled="true"  :value="baseUserInfo.sex"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.zhiwu)" :disabled="true" :value="baseUserInfo.titleName"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.danwei)" :disabled="true" :value="baseUserInfo.deptName"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.tel)" :value="baseUserInfo.tel"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, base.email)" :value="baseUserInfo.email"/>
      <div class="zan-row">
        <div class="zan-col zan-col-16 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" @click="btnStepNextClick">下一步</button>
        </div>
      </div>
    </div>
    <!-- 选择住房区块 -->
    <div class="zan-panel" :hidden="stepTwo">
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">选择住房</div>
            <picker
              mode="selector"
              class="zan-field__input zan-cell__bd"
              :range="houseBase.address"
              :value="houseBase.selectIndex"
              @change="seletHouseChange"
            >
              {{ houseBase.address[houseBase.selectIndex] }}
            </picker>
      </div>
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseID)" :disabled="true" :value="houseInfo.id"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseType)" :disabled="true" :value="houseInfo.typeName" />
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseAddress)" :disabled="true" :value="houseInfo.address"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseArea)" :disabled="true" :value="houseInfo.usedArea"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseStatus)" :disabled="true" :value="houseInfo.statusName"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, houseBase.houseUsedArea)" :disabled="true" :value="houseInfo.usedArea"/>
      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-2">
          <button class="zan-btn  zan-btn--warn" @click="btnStepBackClick">上一步</button>
        </div>
        <div class="zan-col zan-col-8 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" @click="btnStepNextClick">下一步</button>
        </div>
      </div>
    </div>
    <!-- 填写原因提交区块 -->
    <div class="zan-panel" :hidden="stepThree">
      <div class="zan-row">
        <div >
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">填写原因</div>
            <picker
              mode="selector"
              class="zan-field__input zan-cell__bd"
              :range="fixBase.fixParam"
              :value="fixBase.selectIndex"
              range-key="fixParamName"
              @change="seletFixParamChange"
            >
              {{ fixBase.fixParam[fixBase.selectIndex].fixParamName }}
            </picker>
          </div>
        </div>
      </div>
      <zan-field v-bind="Object.assign({}, handleFunctions, fixBase.repairReason)"/>
      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-2">
          <button class="zan-btn  zan-btn--warn" @click="btnStepBackClick">上一步</button>
        </div>
        <div class="zan-col zan-col-8 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" @click="btnSubmitClick">提交</button>
        </div>
      </div>
    </div>

    </form>
  </div>

</div>
</template>

<script>
import store from "../../store/index";
import ZanSteps from "../../components/zan/steps";
import ZanField from "../../components/zan/field";
import { getStaffInfo,getFixParam } from "@/api";
export default {
  data() {
    return {
      baseUserInfo: [],
      houseInfo:[],
      houseList:[],
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
          text: "选择住房"
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

      fixBase: {
        fixParam: [],
        selectIndex: 0,
        repairReason: {
          title: "申请原因",
          type: "textarea",
          placeholder:
            "请详细描述您的住房困难及要求，并留下您的联系方式，以便工作人员和您联系！",
          componentId: "description"
        }
      },
      handleFunctions: {
        handleZanFieldChange: this.handleZanFieldChange,
        handleZanFieldFocus: this.handleZanFieldFocus,
        handleZanFieldBlur: this.handleZanFieldBlur
      }
    };
  },
  computed: {
    count() {
      return store.state.count;
    }
  },
  components: {
    ZanSteps,
    ZanField
  },
  mounted() {
    // 这个不能用created方法
    this.baseUserInfo = this.$store.state.userinfo;
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
        let staffID = this.$store.state.userinfo.id;
        // 获取用户的住房信息
        getStaffInfo(staffID).then(res => {
          if (res.data.data.listHouseGetApply.length === 0) {
            this.houseBase.address.push("暂无住房");
          } else {
            this.houseList = res.data.data.listHouseGetApply;
            var _list = [];
            this.houseList.forEach(element => {
              _list.push(element.address);
            });
            this.houseBase.address = _list;
            this.houseInfo=this.houseList[0]
          }
        });
      } else if (this.step == 2) {
        this.step++;
        this.steps[2].done = true;
        this.steps[2].current = true;
        (this.stepOne = true), (this.stepTwo = true), (this.stepThree = false);
        getFixParam({},16).then(res=>{
                  this.fixBase.fixParam=res.data.data.list
                    console.log(this.fixBase.fixParam)
        })
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
      } else {
        return;
      }
    },
    pageClose() {
      this.step = 1;
      this.stepOne = false;
      this.stepTwo = true;
      this.stepThree = true;
    },
    btnSubmitClick() {
      this.btnStepBackClick();
      this.btnStepBackClick();
      const url = "../index/main";
      wx.switchTab({ url });
    },
    // 用户选择住房改变
    seletHouseChange(e) {
      this.houseBase.selectIndex = e.target.value;
                  this.houseInfo=this.houseList[e.target.value]
    },
    // 选择维修信息改变
    seletFixParamChange(e){
      this.fixBase.selectIndex=e.target.value;
    },
    getApply() {
      let getApply_param = store.state.userinfo.id;
      wx.request({
        url: store.state.API_URL + "/fix/getApply",
        method: "GET",
        data: getApply_param,
        header: {
          "content-type": "application/json", // 默认值
          "X-token": store.state.access_token
        },
        success: function(_res) {
          console.log(_res);
        }
      });
    }
  }
};
</script>

<style >
.red {
  color: #f00;
}
.zan-col {
  line-height: 30px;
  text-align: center;
  background-color: #39a9ed;
  font-size: 12px;
  color: #fff;
}

.zan-row {
  padding-bottom: 30px;
  padding-top: 20px;
}

.zan-col:nth-child(even) {
  background-color: #66c6f2;
}

.doc-title {
  text-align: center;
}
</style>
