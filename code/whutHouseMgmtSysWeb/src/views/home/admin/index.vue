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
    <el-row >
      <el-col :span="23"  >
<page-view :height="'35vh'"></page-view>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <fix-pie :height="'40vh'"></fix-pie>
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
import fixPie from './components/fixPie'
export default {
  data() {
    return {};
  },
  components: {
    infoCard,
    pannelGroup,
    todoList,
    pageView,fixPie
  }
};
</script>

<style scoped lang="scss">

</style>
