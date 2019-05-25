<template>
  <div class="fixForm-filter card"
       v-loading="listLoading">
    <el-form :model="queryForm"
             label-width="80px">
      <el-row>
        <el-col :span="3">
          <el-form-item label="维修类型">
            <el-select v-model="queryForm.fixContentId"
                       size="small"
                       :clearable="true"
                       placeholder="维修类型">
              <el-option v-for="v in fixType"
                         :key="v.fixParamId"
                         :value="v.fixParamId"
                         :label="v.fixParamName"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="申请时间">
            <el-date-picker v-model="setTime"
                            type="daterange"
                            size="small"
                            align="right"
                            unlink-panels
                            range-separator="-"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期"
                            :picker-options="pickerOptions"
                            value-format="yyyy-MM-dd">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="3">
          <el-form-item label="所属校区">
            <el-select v-model="campusId"
                       size="small"
                       :clearable="true"
                       @clear="clearCampus"
                       placeholder="全部校区">
              <el-option v-for="campus in campusData"
                         :key="campus.id"
                         :value="campus.id"
                         :label="campus.name"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="5">
          <el-form-item label="住房区域">
            <el-select v-model="regionId"
                       size="small"
                       :clearable="true"
                       @clear="clearRegion"
                       placeholder="全部区域">
              <el-option v-for="region in regionData"
                         :key="region.id"
                         :value="region.id"
                         :label="region.name"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="4">
          <el-form-item label="住房楼栋">
            <el-select v-model="buildingId"
                       size="small"
                       :clearable="true"
                       placeholder="全部房屋">
              <el-option v-for="building in buildingData"
                         :key="building.id"
                         :value="building.id"
                         :label="building.name"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="3"
                :offset="1">
          <el-button type="danger"
                     size="small"
                     @click="resseting">重置</el-button>
          <el-button type="primary"
                     size="small"
                     @click="queryHandle">查询</el-button>
        </el-col>
      </el-row>
    </el-form>
  </div>
</template>

<script type="text/ecmascript-6">
import { getFixParam } from "@/api/sysManage";
import { getRegionWithBuildings, getCampusData } from "@/api/basiceData";
import * as staticData from "@/utils/static";
export default {
  data () {
    return {
      queryForm: {},
      listLoading: false,
      fixType: [],
      regionData: [],
      setTime: [],
      regionBuildingData: [],
      buildingData: [],
      campusData: [],
      regionId: "",
      buildingId: "",
      campusId: "",
      pickerOptions: {
        shortcuts: staticData.shortSpanPickerOptions
      }
    };
  },
  computed: {
    selectRegion () {
      return this.regionId;
    },
    selectCampus () {
      return this.campusId;
    }
  },
  watch: {
    // 监听选项的变动
    selectRegion (newval) {
      for (var region of this.regionData) {
        if (region.id == newval) this.buildingData = region.buildingList;
      }
    },
    selectCampus (newVal) {
      this.regionData = [];
      for (var region of this.regionBuildingData) {
        if (region.campusId == newVal) this.regionData.push(region);
      }
    }
  },
  created () {
    this.initalGet();
    this.getRegionWithBuilding();
    this.getCampus();
  },
  methods: {
    initalGet () {
      this.listLoading = true;
      let params = {
        page: 1,
        size: 999
      };
      getFixParam(params, 16).then(res => {
        this.fixType = res.data.data.data.list;
        this.listLoading = false;
      });
    },
    // 获取区域信息包括楼栋
    getRegionWithBuilding () {
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
    getCampus () {
      this.listLoading = true;
      let params = {
        page: 1,
        size: 9999
      };
      getCampusData().then(res => {
        this.campusData = res.data.data.data.list;
        this.listLoading = false;
      });
    },
    queryHandle () {
      if (this.setTime != null && this.setTime.length != 0) {
        this.queryForm.startTime = this.setTime[0];
        this.queryForm.endTime = this.setTime[1];
      } else {
        this.queryForm.startTime = "";
        this.queryForm.endTime = "";
      }
      if (this.regionId != "") {
        this.queryForm.regionId = this.regionId;
      }
      if (this.buildingId != "") {
        this.queryForm.buildingId = this.buildingId;
      }
      this.queryForm.campusId = this.campusId;
      for (let v in this.queryForm) {
        if (this.queryForm[v] == "") {
          delete this.queryForm[v];
        }
      }
      const data = Object.assign({}, this.queryForm);
      this.$emit("query-fix", data);
    },
    // 重置查询表单
    resseting () {
      this.campusId = "";
      this.regionId = "";
      this.buildingId = "";
      this.queryForm = {};
    },
    // 清空搜索的区域时
    clearRegion () {
      this.regionId = "";
      this.buildingId = "";
    },
    clearCampus () {
      this.campusId = "",
        this.regionId = "";
      this.buildingId = "";
    }
  }
};
</script>

<style scoped lang="scss">
.card {
  padding: 10px;
}

.fixForm-filter {
  .el-form-item {
    margin-bottom: 5px;
  }
}
</style>
