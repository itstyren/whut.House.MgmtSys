<template>
  <div class="container" @click="clickHandle('test click', $event)">
    <div class="userinfo" @click="bindViewTap">
      <img class="userinfo-avatar" v-if="userInfo.avatarUrl" :src="userInfo.avatarUrl" background-size="cover" />
      <div class="userinfo-nickname">
        <card :text="userInfo.nickName"></card>
      </div>
      <div class="zan-panel-title">完成绑定后，下次将自动登录</div>
    </div>

    <div class="zan-panel">
      <form @submit="formSubmit" @reset="formReset">
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <zan-field v-bind="Object.assign({}, handleFunctions, fieldBase.ID)"/>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <zan-field v-bind="Object.assign({}, handleFunctions,  fieldBase.password)"/>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <div class="zan-cell zan-field">
            <div class="zan-cell__hd zan-field__title">角色</div>
            <picker
              mode="selector"
              class="zan-field__input zan-cell__bd"
              :range="area"
              :value="areaIndex"
              @change="onAreaChange"
            >
              {{ area[areaIndex] }}
            </picker>
          </div>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-2">
          <button class="zan-btn zan-btn--primary" formType="submit">绑定账号</button>
        </div>
        <div class="zan-col zan-col-8 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" formType="reset">重新填写</button>
        </div>
      </div>
      </form>
    </div>
  </div>
</template>

<script>
import card from "@/components/card";
import ZanSelect from "../../components/zan/select";
import ZanField from "../../components/zan/field";

// Use Vuex
import store from "../../store/store";

export default {
  data() {
    return {
      motto: "房屋租赁管理系统",
      userInfo: {},
      activeColor: "#4b0",
      fieldBase: {
        ID: {
          // focus: true,
          title: "账号",
          placeholder: "请输入账号",
          componentId: "ID"
        },
        password: {
          title: "密码",
          placeholder: "请输入密码",
          inputType: "password",
          componentId: "password"
        }
      },
      area: ["角色1", "角色2", "角色3"],
      areaIndex: 0,
      handleFunctions: {
        handleZanFieldChange: this.handleZanFieldChange,
        handleZanFieldFocus: this.handleZanFieldFocus,
        handleZanFieldBlur: this.handleZanFieldBlur
      }
    };
  },

  components: {
    card,
    ZanField
  },
  methods: {
    handleZanFieldChange(e) {
      const { componentId, target, detail } = e;
      console.log("[zan:field:change]", componentId, target, detail);
    },

    handleZanFieldFocus(e) {
      const { componentId, target, detail } = e;
      console.log("[zan:field:focus]", componentId, target, detail);
    },

    handleZanFieldBlur(e) {
      const { componentId, target, detail } = e;

      console.log("[zan:field:blur]", componentId, target, detail);
    },
    bindViewTap() {
      const url = "../logs/main";
      wx.navigateTo({ url });
    },
    getUserInfo() {
      console.log("获取信息");
      // 调用登录接口
      wx.login({
        success: () => {
          wx.getUserInfo({
            success: res => {
              console.log(res);
              this.userInfo = res.userInfo;
            }
          });
        }
      });
    },
    clickHandle(msg, ev) {
    },
    handleZanSelectChange({ componentId, value }) {
    },
    onAreaChange(e) {
      this.areaIndex = e.target.value;
    },
    formSubmit(event) {
      console.log("发起请求");

      let param = {
        no: event.target.value.ID,
        password: event.target.value.password,
        roleId: this.areaIndex
      };

      //不能发出请求
      // loginByUsername(param).then(res => {
      //   console.log(res);
      // });

      //发起 网络请求
      wx.request({
        url: "http://118.126.117.96:8080/whutHouseMgmtReposity/userLogin/login", //仅为示例，并非真实的接口地址
        data: param,
        method: "POST",
        header: {
          "content-type": "application/json" // 默认值
        },
        success: function(res) {
          console.log(res.data.status);
          if (res.data.status === "success") {
            store.commit("login", res.data.data.token);
            wx.request({
              url:
                "http://118.126.117.96:8080/whutHouseMgmtReposity/userLogin/tokenLogin",
              method: "GET",
              data: {
                token: res.data.data.token
              },
              header: {
                "content-type": "application/json", // 默认值
                "X-token": res.data.data.token
              },
              success: function(_res) {
                console.log(res.data);
                const url = "../index/main";
                wx.switchTab({ url });
              }
            });
          } else {
            //TODO 登录失败 处理 
          }
        }
      });
    },

    formReset(event) {
      this.areaIndex = 0;
    }
  },

  created() {
    // 调用应用实例的方法获取全局数据
    this.getUserInfo();
    //postRequest(123);
  }
};
</script>

<style scoped>
.userinfo {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 50px;
}

.userinfo-avatar {
  width: 128rpx;
  height: 128rpx;
  margin: 20rpx;
  border-radius: 50%;
}

.userinfo-nickname {
  color: #aaa;
}

.usermotto {
  margin-top: 150px;
}

.form-control {
  display: block;
  padding: 0 12px;
  margin-bottom: 5px;
  border: 1px solid #ccc;
}

.counter {
  display: inline-block;
  margin: 10px auto;
  padding: 5px 10px;
  color: blue;
  border: 1px solid blue;
}

.zan-row {
  padding-bottom: 10px;
}

.zan-panel-title {
  font-size: 14px;
}
</style>

