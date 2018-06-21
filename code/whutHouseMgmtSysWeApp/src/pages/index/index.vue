<template>
<div class="container">

      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <!-- <button class="zan-btn zan-btn--large zan-btn--primary" @click="btnRepairClick">维修申请</button> -->
          <a href="/pages/repair/main"><img src="../../../static/images/btnImage/roomrepair.png" class = "link"/></a>
        </div>
        <div class="zan-col zan-col-2">
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <a><img src="../../../static/images/btnImage/roomselect.png" class = "link"/></a>
        </div>
        <div class="zan-col zan-col-2">
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <a><img src="../../../static/images/btnImage/roomrent.png" class = "link"/></a>
        </div>
        <div class="zan-col zan-col-2">
        </div>
  </div>

</div>
</template>

<script>
import store from "@/store/index";

export default {
  data() {
    return {
      data: "你好"
    };
  },
  computed: {
    count() {
      return store.state.count;
    }
  },
  components: {},
  methods: {
    tap() {
      this.data += "0";
    },
    btnRepairClick() {
      const url = "../repair/main";
      wx.navigateTo({ url });
    }
  },
};
</script>

<style >
.container{
  padding-top: 8vh;
}
.red {
  color: #f00;
}
.zan-col {
  line-height: 30px;
  text-align: center;
  font-size: 12px;
  color: #fff;
  align-items: center;
}

.zan-row {
  padding-bottom: 30px;
}

.doc-title {
  text-align: center;
}

.link {
  width: 277.5px;
  height: 105px;
  -moz-border-radius: 8px;
  -webkit-border-radius: 8px;
  box-shadow: 5px 5px 5px #888888;
}
</style>
