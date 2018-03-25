<template>
 <div class="channel card" :style="{height:height,width:width}">
<div class="title">
      <strong>快速通道</strong> 
</div>
 </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {};
  },
  props: {
    height: {
      type: String,
      default: "350px"
    },
    width: {
      type: String,
      default: "100%"
    }
  },
  components: {}
};
</script>

<style scoped lang="scss">
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: -10px;
    z-index: 1;
    left: 1%;
    right: 1%;
  }
}
</style>
