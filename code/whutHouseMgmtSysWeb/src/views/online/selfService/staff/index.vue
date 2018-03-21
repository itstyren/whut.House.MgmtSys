<template>
  <div class="container">
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
    getSetHouse
  } from "@/api/online";
  export default {
    data() {
      return {
        ableHouseData: [],
        listLoading: false,
        totalNum: 1,
        page: 1,
        size: 10
      };
    },
    created() {
      this.getAbleHoueList();
    },
    methods: {
      // 获取可选房源
      getAbleHoueList() {
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
    height: 80vh;
    padding: 20px;
    width: 100%；;
    padding-bottom: 60px;
    .title {
      font-size: 18px;
      font-weight: 600;
    }
  }

</style>
