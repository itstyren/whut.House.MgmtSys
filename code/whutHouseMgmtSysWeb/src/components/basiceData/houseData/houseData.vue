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
      <div class="toolbal">
        <el-form :inline="true">
          <el-form-item :model="queryOption">
            <el-form-item label="区域" prop="region">
              <el-select v-model="queryOption.regionId" :clearable="true" @clear="clearRegion" placeholder="全部区域" style="width:250px" @change="selectRegionChange">
                <el-option v-for="region in regionBuildingData"  :key="region.id" :value="region.id" :label="region.name"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="房屋" prop="house">
              <el-select v-model="queryOption.buildingId" :clearable="true"  @clear="clearBuilding" placeholder="全部房屋" style="width:250px">
                <el-option v-for="building in buildingData" :key="building.id" :value="building.id" :label="building.name"></el-option>
              </el-select>
            </el-form-item>
            <el-button type="primary" @click="queryData">查询</el-button>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="addFormVisible = true">新增住房</el-button>
          </el-form-item>
        </el-form>

      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-table :data="houseData" class="table" height="string" v-loading="listLoading">
          <el-table-column type="selection" width="55"></el-table-column>
          <el-table-column prop="id" label="编号" sortable align="center" width="85"></el-table-column>
          <el-table-column prop="address" label="地址" sortable align="center"></el-table-column>
          <el-table-column prop="typeName" label="住房类型" sortable align="center" width="130"></el-table-column>
          <el-table-column prop="layoutName" label="户型" sortable align="center" width="130"></el-table-column>
          <el-table-column prop="buildArea" label="面积" sortable align="center" width="85"></el-table-column>
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

    <!-- 详情页面 -->
    <el-dialog title="详情" :visible.sync="detailFormVisible" v-loading="detailLoading" class="detail-modify">
      <div class="fromBody">
        <!-- 左边文字部分 -->
        <div class="detailFrom">
          <!-- 上部分 -->
          <div class="topFrom">
            <el-form :model="detailData" label-width="110px">
              <el-form-item label="房屋编号">
                <el-input v-model="detailData.id" placeholder="请输入房屋标号" :readonly="!ismodify"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <!-- 中间部分 -->
          <div class="mainFrom">
            <!-- 中间左边 -->
            <div class="singleFrom">
              <el-form :model="detailData" label-width="110px">
                <el-form-item label="住房类型">
                  <el-input v-model="detailData.typeName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="结构">
                  <el-input v-model="detailData.structName" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="使用面积">
                  <el-input v-model="detailData.usedArea" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="所属区域">
                  <el-input v-model="detailData.id" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div class="singleFrom">
              <!-- 中间右边 -->
              <el-form :model="detailData" label-width="110px">
                <el-form-item label="户型">
                  <el-input v-model="detailData.id" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="建筑面积">
                  <el-input v-model="detailData.id" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="地下室面积">
                  <el-input v-model="detailData.id" :readonly="!ismodify"></el-input>
                </el-form-item>
                <el-form-item label="所属楼栋">
                  <el-input v-model="detailData.id" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-form>
            </div>
          </div>
          <!-- 单行的From -->
          <div class="singRowFrom">
            <el-form :model="detailData" label-width="110px">
              <el-form-item label="住房地址">
                <el-input v-model="detailData.address" placeholder="请输入住房地址" :readonly="!ismodify"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <!-- 多行的 -->
          <div class="bottomFrom">
            <div class="singleFrom">
              <el-form :model="detailData" label-width="80px">
                <el-form-item label="产权编号">
                  <el-input v-model="detailData.proId" :label='"产权编号"' :readonly="!ismodify" style="width=80px"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div class="singleFrom">
              <el-form :model="detailData" label-width="50px">
                <el-form-item label="租金">
                  <el-input v-model="detailData.rental" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-form>
            </div>
            <div class="singleFrom">
              <el-form :model="detailData" label-width="80px">
                <el-form-item label="竣工日期">
                  <el-input v-model="detailData.finishTime" :readonly="!ismodify"></el-input>
                </el-form-item>
              </el-form>
            </div>

          </div>
        </div>
        <!-- 右边图片部分 -->
        <div class="picFrom">
          <el-form :model="detailData" label-width="110px">
                          <el-form-item label="相关图片">
               <img class="file" :src="detailData.image" alt="暂无证明材料">
              </el-form-item>
            <el-form-item v-if="!ismodify" label="图片">
              <el-upload action="http://upload.qiniu.com/" :data="postData" :on-success="successUpload" :before-upload="beforePicUpload">
                <el-button size="small" type="primary">点击上传</el-button>
                <!-- <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div> -->
              </el-upload>
            </el-form-item>
                          <el-form-item label="备注">
                            <el-input v-model="detailData.remark" placeholder="请输入...."  type="textarea" :autosize="{ minRows: 2, maxRows: 4}"  :readonly="!ismodify"></el-input>
              </el-form-item>
          </el-form>

        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
import { getHouse, getHouseByBuildingID, getHouseByRegionID } from "@/api/api";
export default {
  data() {
    return {
      // 是否处于编辑状态
      ismodify: false,
      // 七牛云令牌
      postData: {
        token: this.$store.state.uploadToken
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
      detailData: [],

      // 新增表单相关数据
      submitLoading: false,
      addFormVisible: false,
      addFormBody: {
        description: "",
        name: ""
      }
    };
  },
  // 获取父组件传递的数据
  props: ["regionBuildingData"],
  components: {},
  computed: {
    selectRegion() {
      return this.queryOption.regionId;
    }
  },
  watch: {
    // 监听选项的变动
    selectRegion(newval) {
      for (var region of this.regionBuildingData) {
        if (region.id == newval) this.buildingData = region.buildingList;
      }
    },
    // 监听路由
    $route() {
      this.queryStatus = 0;
      this.getList();
    }
  },
  mounted() {},
  methods: {
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
      console.log(this.queryStatus);
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
          //console.log(res.data.data);
          this.houseData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
          //console.log(this.houseData);
        })
        .catch(err => {
          console.log(err);
        });
    },
    //选择的区域变化时
    selectRegionChange(region) {
      console.log(region);
      this.buildingData = region.buildingList;
    },
    // 显示详情页面
    showDetailDialog(index, row) {
      this.detailFormVisible = true;
      this.detailData = Object.assign({}, row);
    },
    //显示编辑
    showModifyDialog(index, row) {
      this.modifyFormVisible = true;
      this.modifyFromBody = Object.assign({}, row);
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
      this.postData = 1;
      this.queryOption.buildingId=''
    },
    // 清空搜索的楼栋时
    clearBuilding() {
      this.postData = 2;
    },

    // 上传成功钩子
    successUpload(res, file, fileLis) {
      //console.log(res)
      this.detailData.FileUrl = this.$store.state.uploadUrl + res.key;
    },
    // 删除功能
    delectRegion(index, row) {},
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
.detail-modify {
  .fromBody {
    display: flex;
    flex-direction: row;
    .detailFrom {
      display: flex;
      flex-direction: column;
      .topFrom {
        width: 50%;
        flex: 0;
      }
      .mainFrom {
        border-top: 1px solid black;
        border-bottom: 1px solid black;
        padding-top: 20px;
        display: flex;
        .singleFrom {
          flex: 1;
        }
      }
      .singRowFrom {
        padding-top: 20px;
        border-bottom: 1px solid black;
        //border-right: 1px solid black;
      }
      .bottomFrom {
        padding-top: 20px;
        display: flex;
        flex-direction: row;
        .singleFrom {
          flex: 1;
          .el-input {
            width: 130px;
          }
        }
      }
    }
    .picFrom {
      border-top: 1px solid black;
      margin-top: 63px;
      flex: 1;
      display: flex;
      flex-direction: column;
      img {
        width: 100%;
        height: 200px;
      }
    }
  }
}
</style>
