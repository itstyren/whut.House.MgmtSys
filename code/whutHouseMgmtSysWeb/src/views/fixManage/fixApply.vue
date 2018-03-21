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
            <div class="apply-from card" v-loading="listLoading">
              <el-steps :active="active" finish-status="success">
                <el-step title="个人信息"></el-step>
                <el-step title="选择住房"></el-step>
                <el-step title="填写原因"></el-step>
              </el-steps>
              <el-form :model="accoutInfo" label-width="100px" inline ref="fixApplyForm" :rules="rules">
                <!-- 个人信息区域 -->
                <div v-if="active==0" class="personal-info">
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职工号">
                        <el-input v-model="accoutInfo.no" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="姓名">
                        <el-input v-model="accoutInfo.name" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="身份证号">
                        <el-input v-model="accoutInfo.code" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="性别">
                        <el-input v-model="accoutInfo.sex" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职务">
                        <el-input v-model="accoutInfo.postName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="单位">
                        <el-input v-model="accoutInfo.deptName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="手机号" prop="tel">
                        <el-input v-model="accoutInfo.tel" placeholder="请输入手机号"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="邮箱" prop="email">
                        <el-input v-model="accoutInfo.email" placeholder="请输入邮箱"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!-- 选择住房区域 -->
                <div v-if="active==1" class="house-info">
                  <el-row type="flex" justify="center">
                    <el-col :span="20">
                      <el-form-item label="住房" prop="houseId">
                        <el-select v-model="accoutInfo.houseId" placeholder="请选择住房" style="width:300px" clearable>
                          <el-option v-for="house in accoutInfo.listHouseGetApply" :key="house.id" :value="house.id" :label="house.address"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="住房号">
                        <el-input v-model="accoutInfo.no" style="width:300px" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="住房类型">
                        <el-input v-model="accoutInfo.typeName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="住房地址">
                        <el-input v-model="accoutInfo.address" style="width:300px" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="住房面积">
                        <el-input v-model="accoutInfo.buildArea" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="产权关系">
                        <el-input v-model="accoutInfo.statusName" style="width:300px" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="使用面积">
                        <el-input v-model="accoutInfo.usedArea" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!-- 维修填写区域 -->
                <div v-if="active==2" class="fix-reason">
                  <el-row type="flex" justify="center">
                    <el-col :span="20">
                      <el-form-item label="维修类型" prop="fixContentId">
                        <el-select v-model="accoutInfo.fixContentId" placeholder="请选择维修类型" style="width:200px" clearable>
                          <el-option v-for="fix in fixType" :key="fix.fixParamId" :value="fix.fixParamId" :label="fix.fixParamName"></el-option>
                        </el-select>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="20">
                      <el-form-item label="申请原因" prop="description">
                        <el-input v-model="accoutInfo.description" type="textarea" style="width:600px" :rows="6" placeholder="请详细说明您的住房困难及需求,并留下您的联系方式，以便工作人员与您联系">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <div v-if="active==3" class="fix-result">
                  <span>提交成功，请等待审核！</span>
                </div>                
                <div class="opera-area">
                  <el-button @click="backButton" v-if="active>=1&&active<3">上一步</el-button>
                  <el-button @click="nextButton" v-if="active<2">下一步</el-button>
                  <el-button @click="addSubmit" v-if="active==2">提交</el-button>
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
  data() {
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
          message: "请选择住房"
        },
        fixContentId: {
          required: true,
          message: "请选择类型"
        },
        description: {
          required: true,
          message: "请填写描述"
        }
      },
      // 进度信息
      active: 0,
      // 维修类型填充
      fixType: []
    };
  },
  // 计算属性
  computed: {
    selectHouse() {
      return this.accoutInfo.houseId;
    }
  },
  //　监视者
  watch: {
    selectHouse(newVal) {
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
  created() {
    this.getList();
  },
  methods: {
    // 前进一步
    nextButton() {
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
    backButton() {
      this.active--;
    },
    // 获取个人信息
    getList() {
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
    addSubmit() {
      this.active++;
      this.$refs["fixApplyForm"].validate(valid => {
        if (valid) {
          this.listLoading = true;
          let applyForm = {
            description: this.accoutInfo.description,
            email: this.accoutInfo.email,
            fixContentId: this.accoutInfo.fixContentId,
            houseId: this.accoutInfo.houseId,
            phone: this.accoutInfo.tel,
            staffId: this.$store.getters.userID
          };
          postFixApply(applyForm).then(res => {
            utils.statusinfo(this, res.data);
            this.listLoading = false;
            // if (res.data.status == "success")
            //   this.$refs["fixApplyForm"].resetFields();
          });
        }
      });
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
  height: 80%;
  margin: auto;
  position: relative;
  .personal-info {
    padding-top: 3%;
    margin-bottom: 5vh;
  }
  .house-info {
    padding-top: 3%;
    margin-bottom: 5vh;
  }
  .fix-reason {
    padding-top: 3%;
    margin-bottom: 5vh;
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
    position: absolute;
    bottom: 10%;
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
</style>
