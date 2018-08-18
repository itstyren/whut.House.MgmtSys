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
            <div class="_card  fix-list" v-for="item in todoFixForm" :key="item.fixId" @click="listClick(item)">
              <div class="first">
                <span>申请时间：{{item.applyTime}}</span>
              </div>
              <div class="second">
                <span> 维修类型：{{item.fixType}}</span>
                <span>审核状态：{{item.fixState}}</span>
              </div>
              <div class="sleect">></div>
            </div>
          </div>
          <!-- 已经结束的表单 -->
          <div class="weui-tab__content" :hidden="activeIndex != 1">
            <!-- 已通过表单 -->
            <div class="_card  fix-list" v-for="item in doneFixForm" :key="item.fixId" @click="listClick(item)">
              <div class="first">
                <span>申请时间：{{item.applyTime}}</span>
              </div>
              <div class="second">
                <span> 维修类型：{{item.fixType}}</span>
                <span>审核状态：{{item.fixState}}</span>
              </div>
              <div class="sleect">></div>
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
        todoFixForm: [],
        doneFixForm: []
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
      this.todoFixForm = wx.getStorageSync("todoFixForm");
      this.doneFixForm = wx.getStorageSync("doneFixForm");
    },
    methods: {
      tabClick(e) {
        console.log(e);
        this.activeIndex = e.currentTarget.id;
      },
      listClick(form) {
        const url = "./detail/main?data=" + JSON.stringify(form);
        wx.navigateTo({
          url
        });
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

  .fix-list {
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
