<template>
  <div class="second-container">
    <indexNav :fix-status="fixstatus" @emit-form="getList"></indexNav>
    <section class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>维修管理</el-breadcrumb-item>
            <el-breadcrumb-item>维修审核</el-breadcrumb-item>
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
                <h1>维修审核单</h1>
                <el-form :model="reviewForm" label-width="100px" ref="reviewForm" :rules="rules">
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="维修类型">
                        <el-input v-model="reviewForm.fixContentName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="申请时间">
                        <el-input v-model="reviewForm.applyTime" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="联系电话">
                        <el-input v-model="reviewForm.phone" readonly></el-input>
                      </el-form-item>
                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="7" :offset="1">
                      <el-form-item label="申请人姓名">
                        <el-input v-model="reviewForm.staffName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职称">
                        <el-input v-model="reviewForm.postName" readonly></el-input>
                      </el-form-item>
                    </el-col>
                    <el-col :span="7">
                      <el-form-item label="职务">
                        <el-input v-model="reviewForm.titleName" readonly></el-input>
                      </el-form-item>
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
  import indexNav from "./components/indexNav";
  export default {
    data() {
      return {
        listLoading: false,
        fixstatus: "review",
        reviewForm: {}
      };
    },
    components: {
      indexNav
    },
    methods: {
      getList(object) {
        this.reviewForm = object.content;
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
