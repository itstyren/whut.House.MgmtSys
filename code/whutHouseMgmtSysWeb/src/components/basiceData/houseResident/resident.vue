<template>
    <div class="third-container">
    <!-- 面包屑导航 -->      
    <div class="warp-breadcrum">   
               <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>住房登记</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 --> 
    <div class="warp-body">
      <!-- 工具栏 -->    
      <div class="toolbal">      
      </div>
      <!-- 信息区 --> 
      <div class="main-data">    
          <!-- 个人信息区 -->
          <div class="before-info">
                  <personal-info-table ></personal-info-table>
              <div class="house-rel">
                  <staff-house-rel></staff-house-rel>
              </div>
          </div>
                <!-- 住房登记区 -->
      <div class="house-resident"></div>
      </div>
    </div>
    </div>
</template>

<script type="text/ecmascript-6">
import personalInfoTable from "./personalInfoTable";
import staffHouseRel from "./staffHouseRel";
export default {
  data() {
    return {};
  },
  // 组件信息
  components: {
    //个人信息区域
    personalInfoTable,
    staffHouseRel
  }
};
</script>

<style scoped lang="scss">
.main-data {
  display: flex;
  flex-direction: column;
  position: relative;
  .before-info {
    //position: absolute;
    display: flex;
    flex-direction: row;
    width: 100%;
    height: 40%;
    .personal-info {
      width: 50%;
      height: 100%;
      background-color: aquamarine;
    }
    .house-rel {
      flex: 1;
    }
  }
  .house-resident {
      width: 100%;
      height: 20%;
      background-color: antiquewhite;
  }
}
</style>
