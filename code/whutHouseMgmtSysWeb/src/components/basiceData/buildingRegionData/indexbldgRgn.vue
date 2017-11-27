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
      <el-menu :collapse="isCollapse" :default-active="$route.path" router>
        <!-- 楼栋区域 -->
        <el-menu-item index="/basic/buildingArea/region">
          <span slot="title">区域管理</span>
        </el-menu-item>
        <el-submenu index="houseParam" >
          <template slot="title">
            <i class="el-icon-search"></i>
            <span slot="title">楼栋管理</span>
          </template>
          <el-menu-item v-for="region in regionData" :key="region.id" :index="'/baseic/buildingArea/building'+region.id">{{region.name}}</el-menu-item>
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
  import {
    getRegionData
  } from "@/api/api";
  export default {
    data() {
      return {
        isCollapse: false,
        regionData: []
      };
    },
    components: {},
    created() {
      this.getrigion();
    },
    methods: {
      //折叠
      collapse: function () {
        this.isCollapse = !this.isCollapse;
      },
      getrigion() {
        this.listLoading = true;
        let param = {
          // page: this.page,
          // size: this.size
        };
        // 获取区域信息
        getRegionData(param)
          .then(res => {

            this.regionData = res.data.data.data.list;
            this.regionData.forEach(region=>{
              let flag=region.name.indexOf('（')
              if(flag!=-1){
              console.log(flag)
              region.name=region.name.substring(0,flag)
              }

            })
            //console.log(typeof this.regionData.name ) 
            this.totalNum = res.data.data.data.total;
            // console.log(res.data.data.list)
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
aside{
>.el-menu {
  width: 250px
    }
}


</style>
