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
                <el-menu :default-active="menuIndex" @select="menuSelect" background-color="#fff" text-color="#000" active-text-color="#ffd04b">
                  <el-menu-item index="personal">
                    <my-icon icon-class="paramSet"></my-icon>
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
                  <el-menu-item index="hire">
                    <my-icon icon-class="detail"></my-icon>
                    <span slot="title">我的申请</span>
                  </el-menu-item>
                  <el-menu-item index="password">
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
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7">
                            <strong>区域</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.regionName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7">
                            <strong>结构</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.structName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7">
                            <strong>户型</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.layoutName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7">
                            <strong>房屋状态</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.houseRelName}}</strong>
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
                    <el-table ref=fixTable :data="fixFormList" class="table" height="string" v-loading="listLoading">
                      <el-table-column type="expand">
                        <template slot-scope="scope">
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>维修类型</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.fixType }}</span>
                            </el-col>
                            <el-col :span="4">
                              <strong>申请时间</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.applyTime }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>处理状态</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.fixState }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>处理说明</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.processReason }}</span>
                            </el-col>
                          </el-row>
                        </template>
                      </el-table-column>
                      <el-table-column label="维修类型" prop="fixType" align="center"></el-table-column>
                      <el-table-column label="申请时间" prop="applyTime" align="center"></el-table-column>
                      <el-table-column label="处理状态" prop="fixState" align="center">
                        <template slot-scope="scope">
                          <el-tag :type="scope.row.fixState | fixStatusFilter">{{scope.row.fixState}}</el-tag>
                        </template>
                      </el-table-column>
                      <el-table-column label="操作" align="center">
                        <template slot-scope="scope">
                          <el-button @click="expand(scope.row)" type="infor" size="small">查看</el-button>
                          <el-button type="success" @click="fixComment(scope.row)" v-if="scope.row.fixState=='已审核'" size="small">评价</el-button>
                        </template>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-col>
              </keep-alive>
              <!-- 租赁信息 -->
              <keep-alive>
                <el-col :span="14" :offset="1" v-loading="listLoading" class="info-form" v-if="menuIndex=='hire'">
                  <div class="title">
                    <h1>租赁信息</h1>
                  </div>
                  <div class="card hire-result">
                    <el-table ref=hireTable :data="hireFormList" class="table" height="string" v-loading="listLoading">
                      <el-table-column type="expand">
                        <template slot-scope="scope">
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>申请时间</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.applyTime }}</span>
                            </el-col>
                            <el-col :span="4">
                              <strong>处理状态</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.hireState }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px" v-if=" scope.row.hireState!=='待受理'">
                            <el-col :span="4">
                              <strong>预分配地址</strong>
                            </el-col>
                            <el-col :span="20">
                              <span>{{ scope.row.address }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px" v-if=" scope.row.hireState!=='待受理'">
                            <el-col :span="4">
                              <strong>处理说明</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.processReason }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px;" v-if=" scope.row.hireState=='待受理'">
                            <el-col :span="4">
                              <el-button type="primary" size="mini" @click="downloadApply">导出申请表</el-button>
                            </el-col>
                          </el-row>
                        </template>
                      </el-table-column>
                      <el-table-column label="预分配地址" width="280" prop="address" align="center"></el-table-column>
                      <el-table-column label="申请时间" prop="applyTime" align="center"></el-table-column>
                      <el-table-column label="处理状态" align="center">
                        <template slot-scope="scope">
                          <el-tag :type="scope.row.hireState | hireStatusFilter">{{scope.row.hireState}}</el-tag>
                        </template>
                      </el-table-column>
                      <el-table-column label="操作" align="center">
                        <template slot-scope="scope">
                          <el-button @click="expand(scope.row)" type="infor" size="small">查看</el-button>
                          <!-- <el-button type="success" @click="fixComment" v-if="scope.row.fixState=='已审核'" size="small">评价</el-button> -->
                        </template>
                      </el-table-column>
                    </el-table>
                  </div>
                </el-col>
              </keep-alive>
              <!-- 修改密碼 -->
              <keep-alive>
                <el-col :span="14" v-loading="listLoading" :offset="1" class="info-form" v-if="menuIndex=='password'">
                  <div class="title">
                    <h1>修改密码</h1>
                  </div>
                  <div class="card change-password">
                    <el-form :model="passwordForm" ref="changePassForm" status-icon label-width="100px" label-position="top" :rules="passwordRules">
                      <el-row>
                        <el-col :span="10" :offset="3">
                          <el-form-item label="旧密码" prop="oldPassword">
                            <el-input v-model="passwordForm.oldPassword" placeholder="请输入旧密码" type="password"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="10" :offset="3">
                          <el-form-item label="新密码" prop="newPassword">
                            <el-input v-model="passwordForm.newPassword" placeholder="请输入旧密码" type="password"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                      <el-row>
                        <el-col :span="10" :offset="3">
                          <el-form-item label="确认新密码" prop="checkNewPassword">
                            <el-input v-model="passwordForm.checkNewPassword" placeholder="请输入旧密码" type="password"></el-input>
                          </el-form-item>
                        </el-col>
                      </el-row>
                    </el-form>
                    <div class="tool">
                      <el-button type="primary" @click="changePass">提交</el-button>
                      <el-button type="infor">取消</el-button>
                    </div>
                  </div>
                </el-col>
              </keep-alive>
            </el-row>
          </div>
        </div>
      </div>
    </div>
    <el-dialog title="维修评价" class="fix-comment" :visible.sync="fixCommentVisible" v-loading="commentLoading">
      <el-form :model="fixCommentForm" label-width="100px">
        <el-row>
          <el-col :span="18" :offset="1">
            <el-form-item label="维修类型">
              <el-input v-model="fixCommentForm.fixType" readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="18" :offset="1">
            <el-form-item label="申请时间">
              <el-input v-model="fixCommentForm.applyTime" readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="18" :offset="1" class="border">
            <el-form-item label="处理状态">
              <el-input v-model="fixCommentForm.fixState" readonly></el-input>
            </el-form-item>
          </el-col>
        </el-row>
                <el-row>
          <el-col :span="18" :offset="1">
            <el-form-item label="评价">
              <el-row>
                <el-col :span="24">
              <el-input v-model="fixCommentForm.description" placeholder="请输入...." type="textarea" :autosize="{ minRows: 2, maxRows: 4}" ></el-input>                
              </el-col>
              </el-row>
              <el-row style="margin-top:20px;">
                <el-col :span="21" :offset="2">
              <el-rate v-model="fixCommentForm.comment" show-text></el-rate>                                  
                </el-col>
              </el-row>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
            <div slot="footer" class="dialog-footer">
        <el-button @click.native=" fixCommentVisible = false">取消</el-button>
        <el-button type="primary" @click.native="submitComment">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import countdownButton from "@/components/countdown/button";
import { getStaff, getStaffHouseRel } from "@/api/basiceData";
import { putChangePassword, putFixComment, getUserHouse } from "@/api/user";
import { getFixByStaffID } from "@/api/fixManage";
import { getHireByStaffID } from "@/api/leaseManage";
import utils from "@/utils/index.js";
export default {
  data() {
    var checkPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入密码"));
      } else if (value !== this.passwordForm.newPassword) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    return {
      listLoading: false,
      staffID: this.$store.getters.userID,
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
      fixFormList: [],
      fixCommentForm: {},
      fixCommentVisible: false,
      commentLoading:false,
      hireFormList: [],
      passwordForm: {},
      passwordRules: {
        oldPassword: [
          {
            required: true,
            message: "请输入旧密码",
            trigger: "blur"
          }
        ],
        newPassword: [
          {
            required: true,
            message: "请输入新密码",
            trigger: "blur"
          }
        ],
        checkNewPassword: [
          {
            required: true,
            message: "请重复新密码",
            trigger: "blur"
          },
          {
            validator: checkPassword,
            trigger: "blur"
          }
        ]
      }
    };
  },
  filters: {
    fixStatusFilter(status) {
      const statusMap = {
        待审核: "warning",
        待受理: "warning",
        审核拒绝: "danger",
        受理拒绝: "danger",
        已审核: "success"
      };
      return statusMap[status];
    },
    hireStatusFilter(status) {
      const statusMap = {
        待审核: "warning",
        待受理: "warning",
        待审批: "warning",
        审核拒绝: "danger",
        受理拒绝: "danger",
        审批拒绝: "danger",
        已审批: "success"
      };
      return statusMap[status];
    }
  },
  components: {
    countdownButton
  },
  created() {
    (this.menuIndex = this.$route.params.menuIndex || "personal"),
      this.getStaff(),
      this.getStaffHouseRel(),
      this.getFix(),
      this.getHire();
  },
  methods: {
    modifyPhone() {
      this.phoneChange = true;
    },
    menuSelect(index, indexPath) {
      this.menuIndex = index;
    },
    // 获取职工个人信息
    getStaff() {
      this.listLoading = true;
      let params = {};
      getStaff(params, this.staffID).then(res => {
        this.staffInfo = res.data.data.data;
        this.listLoading = false;
      });
    },
    getStaffHouseRel() {
      this.listLoading = true;
      getUserHouse(this.staffID).then(res => {
        this.houseList = res.data.data.data;
        this.listLoading = false;
      });
    },
    // 获取维修信息
    getFix() {
      this.listLoading = true;
      getFixByStaffID(this.staffID).then(res => {
        this.fixFormList = res.data.data.data;
        this.listLoading = false;
      });
    },
    fixComment(row) {
      this.fixCommentForm = Object.assign({}, row);
      console.log(this.fixCommentForm);
      this.fixCommentVisible = true;
    },
    getHire() {
      this.listLoading = true;
      getHireByStaffID(this.staffID).then(res => {
        this.hireFormList = res.data.data.data;
      });
    },
    expand(row) {
      this.$refs.fixTable.toggleRowExpansion(row);
    },
    // 修改密码
    changePass() {
      this.$refs["changePassForm"].validate(valid => {
        if (valid) {
          this.listLoading = true;
          let param = {
            newPsw: this.passwordForm.newPassword,
            oldPsw: this.passwordForm.oldPassword
          };
          putChangePassword(param).then(res => {
            utils.statusinfo(this, res.data);
            this.listLoading = false;
            this.$refs.changePassForm.resetFields();
          });
        }
      });
    },
    // 提交评价
    submitComment() {
      this.commentLoading = true;
      let data = {
        description: this.fixCommentForm.description,
        fixId: this.fixCommentForm.fixId,
        description: this.fixCommentForm.description,
        ratings: this.fixCommentForm.comment
      };
      putFixComment(data).then(res => {
        utils.statusinfo(this, res.data);
        this.commentLoading = false;
        this.fixCommentVisible = false;
        //this.getList();
      });
    },
    // 导出申请单
    downloadApply() {
      let staffID = this.$store.getters.userID;
      window.location.href = `http://localhost:8787/whutHouseMgmtReposity/exportToWord/hire/${staffID}`;
    }
  }
};
</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
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
        padding-left: 0;
      }
    }
    .info-form {
      & > .title {
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
      .fix-result,
      .hire-result {
        height: 60vh;
      }
      .change-password {
        height: 400px;
        padding: 20px;
        position: relative;
        .tool {
          position: absolute;
          right: 30px;
          text-align: right;
          bottom: 30px;
        }
      }
    }
  }
  .fix-comment {
    .border {
      position: relative;
      margin-bottom: 15px;
      &::after {
        content: "";
        width: 105%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -2px;
        z-index: 1;
        left: 4%;
        //right: 2%;
      }
    }
  }
}
</style>
