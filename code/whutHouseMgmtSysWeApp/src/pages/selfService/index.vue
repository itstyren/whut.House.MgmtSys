<template>
  <div class="page">
    <div v-if="isSelecting" class="select-info">
      <div class="zan-row ">
        <div class="zan-col zan-col-11 zan-col-offset-1" v-if="!isOwn">
          <span>当前选房：【{{selectInfo.isSelectingStaffName}}】</span>
        </div>
        <div class="zan-col zan-col-11 zan-col-offset-1" v-else>
          <span>您正在选房</span>
        </div>
        <div class="zan-col zan-col-11 zan-col-offset-1"  v-if="isOwn">
          <span>等待选房: 【{{selectInfo.nextSelectingStaffName}}】</span>
        </div>
      </div>
      <div class="zan-row  "  v-if="isOwn">
        <div class="zan-col zan-col-11 zan-col-offset-1 ">
          <div>
            <count-down :startTime="selectInfo.systemNowTime" :endTime="selectInfo.isSelectingStaffEndTime" :tipText="'距离开始文字1'" :tipTextEnd="'本轮剩余'"
              :endText="'已结束'" :dayTxt="'天'" :hourTxt="'小时'" :minutesTxt="'分钟'" :secondsTxt="'秒'"></count-down>
          </div>
        </div>
      </div>
      <div class="zan-row ">
        <div class="zan-col zan-col-23  zan-col-offset-1" v-if="!isOwn">
          <span>您的选房开始于【{{selectInfo.staffStartTimeNow}}】</span>
        </div>
      </div>
    </div>
    <div class="zan-row select-info" v-else>
      <div class="zan-col zan-col-20 zan-col-offset-1">
        <span>{{selectInfo}}</span>
      </div>
    </div>
    <!-- 可选房源内容区域 -->
    <div class="_card  house-list" v-for="item in ableHouseData" :key="item.fixId" @click="listClick(item)">
      <div class="first">
        <span>住房号：{{item.no}}</span>
      </div>
      <div class="second">
        <span>户型: {{item.layout}}</span>
        <span>租金：{{item.rental}}</span>
      </div>
      <div class="sleect">></div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getSelectInfoByName, getSetHouse } from "@/api";
import CountDown from "@/components/CountDownText";
export default {
  data() {
    return {
      staffID: "",
      isSelecting: false,
      isOwn: false,
      selectInfo: {},
      ableHouseData: []
    };
  },
  components: {
    CountDown
  },
  mounted() {
    this.staffID = this.$store.state.userinfo.id;
    this.getSelectInfo();
    this.getAbleHoueList();
  },
  methods: {
    // 获取可选房源
    getAbleHoueList() {
      this.ableHouseData = [];
      let param = {
        page: 1,
        size: 9999
      };
      wx.showLoading({
        title: "请稍后"
      });
      getSetHouse(param).then(res => {
        this.ableHouseData = res.data.data.list;
        wx.hideLoading();
      });
    },
    // 获取职工知否选房信息
    getSelectInfo() {
      getSelectInfoByName(this.staffID).then(res => {
        if (res.data.data != undefined) {
          this.selectInfo = res.data.data;
          this.isSelecting = true;
          if (this.selectInfo.staffStartTimeNow == null) {
            this.isOwn = true;
          }
        } else {
          this.selectInfo = res.message;
          this.isSelecting = false;
        }
      });
    },
    // 选中某一住房
    listClick(item){
      item.isOwn=this.isOwn
        const url = "./detail/main?data=" + JSON.stringify(item);
        wx.navigateTo({
          url
        });
    }
  }
};
</script>

<style scoped lang="scss">
.select-info {
  span {
    font-size: 17px;
    font-weight: 800;
  }
}

.house-list {
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
    > span {
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
