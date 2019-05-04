<template>
  <div class="second-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>网上选房</el-breadcrumb-item>
            <el-breadcrumb-item>住房申请</el-breadcrumb-item>
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
                <el-step title="信息确认"></el-step>
                <el-step title="填写原因"></el-step>
              </el-steps>
              <el-form :model="accoutInfo" label-width="100px" inline ref="hireApplyForm" :rules="rules">
                <!-- 个人信息区域 -->
                <div v-if="active==0" class="personal-info">
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职工号">
                        <el-input v-model="accoutInfo.No" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="姓名">
                        <el-input v-model="accoutInfo.Name" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="身份证号">
                        <el-input v-model="accoutInfo.Code" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="性别">
                        <el-input v-model="accoutInfo.Sex" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职务">
                        <el-input v-model="accoutInfo.TitleName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="单位">
                        <el-input v-model="accoutInfo.DeptName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="手机号" prop="Tel">
                        <el-input v-model="accoutInfo.Tel" placeholder="请输入手机号"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="邮箱" prop="email">
                        <el-input v-model="accoutInfo.email" placeholder="请输入邮箱"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <!-- 信息确认 -->
                <div v-if="active==1" class="house-info">
                  <el-row type="flex" justify="center" class="list-title">
                    <el-col :span="3">
                      <span>已有住房</span>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center" class="house-list">
                    <el-col :span="20">
                      <el-table :data="accoutInfo.listHouseGetApply" border class="table" height="string" v-loading="listLoading">
                        <el-table-column label="住房号" prop="houseNo"></el-table-column>
                        <el-table-column label="住房类型" prop="houseTypeName"></el-table-column>
                        <el-table-column label="住房地址" prop="houseAddress"></el-table-column>
                        <el-table-column label="住房面积" prop="houseBuildArea"></el-table-column>
                        <el-table-column label="使用面积" prop="houseUsedArea"></el-table-column>
                        <el-table-column label="产权关系" prop="houseRelName"></el-table-column>
                      </el-table>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center" class="list-title">
                    <el-col :span="3">
                      <span>已申请信息</span>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center" class="apply-list">
                    <el-col :span="20">
                      <el-table :data="accoutInfo.array" border class="table" height="string" v-loading="listLoading">
                        <el-table-column label="职工号" align="center" prop="staffNo"></el-table-column>
                        <el-table-column label="申请号" align="center" prop="id"></el-table-column>
                        <el-table-column label="职工积分" align="center" prop="totalVal"></el-table-column>
                        <el-table-column label="处理情况" align="center" prop="hireState"></el-table-column>
                      </el-table>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center" class="remark">
                    <el-col :span="20">
                      <span>如有疑问，请联系单位管理员</span>
                    </el-col>
                  </el-row>
                </div>
                <!-- 维修填写区域 -->
                <div v-if="active==2" class="hire-reason">
                  <el-row type="flex" justify="center">
                    <el-col :span="20">
                      <el-form-item label="申请原因" prop="reason">
                        <el-input v-model="accoutInfo.reason" type="textarea" style="width:600px" :rows="6" placeholder="请详细说明您的住房困难及需求，谢谢！">
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </div>
                <div v-if="active==3" class="apply-result" v-loading="listLoading">
                  <div class="tool">
                    <el-button type="primary" @click="downloadApply">导出申请单</el-button>
                  </div>
                  <span>{{resMessage}}</span>
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
import { getStaffHireInfo, postHireApply } from "@/api/online";
import { checkTel } from "@/assets/function/validator";
import utils from "@/utils/index.js";
import { MessageBox } from "element-ui";
import router from "../../router";
export default {
  data() {
    return {
      listLoading: false,
      // 进度信息
      active: 0,
      // 个人信息填充
      accoutInfo: {},
      //表单验证规则
      //表单验证规则
      rules: {},
      // 信息确认区域
      listLoading: [],
      resMessage: ""
    };
  },
  created() {
    this.getList();
  },
  methods: {
    // 获取个人信息
    getList() {
      this.listLoading = true;
      let staffID = this.$store.getters.userID;
      let param = {};
      getStaffHireInfo(param, staffID)
        .then(res => {
          if (res.data.status == "error") {
            MessageBox.confirm(
              "你已购买或租赁政策性住房，无法再次申请",
              "警告",
              {
                confirmButtonText: "确认",
                cancelButtonText: "取消",
                type: "warning"
              }
            ).then(() => {
              router.go(-1);
            });
          } else {
            this.accoutInfo = res.data.data.data;
            let array = [];
            if (this.accoutInfo.hireApplyAlready) {
              array[0] = this.accoutInfo.hireApplyAlready;
            }
            this.accoutInfo.array = array;
            this.listLoading = false;
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 导出申请单
    downloadApply() {
      let staffID = this.$store.getters.userID;
      window.location.href = `http://172.16.65.105:8080/whutHouseMgmtReposity/exportToWord/hire/${staffID}`;
    },
    // 前进一步
    nextButton() {
      let vaild = true;
      if (this.active++ > 2) this.active = 0;
    },
    // 返回一步
    backButton() {
      this.active--;
    },
    // 提交住房申请
    addSubmit() {
      this.active++;
      this.listLoading = true;
      this.$refs["hireApplyForm"].validate(valid => {
        if (valid) {
          let applyForm = {
            reason: this.accoutInfo.reason,
            email: this.accoutInfo.email,
            phone: this.accoutInfo.Tel,
            staffId: this.$store.getters.userID
          };
          postHireApply(applyForm).then(res => {
            this.resMessage = res.data.message;
            //utils.statusinfo(this, res.data);
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
.second-container {
  background-color: $background-grey;
  & .apply-from {
    width: 80%;
    background-color: $white;
    padding: 50px;
    height: 80vh;
    margin: auto;
    position: relative;
    & .personal-info {
      padding-top: 3%;
      margin-bottom: 5vh;
    }
    & .house-info {
      // padding-top: 20px;
      margin-bottom: 5vh;
      position: relative;
      & .list-title {
        padding: 2vh;
        font-size: 14px;
        font-weight: 700;
      }
      & .house-list {
        height: 23vh;
      }
      & .remark {
        padding-top: 10px;
        font-size: 12px;
      }
    }
    & .hire-reason {
      padding-top: 12vh;
      margin-bottom: 5vh;
      & .remark {
        padding-left: 100px;
        font-size: 12px;
        color: red;
      }
    }
    & .apply-result {
      margin: 150px auto 100px;
      position: relative;
      width: 500px;
      text-align: center;
      & > span {
        font-size: 22px;
      }
      & > .tool{
        position: absolute;
        right: 200px;
        top:150px;
      }
    }
    & .opera-area {
      position: absolute;
      bottom: 7%;
      left: 0;
      right: 0;
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-content: space-around;
    }
  }
}
</style>
