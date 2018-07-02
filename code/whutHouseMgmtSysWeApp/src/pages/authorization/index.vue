<template>
  <div class="container">

    <open-data type="userAvatarUrl"></open-data>
    <open-data type="userNickName"></open-data>
    <div class="button">
      <button :class="{'hide':isAuthorization}" open-type="getUserInfo" @getuserinfo="bindGetUserInfo">授权登录</button>
    </div>
  </div>
</template>

<script>
  import card from "@/components/card";
  import ZanTopTips from "../../components/zan/toptips";
  import {
    postLoginWX,
    getTokenLogin,
    postLoginByUnionID,
    getWXCode,
    getdecodeInfo
  } from "@/api";
  import {
    getComponentByTag
  } from "../../utils/helper";
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
        }
      };
    },
    components: {
      card,
      toptips: ZanTopTips
    },
    created() {
      this.checkStatus();
    },
    methods: {
      // 通过微信id优先进入
      checkStatus() {
        let that = this;
        wx.getSetting({
          success(res) {
            // 已经授权，可以直接调用 getUserInfo 获取头像昵称
            if (res.authSetting["scope.userInfo"]) {
              wx.showLoading({
                title: "请稍后"
              });
              // 从服务器端获取code
              wx.login({
                success: res => {
                  // console.log(res.code);
                  getWXCode(res.code).then(res => {
                    // console.log(res.data.data.session_key);
                    wx.setStorage({
                      key: "openid",
                      data: res.data.data.openid
                    });
                    wx.setStorage({
                      key: "session_key",
                      data: res.data.data.session_key
                    });
                    wx.getUserInfo({
                      success: res => {
                        // console.log(res);
                        // console.log(wx.getStorageSync("session_key"));
                        let data1 = {
                          encryptedData: res.encryptedData,
                          iv: res.iv,
                          sessionKey: wx.getStorageSync("session_key")
                        };
                        wx.setStorage({
                          key: "userInfo",
                          data: res.userInfo
                        });

                        getdecodeInfo(data1).then(res => {
                          wx.setStorage({
                            key: "unionId",
                            data: res.data.data.unionId
                          });
                          let data = {
                            unionId: res.data.data.unionId
                          };
                          postLoginByUnionID(data).then(res => {
                            if (res.status === "success") {
                              that.$store.state.access_token = res.data.token;
                              getTokenLogin(that.$store.getters.token).then(
                                res => {
                                  //switchTab 只能打开 tabBar 页面
                                  wx.switchTab({
                                    url: "../index/main"
                                  });
                                }
                              );
                            } else {
                              //navigateTo, redirectTo 只能打开非 tabBar 页面。
                              wx.redirectTo({
                                url: "../login/main"
                              });
                            }
                          });
                        });
                      }
                    });
                  });
                }
              });
            }
          }
        });
      },
      // 获取用户授权
      bindGetUserInfo(e) {
        this.checkStatus();
      }
    }
  };

</script>

<style lang="scss">
  .container {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 50px;
    margin-bottom: 5vh;
    .button {
      margin-top: 50px;
    }
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
