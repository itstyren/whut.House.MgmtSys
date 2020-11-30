<template>
  <div class="second-container">
    <div class="main-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>租赁管理</el-breadcrumb-item>
            <el-breadcrumb-item>租赁申请管理</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">
          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="card">
              <el-table :data="hireFormData"
                        class="table"
                        height="75vh"
                        style="border-radius: 10px;"
                        v-loading="listLoading">
                <!-- <el-table-column type="selection" width="55"></el-table-column> -->
                <!-- <el-table-column type="index" width="65" label="序号" style="text-aligin:center" align="center"></el-table-column> -->
                <el-table-column prop="id"
                                 label="申请号"
                                 align="center"></el-table-column>
                <el-table-column prop="applyTime"
                                 label="申请时间"
                                 sortable
                                 align="center"></el-table-column>
                <el-table-column label="处理状态"
                                 prop="hireState"
                                 align="center"
                                 :filters="statuseArray"
                                 :filter-method="filterHandle">
                  <template slot-scope="scope">
                    <el-tag :type="scope.row.hireState | statusFilter">{{scope.row.hireState}}</el-tag>
                  </template>
                </el-table-column>
                <el-table-column prop="isOver"
                                 label="合同签订"
                                 :formatter="isOverFormat"
                                 align="center">
                  <template slot-scope="scope">
                    <my-icon v-if="scope.row.approveState=='通过'"
                             icon-class="dengji1"></my-icon>
                  </template>
                </el-table-column>
                <el-table-column prop="name"
                                 label="申请人"
                                 align="center"></el-table-column>
                <el-table-column prop="postName"
                                 label="职称"
                                 align="center"></el-table-column>
                <el-table-column prop="titleName"
                                 label="职务"
                                 align="center"></el-table-column>
                <el-table-column prop="deptName"
                                 label="工作部门"
                                 align="center"></el-table-column>
                <el-table-column prop="phone"
                                 label="联系电话"
                                 align="center"></el-table-column>
                <el-table-column label="操作"
                                 width="350"
                                 align="center">
                  <template slot-scope="scope">
                    <el-button type="infor"
                               size="small"
                               @click="showRelDetail(scope.$index,scope.row)">详情</el-button>
                    <!-- <el-button type="infor"
                             size="small"
                             @click="ReAccept(scope.$index,scope.row)">重受理</el-button>
                  <el-button type="primary"
                             size="small"
                             @click="ReAgree(scope.$index,scope.row)">重审核</el-button>
                  <el-button type="warning"
                             size="small"
                             @click="ReApprove(scope.$index,scope.row)">重审批</el-button> -->
                    <el-button type="danger"
                               size="small"
                               @click="delectHireForm(scope.$index,scope.row)">删除</el-button>
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
              <div style="height:20px;width:100%"></div>

            </div>

          </div>
        </div>
      </div>
    </div>
    <one-hire-apply-detail :show.sync="applyDetailVisiable"
                           :detailData="applyDetailData"
                           @status-change="hangleStatusChange"></one-hire-apply-detail>
  </div>
</template>

<script type="text/ecmascript-6">
import {
  getHireForm,
  getHireReAccept,
  getHireReAgree,
  getHireReApprove,
  deleteHireForm
} from "@/api/leaseManage";
import utils from "@/utils/index.js";
import OneHireApplyDetail from './oneHireApplyDetail.vue'
export default {
  components: {
    OneHireApplyDetail
  },
  data () {
    return {
      //表格需要的
      hireFormData: [],
      listLoading: false,
      totalNum: 0,
      page: 1,
      size: 10,
      statuseArray: [{
        text: "未受理",
        value: "未受理"
      },
      {
        text: "待审核",
        value: "待审核"
      },
      {
        text: "待审批",
        value: "待审批"
      },
      {
        text: "已审批",
        value: "已审批"
      },
      {
        text: "受理拒绝",
        value: "受理拒绝"
      },
      {
        text: "审核拒绝",
        value: "审核拒绝"
      },
      {
        text: "审批拒绝",
        value: "审批拒绝"
      }
      ],
      payTypes: [
        {
          id: 0,
          typeName: '无需缴费'
        },
        {
          id: 1,
          typeName: '自行缴费'
        },
        {
          id: 2,
          typeName: '工资代扣'
        }
      ],
      // 是否弹出申请单详情的对话框
      applyDetailVisiable: false,
      // 申请单详情的数据
      applyDetailData: {}
    };
  },
  created () {
    this.getList();
  },
  // 过滤器的哈希表
  filters: {
    statusFilter (status) {
      const statusMap = {
        待审核: "info",
        待受理: 'warning',
        未受理: "warning",
        审核拒绝: "danger",
        受理拒绝: "danger",
        已审批: "success"
      };
      return statusMap[status];
    }
  },
  methods: {
    // 获取列表
    getList () {
      this.listLoading = true;
      let param = {
        page: this.page,
        size: this.size
      };
      getHireForm(param)
        .then(res => {
          // console.log(res.data.data)
          this.hireFormData = res.data.data.data.list;
          this.totalNum = res.data.data.data.total;
          // console.log(res.data.data.list)
          this.listLoading = false;
        })
        .catch(err => {
          console.log(err);
        });
    },
    // 筛选处理
    filterHandle (value, row) {
      return row.hireState === value;
    },
    isOverFormat (row, column, cellValue) {
      if (cellValue == false) {
        return "未签订";
      } else {
        return "已签订";
      }
    },

    // 表单删除
    delectHireForm (index, row) {
      this.$confirm("此操作将对删除该申请单", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          let formID = row.id;
          this.listLoading = true;
          deleteHireForm(formID)
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
          this.$message1({
            type: "info",
            message: "已取消删除"
          });
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
    },
    // 显示申请单详情
    showRelDetail (index, row) {
      // 缴租方式的代号转换
      if (row.payType) {
        this.payTypes.forEach(item => {
          if (item.id == row.payType) {
            row.payType = item.typeName
          }
        })
      }
      row.pastImageData = row.hireFiles ? row.hireFiles.split(',') : ''
      this.applyDetailData = row
      this.applyDetailVisiable = true
    },
    // 重受理、重审核、重审批之后，刷新表格
    hangleStatusChange () {
      this.getList()
    }
  }
};

</script>

<style scoped lang="scss">
</style>
