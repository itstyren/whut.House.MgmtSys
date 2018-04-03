<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>基础数据</el-breadcrumb-item>
        <el-breadcrumb-item>住房管理</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbar">
        <el-form :inline="true">
          <el-form-item :model="queryOption">
            <el-form-item label="区域" prop="region">
              <el-select v-model="queryOption.regionId" :clearable="true" @clear="clearRegion" placeholder="全部区域" style="width:250px" @change="selectRegionChange">
                <el-option v-for="region in regionBuildingData" :key="region.id" :value="region.id" :label="region.name"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="房屋" prop="house">
              <el-select v-model="queryOption.buildingId" :clearable="true" @clear="clearBuilding" placeholder="全部房屋" style="width:250px">
                <el-option v-for="building in buildingData" :key="building.id" :value="building.id" :label="building.name"></el-option>
              </el-select>
            </el-form-item>
            <el-button type="primary" @click="queryData">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="showAddForm()">新增住房</el-button>
          </el-form-item>
        </el-form>
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="houseData" class="table" height="string" v-loading="listLoading">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="no" label="编号" sortable align="center" width="85"></el-table-column>
          <el-table-column prop="address" label="地址" align="center"></el-table-column>
          <el-table-column prop="typeName" label="住房类型" align="center" width="130"></el-table-column>
          <el-table-column prop="layoutName" label="户型" align="center" width="130"></el-table-column>
          <el-table-column label="面积" sortable align="center" width="85">
            <template slot-scope="scope">
              <el-popover trigger="hover" placement="top">
                <p>使用面积: {{ scope.row.usedArea }}</p>
                <p>建筑面积: {{ scope.row.buildArea }}</p>
                <p>地下室面积: {{ scope.row.basementArea }}</p>
                <div slot="reference" class="name-wrapper">
                  <el-tag size="medium" type="info">{{ scope.row.buildArea }}</el-tag>
                </div>
              </el-popover>
            </template>
          </el-table-column>
          <el-table-column prop="rental" label="租金" sortable align="center" width="85"></el-table-column>
          <el-table-column label="操作" width="300" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showDetailDialog(scope.$index,scope.row)">详情</el-button>
              <el-button type="success" size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="delectHouse(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="SizeChangeEvent" @current-change="CurrentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>

    <!-- 详情表单 -->
    <el-dialog :title="title" :visible.sync="detailFormVisible" v-loading="detailLoading" class="detail-modify" @close="modifyFromClose">
      <el-form :model="detailData" label-width="85px" ref="modifyFrom" :rules="rules" status-icon>
        <!-- 上部分 -->
        <div class="top-line">
          <el-row>
            <el-col :span="8">
              <el-form-item label="房屋编号" prop="no">
                <el-input v-model="detailData.no" placeholder="请输入房屋标号" :readonly="!ismodify"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8" v-if="!ismodify" >
              <el-form-item label="校区" prop="name">
                <el-input v-model="detailData.campusName" :readonly="!ismodify"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <!-- 中间部分 -->
        <el-row>
          <el-col :span="16">
            <el-row>
              <el-col :span="12">
                <el-form-item v-if="!ismodify" label="住房类型">
                  <el-input v-model="detailData.typeName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-else label="住房类型" prop="type">
                  <el-select v-model="detailData.type" :clearable="true" placeholder="请选择房屋类型">
                    <el-option v-for="param in addFormParam[1]" :key="param.id" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item v-if="!ismodify" label="住房户型">
                  <el-input v-model="detailData.layoutName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-else label="住房户型" prop="layout">
                  <el-select v-model="detailData.layout" :clearable="true">
                    <el-option v-for="param in addFormParam[2]" :key="param.id" placeholder="请选择房屋户型" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item v-if="!ismodify" label="房屋结构">
                  <el-input v-model="detailData.structName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-else label="房屋结构" prop="struct">
                  <el-select v-model="detailData.struct" :clearable="true" placeholder="请选择房屋结构">
                    <el-option v-for="param in addFormParam[4]" :key="param.id" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="建筑面积">
                  <el-input v-model="detailData.buildArea" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="使用面积" prop="usedArea">
                  <el-input v-model="detailData.usedArea" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="地下室面积">
                  <el-input v-model="detailData.basementArea" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item v-if="!ismodify" label="所属区域">
                  <el-input v-model="detailData.regionName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-else label="所属区域" prop="region">
                  <el-select v-model="detailData.regionId" :clearable="true" placeholder="请选择区域">
                    <el-option v-for="region in regionBuildingData" :key="region.id" :value="region.id" :label="region.name"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item v-if="!ismodify" label="所属楼栋">
                  <el-input v-model="detailData.buildingName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item v-if="ismodify" label="所属楼栋" prop="buildingId">
                  <el-select v-model="detailData.buildingId" :clearable="true" placeholder="请先选择区域">
                    <el-option v-for="building in regionBuilding" :key="building.id" :value="building.id" :label="building.name"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="住房地址">
                  <el-input v-model="detailData.address" placeholder="请输入住房地址" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <!-- 多行的 -->
            <el-row>
              <el-col :span="8">
                <el-form-item label="产权编号">
                  <el-input v-model="detailData.proId" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="月租租金">
                  <el-input v-model="detailData.rental" readonly></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="竣工日期">
                  <el-input v-model="detailData.finishTime" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <!-- 中间右边 -->
          <el-col :span="8">
            <el-row>
              <el-col :span="24">
                <el-form-item label="相关图片">
                  <img class="file" :src="detailData.image" alt="暂无证明材料">
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item v-if="ismodify" label="上传图片">
                  <el-upload action="http://upload.qiniu.com/" :data="postData" :on-success="successUpload" :before-upload="beforePicUpload">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <!-- <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div> -->
                  </el-upload>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="备注">
                  <el-input v-model="detailData.remark" placeholder="请输入...." type="textarea" :autosize="{ minRows: 2, maxRows: 4}" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item v-if="ismodify" label=" " style="margin-top:20px;margin-left:40px">
                  <el-button type="primary" @click.native="modifySubmit">提交</el-button>
                  <el-button @click="cancelAdd">取消</el-button>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-form>
    </el-dialog>

    <!-- 新增表单 -->
    <el-dialog title="新增住房" :visible.sync="addFormVisible" v-loading="submitLoading" class="detail-modify">
      <el-form :model="addFormBody" label-width="110px" ref="addForm" :rules="rules" status-icon>

        <div class="top-line">
          <!-- 上部分 -->
          <el-row>
            <el-col :span="8">
              <el-form-item label="房屋编号" prop="no">
                <el-input v-model="addFormBody.no" placeholder="请输入房屋标号"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </div>
        <el-row>
          <el-col :span="16">
            <el-row>
              <el-col :span="12">
                <el-form-item label="住房类型" prop="type">
                  <el-select v-model="addFormBody.type" :clearable="true" placeholder="请选择房屋类型">
                    <el-option v-for="param in addFormParam[1]" :key="param.id" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="户型" prop="layout">
                  <el-select v-model="addFormBody.layout" :clearable="true">
                    <el-option v-for="param in addFormParam[2]" :key="param.id" placeholder="请选择房屋户型" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="结构" prop="struct">
                  <el-select v-model="addFormBody.struct" :clearable="true" placeholder="请选择房屋结构">
                    <el-option v-for="param in addFormParam[4]" :key="param.id" :value="param.houseParamId" :label="param.houseParamName"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="建筑面积" prop="buildArea">
                  <el-input v-model="addFormBody.buildArea" placeholder="请输入建筑面积"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="使用面积" prop="usedArea">
                  <el-input v-model="addFormBody.usedArea" placeholder="请输入使用面积"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="地下室面积" prop="basementArea">
                  <el-input v-model="addFormBody.basementArea" placeholder="请输入地下室面积"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item label="所属区域" prop="regionId">
                  <el-select v-model="addFormBody.regionId" :clearable="true" placeholder="请选择区域">
                    <el-option v-for="region in regionBuildingData" :key="region.id" :value="region.id" :label="region.name"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item label="所属楼栋" prop="buildingId">
                  <el-select v-model="addFormBody.buildingId" :clearable="true" placeholder="请先选择区域">
                    <el-option v-for="building in regionBuilding" :key="building.id" :value="building.id" :label="building.name"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="住房地址" prop="address">
                  <el-input v-model="addFormBody.address" placeholder="请输入住房地址"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="8">
                <el-form-item label="产权编号" prop="proId">
                  <el-input v-model="addFormBody.proId" :label='"产权编号"' style="width=80px" placeholder="请输入产权编号"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="租金" prop="rental">
                  <el-input v-model="addFormBody.rental" placeholder="请输入租金"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="竣工日期" prop="finishTime">
                  <el-date-picker v-model="addFormBody.finishTime" placeholder="请选择日期" format="yyyy-MM-dd" value-format="yyyy-MM-dd"></el-date-picker>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8">
            <el-row>
              <el-col :span="24">
                <el-form-item label="上传图片">
                  <el-upload action="http://upload.qiniu.com/" :limit="1" list-type="picture-card" :data="postData" :on-success="successUpload"
                    :before-upload="beforePicUpload">
                    <el-button size="small" type="primary">点击上传</el-button>
                    <!-- <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div> -->
                  </el-upload>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item label="备注">
                  <el-input v-model="addFormBody.remark" placeholder="请输入...." type="textarea" :autosize="{ minRows: 2, maxRows: 4}"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-form-item>
                  <el-button type="primary" @click.native="addSubmit">提交</el-button>
                  <el-button @click="cancelAdd">取消</el-button>
                </el-form-item>
              </el-col>
            </el-row>
          </el-col>
        </el-row>

        <!-- 右边图片部分 -->
        <div class="picFrom">

        </div>
      </el-form>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import {
    getHouse,
    getHouseByBuildingID,
    getHouseByRegionID,
    postHouseData,
    deleteHouseData,
    putHouseData,
  } from "@/api/basiceData";
  import {
    getHouseParam
  } from "@/api/sysManage";
  import {
    checkNum,
    checkNULL
  } from "@/assets/function/validator";
  import utils from "@/utils/index.js";
  export default {
    data() {
      return {
        // 是否处于编辑状态
        ismodify: false,
        // 七牛云令牌
        postData: {
          token: this.$store.getters.qiniuToken
        },
        // 表格数据
        houseData: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10,

        //查询需要的数据
        buildingData: [],
        queryStatus: 0, //0 代表列表查，1代表全部，2代表区域查，3代表楼栋查
        // 查询选项
        queryOption: {
          regionId: "",
          buildingId: ""
        },
        // 详情表单数据
        detailFormVisible: false,
        detailLoading: false,
        detailData: {},
        title: "详情",
        modified: false,
        // 新增表单相关数据
        submitLoading: false,
        addFormVisible: false,
        addFormBody: {
          no: "",
          type: ""
        },
        addFormParam: [],
        regionBuilding: [],
        // 表单验证规则
        rules: {
          no: [{
              required: true,
              message: "请输入住房编号",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          type: [{
            validator: checkNULL,
            trigger: "change"
          }],
          struct: {
            validator: checkNULL,
            trigger: "change"
          },
          usedArea: [{
              required: true,
              message: "请输入使用面积",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          regionId: {
            validator: checkNULL,
            trigger: "change"
          },
          layout: {
            validator: checkNULL,
            trigger: "change"
          },
          buildArea: [{
              required: true,
              message: "请输入建筑面积",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          basementArea: [{
              required: true,
              message: "请输入地下室面积",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          buildingId: {
            validator: checkNULL,
            trigger: "change"
          },
          address: {
            required: true,
            message: "请输入地址",
            trigger: "blur"
          },
          proId: [{
              required: true,
              message: "请输入使用产权编号",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          rental: [{
              required: true,
              message: "请输入使用租金",
              trigger: "blur"
            },
            {
              validator: checkNum,
              trigger: "blur"
            }
          ],
          finishTime: {
            required: true,
            message: "请选择使用竣工时间",
            trigger: "blur"
          }
        }
      };
    },
    // 获取父组件传递的数据
    props: ["regionBuildingData"],
    computed: {
      selectRegion() {
        return this.queryOption.regionId;
      },
      addSelectRegion() {
        return this.addFormBody.regionId || this.detailData.regionId;
      }
    },
    watch: {
      // 监听选项的变动
      selectRegion(newval) {
        for (var region of this.regionBuildingData) {
          if (region.id == newval) this.buildingData = region.buildingList;
        }
      },
      // 监听新增表单区域选择变动
      addSelectRegion(newval) {
        // console.log('2')
        //this.addFormBody.buildingId=null
        for (var region of this.regionBuildingData) {
          if (region.id == newval) this.regionBuilding = region.buildingList;
        }
      },
      // 监听路由
      $route() {
        this.queryStatus = 0;
        this.getList();
      }
    },
    methods: {
      // 判定查询的类型
      queryData() {
        if (this.queryOption.regionId == "") {
          this.queryStatus = 1;
          this.getList();
        } else if (this.queryOption.buildingId == "") {
          this.queryStatus = 2;
          this.getList();
        } else {
          this.queryStatus = 3;
          this.getList();
        }
      },
      // 获取房屋列表
      getList() {
        //console.log(this.queryStatus);
        this.listLoading = true;
        let param = {
          page: this.page,
          size: this.size
        };
        // 在这里判断执行哪种查询方法
        if (this.queryStatus == 0) {
          var switchFunction = getHouseByBuildingID;
          var queryID = this.$route.params.id;
        } else if (this.queryStatus == 1) var switchFunction = getHouse;
        else if (this.queryStatus == 2) {
          var switchFunction = getHouseByRegionID;
          var queryID = this.queryOption.regionId;
        } else {
          var switchFunction = getHouseByBuildingID;
          var queryID = this.queryOption.buildingId;
        }
        switchFunction(param, queryID)
          .then(res => {
            this.houseData = res.data.data.data.list;
            this.totalNum = res.data.data.data.total;
            this.listLoading = false;
            //console.log(this.houseData);
          })
          .catch(err => {
            console.log(err);
          });
      },
      // 新增表单需要填充的
      addFromGetList() {
        this.submitLoading = true;
        let param,
          paramNum = 4;
        for (let paramClass = 1; paramClass <= paramNum; paramClass++) {
          getHouseParam(param, paramClass)
            .then(res => {
              //console.log(res.data.data);
              this.addFormParam[paramClass] = res.data.data.data.list;
              // console.log(res.data.data.list)
              if (this.addFormParam[4] != null) this.submitLoading = false;
            })
            .catch(err => {
              console.log(err);
            });
        }
      },
      // 新增表单取消时
      cancelAdd() {
        this.$refs["addForm"].resetFields();
        this.addFormVisible = false;
      },
      // 新增表单提交
      addSubmit() {
        //console.log(this.addFormBody);
        this.$refs["addForm"].validate(valid => {
          if (valid) {
            this.submitLoading = true;
            //复制字符串
            let para = Object.assign({}, this.addFormBody);
            postHouseData(para).then(res => {
              this.submitLoading = false;
              //公共提示方法，传入当前的vue以及res.data
              utils.statusinfo(this, res.data);
              this.$refs["addForm"].resetFields();
              this.addFormVisible = false;
            });
          }
        });
      },
      //选择的区域变化时
      selectRegionChange(region) {
        this.buildingData = region.buildingList;
      },
      // 显示新增页面
      showAddForm() {
        // if (this.addFormParam == "")
        this.addFromGetList();
        this.addFormVisible = true;
      },
      // 显示详情页面
      showDetailDialog(index, row) {
        this.title = "房屋详情";
        this.ismodify = false;
        this.detailFormVisible = true;
        this.detailData = Object.assign({}, row);
      },
      //显示编辑
      showModifyDialog(index, row) {
        this.modified = false;
        this.title = "房屋编辑";
        this.ismodify = true;
          if (this.addFormParam.length == 0) {
            let param,
              paramNum = 4;
            for (let paramClass = 1; paramClass <= paramNum; paramClass++) {
              getHouseParam(param, paramClass)
                .then(res => {
      this.$set(this.addFormParam,paramClass, res.data.data.data.list);                  
                  //this.addFormParam[paramClass] = res.data.data.data.list;
                  if (this.addFormParam[4] != null) this.submitLoading = false;
                })
                .catch(err => {
                  console.log(err);
                });
            }
          }
        this.detailFormVisible = true;
        this.detailData = Object.assign({}, row);
      },
      //编辑提交
      modifySubmit() {
        this.$refs["modifyFrom"].validate(valid => {
          if (valid) {
            this.detailLoading = true;
            let param = Object.assign({}, this.detailData);
            param.regionId = this.$route.params.id;
            putHouseData(param).then(res => {
              utils.statusinfo(this, res.data);
              this.detailLoading = false;
              this.$refs["modifyFrom"].resetFields();
              this.modified = true;
              this.detailFormVisible = false;
              this.getList();
            });
          }
        });
      },
      // 编辑框关闭时候回调
      modifyFromClose() {
        if (this.modified == false && this.title != "详情") {
          this.$notify.info({
            title: "提示",
            message: "已取消编辑"
          });
          this.$refs["modifyFrom"].resetFields();
        }
      },
      //在图片提交前进行验证
      beforePicUpload(file) {
        const isJPG = file.type === "image/jpeg";
        const isPNG = file.type === "image/png";
        const isLt2M = file.size / 1024 / 1024 < 2;
        if (!isJPG && !isPNG) {
          this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
          return false;
        } else if (!isLt2M) {
          this.$message.error("上传证明图片大小不能超过 2MB!");
          return false;
        }
        return true;
      },
      // 清空搜索的区域时
      clearRegion() {
        this.queryStatus = 1;
        this.queryOption.buildingId = "";
      },
      // 清空搜索的楼栋时
      clearBuilding() {
        this.queryStatus = 2;
      },

      // 上传成功钩子
      successUpload(res, file, fileLis) {
        //console.log(res)
        if (this.addFormVisible == false) {
          this.detailData.image = this.$store.getters.qiniuURL + res.key;
        } else this.addFormBody.image = this.$store.state.qiniuURL + res.key;
        //console.log(this.addFormBody.image);
      },
      // 删除功能
      delectHouse(index, row) {
        this.$confirm("此操作将删除该房屋", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          })
          .then(() => {
            let param = row.id;
            this.listLoading = true;
            deleteHouseData(param)
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
      //更换每页数量
      SizeChangeEvent(val) {
        this.listLoading = true;
        this.size = val;
        this.getList();
      },
      //页码切换时
      CurrentChangeEvent(val) {
        this.listLoading = true;
        this.page = val;
        this.getList();
      }
    }
  };

</script>

<style scoped lang="scss">
  .top-line {
    position: relative;
    margin-bottom: 5px;
    &::after {
      content: "";
      width: 95%;
      height: 2px;
      background-color: #dcdcdc;
      position: absolute;
      bottom: 5px;
      z-index: 1; //left: 5%;
      right: 2%;
    }
  }

  img {
    width: 100%;
    height: 200px;
  }

</style>
