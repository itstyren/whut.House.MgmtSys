<template>
 <div class="info-card card">
     <el-row>
       <el-col :span="12">
           <div class="avatar">
               <img :src="img_avatar" width="100%" height="100%" alt="avatar">
           </div>
       </el-col>
              <el-col :span="12">
<el-row class="basice-info">
  <el-col :span="24">
    <strong >任天宇</strong>
  </el-col>
</el-row>
       </el-col>
     </el-row>
 </div>
</template>

<script type="text/ecmascript-6">
import img_avatar from '@/assets/avatar.jpg'
export default {
  data() {
    return {
        img_avatar
    };
  },
  components: {}
};
</script>

<style scoped lang="scss">
.avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  overflow: hidden;
}
.basice-info{
  font-size: 22px;
  padding-top: 3vh;
  color: #2d8cf0;
}
</style>
