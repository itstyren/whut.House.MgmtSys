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
          <div class="toolbal">
            <el-form :model="queryForm" label-width="80px">
              <div class="card">
                <el-row>
                  <el-col :span="4">
                    <el-form-item label="住房类型">
                      <el-select v-model="queryForm.houseType" size="small" :clearable="true" placeholder="所有类型">
                        <el-option v-for="v in typeData" :key="v.houseParamId" :value="v.houseParamName" :label="v.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="使用状态">
                      <el-select v-model="queryForm.useStatus" size="small" :clearable="true" placeholder="所有状态">
                        <el-option v-for="v in statusData" :key="v.houseParamId" :value="v.houseParamName" :label="v.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="住房结构">
                      <el-select v-model="queryForm.structName" size="small" :clearable="true" placeholder="所有结构">
                        <el-option v-for="v in structData" :key="v.houseParamId" :value="v.houseParamName" :label="v.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="住房户型">
                      <el-select v-model="queryForm.layoutName" size="small" :clearable="true" placeholder="所有户型">
                        <el-option v-for="v in layoutData" :key="v.houseParamId" :value="v.houseParamName" :label="v.houseParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="租金">
                      <el-row>
                        <el-col :span="8">
                          <el-input v-model="queryForm.rentalScope.minRental" size="small" placeholder=""></el-input>
                        </el-col>
                        <el-col :span="4" style=" text-align: center;">
                          <span>至</span>
                        </el-col>
                        <el-col :span="8">
                          <el-input v-model="queryForm.rentalScope.maxRental" size="small" placeholder=""></el-input>
                        </el-col>
                      </el-row>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="5">
                    <el-form-item label="住房区域">
                      <el-select v-model="queryForm.houseZone" :clearable="true" @clear="clearRegion" placeholder="全部区域" @change="selectRegionChange">
                        <el-option v-for="region in regionBuildingData" :key="region.id" :value="region.id" :label="region.name"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="住房楼栋">
                      <el-select v-model="queryForm.building" :clearable="true" placeholder="全部房屋">
                        <el-option v-for="building in buildingData" :key="building.id" :value="building.id" :label="building.name"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label=" ">
                      <el-button type="danger" size="small" @click="resseting">重置</el-button>
                      <el-button type="primary" size="small" @click="muticonditionQuery">查询</el-button>
                    </el-form-item>
                  </el-col>
                </el-row>
              </div>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <!-- 未设置选房的表格 -->
            <div class="card can-select">
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
            <!-- 已设置选房的表格 -->
            <div class="card can-select">
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
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getRegionWithBuildings,
  getActiveHouse,
  getSetHouse,
  postActiveHousemulticondition,
  postSetHouse,
  postcancelHouse
} from "@/api/api";
import {getHouseParam} from '@/api/sysMange'
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      // 多重查找表单
      queryForm: {
        rentalScope: {}
      },
      time: [],
      typeData: [],
      layoutData: [],
      statusData: [],
      structData: [],
      regionBuildingData: [],
      buildingData: [],
      // 表格区域
      listLoading: false,
      listLoading1: false,
      activeHouseData: [],
      setList: [],
      setHouseData: [],
      cancelList: [],
      totalNum: 1,
      page: 1,
      size: 10,
      totalNum1: 1,
      page1: 1,
      size1: 10
    };
  },
  computed: {
    selectRegion() {
      return this.queryForm.regionId;
    }
  },
  watch: {
    // 监听选项的变动
    selectRegion(newval) {
      for (var region of this.regionBuildingData) {
        if (region.id == newval) this.buildingData = region.buildingList;
      }
    }
  },
  created() {
    this.initalGet();
    this.getRegionWithBuilding();
    this.getList();
    this.getList1();
  },
  methods: {
    //初始查询条件获取
    initalGet() {
      this.listLoading = true;
      let param = {
        size: 999
      };
      // 类型为1
      getHouseParam(param, 1)
        .then(res => {
          this.typeData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 户型为2
      getHouseParam(param, 2)
        .then(res => {
          this.layoutData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 状态为3
      getHouseParam(param, 3)
        .then(res => {
          this.statusData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 结构为8
      getHouseParam(param, 4)
        .then(res => {
          this.structData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 获取区域信息包括楼栋
    getRegionWithBuilding() {
      this.listLoading = true;
      let param = {
        // page: this.page,
        // size: this.size
      };
      getRegionWithBuildings(param)
        .then(res => {
          this.regionBuildingData = res.data.data.data;
          this.regionBuildingData.forEach(region => {
            let flag = region.name.indexOf("（");
            if (flag != -1) {
              region.name = region.name.substring(0, flag);
            }
          });
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 初始获取数据
    getList() {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      getActiveHouse(param)
        .then(res => {
          console.log(res.data.data);
          this.activeHouseData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 初始获取已设置可选房数据
    getList1() {
      this.listLoading1 = true;
      let param = {
        page: this.page1,
        size: this.size1
      };
      getSetHouse(param)
        .then(res => {
          // console.log(res.data.data)
          this.setHouseData = res.data.data.data.list;
          this.totalNum1 = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading1 = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 多重查找查询
    muticonditionQuery() {
      this.activeHouseData = [];
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") delete this.queryForm[v];
      }
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      console.log(this.queryForm);
      const data = Object.assign({}, this.queryForm);
      postActiveHousemulticondition(param, data).then(res => {
        utils.statusinfo(this, res.data);
        this.activeHouseData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      });
    },
    // 监听带设置房源多选
    setSelectionChange(selection) {
      this.setList = [];
      selection.forEach(v => {
        this.setList.push(v.no);
      });
    },
    // 设为房源
    setSelect() {
      this.listLoading = true;
      const data = this.setList;
      postSetHouse(data).then(res => {
        utils.statusinfo(this, res.data);
        this.getList();
        this.getList1();
      });
    },
    // 监听已经是房源多选
    cancelSelectionChange(selection) {
      this.cancelList = [];
      selection.forEach(v => {
        this.cancelList.push(v.no);
      });
    },
    // 取消可选房
    cancelSelect() {
      //console.log(this.cancelList);
      this.listLoading = true;
      const data = this.cancelList;
      postcancelHouse(data).then(res => {
        utils.statusinfo(this, res.data);
        this.getList();
        this.getList1();
      });
    },
    // 重置查询表单
    resseting() {
      this.time = [];
      this.queryForm = {};
    },
    // 清空搜索的区域时
    clearRegion() {
      this.queryForm.buildingId = "";
    },
    //选择的区域变化时
    selectRegionChange(region) {
      this.buildingData = region.buildingList;
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    },
    //更换每页数量1
    sizeChangeEvent1(val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.getList1();
    },
    //页码切换时1
    currentChangeEvent1(val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.getList1();
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  .toolbal {
    .el-form-item {
      margin-bottom: 0;
    }
    .card {
      padding: 10px;
    }
  }
  .can-select {
    height: 25vh;
    padding-bottom: 6vh;
    position: relative;
    & > .bottom-tool {
      position: absolute;
      bottom: 5px;
      left: 10px;
    }
  }
}
</style>
