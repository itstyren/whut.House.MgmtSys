<template>
  <div class="quill-wrap">
    <quill-editor
      v-model="content"
      ref="myQuillEditor"
      :options="editorOption"
      style="height:50vh"
    >
    </quill-editor>
  </div>
</template>

<script type="text/ecmascript-6">
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
import { quillEditor, Quill } from "vue-quill-editor";
import { container, ImageExtend, QuillWatch } from "quill-image-extend-module";
 import ImageResize from 'quill-image-resize-module'
Quill.register("modules/ImageExtend", ImageExtend);
  Quill.register('modules/ImageResize', ImageResize)
export default {
  data() {        
    return {
      content: "",
      // 富文本框参数设置
      editorOption: {
        modules: {
          ImageExtend: {
            loading: true,
            name: "file",
            action: "http://upload.qiniu.com/",
            response: res => {
              console.log(this.$store.getters.qiniuURL + res.key)
              return  this.$store.getters.qiniuURL + res.key
            },
            change: (xhr, formData) => {
              // xhr.setRequestHeader('myHeader','myValue')
              formData.append("token", this.$store.getters.qiniuToken);
            } // 可选参数 每次选择图片触发，也可用来设置头部，但比headers多了一个参数，可设置formData
          },
           ImageResize: {},
          toolbar: {
            container: container,
            handlers: {
              image: function() {
                QuillWatch.emit(this.quill.id);
              }
            }
          }
        }
      }
    };
  },
  components: {
    quillEditor
  },
  methods: {}
};
</script>

<style scoped lang="scss">
</style>
