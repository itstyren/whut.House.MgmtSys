<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>区域管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
        <el-form :inline="true" style="margin-bottom:15px">
          <el-button type="primary" @click="addFormVisible = true">新增区域</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="regionData" style="width:100%" v-loading="listLoading">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column>
          <el-table-column prop="name" label="区域" sortable align="center"></el-table-column>
          <el-table-column prop="description" label="描述" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="300" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="delectAccTch(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
    <!-- 新增表单 -->
    <el-dialog title="新增区域" :visible.sync="addFormVisible" v-loading="submitLoading" width="35%">
      <el-form :model="addFormBody" label-width="80px" ref="addForm" :rules="rules" auto style="padding-left: 10%;">
        <el-form-item label="区域名" prop="AccountID">
          <el-input v-model="addFormBody.AccountID" placeholder="请输入区域" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="描述" prop="AccountName">
          <el-input type="textarea" :autosize="{minRows:2,maxRows:4}" v-model="addFormBody.AccountName" placeholder="请输入描述" style="width:300px"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary" @click.native="addSubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import { getRegionData } from "@/api/api";
import common from "@/common/util.js";
export default {
  data() {
    return {
      // 表格数据
      regionData: [],
      listLoading: false,

      selectRowIndex: "",
      totalNum: 0,
      page: 1,
      size: 10,

      // 新增教师表单规则验证
      rules: {
        AccountID: [
          {
            required: true,
            message: "请输入账号",
            trigger: "blur"
          }
        ],
        AccountName: [
          {
            required: true,
            message: "请输入姓名",
            trigger: "blur"
          },
          {
            pattern: /^[\u4e00-\u9fa5]{1,6}$/,
            message: "请输入1-6位汉字",
            trigger: "blur"
          }
        ],
        Tel: [
          {
            required: true,
            message: "请输入电话",
            trigger: "blur"
          },
          {
            pattern: /^1\d{10}$/,
            message: "电话号码格式有误！",
            trigger: "blur"
          }
        ]
      },

      // 新增表单相关数据
      submitLoading: false,
      addFormVisible: false,
      addFormBody: {
        AccountName: "",
        AccountID: "",
        RoleID: "",
        OrgID: "",
        Tel: ""
      }
    };
  },
  components: {},
  // 声明时期调用
  mounted() {
    this.getList();
  },
  methods: {
    // 获取区域
    getList() {
      this.listLoading = true;
      let param = {
        // page: this.page,
        // size: this.size
      };
      getRegionData(param)
        .then(res => {
           // console.log(res.data.data)        
          this.regionData = res.data.data.date.list;
        //  this.totalNum = res.data.data.data.total;
         // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    //更换每页数量
    SizeChangeEvent(val) {
      this.loading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent(val) {
      this.loading = true;
      this.page = val;
      this.getList();
    }
  }
};
</script>

<style scoped lang="scss">

</style>
