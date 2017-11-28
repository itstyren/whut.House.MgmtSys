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
        <el-submenu index="houseParam" v-for="house in houseData" :key="house.id">
          <template slot="title">
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon-building"></use>
            </svg>
            <span slot="title">{{house.name}}</span>
          </template>
          <el-menu-item v-for="house in houseData" :key="house.id" :index="'/basic/buildingArea/building/'+house.id">{{house.name}}</el-menu-item>
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
        houseData: []
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

            this.houseData = res.data.data.data.list;
            this.houseData.forEach(house => {
              let flag = house.name.indexOf('（')
              if (flag != -1) {
                console.log(flag)
                house.name = house.name.substring(0, flag)
              }

            })
            //console.log(typeof this.houseData.name ) 
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
  aside {
    >.el-menu {
      width: 250px
    }
    span{
      padding-left: 20px
    }
  }

</style>
