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
    <div class="zan-panel" :hidden="stepTwo">
      <div class="zan-row">
        <div >
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">选择住房</div>
            <picker
              mode="selector"
              class="zan-field__input zan-cell__bd"
              :range="roomInfo.area"
              :value="roomInfo.areaIndex"
              @change="onAreaChange"
            >
              {{ roomInfo.area[roomInfo.areaIndex] }}
            </picker>
          </div>
        </div>
      </div>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomID)" :disabled="true" :value="value"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomType)" :disabled="true"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomAddress)" :disabled="true"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomArea)" :disabled="true" :value="value"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomBelonging)" :disabled="true"/>
      <zan-field v-bind="Object.assign({}, handleFunctions, roomInfo.roomActualArea)" :disabled="true"/>
      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-2">
          <button class="zan-btn zan-btn--primary" @click="btnStepBackClick">上一步</button>
        </div>
        <div class="zan-col zan-col-8 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" @click="btnStepNextClick">下一步</button>
        </div>
      </div>
    </div>
    <div class="zan-panel" :hidden="stepThree">
      <div class="zan-row">
        <div >
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">选择住房</div>
            <picker
              mode="selector"
              class="zan-field__input zan-cell__bd"
              :range="repairInfo.area"
              :value="repairInfo.areaIndex"
              @change="onAreaChange"
            >
              {{ repairInfo.area[repairInfo.areaIndex] }}
            </picker>
          </div>
        </div>
      </div>
      <zan-field v-bind="Object.assign({}, handleFunctions, repairInfo.repairReason)"/>
      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-2">
          <button class="zan-btn zan-btn--primary" @click="btnStepBackClick">上一步</button>
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

export default {
  data() {
    return {
      data: "你好",
      value: "123",
      baseUserInfo: [],
      userRoomCount: 0,
      userRoomInfo: [],
      step: 1,
      stepOne: false,
      stepTwo: true,
      stepThree: true,
      steps: [
        {
          current: true,
          done: true,
          text: "步骤一"
        },
        {
          done: false,
          current: false,
          text: "步骤二"
        },
        {
          done: false,
          current: false,
          text: "步骤三"
        }
      ],

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

      roomInfo: {
        area: [],
        areaIndex: 0,
        IsHaveRoom: false,

        roomID: {
          title: "住房号",
          componentId: "roomID"
        },
        roomType: {
          title: "住房类型",
          componentId: "roomType"
        },
        roomAddress: {
          title: "住房地址",
          componentId: "roomAddress"
        },
        roomArea: {
          title: "住房面积",
          componentId: "roomArea"
        },
        roomBelonging: {
          title: "产权关系",
          componentId: "roomBelonging"
        },
        roomActualArea: {
          title: "使用面积",
          componentId: "roomActualArea"
        }
      },

      repairInfo: {
        area: ["漏水", "墙面", "门窗损坏", "水龙头"],
        areaIndex: 0,
        repairReason: {
          title: "住房号",
          type: "textarea",
          placeholder:
            "请详细描述您的住房困难及要求，并留下您的联系方式，以便工作人员和您联系！",
          componentId: "roomID"
        }
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
  methods: {
    tap() {
      this.data += "0";
    },
    btnStepNextClick() {
      if (this.step == 1) {
        this.step++;
        this.steps[1].done = true;
        this.steps[1].current = true;
        (this.stepOne = true), (this.stepTwo = false), (this.stepThree = true);

        let getApply_param = store.state.userinfo.id;
        wx.request({
          url: store.state.API_URL + "/fix/getApply/" + getApply_param,
          method: "GET",
          data: getApply_param,
          header: {
            "content-type": "application/json", // 默认值
            "X-token": store.state.access_token
          },
          success: function(_res) {
            console.log(_res);
            if (_res.data.data.data.listHouseGetApply.length === 0) {
              this.roomInfo.area.push("暂无住房");
            } else {
              this.IsHaveRoom = true;
              this.userRoomInfo = _res.data.data.data.listHouseGetApply;
              this.userRoomCount = this.userRoomInfo.length;
              console.log("遍历数组");
              var data = _res.data.data.data.listHouseGetApply;
              var _data = [];
              data.forEach(element => {
                console.log(element);
                _data.push(element.address);
                console.log("+");
              });
              console.log(_data);
              this.roomInfo.area = _data;
            }
          }
        });
      } else if (this.step == 2) {
        this.step++;
        this.steps[2].done = true;
        this.steps[2].current = true;
        (this.stepOne = true), (this.stepTwo = true), (this.stepThree = false);
      } else {
        return;
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
    onAreaChange(e) {
      this.roomInfo.areaIndex = e.target.value;
      if (e.target.value == "0") {
        this.roomInfo.areaIndex = 0;
      }
      if (e.target.value == "1") {
        this.roomInfo.areaIndex = 1;
      }
      if (e.target.value == "2") {
        this.roomInfo.areaIndex = 2;
      }
      if (e.target.value == "3") {
        this.roomInfo.areaIndex = 3;
      }
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
  },
  created() {
    console.log("created repair/main");
    console.log(store.state.userinfo);
  },
  mounted() {
    console.log("mounted repair/main");
    console.log(store.state.userinfo);
    this.baseUserInfo = store.state.userinfo;
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
