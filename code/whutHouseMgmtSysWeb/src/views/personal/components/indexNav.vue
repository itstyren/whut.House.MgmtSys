<template>
  <aside>
    <el-row class="nav">
      <div class="title">
        <span>个人信息</span>
      </div>
      <el-menu :default-active="menuIndex" @select="menuSelect" background-color="#373d41" text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="personal">
          <my-icon icon-class="paramSet"></my-icon>
          <span style="margin-left:12px" slot="title"> 常规设置</span>
        </el-menu-item>
        <el-menu-item index="house">
          <my-icon icon-class="building"></my-icon>
          <span style="margin-left:12px" slot="title"> 房屋信息</span>
        </el-menu-item>
        <el-menu-item index="monetarySub">
          <my-icon icon-class="monetarySub"></my-icon>
          <span style="margin-left:12px" slot="title"> 我的补贴</span>
        </el-menu-item>
        <el-menu-item index="fix">
          <my-icon icon-class="fixApplyManager"></my-icon>
          <span style="margin-left:12px" slot="title"> 我的维修</span>
        </el-menu-item>
        <el-menu-item index="hire">
          <my-icon icon-class="detail"></my-icon>
          <span style="margin-left:12px" slot="title"> 我的申请</span>
        </el-menu-item>
        <el-menu-item index="password">
          <my-icon icon-class="xiugaimima"></my-icon>
          <span style="margin-left:12px" slot="title"> 修改密码</span>
        </el-menu-item>
      </el-menu>
    </el-row>
  </aside>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      menuIndex: "personal"
    };
  },
  components: {},
  methods: {
    menuSelect(index, indexPath) {
      this.menuIndex = index;
      this.$emit("select-index", index);
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";
aside {
  background-color: #2c3134 !important;
}
.nav {
  .title {
    width: 100%;
    text-align: left;
    line-height: 42px;
    font-size: 14px;
    padding: 3px 20px;
    background-color: #2c3134;
    color: #ffff;
    border-left: 3px solid #f0cc5f;
  }
  .el-menu {
    border-right: none;
    padding-left: 0;
  }
}
</style>
