<template>
  <div class="second-container">
    <index-nav @select-index="selectIndex"></index-nav>
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
            <el-row class="user-info" :gutter="20">
              <!-- 常规设置 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='personal'">
                  <div class="info-form card">
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
                  </div>
                </el-col>
              </keep-alive>
              <!-- 房屋信息 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='house'">
                  <el-row v-for="(item,index) in houseList" :key="item.address" >
                    <el-col :span="24" class="info-form card">
                      <div class="title">
                        <h1>房屋信息{{index+1}}</h1>
                      </div>
                      <div class="house-info">
                        <el-row class="info-row">
                          <el-col :span="7" style="text-align:center">
                            <strong>地址</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.address}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7" style="text-align:center">
                            <strong>区域</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.regionName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7" style="text-align:center">
                            <strong>结构</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.structName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row" v-if="item.houseRelName!='私有'">
                          <el-col :span="7" style="text-align:center">
                            <strong>户型</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.layoutName}}</strong>
                          </el-col>
                        </el-row>
                        <el-row class="info-row">
                          <el-col :span="7" style="text-align:center">
                            <strong>房屋状态</strong>
                          </el-col>
                          <el-col :span="14">
                            <strong style="color:#666">{{item.houseRelName}}</strong>
                          </el-col>
                        </el-row>
                      </div>
                    </el-col>
                  </el-row>

                </el-col>
              </keep-alive>
              <!-- 补贴信息 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='monetarySub'">
                  <div class="info-form card">
                  <div class="title">
                    <h1>补贴信息</h1>
                  </div>
                  <div class="fix-result">
                    <el-table ref=monetaryTable :data="monetaryList" class="table" height="string" v-loading="listLoading">
                      <el-table-column label="年度" prop="year" align="center"></el-table-column>
                      <el-table-column label="年度工资" prop="annualSal" align="center"></el-table-column>
                      <el-table-column label="年度补贴金" prop="subsidies" align="center"></el-table-column>
                      <el-table-column label="备注说明" prop="remark" align="center"></el-table-column>
                    </el-table>
                  </div>
                  </div>
                </el-col>
              </keep-alive>
              <!-- 维修信息 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='fix'">
                    <div class="info-form card">
                  <div class="title">
                    <h1>维修信息</h1>
                  </div>
                  <div class="fix-result">
                    <el-table ref=fixTable :data="fixFormList" class="table" height="string" v-loading="listLoading">
                      <el-table-column type="expand">
                        <template slot-scope="scope">
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>维修类型：</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.fixType }}</span>
                            </el-col>
                            <el-col :span="4">
                              <strong>申请时间：</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.applyTime }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>处理状态：</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.fixState }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px">
                            <el-col :span="4">
                              <strong>处理说明：</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.processReason }}</span>
                            </el-col>
                          </el-row>
                          <el-row style="margin-bottom:20px; font-size:16px" v-if="scope.row.ratings!=null">
                            <el-col :span="4">
                              <strong>维修评分：</strong>
                            </el-col>
                            <el-col :span="8">
                              <span>{{ scope.row.ratings }} 星</span>
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
                      <el-table-column label="操作" align="center" width="200">
                        <template slot-scope="scope">
                          <el-button @click="expand(scope.row)" type="infor" size="small">查看</el-button>
                          <el-button type="success" @click="fixComment(scope.row)" v-if="scope.row.isCheck==true&&scope.row.ratings==null" size="small">评价</el-button>
                        </template>
                      </el-table-column>
                    </el-table>
                  </div>
                    </div>
                </el-col>
              </keep-alive>
              <!-- 租赁信息 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='hire'">
                  <div class="info-form card">
                  <div class="title">
                    <h1>租赁信息</h1>
                  </div>
                  <div class="hire-result">
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
                  </div>
                </el-col>
              </keep-alive>
              <!-- 修改密碼 -->
              <keep-alive>
                <el-col :span="19" v-loading="listLoading"  v-if="menuIndex=='password'">
                  <div class="info-form card">
                  <div class="title">
                    <h1>修改密码</h1>
                  </div>
                  <div class="change-password">
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
                  </div>
                </el-col>
              </keep-alive>
              <el-col :span="5" >
                <div class=" card avatar-warpper">
                  <div class="avatar">
                    <img :src="avatarURL" width="100%" height="100%" alt="avatar">
                  </div>
                  <image-upload @upload-url="uploadURL"></image-upload>
                </div>
              </el-col>
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
                  <el-input  placeholder="请输入...." type="textarea" :autosize="{ minRows: 2, maxRows: 4}"></el-input>
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
  import img_avatar from "@/assets/avatar.jpg";
  import countdownButton from "@/components/countdown/button";
  import imageUpload from "@/components/imageCropper/index";
  import indexNav from "./components/indexNav";
  import {
    getStaff,
    getStaffHouseRel
  } from "@/api/basiceData";
  import {
    putChangePassword,
    putFixComment,
    getUserHouse,
    getUserAvatar,
    postUserAvatar
  } from "@/api/user";
  import {
    getFixByStaffID
  } from "@/api/fixManage";
  import {
    getHireByStaffID
  } from "@/api/leaseManage";
  import {
    getStaffLumpMonetaryByNO,
    getStaffMonetaryByNO
  } from "@/api/monetarySub";
  import utils from "@/utils/index.js";
  var basiceUrl = "http://172.16.65.105:8080/whutHouseMgmtReposity/dataImport/";
// var basiceUrl='http://118.126.117.96:8080/whutHouseMgmtReposity/dataImport/'
  // var basiceUrl= 'http://120.78.226.24:8080/whutHouseMgmtReposity/dataImport/'
// var   baseURL= 'https://www.terryren.com/whutHouseMgmtReposity' // api的base_url

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
        avatarURL: "",
        listLoading: false,
        staffID: this.$store.getters.userID,
        staffNO: parseInt(this.$store.getters.userNO),
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
        monetaryList: [],
        selectHouse: "",
        fixFormList: [],
        fixCommentForm: {},
        fixCommentVisible: false,
        commentLoading: false,
        hireFormList: [],
        passwordForm: {},
        passwordRules: {
          oldPassword: [{
            required: true,
            message: "请输入旧密码",
            trigger: "blur"
          }],
          newPassword: [{
            required: true,
            message: "请输入新密码",
            trigger: "blur"
          }],
          checkNewPassword: [{
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
      countdownButton,
      imageUpload,
      indexNav
    },
    created() {
      this.menuIndex = this.$route.params.menuIndex || "personal";
      this.getStaff();
      this.getStaffHouseRel();
      this.getFix();
      this.getHire();
      this.getStaffMonetarySub();
    },
    methods: {
      modifyPhone() {
        this.phoneChange = true;
      },
      // 获取职工个人信息
      getStaff() {
        this.listLoading = true;
        let params = {};
        getStaff(params, this.staffID).then(res => {
          this.staffInfo = res.data.data.data;
          getUserAvatar(this.staffID).then(res => {
            if (res.data.status == "error") {
              this.avatarURL = img_avatar;
            } else {
              this.avatarURL = res.data.data.data;
            }
          });
          this.listLoading = false;
        });
      },
      getStaffHouseRel() {
        this.listLoading = true;
        getUserHouse(this.staffID).then(res => {
          this.houseList = res.data.data.data;
          this.houseList[0].houseRelName='购买'
          this.listLoading = false;
        });
      },
      // 获取货币化补贴
      getStaffMonetarySub() {
        this.listLoading = true;
        let params = {
          page: 1,
          size: 10
        };
        getStaffMonetaryByNO(params, this.staffNO).then(res => {
          // console.log(res.data.data);
          this.monetaryList = res.data.data.data.list;
          this.listLoading = false;
          getStaffLumpMonetaryByNO(this.staffNO).then(res => {
            const array = res.data.data.data;
            // console.log(array);
            if (array.length != 0) {
              array.forEach(item => {
                let data = {
                  year: item.oneTimeSubYear,
                  annualSal: "/",
                  subsidies: item.oneTimeSubsidy,
                  remark: item.remark
                };
                // console.log(data);
                this.monetaryList.unshift(data);
              });
            }
          });
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
      selectIndex(index) {
        this.menuIndex = index;
      },
      // 提交评价
      submitComment() {
        this.commentLoading = true;
        let data = {
          description: this.fixCommentForm.description,
          fixId: this.fixCommentForm.fixId,
          ratings: this.fixCommentForm.comment
        };
        putFixComment(data).then(res => {
          utils.statusinfo(this, res.data);
          this.commentLoading = false;
          this.fixCommentVisible = false;
          this.getFix();
          //this.getList();
        });
      },
      // 导出申请单
      downloadApply() {
        let staffID = this.$store.getters.userID;
        window.location.href = `${basiceUrl}exportToWord/hire/${staffID}`;
      },
      uploadURL(url) {
        this.listLoading = true;
        let data = {
          id: this.staffID,
          icon: url
        };
        postUserAvatar(data).then(res => {
          utils.statusinfo(this, res.data);
          this.listLoading = false;
          getUserAvatar(this.staffID).then(res => {
            if (res.data.status == "error") {
              this.avatarURL = img_avatar;
            } else {
              this.avatarURL = res.data.data.data;
            }
          });
        });
      }
    }
  };

</script>

<style scoped lang="scss">
@import "../../styles/variables.scss";

.second-container {
  background-color: $background-grey;
  .user-info {
    width: 100%;
    .avatar-warpper {
      padding: 15px;
      .avatar {
        margin: 0px auto 20px;
        width: 12vw;
        height: 12vw;
        border-radius: 50%;
        overflow: hidden;
      }
    }
    .info-form {
      padding: 0 10px 10px;
      & .title {
        width: 100%;
        border-bottom: 2px solid #ccc;
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
        left: 4%; //right: 2%;
      }
    }
  }
}
</style>
