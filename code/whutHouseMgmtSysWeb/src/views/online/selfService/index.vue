<template>
  <div class="second-container">
    <div class="special-container">
      <div class="main-container">
        <div class="third-container">
          <!-- 面包屑导航 -->
          <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>网上选房</el-breadcrumb-item>
            <el-breadcrumb-item>自助选房</el-breadcrumb-item>
          </el-breadcrumb>
          </div>
          <!-- 下方主内容 -->
          <div class="warp-body">
            <!-- 工具栏 -->
            <div class="toolbar">
            </div>
            <!-- 表格区 -->
            <div class="main-data">
              <component :is="currentRole"></component>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import admin from "./admin/index";
import staff from "./staff/index";
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      currentRole: "admin"
    };
  },
  computed: {
    ...mapGetters(["roles"])
  },
  mounted() {
    if (this.roles[0] == 'ADMIN') {
      this.currentRole = "admin";
    } else {
      this.currentRole = "staff";
    }
  },
  components: {
    admin,
    staff
  }
};
</script>

<style scoped lang="scss">
@import "../../../styles/variables.scss";
.second-container {
  background-color: $background-grey;
}
</style>
