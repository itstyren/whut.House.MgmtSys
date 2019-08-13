<template>
  <div>
    <!-- 详情表单 -->
    <el-dialog :title="`申请单编号:${detailData.id}`"
               :visible.sync="visible"
               @close="$emit('update:show', false)"
               :show="show"
               class="fixApply-detail">

      <el-form :model="detailData"
               label-width="85px"
               status-icon>
        <!-- 上部分 -->
        <div class="top-line">
          <!-- 第一行：申请人姓名 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="申请人姓名"
                            prop="staffName">
                <el-input v-model="detailData.staffName"
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
              <el-form-item label="导出申请单">
                <el-button type="success"
                           size="medium"
                           @click="handleExportApply(detailData.staffId)">点击导出</el-button>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 申请人信息 -->
        <!-- 第二行：职工号 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="职工号">
              <el-input v-model="detailData.staffNo"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="工作部门">
              <el-input v-model="detailData.deptName"
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
        <!-- 第三行：邮箱 -->
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
        <!-- 第四行：报修图片 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="报修图片">
              <span v-if="detailData.pastImageData==''">暂无图片</span>
              <el-button v-else
                         type="text"
                         @click="carouselVisible=true">点击查看图片</el-button>
            </el-form-item>
          </el-col>
          <el-col :span="16">
            <el-form-item label="住房地址">
              <el-input v-model="detailData.address"
                        @click.native="handleShowOneHouse(detailData.houseId)"
                        class="house-input"
                        type="button"
                        readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 第五行：报修原因 -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="报修原因">
                <el-input v-model="detailData.acceptMan"
                          type="textarea"
                          readonly></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="费用类型">
                <el-input v-model="detailData.isPaySelf"
                          readonly></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 受理信息 -->
        <!-- 第一行：受理人 -->
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
        <!-- 第二行：受理意见 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="受理意见">
              <el-input v-model="detailData.acceptNote"
                        type="textarea"
                        readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 审核信息 -->
        <!-- 第一行：审核人 -->
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
        <!-- 第二行：审核意见 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="审核意见">
              <el-input v-model="detailData.agreeNote"
                        type="textarea"
                        readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <!-- 维修金额 -->
        <el-row>
          <el-col :span="8">
            <el-form-item label="维修金额">
              <el-input v-model="detailData.fixMoney"
                        readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="是否结算">
              <el-switch v-model="detailData.isCheck"
                         active-value="是"
                         inactive-value="否"
                         ctive-color="#13ce66a"
                         inactive-color="#ff4949"
                         active-text="是"
                         inactive-text="否"
                         disabled>
              </el-switch>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <!-- 图片的走马灯 -->
      <el-dialog :title="`报修图片`"
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

import utils from "@/utils/index.js";
import HouseDetailDialog from '@/components/OneHouseData'

export default {
  name: 'OneFixApplyDetail',
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
          this.$message1({
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
          this.$message1({
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
          this.$message1({
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
      // window.location.href = `http://172.16.65.105:8080/whutHouseMgmtReposity/exportToWord/hire/${staffId}`;
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
</style>
