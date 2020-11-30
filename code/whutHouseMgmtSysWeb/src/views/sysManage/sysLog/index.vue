<template>
  <div class="special-container"
       style="overflow: hidden;">
    <!-- 这里放置index -->
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>系统管理</el-breadcrumb-item>
            <el-breadcrumb-item>操作记录</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <el-form :model="queryForm"
                     label-width="100px">
              <div class="card">
                <el-row>
                  <el-col :span="4">
                    <el-form-item label="系统角色">
                      <el-select v-model="queryForm.role"
                                 size="small"
                                 :clearable="true"
                                 placeholder="全部">
                        <el-option v-for="param in roleOption"
                                   :key="param.id"
                                   :label="param.groupName"
                                   :value="param.groupName"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4">
                    <el-form-item label="操作类型">
                      <el-select v-model="queryForm.operateType"
                                 size="small"
                                 :clearable="true"
                                 placeholder="全部">
                        <el-option v-for="v in operateOption"
                                   :key="v.value"
                                   :value="v.value"
                                   :label="v.label"></el-option>
                      </el-select>
                    </el-form-item>
                  </el-col>
                  <el-col :span="8">
                    <el-form-item label="操作时间">
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
                                placeholder="输入职工号或姓名"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="4"
                          class="horizontalCenter">
                    <el-button type="danger"
                               size="small"
                               @click="resseting">重置</el-button>
                    <el-button type="primary"
                               size="small"
                               @click="getAllSysLog">查询</el-button>
                  </el-col>
                </el-row>
              </div>
            </el-form>
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card">
              <el-table :data="logData"
                        v-loading="listLoading"
                        class="table"
                        height="65vh"
                        style="border-radius: 10px;"
                        @selection-change="selectionChangeEvent">
                <el-table-column type="selection"
                                 width="55">
                </el-table-column>
                <el-table-column prop="operateTypeName"
                                 label="操作类型">
                  <template slot-scope="scope">
                    <el-tag size="medium"
                            :type="scope.row.operateTypeName | operateTypeFilter">{{ scope.row.operateTypeName }}</el-tag>
                  </template>
                </el-table-column>
                <el-table-column prop="operateUrl"
                                 :formatter="operateUrlFormatter"
                                 label="接口名">

                </el-table-column>
                <el-table-column prop="staffNo"
                                 label="职工号">

                </el-table-column>
                <el-table-column prop="staffName"
                                 label="操作人">

                </el-table-column>
                <el-table-column prop="role"
                                 label="系统角色">

                </el-table-column>
                <el-table-column prop="operateTime"
                                 label="操作时间">

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
              <div class="bottom-tool">
                <el-button type="danger"
                           size="small"
                           :disabled="!tableChecked.length"
                           @click="handleDelLog">删除记录</el-button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import {
  getAllSysLog,
  delMultiSysLog
} from '@/api/sysLog'
import { sysLogOperateType } from "@/assets/data/formOption";
import { getPartAuthList } from '@/api/auth'
import * as staticData from "@/utils/static";
import utils from "@/utils/index.js";

export default {
  name: 'SysLog',
  data () {
    return {
      // 操作记录数据
      logData: [],
      // 是否加载表格
      listLoading: false,
      operateOption: sysLogOperateType,
      // 系统角色下拉框
      roleOption: [],
      // 检索条件
      queryForm: {},
      time: [],
      // 时间选择区域
      pickerOptions: {
        shortcuts: staticData.longSpanPickerOptions
      },
      // 分页参数
      size: 10,
      page: 1,
      totalNum: 0,
      // 表格选中项
      tableChecked: []
    }
  },
  // 过滤器的哈希表
  filters: {
    operateTypeFilter (type) {
      const operateTypeMap = {
        增加: "success",
        删除: 'danger',
        更改: "info",
        登录: ""
      }
      return operateTypeMap[type];
    }
  },
  created () {
    this.getRoleIdByAuthList()
    this.getAllSysLog()
  },
  methods: {
    // 获取用户组部分信息（id、groupName）
    getRoleIdByAuthList () {
      getPartAuthList().then(res => {
        this.roleOption = res.data.data.data
      }).catch(err => {
        this.$message1.error(err)
      })
    },
    // 获取日志信息列表
    getAllSysLog () {
      // 多重查找查询
      if (this.time.length != 0) {
        this.queryForm.startTime = this.time[0]
        this.queryForm.endTime = this.time[1]
      }
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") delete this.queryForm[v];
      }
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      }
      if (this.queryForm.hasOwnProperty('query')) {
        let query = this.queryForm.query
        if (!isNaN(Number(query))) {
          this.queryForm.staffNo = Number(query)
        } else {
          this.queryForm.staffName = query.trim()
        }
      }
      const data = Object.assign({}, this.queryForm);
      getAllSysLog(param, data).then(res => {
        utils.statusinfo(this, res.data);
        this.logData = res.data.data.data.list;
        this.totalNum = res.data.data.data.total;
      })
        .then(() => this.listLoading = false)
      delete this.queryForm.staffName
      delete this.queryForm.staffNo
    },
    // 当前选中项
    selectionChangeEvent (selection) {
      this.tableChecked = selection
    },
    // 删除日志记录
    handleDelLog () {
      // 删除关系
      this.$confirm("此操作将删除记录", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.listLoading = true
          let logIdList = this.tableChecked.map(item => item.id)
          delMultiSysLog(logIdList).then(res => {
            this.getAllSysLog()
            this.$message1({
              showClose: true,
              message: res.data.message,
              type: res.data.status
            });
          })
            .then(() => this.listLoading = false)
            .catch(err => {
              this.$message1.error(err)
            })
        })
        .catch(() => {
          this.$message1({
            type: "info",
            message: "已取消删除"
          });
        });












    },
    // 重置查询表单
    resseting () {
      this.time = []
      this.queryForm = {}
    },
    //更换每页数量
    sizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.getAllSysLog()
    },
    //页码切换时
    currentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.getAllSysLog()
    },
    // 操作类型的标签颜色
    operateTypeTagType (label) {
      let operateType = this.operateOption.find(item => {
        return item.label = label
      })
      if (operateType) {
        console.log("operateType.type:", operateType.type)
        return operateType.type
      }
    },
    // 接口名字段的格式化
    operateUrlFormatter (row, column, cellValue, index) {
      let patter = /.*whutHouseMgmtReposity/
      return cellValue.replace(patter, '')
    }
  }
}
</script>
<style lang="scss" scoped>
@import "../../../styles/variables.scss";

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
  .bottom-tool {
    position: relative;
    left: 20px;
    top: -30px;
    width: fit-content;
  }
  .horizontalCenter {
    display: flex;
    justify-content: space-evenly;
  }
}
</style>
