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
        <el-breadcrumb-item :to="{ path: `/basic/staff/byDept/${staffForm.deptName}` }">{{breadcrumbDeptName}}</el-breadcrumb-item>
        <el-breadcrumb-item>职工</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-form :inline="true"
                 style="margin-bottom:15px">
          <el-button type="primary"
                     @click="addSubmit">提交</el-button>
          <el-button type="primary"
                     @click="routerBack">返回</el-button>
        </el-form>
      </div>
      <!-- 表单区 -->
      <div class="main-data">
        <!-- 两个表单的大盒子 -->
        <div class="from card">
          <el-form :model="staffForm"
                   label-width="110px"
                   ref="staffForm"
                   :rules="rules">
            <div class="title">
              <strong>员工本人信息</strong>
            </div>
            <!-- 员工信息 -->
            <div class="staff-form">
              <!-- 第一行表单 -->
              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职工编号"
                                prop="no">
                    <el-input v-model="staffForm.no"
                              placeholder="请输入职工编号"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职称">
                    <el-select v-model="staffForm.title"
                               clearable
                               placeholder="请选择职称">
                      <el-option v-for="param in staffParam[7]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="上大学时间"
                                prop="goUniversityTime">
                    <el-date-picker v-model="staffForm.goUniversityTime"
                                    placeholder="请选择日期"
                                    format="yyyy-MM-dd"
                                    value-format="yyyy-MM-dd"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第二行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="姓名"
                                prop="name">
                    <el-input v-model="staffForm.name"
                              placeholder="请输入姓名"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职务"
                                prop="post">
                    <el-select v-model="staffForm.post"
                               clearable
                               placeholder="请选择职务">
                      <el-option v-for="param in staffParam[6]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="参加工作时间"
                                prop="joinTime">
                    <el-date-picker v-model="staffForm.joinTime"
                                    placeholder="请选择日期"
                                    format="yyyy-MM-dd"
                                    value-format="yyyy-MM-dd"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第三行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="性别"
                                prop="sex">
                    <el-select v-model="staffForm.sex"
                               placeholder="请选择性别">
                      <el-option v-for="sex in formOption.sexOption"
                                 :key="sex.value"
                                 :label="sex.label"
                                 :value="sex.value"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职工类别"
                                prop="type">
                    <el-select v-model="staffForm.type"
                               clearable
                               placeholder="请选择职工类别">
                      <el-option v-for="param in staffParam[8]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="来校工作时间"
                                prop="firstJobTime">
                    <el-date-picker v-model="staffForm.firstJobTime"
                                    placeholder="请选择日期"
                                    format="yyyy-MM-dd"
                                    value-format="yyyy-MM-dd"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第四行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="婚姻状况"
                                prop="marriageState">
                    <el-select v-model="staffForm.marriageState"
                               placeholder="请选择婚姻状况">
                      <el-option v-for="state in formOption.marriageState"
                                 :key="state.value"
                                 :label="state.label"
                                 :value="state.value"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="工作状态"
                                prop="status">
                    <el-select v-model="staffForm.status"
                               clearable
                               placeholder="请选择工作状态">
                      <el-option v-for="param in staffParam[9]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="离退休时间"
                                prop="retireTime">
                    <el-date-picker v-model="staffForm.retireTime"
                                    placeholder="请选择日期"
                                    format="yyyy-MM-dd"
                                    value-format="yyyy-MM-dd"></el-date-picker>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第五行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="身份证号"
                                prop="code">
                    <el-input v-model="staffForm.code"
                              placeholder="请输入身份证号"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="工作部门"
                                prop="dept">
                    <el-select v-model="staffForm.dept"
                               clearable
                               placeholder="请选择工作部门"
                               @change="handleDeptSelectionChange">
                      <el-option v-for="param in staffParam[5]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="购房款"
                                prop="buyAccount">
                    <el-input v-model="staffForm.buyAccount"
                              placeholder="请输入购房款"></el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第六行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="联系电话"
                                prop="tel">
                    <el-input v-model="staffForm.tel"
                              placeholder="请输入联系电话"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="优惠比例"
                                prop="discountRate">
                    <el-input v-model="staffForm.discountRate"
                              placeholder="请输入优惠比例">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="维修基金"
                                prop="fixFund">
                    <el-input v-model="staffForm.fixFund"
                              placeholder="请输入维修基金">
                    </el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第七行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">

                  <el-form-item label="所属用户组"
                                prop="roleId">
                    <el-select v-model="staffForm.roleId"
                               clearable
                               placeholder="请选择角色组">
                      <el-option v-for="param in RoleIDs"
                                 :key="param.id"
                                 :label="param.groupName"
                                 :value="param.id"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
            <div class="title">
              <strong>配偶信息</strong>
            </div>
            <!-- 员工配偶的信息 -->
            <div class="staff-form">
              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="姓名"
                                prop="spouseName">
                    <el-input v-model="staffForm.spouseName"
                              :readonly="isCampus"
                              placeholder="请输入姓名">
                      <el-button v-if="isCampus"
                                 slot="append"
                                 icon="el-icon-search"
                                 @click="searchStaffDiaVisible=true">
                      </el-button>
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="单位性质"
                                prop="spouseKind">
                    <el-select v-model="staffForm.spouseKind"
                               @change="hanleSpouseKindSelect"
                               placeholder="请选择单位性质">
                      <el-option v-for="param in staffParam[10]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职称"
                                prop="spouseTitle">
                    <el-input v-model="staffForm.spouseTitleName"
                              v-if="isCampus"
                              :readonly="true"></el-input>
                    <el-select v-model="staffForm.spouseTitle"
                               clearable
                               v-if="!isCampus"
                               placeholder="请选择职称">
                      <el-option v-for="param in staffParam[7]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="身份证号"
                                prop="spouseCode">
                    <el-input v-model="staffForm.spouseCode"
                              :readonly="isCampus"
                              placeholder="请输入身份证号"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="工作部门">
                    <el-input v-model="staffForm.spouseDept"
                              :readonly="isCampus"
                              placeholder="请输入工作部门"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职务"
                                prop="spousePost">
                    <el-input v-model="staffForm.spousePostName"
                              v-if="isCampus"
                              :readonly="true"></el-input>
                    <el-select v-model="staffForm.spousePost"
                               clearable
                               v-if="!isCampus"
                               placeholder="请选择职务">
                      <el-option v-for="param in staffParam[6]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
            </div>
          </el-form>
        </div>
      </div>
    </div>
    <!-- 多条件检索员工 -->
    <search-staff-dialog :show.sync="searchStaffDiaVisible"
                         @select-one-staff="handleSelectOneStaff"> </search-staff-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import { postStaffData } from "@/api/basiceData";
import { getStaffParam } from "@/api/sysManage";
import { getPartAuthList } from '@/api/auth'
import { checkNum, checkNULL, checkTel } from "@/assets/function/validator";
import * as OPTION from "@/assets/data/formOption";
import utils from "@/utils/index.js";
import SearchStaffDialog from './searchStaffDialog.vue'

export default {
  components: {
    SearchStaffDialog
  },
  data () {
    return {
      // 表单需要的信息
      staffForm: {},
      listLoading: false,
      // 一些不需要后台获取的静态数据
      formOption: OPTION,
      // 编辑时候需要填充的数据
      staffParam: [],
      // 用户组列表（id,groupName）
      RoleIDs: [],
      // 表单验证规则
      rules: {
        no: [
          {
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
        code: [
          {
            required: true,
            message: "请输入身份证号",
            trigger: "blur"
          },
          {
            validator: checkNum,
            trigger: "blur"
          }
        ],
        tel: [
          {
            required: true,
            message: "请输入手机号",
            trigger: "blur"
          },
          {
            validator: checkTel,
            trigger: "blur"
          }
        ],
        roleId: { required: true, message: '请选择所属用户组', trigger: 'blur' },
        buyAccount: {
          validator: checkNum,
          trigger: "blur"
        },
        spouseCode: {
          validator: checkNum,
          trigger: "blur"
        },
        title: {
          required: true,
          message: "请选择职称"
        },
        post: {
          required: true,
          message: "请选择职务"
        },
        type: {
          required: true,
          message: "请选择类别"
        },
        status: {
          required: true,
          message: "请选择工作状态"
        },
        dept: {
          required: true,
          message: "请选择工作部门"
        }
      },
      breadcrumbDeptName: '',
      // 配偶是否是校内
      isCampus: false,
      // 搜索职工对话框
      searchStaffDiaVisible: false,
    };
  },
  // 监听
  watch: {},
  created () {
    this.getParam();
    this.getRoleIdByAuthList()
  },
  // 方法集合
  methods: {
    // 工作部门下拉框选中值发生变化时，面包屑显示的工作部门名称
    handleDeptSelectionChange (deptId) {
      let deptList = this.staffParam[5]
      let selectDept = deptList.find((item) => {
        return item.staffParamId = deptId
      })
      this.breadcrumbDeptName = selectDept.staffParamName
    },
    // 编辑时候需要获取的数据
    getParam () {
      if (this.staffParam[5] != null) return;
      this.submitLoading = true;
      let param,
        // 职工时候是5-10
        paramNum = 10;
      for (let paramClass = 5; paramClass <= paramNum; paramClass++) {
        getStaffParam(param, paramClass)
          .then(res => {
            this.$set(this.staffParam, paramClass, res.data.data.data.list);
            if (this.staffParam[10] != null) this.submitLoading = false;
          })
          .catch(err => {
            console.log(err);
          });
      }
    },
    // 新增提交
    addSubmit () {
      this.$confirm("此操作新增职工", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$refs["staffForm"].validate(valid => {
          if (valid) {
            this.listLoading = true;
            if (this.staffForm.hasOwnProperty("familyCode") && this.isCampus) {
              delete this.staffForm.spouseName
              delete this.staffForm.spouseCode
              delete this.staffForm.spouseTitle
              delete this.staffForm.spouseDept
              delete this.staffForm.spousePost
              delete this.staffForm.spouseTitleName
              delete this.staffForm.spousePostName
            }
            let param = Object.assign({}, this.staffForm);
            postStaffData(param).then(res => {
              utils.statusinfo(this, res.data);
              this.detailLoading = false;
              if (res.data.status == "success")
                this.$refs["staffForm"].resetFields();
            });
          }
        });
      });
    },
    // 路由返回
    routerBack () {
      this.$router.go(-1);
    },
    // 获取用户组部分信息（id、groupName）
    getRoleIdByAuthList () {
      getPartAuthList().then(res => {
        this.RoleIDs = res.data.data.data
      }).catch(err => {
        this.$message.error(err)
      })
    },
    // 配偶信息中的单位性质下拉框选中值改变时
    hanleSpouseKindSelect (value) {
      let spouseKindList = this.staffParam[10]
      let staffParam = spouseKindList.find((item) => {
        return item.staffParamId == value
      })
      let spouseKind = staffParam.staffParamName
      if (spouseKind === '校内') {
        this.isCampus = true
      } else {
        this.isCampus = false
      }
    },
    // 获取配偶的信息，并进行填充
    handleSelectOneStaff (staff) {
      this.staffForm.familyCode = staff.id
      this.staffForm.spouseName = `${staff.no}-${staff.name}`
      this.staffForm.spouseCode = staff.code
      this.staffForm.spouseTitleName = staff.titleName
      this.staffForm.spouseDept = staff.deptName
      this.staffForm.spousePostName = staff.postName
    }
  }
};
</script>

<style scoped lang="scss">
.main-data {
  .from {
    margin-bottom: 40px;
    padding-bottom: 10px;
    display: flex;
    flex-direction: column;
    background-color: #fff;
    .el-select {
      display: inline-block;
      position: relative;
    } // 员工主表
    .title {
      padding: 20px 0 10px 20px;
      font-size: 1.3vw;
      font-weight: 400;
      position: relative;
      &::after {
        content: "";
        width: 95%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -2px;
        z-index: 1; //left: 5%;
        right: 2%;
      }
    }
    .staff-form {
      margin: 20px auto 0px;
    }
  }
}
</style>
