<template>
  <div class="dashboard-admin">
<el-row>
  <el-col :span="6" style="margin-left:50x">
<info-card></info-card>
  </el-col>
  <el-col :span="18" class="pannel-group">
<pannel-group></pannel-group>
  </el-col>
  <el-col :span="18" class="line-chart">

  </el-col>
</el-row>

 </div>
</template>

<script type="text/ecmascript-6">
import infoCard from '../components/infoCard'
import pannelGroup from '../components/pannelGroup'
 export default {
   data() {
     return {

     }

   },
   components: {
infoCard,pannelGroup
   }
 }
</script>

<style scoped lang="scss">
.pannel-group{
  height: 100%;
}
 
</style>
