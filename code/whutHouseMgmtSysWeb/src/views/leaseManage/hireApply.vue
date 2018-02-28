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
          <div class="toolbal">
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
                            <el-form :model="accoutInfo" label-width="100px" inline ref="hireApplyForm" :rules="rules">
                <!-- 个人信息区域 -->
                                <div v-if="active==0" class="personal-info">
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职工号">
                        <el-input v-model="accoutInfo.staffNo" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="姓名">
                        <el-input v-model="accoutInfo.staffName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="身份证号">
                        <el-input v-model="accoutInfo.staffCode" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="性别">
                        <el-input v-model="accoutInfo.staffSex" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="职务">
                        <el-input v-model="accoutInfo.staffPostName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="单位">
                        <el-input v-model="accoutInfo.staffDeptName" :readonly="true"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="center">
                    <el-col :span="10">
                      <el-form-item label="手机号" prop="tel">
                        <el-input v-model="accoutInfo.staffTel" placeholder="请输入手机号"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="邮箱" prop="email">
                        <el-input v-model="accoutInfo.email" placeholder="请输入邮箱"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
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
import {getStaffHireInfo} from "@/api/api";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      listLoading: false,
      // 进度信息
      active: 0,
      // 个人信息填充
      accoutInfo: {},
      //表单验证规则
      rules: {}
    };
  },
  created() {
    this.getList()
  },
  methods: {
    // 获取个人信息
    getList() {
      this.listLoading = true;
      let staffId = 1;
      let param = {};
      getStaffHireInfo(staffId, param)
        .then(res => {
          this.accoutInfo = res.data.data.data;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
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
    height: 80%;
    margin: auto;
    position: relative;
    & .personal-info {
      padding-top: 3%;
      margin-bottom: 5vh;
    }
  }
}
</style>
