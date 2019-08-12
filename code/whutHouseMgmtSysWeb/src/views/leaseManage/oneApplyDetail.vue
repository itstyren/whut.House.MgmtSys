<template>
  <div>
    <!-- 详情表单 -->
    <el-dialog :title="`申请单编号:${detailData.id}`"
               :visible.sync="visible"
               @close="$emit('update:show', false)"
               :show="show"
               class="apply-detail-modify">

      <el-form :model="detailData"
               label-width="85px"
               status-icon>
        <!-- 上部分 -->
        <div class="top-line">
          <!-- 第一行 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="申请人姓名"
                            prop="name">
                <el-input v-model="detailData.name"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="申请时间"
                            prop="name">
                <el-input v-model="detailData.applyTime"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8"
                    class="btn-flex">
              <el-button type="infor"
                         size="medium"
                         @click="handleReAccept(detailData.id)">重受理</el-button>
              <el-button type="primary"
                         size="medium"
                         @click="handleReAgree(detailData.id)">重审核</el-button>
              <el-button type="warning"
                         size="medium"
                         @click="handleReApprove(detailData.id)">重审批</el-button>
            </el-col>
          </el-row>
        </div>
        <!-- 申请人信息 -->
        <!-- 第二行 -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="职工号">
                <el-input v-model="detailData.staffNo"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="性别">
                <el-input v-model="detailData.sex"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="联系电话">
                <el-input v-model="detailData.phone"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 第三行 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="邮箱">
                <el-input v-model="detailData.email"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="职称">
                <el-input v-model="detailData.titleName"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="职务">
                <el-input v-model="detailData.postName"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 第四行 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="申请原因">
                <el-input v-model="detailData.reason"
                          type="textarea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="相关图片">
                <span v-if="detailData.pastImageData==''">暂无图片</span>
                <el-button v-else
                           type="text"
                           @click="carouselVisible=true">点击查看图片</el-button>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="导出申请单">
                <el-button type="success"
                           size="mini"
                           @click="handleExportApply(detailData.staffId)">点击导出</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 第五行 -->
        <!-- 受理信息 -->
        <!-- 第一行 -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="受理人">
                <el-input v-model="detailData.acceptMan"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="受理时间">
                <el-input v-model="detailData.acceptTime"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="受理状态">
                <el-switch v-if="detailData.acceptState"
                           v-model="detailData.acceptState"
                           active-value="通过"
                           inactive-value="不通过"
                           ctive-color="#13ce66a"
                           inactive-color="#ff4949"
                           active-text="通过"
                           inactive-text="不通过"
                           disabled>
                </el-switch>
                <span v-else>未受理</span>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 第二行（受理意见） -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="受理意见">
                <el-input v-model="detailData.acceptNote"
                          type="textarea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 审核信息 -->
        <!-- 第一行 -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="审核人">
                <el-input v-model="detailData.agreeMan"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="审核时间">
                <el-input v-model="detailData.agreeTime"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="审核状态">
                <el-switch v-if="detailData.agreeState"
                           v-model="detailData.agreeState"
                           active-value="通过"
                           inactive-value="不通过"
                           ctive-color="#13ce66a"
                           inactive-color="#ff4949"
                           active-text="通过"
                           inactive-text="不通过"
                           disabled>
                </el-switch>
                <span v-else>未审核</span>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 第二行 -->
          <el-row>
            <el-col :span="16">
              <el-form-item label="预分配住房">
                <el-input v-model="detailData.houseAddress"
                          @click.native="handleShowOneHouse(detailData.houseId)"
                          class="house-input"
                          type="button"
                          readonly></el-input>
              </el-form-item>
            </el-col>

            <el-col :span="8">
              <el-form-item label="预分配面积">
                <el-input v-model="detailData.houseBuildArea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <!-- 第三行（审核意见 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="审核意见">
                <el-input v-model="detailData.agreeNote"
                          type="textarea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 审批信息 -->
        <!-- 第一行 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="审批人">
              <el-input v-model="detailData.approveMan"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="审批时间">
              <el-input v-model="detailData.approveTime"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="审批状态">
              <el-switch v-if="detailData.approveState"
                         v-model="detailData.approveState"
                         active-value="通过"
                         inactive-value="不通过"
                         ctive-color="#13ce66a"
                         inactive-color="#ff4949"
                         active-text="通过"
                         inactive-text="不通过"
                         disabled>
              </el-switch>
              <span v-else>未审核</span>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第二行（审批意见） -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="审批意见">
                <el-input v-model="detailData.approveNote"
                          type="textarea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 第三行 缴费方式、登记时间 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="缴费方式">
              <el-input v-model="detailData.payType"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="登记时间">
              <el-input v-model="detailData.contractTime"
                        readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <!-- 图片的走马灯 -->
      <el-dialog :title="`相关图片`"
                 :visible.sync="carouselVisible"
                 append-to-body>
        <el-carousel indicator-position="outside"
                     arrow="always"
                     :height="imgHeight">
          <el-carousel-item v-for="(item, index) in detailData.pastImageData"
                            :key="index"
                            :index="index">
            <img :src="item"
                 style="height:100%"
                 class="imgCenter" />
          </el-carousel-item>
        </el-carousel>
      </el-dialog>
    </el-dialog>
    <!-- 住房详情的对话框 -->
    <house-detail-dialog :show.sync="showDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>
</template>
<script>
import {
  getHireReAccept,
  getHireReAgree,
  getHireReApprove,
} from "@/api/leaseManage";
import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'

export default {
  name: 'OneApplyDetail',
  components: {
    HouseDetailDialog
  },
  data () {
    return {

      // 是否显示申请详情的对话框      
      visible: this.show,
      // 图片走马灯
      carouselVisible: false,
      // 走马灯初始高度
      imgHeight: '500px',
      // 是否显示住房详情的对话框
      showDialog: false,
      houseId: 0
    };
  },
  props: {
    show: {
      type: Boolean,
      default: false
    },
    detailData: {
      type: Object,
      default: () => { }
    }
  },
  watch: {
    show () {
      this.visible = this.show;
    },
  },
  methods: {

    // 表单重新受理
    handleReAccept (id) {
      this.$confirm("此操作将对该表单重受理", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let formID = id;
          getHireReAccept(formID)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.$emit("status-change");
              this.visible = false
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作"
          });
        });
    },
    // 表单重新审核
    handleReAgree (id) {
      this.$confirm("此操作将对该表单重审核", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let formID = id;
          getHireReAgree(formID)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.$emit("status-change");
              this.visible = false
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch((err) => {
          console.log("err:", err)
          this.$message({
            type: "info",
            message: "已取消操作"
          });
        });
    },
    // 表单重新审批
    handleReApprove (id) {
      this.$confirm("此操作将对该表单重审批", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let formID = id;

          getHireReApprove(formID)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.$emit("status-change");
              this.visible = false
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消操作"
          });
        });
    },
    // 点击住址,显示住房详情对话框
    handleShowOneHouse (houseId) {
      this.houseId = houseId
      this.showDialog = true
    },
    // 导出申请单
    handleExportApply (staffId) {
      window.location.href = `http://172.16.65.105:8080/whutHouseMgmtReposity/exportToWord/hire/${staffId}`;
    }
  }

}
</script>

<style scoped lang="scss">
.top-line {
  position: relative;
  margin-bottom: 5px;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: 5px;
    z-index: 1; //left: 5%;
    right: 2%;
  }
}
.btn-flex {
  display: flex;
  display: -webkit-flex;
  justify-content: space-evenly;
}
.imgCenter {
  position: relative; /*设置position位置*/
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
</style>
