<template>
  <div class="page">
    <div class="info-card zan-row">
      <a href="../userInfo/main"><img class="userinfo-avatar" :src="userInfo.avatarUrl" background-size="cover" /></a>
      <div class="userinfo-nickname">
        {{userInfo.nickName}}
      </div>
    </div>
    <!-- 操作区域 -->
    <div class="zan-row user-cell">
      <a href="../fixDetail/main">
        <div class="zan-cell zan-cell--access">
          <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
          <div class="zan-cell__bd">查看维修申请单</div>
          <div class="zan-cell__ft">
            <span :class="fixStatus">{{recentlyFixStatus}}</span>
          </div>
        </div>
      </a>

      <a href="../hireDetail/main">
        <div class="zan-cell zan-cell--access">
          <div class="zan-icon zan-icon-points-mall" style="color: #ff4343;"></div>
          <div class="zan-cell__bd">查看租赁申请单</div>
          <div class="zan-cell__ft">
            <span :class="hireState">{{recentlyHireStatus}}</span>
          </div>
        </div>
      </a>
            <a href="../monetarySub/main">
        <div class="zan-cell zan-cell--access">
          <div class="zan-icon zan-icon-cash-back-record" style="color: #ff4343;"></div>
          <div class="zan-cell__bd">住房补贴查询</div>
          <div class="zan-cell__ft">
            <!-- <span :class="hireState">{{recentlyHireStatus}}</span> -->
          </div>
        </div>
      </a>
      <!-- 解除绑定 -->
      <div class="logOut">
        <button @click="logOut" class="zan-btn zan-btn--danger">解除绑定</button>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
// import wxccc from '@minui/wxc-cc';
import { getFixByStaffID, getUnbindUnionID, getHireByStaffID } from "@/api";
export default {
  data() {
    return {
      userInfo: {},
      staffInfo: [],
      recentlyFixStatus: "",
      recentlyHireStatus: "",
      fixStatus: "",
      hireState: ""
    };
  },
  onShow() {
    this.userInfo = wx.getStorageSync("userInfo");
    this.staffInfo = this.$store.state.userinfo;
    this.getFixForm();
    this.getHireForm();
  },
  components: {},
  methods: {
    // 获取维修表单信息
    getFixForm() {
      let staffID = this.staffInfo.id;
      getFixByStaffID(staffID).then(res => {
        let todoFixForm = [];
        let doneFixForm = [];
        let fixForm = res.data.data;
        this.recentlyFixStatus =
          res.data.data[res.data.data.length - 1].fixState;
        if (this.recentlyFixStatus == "已审核") this.fixStatus = "yishenhe";
        fixForm.forEach(i => {
          if (i.fixState == "待受理" || i.fixState == "待审核") {
            todoFixForm.push(i);
          } else {
            doneFixForm.push(i);
          }
        });
        todoFixForm.reverse();
        doneFixForm.reverse();
        wx.setStorageSync("todoFixForm", todoFixForm);
        wx.setStorageSync("doneFixForm", doneFixForm);
      });
    },
    getHireForm() {
      let staffID = this.staffInfo.id;
      getHireByStaffID(staffID).then(res => {
        // console.log(res.data.data);
        let hireForm = res.data.data;
        if (hireForm.length != 0) {
          this.recentlyHireStatus = hireForm[0].hireState;
        } else {
          this.recentlyHireStatus = "暂无申请单";
        }
        if (this.recentlyHireStatus == "已审核") this.hireState = "yishenhe";
        wx.setStorageSync("hireForm", hireForm);
      });
    },
    // 用户解除绑定
    logOut() {
      let staffID = this.staffInfo.id;
      wx.showModal({
        title: "提示",
        content: "是否确认解除绑定",
        success: function(res) {
          if (res.confirm) {
            wx.showLoading({
              title: "请稍后"
            });
            getUnbindUnionID(staffID).then(res => {
              const url = "../../login/main";
              wx.redirectTo({
                url
              });
            });
          } else {
          }
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
.info-card {
  height: 30vh;
  background-color: #fff;
  padding: 10%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  .userinfo-avatar {
    width: 200rpx;
    height: 200rpx;
    margin: 20rpx;
    border-radius: 50%;
  }

  .userinfo-nickname {
    color: #aaa;
  }
}

.user-cell {
  margin-top: 3vh;
  .zan-cell {
    font-size: 22px;
    background-color: #fff;
    margin-bottom: 2vh;
  }
  .zan-cell__bd {
    margin-left: 20px;
    font-size: 16px;
  }
  .zan-cell__ft {
    font-size: 14px;
    line-height: 10px;
    letter-spacing: 2px;
    padding-right: 20px;
    span {
      padding: 2px 4px;
      background-color: #d8d8d8;
      color: #fff;
      border-radius: 30px;
    }
    .yishenhe {
      background-color: #81cacb;
    }
    .yijujue {
    }
  }
  .logOut {
    margin: 20px 20px 0;
  }
}
</style>
