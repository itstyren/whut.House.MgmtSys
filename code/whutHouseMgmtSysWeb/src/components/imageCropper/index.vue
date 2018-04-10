<template>
<div class="image-cropper">
<el-button @click="visible=true">设置头像</el-button>
 <my-upload  v-model="visible" url="http://upload.qiniu.com/" :noRotate="false"  :params="postData" @crop-upload-success="successUpload" @crop-upload-fail="failUpload"></my-upload>
 </div>
</template>

<script type="text/ecmascript-6">
import "babel-polyfill"; // es6 shim
import myUpload from "vue-image-crop-upload";
export default {
  data() {
    return {
      visible: false,
      // 七牛云令牌
      postData: {
        token: this.$store.getters.qiniuToken
      },
      imageURL: ""
    };
  },
  components: {
    myUpload
  },
  methods: {
    successUpload(jsonData, field) {
      console.log(jsonData);
      this.imageURL = this.$store.getters.qiniuURL + jsonData.key;
    },
    failUpload(status, field) {
      console.log("-------- upload fail --------");
      console.log(status);
      console.log("field: " + field);
    }
  }
};
</script>

<style scoped lang="scss">
.image-cropper {
  width: 100%;
  text-align: center;
}
</style>
