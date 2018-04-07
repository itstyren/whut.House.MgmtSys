<template>
<div class="house-filter card">
  <el-form :model="queryForm" label-width="100px">
      <el-row>
        <el-col :span="4">
          <el-form-item label="住房类型">
            <el-select v-model="queryForm.houseTypeId" size="small" :clearable="true" placeholder="所有类型">
              <el-option v-for="v in typeData" :key="v.houseParamId" :value="v.houseParamId" :label="v.houseParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="使用状态">
            <el-select v-model="queryForm.useStatusId" size="small" :clearable="true" placeholder="所有状态">
              <el-option v-for="v in statusData" :key="v.houseParamId" :value="v.houseParamId" :label="v.houseParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="住房结构">
            <el-select v-model="queryForm.structId" size="small" :clearable="true" placeholder="所有结构">
              <el-option v-for="v in structData" :key="v.houseParamId" :value="v.houseParamId" :label="v.houseParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="住房户型">
            <el-select v-model="queryForm.layoutId" size="small" :clearable="true" placeholder="所有户型">
              <el-option v-for="v in layoutData" :key="v.houseParamId" :value="v.houseParamId" :label="v.houseParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="租金">
            <el-row>
              <el-col :span="9">
                <el-input v-model="minRental" size="small" placeholder=""></el-input>
              </el-col>
              <el-col :span="4" style=" text-align: center;">
                <span>至</span>
              </el-col>
              <el-col :span="9">
                <el-input v-model="maxRental" size="small" placeholder=""></el-input>
              </el-col>
            </el-row>
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
          <el-form-item label="住房区域">
            <el-select v-model="regionId" size="small" :clearable="true" @clear="clearRegion" placeholder="全部区域">
              <el-option v-for="region in regionBuildingData" :key="region.id" :value="region.id" :label="region.name"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="住房楼栋">
            <el-select v-model="buildingId" size="small" :clearable="true" placeholder="全部房屋">
              <el-option v-for="building in buildingData" :key="building.id" :value="building.id" :label="building.name"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4" :offset="1">
          <el-button type="danger" size="small" @click="resseting">重置</el-button>
          <el-button type="primary" size="small" @click="queryHandle" >查询</el-button>
        </el-col>
      </el-row>
  </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
import { getRegionWithBuildings } from "@/api/basiceData";
import { getHouseParam } from "@/api/sysManage";
export default {
  data() {
    return {
      queryForm: {},
      minRental: "",
      maxRental: "",
      regionId: "",
      buildingId: "",
      time: [],
      typeData: [],
      layoutData: [],
      statusData: [],
      structData: [],
      regionBuildingData: [],
      buildingData: []
    };
  },
  computed: {
    selectRegion() {
      return this.regionId;
    }
  },
  watch: {
    // 监听选项的变动
    selectRegion(newval) {
      for (var region of this.regionBuildingData) {
        if (region.id == newval) this.buildingData = region.buildingList;
      }
    }
  },
  created() {
    this.initalGet();
    this.getRegionWithBuilding();
  },
  methods: {
    //初始查询条件获取
    initalGet() {
      this.listLoading = true;
      let param = {
        size: 999
      };
      // 类型为1
      getHouseParam(param, 1)
        .then(res => {
          this.typeData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 户型为2
      getHouseParam(param, 2)
        .then(res => {
          this.layoutData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 状态为3
      getHouseParam(param, 3)
        .then(res => {
          this.statusData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
      // 结构为8
      getHouseParam(param, 4)
        .then(res => {
          this.structData = res.data.data.data.list;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 获取区域信息包括楼栋
    getRegionWithBuilding() {
      this.listLoading = true;
      let param = {};
      getRegionWithBuildings(param)
        .then(res => {
          this.regionBuildingData = res.data.data.data;
          this.regionBuildingData.forEach(region => {
            let flag = region.name.indexOf("（");
            if (flag != -1) {
              region.name = region.name.substring(0, flag);
            }
          });
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    queryHandle() {
      if (this.minRental != "" || this.maxRental != "") {
        this.queryForm.rentalScope = {
          minRental: this.minRental,
          maxRental: this.maxRental
        };
      }
      if (this.regionId != "") {
        this.queryForm.regionId = this.regionId;
      }
      if (this.buildingId != "") {
        this.queryForm.buildingId = this.buildingId;
      }
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") {
          delete this.queryForm[v];
        }
      }
      this.listLoading = true;
      //console.log(this.queryForm);
      const data = Object.assign({}, this.queryForm);
      this.$emit("query-house", data);
    },
    // 重置查询表单
    resseting() {
      this.time = [];
      this.regionId = "";
      this.buildingId = "";
      this.minRental = "";
      this.maxRental = "";
      this.queryForm = {};
    },
    // 清空搜索的区域时
    clearRegion() {
      this.queryForm.buildingId = "";
    }
  }
};
</script>

<style scoped lang="scss">
.house-filter {
  .el-form-item {
    margin-bottom: 5px;
  }
}
.card {
  padding: 10px;
}
</style>
