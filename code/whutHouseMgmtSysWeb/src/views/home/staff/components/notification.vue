<template>
  <div class="card notification">
    <div class="title">
      <strong>新的通知</strong>
    </div>
    <div class="content">
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16" :offset="2">
          <span>您的住房申请状态已更新</span>
        </el-col>
        <el-col :span="5">
          <el-button size="mini" type="">查看</el-button>
        </el-col>
      </el-row>
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16" :offset="2">
          <span>您的维修申请状态已更新</span>
        </el-col>
        <el-col :span="5">
          <el-button size="mini" type="">查看</el-button>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  export default {
    data() {
      return {};
    },
    components: {}
  };

</script>

<style scoped lang="scss">
  .notification {
    height: 50vh;
    padding: 3vh;
    .title {
      position: relative;
      width: 100%;
      &::after {
        content: "";
        width: 100%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -10px;
        z-index: 1;
        left: 1%;
        right: 1%;
      }
    }
    .content {
      margin-top: 30px;
      .info-row {
        border-bottom: 1px solid #eee;
        padding: 10px;
        height: 45px;
        font-size: 16px;
        font-weight: 500
      }
    }
  }

</style>
