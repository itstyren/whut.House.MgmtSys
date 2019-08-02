<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>楼栋管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar "
           style="padding-left:10px;">
        <el-form :inline="true">
          <!-- <el-select v-model="selectRegion" placeholder="请选择区域">
            <el-option v-for="region of buildingData" :key="region.id"></el-option>
          </el-select> -->
          <el-button type="primary"
                     @click="addFormVisible = true"
                     style="margin-left:20px;">新增楼栋</el-button>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <div class="card "
             style="height:95%">
          <el-table :data="buildingData"
                    class="table"
                    height="93%"
                    v-loading="listLoading">
            <el-table-column prop="name"
                             label="楼栋名称"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="finishTime"
                             label="竣工时间"
                             width="120"
                             sortable
                             align="center"></el-table-column>
            <el-table-column prop="floorArea"
                             label="占地面积"
                             width="80"
                             align="center"></el-table-column>
            <el-table-column prop="usedArea"
                             label="使用面积"
                             width="80"
                             align="center"></el-table-column>
            <el-table-column prop="unitCount"
                             label="单元数"
                             width="80"
                             align="center"></el-table-column>
            <el-table-column prop="floorCount"
                             label="楼层数"
                             width="80"
                             align="center"></el-table-column>
            <el-table-column prop="supportFund"
                             label="维修基金"
                             width="80"
                             align="center"></el-table-column>
            <el-table-column prop="manager"
                             label="负责人"
                             width="100"
                             align="center"></el-table-column>
            <el-table-column prop="description"
                             label="楼栋描述"
                             align="center"></el-table-column>
            <el-table-column label="操作"
                             width="170"
                             align="center">
              <template slot-scope="scope">
                <el-button size="small"
                           @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
                <el-button type="danger"
                           size="small"
                           @click="delectBuilding(scope.$index,scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination background 
                         layout="total, prev, pager, next, sizes, jumper"
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
    <el-dialog title="新增楼栋"
               class="paramDialog-large"
               :visible.sync="addFormVisible"
               v-loading="submitLoading">
      <el-form :model="addFormBody"
               label-width="100px"
               ref="addForm"
               :rules="rules"
               auto>
        <el-row>
          <el-col :span="11">
            <el-form-item label="楼栋名称"
                          prop="name">
              <el-input v-model="addFormBody.name"
                        placeholder="请输入楼栋名称"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="竣工时间"
                          prop="finishTime">
              <el-date-picker v-model="addFormBody.finishTime"
                              placeholder="竣工时间"
                              format="yyyy 年 MM 月 dd 日"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="占地面积"
                          prop="floorArea">
              <el-input v-model="addFormBody.floorArea"
                        placeholder="请输入占地面积"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="使用面积"
                          prop="usedArea">
              <el-input v-model="addFormBody.usedArea"
                        placeholder="请输入使用面积"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="楼层数"
                          prop="floorCount">
              <el-input v-model="addFormBody.floorCount"
                        placeholder="请输入楼层数"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="单元数"
                          prop="unitCount">
              <el-input v-model="addFormBody.unitCount"
                        placeholder="请输入单元数"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="负责人"
                          prop="manager">
              <el-input v-model="addFormBody.manager"
                        placeholder="请输入负责人"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="维修基金"
                          prop="supportFund">
              <el-input v-model="addFormBody.supportFund"
                        placeholder="请输入维修基金"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="14">
            <el-form-item label="描述"
                          prop="description">
              <el-input v-model="addFormBody.description"
                        type="textarea"
                        :rows="3"
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
    <el-dialog title="编辑住房类型"
               class="paramDialog-large"
               :visible.sync="modifyFormVisible"
               v-loading="modifyLoading">
      <el-form :model="modifyFromBody"
               label-width="100px"
               ref="modifyFrom"
               :rules="rules">
        <el-row>
          <el-col :span="11">
            <el-form-item label="楼栋名称"
                          prop="name">
              <el-input v-model="modifyFromBody.name"
                        placeholder="请输入楼栋名称"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="竣工时间"
                          prop="finishTime">
              <el-date-picker v-model="modifyFromBody.finishTime"
                              placeholder="竣工时间"
                              format="yyyy 年 MM 月 dd 日"
                              value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="占地面积"
                          prop="floorArea">
              <el-input v-model="modifyFromBody.floorArea"
                        placeholder="请输入占地面积"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="使用面积"
                          prop="usedArea">
              <el-input v-model="modifyFromBody.usedArea"
                        placeholder="请输入使用面积"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="楼层数"
                          prop="floorCount">
              <el-input v-model="modifyFromBody.floorCount"
                        placeholder="请输入楼层数"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="单元数"
                          prop="unitCount">
              <el-input v-model="modifyFromBody.unitCount"
                        placeholder="请输入单元数"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="11">
            <el-form-item label="负责人"
                          prop="manager">
              <el-input v-model="modifyFromBody.manager"
                        placeholder="请输入负责人"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="10"
                  :offset="2">
            <el-form-item label="维修基金"
                          prop="supportFund">
              <el-input v-model="modifyFromBody.supportFund"
                        placeholder="请输入维修基金"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="14">
            <el-form-item label="描述"
                          prop="description">
              <el-input v-model="modifyFromBody.description"
                        type="textarea"
                        :rows="3"
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
  getbuildingDataByID,
  postBuildingData,
  putBuildingData,
  deleteBuildingData
} from "@/api/basiceData";
import utils from "@/utils/index.js";

export default {
  data () {
    return {
      // 表格数据
      buildingData: [],
      listLoading: false,

      selectRowIndex: "",
      totalNum: 0,
      page: 1,
      size: 10,

      // 表单规则验证
      rules: {
        name: {
          required: true,
          message: "楼栋名称不能为空",
          trigger: "blur"
        },
        finishTime: {
          required: true,
          message: "竣工时间不能为空",
          trigger: "blur"
        },
        floorArea: [{
          required: true,
          message: "占地面积不能为空",
          trigger: "blur"
        },
        {
          pattern: /^\d+(\.\d+)?$/,
          message: "占地面积必须为整数或者小数",
          trigger: "blur"
        }
        ]
      },

      //编辑表单相关数据
      modifyFormVisible: false,
      modifyLoading: false,
      modifyFromBody: {
        name: "",
        finishTime: "",
        floorArea: "",
        floorCount: "",
        usedArea: "",
        description: ""
      },

      // 新增表单相关数据
      submitLoading: false,
      addFormVisible: false,
      addFormBody: {
        name: "",
        finishTime: "",
        floorArea: "",
        floorCount: "",
        usedArea: "",
        description: ""
      }
    };
  },
  // created(){
  //   console.log(this.$route.params.id)
  // },
  created () {
    this.getList();
  },
  watch: {
    $route: "getList"
  },
  methods: {
    // 获取列表
    getList () {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      let regionID = this.$route.params.id;
      getbuildingDataByID(param, regionID)
        .then(res => {
          // console.log(res.data.data)
          this.buildingData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 删除功能
    delectBuilding (index, row) {
      this.$confirm("此操作将删除该户型选项", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let param = row.id;
          this.listLoading = true;
          deleteBuildingData(param)
            .then(res => {
              // 公共提示方法
              utils.statusinfo(this, res.data);
              this.getList();
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
    // 新增提交
    addSubmit () {
      this.$refs["addForm"].validate(valid => {
        if (valid) {
          this.submitLoading = true;
          let param = Object.assign({}, this.addFormBody);
          param.regionId = this.$route.params.id;
          postBuildingData(param).then(res => {
            // 公共提示方法
            utils.statusinfo(this, res.data);
            this.$refs["addForm"].resetFields();
            this.submitLoading = false;
            this.addFormVisible = false;
            this.getList();
          });
        }
      });
    },
    //显示编辑
    showModifyDialog (index, row) {
      this.modifyFormVisible = true;
      this.modifyFromBody = Object.assign({}, row);
      this.selectRowIndex = index;
      //console.log(this.selectRowIndex)
    },
    //编辑提交
    modifySubmit () {
      this.$refs["modifyFrom"].validate(valid => {
        if (valid) {
          this.modifyLoading = true;
          let param = Object.assign({}, this.modifyFromBody);
          param.regionId = this.$route.params.id;
          putBuildingData(param).then(res => {
            utils.statusinfo(this, res.data);
            this.modifyLoading = false;
            this.modifyFormVisible = false;
            this.getList();
          });
        }
      });
    },
    //更换每页数量
    SizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    CurrentChangeEvent (val) {
      this.listLoading = true;
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
