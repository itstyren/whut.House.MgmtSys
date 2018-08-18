<template>
<div class="container">
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <a href="/pages/fixApply/main"><image src="http://p1z72063k.bkt.clouddn.com/wx/fixApply.png" class = "link"/></a>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <a href="/pages/hireApply/main"><image src="http://p1z72063k.bkt.clouddn.com/wx/hireApply.png" class = "link"/></a>
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <a href="/pages/selfService/main"><image src="http://p1z72063k.bkt.clouddn.com/wx/selfService.png" class = "link"/></a>
        </div>
  </div>
  <!-- <div class="scaner" @click="scanerClick">
    <image src="http://p1z72063k.bkt.clouddn.com/wx/nav_scaner.png" class="scaner_img"/>
  </div> -->
</div>
</template>

<script>
import store from "@/store/index";

export default {
  data() {
    return {
    };
  },
  computed: {
    count() {
      return store.state.count;
    }
  },
  components: {}, 
  methods: {
    // 当点击了扫描时
    scanerClick() {
      wx.scanCode({
        success: res => {
          console.log(res);
        }
      });
    }
  }
};
</script>

<style lang="scss" >
.container {
  padding-top: 30px;
  position: relative;
  height: 93vh;
  .scaner {
    padding: 10px;
    border-radius: 50%;
    border: 1px solid #e6ebf5;
    box-shadow: 0 2px 8px 0 rgba(0, 0, 0, 0.5);
    background-color: #ffffff;
    position: absolute;
    bottom: 15px;
    right: 24px;
    .scaner_img {
      width: 30px;
      height: 35px;
    }
  }
}
.zan-col {
  line-height: 30px;
  text-align: center;
  font-size: 12px;
  color: #fff;
  align-items: center;
}

.zan-row {
  padding-bottom: 20px;
}

.doc-title {
  text-align: center;
}

.link {
  width: 85vw;
  height: 24vh;
  -moz-border-radius: 8px;
  -webkit-border-radius: 8px;
  // box-shadow: 5px 5px 5px #888888;
      box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.5);
}
</style>
