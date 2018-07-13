<template>
  <div class="page">
    <div class="page__bd">
      <div class="weui-tab">
        <div class="weui-navbar">
          <block v-for="(item,index) in tabs" :key="index">
            <div :id="index" :class="{'weui-bar__item_on':activeIndex == index}" class="weui-navbar__item" @click="tabClick">
              <div class="weui-navbar__title">{{item}}</div>
            </div>
          </block>
          <div class="weui-navbar__slider" :class="navbarSliderClass"></div>
        </div>
        <div class="weui-tab__panel">
          <!-- 正在处理的表单 -->
          <div class="weui-tab__content " :hidden="activeIndex != 0">
              <!-- 待受理表单 -->
            <div class="_card fixFormList">
                 <div class="table">
      <div class="tr ">
          <div class="th th1">日期</div>
          <div class="th th2">维修类型</div>
          <div class="th th3">状态</div>
      </div>
      <div class="tr" v-for="item in todoFixForm" :key="item.fixId" >
          <div class="td td1">{{item.applyTime}}</div>
          <div class="td td2">{{item.fixType}}</div>
          <div class="td td3">{{item.fixState}}</div>
      </div>
    </div>
            </div>
          </div>
          <!-- 已经结束的表单 -->
          <div class="weui-tab__content" :hidden="activeIndex != 1">
                            <!-- 已通过表单 -->
            <div class="_card fixFormList">
                 <div class="table">
      <div class="tr ">
          <div class="th th1">日期</div>
          <div class="th th2">维修类型</div>
          <div class="th th3">状态</div>
      </div>
      <div class="tr" v-for="item in doneFixForm" :key="item.fixId" >
          <div class="td td1">{{item.applyTime}}</div>
          <div class="td td2">{{item.fixType}}</div>
          <div class="td td3">{{item.fixState}}</div>
      </div>
    </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        tabs: ["正在进行", "已经结束"],
        activeIndex: 0,
        fontSize: 30,
        todoFixForm : [],
        doneFixForm : [],
      };
    },
    computed: {
      navbarSliderClass() {
        if (this.activeIndex == 0) {
          return "weui-navbar__slider_0";
        }
        if (this.activeIndex == 1) {
          return "weui-navbar__slider_1";
        }
      }
    },
    mounted() {
      this.todoFixForm=wx.getStorageSync('todoFixForm')
      this.doneFixForm=wx.getStorageSync('doneFixForm')
    },
    methods: {
      tabClick(e) {
        console.log(e);
        this.activeIndex = e.currentTarget.id;
      }
    }
  };

</script>

<style scoped lang="scss">
  page,
  .page,
  .page__bd {
    height: 100%;
  }

  .page__bd {
    padding-bottom: 0;
  }

  .weui-tab__content {
    padding-top: 20px;
    text-align: center;
  }

  .weui-navbar__slider_0 {
    left: 29rpx;
    transform: translateX(0);
  }

  .weui-navbar__slider_1 {
    left: 29rpx;
    transform: translateX(380rpx);
  }
.weui-navbar__slider {
  width: 9em;

}
/* 表格代码   */
.table{
  border:1px solid #dadada;
  border-right:0;
  border-bottom: 0;
  width: 98%;
  margin-left: 1%;
}
.tr{
  width:100%;
  display: flex;
  padding: 5px 10px;
  justify-content: space-between;
}
.th,.td{
  padding: 10px;
  border-bottom: 1px solid #dadada;
  // border-right: 1px solid #dadada;
  text-align: center;
  width: 100%;
}
.th1,.th2,.td1,.td2{
  width: 100%;
}
.th{
  padding: 0;
  border: none;
  font-weight: 800;
  // background-color: #b66242;
  font-size: 28rpx;
  color: #330e0e;
}
.td{
  font-size: 28rpx;
}
</style>
