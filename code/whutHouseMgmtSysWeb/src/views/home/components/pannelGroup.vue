<template>
  <el-row class="panel-group"
          :gutter="15">
    <el-col :span="6"
            class="card-panel-col">
      <div class='card'
           @click="handleSetLineChartData('newVisitis')">
        <el-row class="card-panel-row"
                type="flex"
                align="middle">
          <el-col :span="12"
                  class="card-panel-icon-col">
            <div class="card-panel-icon-wrapper icon-people">
              <my-icon icon-class="studio"
                       class-name="card-panel-icon" />
            </div>
          </el-col>
          <el-col :span="12">
            <div class="card-panel-description">
              <div class="card-panel-text">今日访问量</div>
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todayData.todayVisit"
                        :duration="2600"></count-to>
            </div>
          </el-col>
        </el-row>

      </div>
    </el-col>

    <el-col :span="6"
            class="card-panel-col">
      <div class="card"
           @click="handleSetLineChartData('messages')">
        <el-row class="card-panel-row"
                type="flex"
                align="middle">
          <el-col :span="12"
                  class="card-panel-icon-col">
            <div class="card-panel-icon-wrapper icon-message">
              <my-icon icon-class="fixApplyManager"
                       class-name="card-panel-icon" />
            </div>
          </el-col>
          <el-col :span="12">
            <div class="card-panel-description">
              <div class="card-panel-text">今日维修申请</div>
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todayData.todayFixApply"
                        :duration="3000"></count-to>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-col>
    <el-col :span="6"
            class="card-panel-col">
      <div class="card"
           @click="handleSetLineChartData('purchases')">
        <el-row class="card-panel-row"
                type="flex"
                align="middle">
          <el-col :span="12"
                  class="card-panel-icon-col">
            <div class="card-panel-icon-wrapper icon-money">
              <my-icon icon-class="dengji"
                       class-name="card-panel-icon" />
            </div>
          </el-col>
          <el-col :span="12">
            <div class="card-panel-description">
              <div class="card-panel-text">今日租赁申请</div>
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todayData.todayHireApply"
                        :duration="3200"></count-to>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-col>
    <el-col :span="6"
            class="card-panel-col">
      <div class="card"
           @click="handleSetLineChartData('shoppings')">
        <el-row class="card-panel-row"
                type="flex"
                align="middle">
          <el-col :span="12"
                  class="card-panel-icon-col">
            <div class="card-panel-icon-wrapper icon-shoppingCard">
              <my-icon icon-class="success"
                       class-name="card-panel-icon" />
            </div>
          </el-col>
          <el-col :span="12">
            <div class="card-panel-description">
              <div class="card-panel-text">今日业务受理</div>
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todayData.todayHandle"
                        :duration="3600"></count-to>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-col>
  </el-row>
</template>

<script type="text/ecmascript-6">
import countTo from "vue-count-to";
export default {
  data () {
    return {};
  },
  components: {
    countTo
  },
  created () {
  },
  computed: {
    todayData () {
      return this.$store.state.app.todayData;
    }
  }
};
</script>

<style scoped lang="scss">
.card {
  cursor: pointer;
  position: relative;
  overflow: hidden;
  color: #666;
  background: #fff;
  &:hover {
    .card-panel-icon-wrapper {
      color: #fff;
    }
    .icon-people {
      background: #40c9c6;
    }
    .icon-message {
      background: #36a3f7;
    }
    .icon-money {
      background: #f4516c;
    }
    .icon-shoppingCard {
      background: #34bfa3;
    }
  }
  .icon-people {
    color: #40c9c6;
  }
  .icon-message {
    color: #36a3f7;
  }
  .icon-money {
    color: #f4516c;
  }
  .icon-shoppingCard {
    color: #34bfa3;
  }
  .card-panel-icon-wrapper {
    padding: 8%;
    border-radius: 6px;
  }
  .card-panel-icon {
    float: left;
    font-size: 3.2vw;
  }
  .card-panel-description {
    font-weight: bold;
    margin-left: 0px;
    .card-panel-text {
      line-height: 18px;
      color: rgba(0, 0, 0, 0.45);
      font-size: 1.05vw;
      margin-bottom: 12px;
    }
    .card-panel-num {
      font-size: 20px;
    }
  }
}
.card-panel-col,
.card,
.card-panel-row,
.card-panel-icon-col {
  height: 100%;
}
.card {
  margin: 0 !important;
}
.card-panel-icon-col {
  display: flex;
  justify-content: center;
  align-items: Center;
}
</style>
