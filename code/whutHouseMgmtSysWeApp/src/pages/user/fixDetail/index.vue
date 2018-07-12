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
          <div class="weui-tab__content" :hidden="activeIndex != 0">
              <!-- 待受理表单 -->
            <div class="_card">
              <div class="title">
                <span>待受理</span>
              </div>
              <div class="cell" v-if="false">
                <div class="zan-cell zan-cell--access" @click="fixCheck">
                  <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
                  <div class="zan-cell__bd">查看维修申请单</div>
                  <div class="zan-cell__ft"></div>
                </div>
              </div>
              <div class="no-cell" v-else>
                暂无数据
              </div>
            </div>
            <!-- 待审核表单 -->
                        <div class="_card" style="margin-top:30px">
              <div class="title">
                <span>待审核</span>
              </div>
              <div class="cell" v-if="false">
                <div class="zan-cell zan-cell--access" @click="fixCheck">
                  <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
                  <div class="zan-cell__bd">查看维修申请单</div>
                  <div class="zan-cell__ft"></div>
                </div>
              </div>
              <div class="no-cell" v-else>
                暂无数据
              </div>
            </div>
          </div>
          <!-- 已经结束的表单 -->
          <div class="weui-tab__content" :hidden="activeIndex != 1">
                            <!-- 已通过表单 -->
            <div class="_card">
              <div class="title">
                <span>审核通过</span>
              </div>
              <div class="cell" v-if="false">
                <div class="zan-cell zan-cell--access" @click="fixCheck">
                  <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
                  <div class="zan-cell__bd">查看维修申请单</div>
                  <div class="zan-cell__ft"></div>
                </div>
              </div>
              <div class="no-cell" v-else>
                暂无数据
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
        tabs: ["正在处理", "已经结束"],
        activeIndex: 0,
        fontSize: 30
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
    methods: {
      tabClick(e) {
        console.log(e);
        this.activeIndex = e.currentTarget.id;
      }
    }
  };

</script>

<style scoped>
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
    transform: translateX(250rpx);
  }

  .weui-navbar__slider_2 {
    left: 29rpx;
    transform: translateX(500rpx);
  }

  .no-cell {
    height: 20vh;
    display: flex;
    align-items: center;
    justify-content: center;
  }

</style>
