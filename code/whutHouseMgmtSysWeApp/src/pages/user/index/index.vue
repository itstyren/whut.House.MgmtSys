<template>
 <div class="page">
   <div class="info-card zan-row" >
      <img class="userinfo-avatar"  :src="userInfo.avatarUrl" background-size="cover" />
      <div class="userinfo-nickname">
        {{userInfo.nickName}}
      </div>
   </div>
   <!-- 操作区域 -->
   <div class="zan-row user-cell">
      <a href="../fixDetail/main"><div class="zan-cell zan-cell--access" @click="fixCheck">
        <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
        <div class="zan-cell__bd">查看维修申请单</div>
        <div class="zan-cell__ft"><span :class="status">{{recentlyFixStatus}}</span></div>
      </div></a>
      <div class="zan-cell zan-cell--access">
        <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
        <div class="zan-cell__bd">查看维修申请单</div>
        <div class="zan-cell__ft">未审核</div>
      </div>
         <!-- 解除绑定 -->
   <div class="logOut">
         <button @click="logOut" class="zan-btn zan-btn--danger">解除绑定</button>
         </div>
   </div>
 </div>
</template>

<script type="text/ecmascript-6">
// import wxccc from '@minui/wxc-cc';
import { getFixByStaffID } from "@/api";
export default {
  data() {
    return {
      userInfo: {},
      staffInfo: [],
      recentlyFixStatus:'',
      status:''
    };
  },
  mounted() {
    this.userInfo = wx.getStorageSync("userInfo");
    this.staffInfo = this.$store.state.userinfo;
    this.getFixForm();
  },
  components: {},
  methods: {
    fixCheck() {
      console.log(233);
    },
    // 获取维修表单信息
    getFixForm() {
      let staffID = this.staffInfo.id;
      getFixByStaffID(staffID).then(res => {
        this.recentlyFixStatus=res.data.data[0].fixState
        if(this.recentlyFixStatus=='已审核')
        this.status='yishenhe'
      });
    },
    // 用户解除绑定
    logOut(){
      
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
    .yishenhe{
      background-color: #81CACB;
    }
    .yijujue{
      
    }
  }
      .logOut{
 margin: 20px 20px 0;
  }
}

</style>

