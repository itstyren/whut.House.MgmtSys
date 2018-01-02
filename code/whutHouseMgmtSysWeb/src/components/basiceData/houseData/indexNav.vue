<template>
  <div class="second-container">
    <aside :class="{showSidebar:!isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button" @click.prevent="collapse">
        <svg class="icon" aria-hidden="true" v-show="isCollapse">
          <use xlink:href="#icon-next"></use>
        </svg>
        <svg class="icon" aria-hidden="true" v-show="!isCollapse">
          <use xlink:href="#icon-pre"></use>
        </svg>
      </div>
      <!-- 主菜单 -->
      <el-menu :collapse="isCollapse" :default-active="$route.path" router v-for="region in regionDataWithBuilding" :key="region.id">
        <!-- 区域菜单 -->
        <el-submenu index="regionParam" >
          <template slot="title">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-building"></use>
            </svg>
            <span slot="title">{{region.name}}</span>
          </template>
          <el-menu-item v-for="building in region.buildingList" :key="building.id" :index="'/basic/house/byBuilding/'+building.id">{{building.name}}</el-menu-item>
        </el-submenu>
      </el-menu>
    </aside>
    <section class="main-container">
      <!-- 需要长时间存活的 -->
      <transition>
        <keep-alive>
          <router-view v-if="$route.meta.keepAlive" :region-building-data="regionDataWithBuilding"></router-view>
        </keep-alive>
      </transition>
      <!-- 不需要长时间保存的 -->
      <transition mode="out-in">
        <router-view v-if="!$route.meta.keepAlive" :region-building-data="regionDataWithBuilding"></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import { getRegionWithBuildings } from "@/api/api";
export default {
  data() {
    return {
      sss:'222',
      isCollapse: false,
      // 区域信息
      regionDataWithBuilding: [],
    };
  },
  components: {},
  created() {
    this.getRegionWithBuilding();
  },
  methods: {
    //折叠
    collapse: function() {
      this.isCollapse = !this.isCollapse;
    },
    // 获取区域信息包括楼栋
    getRegionWithBuilding() {
      this.listLoading = true;
      let param = {
        // page: this.page,
        // size: this.size
      };
      getRegionWithBuildings(param)
        .then(res => {
          this.regionDataWithBuilding = res.data.data.data;
          this.regionDataWithBuilding.forEach(region => {
            let flag = region.name.indexOf("（");
            if (flag != -1) {
              region.name = region.name.substring(0, flag);
            }
          });
          this.totalNum = res.data.data.data.total;
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
  }
};
</script>

<style scoped lang="scss">
aside {
  > .el-menu {
    width: 250px;
    height: auto;
  }
    .el-menu--collapse{
    width: 60px;
  }
  span {
    padding-left: 20px;
  }
}
</style>
