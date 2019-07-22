<template>
  <div class="image-cropper">
    <el-button @click="visible=true">设置头像</el-button>
    <my-upload field="file"
               v-model="visible"
               :url="`${basiceUrl}/fileUpload/multiFileUpload`"
               :noRotate="false"
               @crop-success="cropSuccess"
               @crop-upload-success="successUpload"
               @crop-upload-fail="failUpload"></my-upload>
  </div>
</template>

<script type="text/ecmascript-6">
import "babel-polyfill"; // es6 shim
import myUpload from "vue-image-crop-upload";
export default {
  data () {
    return {
      visible: false,
      // 七牛云令牌
      // postData: {
      //   token: this.$store.getters.qiniuToken
      // },
      imageURL: "",
      basiceUrl: "http://172.16.65.105:8080/whutHouseMgmtReposity"
    };
  },
  components: {
    myUpload
  },
  methods: {
    cropSuccess (imgDataUrl, field) {
    },
    successUpload (jsonData, field) {
      // this.imageURL就是服务器给的图片路径
      this.imageURL = jsonData.data.data[0]
      this.$emit('upload-url', this.imageURL)
    },
    failUpload (status, field) {
      this.$message.error("上传图片失败！")
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
