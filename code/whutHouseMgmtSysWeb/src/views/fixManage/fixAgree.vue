<template>
  <div class="second-container">
    <indexNav :fix-status="fixstatus"
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
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修审核</el-breadcrumb-item>
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
                <h1>维修审核单</h1>
                <el-form :model="agreeForm"
                         label-width="100px"
                         ref="agreeForm"
                         :rules="rules">
                  <el-row>
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="维修类型">
                        <el-input v-model="agreeForm.fixContentName"
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
                      <el-form-item label="申请人姓名">
                        <el-input v-model="agreeForm.staffName"
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
                      <el-form-item label="工作部门">
                        <el-input v-model="agreeForm.deptName"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="14">
                      <el-form-item label="住房地址">
                        <el-input v-model="agreeForm.address"
                                  @click.native="handleShowOneHouse(agreeForm.houseId)"
                                  class="house-input"
                                  type="button"
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
                  <el-row v-if="!agreeState"
                          :class="{'is-agree':!agreeState}">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="受理说明">
                        <el-input v-model="agreeForm.acceptNote"
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="费用类型">
                        <el-input v-model="agreeForm.isPaySelf"
                                  readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="报修图片">
                        <span v-if="agreeForm.pastImageData==''">暂无图片</span>
                        <el-button v-else
                                   type="text"
                                   @click="carouselVisible=true">点击查看图片</el-button>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="agreeState">
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
                          justify="center"
                          v-if="!agreeState"
                          :gutter="12">
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
                          justify="center"
                          v-if="!agreeState">
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
                                   @click="reviewSubmit">提交</el-button>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 非操作区域 -->
                  <el-row v-if="agreeState">
                    <el-col :span="7"
                            :offset="1">
                      <el-form-item label="审核意见">
                        <el-input v-model="agreeForm.agreeNote"
                                  type="textarea"
                                  :rows="2"
                                  placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="agreeState">
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
                                   :disabled="agreeState"></el-switch>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-form>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 图片的走马灯 -->
      <el-dialog :title="`报修图片`"
                 :visible.sync="carouselVisible"
                 append-to-body>
        <el-carousel indicator-position="outside"
                     arrow="always"
                     :height="imgHeight">
          <el-carousel-item v-for="(item, index) in agreeForm.pastImageData"
                            :key="index"
                            :index="index">
            <img :src="item"
                 class="imgCenter" />
          </el-carousel-item>
        </el-carousel>
      </el-dialog>
    </section>
    <!-- 住房详情的对话框 -->
    <house-detail-dialog :show.sync="showDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import indexNav from "./components/indexNav";
import { putFixAgree, postFixEmail } from "@/api/fixManage";
import { checkNULL, checkTel } from "@/assets/function/validator";
import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'

export default {
  data () {
    return {
      listLoading: false,
      fixstatus: "review",
      agreeForm: {},
      agreeState: false,
      isSubmit: false,
      // 表单验证规则
      rules: {
        agreeNote: {
          required: true,
          message: "请输入审核意见",
          trigger: "blur"
        }
      },
      // 图片走马灯
      carouselVisible: false,
      // 走马灯初始高度
      imgHeight: '500px',
      // 是否显示住房详情的对话框
      showDialog: false,
      houseId: 0
    };
  },
  components: {
    indexNav,
    HouseDetailDialog
  },
  methods: {
    getList (object) {
      object.content.pastImageData = object.content.fixFiles ? object.content.fixFiles.split(',') : ''
      object.content.isPaySelf = object.content.isPaySelf ? '自费' : '公费'
      this.agreeForm = object.content;
      this.agreeState = object.status;
    },
    // 维修审核提交
    reviewSubmit () {
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
                id: agreeForm.id
              };
              putFixAgree(params).then(res => {
                let params = {
                  fixId: agreeForm.id
                };
                postFixEmail(params).catch(err => {
                  console.log(err);
                });
                this.agreeForm = {};
                utils.statusinfo(this, res.data);
                this.isSubmit = !this.isSubmit;
                this.listLoading = false;
                if (res.data.status == "success")
                  this.$refs["agreeForm"].resetFields();
              });
            }
          });
        })
        .catch(() => {
          this.$message1({
            type: "info",
            message: "已取消审核"
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
  .line {
    margin: 10px;
    border: 1px solid #e6ebf5;
    background-color: #fff;
    margin-bottom: 20px;
  }
  .main-data {
    padding-top: 20px;
  }

  .accept-form {
    width: 80%;
    background-color: #fff;
    padding: 10px;
    padding-bottom: 30px;
    margin: 20px auto;
    position: relative;
    .need-accept {
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
</style>
