<template>
  <div class="second-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>个人信息</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-row class="user-info">
              <el-col :span="4" class="card nav">
                <div class="title">
                  <span>个人信息</span>
                </div>
                <el-menu default-active="2" background-color="#fff" text-color="#000" active-text-color="#ffd04b">
                  <el-menu-item index="2">
                    <i class="el-icon-menu"></i>
                    <span slot="title">常规设置</span>
                  </el-menu-item>
                  <el-menu-item index="3">
                    <i class="el-icon-document"></i>
                    <span slot="title">房屋信息</span>
                  </el-menu-item>
                  <el-menu-item index="4">
                    <i class="el-icon-setting"></i>
                    <span slot="title">维修信息</span>
                  </el-menu-item>
                  <el-menu-item index="5">
                    <i class="el-icon-setting"></i>
                    <span slot="title">租赁信息</span>
                  </el-menu-item>
                  <el-menu-item index="6">
                    <i class="el-icon-setting"></i>
                    <span slot="title">修改密码</span>
                  </el-menu-item>
                </el-menu>
              </el-col>
              <!-- 常规设置 -->
              <el-col :span="12" :offset="1" class="info-form">
                <div class="title">
                  <h1>常规设置</h1>
                </div>
                <el-row class="info-row">
                  <el-col :span="7">
                    <strong>姓名</strong>
                  </el-col>
                  <el-col :span="14">
                    <strong style="color:#666">{{staffInfo.name}}</strong>
                  </el-col>
                </el-row>
                <el-row class="info-row">
                  <el-col :span="7">
                    <strong>部门</strong>
                  </el-col>
                  <el-col :span="14">
                    <strong style="color:#666">{{staffInfo.dept}}</strong>
                  </el-col>
                </el-row>
                <el-row class="info-row">
                  <el-col :span="7">
                    <strong>职称</strong>
                  </el-col>
                  <el-col :span="14">
                    <strong style="color:#666">{{staffInfo.title}}</strong>
                  </el-col>
                </el-row>
                <el-row class="info-row">
                  <el-col :span="7">
                    <strong>职务</strong>
                  </el-col>
                  <el-col :span="14">
                    <strong style="color:#666">{{staffInfo.post}}</strong>
                  </el-col>
                </el-row>
                <el-row :class="{'info-row':!phoneChange,'is-change':phoneChange}">
                  <el-col :span="7">
                    <strong>手机</strong>
                  </el-col>
                  <el-col :span="14" v-if="!phoneChange">
                    <strong style="color:#666">{{staffInfo.phone}}</strong>
                  </el-col>
                  <el-col :span="14" v-if="phoneChange">
                    <el-row>
                      <el-col :span="24">
                        <div class="old-vertify">
                          <strong>当前手机号验证</strong>
                        </div>
                      </el-col>
                    </el-row>
                    <el-row>
                      <el-col :span="17">
                        <el-input v-model="staffInfo.phone" disabled></el-input>
                      </el-col>
                    </el-row>
                    <el-row style="margin-top:10px">
                      <el-col :span="17">
                        <el-input v-model="identifyCode"></el-input>
                      </el-col>
                      <el-col :span="3" :offset="1">
                        <el-button type="infor">获取验证码</el-button>
                      </el-col>
                    </el-row>
                    <el-row style="margin-top:10px">
                      <el-col :span="7">
                        <el-button type="primary">下一步</el-button>
                      </el-col>
                      <el-col :span="3">
                        <el-button @click="phoneChange=false">取消</el-button>
                      </el-col>
                    </el-row>
                  </el-col>
                  <el-col :span="3">
                    <el-button type="infor" size="mini" v-if="!phoneChange" @click="modifyPhone">编辑</el-button>
                  </el-col>
                </el-row>
                <el-row class="info-row">
                  <el-col :span="7">
                    <strong>邮箱</strong>
                  </el-col>
                  <el-col :span="14">
                    <strong style="color:#666">{{staffInfo.email}}</strong>
                  </el-col>
                  <el-col :span="3">
                    <el-button type="infor" size="mini">编辑</el-button>
                  </el-col>
                </el-row>
              </el-col>
            </el-row>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data() {
      return {
        staffInfo: {
          name: "任天宇",
          dept: "管理学院",
          title: "学生",
          post: "还是学生",
          phone: "13129917437",
          email: "620461@qq.com"
        },
        phoneChange: false,
        identifyCode: ''
      };
    },
    components: {},
    methods: {
      modifyPhone() {
        this.phoneChange = true;
      }
    }
  };

</script>

<style scoped lang="scss">
  .user-info {
    margin: 5px auto;
    width: 90%;
    .nav {
      margin-top: 70px;
      .title {
        width: 100%;
        text-align: center;
        line-height: 42px;
        font-weight: bold;
        padding-top: 3px;
        background-color: #f3f5f8;
      }
      .el-menu {
        border-right: none;
      }
    }
    .info-form {
      &>.title {
        width: 100%;
        border-bottom: 2px solid #ccc;
        margin-bottom: 50px;
      }
      .info-row {
        border-bottom: 1px solid #eee;
        padding: 10px;
        height: 45px;
      }
      .is-change {
        background-color: #f5f5f5;
        border-bottom: 1px solid #eee;
        padding: 10px;
        .old-vertify {
          margin-bottom: 5px;
          &::after {
            content: " *";
            color: #ed1c24;
          }
        }
      }
    }
  }

</style>
