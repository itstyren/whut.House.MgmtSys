<template>
  <el-row class="panel-group" >
      <el-col :span="6" class="card-panel-col ">
      <div class='card' @click="handleSetLineChartData('newVisitis')">
        <div class="card-panel-icon-wrapper icon-people">
          <my-icon icon-class="studio" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">今日访问量</div>
          <count-to class="card-panel-num" :startVal="0" :endVal="102400" :duration="2600"></count-to>
        </div>
      </div>
      </el-col>
        <el-col :span="6" class="card-panel-col">
      <div class="card" @click="handleSetLineChartData('messages')">
        <div class="card-panel-icon-wrapper icon-message">
          <my-icon icon-class="baoxiu" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">今日维修申请</div>
          <count-to class="card-panel-num" :startVal="0" :endVal="81212" :duration="3000"></count-to>
        </div>
      </div>
    </el-col>
    <el-col :span="6" class="card-panel-col">
      <div class="card" @click="handleSetLineChartData('purchases')">
        <div class="card-panel-icon-wrapper icon-money">
          <my-icon icon-class="dengji" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">今日租赁申请</div>
          <count-to class="card-panel-num" :startVal="0" :endVal="9280" :duration="3200"></count-to>
        </div>
      </div>
    </el-col>
    <el-col :span="6" class="card-panel-col">
      <div class="card" @click="handleSetLineChartData('shoppings')">
        <div class="card-panel-icon-wrapper icon-shoppingCard">
          <my-icon icon-class="success" class-name="card-panel-icon" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">今日业务受理</div>
          <count-to class="card-panel-num" :startVal="0" :endVal="200" :duration="3600"></count-to>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script type="text/ecmascript-6">
import countTo from 'vue-count-to'
 export default {
   data() {
     return {

     }

   },
   components: {
countTo
   },
   methods: {
     handleSetLineChartData(){

     }
   }
 }
</script>

<style scoped lang="scss">
  .card {
    cursor: pointer;
    font-size: 12px;
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
        background: #34bfa3
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
      color: #34bfa3
    }
    .card-panel-icon-wrapper {
      float: left;
      margin: 10px 0 10px 14px;
      padding: 16px;
      transition: all 0.38s ease-out;
      border-radius: 6px;
    }
    .card-panel-icon {
      float: left;
      font-size: 48px;
    }
    .card-panel-description {
      float: right;
      font-weight: bold;
      margin: 26px;
      margin-left: 0px;
      .card-panel-text {
        line-height: 18px;
        color: rgba(0, 0, 0, 0.45);
        font-size: 16px;
        margin-bottom: 12px;
      }
      .card-panel-num {
        font-size: 20px;
      }
    }
  }
 
</style>
