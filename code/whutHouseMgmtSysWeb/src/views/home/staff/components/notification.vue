<template>
  <div class="card notification">
    <div class="title">
      <strong>新的通知</strong>
    </div>
    <div class="content">
      <el-row class="info-row"  v-for="note in hireNote" :key="note">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="15" :offset="2">
          <span>{{note}}</span>
        </el-col>
        <el-col :span="5" :offset="1">
          <router-link :to="{name:'personal',params:{menuIndex:'fix'}}">
          <el-button size="mini"  type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
      <el-row class="info-row" v-for="note in fixNote" :key="note">
        <el-col :span="1">
          <my-icon icon-class="information"></my-icon>
        </el-col>
        <el-col :span="15" :offset="2">
          <span style="">{{note}}</span>
        </el-col>
        <el-col :span="5" :offset="1">
<router-link :to="{name:'personal',params:{menuIndex:'hire'}}">
          <el-button size="mini"  type="">查看</el-button>
          </router-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import {getUserFix,getUserHire} from '@/api/user.js'
  export default {
    data() {
      return {
        staffID:this.$store.getters.userID,
        listLongding:false,
        hireNote:'',
        fixNote:''
      };
    },
    mounted () {
      this.getUserInfo()
    },
    methods: {
      getUserInfo(){
        this.listLongding=true
        getUserFix(this.staffID).then(res=>{
            this.hireNote=res.data.data.data         
          getUserHire(this.staffID).then(res=>{
            this.fixNote=res.data.data.data
          })
        })
      }
    }
  };

</script>

<style scoped lang="scss">
  .notification {
    height: 420px;
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
        //height: 45px;
        font-size: 16px;
        font-weight: 500
      }
    }
  }

</style>
