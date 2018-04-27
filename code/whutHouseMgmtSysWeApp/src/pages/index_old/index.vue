<template>
  <div class="container">
    <div class="userinfo" @click="bindViewTap">
      <img class="userinfo-avatar" v-if="userInfo.avatarUrl" :src="userInfo.avatarUrl" background-size="cover" />
      <div class="userinfo-nickname">
        <card :text="userInfo.nickName"></card>
      </div>
    </div>
  </div>
</template>

<script>
import card from "@/components/card";
import ZanSelect from "../../components/zan/select";
import store from '../../store/store'

export default {
  data() {
    return {
      userInfo: {}
    };
  },

  components: {
    card
  },

  methods: {
    getUserInfo() {
      // 调用登录接口
      wx.login({
        success: () => {
          wx.getUserInfo({
            success: res => {
              this.userInfo = res.userInfo;
            }
          });
        }
      });
    },
    login() {
      // 调用微信登录接口
      wx.login({
        success: () => {
          wx.getUserInfo({
            success: res => {
              this.userInfo = res.userInfo;
            }
          });
        }
      });

      //使用获取的UNIONID 登录系统
      //发起 网络请求
      wx.request({
        url: store.state.API_URL + "/userLogin/loginByUnionId", //仅为示例，并非真实的接口地址
        data: {
          unionId: '123456789'//使用获取的用户UnionID
        },
        method: "POST",
        header: {
          "content-type": "application/json" // 默认值
        },
        success: function(res) {
          console.log(res);
          if (res.data.status === "success") {
            const url = "../index/main";
            wx.switchTab({ url });
            // store.commit("login", res.data.data.token);
            // wx.request({
            //   url:
            //     "http://118.126.117.96:8080/whutHouseMgmtReposity/userLogin/tokenLogin",
            //   method: "GET",
            //   data: {
            //     token: res.data.data.token
            //   },
            //   header: {
            //     "content-type": "application/json", // 默认值
            //     "X-token": res.data.data.token
            //   },
            //   success: function(_res) {
            //     console.log(res.data);
            //     const url = "../index/main";
            //     wx.switchTab({ url });
            //   }
            // });
          } else {
            //TODO 登录失败 处理
            console.log("跳转到登录界面");
          }
        }
      });
    }
  },

  created() {
    // 调用应用实例的方法获取全局数据
    this.login();
  }
};
</script>

<style scoped>
.userinfo {
  display: flex;
  flex-direction: column;
  align-items: center;
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
</style>
