<template>
  <div class="second-container">
    <!-- 这里放置index -->
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>自助选房</el-breadcrumb-item>
            <el-breadcrumb-item>房源设置</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <house-filter @query-house="queryHandle"></house-filter>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-tabs v-model="activeName" type="border-card" style="margin:10px 10px 10px">
              <el-tab-pane name="canSelect">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 可选房源</span>
                <keep-alive>
                  <!-- 未设置选房的表格 -->
                  <div v-if="activeName=='canSelect'" class="table-tabs">
                    <el-table :data="activeHouseData" class="table" height="string" v-loading="listLoading" @selection-change="setSelectionChange">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="no" label="住房号" sortable width="95" align="center"></el-table-column>
                      <el-table-column prop="layout" label="户型" sortable width="100" align="center"></el-table-column>
                      <el-table-column prop="usedArea" label="使用面积" width="100" sortable align="center"></el-table-column>
                      <el-table-column prop="regionName" label="所属区域" sortable align="center"></el-table-column>
                      <el-table-column prop="buildingName" label="所属楼栋" align="center"></el-table-column>
                      <el-table-column prop="address" label="地址" align="center"></el-table-column>
                      <!-- <el-table-column prop="titleName" label="竣工时间" align="center"></el-table-column> -->
                      <el-table-column prop="rental" label="租金" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
                      :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
                    </el-pagination>
                    <div class="bottom-tool">
                      <el-button type="primary" size="small" @click="setSelect">设为房源</el-button>
                    </div>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <!-- 已设置选房的表格 -->
              <el-tab-pane name="haveSelevt">
                <span slot="label">
                  <my-icon icon-class="basisData" />已设置房源</span>
                <keep-alive>
                  <div v-if="activeName=='haveSelevt'" class="table-tabs">
                    <el-table :data="setHouseData" class="table" height="string" v-loading="listLoading1" @selection-change="cancelSelectionChange">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="no" label="住房号" sortable width="95" align="center"></el-table-column>
                      <el-table-column prop="layout" label="户型" sortable width="100" align="center"></el-table-column>
                      <el-table-column prop="usedArea" label="使用面积" width="100" sortable align="center"></el-table-column>
                      <el-table-column prop="regionName" label="所属区域" sortable align="center"></el-table-column>
                      <el-table-column prop="buildingName" label="所属楼栋" align="center"></el-table-column>
                      <el-table-column prop="address" label="地址" align="center"></el-table-column>
                      <!-- <el-table-column prop="titleName" label="竣工时间" align="center"></el-table-column> -->
                      <el-table-column prop="rental" label="租金" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent1" @current-change="currentChangeEvent1"
                      :page-size="size1" :page-sizes="[10,15,20,25,30]" :total="totalNum1">
                    </el-pagination>
                    <div class="bottom-tool">
                      <el-button type="warning" size="small" @click="cancelSelect">撤销房源</el-button>
                    </div>
                  </div>
                </keep-alive>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import houseFilter from "@/views/tools/houseFilter";
import {
  postActiveHousemulticondition,
  postSetHousemulticondition,
  postSetHouse,
  postcancelHouse
} from "@/api/online";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      activeName: "canSelect",
      // 表格区域
      listLoading: false,
      listLoading1: false,
      activeHouseData: [],
      setList: [],
      setHouseData: [],
      cancelList: [],
      totalNum: 0,
      page: 1,
      size: 10,
      totalNum1: 0,
      page1: 1,
      size1: 10,
      queryData:{}
    };
  },
  components: {
    houseFilter
  },
  created() {
    this.multiplyPostActiveHouse();
    this.multiplyPostSetHouse();
  },
  methods: {
    queryHandle(data) {
      this.queryData=data
      this.activeHouseData = [];
      this.setHouseData = [];
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      postActiveHousemulticondition(param, data).then(res => {
        utils.statusinfo(this, res.data);
        this.activeHouseData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        postSetHousemulticondition(param, data).then(res => {
          this.setHouseData = res.data.data.data.list;
          this.totalNum1 = res.data.data.data.total;
          this.listLoading = false;
        });
      });
    },
    multiplyPostActiveHouse() {
      this.activeHouseData = [];
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      postActiveHousemulticondition(param, this.queryData).then(res => {
        utils.statusinfo(this, res.data);
        this.activeHouseData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading=false
      });
    },
    multiplyPostSetHouse() {
      this.setHouseData = [];
      this.listLoading1 = true;
      let param = {
        page: this.page,
        size: this.size
      };
      postSetHousemulticondition(param, this.queryData).then(res => {
        utils.statusinfo(this, res.data);
        this.setHouseData = res.data.data.data.list;
        this.totalNum1 = res.data.data.data.total;
        this.listLoading1=false
      });
    },
    // 监听带设置房源多选
    setSelectionChange(selection) {
      this.setList = [];
      selection.forEach(v => {
        this.setList.push(v.id);
      });
    },
    // 设为房源
    setSelect() {
      this.listLoading = true;
      const data = this.setList;
      postSetHouse(data).then(res => {
        utils.statusinfo(this, res.data);
        this.multiplyPostActiveHouse();
        this.multiplyPostSetHouse();
      });
    },
    // 监听已经是房源多选
    cancelSelectionChange(selection) {
      this.cancelList = [];
      selection.forEach(v => {
        this.cancelList.push(v.id);
      });
    },
    // 取消可选房
    cancelSelect() {
      //console.log(this.cancelList);
      this.listLoading = true;
      const data = this.cancelList;
      postcancelHouse(data).then(res => {
        utils.statusinfo(this, res.data);
        this.multiplyPostActiveHouse();
        this.multiplyPostSetHouse();
      });
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.multiplyPostActiveHouse();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.multiplyPostActiveHouse();
    },
    //更换每页数量1
    sizeChangeEvent1(val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.multiplyPostSetHouse();
    },
    //页码切换时1
    currentChangeEvent1(val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.multiplyPostSetHouse();
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;

  .table-tabs {
    height: 52vh;
    padding-bottom: 40px;
    position: relative;
    & > .bottom-tool {
      position: absolute;
      bottom: 5px;
      left: 15px;
    }
  }
}
</style>
