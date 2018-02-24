<template>
  <div class="second-container">
    <!-- 这里放置index -->
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修结算</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbal card">
            <el-form :model="queryForm" label-width="100px" >
              <el-row>
                <el-col :span="4">
                  <el-form-item label="查询条件">
                    <el-select v-model="queryForm.conditionId" :clearable="true" placeholder="请选择条件">
                      <el-option v-for="conditionid in formOption.fixBalanceCondition" :key="conditionid.value" :value="conditionid.value" :label="conditionid.label"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="输入条件">
                    <el-input v-model="queryForm.conditionContent" placeholder="输入检索"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="4">
                  <el-form-item label="申请时间">
                    <el-input v-model="queryForm.conditionContent" placeholder="输入检索"></el-input>
                  </el-form-item>
                </el-col>
                             <el-col :span="5">
                  <el-form-item label="">
                      <el-button type="danger">重置</el-button>
                      <el-button type="primary">查询</el-button>
                  </el-form-item>
                </el-col>
              </el-row>
            </el-form>
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
  import * as OPTION from "@/assets/data/formOption";
  export default {
    data() {
      return {
        queryForm: {},
        // 一些不需要后台获取的静态数据
        formOption: OPTION
      };
    },
    components: {}
  };

</script>

<style scoped lang="scss">
  .toolbal {
    padding: 10px 10px;
    & .el-form-item {
      margin-bottom: 5px;
    }
  }

</style>
