<template>
  <div class="second-container">
    <staffIndex @emit-staff="getStaff"></staffIndex>
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修直批</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbal">
            <el-row>
              <el-col :span="4" :offset="1">
                <el-input v-model="query" placeholder="输入职工姓名或id搜索"></el-input>
              </el-col>
              <el-col :span="1" :offset="1">
                <el-button type="primary">查询</el-button>
              </el-col>
              <el-col :span="1" :offset="1">
                <el-button type="primary">重置</el-button>
              </el-col>
            </el-row>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-row>
              <el-col :span="12">
                <div class="staffTable card">

                </div>
              </el-col>
              <el-col :span="12">
                <div class="houseRel card">

                </div>
              </el-col>
            </el-row>

          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import staffIndex from "./components/staffIndex";
  import {
    getFixStaffById,
    getFixStaffByName
  } from "@/api/api";
  export default {
    data() {
      return {};
    },
    components: {
      staffIndex
    },
    methods: {
      getStaff(object) {
        console.log(object);
      }
    }
  };

</script>

<style scoped lang="scss">


</style>
