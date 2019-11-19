<template>
  <div class="second-container">
    <!-- <staffIndex @emit-staff="getStaff"></staffIndex> -->
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>租赁管理</el-breadcrumb-item>
            <el-breadcrumb-item>租金生成</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar card">
            <el-row type="flex"
                    align="middle">
              <el-col :span="2"
                      :offset="2">
                <span>关键检索</span>
              </el-col>
              <el-col :span="4">
                <el-input v-model="directQuery"
                          placeholder="输入姓名或id检索"></el-input>
              </el-col>
              <el-col :span="2"
                      :offset="1">
                <el-button type="primary"
                           @click="directQueryMthod">查找</el-button>
              </el-col>
              <el-col :span="2">
                <!-- <transition name="fade"> -->
                <el-button type="primary"
                           v-if="activeName=='staff'"
                           @click="showDialog">条件检索</el-button>
                <!-- </transition> -->
              </el-col>
              <el-col :span="6"
                      :offset="1">
                <el-date-picker v-model="timeRange"
                                type="daterange"
                                align="right"
                                unlink-panels
                                range-separator="-"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期"
                                :picker-options="pickerOptions"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-col>
              <el-col :span="2"
                      :offset="1">
                <el-button type="success"
                           @click="rentalQuery">查询</el-button>
              </el-col>
              <el-col :span="2"
                      :offset="1">
                <export-popover v-if="activeName=='rental'"
                                :download-loading="downloadLoading"
                                @export="exportHandle"></export-popover>
              </el-col>
            </el-row>
          </div>
          <div class="main-data">
            <el-tabs v-model="activeName"
                     type="border-card"
                     style="margin:10px 10px 10px">
              <el-tab-pane name="staff">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon> 租赁员工
                </span>
                <keep-alive>
                  <div v-if="activeName=='staff'"
                       class="table-tabs">
                    <el-table :data="hireStaffData"
                              class="table"
                              style="width: 100%"
                              height="string"
                              @cell-click="handleClikHouse"
                              v-loading="listLoading"
                              @selection-change="setSelectionChange">
                      <el-table-column type="selection"></el-table-column>
                      <el-table-column prop="staffNo"
                                       fixed
                                       label="职工号"
                                       width="70"
                                       align="center"></el-table-column>
                      <el-table-column label="姓名"
                                       width="70"
                                       fixed
                                       align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover"
                                      placement="top">
                            <p>姓名: {{ scope.row.staffName }}</p>
                            <p>联系电话: {{ scope.row.tel }}</p>
                            <p>身份证号: {{ scope.row.code }}</p>
                            <p>参加工作时间: {{ scope.row.firstJobTime }}</p>
                            <p>上大学时间: {{ scope.row.goUniversityTime }}</p>
                            <p>离退休时间: {{ scope.row.retireTime }}</p>
                            <div slot="reference"
                                 class="name-wrapper">
                              <el-tag size="medium"
                                      type="info">{{ scope.row.staffName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="bookTime"
                                       label="入住时间"
                                       fixed
                                       width="100"
                                       align="center"></el-table-column>
                      <el-table-column prop="expireTime"
                                       label="到期时间"
                                       width="100"
                                       align="center"></el-table-column>
                      <el-table-column prop="joinTime"
                                       label="来校时间"
                                       width="100"
                                       align="center"></el-table-column>
                      <el-table-column prop="sex"
                                       label="性别"
                                       width="50"
                                       align="center"></el-table-column>
                      <el-table-column prop="marriageState"
                                       label="婚姻状况"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="postName"
                                       label="职称"
                                       align="center"></el-table-column>
                      <el-table-column prop="titleName"
                                       label="职务"
                                       align="center"></el-table-column>
                      <el-table-column prop="typeName"
                                       label="职工类别"
                                       width="120"
                                       align="center"></el-table-column>
                      <el-table-column prop="statusName"
                                       label="工作状态"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="deptName"
                                       label="工作部门"
                                       width="150"
                                       align="center"></el-table-column>
                      <el-table-column label="配偶姓名"
                                       width="80"
                                       align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover"
                                      placement="top">
                            <p>姓名: {{ scope.row.spouseName }}</p>
                            <p>单位: {{ scope.row.spouseDeptName }}</p>
                            <p>单位性质: {{ scope.row.spouseKindName }}</p>
                            <p>身份证号: {{ scope.row.spouseCode }}</p>
                            <div slot="reference"
                                 class="name-wrapper">
                              <el-tag size="medium">{{ scope.row.spouseName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="spousePostName"
                                       label="配偶职称"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="spousePostName"
                                       label="配偶职务"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseTypeName"
                                       label="住房类型"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseLayoutName"
                                       label="户型"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseStructName"
                                       label="结构"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseStatusName"
                                       label="使用状态"
                                       width="80"
                                       align="center"></el-table-column>
                      <el-table-column prop="houseNo"
                                       label="住房号"
                                       fixed="right"
                                       width="70"
                                       align="center"></el-table-column>>
                      <el-table-column label="地址"
                                       fixed="right"
                                       prop="houseAddress"
                                       width="260"
                                       class-name="address-cursor"
                                       align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover"
                                      placement="top">
                            <p>所属楼栋: {{ scope.row.buildingName }}</p>
                            <p>竣工时间: {{ scope.row.houseFinishTime }}</p>
                            <p>建筑面积: {{ scope.row.houseBulidArea }}</p>
                            <p>使用面积: {{ scope.row.houseUsedArea }}</p>
                            <p>占地面积: {{ scope.row.houseBasementArea }}</p>
                            <div slot="reference"
                                 class="name-wrapper">
                              <el-tag size="medium"
                                      @click="handleClikTagHouse(scope.row,scope.column)"
                                      type="success">{{ scope.row.houseAddress }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                    </el-table>
                    <el-pagination background
                                   layout="total, prev, pager, next, sizes, jumper"
                                   @size-change="sizeChangeEvent"
                                   @current-change="currentChangeEvent"
                                   :page-size="size"
                                   :page-sizes="[10,15,20,25,30]"
                                   :total="totalNum">
                    </el-pagination>
                    <!-- <div class="bottom-tool">
                      <el-button type="warning"
                                 size="small"
                                 @click="generateSelectRental">租金生成</el-button>
                    </div> -->
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="rental">
                <span slot="label">
                  <my-icon icon-class="basisData" />租金查询</span>
                <keep-alive>
                  <div v-if="activeName=='rental'"
                       class="table-tabs">
                    <el-table :data="rentalData"
                              class="table"
                              style="width: 100%"
                              height="string"
                              @cell-click="handleClikHouse"
                              v-loading="listLoading1">
                      <el-table-column type="index"
                                       label="序号"
                                       width="70"
                                       align="center"></el-table-column>
                      <el-table-column prop="staffNo"
                                       label="职工号"
                                       width="70"
                                       align="center"></el-table-column>
                      <el-table-column prop="staffName"
                                       label="姓名"
                                       width="70"
                                       align="center"></el-table-column>
                      <el-table-column prop="staffDeptName"
                                       label="工作部门"
                                       width="150"
                                       align="center"></el-table-column>
                      <el-table-column prop="address"
                                       label="住房地址"
                                       class-name="address-cursor"
                                       align="center"></el-table-column>
                      <el-table-column prop="payType"
                                       label="缴费方式"
                                       width="100"
                                       :formatter="payTypeColFormat"
                                       align="center"></el-table-column>
                      <el-table-column prop="rentInitMoney"
                                       label="租金"
                                       width="100"
                                       align="center"></el-table-column>
                    </el-table>
                    <el-pagination background
                                   layout="total, prev, pager, next, sizes, jumper"
                                   @size-change="sizeChangeEvent1"
                                   @current-change="currentChangeEvent1"
                                   :page-size="size"
                                   :page-sizes="[10,15,20,25,30]"
                                   :total="totalNum1">
                    </el-pagination>
                  </div>
                </keep-alive>
              </el-tab-pane>
            </el-tabs>
          </div>
        </div>
        <!-- 多条件查询窗口 -->
        <el-dialog title="条件检索"
                   class="multiply-diolog"
                   v-loading="dialogLoading"
                   :visible.sync="dialogVisible">
          <el-form :model="queryForm"
                   label-width="90px">
            <el-row>
              <el-col :span="8">
                <el-form-item label="工作部门">
                  <el-select v-model="queryForm.dept"
                             :clearable="true"
                             placeholder="所有部门">
                    <el-option v-for="v in deptData"
                               :key="v.staffParamId"
                               :value="v.staffParamName"
                               :label="v.staffParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="职务">
                  <el-select v-model="queryForm.post"
                             :clearable="true"
                             placeholder="所有职务">
                    <el-option v-for="v in postData"
                               :key="v.staffParamId"
                               :value="v.staffParamName"
                               :label="v.staffParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="职称">
                  <el-select v-model="queryForm.title"
                             :clearable="true"
                             placeholder="所有职称">
                    <el-option v-for="v in titleData"
                               :key="v.staffParamId"
                               :value="v.staffParamName"
                               :label="v.staffParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="职工类别">
                  <el-select v-model="queryForm.class"
                             :clearable="true"
                             placeholder="所有类别">
                    <el-option v-for="v in classData"
                               :key="v.staffParamId"
                               :value="v.staffParamName"
                               :label="v.staffParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="工作状态">
                  <el-select v-model="queryForm.status"
                             :clearable="true"
                             placeholder="所有状态">
                    <el-option v-for="v in statusData"
                               :key="v.staffParamId"
                               :value="v.staffParamName"
                               :label="v.staffParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="住房类型">
                  <el-select v-model="queryForm.houseTypeName"
                             :clearable="true"
                             placeholder="所有类型">
                    <el-option v-for="v in typeData"
                               :key="v.houseParamId"
                               :value="v.houseParamName"
                               :label="v.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="婚姻状况">
                  <el-select v-model="queryForm.marriageState"
                             :clearable="true"
                             placeholder="全部">
                    <el-option v-for="v in formOption.marriageState"
                               :key="v.value"
                               :value="v.value"
                               :label="v.label"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="性别">
                  <el-select v-model="queryForm.sex"
                             :clearable="true"
                             placeholder="全部">
                    <el-option v-for="v in formOption.sexOption"
                               :key="v.value"
                               :value="v.value"
                               :label="v.label"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="是否到期">
                  <el-select v-model="queryForm.isExpire"
                             :clearable="true"
                             placeholder="全部">
                    <el-option v-for="v in formOption.hireIsExpire"
                               :key="v.value"
                               :value="v.value"
                               :label="v.label"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10">
                <el-form-item label="工作时间">
                  <el-date-picker v-model="joinTime"
                                  type="daterange"
                                  align="right"
                                  unlink-panels
                                  range-separator="-"
                                  start-placeholder="开始日期"
                                  end-placeholder="结束日期"
                                  :picker-options="pickerOptions"
                                  value-format="yyyy-MM-dd">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10">
                <el-form-item label="上大学时间">
                  <el-date-picker v-model="goUniversityTimeRange"
                                  type="daterange"
                                  align="right"
                                  unlink-panels
                                  range-separator="-"
                                  start-placeholder="开始日期"
                                  end-placeholder="结束日期"
                                  :picker-options="pickerOptions"
                                  value-format="yyyy-MM-dd">
                  </el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="10">
                <el-form-item label="所属区域">
                  <el-select v-model="queryForm.regionName"
                             :clearable="true"
                             placeholder="全部">
                    <el-option v-for="v in regionData"
                               :key="v.id"
                               :value="v.name"
                               :label="v.name"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-button type="primary"
                           @click="multiplyQuery">查询</el-button>
              </el-col>
            </el-row>
          </el-form>
        </el-dialog>
      </div>
    </section>
    <house-detail-dialog :show.sync="showHouseDetailDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import exportPopover from "@/components/exportPopover";
import staffIndex from "@/views/fixManage/components/staffIndex";
import HouseDetailDialog from '@/components/OneHouseData'
import {
  getHouseParam,
  getStaffParam
} from "@/api/sysManage";
import {
  getRegionData
} from "@/api/basiceData";
import {
  postHireRenterMultiply,
  getHireRenter,
  postHireGenerateRental,
  postHireRentalQuery
} from "@/api/leaseManage";
import * as OPTION from "@/assets/data/formOption";
import * as staticData from "@/utils/static";
import utils from "@/utils/index.js";
import {
  parseTime
} from "@/utils/time.js";
export default {
  data () {
    return {
      downloadLoading: false,
      // Tabs需要的
      activeName: "staff",
      // 查询需要相关的
      directQuery: "",
      // isFillStaff: false,
      // 查询租金记录
      timeRange: [],
      // 多条件查找区
      dialogLoading: false,
      dialogVisible: false,
      queryForm: {},
      deptData: [],
      postData: [],
      titleData: [],
      classData: [],
      statusData: [],
      regionData: [],
      typeData: [],
      joinTime: [],
      goUniversityTimeRange: [],
      formOption: OPTION,
      setList: [],
      // 时间选择区域
      pickerOptions: {
        shortcuts: staticData.longSpanPickerOptions
      },
      // 员工表格
      hireStaffData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,
      // 租金生成表格
      rentalData: [],
      listLoading1: false,
      totalNum1: 0,
      page1: 1,
      size1: 10,
      // 是否显示住房详情的对话框 
      showHouseDetailDialog: false,
      houseId: 0,
    };
  },
  // watch: {
  //   hireStaffData(newVal) {
  //     if (newVal != []) {
  //       this.isFillStaff = true;
  //     }
  //   }
  // },
  components: {
    staffIndex,
    exportPopover,
    HouseDetailDialog
  },
  methods: {
    // 从组件获取id
    getStaff (object) {
      console.log(object);
    },
    //初始查询条件获取
    initalGet () {
      return new Promise((resolve, reject) => {
        if (this.deptData.length == 0) {
          this.dialogLoading = true;
          let param = {
            size: 999
          };
          let roleId = this.$store.getters.roleId
          //部门5
          getStaffParam(param, 5)
            .then(res => {
              this.deptData = res.data.data.data.list;
            })
            .catch(err => {
              console.log(err);
              reject(err);
            });
          // 职务为6
          getStaffParam(param, 6)
            .then(res => {
              this.postData = res.data.data.data.list;
            })
            .catch(err => {
              console.log(err);
              reject(err);
            });
          // 职称为7
          getStaffParam(param, 7)
            .then(res => {
              this.titleData = res.data.data.data.list;
            })
            .catch(err => {
              console.log(err);
              reject(err);
            });
          // 类别为8
          getStaffParam(param, 8)
            .then(res => {
              this.classData = res.data.data.data.list;
            })
            .catch(err => {
              console.log(err);
              reject(err);
            });
          // 状态为9
          getStaffParam(param, 9)
            .then(res => {
              this.statusData = res.data.data.data.list;
              this.listLoading = false;
            })
            .catch(err => {
              console.log(err);
              reject(err);
            });
          // 住房类型1
          getHouseParam(param, 1)
            .then(res => {
              this.typeData = res.data.data.data.list;
            })
            .catch(err => {
              console.log(err);
            });
          // 获取全部区域
          getRegionData(param, roleId)
            .then(res => {
              this.regionData = res.data.data.data.list;
              this.regionData.forEach(region => {
                let flag = region.name.indexOf("（");
                if (flag != -1) {
                  region.name = region.name.substring(0, flag);
                }
              });
              resolve();
            })
            .catch(err => {
              console.log(err);
            });
        } else {
          resolve();
        }
      });
    },
    // 处理导出情况
    exportHandle (exportType) {
      if (exportType == 1) this.handleDownload();
      else {
        let param = {
          page: 1,
          size: 9999
        };
        let data = {};
        if (this.timeRange.length != 0) {
          data = {
            startTime: this.timeRange[0],
            endTime: this.timeRange[1]
          };
        }
        postHireRentalQuery(param, data).then(res => {
          const values = res.data.data.data.list;
          this.handleDownload(values);
        });
      }
    },
    // 导出
    handleDownload (values) {
      let filename = "租金表统计";
      this.downloadLoading = true;
      import("@/vendor/Export2Excel").then(excel => {
        const tHeader = ["职工号", "姓名", "工作部门", '缴费方式', "租金"];
        const filterVal = [
          "staffNo",
          "staffName",
          "staffDeptName",
          "payType",
          "rentInitMoney"
        ];
        let list = [];
        if (arguments.length == 0) list = this.rentalData;
        else list = arguments[0];
        const data = this.formatJson(filterVal, list); // 用于自行洗数据
        let date = new Date();
        filename = filename + `(${parseTime(date, "{y}-{m}-{d}")})`;
        excel.export_json_to_excel(tHeader, data, filename);
        this.downloadLoading = false;
      });
    },
    // 缴租方式的代号替换：1：自缴。2：代扣
    payTypeFormat (id) {
      let value = ''
      let payTypes = [
        {
          id: 0,
          typeName: '无需'
        },
        {
          id: 1,
          typeName: '自缴'
        },
        {
          id: 2,
          typeName: '代扣'
        }
      ]
      payTypes.forEach(item => {
        if (item.id == id) {
          value = item.typeName
        }
      })
      return value
    },
    // 格式化缴费方式的内容
    payTypeColFormat (row, column, cellValue, index) {
      let value = ''
      let payTypes = [
        {
          id: 0,
          typeName: '无需'
        },
        {
          id: 1,
          typeName: '自缴'
        },
        {
          id: 2,
          typeName: '代扣'
        }
      ]
      payTypes.forEach(item => {
        if (item.id == cellValue) {
          value = item.typeName
        }
      })
      return value
    },
    formatJson (filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => {
          if (j === "timestamp") {
            return parseTime(v[j]);
          }
          if (j === "payType") {
            return this.payTypeFormat(v[j])
          }
          return v[j];
        })
      );
    },
    // 显示多条件查询时候
    showDialog () {
      this.dialogVisible = true;
      this.initalGet().then((this.dialogLoading = false));
    },
    // 直接查询的方法
    directQueryMthod () {
      this.listLoading = true;
      let params = {
        conditionValue: this.directQuery,
        page: 1,
        size: 10
      };
      getHireRenter(params).then(res => {
        utils.statusinfo(this, res.data);
        this.hireStaffData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
      });
    },
    // 多条件查询操作
    multiplyQuery () {
      this.dialogVisible = false;
      if (this.joinTime.length != 0) {
        this.queryForm.joinTime = {
          startTime: this.time[0],
          endTime: this.time[1]
        };
      }
      if (this.goUniversityTimeRange.length != 0) {
        this.queryForm.goUniversityTimeRange = {
          startTime: this.time[0],
          endTime: this.time[1]
        };
      }
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") delete this.queryForm[v];
      }
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      const data = Object.assign({}, this.queryForm);
      postHireRenterMultiply(param, data).then(res => {
        utils.statusinfo(this, res.data);
        this.hireStaffData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
        this.listLoading = false;
        this.listLoading1 = false;
      });
    },
    // 监听多选生成租金
    setSelectionChange (selection) {
      this.setList = [];
      selection.forEach(v => {
        this.setList.push(v.houseNo);
      });
    },
    // // 生成租金
    // generateSelectRental () {
    //   //console.log(this.setList)
    //   this.listLoading = true;
    //   const data = this.setList;
    //   let params = {};
    //   postHireGenerateRental(params, data).then(res => {
    //     utils.statusinfo(this, res.data);
    //     this.listLoading = false;
    //   });
    // },
    // 时间段已经生成租金查询
    rentalQuery () {
      let data = {};
      if (this.timeRange.length != 0) {
        data = {
          startTime: this.timeRange[0],
          endTime: this.timeRange[1]
        };
      }
      this.listLoading1 = true;
      let params = {
        size: this.size1,
        page: this.page1
      };
      postHireRentalQuery(params, data).then(res => {
        utils.statusinfo(this, res.data);
        this.rentalData = res.data.data.data.list;
        this.totalNum1 = res.data.data.data.total;
        this.listLoading1 = false;
      });
    },
    //更换每页数量
    sizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.multiplyQuery();
    },
    //页码切换时
    currentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.multiplyQuery();
    },
    //更换每页数量
    sizeChangeEvent1 (val) {
      this.listLoading1 = true;
      this.size1 = val;
      this.rentalQuery();
    },
    //页码切换时
    currentChangeEvent1 (val) {
      this.listLoading1 = true;
      this.page1 = val;
      this.rentalQuery();
    },
    // 点击地址弹开对话框
    handleClikHouse (row, column, cell, event) {
      if (column.property === "address") {
        this.showHouseDetailDialog = true
        this.houseId = row.houseId
      }
    },
    handleClikTagHouse (row, column) {
      if (column.property === "houseAddress") {
        this.showHouseDetailDialog = true
        this.houseId = row.houseId
      }

    }
  }
};

</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  .toolbar {
    padding: 15px;
  }
  .table-tabs {
    height: 57vh;
    padding-bottom: 40px;
    position: relative;
    & > .bottom-tool {
      position: absolute;
      bottom: 5px;
      left: 15px;
    }
  } // .staff-table {
  //   height: 28vh;
  //   padding-bottom: 40px;
  //   position: relative;
  //   &>.bottom-tool {
  //     position: absolute;
  //     bottom: 5px;
  //     left: 15px;
  //   }
  // }
  // .rental-table {
  //   height: 28vh;
  //   padding-bottom: 35px;
  // }
  .multiply-diolog {
    .el-form-item {
      margin-bottom: 5px;
    }
  }
}
</style>
