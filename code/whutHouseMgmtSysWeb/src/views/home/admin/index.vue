<template>
  <div class="dashboard-admin">
<el-row>
  <el-col :span="6" style="margin-left:50x">
    <el-row>
      <info-card></info-card>
    </el-row>
    <el-row>
      <todo-list></todo-list>
    </el-row>
  </el-col>
  <el-col :span="18" class="pannel-group">
    <el-row>
      <pannel-group></pannel-group>
    </el-row>
    <el-row>
      <el-col :span="11" >
<page-view :height="'35vh'"></page-view>
      </el-col>
    </el-row>
  </el-col>
</el-row>

 </div>
</template>

<script type="text/ecmascript-6">
import infoCard from "../components/infoCard";
import pannelGroup from "../components/pannelGroup";
import todoList from "./components/todoList";
import pageView from "./components/pageView";
export default {
  data() {
    return {};
  },
  components: {
    infoCard,
    pannelGroup,
    todoList,
    pageView
  }
};
</script>

<style scoped lang="scss">
</style>
