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
          <el-button v-if="!ismodify"
                     type="primary"
                     @click="modifyForm">编辑员工</el-button>
          <el-button v-if="!ismodify"
                     type="primary"
                     @click="routerBack">返回</el-button>
          <el-button v-if="ismodify"
                     type="primary"
                     @click="handleCancelEdit">取消编辑</el-button>
          <el-button v-if="ismodify"
                     type="primary"
                     @click="beforModify">提交</el-button>
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
                              :readonly="!ismodify"
                              placeholder="请输入职工编号"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职称">
                    <el-input v-model="staffForm.titleName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.titleName"
                               clearable
                               v-if="ismodify"
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
                  <el-form-item label="学历"
                                prop="goUniversityTime">
                    <el-input v-model="staffForm.eduQualifications"
                              :readonly="!ismodify"
                              placeholder="请输入学历"></el-input>
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
                              :readonly="!ismodify"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职务">
                    <el-input v-model="staffForm.postName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.postName"
                               clearable
                               v-if="ismodify"
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
                                    :disabled="!ismodify"
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
                    <el-input v-model="staffForm.sex"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.sex"
                               v-if="ismodify"
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
                  <el-form-item label="职工类别">
                    <el-input v-model="staffForm.typeName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.typeName"
                               clearable
                               v-if="ismodify"
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
                                    :disabled="!ismodify"
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
                    <el-input v-model="staffForm.marriageState"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.marriageState"
                               v-if="ismodify"
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
                  <el-form-item label="工作状态">
                    <el-input v-model="staffForm.statusName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.statusName"
                               clearable
                               v-if="ismodify"
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
                                    :disabled="!ismodify"
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
                              :readonly="!ismodify"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="工作部门">
                    <el-input v-model="staffForm.deptName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.deptName"
                               clearable
                               v-if="ismodify"
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
                  <el-form-item label="购买校内房"
                                prop="isOwnPriHouse">
                    <el-switch :class="{'is-own-wsitch':!staffForm.isOwnPriHouse}"
                               v-model="staffForm.isOwnPriHouse"
                               ctive-color="#13ce66a"
                               inactive-color="#ff4949"
                               active-text="是"
                               inactive-text="否"
                               :disabled="!ismodify">
                    </el-switch>
                    <el-button v-if="staffForm.isOwnPriHouse"
                               @click="checkHouse"
                               :class="{'is-own':staffForm.isOwnPriHouse}"
                               size="mini"
                               type="info">查看</el-button>
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
                              :readonly="!ismodify"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="邮箱"
                                prop="email">
                    <el-input v-model="staffForm.email"
                              :readonly="!ismodify">
                    </el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="货币化补偿金"
                                prop="compensate">
                    <el-input v-model="staffForm.compensate"
                              :readonly="!ismodify"
                              placeholder="无">
                    </el-input>
                  </el-form-item>
                </el-col>
              </el-row>
              <!-- 第七行表单 -->

              <el-row>
                <el-col :span="6"
                        :offset="1">

                  <el-form-item label="所属用户组"
                                prop="groupName">
                    <el-input v-model="staffForm.groupName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.roleId"
                               clearable
                               v-if="ismodify"
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
                              :readonly="!ismodify||isCampus">
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
                  <el-form-item label="单位性质">
                    <el-input v-model="staffForm.spouseKindName"
                              v-if="!ismodify"
                              :readonly="!ismodify"></el-input>
                    <el-select v-model="staffForm.spouseKindName"
                               @change="hanleSpouseKindSelect"
                               v-if="ismodify">
                      <el-option v-for="param in staffParam[10]"
                                 :key="param.staffParamId"
                                 :label="param.staffParamName"
                                 :value="param.staffParamId"></el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职称">
                    <el-input v-model="staffForm.spouseTitleName"
                              v-if="!ismodify||isCampus"
                              :readonly="!ismodify||isCampus"></el-input>
                    <el-select v-model="staffForm.spouseTitleName"
                               clearable
                               v-if="ismodify &&!isCampus"
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
                              :readonly="!ismodify ||isCampus"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="工作部门">
                    <el-input v-model="staffForm.spouseDept"
                              :readonly="!ismodify||isCampus"></el-input>
                  </el-form-item>
                </el-col>
                <el-col :span="6"
                        :offset="1">
                  <el-form-item label="职务">
                    <el-input v-model="staffForm.spousePostName"
                              v-if="!ismodify||isCampus"
                              :readonly="!ismodify||isCampus"></el-input>
                    <el-select v-model="staffForm.spousePostName"
                               clearable
                               v-if="ismodify&&!isCampus"
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
import { getStaff, putStaffData } from "@/api/basiceData";
import { getStaffParam } from "@/api/sysManage";
import { getPartAuthList } from '@/api/auth'
import { postPromoteSubStaffID } from "@/api/monetarySub";
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
      // 搜索职工对话框
      searchStaffDiaVisible: false,
      // 面包屑显示的工作部门的名称
      isCampus: false,
      breadcrumbDeptName: '',
      ismodify: false,
      // 表单需要的信息
      staffForm: {},
      oldStaffForm: {},
      listLoading: false,
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
            message: "请输入手机号码",
            trigger: "blur"
          },
          {
            validator: checkTel,
            trigger: "blur"
          }
        ],
        groupName: [
          { required: true, message: '请选择所属用户组', trigger: 'blur' }
        ],
        buyAccount: {
          validator: checkNum,
          trigger: "blur"
        },
        spouseCode: {
          validator: checkNum,
          trigger: "blur"
        }
      }
    };
  },
  computed: {
    store_ismodify () {
      return this.$store.state.staffModify;
    },
  },
  // 监听
  watch: {
    $route () {
      this.getList();
      if (this.store_ismodify == false) {
        this.ismodify = false;
      } else {
        this.ismodify = true;
        this.getParam();
      }
    },
    oldStaffForm: {
      handler: function (newVal) {
      },
      deep: true
    },
    store_ismodify (newVal) {
      if (newVal == false) {
        this.ismodify = false;
      } else {
        this.ismodify = true;
        this.getParam();
      }
    }
  },
  created () {
    if (this.store_ismodify == false) {
      this.ismodify = false;
    } else {
      this.ismodify = true;
      this.getParam();
    }
    this.getList();
    this.getRoleIdByAuthList()
  },
  // 方法集合
  methods: {
    // 工作部门下拉框选中值发生变化时，面包屑显示的工作部门名称
    handleDeptSelectionChange (deptId) {
      let deptList = this.staffParam[5]
      let selectDept = deptList.find((item) => {
        return item.staffParamId == deptId
      })
      this.breadcrumbDeptName = selectDept.staffParamName
    },
    // 获取列表
    getList () {
      let param = "";
      this.listLoading = true;
      let staffID = this.$route.params.id;
      getStaff(param, staffID)
        .then(res => {
          this.staffForm = res.data.data.data;
          if (this.staffForm.spouseKindName === '校内') {
            this.isCampus = true
          }
          let familyCode = res.data.data.data.familyCode
          if (typeof familyCode !== "undefined" && typeof familyCode !== "null" && familyCode !== -1) {
            getStaff(param, familyCode).then(res => {
              let spouse = res.data.data.data
              this.staffForm.spouseCode = spouse.code
              this.staffForm.spouseDept = spouse.deptName
              this.staffForm.spouseName = `${spouse.no}-${spouse.name}`
              this.staffForm.spousePostName = spouse.postName
              this.staffForm.spouseTitleName = spouse.titleName
            })
          }
          this.breadcrumbDeptName = this.staffForm.deptName
          Object.assign(this.oldStaffForm, res.data.data.data);
          this.listLoading = false
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 当点击编辑时
    modifyForm () {
      this.getParam();
      this.ismodify = !this.ismodify;
      if (this.staffForm.spouseKindName === '校内') {
        this.isCampus = true
      }
    },
    // 点击取消编辑，还原原表单
    handleCancelEdit () {
      this.ismodify = !this.ismodify
      this.isCampus = false
      this.staffForm = JSON.parse(JSON.stringify(this.oldStaffForm))
      this.$refs["staffForm"].clearValidate()

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
    // 查看住房
    checkHouse () {
      this.$router.push({
        path: `/basic/houseResident/${this.staffForm.id}`
      });
    },
    // 编辑提交之前的处理
    beforModify () {
      const postForm = {};
      postForm.id = this.oldStaffForm.id;
      let newVal = JSON.parse(JSON.stringify(this.staffForm))
      let oldVal = JSON.parse(JSON.stringify(this.oldStaffForm))
      for (let v in newVal) {
        if (newVal[v] != oldVal[v]) {
          postForm[v] = newVal[v];
        }
      }

      if (postForm.hasOwnProperty("postName")) {
        postForm.post = postForm.postName;
        delete postForm.postName;
      }
      if (postForm.hasOwnProperty("titleName")) {
        postForm.title = postForm.titleName;
        delete postForm.titleName;
      }
      if (postForm.hasOwnProperty("typeName")) {
        postForm.type = postForm.typeName;
        delete postForm.typeName;
      }
      if (postForm.hasOwnProperty("statusName")) {
        postForm.status = postForm.statusName;
        delete postForm.statusName;
      }
      if (postForm.hasOwnProperty("deptName")) {
        postForm.dept = postForm.deptName;
        delete postForm.deptName;
      }
      if (this.isCampus) {
        delete postForm.spouseName
        delete postForm.spouseCode
        delete postForm.spouseTitleName
        delete postForm.spouseDept
        delete postForm.spousePostName
        postForm.spouseKind = postForm.spouseKindName
        delete postForm.spouseKindName;

      } else {

        if (postForm.hasOwnProperty("spouseTitleName")) {
          postForm.spouseTitle = postForm.spouseTitleName;
          delete postForm.spouseTitleName;
        }
        if (postForm.hasOwnProperty("spouseDept")) {
          postForm.spouseDept = postForm.spouseDept;
          delete postForm.spouseDept;
        }
        if (postForm.hasOwnProperty("spousePostName")) {
          postForm.spousePost = postForm.spousePostName;
          delete postForm.spousePostName;
        }
        if (postForm.hasOwnProperty("spouseKindName")) {
          postForm.spouseKind = postForm.spouseKindName
          delete postForm.spouseKindName;
        }
        delete postForm.familyCode
      }
      console.log("postForm:", postForm)

      this.modifySubmit(postForm);
    },
    // 编辑提交
    modifySubmit (postForm) {
      this.$confirm("此操作保存编辑", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$refs["staffForm"].validate(valid => {
            if (valid) {
              this.listLoading = true;
              //let param = Object.assign({}, this.staffForm);
              putStaffData(postForm).then(res => {
                let staffID = this.staffForm.id;
                utils.statusinfo(this, res.data);
                postPromoteSubStaffID(staffID).then(res => {
                  this.detailLoading = false;
                });
                this.getList()
                this.ismodify = false
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消修改"
          });
        });
    },
    // 路由返回
    routerBack () {
      this.$store.commit("SET_STAFF_SHOW", false);
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
      this.staffForm.familyCode = staff.no
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
