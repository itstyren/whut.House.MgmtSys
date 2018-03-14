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
            <el-breadcrumb-item>个人信息</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <el-row class="user-info">
              <el-col :span="4" class="card nav">
                <div class="title">
                  <span>个人信息</span>
                </div>
                <el-menu default-active="personal" @select="menuSelect" background-color="#fff" text-color="#000" active-text-color="#ffd04b">
                  <el-menu-item index="personal">
                    <my-icon icon-class="set"></my-icon>
                    <span slot="title">常规设置</span>
                  </el-menu-item>
                  <el-menu-item index="house">
                    <my-icon icon-class="building"></my-icon>
                    <span slot="title">房屋信息</span>
                  </el-menu-item>
                  <el-menu-item index="fix">
                    <my-icon icon-class="baoxiu"></my-icon>
                    <span slot="title">我的维修</span>
                  </el-menu-item>
                  <el-menu-item index="5">
                    <my-icon icon-class="detail"></my-icon>
                    <span slot="title">我的申请</span>
                  </el-menu-item>
                  <el-menu-item index="6">
                    <my-icon icon-class="xiugaimima"></my-icon>
                    <span slot="title">修改密码</span>
                  </el-menu-item>
                </el-menu>
              </el-col>
              <!-- 常规设置 -->
              <keep-alive>
                <el-col :span="14" v-loading="listLoading" :offset="1" class="info-form" v-if="menuIndex=='personal'">
                  <div class="title">
                    <h1>常规设置</h1>
                  </div>
                  <el-row class="info-row">
                    <el-col :span="7">
                      <strong>姓名</strong>
                    </el-col>
                    <el-col :span="14">
                      <strong style="color:#666">{{staffInfo.name}}</strong>
                    </el-col>
                  </el-row>
                  <el-row class="info-row">
                    <el-col :span="7">
                      <strong>部门</strong>
                    </el-col>
                    <el-col :span="14">
                      <strong style="color:#666">{{staffInfo.deptName}}</strong>
                    </el-col>
                  </el-row>
                  <el-row class="info-row">
                    <el-col :span="7">
                      <strong>职称</strong>
                    </el-col>
                    <el-col :span="14">
                      <strong style="color:#666">{{staffInfo.titleName}}</strong>
                    </el-col>
                  </el-row>
                  <el-row class="info-row">
                    <el-col :span="7">
                      <strong>职务</strong>
                    </el-col>
                    <el-col :span="14">
                      <strong style="color:#666">{{staffInfo.postName}}</strong>
                    </el-col>
                  </el-row>
                  <el-row :class="{'info-row':!phoneChange,'is-change':phoneChange}">
                    <el-col :span="7">
                      <strong>手机</strong>
                    </el-col>
                    <el-col :span="14" v-if="!phoneChange">
                      <strong style="color:#666">{{staffInfo.tel}}</strong>
                    </el-col>
                    <el-col :span="14" v-if="phoneChange">
                      <el-row>
                        <el-col :span="24">
                          <div class="old-vertify">
                            <strong>当前手机号验证</strong>
                          </div>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="17">
                          <el-input v-model="staffInfo.tel" disabled></el-input>
                        </el-col>
                      </el-row>
                      <el-row style="margin-top:10px">
                        <el-col :span="17">
                          <el-input v-model="identifyCode"></el-input>
                        </el-col>
                        <el-col :span="3" :offset="1">
                          <countdown-button></countdown-button>
                        </el-col>
                      </el-row>
                      <el-row style="margin-top:10px">
                        <el-col :span="7">
                          <el-button type="primary">下一步</el-button>
                        </el-col>
                        <el-col :span="3">
                          <el-button @click="phoneChange=false">取消</el-button>
                        </el-col>
                      </el-row>
                    </el-col>
                    <el-col :span="3">
                      <el-button type="infor" size="mini" v-if="!phoneChange" @click="modifyPhone">编辑</el-button>
                    </el-col>
                  </el-row>
                  <el-row class="info-row">
                    <el-col :span="7">
                      <strong>邮箱</strong>
                    </el-col>
                    <el-col :span="14">
                      <strong style="color:#666">{{staffInfo.email}}</strong>
                    </el-col>
                    <el-col :span="3">
                      <el-button type="infor" size="mini">编辑</el-button>
                    </el-col>
                  </el-row>
                </el-col>
              </keep-alive>
              <!-- 房屋信息 -->
              <keep-alive>
                <el-col :span="14" :offset="1" v-loading="listLoading" class="info-form" v-if="menuIndex=='house'">
                  <div class="title">
                    <h1>房屋信息</h1>
                  </div>
                  <el-tabs v-if="houseList.length!=0" v-model="selectHouse" type="border-card" style="margin:10px 10px 10px">
                    <el-tab-pane v-for="(item,index) in houseList" :key="item.address" :name="index.toString()">
                      <span slot="label">
                        <my-icon icon-class="house"></my-icon> 住房 {{index+1}}</span>
                      <div v-if="selectHouse==index" class="house-info">
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>地址</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.address}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>区域</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.region}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>结构</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.struct}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>户型</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.layout}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>房屋状态</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.houseRel}}</strong>
                          </el-col>
                        </el-row>
                      </div>
                    </el-tab-pane>
                  </el-tabs>
                  <div v-else class="card no-result">
                    <strong>暂无数据</strong>
                  </div>
                </el-col>
              </keep-alive>
              <!-- 维修信息 -->
              <keep-alive>
                <el-col :span="14" :offset="1" v-loading="listLoading" class="info-form" v-if="menuIndex=='fix'">
                  <div class="title">
                    <h1>维修信息</h1>
                  </div>
                  <div class="card fix-result">
                    <el-table :data="fixFormList" class="table" height="string" v-loading="listLoading">
                      <el-table-column label="维修类型" align="center"></el-table-column>
                      <el-table-column label="申请时间" align="center"></el-table-column>
                      <el-table-column label="处理状态" align="center"></el-table-column>
                      <el-table-column label="操作" align="center">
                        <template slot-scope="scope">
                          <el-button type="infor" size="small">评价</el-button>
                        </template>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-col>
              </keep-alive>
            </el-row>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import countdownButton from "@/components/countdown/button";
  import {
    getStaff,
    getStaffHouseRel
  } from "@/api/basiceData";
  import {
    getUserHouse
  } from "@/api/user";
  export default {
    data() {
      return {
        listLoading: false,
        staffInfo: {
          name: "",
          deptName: "",
          titleName: "",
          postName: "",
          tel: "",
          email: ""
        },
        phoneChange: false,
        identifyCode: "",
        menuIndex: "personal",
        houseList: [],
        selectHouse: "",
        fixFormList: []
      };
    },
    components: {
      countdownButton
    },
    created() {
      this.getStaff(), this.getStaffHouseRel();
    },
    methods: {
      modifyPhone() {
        this.phoneChange = true;
      },
      menuSelect(index, indexPath) {
        this.menuIndex = index;
      },
      getStaff() {
        this.listLoading = true;
        let params = {};
        const staffID = this.$store.getters.userNO;
        getStaff(params, staffID).then(res => {
          this.staffInfo = res.data.data.data;
          this.listLoading = false;
        });
      },
      getStaffHouseRel() {
        this.listLoading = true;
        const staffID = this.$store.getters.userNO;
        getUserHouse(staffID).then(res => {
          console.log(res.data);
          this.houseList = res.data;
          this.listLoading = false;
        });
      }
    }
  };

</script>

<style scoped lang="scss">
  .user-info {
    margin: 5px auto;
    width: 80%;
    .nav {
      margin-top: 70px;
      .title {
        width: 100%;
        text-align: center;
        line-height: 42px;
        font-weight: bold;
        padding-top: 3px;
        background-color: #f3f5f8;
      }
      .el-menu {
        border-right: none;
      }
    }
    .info-form {
      &>.title {
        width: 100%;
        border-bottom: 2px solid #ccc;
        margin-bottom: 50px;
      }
      .info-row {
        border-bottom: 1px solid #eee;
        padding: 10px;
        height: 45px;
      }
      .is-change {
        background-color: #f5f5f5;
        border-bottom: 1px solid #eee;
        padding: 10px;
        .old-vertify {
          margin-bottom: 5px;
          &::after {
            content: " *";
            color: #ed1c24;
          }
        }
      }
      .no-result {
        height: 50vh;
        display: flex;
        justify-content: center;
        flex-direction: column;
        text-align: center;
      }
      .fix-result {
        height: 60vh;
      }
    }
  }

</style>
