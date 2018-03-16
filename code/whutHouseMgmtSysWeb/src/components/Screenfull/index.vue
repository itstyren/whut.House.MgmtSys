<template>
  <div style="font-size:20px;"  @click='click'> 
      <my-icon class="screenfull-svg" icon-class="quanping"></my-icon>
  </div>
</template>

<script>
import screenfull from "screenfull";

export default {
  name: "screenfull",
  props: {
    width: {
      type: Number,
      default: 22
    },
    height: {
      type: Number,
      default: 22
    },
    fill: {
      type: String,
      default: "#48576a"
    }
  },
  data() {
    return {
      isFullscreen: false
    };
  },
  methods: {
    click() {
      if (!screenfull.enabled) {
        this.$message({
          message: this.$t('screenfull_message'),
          type: "warning"
        });
        return false;
      }
      screenfull.toggle();
    }
  }
};
</script>

<style scoped>
.screenfull-svg {
  display: inline-block;
  cursor: pointer;
  fill: #fff;
  width: 20px;
  height: 20px;
  vertical-align: -6px !important;
}
</style>
