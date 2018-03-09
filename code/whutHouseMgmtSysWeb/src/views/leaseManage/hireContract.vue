<template>
  <div class="second-container">
    <indexNav :hire-status="hireStatus" :is-submit="isSubmit" @emit-form="getList"></indexNav>
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>租赁管理</el-breadcrumb-item>
            <el-breadcrumb-item>签订合同</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbal">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="accept-form card">
              <div class="need-accept">
                <h1>签订合同单</h1>
                <el-form :model="contractForm" label-width="100px" ref="contractForm" :rules="rules">
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="contractForm.name" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="contractForm.applyTime" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="contractForm.phone" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="contractForm.deptName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="contractForm.postName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="contractForm.titleName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- <el-row>
                    <el-col :span="5" :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="contractForm.titleVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="职务分">
                        <el-input v-model="contractForm.titleVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="配偶分">
                        <el-input v-model="contractForm.spouseVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="其他分">
                        <el-input v-model="contractForm.otherVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row> -->
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="受理人">
                        <el-input v-model="contractForm.acceptMan" size="small" readonly placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理状态">
                        <el-input v-model="contractForm.acceptState" size="small" readonly placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理时间">
                        <el-input v-model="contractForm.acceptTime" size="small" readonly placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="审核人">
                        <el-input v-model="contractForm.agreeMan" size="small" readonly placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核状态">
                        <el-input v-model="contractForm.agreeState" size="small" readonly placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="contractForm.agreeTime" size="small" readonly placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="14" :offset="1">
                      <el-form-item label="预分配住房">
                        <el-input v-model="contractForm.houseAddress" size="small" readonly>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="预分配面积">
                        <el-input v-model="contractForm.houseBuildArea" size="small" readonly placeholder="请选择住房">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!status" :class="{'is-agree':!status}">
                    <el-col :span="7" :offset="1">
                      <el-form-item label="申请理由">
                        <el-input v-model="contractForm.reason" type="textarea" :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理意见">
                        <el-input v-model="contractForm.acceptNote" type="textarea" :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核意见">
                        <el-input v-model="contractForm.agreeNote" type="textarea" :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="7" :offset="1">
                      <el-form-item label="审批人">
                        <el-input v-model="contractForm.approveMan" readonly placeholder="审核人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="contractForm.approveTime" readonly placeholder="审核时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex" justify="start" v-if="!status">
                    <el-col :span="8" :offset="1">
                      <el-form-item label="登记时间">
                        <el-date-picker v-model="contractForm.bookTime" size="small" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
                      </el-form-item>
                    </el-col>
                    <el-col :span="2" :offset="2">
                      <el-button type="primary" @click="contractSubmit">提交</el-button>
                    </el-col>
                  </el-row>
                </el-form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import indexNav from "./components/indexNav";
import { putHireContract } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      listLoading: false,
      contractForm: {},
      status: false,
      hireStatus: "contract",
      isSubmit: false,
      // 表单验证规则
      rules: {
        approveNote: {
          required: true,
          message: "请输入审批意见",
          trigger: "blur"
        }
      },
      dialogVisible: false
    };
  },
  // 注册组件
  components: {
    indexNav
  },
  methods: {
    // 从子组件获取
    getList(object) {
      this.contractForm = object.content;
      this.contractForm.otherVal = 0;
      this.status = object.status;
    },
    // 审批信息提交
    contractSubmit() {
      this.$confirm("确认签订合同", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["contractForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let contractForm = this.contractForm;
              let param = {
                bookTime: contractForm.bookTime,
                id: contractForm.id
              };
              putHireContract(param).then(res => {
                this.contractForm = {};
                utils.statusinfo(this, res.data);
                this.isSubmit = !this.isSubmit;
                this.listLoading = false;
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消审批"
          });
        });
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  & .main-data {
    padding-top: 20px;
    & .accept-form {
      width: 80%;
      background-color: #fff;
      padding: 10px;
      padding-bottom: 30px;
      height: 90%;
      margin: auto;
      position: relative;
      & .need-accept {
        h1 {
          text-align: center;
          margin-bottom: 30px;
        }
        & .is-agree {
          position: relative;
          border-bottom: 1px solid #e6ebf5;
          margin-bottom: 20px;
        }
      }
    }
  }
}
</style>
