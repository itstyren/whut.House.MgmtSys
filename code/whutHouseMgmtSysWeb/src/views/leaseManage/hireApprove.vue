<template>
  <div class="second-container">
    <indexNav :hire-status="hireStatus"
              :is-submit="isSubmit"
              @emit-form="getList"></indexNav>
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>租赁管理</el-breadcrumb-item>
            <el-breadcrumb-item>租赁审批</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="accept-form card">
              <div class="need-accept">
                <h1>租赁审批单</h1>
                <el-form :model="approveForm"
                         label-width="100px"
                         ref="approveForm"
                         :rules="rules">
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="approveForm.name"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="approveForm.applyTime"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="approveForm.phone"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="approveForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="approveForm.postName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="approveForm.titleName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- <el-row>
                    <el-col :span="5" :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="approveForm.titleVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="职务分">
                        <el-input v-model="approveForm.titleVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="配偶分">
                        <el-input v-model="approveForm.spouseVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="其他分">
                        <el-input v-model="approveForm.otherVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row> -->
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="受理人">
                        <el-input v-model="approveForm.acceptMan"
                                  readonly
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理状态">
                        <el-input v-model="approveForm.acceptState"
                                  readonly
                                  placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理时间">
                        <el-input v-model="approveForm.acceptTime"
                                  readonly
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审核人">
                        <el-input v-model="approveForm.agreeMan"
                                  readonly
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核状态">
                        <el-input v-model="approveForm.agreeState"
                                  readonly
                                  placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="approveForm.agreeTime"
                                  readonly
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="14"
                            :offset="1">
                      <el-form-item label="预分配住房">
                        <el-input v-model="approveForm.houseAddress"
                                  readonly>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="预分配面积">
                        <el-input v-model="approveForm.houseBuildArea"
                                  readonly
                                  placeholder="请选择住房">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!status"
                          :class="{'is-agree':!status}">
                    <el-col :span="9"
                            :offset="1">
                      <el-form-item label="审核说明">
                        <el-input v-model="approveForm.agreeNote"
                                  readonly
                                  type="textarea"
                                  :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审批人">
                        <el-input v-model="approveForm.approveMan"
                                  readonly
                                  placeholder="审核人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="approveForm.approveTime"
                                  readonly
                                  placeholder="审核时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col class="agree-col-width">
                      <el-form-item label="审批意见"
                                    prop="approveNote">
                        <el-input v-model="approveForm.approveNote"
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入审批意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col class="agree-col-width">
                      <el-form-item label="审核状态"
                                    prop="approveState">
                        <el-switch v-model="approveForm.approveState"
                                   active-color="#ff4949"
                                   inactive-color="#13ce66"
                                   active-text="拒绝"
                                   active-value="拒绝"
                                   inactive-text="通过"
                                   inactive-value="通过"
                                   class="agree-col-switch"></el-switch>
                        <el-button type="primary"
                                   class="agree-col-btn"
                                   size="medium"
                                   @click="approveSubmit">提交</el-button>

                      </el-form-item>
                    </el-col>

                  </el-row>
                  <!-- 非操作区域 -->
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审批意见">
                        <el-input v-model="approveForm.approveNote"
                                  readonly
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审批状态">
                        <el-switch v-model="approveForm.approveState"
                                   active-color="#ff4949"
                                   inactive-color="#13ce66"
                                   active-text="拒绝"
                                   active-value="拒绝"
                                   inactive-text="通过"
                                   inactive-value="通过"
                                   :disabled="status"></el-switch>
                      </el-form-item>
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
import { putHireApprove, postHireEmail } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data () {
    return {
      listLoading: false,
      approveForm: {},
      status: false,
      hireStatus: "approve",
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
    getList (object) {
      this.approveForm = object.content;
      this.approveForm.otherVal = 0;
      this.status = object.status;
    },
    // 审批信息提交
    approveSubmit () {
      if (this.approveForm.approveState == null)
        this.approveForm.approveState = "通过";
      this.$confirm(`确认${this.approveForm.approveState}审批`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["approveForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let approveForm = this.approveForm;
              let params = {
                approveMan: this.$store.getters.userName,
                approveNote: approveForm.approveNote,
                approveState: approveForm.approveState,
                id: approveForm.id
              };
              putHireApprove(params).then(res => {
                let params = {
                  hireId: approveForm.id
                };
                postHireEmail(params).catch(err => {
                  console.log(err);
                });
                this.approveForm = {};
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
      margin: 20px auto;
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
