<template>
  <div class="second-container">
    <aside :class="{hideSidebar:isCollapse}">
      <scroll-bar>
        <!-- 展开关闭按钮 -->
        <div class="asid-button" @click.prevent="collapse">
          <my-icon icon-class="next" v-show="isCollapse" />
          <my-icon icon-class="pre" v-show="!isCollapse" />
        </div>
        <!-- 主菜单 -->
        <el-menu class="aside-menu" :collapse="isCollapse" :default-active="$route.path" background-color="#373d41" text-color="#fff"
          active-text-color="#4682B4" router>
          <!-- 楼栋区域 -->
          <el-menu-item index="/basic/buildingArea/campus">
            <my-icon icon-class="dituleijubuquyutu" />
            <span slot="title">校区管理</span>
          </el-menu-item>
          <el-menu-item index="/basic/buildingArea/region">
            <my-icon icon-class="link" />
            <span slot="title">区域管理</span>
          </el-menu-item>
          <el-submenu index="houseParam">
            <template slot="title">
              <my-icon icon-class="building" />
              <span slot="title">楼栋管理</span>
            </template>
            <el-menu-item v-for="region in regionData" :key="region.id" :index="'/basic/buildingArea/building/'+region.id">{{region.name}}</el-menu-item>
          </el-submenu>
        </el-menu>
      </scroll-bar>
    </aside>
    <section class="main-container">
      <transition mode="out-in">
        <router-view></router-view>
      </transition>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import {
    getRegionData,
    getRegionWithBuildings
  } from "@/api/basiceData";
  import ScrollBar from "@/components/ScrollBar";
  export default {
    data() {
      return {
        isCollapse: false,
        regionData: []
      };
    },
    components: {
      ScrollBar
    },
    // 计算属性
    computed: {
      regionStatus: function () {
        return this.$store.state.regionStatus;
      }
    },
    // 监听者
    watch: {
      regionStatus: {
        handler: function (params) {
          this.getRigion();
        }
      }
    },
    created() {
      this.getRigion();
    },
    methods: {
      //折叠
      collapse: function () {
        this.isCollapse = !this.isCollapse;
      },
      // 获取区域信息
      getRigion() {
        this.listLoading = true;
        let param = {};
        getRegionData(param)
          .then(res => {
            this.regionData = res.data.data.data.list;
            this.regionData.forEach(region => {
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
@import "../../../styles/variables.scss";

.second-container {
  background-color: $background-grey;

}

</style>
