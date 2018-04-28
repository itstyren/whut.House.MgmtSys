<template>
  <div class="container" >
    <div class="userinfo" >
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
      area: ["角色1", "角色2", "角色3","职工"],
      areaIndex: 0,
      handleFunctions: {
        handleZanFieldChange: this.handleZanFieldChange,
        handleZanFieldFocus: this.handleZanFieldFocus,
        handleZanFieldBlur: this.handleZanFieldBlur
      },
      test_UNIONID: '111222'
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
              //console.log(res);
              this.userInfo = res.userInfo;
              store.state.unionId = this.test_UNIONID;
              let loginByUnionID_param = store.state.unionId;
              //使用获取的UNIONID 登录系统
              //发起 网络请求
              wx.request({
                url: store.state.API_URL + "/userLogin/loginByUnionId", //仅为示例，并非真实的接口地址
                data: loginByUnionID_param,
                method: "POST",
                header: {
                  "content-type": "application/json" // 默认值
                },
                success: function(res) {
                  //console.log(res);
                  if (res.data.status === "success") {
                    store.state.access_token = res.data.data.token;
                    wx.request({
                      url: store.state.API_URL + "/userLogin/tokenLogin",
                      method: "GET",
                      data: {
                        token: store.state.access_token
                      },
                      header: {
                        "content-type": "application/json", // 默认值
                        "X-token": res.data.data.token
                      },
                      success: function(_res) {
                        console.log(_res.data.data.data[0]);
                        store.state.userinfo = _res.data.data.data[0];
                        const url = "../index/main";
                        wx.switchTab({ url });
                      }
                    });
                  } else {
                    //TODO 登录失败 处理
                    console.log("跳转到登录界面");
                    this.IsLogin = false;
                    console.log(this.IsLogin);
                  }
                }
              });
            }
          });
        }
      });
    },
    clickHandle(msg, ev) {},
    handleZanSelectChange({ componentId, value }) {},
    onAreaChange(e) {
      this.areaIndex = e.target.value;
    },
    formSubmit(event) {
      console.log("发起请求");
      let param = {
        no: event.target.value.ID,
        password: event.target.value.password,
        roleId: 3,
        unionId: "111222"
      };

      //发起 网络请求
      wx.request({
        url: store.state.API_URL + "/userLogin/loginWX", //仅为示例，并非真实的接口地址
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
              url: store.state.API_URL + "/userLogin/tokenLogin",
              method: "GET",
              data: {
                token: store.state.access_token
              },
              header: {
                "content-type": "application/json", // 默认值
                "X-token": res.data.data.token
              },
              success: function(_res) {
                console.log(res.data);
                store.state.userinfo = res.data.data[0];
                const url = "../index/main";
                wx.switchTab({ url });
              }
            });
          } else {
            //TODO 登录失败 处理
            console.log("跳转登录");
            const url = "../index_old/main";
            wx.navigateTo({ url });
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

