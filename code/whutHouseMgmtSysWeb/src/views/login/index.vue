<template>
  <div class="login">
    <div class="main-tittle">
      <h1>房屋租赁管理系统</h1>
      <h1>武汉理工大学</h1>
    </div>
    <el-form :model="loginForm" v-loading="loginLoading" ref="loginForm" label-position="left" label-width="0px" class=" login-container">
      <h3 class="title">系统登录</h3>
      <el-form-item prop="no">
        <el-input type="text" v-model="loginForm.no" auto-complete="on" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" v-model="loginForm.password" auto-complete="on" placeholder="密码" @keyup.enter.native="handleLogin"></el-input>
      </el-form-item>
      <el-form-item prop="roleId">
        <el-select v-model="loginForm.roleId" placeholder="请选择角色">
          <el-option v-for="Role in RoleIDs" :key="Role.value" :label="Role.label" :value="Role.value"></el-option>
        </el-select>
      </el-form-item>
      <!-- <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox> -->
      <el-form-item style="width:100%;">
        <el-button type="primary" style="width:100%;" @click.native.prevent="handleLogin">登录</el-button>
        <!--<el-button @click.native.prevent="handleReset2">重置</el-button>-->
      </el-form-item>
      <div class="tip">
        <span>{{tipMessage}}</span>
      </div>
    </el-form>
    <footer>© 2017 Terry. All rights reserved.</footer>
  </div>
</template>

<script type="text/ecmascript-6">
import * as types from "@/store/mutation-types";
import { posLogin } from "@/api/api";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      loginLoading: false,
      // 表单需要内容
      loginForm: {
        no: "",
        password: "",
        roleId: ""
      },
      tipMessage: "",
      //角色
      RoleIDs: [
        {
          value: "0",
          label: "超级管理员"
        },
        {
          value: "1",
          label: "单位管理员"
        },
        {
          value: "2",
          label: "学院管理员"
        },
        {
          value: "3",
          label: "职工"
        }
      ]
    };
  },
  methods: {
    // 登录方法
    handleLogin() {
      let param;
      this.$refs["loginForm"].validate(valid => {
        if (valid) {
          this.loginLoading = true;
          this.tipMessage=""
          let param = Object.assign({}, this.loginForm);
          this.$store
            .dispatch("LoginByUsername", param)
            .then(message => {
              this.$message({
                type: "success",
                message: message,
        duration: 2000                
              });
              this.loginLoading = false;
              let redirect = decodeURIComponent(
                this.$route.query.redirect || "/"
              );
              this.$router.push({
                path: redirect
              });
            })
            .catch(err => {
              this.tipMessage = "请输入正确的用户名或密码";
              this.$message({
                type: "error",
                message: err
              });
              this.loginLoading = false;
            });
        }
      });
    }
  }
};
</script>

<style scoped lang="scss">
.login {
  display: flex;
  justify-content: space-around;
  align-items: center;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: url(../../assets/loginBg.jpg);
  background-position: center;
  background-size: 100% 100%;
  background-repeat: no-repeat;
  footer {
    position: absolute;
    bottom: 1vh;
    text-align: center;
  }
}

.main-container {
  margin-top: 180px;

  .main-tittle {
    font-family: "PingFang SC", "Hiragino Sans GB", "Heiti SC",
      "Microsoft YaHei", "WenQuanYi Micro Hei";
    font-size: 25px;
    text-align: right;
  }
}

.login-container {
  // position: fixed;
  // right: 20%;
  // margin: auto;
  // top: 0;
  // bottom: 0;
  -webkit-border-radius: 5px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  width: 350px; // height:350px;
  padding: 35px 35px 15px 35px;
  background: rgba(255, 255, 255, 0.9);
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  .title {
    text-align: center;
  }
  .tip {
    height: 20px;
    color: #fb1616;
    font-size: 14px;
    line-height: 1;
  }
}

.el-select {
  width: 100%;
}
</style>
