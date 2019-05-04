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
            <el-breadcrumb-item>租赁受理</el-breadcrumb-item>
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
                <h1>租赁受理单</h1>
                <el-form :model="acceptForm"
                         label-width="100px"
                         ref="acceptForm"
                         :rules="rules">
                  <el-row v-if="!acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="acceptForm.name"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="工作部门">
                        <el-input v-model="acceptForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="acceptForm.name"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="工作部门">
                        <el-input v-model="acceptForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="acceptForm.phone"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="职称">
                        <el-input v-model="acceptForm.titleName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="职务">
                        <el-input v-model="acceptForm.postName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="职称">
                        <el-input v-model="acceptForm.titleName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="acceptForm.postName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="acceptForm.applyTime"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="联系电话">
                        <el-input v-model="acceptForm.phone"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="申请时间">
                        <el-input v-model="acceptForm.applyTime"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="acceptForm.titleVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="职务分">
                        <el-input v-model="acceptForm.jobLevelVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="acceptForm.titleVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务分">
                        <el-input v-model="acceptForm.jobLevelVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="工龄分">
                        <el-input v-model="acceptForm.timeVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row :class="{'is-accept':!acceptStatus}"
                          v-if="!acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="申请理由">
                        <el-input v-model="acceptForm.reason"
                                  type="textarea"
                                  :rows="2"
                                  readonly
                                  placeholder="无额外描述"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex"
                          justify="start"
                          v-if="!acceptStatus">
                    <el-col :span="7"
                            :push="1">
                      <el-form-item label="工龄分">
                        <el-input v-model="acceptForm.timeVal"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7"
                            :push="1">
                      <el-form-item label="配偶加分">
                        <el-input v-model="acceptForm.spouseVal"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7"
                            :push="1">
                      <el-form-item label="其他加分">
                        <el-input v-model="acceptForm.otherVal"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!acceptStatus">
                    <el-col :span="7"
                            :push="1">
                      <el-form-item label="总计得分">
                        <el-input v-model="totalVal"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!acceptStatus">
                    <el-col class="agree-col-width">
                      <el-form-item label="受理意见"
                                    prop="acceptNote">
                        <el-input v-model="acceptForm.acceptNote"
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!acceptStatus">
                    <el-col class="agree-col-width">
                      <el-form-item label="受理状态">
                        <el-switch v-model="acceptForm.acceptState"
                                   active-color="#ff4949"
                                   inactive-color="#13ce66"
                                   active-text="拒绝"
                                   active-value="拒绝"
                                   inactive-text="通过"
                                   inactive-value="通过"
                                   class="agree-col-switch"></el-switch>
                        <el-button type="primary"
                                   v-if="!acceptStatus"
                                   class="agree-col-btn"
                                   size="medium"
                                   @click="acceptSubmit">提交</el-button>

                      </el-form-item>
                    </el-col>

                  </el-row>
                  <!-- 非操作区域 -->
                  <el-row v-if="acceptStatus">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="配偶加分">
                        <el-input v-model="acceptForm.spouseVal"
                                  placeholder="无配偶分"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="其他分">
                        <el-input v-model="acceptForm.otherVal"
                                  placeholder="无其他分"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="总分">
                        <el-input v-model="acceptForm.totalVal"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="受理人">
                        <el-input v-model="acceptForm.acceptMan"
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="11">
                      <el-form-item label="受理时间">
                        <el-input v-model="acceptForm.acceptTime"
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="受理说明">
                        <el-input v-model="acceptForm.acceptNote"
                                  type="textarea"
                                  :rows="2"
                                  readonly
                                  placeholder="无额外描述"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="acceptStatus">
                    <el-col :span="10"
                            :offset="1">
                      <el-form-item label="受理状态">
                        <el-switch v-model="acceptForm.acceptState"
                                   active-color="#ff4949"
                                   inactive-color="#13ce66"
                                   active-text="拒绝"
                                   active-value="拒绝"
                                   inactive-text="通过"
                                   inactive-value="通过"
                                   :disabled="acceptStatus"></el-switch>
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
import { putHireAccept, postHireEmail } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data () {
    return {
      listLoading: false,
      acceptForm: {},
      acceptStatus: false,
      hireStatus: "accept",
      isSubmit: false,
      // 表单验证规则
      rules: {
        acceptNote: {
          required: true,
          message: "请输入受理意见",
          trigger: "blur"
        }
      }
    };
  },
  computed: {
    totalVal: function () {
      return (
        parseInt(this.acceptForm.otherVal) +
        parseInt(this.acceptForm.titleVal) +
        parseInt(this.acceptForm.spouseVal) +
        parseInt(this.acceptForm.timeVal)
      );
    }
  },
  components: {
    indexNav
  },
  methods: {
    // 从子组件获取
    getList (object) {
      this.acceptForm = object.content;
      this.acceptForm.otherVal = 0;
      this.acceptStatus = object.status;
      this.acceptForm.jobLevelVal = 0
    },
    // 受理信息提交
    acceptSubmit () {
      if (this.acceptForm.acceptState == null)
        this.acceptForm.acceptState = "通过";
      this.$confirm(`确认${this.acceptForm.acceptState}受理`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["acceptForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let acceptForm = this.acceptForm;
              let params = {
                acceptMan: this.$store.getters.userName,
                acceptNote: acceptForm.acceptNote,
                acceptState: acceptForm.acceptState,
                id: acceptForm.id,
                otherVal: acceptForm.otherVal,
                spouseVal: acceptForm.spouseVal,
                timeVal: acceptForm.timeVal,
                totalVal: this.totalVal
              };
              putHireAccept(params).then(res => {
                if ((params.acceptState = "拒绝")) {
                  let params = {
                    hireId: acceptForm.id
                  };
                  postHireEmail(params).catch(err => {
                    console.log(err);
                  });
                }
                this.acceptForm = {};
                utils.statusinfo(this, res.data);
                this.isSubmit = !this.isSubmit;
                this.listLoading = false;
                if (res.data.status == "success")
                  this.$refs["acceptForm"].resetFields();
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消受理"
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
      padding-bottom: 30px; // height: 90%;
      margin: 20px auto;
      position: relative;
      & .need-accept {
        h1 {
          text-align: center;
          margin-bottom: 30px;
        }
        & .is-accept {
          position: relative;
          border-bottom: 1px solid #e6ebf5;
          margin-bottom: 20px;
        }
      }
    }
  }
}
</style>
