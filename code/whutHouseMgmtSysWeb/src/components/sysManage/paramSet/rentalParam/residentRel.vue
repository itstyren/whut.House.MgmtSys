<template>
  <div class="third-container">
    <!-- 面包屑导航 -->
    <div class="warp-breadcrum">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">
          <b>首页</b>
        </el-breadcrumb-item>
        <el-breadcrumb-item>租赁参数</el-breadcrumb-item>
        <el-breadcrumb-item>登记关系</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <!-- 下方主内容 -->
    <div class="warp-body">
      <!-- 工具栏 -->
      <div class="toolbal">
      </div>
      <!-- 表格区 -->
      <div class="main-data">
        <el-card class="resident-rel-card">
          <div slot="header">
            <span>当前关系</span>
            <el-button type="text" style="float:right; padding:3px 0" @click="submit">修改并提交</el-button>
          </div>
          <div class="rel-form">
            <el-table :data="residentRelData" v-loading="listLoading" style="width:100%">
              <el-table-column label="状态名" prop="houseParamName" align="center"></el-table-column>
              <el-table-column label="关系登记" width="400" align="center">
                <template slot-scope="scope">
                  <el-checkbox-group v-model="scope.row.checkedStatus">
                    <el-checkbox v-for="status in  statusData" :key="status" :label="status" :checked="checked" @change="checked=!checked">{{status}}</el-checkbox>
                  </el-checkbox-group>
                </template>
              </el-table-column>
            </el-table>

          </div>
        </el-card>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import { getResident, getHouseParam } from "@/api/api";
export default {
  data() {
    return {
      // 表格数据
      listLoading: "false",
      // 表格数据--房屋和登记关系
      residentRelData: [],
      // 房屋使用状态
      statusData: [],
      // 选择的关系
      checked: false
    };
  },
  components: {},
  // 声明周期调用
  mounted() {
    this.getList();
    this.getHouseStatus();
  },
  methods: {
    // 获取职工职务
    getList() {
      this.listLoading = true;
      let param = {};
      // http请求
      getResident(param)
        .then(res => {
          this.residentRelData = res.data.data.data;
          this.residentRelData.forEach(item => {
            if (item.houseParamRel != null)
              item.checkedStatus = item.houseParamRel.split(",");
            //console.log(item)
          });
          //console.log(this.residentRelData)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 获取房屋状态
    getHouseStatus() {
      this.listLoading = true;
      let param = {};
      // http请求
      getHouseParam(param, 3)
        .then(res => {
          let data = res.data.data.data.list;
          data.forEach(status => {
            this.statusData.push(status.houseParamName);
          });
          //this.statusData = res.data.data.data.list;
          //console.log(this.statusData);
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    submit() {
      this.$confirm("此操作将修改房屋关系并提交", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          console.log("11");
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消修改"
          });
        });
    }
  }
};
</script>

<style scoped lang="scss">
.resident-rel-card {
  width: 60%;
  height: 60%;
  margin: 100px auto;
  padding: 200px auto;
  .rel-form {
  }
}
</style>
