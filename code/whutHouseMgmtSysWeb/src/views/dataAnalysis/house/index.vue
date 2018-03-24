<template>
 <div class="second-container">
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>统计分析</el-breadcrumb-item>
            <el-breadcrumb-item>住房分析</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
 export default {
   data() {
     return {

     }

   },
   components: {

   }
 }
</script>

<style scoped lang="scss">

 
</style>
