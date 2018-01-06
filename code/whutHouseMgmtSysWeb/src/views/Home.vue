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
            <span>武汉理工房屋管理系统</span>
        </div>
        <!-- 主菜单 -->
        <div class="main-menu" :router="true" >
            <el-menu default-active="/index" menu-trigger="click" unique-opened  mode="horizontal" background-color="#373d41" text-color="#fff" :default-active="$route.path" router >
              <!-- 首页 -->
              <el-menu-item index="/index">
                <template slot="title">
                    <span slot="title">首页</span>
                </template>
              </el-menu-item>    
              <!-- 系统管理-->
              <el-submenu index="sysManage">
                <template slot="title">
                    <span slot="title">系统管理</span>
                </template>                  
                <el-menu-item index="/sysmanage/paramSet">
                    <span>参数设置</span>
                </el-menu-item>
                <el-menu-item index="/paramSet">
                    <span>权限控制</span>
                </el-menu-item>                
              </el-submenu>
              <!-- 基础资料 -->
              <el-submenu index="basicData">
                <template slot="title">
                    <span slot="title">基础资料</span>
                </template>                  
                <el-menu-item index="/basic/buildingArea">
                    <span>楼栋区域</span>
                </el-menu-item>
                <el-menu-item index="/basic/house">
                    <span>房屋管理</span>
                </el-menu-item> 
                <el-menu-item index="/basic/staff">
                    <span>职工管理</span>
                </el-menu-item>
                <el-menu-item index="/basic/awdlist">
                    <span>住房登记</span>
                </el-menu-item>
                <el-menu-item index="/basic/orglist">
                    <span>数据导入</span>
                </el-menu-item>                                                   
              </el-submenu>
            </el-menu>
        </div>
        <!-- 头部账户 -->
        <div class="account">
            <el-dropdown trigger="click" > 
                <span class="dropdown-main">
                    <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-account"></use>
                    </svg>
                    <span>{{RoleName}}</span>
                    <svg class="icon" aria-hidden="true">
                    <use xlink:href="#icon-more_unfold"></use>
                    </svg>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>
                        <router-link to="/account/info"><span style=" color: #000; font-size: 14px;">个人信息</span></router-link>
                    </el-dropdown-item>
                    <el-dropdown-item>
                        <router-link to="/account/PassWord"><span style=" color: #000; font-size: 14px;">修改密码</span></router-link>
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
export default {
  data() {
    return {
      RoleName: this.$store.state.Name
    };
  },
  components: {}
};
</script>

<style scoped lang="scss">
$background-color: #373d41;
.home-container {
  display: flex;
  width: 100vw;
  height: 100vh;
  flex-direction: column;
  .top-bar {
    $heigt: 61px;
    height: $heigt;
    line-height: 61px;
    background-color: $background-color;
    flex-grow: 0;
    color: #fff;
    //display: flex;
    > .logo {
      float: left;
      width: 59px;
      height: $heigt;
      display: flex;
      background-image: url("../assets/logo.png");
      background-size: 100% 100%;
      > a {
        flex-grow: 1;
      }
    }
    > .main-menu {
      float: left;
      margin-left: 50px;
      //height: $heigt;
      > .el-menu {
        height: 100%; /*写给不支持calc()的浏览器*/
        height: -moz-calc(100% - 80px);
        height: -webkit-calc(100% - 80px);
        height: calc(100% - 80px);
        border-radius: 0px;
        background-color: $background-color;
      }
    }
    > .title {
      float: left;
      padding-left: 10px;
      //border-right: 1px solid #000;
      > span {
        font-size: 20px;
      }
    }
    > .account {
      float: right;
      padding-right: 15px;
      .dropdown-main {
        color: #fff;
        cursor: pointer;
        padding-left: 12px;
      }
    }
  }
  //   下方主内容
  > .body-container {
    overflow: hidden; // 必须使用
    flex-grow: 1;
    display: flex;
    position: relative;
  }
}


</style>
