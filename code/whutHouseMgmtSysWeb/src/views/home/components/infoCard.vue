<template>
  <div class="info-card card">
    <div class="top">
      <el-row>
        <el-col :span="10"
                :offset="2">
          <div class="avatar">
            <img :src="avatarURL"
                 width="100%"
                 height="100%"
                 alt="avatar">
          </div>
        </el-col>
        <el-col :span="12">
          <el-row class="basice-info-name">
            <el-col :span="24">
              <strong>{{staffName}}</strong>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24"
                    class="basice-info-role">
              <span>{{roleName}}</span>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
    <div class="bottom">
      <el-row>
        <el-col :span="22"
                :offset="2">
          <el-row>
            <strong>上次登录时间: {{loginTime}}</strong>
          </el-row>
          <el-row style="padding-top:5px;">
            <strong>上次登录地址: {{ip}}</strong>
          </el-row>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
import img_avatar from "@/assets/avatar.jpg";
import { getUserAvatar } from "@/api/user";
export default {
  data () {
    return {
      staffID: this.$store.getters.userID,
      avatarURL: "",
      staffName: this.$store.getters.userName,
      roleName: "",
      ip: this.$store.state.user.ip,
      loginTime: this.$store.state.user.loginTime
    };
  },
  mounted () {
    if (this.$store.getters.roles == 'ADMIN') {
      this.roleName = "超级管理员";
    } else {
      this.roleName = "职工";
    }
    this.getData()
  },
  methods: {
    getData () {
      getUserAvatar(this.staffID).then(res => {
        if (res.data.status == "error") {
          this.avatarURL = img_avatar;
        } else {
          this.avatarURL = res.data.data.data;
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
.info-card {
  // height: 240px;
  height: 100%;
  .top {
    position: relative;
    padding-bottom: 20px;
    margin-bottom: 20px;
    &::after {
      content: "";
      width: 90%;
      height: 2px;
      background-color: #dcdcdc;
      position: absolute;
      bottom: -0px;
      z-index: 1;
      left: 5%;
      right: 5%;
    }
    .avatar {
      margin-top: 10px;
      width: 14vh;
      height: 14vh;
      border-radius: 50%;
      overflow: hidden;
    }
    .basice-info-name {
      font-size: 1.5vw;
      padding-top: 30px;
      color: #2d8cf0;
    }
    .basice-info-role {
      margin-top: 10px;
      font-size: 1.2vw;
    }
  }

  .bottom {
    padding-bottom: 25px;
    line-height: 20px;
  }
}
</style>
