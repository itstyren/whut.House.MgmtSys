<template>
<div class="container">

  <div class="doc-title zan-hairline--bottom">申请</div>
  <div class="zan-panel-title"></div>
  <div class="zan-panel">
    
    <div class="zan-panel">
      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <button class="zan-btn zan-btn--large zan-btn--primary" @click="btnRepairClick">维修申请</button>
        </div>
        <div class="zan-col zan-col-2">
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <button class="zan-btn zan-btn--large zan-btn--warn">租赁申请</button>
        </div>
        <div class="zan-col zan-col-2">
        </div>
      </div>
      <div class="zan-row">
        <div class="zan-col zan-col-2">
        </div>
        <div class="zan-col zan-col-20 zan-col-offset-2">
          <button class="zan-btn zan-btn--large zan-btn--warn">申请记录</button>
        </div>
        <div class="zan-col zan-col-2">
        </div>
      </div>
    </div>
  </div>

</div>
</template>

<script>
import store from "../../store/store";

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
      wx.navigateTo({url});
    }
  },
  created() {
    console.log("created index/main");
    console.log(store.state.userinfo);
  },
  mounted() {
    console.log("mounted index/main");
    console.log(store.state.userinfo);
  }
};
</script>

<style >
.red {
  color: #f00;
}
.zan-col {
  line-height: 30px;
  text-align: center;
  background-color: #39a9ed;
  font-size: 12px;
  color: #fff;
}

.zan-row {
  padding-bottom: 30px;
}

.zan-col:nth-child(even) {
  background-color: #66c6f2;
}

.doc-title {
  text-align: center;
}
</style>
