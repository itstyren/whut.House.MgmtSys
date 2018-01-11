<template>
    <div class="third-container">
    <!-- 面包屑导航 -->      
    <div class="warp-breadcrum">
              <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>职工管理</el-breadcrumb-item>
        <el-breadcrumb-item>职工</el-breadcrumb-item>
        
      </el-breadcrumb>    
    </div>
    <!-- 下方主内容 --> 
    <div class="warp-body">
      <!-- 工具栏 -->    
      <div class="toolbal">   
                  <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" >编辑员工</el-button>
        </el-form>   
      </div>
      <!-- 表单区 --> 
      <div class="main-data"> 
                        <el-form :model="staffFrom">
          <div class="staff-from">

                  <div class="single-staff-from">
                      <el-form-item label="职工编号" prop="no">
                          <el-input v-model="staffFrom.no" ></el-input>
                      </el-form-item>
                  </div>
                                    <div class="single-staff-from">
                                                              <el-form-item label="姓名" prop="name">
                          <el-input v-model="staffFrom.name" ></el-input>
                      </el-form-item>
                                    </div>

              </div>  
              <div class="staff-spouse-from"></div> 
                            </el-form>
      </div>
    </div>
    </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      staffFrom: []
    };
  },
  components: {}
};
</script>

<style scoped lang="scss">
.main-data {
  display: flex;
  flex-direction: column;
  border: 1px solid black;
  // 员工主表
  .staff-from {
    width: 90%;
    height: 100%;
    margin: 10px auto 0px;
    padding-left: 10px;
    display: flex;
    flex-direction: row;
    flex: 1;
    .single-staff-from {
        width:50%;
      display: flex;
      flex-direction: column;
      flex: 1;
    }
  }
  // 员工配偶表单
  .staff-spouse-from {
    flex: 1;
  }
}
</style>
