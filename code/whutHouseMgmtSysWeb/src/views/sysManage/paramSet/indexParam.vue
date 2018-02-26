<template>
  <div class="second-container">
    <aside :class="{showSidebar:!isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button" @click.prevent="collapse">
        <my-icon icon-class="next" v-show="isCollapse" />
        <my-icon icon-class="pre" v-show="!isCollapse" />
      </div>
      <!-- 主菜单 -->
      <el-menu :collapse="isCollapse" :default-active="$route.path" router>
        <!-- 住房参数 -->
        <el-submenu index="houseParam">
          <template slot="title">
            <i class="el-icon-search"></i>
            <span slot="title">住房参数</span>
          </template>
          <el-menu-item index="/sysmanage/paramSet/houseType">
            住房类型
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/houseLayout">
            住房户型
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/houseStatus">
            使用状态
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/houseStruct">
            住房结构
          </el-menu-item>
        </el-submenu>
        <!-- 职工参数 -->
        <el-submenu index="staffParam">
          <template slot="title">
            <i class="el-icon-plus"></i>
            <span>职工参数</span>
          </template>
          <el-menu-item index="/sysmanage/paramSet/staffDept">
            工作部门
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/staffPost">
            职务
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/staffTitle">
            职称
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/staffClass">
            职工类别
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/staffStatus">
            工作状态
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/staffSpouse">
            配偶单位性质
          </el-menu-item>
        </el-submenu>
        <!-- 租赁参数 -->
        <el-submenu index="rentParam">
          <template slot="title">
            <i class="el-icon-edit "></i>
            <span slot="title">租赁参数</span>
          </template>
          <el-menu-item index="/sysmanage/paramSet/rentPostVal">
            职务分
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/rentTitleVal">
            职称分
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/rentPostArea">
            职务面积
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/rentTitleArea">
            职务面积
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/rentOption">
            选房选项
          </el-menu-item>
        </el-submenu>
        <!-- 维修参数 -->
        <el-submenu index="fixParam">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span slot="title">维修参数</span>
          </template>
          <el-menu-item index="/sysmanage/paramSet/fixContent">
            维修内容
          </el-menu-item>
        </el-submenu>
        <!-- 租赁参数 -->
        <el-submenu index="rentalParam">
          <template slot="title">
            <i class="el-icon-star-off"></i>
            <span slot="title">租赁参数</span>
          </template>
          <el-menu-item index="/sysmanage/paramSet/rentalOption">
            租金选项
          </el-menu-item>
          <el-menu-item index="/sysmanage/paramSet/residentRel">
            登记关系
          </el-menu-item>
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
  export default {
    data() {
      return {
        isCollapse: false
      };
    },
    methods: {
      //折叠
      collapse: function () {
        this.isCollapse = !this.isCollapse;
      }
    }
  };

</script>

<style scoped lang="scss">


</style>
