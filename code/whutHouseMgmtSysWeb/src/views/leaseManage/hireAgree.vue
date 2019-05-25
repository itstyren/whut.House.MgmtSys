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
            <el-breadcrumb-item>租赁审核</el-breadcrumb-item>
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
                <h1>租赁审核单</h1>
                <el-form :model="agreeForm"
                         label-width="100px"
                         ref="agreeForm"
                         :rules="rules">
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="agreeForm.name"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="agreeForm.applyTime"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="agreeForm.phone"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="agreeForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="agreeForm.postName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="agreeForm.titleName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="agreeForm.titleVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务分">
                        <el-input v-model="agreeForm.titleVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="工龄分">
                        <el-input v-model="agreeForm.timeVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="配偶分">
                        <el-input v-model="agreeForm.spouseVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="其他分">
                        <el-input v-model="agreeForm.otherVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="总得分">
                        <el-input v-model="agreeForm.totalVal"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="受理人">
                        <el-input v-model="agreeForm.acceptMan"
                                  readonly
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理状态">
                        <el-input v-model="agreeForm.acceptState"
                                  readonly
                                  placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理时间">
                        <el-input v-model="agreeForm.acceptTime"
                                  readonly
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!status"
                          :class="{'is-agree':!status}">
                    <el-col :span="9"
                            :offset="1">
                      <el-form-item label="受理说明">
                        <el-input v-model="agreeForm.acceptNote"
                                  readonly
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="14"
                            :offset="1">
                      <el-form-item label="预分配住房">
                        <el-input v-model="agreeForm.houseAddress"
                                  readonly>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="预分配面积">
                        <el-input v-model="agreeForm.houseBuildArea"
                                  readonly
                                  placeholder="请选择住房">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审核人">
                        <el-input v-model="agreeForm.agreeMan"
                                  readonly
                                  placeholder="审核人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="agreeForm.agreeTime"
                                  readonly
                                  placeholder="审核时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col :span="16"
                            :offset="1">
                      <el-form-item label="住房分配"
                                    prop="houseName">
                        <el-input v-model="agreeForm.houseName"
                                  readonly
                                  placeholder="请选择住房">
                          <el-button slot="append"
                                     icon="el-icon-search"
                                     @click="dialogVisible"></el-button>
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col class="agree-col-width">
                      <el-form-item label="审核意见"
                                    prop="agreeNote">
                        <el-input v-model="agreeForm.agreeNote"
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col class="agree-col-width">
                      <el-form-item label="审核状态"
                                    prop="agreeState">
                        <el-switch v-model="agreeForm.agreeState"
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
                                   @click="agreeSubmit">提交</el-button>

                      </el-form-item>
                    </el-col>

                  </el-row>
                  <!-- 非操作区域 -->
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审核意见">
                        <el-input v-model="agreeForm.agreeNote"
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
                      <el-form-item label="审核状态">
                        <el-switch v-model="agreeForm.agreeState"
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
        <seach-house @select-house="selectHouse"></seach-house>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import indexNav from "./components/indexNav";
import seachHouse from "@/views/tools/seachHouse";
import { putHireAgree, postHireEmail } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data () {
    return {
      listLoading: false,
      agreeForm: {},
      status: false,
      hireStatus: "agree",
      isSubmit: false,
      selectHouseId: "",
      // 表单验证规则
      rules: {
        agreeNote: {
          required: true,
          message: "请输入审核意见",
          trigger: "blur"
        }
      }
    };
  },
  // 注册组件
  components: {
    seachHouse,
    indexNav
  },
  computed: {
    totalVal: function () {
      return (
        parseInt(this.agreeForm.otherVal) + parseInt(this.agreeForm.titleVal)
      );
    }
  },
  methods: {
    dialogVisible () {
      this.$store.dispatch("setSeachHouse", true);
    },
    // 从子组件获取
    getList (object) {
      this.agreeForm = object.content;
      this.agreeForm.otherVal = 0;
      this.status = object.status;
    },
    // 审核信息提交
    agreeSubmit () {
      if (this.agreeForm.agreeState == null) this.agreeForm.agreeState = "通过";
      this.$confirm(`确认${this.agreeForm.agreeState}审核`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["agreeForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let agreeForm = this.agreeForm;
              let params = {
                agreeMan: this.$store.getters.userName,
                agreeNote: agreeForm.agreeNote,
                agreeState: agreeForm.agreeState,
                id: agreeForm.id,
                houseId: this.selectHouseId
              };
              putHireAgree(params).then(res => {
                if ((params.agreeState = "拒绝")) {
                  let params = {
                    hireId: agreeForm.id
                  };
                  postHireEmail(params).catch(err => {
                    console.log(err);
                  });
                }
                this.agreeForm = {};
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
            message: "已取消审核"
          });
        });
    },
    // 从组件中传递
    selectHouse (data) {
      this.$set(this.agreeForm, "houseName", data[0]);
      this.selectHouseId = data[1];
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
