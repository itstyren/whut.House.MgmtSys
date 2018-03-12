<template>
  <div class="second-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>网上选房</el-breadcrumb-item>
            <el-breadcrumb-item>自助选房</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card waiting-staff">
              <div class="title">
                <span>等待选房员工</span>
              </div>
              <el-table :data="waitingStaffData" class="table" height="string" v-loading="listLoading">
                <el-table-column prop="staffName" label="职工姓名" align="center"></el-table-column>
                <el-table-column prop="staffNo" label="职工号" align="center"></el-table-column>
                <el-table-column prop="staffPostName" label="职称" align="center"></el-table-column>
                <el-table-column prop="staffTitleName" label="职务" align="center"></el-table-column>
                <el-table-column prop="staffTypeName" label="职工类别" align="center"></el-table-column>
                <el-table-column prop="staffStatusName" label="工作状态" align="center"></el-table-column>
                <el-table-column prop="staffDeptName" label="工作部门" align="center"></el-table-column>
                <el-table-column label="职工总分" align="center" width="80">
                  <template slot-scope="scope">
                    <el-popover trigger="hover" placement="top">
                      <p>职务分: {{ scope.row.staffTitleVal }}</p>
                      <p>职称分 : {{ scope.row.staffPostVal }}</p>
                      <p>配偶职务分 : {{ scope.row.staffSpouseTitleVal }}</p>
                      <p>配偶职称分 : {{ scope.row.staffSpousePostVal }}</p>
                      <p>工龄分 : {{ scope.row.staffTimeVal }}</p>
                      <p>其他分 : {{ scope.row.staffOtherVal }}</p>
                      <div slot="reference" class="totle-wrapper">
                        <el-tag size="medium" type="info">{{ scope.row.staffTotalVal }}</el-tag>
                      </div>
                    </el-popover>
                  </template>
                </el-table-column>
                <el-table-column prop="houseSelectStart" label="选房开始时间" align="center"></el-table-column>
                <el-table-column prop="houseSelectEnd" label="选房结束时间" align="center"></el-table-column>
              </el-table>
              <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
                :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
              </el-pagination>
            </div>
            <div class="card able-house">
              <div class="title">
                <span>可申请房源</span>
              </div>
              <el-table :data="ableHouseData" class="table" height="string" v-loading="listLoading1">
                <el-table-column prop="no" label="住房号" align="center"></el-table-column>
                <el-table-column prop="layout" label="户型" align="center"></el-table-column>
                <el-table-column prop="usedArea" label="建筑面积" align="center"></el-table-column>
                <el-table-column prop="usedArea" label="使用面积" align="center"></el-table-column>
                <el-table-column prop="regionName" label="所属区域" align="center"></el-table-column>
                <el-table-column prop="buildingName" label="所属楼栋" align="center"></el-table-column>
                <el-table-column prop="address" label="地址" align="center"></el-table-column>
                <el-table-column prop="rental" label="租金" align="center"></el-table-column>
              </el-table>
              <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent1" @current-change="currentChangeEvent1"
                :page-size="size1" :page-sizes="[10,15,20,25,30]" :total="totalNum1">
              </el-pagination>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getSubmitSelectHouseApply,
  getAllCanselectHouseStaff,
  getSetHouse
} from "@/api/online";
export default {
  data() {
    return {
      // 表格数据
      listLoading: false,
      listLoading1: false,
      waitingStaffData: [],
      ableHouseData: [],
      totalNum: 1,
      page: 1,
      size: 10,
      totalNum1: 1,
      page1: 1,
      size1: 10
    };
  },
  components: {},
  created() {
    this.getWaitingStaffList();
    this.getAbleHoueList();
  },
  methods: {
    // 获取等待选房员工
    getWaitingStaffList() {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      getAllCanselectHouseStaff(param)
        .then(res => {
          this.waitingStaffData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 获取可选房源
    getAbleHoueList() {
      this.listLoading1 = true;
      let param = {
        page: this.page1,
        size: this.size1
      };
      getSetHouse(param).then(res => {
        this.ableHouseData = res.data.data.data.list;
        this.totalNum1 = res.data.data.data.total;
        this.listLoading1 = false;
      });
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getWaitingStaffList();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getWaitingStaffList();
    },
    //更换每页数量1
    sizeChangeEvent1(val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.getAbleHoueList();
    },
    //页码切换时1
    currentChangeEvent1(val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.getAbleHoueList();
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  & .waiting-staff {
    height: 25vh;
    text-align: center;
    position: relative;
    padding-top: 25px;
    padding-bottom: 6vh;
    & > .title {
      position: absolute;
      top: 5px;
      width: 100%;
      & > span {
        font-weight: 800;
        font-size: 16px;
      }
    }
  }
  & .able-house {
    height: 25vh;
    text-align: center;
    position: relative;
    padding-top: 25px;
    padding-bottom: 6vh;
    & > .title {
      position: absolute;
      top: 5px;
      width: 100%;
      & > span {
        font-weight: 800;
        font-size: 16px;
      }
    }
  }
}
</style>
