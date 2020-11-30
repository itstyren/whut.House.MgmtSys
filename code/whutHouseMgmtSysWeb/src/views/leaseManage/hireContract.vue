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
            <el-breadcrumb-item>签订合同</el-breadcrumb-item>
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
                <h1>签订合同单</h1>
                <el-form :model="contractForm"
                         label-width="100px"
                         ref="contractForm"
                         :rules="rules">
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="contractForm.name"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="contractForm.applyTime"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="contractForm.phone"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="contractForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="contractForm.postName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="contractForm.titleName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- <el-row>
                    <el-col :span="5" :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="contractForm.titleVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="职务分">
                        <el-input v-model="contractForm.titleVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="配偶分">
                        <el-input v-model="contractForm.spouseVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="其他分">
                        <el-input v-model="contractForm.otherVal"  readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row> -->
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="受理人">
                        <el-input v-model="contractForm.acceptMan"
                                  readonly
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理状态">
                        <el-input v-model="contractForm.acceptState"
                                  readonly
                                  placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理时间">
                        <el-input v-model="contractForm.acceptTime"
                                  readonly
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审核人">
                        <el-input v-model="contractForm.agreeMan"
                                  readonly
                                  placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核状态">
                        <el-input v-model="contractForm.agreeState"
                                  readonly
                                  placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="contractForm.agreeTime"
                                  readonly
                                  placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="14"
                            :offset="1">
                      <el-form-item label="预分配住房">
                        <el-input v-model="contractForm.houseAddress"
                                  @click.native="handleShowOneHouse(contractForm.houseId)"
                                  class="house-input"
                                  type="button"
                                  readonly>
                        </el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="预分配面积">
                        <el-input v-model="contractForm.houseBuildArea"
                                  readonly
                                  placeholder="请选择住房">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!status"
                          :class="{'is-agree':!status}">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="申请理由">
                        <el-input v-model="contractForm.reason"
                                  type="textarea"
                                  readonly
                                  :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="受理意见">
                        <el-input v-model="contractForm.acceptNote"
                                  type="textarea"
                                  readonly
                                  :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核意见">
                        <el-input v-model="contractForm.agreeNote"
                                  type="textarea"
                                  readonly
                                  :rows="2"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="status">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审批人">
                        <el-input v-model="contractForm.approveMan"
                                  readonly
                                  placeholder="审核人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="contractForm.approveTime"
                                  readonly
                                  placeholder="审核时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex"
                          justify="start"
                          v-if="!status">
                    <el-col :span="8"
                            :offset="1">
                      <el-form-item label="登记时间">
                        <el-date-picker v-model="contractForm.bookTime"
                                        placeholder="请选择日期"
                                        format="yyyy-MM-dd"
                                        value-format="yyyy-MM-dd HH:mm:ss"></el-date-picker>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-form-item label="缴费方式"
                                    class="from-label"
                                    prop="payType">
                        <el-select v-model="contractForm.payType"
                                   placeholder="请选择">
                          <el-option v-for="payType in payTypes"
                                     :key="payType.id"
                                     :value="payType.id"
                                     :label="payType.typeName"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                    <el-col :span="2"
                            :offset="2">
                      <el-button type="primary"
                                 @click="contractSubmit">提交</el-button>
                    </el-col>
                  </el-row>
                </el-form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 住房详情的对话框 -->
      <house-detail-dialog :show.sync="showDialog"
                           :houseId.sync="houseId"></house-detail-dialog>

    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import indexNav from "./components/indexNav";
import { putHireContract } from "@/api/leaseManage";
import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'
export default {
  data () {
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
      dialogVisible: false,
      payTypes: [
        {
          id: 1,
          typeName: '自行缴费'
        },
        {
          id: 2,
          typeName: '工资代扣'
        }
      ],

      // 是否显示住房详情的对话框
      showDialog: false,
      houseId: 0
    };
  },
  // 注册组件
  components: {
    indexNav,
    HouseDetailDialog
  },
  methods: {
    // 从子组件获取
    getList (object) {
      this.contractForm = object.content;
      this.contractForm.otherVal = 0;
      this.status = object.status;
    },
    // 审批信息提交
    contractSubmit () {
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
                id: contractForm.id,
                payType: contractForm.payType
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
          this.$message1({
            type: "info",
            message: "已取消审批"
          });
        });
    },
    // 点击住址,显示住房详情对话框
    handleShowOneHouse (houseId) {
      this.houseId = houseId
      this.showDialog = true
    },
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
