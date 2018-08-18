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
            <!-- 年度补贴 -->
            <div class="_card  moetary-list" v-for="item in yaerMonetary" :key="item.year">
              <div class="first">
                <span>发放年度：{{item.year}}</span>
              </div>
              <div class="second">
                <span> 年度工资：{{item.annualSal}}</span>
                <span>补贴金额：{{item.subsidies}}</span>
              </div>
              <!-- <div class="sleect">></div> -->
            </div>
            <div class="null" v-if="yaerMonetary.length==0">
              暂无年度补贴发放记录
            </div>
          </div>
          <!-- 已经结束的表单 -->
          <div class="weui-tab__content" :hidden="activeIndex != 1">
            <!-- 一次性补贴 -->
            <div class="_card  moetary-list" v-for="item in lumpMonetary" :key="item.year">
              <div class="first">
                <span>发放年度：{{item.year}}</span>
              </div>
              <div class="second">
                <!-- <span> 维修类型：{{item.fixType}}</span> -->
                <span>补贴金额：{{item.subsidies}}</span>
              </div>
              <!-- <div class="sleect">></div> -->
            </div>
            <div class="null" v-if="lumpMonetary.length==0">
              暂无一次性补贴发放记录
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
        tabs: ["年度补贴", "一次补贴"],
        activeIndex: 0,
        fontSize: 30,
        yaerMonetary: [],
        lumpMonetary: []
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
      this.yaerMonetary = wx.getStorageSync("yaerMonetary");
      this.lumpMonetary = wx.getStorageSync("lumpMonetary");
    },
    methods: {
      tabClick(e) {
        // console.log(e);
        this.activeIndex = e.currentTarget.id;
      },
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
    left: 0rpx;
    transform: translateX(0);
  }

  .weui-navbar__slider_1 {
    left: 80rpx;
    transform: translateX(340rpx);
  }

  .weui-navbar__slider {
    width: 10em;
  }

  /* 表格代码   */

  .table {
    border: 1px solid #dadada;
    border: none;
    width: 98%;
    margin-left: 1%;
  }

  .title {
    border-bottom: 1px solid #dadada;
  }

  .tr {
    width: 100%;
    display: flex;
    padding: 5px 10px;
    justify-content: space-between;
  }

  .th,
  .td {
    padding: 10px;
    border-bottom: 1px solid #dadada; // border-right: 1px solid #dadada;
    text-align: center;
    width: 100%;
  }

  .th1,
  .th2,
  .td1,
  .td2 {
    width: 100%;
  }

  .th {
    padding: 0;
    border: none;
    font-weight: 800; // background-color: #b66242;
    font-size: 28rpx;
    color: #330e0e;
  }

  .td {
    font-size: 28rpx;
  }

  .moetary-list {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: flex-start;
    position: relative; // justify-content: space-around;
    // align-items: center;
    .first {
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      font-size: 16px;
      font-weight: 600;
      margin-bottom: 10px;
    }
    .second {
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      font-size: 14px;
      font-weight: 200;
      >span {
        margin-right: 15px;
      }
    }
    .sleect {
      position: absolute;
      right: 14px;
      top: 40%;
      font-size: 16px;
      font-weight: 600;
    }
  }

</style>
