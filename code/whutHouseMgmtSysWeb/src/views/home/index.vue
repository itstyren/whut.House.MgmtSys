<template>
  <div class="second-container">
    <div class="special-container"
         style="overflow:hidden">
      <div class="main-container">
        <div class="third-container">
          <!-- 面包屑导航 -->
          <div class="warp-breadcrum">
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
import adminDashboard from "./admin/index";
import staffDashboard from "./staff/index";
import { mapGetters } from "vuex";
export default {
  data () {
    return {
      currentRole: "adminDashboard"
    };
  },
  computed: {
    ...mapGetters(["property"])
  },
  mounted () {
    if (this.property === '管理员') {
      this.currentRole = "adminDashboard";
    } else {
      this.currentRole = "staffDashboard";
    }
  },
  components: {
    adminDashboard,
    staffDashboard
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
}
</style>
