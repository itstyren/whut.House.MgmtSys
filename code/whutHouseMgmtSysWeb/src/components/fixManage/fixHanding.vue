<template>
  <div class="second-container">
    <indexNav @emit-form="getList"></indexNav>
    <section class="main-container">
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
          <div class="toolbal">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="accept-form card">
              <div class="need-accept">
                <h1>维修受理单</h1>
                <el-form :model="acceptForm" label-width="100px" ref="acceptForm" :rules="rules">
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="维修类型">
                        <el-input v-model="acceptForm.fixContentName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="申请时间">
                        <el-input v-model="acceptForm.applyTime" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="acceptForm.staffName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="联系电话">
                        <el-input v-model="acceptForm.phone" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="职称">
                        <el-input v-model="acceptForm.postName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="职务">
                        <el-input v-model="acceptForm.titleName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="acceptForm.deptName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="10">
                      <el-form-item label="住房地址">
                        <el-input v-model="acceptForm.staffAddress" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="维修描述">
                        <el-input v-model="acceptForm.description" type="textarea" :rows="2" readonly placeholder="无额外描述"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row>
                    <el-col :span="10" :offset="1">
                      <el-form-item label="受理意见" prop="acceptNote">
                        <el-input v-model="acceptForm.acceptNote" type="textarea" :rows="2" placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="8" :offset="1">
                      <el-form-item label="审核状态">
                        <el-switch v-model="acceptForm.acceptState" active-color="#ff4949" inactive-color="#13ce66" active-text="拒绝" active-value="拒绝" inactive-text="通过" inactive-value="通过"></el-switch>
                      </el-form-item>
                    </el-col>
                    <el-col :span="8">
                      <el-button type="primary" v-if="!acceptStatus" @click="acceptSubmit">提交</el-button>
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
import { putFixAccept } from "@/api/api";
import indexNav from "./components/indexNav";
import { checkNum, checkNULL, checkTel } from "@/assets/function/validator";
import common from "@/common/util.js";
export default {
  data() {
    return {
      listLoading: false,
      acceptForm: {},
      acceptStatus: false,
      // 表单验证规则
      rules: {
        acceptNote: {
          required: true,
          message: "请输入审核意见",
          trigger: "blur"
        }
      }
    };
  },
  components: {
    indexNav
  },
  methods: {
    getList(object) {
      this.acceptForm = object.content;
      this.acceptStatus = object.status;
    },
    // 维修受理提交
    acceptSubmit() {
      if (!this.acceptForm.hasOwnProperty("acceptStatus"))
        this.acceptForm.acceptStatus = "通过";
      this.$confirm("确认通过审核", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["acceptForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let acceptForm = this.acceptForm;
              let param = {
                acceptMan: acceptForm.staffName,
                acceptNote: acceptForm.acceptNote,
                acceptState: acceptForm.acceptStatus,
                id: acceptForm.id
              };
              putFixAccept(param).then(res => {
                common.statusinfo(this, res.data);
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
            message: "已取消审核"
          });
        });
    }
  }
};
</script>

<style scoped lang="scss">
.main-data {
  padding-top: 20px;
}

.accept-form {
  width: 80%;
  background-color: #fff;
  padding: 10px;
  padding-bottom: 30px;
  height: 90%;
  margin: auto;
  position: relative;
  .need-accept {
    h1 {
      text-align: center;
      margin-bottom: 30px;
    }
  }
}
</style>
