<template>
 <div class="info-card card">
     <el-row>
       <el-col :span="12">
           <div class="avatar">
               <img :src="img_avatar" width="100%" height="100%" alt="avatar">
           </div>
           
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
</style>
