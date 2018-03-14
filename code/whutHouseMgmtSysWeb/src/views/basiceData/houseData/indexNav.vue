<template>
  <div class="second-container">
    <aside :class="{hideSidebar:isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button" @click.prevent="collapse">
        <my-icon icon-class="next" v-show="isCollapse" />
        <my-icon icon-class="pre" v-show="!isCollapse" />
      </div>
      <!-- 主菜单 -->
      <el-menu  class="aside-menu" :collapse="isCollapse" :default-active="$route.path" router  background-color="#373d41" text-color="#fff" active-text-color="#4682B4">
        <!-- 区域菜单 -->
        <el-submenu v-for="region in regionDataWithBuilding" :key="region.id" :index="region.name">
          <template slot="title">
            <my-icon icon-class="building" />
            <span style="font-size:12px;" slot="title">{{region.name}}</span>
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
import { getRegionWithBuildings } from "@/api/basiceData";
export default {
  data() {
    return {
      sss: "222",
      isCollapse: false,
      // 区域信息
      regionDataWithBuilding: []
    };
  },
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
    }
  }
};
</script>

<style scoped lang="scss">
</style>
