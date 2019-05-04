<template>
  <div class="card notification">
    <div class="title">
      <strong>工作清单</strong>
    </div>
    <div class="content"
         v-loading="listLoading">
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16"
                :offset="2">
          <span>有
            <span style="color:red;">
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todoList.fixToHandle"
                        :duration="3200"></count-to>
            </span>条维修信息待处理</span>
        </el-col>
        <el-col :span="4"
                :offset="1">
          <router-link to="/fixManage/fixAccept">
            <el-button size="mini"
                       type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16"
                :offset="2">
          <span>有
            <span style="color:red;">
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todoList.fixToCheck"
                        :duration="3200"></count-to>
            </span>条维修信息待结算</span>
        </el-col>
        <el-col :span="4"
                :offset="1">
          <router-link to="/fixManage/fixBalance">
            <el-button size="mini"
                       type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16"
                :offset="2">
          <span>有
            <span style="color:red;">
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todoList.hireToHandle"
                        :duration="3200"></count-to>
            </span>条租赁信息待处理</span>
        </el-col>
        <el-col :span="4"
                :offset="1">
          <router-link to="/leaseManage/hireAccept">
            <el-button size="mini"
                       type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
      <el-row class="info-row">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="16"
                :offset="2">
          <span>有
            <span style="color:red;">
              <count-to class="card-panel-num"
                        :startVal="0"
                        :endVal="todoList.hireToSign"
                        :duration="3200"></count-to>
            </span>条租赁合同待签订</span>
        </el-col>
        <el-col :span="4"
                :offset="1">
          <router-link to="/leaseManage/hireContract">
            <el-button size="mini"
                       type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import countTo from "vue-count-to";
import {
  getJobList
} from "@/api/user";
export default {
  data () {
    return {
      listLoading: false,
      todoList: {},
      todayData: {}
    };
  },
  created () {
    this.getList();
  },
  components: {
    countTo
  },
  methods: {
    getList () {
      this.listLoading = true;
      getJobList().then(res => {
        var { hireToSign, fixToHandle, hireToHandle, fixToCheck } = res.data.data.data
        this.todoList = { hireToSign, fixToHandle, hireToHandle, fixToCheck }
        var { todayHandle, todayVisit, todayFixApply, todayHireApply } = res.data.data.data
        var todayData = { todayHandle, todayVisit, todayFixApply, todayHireApply }
        this.$store.commit('SET_TODAY_DATA', todayData)
        this.listLoading = false
      });
    }
  }
};

</script>

<style scoped lang="scss">
.notification {
  // height: 460px;
  height: 100%;
  padding: 20px;
  .title {
    position: relative;
    width: 100%;
    &::after {
      content: "";
      width: 100%;
      height: 2px;
      background-color: #dcdcdc;
      position: absolute;
      bottom: -10px;
      z-index: 1;
      left: 1%;
      right: 1%;
    }
  }
  .content {
    margin-top: 30px;
    .info-row {
      border-bottom: 1px solid #eee;
      padding: 10px;
      height: 45px;
      font-size: 1.05vw;
      font-weight: 500;
    }
  }
}
</style>
