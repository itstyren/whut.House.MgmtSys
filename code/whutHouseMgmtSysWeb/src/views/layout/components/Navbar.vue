<template>
  <el-menu class="navbar" mode="horizontal">
    <collapse-button class="collapse-container" :toggleClick="toggleSideBar" :isActive="sidebar.opened"></collapse-button>


    <div class="right-menu">

      <!-- 头部账户 -->
        <el-dropdown class="account-container" trigger="click">
          <div class="account-wrapper">
            <my-icon icon-class="account" />
            <span>{{userName}}</span>
            <my-icon icon-class="more_unfold" />
          </div>
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
  </el-menu>
</template>

<script>
import { mapGetters } from 'vuex'
import CollapseButton from '@/components/CollapseButton'


export default {
  components: {
    CollapseButton,
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'userName',
    ])
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('toggleSideBar')
    },
      // 退出登录
      logout() {
       // console.log('2')
        this.$store.dispatch("LogOut").then(() => {
          location.reload(); // In order to re-instantiate the vue-router object to avoid bugs
        });
      }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.navbar {
  height: 50px;
  line-height: 50px;
  border-radius: 0px !important;
  .collapse-container {
    line-height: 58px;
    height: 50px;
    float: left;
    padding: 0 10px;
  }
  .breadcrumb-container{
    float: left;
  }
  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }
  .right-menu {
    float: right;
    height: 100%;
    &:focus{
     outline: none;
    }
    .right-menu-item {
      display: inline-block;
      margin: 0 8px;
    }
    .screenfull {
      height: 20px;
    }
    .international{
      vertical-align: top;
    }
    .theme-switch {
      vertical-align: 15px;
    }
    .account-container {
      height: 50px;
      margin-right: 30px;
      .account-wrapper {
        cursor: pointer;
        margin-top: 5px;
        position: relative;
        .user-avatar {
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }
        .el-icon-caret-bottom {
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
              
  }
}
</style>
