<template>
 <div class="page">
123
 </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {};
  },
  components: {},
  // 当页面显示时候调用
onLoad(){
wx.scanCode({
  success: (res) => {
    console.log(res)
  }
})
}
};
</script>

<style scoped >
</style>
