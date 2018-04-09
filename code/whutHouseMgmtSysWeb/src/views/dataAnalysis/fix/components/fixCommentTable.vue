<template>
  <div class="card" :style="{height:height,width:width}">
    <div class="title">
      <strong>维修评价记录</strong>
    </div>
    <div class="table" ref="pageView">
      <el-table :data="commentData" class="table" height="string" v-loading="listLoading">
      </el-table>
      <el-pagination layout="total, prev, pager, next, sizes, jumper" @size-change="sizeChangeEvent" @current-change="currentChangeEvent"
        :page-size="size" :page-sizes="[10,15,20,25,30]" :total="totalNum">
      </el-pagination>
    </div>
  </div>
</template>

<script>
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
  watch: {
    filtersData(newVal) {
      this.getList(newVal);
    }
  },
  methods: {
    getList() {},
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
