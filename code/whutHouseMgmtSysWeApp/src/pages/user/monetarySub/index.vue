<template>
 <div class="page">
    <div class="current-info zan-row">
        <div class="title">
            <span>本年度补贴金额（元）</span>
        </div>
        <div class="content">
            <span>{{currentMonetary}}.00</span>
        </div>
        <div class="footer">
            <span>本年度货币化补贴已核算</span>
            <button @click="check" class="zan-btn zan-btn--mini zan-btn--plain">去查看</button>            
        </div>
    </div>
        <!-- 操作区域 -->
    <div class="zan-row user-cell">
      <a href="./allMonetary/main">
        <div class="zan-cell zan-cell--access">
          <div class="zan-icon zan-icon-description" style="color: #ff4343;"></div>
          <div class="zan-cell__bd">历史补贴查询</div>
          <div class="zan-cell__ft">
          </div>
        </div>
      </a>

      <a href="./policyInterpretation/main">
        <div class="zan-cell zan-cell--access">
          <div class="zan-icon zan-icon-points-mall" style="color: #ff4343;"></div>
          <div class="zan-cell__bd">补贴政策解读</div>
          <div class="zan-cell__ft">
          </div>
        </div>
      </a>
    </div>
 </div>
</template>

<script type="text/ecmascript-6">
import { getStaffMonetaryByNO, getStaffLumpMonetaryByNO } from "@/api";
export default {
  data() {
    return {
      monetaryList: [],
      staffNO: "",
      currentMonetary: 0
    };
  },
  components: {},
  mounted() {
    this.staffNO = this.$store.state.userinfo.no;
    this.getStaffMonetarySub();
  },
  methods: {
    // 获取货币化补贴
    getStaffMonetarySub() {
      let params = {
        page: 1,
        size: 10
      };
      getStaffMonetaryByNO(params, this.staffNO).then(res => {
        wx.showLoading({
          title: "请稍后"
        });
        let monetaryList = res.data.data.list;
        wx.setStorageSync("yaerMonetary", monetaryList);
          this.currentMonetary=res.data.totalSubNumber
        // this.currentMonetary = res.data.totalSubNumber;
        getStaffLumpMonetaryByNO(this.staffNO).then(res => {
          const array = res.data.data;
          let temp = [];
          // console.log(array);
          if (array.length != 0) {
            array.forEach(item => {
              let data = {
                year: item.oneTimeSubYear,
                annualSal: "/",
                subsidies: item.oneTimeSubsidy,
                remark: item.remark
              };
              temp.push(data);
              //   this.monetaryList.unshift(data);

              //   console.log(this.monetaryList)
            });
            wx.setStorageSync("lumpMonetary", temp);
          }
          wx.hideLoading();
        });
      });
    },
    // 前往查看详情
    check() {
      const url = "./yearDetail/main";
      wx.navigateTo({
        url
      });
    }
  }
};
</script>

<style scoped lang="scss">
.current-info {
  position: relative;
  height: 20vh;
  background-color: #ff4343;
  padding: 5%;
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  color: #fff;
  .title {
    font-size: 16px;
    margin-bottom: 5px;
  }
  .content {
    font-size: 45px;
    font-weight: 600;
  }
  .footer {
    background-color: #be1d1d;
    //   height: 6px;
    font-size: 16px;
    position: absolute;
    width: 100%;
    left: 0;
    bottom: 0;
    padding: 2px 0 2px 10px;
  }
}

.user-cell {
  margin-top: 3vh;
  .zan-cell {
    font-size: 22px;
    background-color: #fff;
    margin-bottom: 2vh;
  }
  .zan-cell__bd {
    margin-left: 20px;
    font-size: 16px;
  }
  .zan-cell__ft {
    font-size: 14px;
    line-height: 10px;
    letter-spacing: 2px;
    padding-right: 20px;
    span {
      padding: 2px 4px;
      background-color: #d8d8d8;
      color: #fff;
      border-radius: 30px;
    }
  }
}
</style>
