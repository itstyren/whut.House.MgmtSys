<template>
  <div class="special-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
            <div class="welcome">
            <strong>欢迎您 , {{$store.getters.userName}}</strong>
            </div>
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
</template>

<script type="text/ecmascript-6">
import adminDashboard from './admin/index'
 export default {
   data() {
     return {
currentRole:'adminDashboard'
     }

   },
   components: {
adminDashboard
   }
 }
</script>

<style scoped lang="scss">
.welcome{
    margin:20px;
    font-size: 16px
}
 
</style>
