<template>
    <quill-editor
      v-model="mycontent"
      ref="myQuillEditor"
      :options="editorOption"
      class="quill"
    >
    </quill-editor>
</template>

<script type="text/ecmascript-6">
import "quill/dist/quill.core.css";
import "quill/dist/quill.snow.css";
import "quill/dist/quill.bubble.css";
import { quillEditor, Quill } from "vue-quill-editor";
import { container, ImageExtend, QuillWatch } from "quill-image-extend-module";
import ImageResize from "quill-image-resize-module";
Quill.register("modules/ImageExtend", ImageExtend);
Quill.register("modules/ImageResize", ImageResize);
export default {
  data() {
    return {
      mycontent: this.content,
      // 富文本框参数设置
      editorOption: {
        modules: {
          ImageExtend: {
            loading: true,
            name: "file",
            action: "http://upload.qiniu.com/",
            response: res => {
              return this.$store.getters.qiniuURL + res.key;
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
  props: {
    content: {
      type: String
    },
    height:{
      type:String,
      default:'50vh'
    }
  },
  watch: {
    content(val) {
      this.mycontent = val;
    },
    mycontent(newVal) {
      this.$emit("emit-content", newVal);
    }
  },
  components: {
    quillEditor
  },
  methods: {}
};
</script>

<style scoped lang="scss">
.quill-editor{
      box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>
