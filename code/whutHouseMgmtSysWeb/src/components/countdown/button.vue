<template>
<el-button type="primary" @click="sendMessage">{{word}}</el-button>
</template>

<script type="text/ecmascript-6">
export default {
  name: "countdown-button",
  data() {
    return {
      word: "发送验证码",
      isOvertime: false
    };
  },
  methods: {
    sendMessage() {
      if (this.isOvertime) {
        return false;
      }
      let that = this,
        time = 60;
      var sendTimer = setInterval(function() {
        that.isOvertime = true;
        time--;
        that.word = `重新发送 ${time} 秒后` ;
        if (time < 0) {
          that.isOvertime = false;
          clearInterval(sendTimer);
          that.word = "获取验证码";
        }
      }, 1000);
    }
  }
};
</script>

<style scoped lang="scss">

</style>
