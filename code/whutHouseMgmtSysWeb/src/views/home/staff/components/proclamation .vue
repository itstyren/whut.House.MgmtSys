<template>
  <div class="proclamation card">
    <div class="title">
      <strong>系统说明</strong>
    </div>
    <div class="content">
      {{content}}
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
  .proclamation {
    height: 84vh;
    padding: 20px;
    .title {
      font-size: 26px;
      font-weight: 400;
      position: relative;
      &::after {
        content: "";
        width: 100%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -10px;
        z-index: 1; //left: 1%;
        right: 1%;
      }
    }
    .content {
      margin-top: 30px;
      height: 90%;
      overflow-y: auto;
    }
  }

</style>
