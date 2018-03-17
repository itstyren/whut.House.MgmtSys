<template>
  <div class="dashboard-admin">
<el-row>
  <el-col :span="6">
<info-card></info-card>
  </el-col>
</el-row>

 </div>
</template>

<script type="text/ecmascript-6">
import infoCard from '../components/infoCard'
 export default {
   data() {
     return {

     }

   },
   components: {
infoCard
   }
 }
</script>

<style scoped lang="scss">

 
</style>
