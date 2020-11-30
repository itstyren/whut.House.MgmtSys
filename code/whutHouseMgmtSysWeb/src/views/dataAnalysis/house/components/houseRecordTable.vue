<template>
  <div class="card"
       :style="{height:height,width:width}">
    <div class="title">
      <strong>住房情况统计</strong>
      <export-popover class="export-btn"
                      :download-loading="downloadLoading"
                      @export="exportHandle"></export-popover>
    </div>
    <div class="table"
         ref="pageView">
      <el-table :data="houseData"
                class="table"
                @cell-click="handleClikHouse"
                height="string"
                v-loading="listLoading">
        <el-table-column prop="no"
                         label="住房号"
                         align="center"
                         width="85"></el-table-column>
        <el-table-column prop="campusName"
                         label="所属校区"
                         align="center"
                         width="130"></el-table-column>
        <el-table-column prop="address"
                         label="地址"
                         class-name="address-cursor"
                         align="center"></el-table-column>
        <el-table-column prop="layoutName"
                         label="住房户型"
                         align="center"
                         width="150"></el-table-column>
        <el-table-column prop="typeName"
                         label="住房类型"
                         align="center"
                         width="120"></el-table-column>
        <el-table-column label="使用状态"
                         align="center"
                         width="120">
          <template slot-scope="scope">
            <el-tag :type="scope.row.statusName | statusFilter">{{scope.row.statusName}}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="buildArea"
                         label="使用面积"
                         align="center"
                         width="85"></el-table-column>
        <el-table-column prop="staffName"
                         label="现住户"
                         align="center"
                         width="120"></el-table-column>
        <el-table-column prop="staffDeptName"
                         label="所在部门"
                         align="center"
                         width="150"></el-table-column>
        <el-table-column prop="bookTime"
                         label="入住时间"
                         align="center"
                         width="150"></el-table-column>
      </el-table>
      <el-pagination background
                     layout="total, prev, pager, next, sizes, jumper"
                     @size-change="sizeChangeEvent"
                     @current-change="currentChangeEvent"
                     :page-size="size"
                     :page-sizes="[10,15,20,25,30]"
                     :total="totalNum">
      </el-pagination>
    </div>
    <house-detail-dialog :show.sync="showDialog"
                         :houseId.sync="houseId"></house-detail-dialog>
  </div>
</template>

<script>
import {
  postHouseStaffRecord
} from "@/api/dataAnalysis.js";
import HouseDetailDialog from '@/components/OneHouseData'
import exportPopover from "@/components/exportPopover";
import {
  parseTime
} from "@/utils/time.js";
export default {
  components: {
    HouseDetailDialog,
    exportPopover
  },
  props: {
    width: {
      type: String,
      default: "100%"
    },
    height: {
      type: String,
      default: "350px"
    },
    autoResize: {
      type: Boolean,
      default: true
    },
    filtersData: {
      type: Object,
      default: {}
    }
  },
  data () {
    return {
      houseData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,
      houseId: 0,
      showDialog: false,
      downloadLoading: false,
    };
  },
  filters: {
    statusFilter (status) {
      const statusMap = {
        购买: "info",
        租赁: "warning",
        空闲: "success"
      };
      return statusMap[status];
    }
  },
  created () {
    this.getList()
  },
  watch: {
    filtersData (newVal) {
      this.getList(newVal);
    }
  },
  methods: {
    getList () {
      this.listLoading = true;
      let roleId = this.$store.getters.roleId
      let params = {
        page: this.page,
        size: this.size
      };
      postHouseStaffRecord(params, this.filtersData, roleId).then(res => {
        this.houseData = res.data.data.data.list;
        // console.log(this.houseData)
        this.totalNum = res.data.data.data.total;

      }).finally(() => {
        this.listLoading = false;
      })
    },
    // 更换每页数量
    sizeChangeEvent (val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    currentChangeEvent (val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    },
    // 点击地址弹开对话框
    handleClikHouse (row, column, cell, event) {
      if (column.property === "address") {
        this.showDialog = true
        this.houseId = row.houseId
      }
    },
    // 处理导出情况
    exportHandle (exportType) {
      const loading = this.$loading({
        lock: true,
        text: '加载中，请稍等。',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)',
        customClass: 'custom-download-loading'
      });
      if (exportType == 1) {
        this.handleDownload();
        this.$nextTick(() => { // 以服务的方式调用的 Loading 需要异步关闭
          loading.close();
        });
      }
      else {
        let roleId = this.$store.getters.roleId
        let param = {
          page: 1,
          size: 99999
        };
        postHouseStaffRecord(param, this.filtersData, roleId).then(res => {
          const values = res.data.data.data.list;
          this.handleDownload(values);
          this.$nextTick(() => { // 以服务的方式调用的 Loading 需要异步关闭
            loading.close();
          });

        })
      }
    },
    // 导出
    handleDownload (values) {
      let filename = "住房情况统计";
      import("@/vendor/Export2Excel").then(excel => {
        const tHeader = ["住房号", "所属校区", "地址", '住房户型', "住房类型", "使用状态", "使用面积", "现住户", "所在部门", "入住时间"];
        const filterVal = [
          "no",
          "campusName",
          "address",
          "layoutName",
          "typeName",
          "statusName",
          "buildArea",
          "staffName",
          "staffDeptName",
          "bookTime"
        ];
        let list = [];
        if (arguments.length == 0) list = this.houseData;
        else list = arguments[0];
        const data = this.formatJson(filterVal, list); // 用于自行洗数据
        let date = new Date();
        filename = filename + `(${parseTime(date, "{y}-{m}-{d}")})`;
        excel.export_json_to_excel(tHeader, data, filename);
      })
    },
    formatJson (filterVal, jsonData) {
      return jsonData.map(v =>
        filterVal.map(j => {
          return v[j];
        })
      );
    },
  }
};

</script>


<style scoped lang="scss">
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
  height: 40px;
  &::after {
    content: "";
    width: 95%;
    height: 2px;
    background-color: #dcdcdc;
    position: absolute;
    bottom: -10px;
    z-index: 1;
    left: 1%;
    right: 1%;
  }
  .export-btn {
    position: absolute;
    top: 5px;
    right: 57px;
  }
}

.table {
  margin-top: 30px;
  height: calc(100% - 55px);
}
</style>
