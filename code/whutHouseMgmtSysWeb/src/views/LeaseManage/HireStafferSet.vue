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
            <el-breadcrumb-item>选房资格认定</el-breadcrumb-item>
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
                    <el-form-item label="部门">
                      <el-select v-model="queryForm.dept" size="small" :clearable="true" placeholder="所有部门">
                        <el-option v-for="v in deptData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="职务">
                      <el-select v-model="queryForm.post" size="small" :clearable="true" placeholder="所有职务">
                        <el-option v-for="v in postData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="职称">
                      <el-select v-model="queryForm.title" size="small" :clearable="true" placeholder="所有职称">
                        <el-option v-for="v in titleData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="类别">
                      <el-select v-model="queryForm.class" size="small" :clearable="true" placeholder="所有类别">
                        <el-option v-for="v in classData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="状态">
                      <el-select v-model="queryForm.status" size="small" :clearable="true" placeholder="所有状态">
                        <el-option v-for="v in statusData" :key="v.staffParamId" :value="v.staffParamId" :label="v.staffParamName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="4">
                    <el-form-item label="婚姻">
                      <el-select v-model="queryForm.marriage" size="small" :clearable="true" placeholder="全部">
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
                      <el-date-picker v-model="queryForm.setTime" size="small" type="daterange" align="right" unlink-panels range-separator="至"
                        start-placeholder="开始日期" end-placeholder="结束日期" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                      </el-date-picker>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label=" ">
                      <el-button type="danger" size="small">重置</el-button>
                      <el-button type="primary" size="small">查询</el-button>
                    </el-form-item>
                  </el-col>
                </el-row>
              </div>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card can-select">
              <el-table :data="canSelectData" class="table" height="string" v-loading="listLoading">
               <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                <el-table-column prop="staffName" label="姓名" sortable align="center"></el-table-column>
                <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                <el-table-column prop="statusName" label="职务" align="center"></el-table-column>
                <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
              </el-table>
              <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
                :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
              </el-pagination>
            </div>
            <div class="card can-select">
              <el-table :data="canSelectData" class="table" height="string" v-loading="listLoading">
                <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column prop="staffNo" label="职工号" sortable align="center"></el-table-column>
                <el-table-column prop="staffName" label="姓名" sortable align="center"></el-table-column>
                <el-table-column prop="totalVal" label="总分" sortable align="center"></el-table-column>
                <el-table-column prop="sex" label="性别" sortable align="center"></el-table-column>
                <el-table-column prop="marriageState" label="婚姻状况" align="center"></el-table-column>
                <el-table-column prop="postName" label="职称" align="center"></el-table-column>
                <el-table-column prop="statusName" label="职务" align="center"></el-table-column>
                <el-table-column prop="typeName" label="职工类别" align="center"></el-table-column>
                <el-table-column prop="statusName" label="工作状态" align="center"></el-table-column>
                <el-table-column prop="deptName" label="工作部门" align="center"></el-table-column>
              </el-table>
              <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
                :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
              </el-pagination>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getStaffParam,
  getCanSelectStaff,
  getHaveSelectStaff,
  postCanSelectmulticondition,
  postSetCanSelect,
  postcancelCanSelect
} from "@/api/api";
import * as OPTION from "@/assets/data/formOption";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      // 多重查找表单
      queryForm: {},
      deptData: [],
      postData: [],
      titleData: [],
      classData: [],
      statusData: [],
      formOption: OPTION,
      // 时间选择区域
      pickerOptions: {
        shortcuts: [
          {
            text: "最近一周",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近一个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit("pick", [start, end]);
            }
          },
          {
            text: "最近三个月",
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit("pick", [start, end]);
            }
          }
        ]
      },
      // 表格区域
      listLoading: false,
      canSelectData: [],
      totalNum: 1,
      page: 1,
      size: 10
    };
  },
  components: {},
  created() {
    this.initalGet();
    this.getList()
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
    getList(){
      this.listLoading=true
            let param = {
        page: this.page,
        size: this.size
      };
      getCanSelectStaff(param)
        .then(res => {
          // console.log(res.data.data)
          this.canSelectData = res.data.data.data;
          //this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    //更换每页数量
    SizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    }
  }
};
</script>

<style scoped lang="scss">
.second-container {
  background-color: #f0f2f5;
  .toolbal {
    .el-form-item {
      margin-bottom: 0;
    }
    .card {
      padding: 20px;
    }
  }
  .can-select {
    height: 24vh;
    padding-bottom: 5vh;
  }
}
</style>
