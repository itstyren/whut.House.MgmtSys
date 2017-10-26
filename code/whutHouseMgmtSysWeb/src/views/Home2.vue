<template>
<el-container>
  <el-header> 
  </el-header>
  <el-aside></el-aside>
  <el-main></el-main>
</el-container>
</template>

<script type="text/ecmascript-6">
 export default {
   data() {
     return {

     }

   },
   components: {

   }
 }
</script>

<style scoped lang="scss">
//scoped范围样式，用于隔离组件的style
  .all-containers{
    position: absolute;
    top: 0px;
    bottom: 0px;
    width: 100%;
    left: 0px;
    
    
    .top-bar-warp{
      height: 50px;
      line-height: 50px;
      background: #373d41;
      padding: 0px;
      color: #fff;
      
      .top-bar-logo{
        float: left;
        width: 59px;
        line-height: 26px;
        }
      
      .top-bar-logo img{
        height: 40px;
        margin-top: 5px;
        margin-left: 2px;
        }
      
      .top-bar-title {
        float: left;
        text-align: left;
        width: 200px;
        padding-left: 10px;
        border-left: 1px solid #000;
        span{
         font-size: 20px;
        }
        }

        .top-bar-account{
          float: right;
          padding-right: 15px;
          .el-dropdown-main{
          color: #fff;
          cursor: pointer;
          padding-left: 12px;
          }
        }
        
      } //top-bar-warp包裹

      // 中间部分
      .body-containers{
        display: -webkit-box;
        display: -webkit-flex;
        display: -ms-flexbox;
        display: flex;
        position: absolute;
        top: 50px;
        bottom: 0px;
        overflow: hidden;
      }

      //左侧内容样式
      aside{
        min-width: 50px;
        background: #333744;
        &::-webkit-scrollbar {
          display: none;
        }

        .asid-button{
          background: #4A5064;
          text-align: center;
          color: white;
          height: 30px;
          line-height: 30px;
          cursor: pointer;
        }
        
        &.showSidebar {
          overflow-x: hidden;
          overflow-y: auto;
          }


        .el-menu {
          height: 100%; /*写给不支持calc()的浏览器*/
          height: -moz-calc(100% - 80px);
          height: -webkit-calc(100% - 80px);
          height: calc(100% - 80px);
          border-radius: 0px;
          background-color: #333744;
      }
      .el-menu {
        width: 180px;
        background-color: #333744;
      }
      .el-menu--collapse {
        width: 60px;
      }

      }
      //中间主内容样式
      .main-containers{
        background: #fff;
        flex: 1;
        overflow-y: auto;
        padding: 10px;
        padding-bottom: 1px;
        
        .main-warp{
           box-sizing: border-box;
            height: 100%;
        }
              //底部样式
      // .bottom-containers{
      //   position: absolute;
      //   height: 50px;
      //   background: #333744;
      //   bottom:0px;
      //   border: 1px solid #fff;
      //   padding: 12px;

      //   SPAN{
      //     text-align: center;
      //     color: white;
      //     font-size: 14px;
      //   }
      // }
        }
  }
 
</style>
