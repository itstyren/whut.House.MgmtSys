<template>
  <div class="container" >
    <div class="userinfo" >
      <img class="userinfo-avatar" v-if="userInfo.avatarUrl" :src="userInfo.avatarUrl" background-size="cover" />
      <div class="userinfo-nickname">
        <card :text="userInfo.nickName"></card>
      </div>
      <button :class="{'hide':isAuthorization}"  open-type="getUserInfo" @getuserinfo="bindGetUserInfo">授权登录</button>
      <!-- <open-data type="userAvatarUrl"></open-data> -->
<!-- <open-data type="userNickName"></open-data> -->
    </div>

<div   :class="{'hide':!isAuthorization}">
      <form @submit="formSubmit" @reset="formReset">
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <zan-field  v-bind="Object.assign({}, handleFunctions, fieldBase.ID)"/>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <zan-field  v-bind="Object.assign({}, handleFunctions,  fieldBase.password)"/>
        </div>
      </div>

      <div class="zan-row">
        <div class="zan-col zan-col-8 zan-col-offset-9">
          <div class="zan-cell zan-field ">
            <picker
              mode="selector"
              :range="roleArray"
              :value="roleID"
              @change="onAreaChange"
            >
              {{ roleArray[roleID] }}
            </picker>
          </div>
        </div>
      </div>
      <div class="zan-row login_button">
        <div class="zan-col zan-col-18 zan-col-offset-3">
          <button class="zan-btn zan-btn--primary" formType="submit">登录并绑定</button>
        </div>
        <!-- <div class="zan-col zan-col-6 zan-col-offset-4">
          <button class="zan-btn zan-btn--primary" formType="reset">重新填写</button>
        </div> -->
      </div>
      </form>
</div>
    <toptips />
  </div>
</template>

<script>
import card from "@/components/card";
import ZanField from "@/components/zan/field";
import ZanTopTips from "../../components/zan/toptips";
import {
  postLoginWX,
  getTokenLogin,
  postLoginByUnionID,
  getWXCode
} from "@/api";
import { getComponentByTag } from "../../utils/helper";
export default {
  data() {
    return {
      motto: "房屋租赁管理系统",
      isAuthorization: false,
      userInfo: {},
      activeColor: "#4b0",
      fieldBase: {
        ID: {
          mode: "wrapped",
          placeholder: "请输入账号",
          componentId: "ID"
        },
        password: {
          mode: "wrapped",
          placeholder: "请输入密码",
          inputType: "password",
          componentId: "password"
        }
      },
      roleArray: ["请选择角色", "超级管理员", "单位管理员", "职工"],
      roleID: 0,
      handleFunctions: {
        handleZanFieldChange: this.handleZanFieldChange,
        handleZanFieldFocus: this.handleZanFieldFocus,
        handleZanFieldBlur: this.handleZanFieldBlur
      },
      test_UNIONID: "111222"
    };
  },
  components: {
    card,
    ZanField,
    toptips: ZanTopTips
  },
  created() {
    this.checkStatus();
  },
  methods: {
    handleZanFieldChange(e) {
      const { componentId, target, detail } = e;
      //console.log("[zan:field:change]", componentId, target, detail);
    },

    handleZanFieldFocus(e) {
      const { componentId, target, detail } = e;
      // console.log("[zan:field:focus]", componentId, target, detail);
    },

    handleZanFieldBlur(e) {
      const { componentId, target, detail } = e;

      // console.log("[zan:field:blur]", componentId, target, detail);
    },
    bindViewTap() {
      const url = "../logs/main";
      wx.navigateTo({ url });
    },
    // 通过微信id优先进入
    checkStatus() {
      let that = this;
      wx.getSetting({
        success(res) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          if (res.authSetting["scope.userInfo"]) {
            this.isAuthorization = true;
            // 从服务器端获取code
            wx.login({
              success: res => {
                getWXCode(res.code).then(res => {
                  wx.setStorage({
                    key: "openid",
                    data: res.data.data.openid
                  });
                  wx.setStorage({
                    key: "session_key",
                    data: res.data.data.session_key
                  });
                });
                wx.getUserInfo({
                  success: res => {
                    console.log(res);
                    this.userInfo = res.userInfo;
                    that.$store.commit("setUnionID", that.test_UNIONID);
                    let data = {
                      unionId: that.$store.state.unionID
                    };
                    postLoginByUnionID(data).then(res => {
                      if (res.status === "success") {
                        that.$store.state.access_token = res.data.token;
                        getTokenLogin(that.$store.getters.token).then(res => {
                          that.$store.commit("setUserInfo", res.data.data[0]);
                          const url = "../index/main";
                          wx.switchTab({ url });
                        });
                      } else {
                      }
                    });
                  }
                });
              }
            });
          }
        }
      });
    },
    // 获取用户授权
    bindGetUserInfo(e) {
      this.userInfo = e.mp.detail.userInfo;
      this.isAuthorization = true;
    },
    clickHandle(msg, ev) {},
    handleZanSelectChange({ componentId, value }) {},
    onAreaChange(e) {
      this.roleID = e.target.value;
    },
    // 提交表单信息
    formSubmit(event) {
      let data = {
        no: event.target.value.ID,
        password: event.target.value.password,
        roleId: this.roleID - 1,
        unionId: "111222"
      };
      postLoginWX(data).then(res => {
        if (res.status === "success") {
          wx.showLoading({
            title: "加载中"
          });
          this.$store.commit("login", res.data.token);
          getTokenLogin(this.$store.getters.token).then(res => {
            this.$store.commit("setUserInfo", res.data.data[0]);
            const url = "../index/main";
            wx.switchTab({ url });
          });
        } else {
          getComponentByTag(this, "toptips").showZanTopTips("账号或密码错误");
        }
      });
    },

    formReset(event) {
      this.roleID = 0;
    }
  }
};
</script>

<style scoped>
.hide {
  display: none;
}
.userinfo {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 50px;
  margin-bottom: 5vh;
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
  text-align: center;
  padding-bottom: 2vh;
}

.zan-panel-title {
  font-size: 14px;
}
.login_button {
  margin-top: 5vh;
}
</style>

