<template>
  <div class="second-container">
    <staffIndex @emit-staff="getStaff"></staffIndex>
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>租赁管理</el-breadcrumb-item>
            <el-breadcrumb-item>租赁直批</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar card">
            <el-row>
              <el-col :span="4" :offset="1">
                <el-input v-model="query" placeholder="输入职工姓名或id搜索"></el-input>
              </el-col>
              <el-col :span="1" :offset="1">
                <el-button type="primary" @click="queryMethod">查询</el-button>
              </el-col>
              <el-col :span="1" :offset="1">
                <el-button type="primary">重置</el-button>
              </el-col>
            </el-row>
          </div>
          <div class="main-data">
            <!-- 表格区 -->
            <el-row class="personal-info">
              <el-col :span="8" class="col card">
                <personal-info-table @select-staff="getPropsStaff" :query-data="queryData"></personal-info-table>
              </el-col>
              <el-col :span="15" class="col card" style="margin-left:20px">
                <house-rel></house-rel>
              </el-col>
            </el-row>
            <!-- 表单区域 -->
            <div class="super-form card">
              <el-form :model="hireSuperForm" label-width="100px" ref="hireSuperForm" v-loading="listLoading">
                <el-row>
                  <el-col :span="8" :offset="2">
                    <el-form-item label="职工姓名">
                      <el-input v-model="hireSuperForm.staffName" readonly placeholder="请选择职工"></el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="17" :offset="2">
                    <el-form-item label="住房分配">
                      <el-input v-model="hireSuperForm.houseName" size="small" readonly placeholder="请选择住房">
                        <el-button slot="append" icon="el-icon-search" @click="dialogVisible"></el-button>
                      </el-input>
                    </el-form-item>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="10" :offset="2">
                    <el-form-item label="登记说明" prop="directApplyNote">
                      <el-input v-model="hireSuperForm.directApplyNote" type="textarea" :rows="2" placeholder="请输入备注说明（可选）"></el-input>
                    </el-form-item>
                  </el-col>
                  <el-col :span="5" :offset="2">
                    <el-button type="primary" @click="hireSuperSubmit">提交</el-button>
                  </el-col>
                </el-row>
              </el-form>
            </div>
          </div>
        </div>
        <seach-house @select-house="selectHouse"></seach-house>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import staffIndex from "@/views/fixManage/components/staffIndex";
  import personalInfoTable from "@/views/fixManage/components/personalInfoTable";
  import seachHouse from "@/views/tools/seachHouse";
  import houseRel from "@/views/fixManage/components/houseRel";
  import {
    putHireSuper,
    postHireEmail
  } from "@/api/leaseManage";
  import utils from "@/utils/index.js";
  export default {
    data() {
      return {
        // 查询需要相关的
        propQuery: "",
        query: "",
        queryData: {
          param: "",
          type: ""
        },
        // 直批表单
        listLoading: false,
        hireSuperForm: {},
        selectHouseId: ""
      };
    },
    components: {
      staffIndex,
      personalInfoTable,
      houseRel,
      seachHouse
    },
    watch: {
      propQuery(newVal) {
        if (typeof newVal == "number") {
          this.queryData.param = newVal;
          this.queryData.type = 0;
        } else {
          this.queryData.param = newVal;
          this.queryData.type = 1;
        }
      }
    },
    methods: {
      // 从组件获取id
      getStaff(object) {
        this.propQuery = object.id;
      },
      // 页面查询方法
      queryMethod() {
        this.propQuery = this.query;
      },
      getPropsStaff(selectStaff) {
        this.$set(this.hireSuperForm, "staffName", selectStaff.name);
        this.hireSuperForm.staffId = selectStaff.id;
      },
      // 从组件中传递
      selectHouse(data) {
        this.$set(this.hireSuperForm, "houseName", data[0]);
        this.selectHouseId = data[1];
      },
      // 租赁直批提交
      hireSuperSubmit() {
        this.listLoading = true;
        let name = this.hireSuperForm.staffName;
        const postData = {
          directApplyMan: this.$store.getters.userName,
          directApplyNote: this.hireSuperForm.directApplyNote,
          houseId: this.selectHouseId,
          staffId: this.hireSuperForm.staffId
        };
        putHireSuper(postData).then(res => {
          let params = {
            hireId: this.hireSuperForm.id
          };
          postHireEmail(params).catch(err => {
            // console.log(err);
          });
          utils.statusinfo(this, res.data);
          this.listLoading = false;
          if (res.data.status == "success") {
            this.hireSuperForm= {};
            this.$set(this.hireSuperForm, "staffName", name);
          }
        });
      },
      dialogVisible() {
        this.$store.dispatch("setSeachHouse", true);
      }
    }
  };

</script>

<style scoped lang="scss">
  @import "../../styles/variables.scss";

  .second-container {
    background-color: $background-grey;
    .toolbar {
      padding: 10px;
    }
    .main-data {
      &>.personal-info {
        height: 33vh;
        &>.col {
          height: 100%;
          overflow: auto;
        }
      }
      &>.super-form {
        margin: 30px auto 20px;
        padding-top: 20px;
        height: 32vh;
      }
    }
  }

</style>
