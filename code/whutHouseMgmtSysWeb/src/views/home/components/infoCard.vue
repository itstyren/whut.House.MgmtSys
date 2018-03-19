<template>
  <div class="info-card card">
    <div class="top">
      <el-row>
        <el-col :span="10" :offset="2">
          <div class="avatar">
            <img :src="img_avatar" width="100%" height="100%" alt="avatar">
          </div>
        </el-col>
        <el-col :span="12">
          <el-row class="basice-info-name">
            <el-col :span="24">
              <strong>{{staffName}}</strong>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24" class="basice-info-role">
              <span>{{roleName}}</span>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
    <div class="bottom">
      <el-row>
        <el-col :span="22" :offset="2">
          <el-row>
            <el-col :span="8" :offset="1">
              <strong>上次登录时间:</strong>
            </el-col>
            <el-col :span="12">
              <strong>2018.03.18</strong>
            </el-col>
          </el-row>
          <el-row style="padding-top:5px;">
            <el-col :span="8" :offset="1">
              <strong>上次登录地址:</strong>
            </el-col>
            <el-col :span="12">
              <strong>湖北省武汉市</strong>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
  import img_avatar from "@/assets/avatar.jpg";
  export default {
    data() {
      return {
        img_avatar,
        staffName: this.$store.getters.userName,
        roleName:''
      };
    },
    mounted () {
      if(this.$store.getters.roles==3){
        this.roleName='超级管理员'
      }else{
        this.roleName='职工'
      }
    },
  };

</script>

<style scoped lang="scss">
.info-card {
  height: 29vh;
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
      bottom: -2px;
      z-index: 1;
      left: 5%;
      right: 5%;
    }
    .avatar {
      width: 15vh;
      height: 15vh;
      border-radius: 50%;
      overflow: hidden;
    }
    .basice-info-name {
      font-size: 22px;
      padding-top: 3vh;
      color: #2d8cf0;
    }
    .basice-info-role {
      margin-top: 1vh;
      font-size: 18px;
    }
  }

  .bottom {
    padding-bottom: 25px;
    line-height: 20px;
  }
}
</style>
