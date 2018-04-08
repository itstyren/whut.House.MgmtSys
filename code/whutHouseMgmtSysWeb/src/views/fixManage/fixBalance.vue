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
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修结算</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
            <el-form :model="queryForm" label-width="100px">
              <el-row>
                <el-col :span="4">
                  <el-form-item label="查询条件">
                    <el-select v-model="queryForm.conditionId" :clearable="true" placeholder="请选择条件">
                      <el-option v-for="conditionid in formOption.fixBalanceCondition" :key="conditionid.value" :value="conditionid.value" :label="conditionid.label"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="4">
                  <el-form-item label="输入条件">
                    <el-input v-model="queryForm.conditionContent" placeholder="输入检索"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="7">
                  <el-form-item label="申请时间">
                    <el-date-picker v-model="setTime" type="daterange" align="right" unlink-panels range-separator="-" start-placeholder="开始日期"
                      end-placeholder="结束日期" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="3" :offset="1">
                  <el-button type="danger">重置</el-button>
                  <el-button type="primary" @click="multicondition">查询</el-button>
                </el-col>
                <el-col :span="2" :offset="1">
                  <export-popover :download-loading="downloadLoading" @export="exportHandle"></export-popover>
                </el-col>
              </el-row>
            </el-form>

          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-table :data="fixFormData" class="table" height="string" v-loading="listLoading">
              <el-table-column type="selection"></el-table-column>
              <el-table-column prop="id" label="单据号" sortable align="center"></el-table-column>
              <el-table-column prop="fixContentName" label="维修类型" align="center"></el-table-column>
              <el-table-column label="姓名" align="center">
                <template slot-scope="scope">
                  <el-popover trigger="hover" placement="top">
                    <p>姓名: {{ scope.row.staffName }}</p>
                    <p>工作部门: {{ scope.row.deptName }}</p>
                    <p>住址: {{ scope.row.staffAddress }}</p>
                    <div slot="reference" class="name-wrapper">
                      <el-tag size="medium" type="info">{{ scope.row.staffName }}</el-tag>
                    </div>
                  </el-popover>
                </template>
              </el-table-column>
              <el-table-column label="维修金额（元）" width="180" align="center">
                <template slot-scope="scope">
                  <template v-if="scope.row.edit">
                    <el-input class="edit-input" style="width:78px;" size="small" v-model="scope.row.fixMoney"></el-input>
                  </template>
                  <span v-else>{{ scope.row.fixMoney }}</span>
                </template>
              </el-table-column>
              <el-table-column prop="isCheck" label="是否结算" align="center">
                <template slot-scope="scope">
                  <my-icon v-if="scope.row.isCheck" icon-class="icon-" />
                </template>
              </el-table-column>
              <el-table-column label="状态" align="center">
                <template slot-scope="scope">
                  <el-tag :type="scope.row.fixState | statusFilter">{{scope.row.fixState}}</el-tag>
                </template>
              </el-table-column>
              <el-table-column prop="houseNo" label="住房号" align="center"></el-table-column>
              <el-table-column prop="staffNo" label="职工号" align="center"></el-table-column>
              <el-table-column prop="postName" label="职称" align="center"></el-table-column>
              <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
              <el-table-column prop="applyTime" label="申请时间" align="center"></el-table-column>
              <el-table-column prop="message" label="备注" align="center"></el-table-column>
              <el-table-column label="操作" width="180" align="center">
                <template slot-scope="scope">
                  <template v-if="!scope.row.edit">
                    <el-button v-if="!scope.row.edit" type="primary" size="mini" @click="priceEdit(scope.$index,scope.row)">定价</el-button>
                    <el-button type="success" size="mini" @click="setCheck(scope.$index,scope.row)">结算</el-button>
                  </template>
                  <template v-else>
                    <el-button type="success" size="mini" @click="SavePrice(scope.$index,scope.row)">保存</el-button>
                    <el-button class='cancel-btn' size="mini" type="warning" @click="cancel(scope.$index,scope.row)">取消</el-button>
                  </template>
                </template>
              </el-table-column>
            </el-table>
          </div>
          <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
            :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
          </el-pagination>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import * as OPTION from "@/assets/data/formOption";
import * as staticData from "@/utils/static";  
  import {
    postFixmulticondition,
    putFixPrice,
    putFixcheck
  } from "@/api/fixManage";
  import utils from "@/utils/index.js";
  import {
    parseTime
  } from "@/utils/time.js";
  import exportPopover from '@/components/exportPopover'
  export default {
    data() {
      return {
        downloadLoading: false,
        exportVisible: false,
        exportType: "1",
        // 多重查找表单
        queryForm: {},
        setTime: [],
        // 一些不需要后台获取的静态数据
        formOption: OPTION,
        // 表格需要的数据
        fixFormData: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10,
        pickerOptions: {
          shortcuts: staticData.shortSpanPickerOptions
        }
      };
    },
    components: {
      exportPopover
    },
    // 过滤器的哈希表
    filters: {
      statusFilter(status) {
        const statusMap = {
          待审核: "warning",
          待受理: "warning",
          审核拒绝: "danger",
          受理拒绝: "danger",
          已审核: "success"
        };
        return statusMap[status];
      }
    },
    created() {
      this.multicondition();
    },
    methods: {
      // 格式化价格处
      priceFormat(row, column, cellValue) {
        if (cellValue == null) return "待填";
        else return row.fixMoney;
      },
      // 行内编辑定价
      priceEdit(index, row) {
        if (row.isCheck == true) {
          this.$notify.error({
            title: "错误",
            message: "不能对已结算项重操作"
          });
          return;
        } else {
          row.edit = !row.edit;
        }
      },
      // 初始获取和多条件获取通用
      multicondition() {
        if (this.setTime != null && this.setTime.length != 0) {
          this.queryForm.startTime = this.setTime[0];
          this.queryForm.endTime = this.setTime[1];
        } else {
          this.queryForm.startTime = "";
          this.queryForm.endTime = "";
        }
        this.listLoading = true;
        for (let val in this.queryForm) {
          if (this.queryForm[val] == "") {
            delete this.queryForm[val];
          }
        }
        let param = {
          page: this.page,
          size: this.size
        };
        let data = Object.assign({}, this.queryForm);
        postFixmulticondition(param, data).then(res => {
          utils.statusinfo(this, res.data);
          const data = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.fixFormData = data.map(v => {
            this.$set(v, "edit", false);
            v.originFixMoney = v.fixMoney;
            return v;
          });
          this.listLoading = false;
        });
      },
      // 维修定价
      SavePrice(index, row) {
        if (row.fixMoney != null) {
          this.listLoading = true;
          let param = {
            price: row.fixMoney,
            id: row.id,
            priceMan: "任天宇"
          };
          putFixPrice(param).then(res => {
            // 公共提示方法
            utils.statusinfo(this, res.data);
            this.multicondition();
          });
        } else {
          this.$notify.error({
            title: "错误",
            message: "不能保存定价为空"
          });
        }
      },
      // 取消定价
      cancel(index, row) {
        row.fixMoney = row.originFixMoney;
        row.edit = false;
        this.$message({
          message: "已取消定价操作",
          type: "warning"
        });
      },
      // 维修结算
      setCheck(index, row) {
        if (row.fixMoney == null) {
          this.$notify.error({
            title: "错误",
            message: "不能对未定价的维修进行结算"
          });
          return;
        } else if (row.isCheck == true) {
          this.$notify.error({
            title: "错误",
            message: "请勿重复结算"
          });
          return;
        } else {
          this.$confirm("确认结算该项", "提示", {
              confirmButtonText: "确定",
              cancelButtonText: "取消",
              type: "warning"
            })
            .then(() => {
              this.listLoading = true;
              let param = {
                checkMan: "任天宇",
                id: row.id
              };
              putFixcheck(param).then(res => {
                utils.statusinfo(this, res.data);
              this.multicondition();
                this.listLoading = false;
              });
            })
            .catch(() => {
              this.$message({
                type: "info",
                message: "已取消结算"
              });
            });
        }
      },
      // 处理导出情况
      exportHandle(exportType) {
        //console.log(33)
        if (exportType == 1) this.handleDownload();
        else {
          let param = {
            page: 1,
            size: 9999
          };
          let data = Object.assign({}, this.queryForm);
          postFixmulticondition(param, data).then(res => {
            const values = res.data.data.data.list;
            this.handleDownload(values);
          });
        }
      },
      // 导出
      handleDownload(...values) {
        let filename = "维修结算表统计";
        this.downloadLoading = true;
        import ("@/vendor/Export2Excel").then(excel => {
          const tHeader = [
            "单据号",
            "维修类型",
            "姓名",
            "维修金额",
            "是否定价",
            "状态",
            "住房号",
            "职工号",
            "职称",
            "职务",
            "申请时间",
            "备注"
          ];
          const filterVal = [
            "id",
            "fixContentName",
            "staffName",
            "fixMoney",
            "isCheck",
            "fixState",
            "houseNo",
            "staffNo",
            "postName",
            "titleName",
            "applyTime",
            "message"
          ];
          let list = [];
          if (arguments.length == 0) list = this.fixFormData;
          else list = arguments[0];
          const data = this.formatJson(filterVal, list); // 用于自行洗数据
          let date = new Date();
          filename = filename + `(${parseTime(date, "{y}-{m}-{d}")})`;
          excel.export_json_to_excel(tHeader, data, filename);
          this.downloadLoading = false;
        });
      },
      formatJson(filterVal, jsonData) {
        return jsonData.map(v =>
          filterVal.map(j => {
            if (j === "timestamp") {
              return parseTime(v[j]);
            } else {
              return v[j];
            }
          })
        );
      },
      //更换每页数量
      SizeChangeEvent(val) {
        this.listLoading = true;
        this.size = val;
        this.multicondition();
      },
      //页码切换时
      CurrentChangeEvent(val) {
        this.listLoading = true;
        this.page = val;
        this.multicondition();
      }
    }
  };

</script>

<style scoped lang="scss">
  .toolbar {
    padding: 10px 10px;
    & .el-form-item {
      margin-bottom: 5px;
    }
  }

  .edit-input {
    padding-right: 10px;
  }

</style>
