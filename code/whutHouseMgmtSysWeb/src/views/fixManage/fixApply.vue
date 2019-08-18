<template>
  <div class="second-container">
    <div class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修申请</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <!-- 申请表单区 -->
            <div class="apply-from card"
                 v-loading="listLoading">
              <el-steps :active="active"
                        finish-status="success">
                <el-step title="个人信息"></el-step>
                <el-step title="选择住房"></el-step>
                <el-step title="填写原因"></el-step>
              </el-steps>
              <el-form :model="accoutInfo"
                       label-width="100px"
                       inline
                       ref="fixApplyForm"
                       :rules="rules">
                <!-- 个人信息区域 -->
                <div v-if="active==0"
                     class="personal-info">
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="10">
                      <el-form-item label="职工号"
                                    prop="no">
                        <el-input v-model="accoutInfo.no"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="姓名"
                                    prop="name">
                        <el-input v-model="accoutInfo.name"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="10">
                      <el-form-item label="身份证号"
                                    prop="code">
                        <el-input v-model="accoutInfo.code"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="性别"
                                    prop="sex">
                        <el-input v-model="accoutInfo.sex"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="10">
                      <el-form-item label="职务"
                                    prop="postName">
                        <el-input v-model="accoutInfo.postName"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="单位"
                                    prop="deptName">
                        <el-input v-model="accoutInfo.deptName"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="10">
                      <el-form-item label="手机号"
                                    prop="tel">
                        <el-input v-model="accoutInfo.tel"
                                  placeholder="请输入手机号"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="邮箱"
                                    prop="email">
                        <el-input v-model="accoutInfo.email"
                                  placeholder="请输入邮箱"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!-- 选择住房区域 -->
                <div v-if="active==1"
                     class="house-info">
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="14"
                            :md="14"
                            :lg="9">
                      <el-form-item label="住房"
                                    label-width="80px"
                                    prop="houseId">
                        <el-select v-model="accoutInfo.houseId"
                                   placeholder="请选择住房"
                                   style="width:300px"
                                   clearable>
                          <el-option v-for="house in accoutInfo.listHouseGetApply"
                                     :key="house.id"
                                     :value="house.id"
                                     :label="house.address"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10"
                            :md="10"
                            :lg="7"></el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="14"
                            :md="14"
                            :lg="9">
                      <el-form-item label="住房号"
                                    label-width="80px"
                                    prop="no">
                        <el-input v-model="accoutInfo.no"
                                  style="width:300px"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10"
                            :md="10"
                            :lg="7">
                      <el-form-item label="住房类型"
                                    label-width="80px"
                                    prop="typeName">
                        <el-input v-model="accoutInfo.typeName"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="14"
                            :md="14"
                            :lg="9">
                      <el-form-item label="住房地址"
                                    label-width="80px"
                                    prop="address">
                        <el-input v-model="accoutInfo.address"
                                  style="width:300px"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10"
                            :md="10"
                            :lg="7">
                      <el-form-item label="住房面积"
                                    label-width="80px"
                                    prop="buildArea">
                        <el-input v-model="accoutInfo.buildArea"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="14"
                            :md="14"
                            :lg="9">
                      <el-form-item label="产权关系"
                                    label-width="80px"
                                    prop="statusName">
                        <el-input v-model="accoutInfo.statusName"
                                  style="width:300px"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10"
                            :md="10"
                            :lg="7">
                      <el-form-item label="使用面积"
                                    label-width="80px"
                                    prop="usedArea">
                        <el-input v-model="accoutInfo.usedArea"
                                  :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!-- 维修填写区域 -->
                <div v-if="active==2"
                     class="fix-reason">
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="20">
                      <el-row>
                        <!-- 维修类型 -->
                        <el-col :span="10">
                          <el-form-item label="维修类型"
                                        prop="fixContentId">
                            <el-select v-model="accoutInfo.fixContentId"
                                       placeholder="请选择维修类型"
                                       style="width:200px"
                                       clearable>
                              <el-option v-for="fix in fixType"
                                         :key="fix.fixParamId"
                                         :value="fix.fixParamId"
                                         :label="fix.fixParamName"></el-option>
                            </el-select>
                          </el-form-item>
                        </el-col>
                      </el-row>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="20">
                      <!-- 费用类型 -->
                      <el-form-item label="费用类型"
                                    prop="fixPayType">
                        <el-select v-model="isPaySelf"
                                   placeholder="请选择费用类型"
                                   style="width:200px"
                                   clearable>
                          <el-option v-for="(fix,index) in fixPayTypes"
                                     :key="index"
                                     :value="fix"
                                     :label="fix"></el-option>
                        </el-select>
                      </el-form-item>

                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="20">
                      <el-form-item label="报修图片"
                                    prop="picData">
                        <el-upload :action="`${basiceUrl}/fileUpload/multiFileUpload`"
                                   :multiple="true"
                                   style="width:350px;"
                                   ref="addFormImageUpload"
                                   :on-success="successUpload"
                                   :on-error="errorUpload"
                                   :on-remove="handleNowImageRemove"
                                   :before-remove="beforeRemove"
                                   :before-upload="beforePicUpload">
                          <el-button size="small"
                                     type="primary">点击上传</el-button>
                        </el-upload>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex"
                          justify="center">
                    <el-col :span="20">
                      <el-form-item label="申请原因"
                                    prop="description">
                        <el-input v-model="accoutInfo.description"
                                  type="textarea"
                                  style="width:600px"
                                  :rows="6"
                                  placeholder="请详细说明您的房屋问题，以便快读得到反馈！">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <div v-if="active==3"
                     class="fix-result">
                  <span>提交成功，请等待审核！</span>
                  <el-button type="success"
                             class="btn-export-fixApply"
                             size="medium"
                             @click="handleExportApply(fixId)">导出申请单</el-button>
                </div>
                <div class="opera-area">
                  <el-button @click="backButton"
                             v-if="active>=1&&active<3">上一步</el-button>
                  <el-button @click="nextButton"
                             v-if="active<2">下一步</el-button>
                  <el-button @click="addSubmit"
                             v-if="active==2">提交</el-button>
                </div>
              </el-form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getStaffInfo, postFixApply } from "@/api/fixManage";
import { getFixParam } from "@/api/sysManage";
import { checkEmail, checkNULL, checkTel } from "@/assets/function/validator";
import utils from "@/utils/index.js";
export default {
  data () {
    return {
      listLoading: false,
      // 个人信息填充
      accoutInfo: {},
      //表单验证规则
      rules: {
        tel: [
          {
            required: true,
            message: "请输入手机号"
          },
          {
            validator: checkTel,
            trigger: "blur"
          }
        ],
        // email: [{
        //     required: true,
        //     message: "请输入电子邮箱",
        //     trigger: "change"
        //   },
        //   {
        //     validator: checkEmail,
        //     trigger: "blur"
        //   }
        // ],
        houseId: {
          required: true,
          message: "请选择住房",
          trigger: "blur"
        },
        fixContentId: {
          required: true,
          message: "请选择类型",
          trigger: "blur"
        },
        description: {
          required: true,
          message: "请填写描述",
          trigger: "blur"
        }
      },
      // 进度信息
      active: 0,
      // 维修类型填充
      fixType: [],
      // 图片上传的域名
      basiceUrl: "http://172.16.65.105:8080/whutHouseMgmtReposity",
      // 已经上传但是未提交的图片数组
      allImageData: [],
      isBeforeRemove: true,
      fixPayTypes: ['公费', '自费'],
      isPaySelf: '公费',
      // 维修单编号
      fixId: null
    };
  },
  // 计算属性
  computed: {
    selectHouse () {
      return this.accoutInfo.houseId;
    }
  },
  //　监视者
  watch: {
    selectHouse (newVal) {
      this.accoutInfo.listHouseGetApply.forEach(house => {
        if (house.id == newVal) {
          this.accoutInfo.no = house.no;
          this.accoutInfo.address = house.address;
          this.accoutInfo.statusName = house.statusName;
          this.accoutInfo.typeName = house.typeName;
          this.accoutInfo.usedArea = house.usedArea;
          this.accoutInfo.buildArea = house.buildArea;
        }
      });
    }
  },
  created () {
    this.getList();
  },
  methods: {
    // 前进一步
    nextButton () {
      let vaild = true;
      // 个人信息验证
      if (this.active == 0) {
        this.$refs["fixApplyForm"].validateField("tel", callback => {
          if (callback.length == 0) {
            this.active++;
          }
        });
      } else if (this.active++ > 2) this.active = 0;
    },
    // 返回一步
    backButton () {
      this.active--;
      this.$refs["fixApplyForm"].clearValidate()
    },
    // 获取个人信息
    getList () {
      this.listLoading = true;
      let staffID = this.$store.getters.userID;
      let param = {};
      getStaffInfo(param, staffID)
        .then(res => {
          this.accoutInfo = res.data.data.data;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
      // 获取维修类型
      getFixParam(param, 16)
        .then(res => {
          this.fixType = res.data.data.data.list;
          // console.log(this.fixType);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 提交维修申请
    addSubmit () {

      this.$refs["fixApplyForm"].validate(valid => {
        if (valid) {
          this.$confirm("此操作将提交该申请", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          })
            .then(() => {
              this.listLoading = true;
              let applyForm = {
                description: this.accoutInfo.description,
                email: this.accoutInfo.email,
                fixContentId: this.accoutInfo.fixContentId,
                houseId: this.accoutInfo.houseId,
                phone: this.accoutInfo.tel,
                staffId: this.$store.getters.userID,
                isPaySelf: this.isPaySelf === "自费" ? true : false,
                fixFiles: this.allImageData.join(',')
              };
              postFixApply(applyForm).then(res => {
                this.active++;
                utils.statusinfo(this, res.data);
                this.listLoading = false;
                if (res.data.status == "success") {
                  this.$refs["fixApplyForm"].resetFields();
                  this.fixId = res.data.data.id
                }
              });

            })
            .catch(() => {
              this.$message1({
                type: "info",
                message: "已取消提交"
              })
            })
        }

      })
    },
    // 上传未提交的图片成功的钩子
    successUpload (response, file, fileList) {
      this.allImageData = this.allImageData.concat(response.data.data[0])
    },
    // 图片上传失败的钩子
    errorUpload (res, file) {
      this.$message1.error("图片上传失败！")
    },
    // 删除未提交的图片之后的钩子
    handleNowImageRemove (file, fileList) {
      let imageUrl = file.response.data.data[0]
      let index = this.allImageData.indexOf(imageUrl)
      this.allImageData.splice(index, 1)
    },
    // 删除图片前的钩子
    beforeRemove (file, fileList) {
      if (this.isBeforeRemove) {
        return this.$confirm(`确定移除 ${file.name}？`);
      } else {
        this.isBeforeRemove = true
        return true
      }
    },
    //在图片提交前进行验证
    beforePicUpload (file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG && !isPNG) {
        this.$message1.error("上传头像图片只能是 JPG/PNG 格式!");
        this.isBeforeRemove = false
        return false;
      } else if (!isLt2M) {
        this.$message1.error("上传证明图片大小不能超过 2MB!");
        this.isBeforeRemove = false
        return false;
      }
      return true;
    },
    // 导出申请单
    handleExportApply (fixId) {
      window.location.href = `http://172.16.65.105:8080/whutHouseMgmtReposity/exportToWord/fix/${fixId}`;
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.apply-from {
  width: 80%;
  background-color: $white;
  padding: 50px;
  height: 95%;
  margin: auto;
  position: relative;
  .personal-info {
    padding-top: 8vh;
    margin-bottom: 5vh;
  }
  .house-info {
    padding-top: 8vh;
    margin-bottom: 8vh;
  }
  .fix-reason {
    padding-top: 8vh;
    margin-bottom: 8vh;
  }
  & .fix-result {
    margin: 150px auto 100px;
    width: 500px;
    text-align: center;
    & > span {
      font-size: 22px;
    }
  }
  .opera-area {
    // position: absolute;
    // bottom: 10%;
    left: 0;
    right: 0;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-content: space-around;
  }
}

.second-container {
  background-color: $background-grey;
  .el-input {
    width: 200px;
  }
}
.btn-export-fixApply {
  display: block;
  margin: 20px auto;
}
</style>
