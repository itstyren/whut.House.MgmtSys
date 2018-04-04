<template>
  <div class="container">
    <el-row class="select-info" v-if="isSelecting">
      <el-col :span="3" :offset="1" v-if="!isOwn">
        <span>当前选房： 【{{selectInfo.isSelectingStaffName}}】</span>
      </el-col>
            <el-col :span="3" :offset="1" v-else>
        <span>您正在选房</span>
      </el-col>
      <el-col :span="4">
        <div>
          <count-down :startTime="selectInfo.systemNowTime" :endTime="selectInfo.isSelectingStaffEndTime" :tipText="'距离开始文字1'" :tipTextEnd="'本轮剩余'" :endText="'已结束'" :dayTxt="'天'"
            :hourTxt="'小时'" :minutesTxt="'分钟'" :secondsTxt="'秒'"></count-down>
        </div>
      </el-col>
      <el-col :span="3">
        <span>下一选房员工 【{{selectInfo.nextSelectingStaffName}}】</span>
      </el-col>
      <el-col :span="6" :offset="1" v-if="!isOwn">
        <span>您的选房开始于【{{selectInfo.staffStartTimeNow}}】</span>
      </el-col>
      <el-col :span="3" v-if="!isOwn">
        <span>期间有【{{selectInfo.selectTime}}】分钟可选房</span>
      </el-col>
    </el-row>
    <el-row v-else>
      <el-col class="select-info" :span="10" :offset="1">
        <span>{{selectInfo}}</span>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div class="card house-list">
          <el-row type="flex" justify="center">
            <el-col :span="2" class="title">
              <span>可申请房源</span>
            </el-col>
          </el-row>
          <el-table :data="ableHouseData" class="table" height="string" v-loading="listLoading">
            <el-table-column prop="no" label="住房号" align="center"></el-table-column>
            <el-table-column prop="layout" label="户型" align="center"></el-table-column>
            <el-table-column prop="usedArea" label="建筑面积" align="center"></el-table-column>
            <el-table-column prop="usedArea" label="使用面积" align="center"></el-table-column>
            <el-table-column prop="regionName" label="所属区域" align="center"></el-table-column>
            <el-table-column prop="buildingName" label="所属楼栋" align="center"></el-table-column>
            <el-table-column prop="address" label="地址" align="center"></el-table-column>
            <el-table-column prop="rental" label="租金" align="center"></el-table-column>
            <el-table-column label="操作" width="200" align="center">
              <template slot-scope="scope">
                <el-button size="small">查看</el-button>
                <el-button type="primary" size="small" @click="apply(scope.$index,scope.row)">申请</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
            :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
          </el-pagination>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getSubmitSelectHouseApply,
  getSetHouse,
  getSelectInfoByName
} from "@/api/online";
import CountDown from "@/components/CountDownText";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      staffID: this.$store.getters.userID,
      isSelecting:false,
      ableHouseData: [],
      listLoading: false,
      isOwn:false,
      totalNum: 0,
      page: 1,
      size: 10,
      selectInfo: {}
    };
  },
  created() {
    this.getAbleHoueList();
    this.getSelectInfo();
  },
  components: {
    CountDown
  },
  methods: {
    // 获取可选房源
    getAbleHoueList() {
      this.ableHouseData = [];
      this.listLoading = true;
      let param = {
        page: this.page1,
        size: this.size1
      };
      getSetHouse(param).then(res => {
        this.ableHouseData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      });
    },
    getSelectInfo() {
      getSelectInfoByName(this.staffID).then(res => {
        if(res.data.data.data!=undefined)
        {
          this.selectInfo = res.data.data.data;
        this.isSelecting=true
        if(this.selectInfo.staffStartTimeNow==null){
          this.isOwn=true
        }}
        else{
          this.selectInfo=res.data.message
          this.isSelecting=false
        }
        //var endTime=new Date(this.selectInfo.isSelectingStaffEndTime)
        //this.selectInfo.isSelectingStaffEndTime=endTime.getTime()
      });
    },
    apply(index, row) {
      //console.log(row);
      this.listLoading = true;
      let params = {
        staffId: this.staffID,
        houseId: row.no
      };
      getSubmitSelectHouseApply(params).then(res => {
        utils.statusinfo(this, res.data);
        this.listLoading = false;
        this.getAbleHoueList();
      });
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getAbleHoueList();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getAbleHoueList();
    }
  }
};
</script>

<style scoped lang="scss">
.house-list {
  height: 79vh;
  padding: 20px;
  width: 100%；;
  padding-bottom: 60px;
  .title {
    font-size: 18px;
    font-weight: 600;
  }
}

.select-info {
  span {
    font-size: 16px;
    font-weight: 800;
  }
}
</style>
