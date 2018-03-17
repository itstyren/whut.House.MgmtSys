<template>
  <!-- 容器 -->
  <div class="home-container">
    <!-- 头部 -->
    <header class="top-bar">
      <!-- 头部logo -->
      <div class="logo">
        <a href="/"></a>
      </div>
      <!-- 头部标题 -->
      <div class="title">
        <span>{{$t('header.title')}}</span>
      </div>
      <!-- 主菜单 -->
      <div class="main-menu" :router="true">
        <horizon-menu></horizon-menu>
      </div>
      <!-- 头部账户 -->
      <div class="account">
        <el-tooltip effect="dark" :content="$t('header.screenfull')" placement="bottom">
          <screenfull class="screenfull right-menu-item"></screenfull>
        </el-tooltip>
        <lang-select class="international right-menu-item"></lang-select>
        <el-dropdown trigger="click" class=" right-menu-item">
          <span class="dropdown-main">
            <my-icon icon-class="account" />
            <span>{{userName}}</span>
            <my-icon icon-class="more_unfold" />
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>
              <router-link to="/user/setting">
                <span style=" color: #000; font-size: 14px;">个人设置</span>
              </router-link>
            </el-dropdown-item>
            <el-dropdown-item>
              <router-link to="/account/PassWord">
                <span style=" color: #000; font-size: 14px;">修改密码</span>
              </router-link>
            </el-dropdown-item>
            <el-dropdown-item divided>
              <span style="font-size: 14px;" @click.prevent="logout">退出登录</span>
            </el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </header>
    <!-- 下方主体内容 -->
    <section class="body-container">
      <router-view></router-view>
    </section>
  </div>

</template>

<script type="text/ecmascript-6">
import horizonMenu from "./components/horizonMenu";
import LangSelect from "@/components/LangSelect";
import Screenfull from "@/components/Screenfull";

export default {
  data() {
    return {};
  },
  computed: {
    userName() {
      return this.$store.getters.userName;
    }
  },
  components: {
    horizonMenu,
    LangSelect,
    Screenfull
  },
  methods: {
    // 退出登录
    logout() {
      // console.log('2')
      this.$store.dispatch("LogOut").then(() => {
        location.reload(); // In order to re-instantiate the vue-router object to avoid bugs
      });
    }
  }
};
</script>

<style scoped lang="scss">
$background-color: #373d41;
@import "../../styles/variables.scss";
.home-container {
  .top-bar {
    background-color: $background-color;
    color: #fff; //display: flex;
    > .logo {
      float: left;
      width: 59px;
      height: $top-bar-height;
      display: flex;
      background-image: url("../../assets/logo.png");
      background-size: 100% 100%;
      > a {
        flex-grow: 1;
      }
    }
    > .main-menu {
      float: left;
      margin-left: 50px;
      > .el-menu {
        height: 100%;
        /*写给不支持calc()的浏览器*/
        height: -moz-calc(100% - 80px);
        height: -webkit-calc(100% - 80px);
        height: calc(100% - 80px);
        border-radius: 0px;
        background-color: $background-color;
      }
    }
    > .title {
      float: left;
      padding-left: 10px; //border-right: 1px solid #000;
      > span {
        font-size: 20px;
      }
    }
    > .account {
      float: right;
      padding-right: 15px;
      .right-menu-item {
        display: inline-block;
        margin: 0 8px;
      }
      .international {
        vertical-align: top;
        color: #fff;
        margin-right: 5px;
      }
      .screenfull {
        height: 100%;
      }
      .dropdown-main {
        color: #fff;
        cursor: pointer;
        padding-left: 12px;
      }
    }
  }
}
</style>
