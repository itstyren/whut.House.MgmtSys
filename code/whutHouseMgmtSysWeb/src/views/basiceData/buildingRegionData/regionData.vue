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
      <div class="toolbar "
           style="padding-left:10px;">
        <el-form :inline="true">
          <el-button type="primary"
                     @click="addForm">新增区域</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <div class="card "
             style="height:95%">
          <el-table :data="regionData"
                    class="table"
                    height="93%"
                    v-loading="listLoading">
            <el-table-column type="selection"
                             width="55"></el-table-column>
            <el-table-column type="index"
                             label="序号"
                             width="70"
                             align="center"></el-table-column>
            <el-table-column prop="name"
                             label="区域"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="description"
                             label="描述"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="campusName"
                             label="所属校区"
                             sortable
                             align="center"></el-table-column>
            <el-table-column label="操作"
                             width="300"
                             align="center">
              <template slot-scope="scope">
                <el-button size="small"
                           @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
                <el-button type="danger"
                           size="small"
                           @click="delectRegion(scope.$index,scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination background layout="total, prev, pager, next, sizes, jumper"
                         @size-change="SizeChangeEvent"
                         @current-change="CurrentChangeEvent"
                         :page-size="size"
                         :page-sizes="[10,15,20,25,30]"
                         :total="totalNum">
          </el-pagination>
        </div>
      </div>
    </div>
    <!-- 新增表单 -->
    <el-dialog title="新增区域"
               class="paramDialog"
               :visible.sync="addFormVisible"
               v-loading="submitLoading">
      <el-form :model="addFormBody"
               label-width="100px"
               ref="addForm"
               :rules="rules"
               auto>
        <el-row>
          <el-col :span="20">
            <el-form-item label="区域名"
                          prop="name">
              <el-input v-model="addFormBody.name"
                        placeholder="请输入区域"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="校区"
                          prop="name">
              <el-select v-model="addFormBody.campusId"
                         placeholder="请选择校区">
                <el-option v-for="v of compusData"
                           :key="v.id"
                           :label="v.name"
                           :value="v.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="描述"
                          prop="description">
              <el-input type="textarea"
                        :autosize="{minRows:2,maxRows:4}"
                        v-model="addFormBody.description"
                        placeholder="请输入描述"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click.native=" addFormVisible = false">取消</el-button>
        <el-button type="primary"
                   @click.native="addSubmit">提交</el-button>
      </div>
    </el-dialog>

    <!-- 编辑表单 -->
    <el-dialog title="编辑楼栋区域"
               class="paramDialog"
               :visible.sync="modifyFormVisible"
               v-loading="modifyLoading">
      <el-form :model="modifyFromBody"
               label-width="100px"
               ref="modifyFrom"
               :rules="rules">
        <el-row>
          <el-col :span="20">
            <el-form-item label="区域名"
                          prop="name">
              <el-input v-model="modifyFromBody.name"
                        placeholder="请输入区域"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="校区"
                          prop="name">
              <el-select v-model="modifyFromBody.campusId"
                         placeholder="请选择校区">
                <el-option v-for="v of compusData"
                           :key="v.id"
                           :label="v.name"
                           :value="v.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="20">
            <el-form-item label="描述"
                          prop="description">
              <el-input type="textarea"
                        :autosize="{minRows:2,maxRows:4}"
                        v-model="modifyFromBody.description"
                        placeholder="请输入描述"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer"
           class="dialog-footer">
        <el-button @click.native=" modifyFormVisible = false">取消</el-button>
        <el-button type="primary"
                   @click.native="modifySubmit">提交</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getRegionData,
  getCampusData,
  postRegionData,
  putRegionData,
  deleteRegionData
} from "@/api/basiceData";
import utils from "@/utils/index.js";
import * as types from "../../../store/mutation-types";
export default {
  data () {
    return {
      // 表格数据
      regionData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,

      // 新增教师表单规则验证
      rules: {
        name: [{
          required: true,
          message: "请输入区域",
          trigger: "blur"
        }],
        description: [{
          required: true,
          message: "请输入区域描述",
          trigger: "blur"
        },
          // {
          //   pattern: /^[\u4e00-\u9fa5]{0,200}$/,
          //   message: "最多100个字符",
          //   trigger: "blur"
          // }
        ]
      },
      //编辑表单相关数据
      modifyFormVisible: false,
      modifyLoading: false,
      modifyFromBody: {
        description: "",
        name: ""
      },

      // 新增表单相关数据
      submitLoading: false,
      addFormVisible: false,
      compusData: [],
      addFormBody: {
        description: "",
        name: ""
      }
    };
  },
  // 声明时期调用
  mounted () {
    this.getList();
  },
  methods: {
    // 获取校区
    getCompus () {
      return new Promise((resolve, reject) => {
        this.listLoading = true;
        let params = {
          page: 1,
          size: 9999
        };
        getCampusData(params)
          .then(res => {
            this.compusData = res.data.data.data.list;
            this.listLoading = false;
            resolve(res.data);
          })
          .then(err => {
            reject(err);
          });
      });
    },
    // 获取区域
    getList () {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      let roleId = this.$store.getters.roleId
      getRegionData(param, roleId)
        .then(res => {
          // console.log(res.data.data)
          this.regionData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    //显示编辑
    showModifyDialog (index, row) {
      if (this.compusData.length == 0) {
        this.getCompus().then(res => {
          this.modifyFormVisible = true;
          this.modifyFromBody = Object.assign({}, row);
        });
      } else {
        this.modifyFormVisible = true;
        this.modifyFromBody = Object.assign({}, row);
      }
    },
    //编辑提交
    modifySubmit () {
      this.$refs["modifyFrom"].validate(valid => {
        if (valid) {
          this.modifyLoading = true;
          let param = Object.assign({}, this.modifyFromBody);
          putRegionData(param).then(res => {
            utils.statusinfo(this, res.data);
            this.modifyLoading = false;
            this.modifyFormVisible = false;
            this.getList();
            this.$store.commit(types.REGION_CHANGE);
          });
        }
      });
    },
    // 显示新增
    addForm () {
      if (this.compusData.length == 0) {
        this.getCompus().then(res => {
          this.addFormVisible = true;
        });
      } else {
        this.addFormVisible = true;
      }
    },
    // 新增提交
    addSubmit () {
      this.$refs["addForm"].validate(valid => {
        if (valid) {
          this.submitLoading = true;
          let param = Object.assign({}, this.addFormBody);
          postRegionData(param).then(res => {
            // 公共提示方法
            utils.statusinfo(this, res.data);
            this.$refs["addForm"].resetFields();
            this.submitLoading = false;
            this.addFormVisible = false;
            this.getList();
            this.$store.commit(types.REGION_CHANGE);
          });
        }
      });
    },
    // 删除功能
    delectRegion (index, row) {
      this.$confirm("此操作将删除该户型选项", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.id;
          this.listLoading = true;
          deleteRegionData(param)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.getList();
              this.$store.commit(types.REGION_CHANGE);
            })
            .catch(err => {
              console.log(err);
            });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
    },
    //更换每页数量
    SizeChangeEvent (val) {
      this.loading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent (val) {
      this.loading = true;
      this.page = val;
      this.getList();
    }
  }
};

</script>

<style scoped lang="scss">
.toolbar {
  .el-form-item {
    margin-bottom: 5px;
  }
}

.card {
  padding: 10px;
}
</style>
