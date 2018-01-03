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
              <el-select v-model="queryOption.regionId" placeholder="请选择区域" style="width:250px" @change="selectRegionChange">
                <el-option v-for="region in regionBuildingData"  :key="region.id" :value="region.id" :label="region.name" ></el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="房屋" prop="house">
              <el-select v-model="queryOption.buildingId" placeholder="请选择房屋" style="width:250px">
                <el-option v-for="building in buildingData" :key="building.id" :value="building.id" :label="building.name"></el-option>
              </el-select>
            </el-form-item>
            <el-button type="primary">查询</el-button>
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
          <el-table-column prop="name" label="区域" sortable align="center"></el-table-column>
          <el-table-column prop="description" label="描述" sortable align="center"></el-table-column>
          <el-table-column label="操作" width="300" align="center">
            <template slot-scope="scope">
              <el-button size="small" @click="showModifyDialog(scope.$index,scope.row)">编辑</el-button>
              <el-button type="danger" size="small" @click="delectHouse(scope.$index,scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
  import {} from "@/api/api";
  export default {
    data() {
      return {
        // 表格数据
        houseData: [],
        listLoading: false,
        totalNum: 0,
        page: 1,
        size: 10,
        //查询需要的数据
        buildingData: [],
        // 查询选项
        queryOption: {
          regionId: "",
          buildingId: ""
        },
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
    props: ['regionBuildingData'],
    components: {},
      computed: {
      selectRegion() {
        return this.queryOption.regionId
      }
    },
    watch: {
      // 监听选项的变动
      selectRegion(newval) {
          for(var region of this.regionBuildingData){
              if(region.id==newval)
              this.buildingData=region.buildingList
          }
      }
    },
    mounted() {
      //console.log(this.regionBuildingData)
    },
    methods: {
        //选择的区域变化时
        selectRegionChange(region){
            console.log(region)
            this.buildingData=region.buildingList
           // console.log(this.buildingData)
        },
      //显示编辑
      showModifyDialog(index, row) {
        this.modifyFormVisible = true;
        this.modifyFromBody = Object.assign({}, row);
      },
      // 删除功能
      delectRegion(index, row) {},
    }
  };

</script>

<style scoped lang="scss">


</style>
