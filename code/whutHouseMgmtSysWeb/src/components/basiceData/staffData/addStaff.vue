<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>职工管理</el-breadcrumb-item>
        <el-breadcrumb-item>新增职工</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" @click="addSubmit">提交</el-button>
          <el-button type="primary" @click="routerBack">返回</el-button>
        </el-form>
      </div>
      <!-- 表单区 -->
      <div class="main-data">
        <!-- 两个表单的大盒子 -->
        <div class="from">
          <el-form :model="staffForm" label-width="110px" ref="staffForm" :rules="rules">
            <h1>员工本人信息</h1>
            <!-- 员工信息 -->
            <div class="staff-from">
              <!-- 左半边的信息 -->
              <div class="single-staff-from">
                <el-form-item label="职工编号" prop="no">
                  <el-input v-model="staffForm.no" placeholder="请输入职工编号"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                  <el-input v-model="staffForm.name" placeholder="请输入姓名"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="sex">
                  <el-select v-model="staffForm.sex" placeholder="请选择性别">
                    <el-option v-for="sex in formOption.sexOption" :key="sex.value" :label="sex.label" :value="sex.value"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="婚姻状况" prop="marriageState">
                  <el-select v-model="staffForm.marriageState" placeholder="请选择婚姻状况">
                    <el-option v-for="state in formOption.marriageState" :key="state.value" :label="state.label" :value="state.value"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="身份证号" prop="code">
                  <el-input v-model="staffForm.code" placeholder="请输入身份证号"></el-input>
                </el-form-item>
                <el-form-item label="联系电话" prop="tel">
                  <el-input v-model="staffForm.tel" placeholder="请输入联系电话"></el-input>
                </el-form-item>
              </div>
              <!-- 中间信息 -->
              <div class="single-staff-from">
                <el-form-item label="职称" prop="titleName">
                  <el-select v-model="staffForm.titleName" clearable placeholder="请选择职称">
                    <el-option v-for="param in staffParam[7]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="职务" prop="postName">
                  <el-select v-model="staffForm.postName" clearable placeholder="请选择职务">
                    <el-option v-for="param in staffParam[6]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="职工类别" prop="typeName">
                  <el-select v-model="staffForm.typeName" clearable placeholder="请选择职工类别">
                    <el-option v-for="param in staffParam[8]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="工作状态" prop="statusName">
                  <el-select v-model="staffForm.statusName" clearable placeholder="请选择工作状态">
                    <el-option v-for="param in staffParam[9]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="工作部门" prop="deptName">
                  <el-select v-model="staffForm.deptName" clearable filterable placeholder="请选择工作部门">
                    <el-option v-for="param in staffParam[5]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="优惠比例" prop="discountRate">
                  <el-input v-model="staffForm.discountRate" placeholder="请输入优惠比例">
                  </el-input>
                </el-form-item>
              </div>
              <!-- 右半边的信息 -->
              <div class="single-staff-from">
                <el-form-item label="上大学时间" prop="goUniversityTime">
                  <el-date-picker v-model="staffForm.goUniversityTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="参加工作时间" prop="joinTime">
                  <el-date-picker v-model="staffForm.joinTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="来校工作时间" prop="firstJobTime">
                  <el-date-picker v-model="staffForm.firstJobTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="离退休时间" prop="retireTime">
                  <el-date-picker v-model="staffForm.retireTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="购房款" prop="buyAccount">
                  <el-input v-model="staffForm.buyAccount" placeholder="请输入购房款">
                  </el-input>
                </el-form-item>
                <el-form-item label="维修基金" prop="fixFund">
                  <el-input v-model="staffForm.fixFund" placeholder="请输入维修基金">
                  </el-input>
                </el-form-item>
              </div>
            </div>
            <div class="tittle">
              <h1>配偶信息</h1>
            </div>
            <!-- 员工配偶的信息 -->
            <div class="staff-from">
              <!-- 右半边的信息 -->
              <div class="single-staff-from">
                <el-form-item label="姓名" prop="spouseName">
                  <el-input v-model="staffForm.spouseName" placeholder="请输入配偶姓名"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="spouseCode">
                  <el-input v-model="staffForm.spouseCode" placeholder="请输入身份证号"></el-input>
                </el-form-item>
              </div>
              <div class="single-staff-from">
                <el-form-item label="单位性质">
                  <el-select v-model="staffForm.spouseKind" placeholder="请选择职称">
                    <el-option v-for="param in staffParam[10]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="工作部门">
                  <el-input v-model="staffForm.spouseDept" placeholder="请输入工作部门"></el-input>
                </el-form-item>
              </div>
              <div class="single-staff-from">
                <el-form-item label="职称">
                  <el-select v-model="staffForm.spouseTitleName" placeholder="请选择职称">
                    <el-option v-for="param in staffParam[7]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
                <el-form-item label="职务">
                  <el-select v-model="staffForm.spousePostName" placeholder="请选择职务">
                    <el-option v-for="param in staffParam[6]" :key="param.staffParamId" :label="param.staffParamName" :value="param.staffParamId"></el-option>
                  </el-select>
                </el-form-item>
              </div>
            </div>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {
    getStaffParam,
    postStaffData
  } from "@/api/api";
  import {
    checkNum,
    checkNULL,
    checkTel
  } from "@/assets/function/validator";
  import * as OPTION from "@/assets/data/formOption";
  import common from "@/common/util.js";
  export default {
    data() {
      return {
        // 表单需要的信息
        staffForm: {},
        listLoading: false,
        // 一些不需要后台获取的静态数据
        formOption: OPTION,
        // 编辑时候需要填充的数据
        staffParam: [],
        // 表单验证规则
        rules: {
          no: [{
              required: true,
              message: "请输入职工编号",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          name: {
            required: true,
            message: "请输入姓名",
            trigger: "blur"
          },
          sex: {
            required: true,
            message: "请选择",
            trigger: "blur"
          },
          marriageState: {
            required: true,
            message: "请选择",
            trigger: "blur"
          },
          code: [{
              required: true,
              message: "请输入身份证号",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          tel: [{
              required: true,
              message: "请输入手机号",
              trigger: "blur"
            },
            {
              validator: checkTel,
              trigger: "blur"
            }
          ],
          buyAccount: {
            validator: checkNum,
            trigger: "blur"
          },
          spouseCode: {
            validator: checkNum,
            trigger: "blur"
          },
          titleName: {
            required: true,
            message: "请选择职称",
          },
          postName: {
            required: true,
            message: "请选择职务",
          },
          typeName: {
            required: true,
            message: "请选择类别",
          },
          statusName: {
            required: true,
            message: "请选择工作状态",
          },
          deptName: {
            required: true,
            message: "请选择工作部门",
          }
        }
      };
    },
    // 监听
    watch: {},
    created() {
      this.getParam();
    },
    // 方法集合
    methods: {
      // 编辑时候需要获取的数据
      getParam() {
        if (this.staffParam[5] != null) return;
        this.submitLoading = true;
        let param,
          // 职工时候是5-10
          paramNum = 10;
        for (let paramClass = 5; paramClass <= paramNum; paramClass++) {
          getStaffParam(param, paramClass)
            .then(res => {
              //console.log(res.data.data);
              this.staffParam[paramClass] = res.data.data.data.list;
              //console.log(this.staffParam)
              if (this.staffParam[10] != null) this.submitLoading = false;
            })
            .catch(err => {
              console.log(err);
            });
        }
      },
      // 新增提交
      addSubmit() {
        this.$confirm("此操作新增职工", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.$refs["staffForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              let param = Object.assign({}, this.staffForm);
              postStaffData(param).then(res => {
                common.statusinfo(this, res.data);
                this.detailLoading = false;
                if (res.data.status == "success")
                  this.$refs["staffForm"].resetFields();
              });
            }
          });
        });
      },
      // 路由返回
      routerBack() {
        this.$router.go(-1);
      }
    }
  };

</script>

<style scoped lang="scss">
  .main-data {
    position: relative;
    .from {
      position: absolute;
      top: 20px;
      bottom: 20px;
      left: 20px;
      right: 20px;
      display: flex;
      flex-direction: column;
      overflow-y: auto;
      border: 1px solid black;
      .el-select {
        display: inline-block;
        position: relative;
        width: 205px;
      } // 员工主表
      h1 {
        margin-left: 10px;
      }
      .staff-from {
        margin: 10px auto 0px;
        display: flex;
        flex-direction: row;
        .single-staff-from {
          margin-left: 2px;
          margin-right: 2px;
          padding-top: 10px;
          border: 1px solid black;
          align-items: center;
          width: 33.3%; //margin: 10px;
          display: flex;
          flex-direction: column;
          flex: 1;
        }
      } // 员工配偶表单
      .staff-spouse-from {
        flex: 1;
      }
    }
  }

</style>
