<template>
  <div class="errPage-container">
    <el-row class="content"
            type="flex"
            justify="center">
      <el-col :span="11"
              style="padding-top:20vh">
        <el-row>
          <el-col :span="24">
            <h1 class="text-jumbo text-ginormous">404!</h1>
            <strong class="error-text">您所访问的页面不存在</strong>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24"
                  class="button">
            <el-button @click="click"
                       type="">返回首页</el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="13">
        <img :src="gif_404"
             width="700"
             height="650"
             alt="Girl has dropped her ice cream.">
      </el-col>
    </el-row>
  </div>
</template>

<script>
import gif_404 from "@/assets/404.gif";

export default {
  name: "page404",
  data () {
    return {
      gif_404
    };
  },
  methods: {
    click () {
      this.$router.push({
        path: "/"
      });
    }
  }
};

</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.errPage-container {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: #f4f4f4;
  .content {
    position: relative;
    top: 50%;
    transform: translateY(-50%);
    color: #484848;
    text-align: right;
    .button {
      margin-top: 8vh;
    }
    .text-jumbo {
      font-size: 80px;
      font-weight: 700;
    }
    .error-text {
      font-size: 30px;
      font-weight: 600;
    }
  }
}
</style>
