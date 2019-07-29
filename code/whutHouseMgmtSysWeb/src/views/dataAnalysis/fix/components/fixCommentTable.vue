<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修评价记录</strong>
    </div>
    <div class="table" ref="pageView">
      <el-table :data="commentData" class="table" height="string" v-loading="listLoading">
          <el-table-column prop="id" label="单号" align="center"  width="85"></el-table-column>
          <el-table-column prop="applyTime" label="申请时间" align="center"  width="100"></el-table-column>
          <el-table-column prop="fixContentName" label="维修类型" align="center"  width="120"></el-table-column>
          <el-table-column prop="staffName" label="申请人" align="center" width="120" ></el-table-column>
          <el-table-column prop="campusName" label="所在校区" align="center" width="100"></el-table-column>
          <el-table-column prop="address" label="住房地址" align="center"></el-table-column>
          <el-table-column prop="fixMoney" label="维修金额" sortable align="center"  width="100"></el-table-column>
          <el-table-column prop="ratingDescription" label="维修评价" align="center"></el-table-column>
          <el-table-column  label="住户评分" align="center" sortable width="150">
                    <template slot-scope="scope">
          <my-icon v-for="n in +scope.row.ratings" icon-class="xingxing" class="icon-star" :key="n"></my-icon>
        </template>
          </el-table-column>
      </el-table>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { postFixFormRecord } from "@/api/dataAnalysis.js";
export default {
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
  data() {
    return {
      commentData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10
    };
  },
  created () {
    this.getList()
  },
  watch: {
    filtersData(newVal) {
      this.getList(newVal);
    }
  },
  methods: {
    getList() {
      this.listLoading=false
      let params = {
        page: this.page,
        size: this.size
      };
      postFixFormRecord(params,this.filtersData).then(res=>{
         this.commentData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          this.listLoading = false;
      })
    },
    // 更换每页数量
    sizeChangeEvent(val) {
      this.listLoading = true;
      this.size = val;
      this.getList();
    },
    //页码切换时
    currentChangeEvent(val) {
      this.listLoading = true;
      this.page = val;
      this.getList();
    }
  }
};
</script>


<style scoped lang="scss">
.title {
  padding: 10px 0 0 10px;
  position: relative;
  width: 100%;
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
}

.table {
  margin-top: 30px;
  height: calc(100% - 55px);
}
</style>
