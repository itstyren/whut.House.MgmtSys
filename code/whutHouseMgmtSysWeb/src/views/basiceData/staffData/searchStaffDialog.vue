<template>
  <div class="seach">
    <el-dialog title="选择配偶"
               :visible.sync="visiable"
               @close="$emit('update:show', false)"
               :show="show">
      <!-- 工具栏 -->
      <div class="query-tool">
        <el-form :model="queryForm"
                 label-width="100px">
          <el-row type="flex"
                  justify="start">
            <el-col :span="4">
              <el-form-item label="部门">
                <el-select v-model="queryForm.dept"
                           size="small"
                           :clearable="true"
                           placeholder="所有部门">
                  <el-option v-for="v in deptData"
                             :key="v.staffParamId"
                             :value="v.staffParamName"
                             :label="v.staffParamName"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="职务">
                <el-select v-model="queryForm.post"
                           size="small"
                           :clearable="true"
                           placeholder="所有职务">
                  <el-option v-for="v in postData"
                             :key="v.staffParamId"
                             :value="v.staffParamName"
                             :label="v.staffParamName"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="职称">
                <el-select v-model="queryForm.title"
                           size="small"
                           :clearable="true"
                           placeholder="所有职称">
                  <el-option v-for="v in titleData"
                             :key="v.staffParamId"
                             :value="v.staffParamName"
                             :label="v.staffParamName"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="类别">
                <el-select v-model="queryForm.class"
                           size="small"
                           :clearable="true"
                           placeholder="所有类别">
                  <el-option v-for="v in classData"
                             :key="v.staffParamId"
                             :value="v.staffParamName"
                             :label="v.staffParamName"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="状态">
                <el-select v-model="queryForm.status"
                           size="small"
                           :clearable="true"
                           placeholder="所有状态">
                  <el-option v-for="v in statusData"
                             :key="v.staffParamId"
                             :value="v.staffParamName"
                             :label="v.staffParamName"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row type="flex"
                  justify="start">
            <el-col :span="4">
              <el-form-item label="婚姻">
                <el-select v-model="queryForm.marriageState"
                           size="small"
                           :clearable="true"
                           placeholder="全部">
                  <el-option v-for="v in formOption.marriageState"
                             :key="v.value"
                             :value="v.value"
                             :label="v.label"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="性别">
                <el-select v-model="queryForm.sex"
                           size="small"
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
              <el-form-item label="工作时间">
                <el-date-picker v-model="time"
                                size="small"
                                type="daterange"
                                align="right"
                                unlink-panels
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期"
                                :picker-options="pickerOptions"
                                value-format="yyyy-MM-dd">
                </el-date-picker>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item label="直接查询">
                <el-input v-model="queryForm.query"
                          size="small"
                          placeholder="请输入搜索"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-button type="danger"
                         size="small"
                         style="margin-left:30px"
                         @click="resseting">重置</el-button>
              <el-button type="primary"
                         size="small"
                         @click="muticonditionQuery">查询</el-button>
            </el-col>
          </el-row>
        </el-form>
      </div>
      <div class="query-table card">
        <el-table :data="staffData"
                  class="table"
                  height="string"
                  v-loading="staffDataTableLoading"
                  @row-dblclick="rowDblclik">
          <el-table-column prop="no"
                           label="职工号"
                           sortable
                           align="center"></el-table-column>
          <el-table-column label="姓名"
                           sortable
                           prop="name"
                           align="center">
          </el-table-column>
          <el-table-column prop="code"
                           label="身份证号"
                           sortable
                           align="center"></el-table-column>
          <el-table-column prop="sex"
                           label="性别"
                           sortable
                           align="center"></el-table-column>
          <el-table-column prop="marriageState"
                           label="婚姻状况"
                           align="center"></el-table-column>
          <el-table-column prop="postName"
                           label="职称"
                           align="center"></el-table-column>
          <el-table-column prop="titleName"
                           label="职务"
                           align="center"></el-table-column>
          <el-table-column prop="typeName"
                           label="职工类别"
                           align="center"></el-table-column>
          <el-table-column prop="statusName"
                           label="工作状态"
                           align="center"></el-table-column>
          <el-table-column prop="deptName"
                           label="工作部门"
                           align="center"></el-table-column>
        </el-table>
        <el-pagination background layout="total, prev, pager, next, sizes, jumper"
                       @size-change="sizeChangeEvent"
                       @current-change="currentChangeEvent"
                       :page-size="size"
                       :page-sizes="[10,15,20,25,30]"
                       :total="totalNum">
        </el-pagination>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import {
  getStaffListByMultiCondition,
  getStaffByNoOrName
} from '@/api/basiceData'
import {
  getStaffParam
} from "@/api/sysManage";
import * as OPTION from "@/assets/data/formOption";
import utils from "@/utils/index.js";
import * as staticData from "@/utils/static";
export default {
  name: 'SearchStaffDialog',
  data () {
    return {
      visiable: this.show,
      // 查询的条件
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
      staffDataTableLoading: false,
      // 员工的表格信息
      staffData: [],
      totalNum: 0,
      page: 1,
      size: 10,
    }
  },
  props: {
    show: {
      type: Boolean,
      default: false
    },
  },
  watch: {
    // 是否显示选择配偶的对话框
    show () {
      this.visiable = this.show;
      this.initalGet();
      this.muticonditionQuery()
    },
  },
  methods: {
    //初始查询条件获取
    initalGet () {
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
    // 多重查找查询
    muticonditionQuery () {
      this.staffDataTableLoading = true;
      if (this.time.length != 0) {
        this.queryForm.joinTime = {
          startTime: this.time[0],
          endTime: this.time[1]
        };
      }
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") delete this.queryForm[v];
      }
      let param = {
        page: this.page,
        size: this.size
      };
      //console.log(this.queryForm)
      if (this.queryForm.hasOwnProperty('query')) {
        param.conditionValue = this.queryForm.query
        getStaffByNoOrName(param).then(res => {
          utils.statusinfo(this, res.data);
          this.staffData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.staffDataTableLoading = false;
        })
      } else {
        const data = Object.assign({}, this.queryForm);
        getStaffListByMultiCondition(param, data).then(res => {
          utils.statusinfo(this, res.data);
          this.staffData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.staffDataTableLoading = false;
        });
      }
    },
    // 重置查询表单
    resseting () {
      this.time = []
      this.queryForm = {}
    },
    //更换每页数量
    sizeChangeEvent (val) {
      this.staffDataTableLoading = true;
      this.size = val;
      this.muticonditionQuery()

    },
    //页码切换时
    currentChangeEvent (val) {
      this.staffDataTableLoading = true;
      this.page = val;
      this.muticonditionQuery()
    },
    // 某一行被双击时触发
    rowDblclik (row, event) {
      this.visiable = false
      this.$emit("select-one-staff", row);
    }
  }
}
</script>
<style lang="scss" scoped>
@import "../../../styles/variables.scss";

.seach {
  .query {
    background-color: $background-grey;
  }
  .el-form-item {
    margin-bottom: 5px;
  }
  & .query-table {
    height: 35vh;
    position: relative;
    padding-bottom: 5vh;
    & .table {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
