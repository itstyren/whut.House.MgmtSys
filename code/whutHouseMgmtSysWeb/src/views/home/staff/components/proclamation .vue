<template>
  <div class="proclamation card" v-loading="listLoading">
    <div class="title">
      <strong>系统说明</strong>
    </div>
    <div class="content" v-html="content">
     
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import {getSysParam} from '@/api/sysManage'
  export default {
    data() {
      return {
        content:'',
        listLoading:false
      };
    },
    created () {
      this.getProclamation()
    },
    methods: {
      getProclamation(){
        this.listLoading=true
        let params={
          sysParamId:1
        }
        getSysParam(params).then(res=>{
          this.content=res.data.data.data.sysParamContent
          this.listLoading=false
        })
      }
    }
  };

</script>

<style scoped lang="scss">
  .proclamation {
    height: 84vh;
    padding: 20px;
    .title {
      font-size: 26px;
      font-weight: 400;
      position: relative;
      &::after {
        content: "";
        width: 100%;
        height: 2px;
        background-color: #dcdcdc;
        position: absolute;
        bottom: -10px;
        z-index: 1; //left: 1%;
        right: 1%;
      }
    }
    .content {
      margin-top: 30px;
      height: 90%;
      overflow-y: auto;
    }
  }

</style>
