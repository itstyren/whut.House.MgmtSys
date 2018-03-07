<template>
  <div class="second-container">
    <indexNav :hire-status="hireStatus" :is-submit="isSubmit" @emit-form="getList"></indexNav>
    <section class="main-container">
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
          <div class="toolbal">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="accept-form card">
              <div class="need-accept">
                <h1>租赁审核单</h1>
                <el-form :model="agreeForm" label-width="100px" ref="agreeForm" :rules="rules">
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="agreeForm.name" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="agreeForm.applyTime" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="agreeForm.phone" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="工作部门">
                        <el-input v-model="agreeForm.deptName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="agreeForm.postName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="agreeForm.titleName" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="5" :offset="1">
                      <el-form-item label="职称分">
                        <el-input v-model="agreeForm.titleVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="职务分">
                        <el-input v-model="agreeForm.titleVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="配偶分">
                        <el-input v-model="agreeForm.spouseVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="其他分">
                        <el-input v-model="agreeForm.otherVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="5" :offset="1">
                      <el-form-item label="总得分">
                        <el-input v-model="agreeForm.totalVal" size="small" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="受理人">
                        <el-input v-model="agreeForm.acceptMan" size="small" readonly placeholder="受理人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="受理状态">
                        <el-input v-model="agreeForm.acceptState" size="small" readonly placeholder="状态未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="5">
                      <el-form-item label="受理时间">
                        <el-input v-model="agreeForm.acceptTime" size="small" readonly placeholder="受理时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="!agreeState" :class="{'is-agree':!agreeState}">
                    <el-col :span="9" :offset="1">
                      <el-form-item label="受理说明">
                        <el-input v-model="agreeForm.acceptNote" type="textarea" :rows="2" placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="agreeState">
                    <el-col :span="7" :offset="1">
                      <el-form-item label="审核人">
                        <el-input v-model="agreeForm.agreeMan" readonly placeholder="审核人未知"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="审核时间">
                        <el-input v-model="agreeForm.agreeTime" readonly placeholder="审核时间未知"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <!-- 操作区域 -->
                  <el-row type="flex" justify="start" v-if="!agreeState">
                    <el-col :span="16" :offset="1">
                      <el-form-item label="住房分配" prop="agreeState">
                        <el-input v-model="agreeForm.houseName" size="small" readonly placeholder="请选择住房">
                          <el-button slot="append" icon="el-icon-search" @click="dialogVisible=!dialogVisible"></el-button>
                        </el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row type="flex" justify="start" v-if="!agreeState">
                    <el-col :span="8" :offset="1">
                      <el-form-item label="审核意见" prop="agreeNote">
                        <el-input v-model="agreeForm.agreeNote" type="textarea" :rows="2" placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="6">
                      <el-form-item label="审核状态" prop="agreeState">
                        <el-switch v-model="agreeForm.agreeState" active-color="#ff4949" inactive-color="#13ce66" active-text="拒绝" active-value="拒绝"
                          inactive-text="通过" inactive-value="通过"></el-switch>
                      </el-form-item>
                    </el-col>
                    <el-col :span="1">
                      <el-button type="primary" @click="agreeSubmit">提交</el-button>
                    </el-col>
                  </el-row>
                  <!-- 非操作区域 -->
                  <el-row v-if="agreeState">
                    <el-col :span="7" :offset="1">
                      <el-form-item label="审核意见">
                        <el-input v-model="agreeForm.agreeNote" type="textarea" :rows="2" placeholder="请输入受理意见"></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row v-if="agreeState">
                    <el-col :span="7" :offset="1">
                      <el-form-item label="审核状态">
                        <el-switch v-model="agreeForm.agreeState" active-color="#ff4949" inactive-color="#13ce66" active-text="拒绝" active-value="拒绝"
                          inactive-text="通过" inactive-value="通过" :disabled="agreeState"></el-switch>
                      </el-form-item>
                    </el-col>
                  </el-row>
                </el-form>
              </div>
            </div>
          </div>
        </div>
        <seach-house :select-form-visible="dialogVisible" @select-house="selectHouse"></seach-house>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import indexNav from "./components/indexNav";
import seachHouse from "@/views/tools/seachHouse";
import { putHireAccept } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data() {
    return {
      listLoading: false,
      agreeForm: {},
      agreeState: false,
      hireStatus: "agree",
      isSubmit: false,
      selectHouseId:'',
      houseName:'',
      // 表单验证规则
      rules: {
        acceptNote: {
          required: true,
          message: "请输入受理意见",
          trigger: "blur"
        }
      },
      dialogVisible: false
    };
  },
  // 注册组件
  components: {
    seachHouse,
    indexNav
  },
  computed: {
    totalVal: function() {
      return (
        parseInt(this.agreeForm.otherVal) + parseInt(this.agreeForm.titleVal)
      );
    }
  },
  methods: {
    // 从子组件获取
    getList(object) {
      this.agreeForm = object.content;
      this.agreeForm.otherVal = 0;
      this.agreeState = object.status;
    },
    // 受理信息提交
    agreeSubmit() {
      if (this.agreeForm.acceptState == null)
        this.agreeForm.acceptState = "通过";
      this.$confirm("确认通过审核", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["agreeForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let agreeForm = this.agreeForm;
              let param = {
                acceptMan: agreeForm.name,
                acceptNote: agreeForm.acceptNote,
                acceptState: agreeForm.acceptState,
                id: agreeForm.id,
                otherVal: agreeForm.otherVal,
                spouseVal: agreeForm.spouseVal,
                timeVal: agreeForm.timeVal,
                titleVal: agreeForm.titleVal,
                totalVal: this.totalVal
              };
              putHireAccept(param).then(res => {
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
          this.$message({
            type: "info",
            message: "已取消审核"
          });
        });
    },
    // 从组件中传递
    selectHouse(houseData, houseId) {
      this.agreeForm.houseName  = houseData;
      this.selectHouseId=houseId
      console.log(this.agreeForm.houseName)
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
      height: 90%;
      margin: auto;
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
