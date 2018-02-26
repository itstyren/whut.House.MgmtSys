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
          <div class="toolbal">
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
                    <el-date-picker v-model="setTime" type="daterange" align="right" unlink-panels range-separator="至" start-placeholder="开始日期"
                      end-placeholder="结束日期" :picker-options="pickerOptions" value-format="yyyy-MM-dd">
                    </el-date-picker>
                  </el-form-item>
                </el-col>
                <el-col :span="5" :offset="1">
                  <el-button type="danger">重置</el-button>
                  <el-button type="primary" @click="multicondition">查询</el-button>
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
              <el-table-column prop="fixMoney" label="维修金额（元）" :formatter="priceFormat" width="120" align="center"></el-table-column>
              <el-table-column prop="isOver" label="是否定价" align="center"></el-table-column>
              <el-table-column prop="fixState" label="状态" align="center"></el-table-column>
              <el-table-column prop="houseNo" label="住房号" align="center"></el-table-column>
              <el-table-column prop="staffNo" label="职工号" align="center"></el-table-column>
              <el-table-column prop="postName" label="职称" align="center"></el-table-column>
              <el-table-column prop="titleName" label="职务" align="center"></el-table-column>
              <el-table-column prop="applyTime" label="申请时间" align="center"></el-table-column>
              <el-table-column prop="message" label="备注" align="center"></el-table-column>
              <el-table-column label="操作" width="160" align="center">
                <template slot-scope="scope">
                  <el-button type="primary" size="mini" @click="showSetPrice(scope.$index,scope.row)">定价</el-button>
                  <el-button type="success" size="mini" @click="setCheck(scope.$index,scope.row)">结算</el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
          <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
            :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
          </el-pagination>
        </div>
        
    <!-- 编辑表单 -->
    <el-dialog title="维修定价" :visible.sync="addPriceFormVisble" v-loading="submitLoading">
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules">
        <el-form-item label="维修价格" prop="price">
          <el-input v-model="addFormBody.price" style="width:500px;" placeholder="请输入维修价格">
                <template slot="append">元</template>
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addPriceFormVisble = false">取消</el-button>
        <el-button type="primary" @click.native="addPriceSubmit">提交</el-button>
      </div>
    </el-dialog>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import * as OPTION from "@/assets/data/formOption";
import { postFixmulticondition, putFixPrice, putFixcheck } from "@/api/api";
import common from "@/common/util.js";
export default {
  data() {
    return {
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
      // 定价表单
      addPriceFormVisble: false,
      submitLoading: false,
      addFormBody: {},
      addFormId: "",
      // 表单规则验证
      rules: {
        price: {
          required: true,
          message: "维修价格不能为空",
          trigger: "blur"
        }
      }
    };
  },
  created() {
    this.multicondition();
  },
  methods: {
    // 格式化价格处
    priceFormat(row, column, cellValue){
      if(cellValue==null)
      return '待填'
      else return row.fixMoney

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
      let param = Object.assign({}, this.queryForm);
      postFixmulticondition(param).then(res => {
        common.statusinfo(this, res.data);
        this.fixFormData = res.data.data.data;
        this.listLoading = false;
      });
    },
    // 维修定价
    showSetPrice(index, row) {
      this.addPriceFormVisble = true;
      this.addFormId = row.id;
    },
    addPriceSubmit() {
      this.$refs["addForm"].validate(valid => {
        if (valid) {
          this.submitLoading = true;
          let param = Object.assign({}, this.addFormBody);
          param.id = this.addFormId;
          param.priceMan = "任天宇";
          putFixPrice(param).then(res => {
            // 公共提示方法
            common.statusinfo(this, res.data);
            this.$refs["addForm"].resetFields();
            this.submitLoading = false;
            this.addPriceFormVisble = false;
            this.multicondition();
          });
        }
      });
    },
    // 维修结算
    setCheck(index, row) {
      this.$confirm("确认结算该项", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.listLoading=true
          let param={
            checkMan:'任天宇',
            id:row.id
          }
          putFixcheck(param).then(res => {
            common.statusinfo(this, res.data);
            this.listLoading = false;
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消结算"
          });
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
.toolbal {
  padding: 10px 10px;
  & .el-form-item {
    margin-bottom: 5px;
  }
}
</style>
