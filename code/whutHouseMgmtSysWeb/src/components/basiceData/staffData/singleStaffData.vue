<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: `/basic/staff/byDept/48` }">职工管理</el-breadcrumb-item>
        <el-breadcrumb-item>职工</el-breadcrumb-item>

      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary">编辑员工</el-button>
        </el-form>
      </div>
      <!-- 表单区 -->
      <div class="main-data">
        <!-- 两个表单的大盒子 -->
        <div class="from">
          <el-form :model="staffFrom" label-width="110px" ref="staffFrom">
            <h1>员工本人信息</h1>
            <!-- 员工信息 -->
            <div class="staff-from">
              <!-- 左半边的信息 -->
              <div class="single-staff-from">
                <el-form-item label="职工编号" prop="no">
                  <el-input v-model="staffFrom.no" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                  <el-input v-model="staffFrom.name" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                  <el-input v-model="staffFrom.sex" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="婚姻状况">
                  <el-input v-model="staffFrom.marriageState" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="code">
                  <el-input v-model="staffFrom.code" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="联系电话" prop="tel">
                  <el-input v-model="staffFrom.tel" :readonly="!ismodify"></el-input>
                </el-form-item>
              </div>
              <!-- 中间信息 -->
              <div class="single-staff-from">
                <el-form-item v-if="!ismodify" label="职称">
                  <el-input v-model="staffFrom.titleName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="!ismodify" label="职务">
                  <el-input v-model="staffFrom.postName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="!ismodify" label="职工类别">
                  <el-input v-model="staffFrom.typeName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="!ismodify" label="工作状态">
                  <el-input v-model="staffFrom.statusName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="!ismodify" label="工作部门">
                  <el-input v-model="staffFrom.deptName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="优惠比例" prop="discountRate">
                  <el-input v-model="staffFrom.discountRate" :readonly="!ismodify">
                  </el-input>
                </el-form-item>
              </div>
              <!-- 右半边的信息 -->
              <div class="single-staff-from">
                <el-form-item label="上大学时间" prop="goUniversityTime">
                  <el-date-picker v-model="staffFrom.goUniversityTime" :readonly="!ismodify" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="参加工作时间" prop="joinTime">
                  <el-date-picker v-model="staffFrom.joinTime" :readonly="!ismodify" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="来校工作时间" prop="firstJobTime">
                  <el-date-picker v-model="staffFrom.firstJobTime" :readonly="!ismodify" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="离退休时间" prop="retireTime">
                  <el-date-picker v-model="staffFrom.retireTime" :readonly="!ismodify" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
                <el-form-item label="购房款" prop="buyAccount">
                  <el-input v-model="staffFrom.buyAccount" :readonly="!ismodify">
                  </el-input>
                </el-form-item>
                <el-form-item label="维修基金" prop="fixFund">
                  <el-input v-model="staffFrom.fixFund" :readonly="!ismodify">
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
                  <el-input v-model="staffFrom.spouseName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="身份证号" prop="spouseCode">
                  <el-input v-model="staffFrom.spouseCode" :readonly="!ismodify"></el-input>

                </el-form-item>
              </div>
              <div class="single-staff-from">
                <el-form-item label="单位性质">
                  <el-input v-model="staffFrom.spouseKind" :readonly="!ismodify"></el-input>

                </el-form-item>
                <el-form-item label="工作部门">
                  <el-input v-model="staffFrom.spouseDept" :readonly="!ismodify"></el-input>

                </el-form-item>
              </div>
              <div class="single-staff-from">
                <el-form-item v-if="!ismodify" label="职称">
                  <el-input v-model="staffFrom.spouseTitleName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="!ismodify" label="职务">
                  <el-input v-model="staffFrom.spousePostName" :readonly="!ismodify"></el-input>
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
    getStaff
  } from "@/api/api";
  export default {
    data() {
      return {
        // 是否处于编辑状态
        ismodify: false,
        // 表单需要的信息
        staffFrom: {},
        listLoading: false
      };
    },
    components: {},
    // 监听
    watch: {
      $route: "getList"
    },
    created() {
      this.getList();
    },
    // 方法集合
    methods: {
      // 获取列表
      getList() {
        let param = "";
        this.listLoading = true;
        let staffID = this.$route.params.id;
        if (this.$store.state.staffData.id == staffID) {
          this.staffFrom = this.$store.state.staffData;
          return;
        }
        getStaff(param, staffID)
          .then(res => {
            this.staffFrom = res.data.data.data;
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
      border: 1px solid black; // 员工主表
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
