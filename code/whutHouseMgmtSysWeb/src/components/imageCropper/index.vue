<template>
<div class="image-cropper">
<el-button @click="visible=true">设置头像</el-button>
 <my-upload v-model="visible"></my-upload>
 </div>
</template>

<script type="text/ecmascript-6">
import myUpload from "vue-image-crop-upload";
export default {
  data() {
    return {
      visible: false
    };
  },
  components: {
    myUpload
  }
};
</script>

<style scoped lang="scss">
.image-cropper{
    width: 100%;
    text-align: center;
}
</style>
