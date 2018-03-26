<template>
  <div class="special-container">
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
            <el-breadcrumb-item>选房资格认定</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <el-form :model="queryForm" label-width="100px">
              <div class="card">
                <el-row>
                  <el-col :span="4">
                    <el-form-item label="部门">
                      <el-select v-model="queryForm.dept" size="small" :clearable="true" placeholder="所有部门">
                        <el-option v-for="v in deptData" :key="v.staffParamId" :value="v.staffParamName" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="职务">
                      <el-select v-model="queryForm.post" size="small" :clearable="true" placeholder="所有职务">
                        <el-option v-for="v in postData" :key="v.staffParamId" :value="v.staffParamName" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="职称">
                      <el-select v-model="queryForm.title" size="small" :clearable="true" placeholder="所有职称">
                        <el-option v-for="v in titleData" :key="v.staffParamId" :value="v.staffParamName" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="类别">
                      <el-select v-model="queryForm.class" size="small" :clearable="true" placeholder="所有类别">
                        <el-option v-for="v in classData" :key="v.staffParamId" :value="v.staffParamName" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="状态">
                      <el-select v-model="queryForm.status" size="small" :clearable="true" placeholder="所有状态">
                        <el-option v-for="v in statusData" :key="v.staffParamId" :value="v.staffParamName" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="4">
                    <el-form-item label="婚姻">
                      <el-select v-model="queryForm.marriageState" size="small" :clearable="true" placeholder="全部">
                        <el-option v-for="v in formOption.marriageState" :key="v.value" :value="v.value" :label="v.label"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="性别">
                      <el-select v-model="queryForm.sex" size="small" :clearable="true" placeholder="全部">
                        <el-option v-for="v in formOption.sexOption" :key="v.value" :value="v.value" :label="v.label"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="工作时间">
                      <el-date-picker v-model="time" size="small" type="daterange" align="right" unlink-panels range-separator="至" start-placeholder="开始日期"
                        end-placeholder="结束日期" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="直接查询">
                      <el-input v-model="queryForm.query" size="small" placeholder="请输入搜索"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="3" :offset="1">
                    <el-button type="danger" size="small" @click="resseting">重置</el-button>
                    <el-button type="primary" size="small" @click="muticonditionQuery">查询</el-button>
                  </el-col>
                </el-row>
              </div>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-tabs v-model="activeName" type="border-card" style="margin:10px 10px 10px">
              <el-tab-pane name="canSelect">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon>待选员工</span>
                <keep-alive>
                  <!-- 未设置选房的表格 -->
                  <div v-if="activeName=='canSelect'" class="table-tabs">
                    <el-table :data="canSelectData" class="table" height="string" v-loading="listLoading" @selection-change="setSelectionChange">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                      <el-table-column label="姓名" sortable align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.staffName }}</p>
                            <p>来校工作时间: {{ scope.row.joinTime }}</p>
                            <p>预计退休时间: {{ scope.row.retireTime }}</p>
                            <div slot="reference" class="name-wrapper">
                              <el-tag size="medium" type="info">{{ scope.row.staffName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                      <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                      <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                      <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                      <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
                      <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                      <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                      <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
                      :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
                    </el-pagination>
                    <div class="bottom-tool">
                      <el-button type="primary" size="small" @click="setSelect">设为可选</el-button>
                    </div>
                  </div>
                </keep-alive>
              </el-tab-pane>
              <el-tab-pane name="haveSleect">
                <span slot="label">
                  <my-icon icon-class="users"></my-icon>可选员工</span>
                <keep-alive>
                  <!-- 已设置选房的表格 -->
                  <div v-if="activeName=='haveSleect'" class="table-tabs">
                    <el-table :data="haveSelectData" class="table" height="string" v-loading="listLoading1" @selection-change="cancelSelectionChange">
                      <el-table-column type="selection" width="55"></el-table-column>
                      <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                      <el-table-column label="姓名" sortable align="center">
                        <template slot-scope="scope">
                          <el-popover trigger="hover" placement="top">
                            <p>姓名: {{ scope.row.staffName }}</p>
                            <p>来校工作时间: {{ scope.row.joinTime }}</p>
                            <p>离退休时间: {{ scope.row.retireTime }}</p>
                            <div slot="reference" class="name-wrapper">
                              <el-tag size="medium" type="info">{{ scope.row.staffName }}</el-tag>
                            </div>
                          </el-popover>
                        </template>
                      </el-table-column>
                      <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                      <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                      <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                      <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                      <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
                      <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                      <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                      <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
                    </el-table>
                    <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent1" @current-change="currentChangeEvent1"
                      :page-size="size1" :page-sizes="[10,15,20,25,30]" :total="totalNum1">
                    </el-pagination>
                    <div class="bottom-tool">
                      <el-button type="warning" size="small" @click="cancelSelect">撤销可选</el-button>
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
  import {
    getCanSelectStaff,
    getHaveSelectStaff,
    postCanSelectmulticondition,
    postSetCanSelect,
    postcancelCanSelect,
  } from "@/api/online";
  import {
    getStaffParam
  } from "@/api/sysManage";
  import * as OPTION from "@/assets/data/formOption";
  import utils from "@/utils/index.js";
  import * as staticData from "@/utils/static";
  export default {
    data() {
      return {
        activeName: 'canSelect',
        // 多重查找表单
        queryForm: {},
        time: [],
        deptData: [],
        postData: [],
        titleData: [],
        classData: [],
        statusData: [],
        formOption: OPTION,
        // 时间选择区域
        pickerOptions: {
          shortcuts: staticData.longSpanPickerOptions
        },
        // 表格区域
        listLoading: false,
        listLoading1: false,
        canSelectData: [],
        setList: [],
        haveSelectData: [],
        cancelList: [],
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
      this.initalGet();
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
        //部门5
        getStaffParam(param, 5)
          .then(res => {
            this.deptData = res.data.data.data.list;
          })
          .catch(err => {
            console.log(err);
          });
        // 职务为6
        getStaffParam(param, 6)
          .then(res => {
            this.postData = res.data.data.data.list;
          })
          .catch(err => {
            console.log(err);
          });
        // 职称为7
        getStaffParam(param, 7)
          .then(res => {
            this.titleData = res.data.data.data.list;
          })
          .catch(err => {
            console.log(err);
          });
        // 类别为8
        getStaffParam(param, 8)
          .then(res => {
            this.classData = res.data.data.data.list;
          })
          .catch(err => {
            console.log(err);
          });
        // 状态为9
        getStaffParam(param, 9)
          .then(res => {
            this.statusData = res.data.data.data.list;
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
        getCanSelectStaff(param)
          .then(res => {
            // console.log(res.data.data)
            this.canSelectData = res.data.data.data.list;
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
        getHaveSelectStaff(param)
          .then(res => {
            // console.log(res.data.data)
            this.haveSelectData = res.data.data.data.list;
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
        this.canSelectData = [];
        if (this.time.length != 0) {
          this.queryForm.joinTime = {
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
        //console.log(this.queryForm)
        if (this.queryForm.hasOwnProperty('query')) {

        } else {
          const data = Object.assign({}, this.queryForm);
          postCanSelectmulticondition(param, data).then(res => {
            utils.statusinfo(this, res.data);
            this.canSelectData = res.data.data.data.list;
            this.totalNum = res.data.data.data.total;
            this.listLoading = false;
          });
        }
      },
      // 为设置选房表格的多选
      setSelectionChange(selection) {
        this.setList = [];
        selection.forEach(v => {
          this.setList.push(v.staffNo);
        });
      },
      // 设为可选房
      setSelect() {
        this.listLoading = true;
        const data = this.setList;
        postSetCanSelect(data).then(res => {
          utils.statusinfo(this, res.data);
          this.getList();
          this.getList1();
        });
      },
      // 监听已设置选房多选
      cancelSelectionChange(selection) {
        this.cancelList = [];
        selection.forEach(v => {
          this.cancelList.push(v.staffNo);
        });
      },
      // 取消可选房
      cancelSelect() {
        //console.log(this.cancelList)
        this.listLoading = true;
        const data = this.cancelList;
        postcancelCanSelect(data).then(res => {
          utils.statusinfo(this, res.data);
          this.getList();
          this.getList1();
        });
      },
      // 重置查询表单
      resseting() {
        this.time = []
        this.queryForm = {}
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

  .special-container {
    background-color: $background-grey;
    .toolbar {
      .el-form-item {
        margin-bottom: 0;
      }
      .card {
        padding: 10px;
      }
    }
    .table-tabs {
      height: 57vh;
      padding-bottom: 40px;
      position: relative;
      &>.bottom-tool {
        position: absolute;
        bottom: 5px;
        left: 15px;
      }
    }
  }

</style>
