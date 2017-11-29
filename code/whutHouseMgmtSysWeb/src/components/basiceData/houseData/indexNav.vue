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
      <el-menu :collapse="isCollapse" :default-active="$route.path" router v-for="region in regionData" :key="region.id">
        <!-- 区域菜单 -->
        <el-submenu index="regionParam" >
          <template slot="title">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-building"></use>
            </svg>
            <span slot="title">{{region.name}}</span>
          </template>
          <el-menu-item v-for="building in buildingData[region.id]" :key="building.id" :index="building.id">{{building.name}}</el-menu-item>
        </el-submenu>
      </el-menu>
    </aside>
    <section class="main-container">
      <!-- 需要长时间存活的 -->
      <transition>
        <keep-alive>
          <router-view v-if="$route.meta.keepAlive"></router-view>
        </keep-alive>
      </transition>
      <!-- 不需要长时间保存的 -->
      <transition mode="out-in">
        <router-view v-if="!$route.meta.keepAlive"></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import { getRegionData, getbuildingDataByID } from "@/api/api";
export default {
  data() {
    return {
      isCollapse: false,
      // 区域信息
      regionData: [],
      // 楼栋信息
      buildingData: []
    };
  },
  components: {},
  created() {
    this.getRegion();
  },
  methods: {
    //折叠
    collapse: function() {
      this.isCollapse = !this.isCollapse;
    },
    getRegion() {
      this.listLoading = true;
      let param = {
        // page: this.page,
        // size: this.size
      };
      // 获取区域信息
      getRegionData(param)
        .then(res => {
          this.regionData = res.data.data.data.list;
          this.regionData.forEach(region => {
            let flag = region.name.indexOf("（");
            if (flag != -1) {
              // console.log(flag)
              region.name = region.name.substring(0, flag);
            }
          });
          //console.log(typeof this.regionData.name )
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
          console.log(this.regionData)
          //this.getBuildingData();
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 获取区域下属楼栋信息
    getBuildingData() {
      this.listLoading = true;
      let param = "";
      let regionID=1
        getbuildingDataByID(param, regionID)
          .then(res => {
            this.buildingData[regionID] = res.data.data.data.list;
                        //console.log(regionID)
            //console.log(this.buildingData[regionID])
          })
          .catch(err => {
            console.log(err);
      });
    }
  }
};
</script>

<style scoped lang="scss">
aside {
  > .el-menu {
    width: 250px;
    height: auto;
  }
  span {
    padding-left: 20px;
  }
}
</style>
