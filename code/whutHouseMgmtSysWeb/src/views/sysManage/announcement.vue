<template>
  <div class="second-container">
    <section class="special-container">
      <div class="third-container">
        <!-- 面包屑导航 -->
        <div class="warp-breadcrum">
          <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/' }">
              <b>首页</b>
            </el-breadcrumb-item>
            <el-breadcrumb-item>系统管理</el-breadcrumb-item>
            <el-breadcrumb-item>公告发布</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <!-- 下方主内容 -->
        <div class="warp-body">
          <!-- 工具栏 -->
          <div class="toolbar">

          </div>
          <!-- 表格区 -->
          <div class="main-data">
            <div class="editor" v-loading="listLoading">
              <quill-editor  :content="content" @emit-content="emitContent"></quill-editor>
            </div>
            <div class="button">
            <el-button type="primary" @click="modifyContent">提交</el-button>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import quillEditor from "@/components/QuillEditor";
import { getSysParam, putSysParam } from "@/api/sysManage";
  import utils from '@/utils/index.js'
export default {
  data() {
    return {
      listLoading: false,
      content:''
    };
  },
  components: {
    quillEditor
  },
  created() {
    this.getContent();
  },
  methods: {
    emitContent(newval) {
      this.content = newval;
    },
    getContent() {
      this.listLoading = true;
      let params = {
        sysParamId: 1
      };
      getSysParam(params).then(res => {
        this.content = res.data.data.data.sysParamContent;
        this.listLoading = false;
      });
    },
    modifyContent() {
      this.$confirm("保存并提交修改", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.listLoading = true;
          let data = {
            sysParamContent: this.content,
            sysParamId: 1,
            sysParamName: "公告"
          };
          putSysParam(data).then(res => {
            // 公共提示方法
            utils.statusinfo(this, res.data)
            this.listLoading=false
          });
        })
        .catch(() => {
          this.$message1({
            type: "info",
            message: "暂不提交"
          });
        });
    }
  }
};
</script>

<style scoped lang="scss">
.editor {
  margin: 50px;
}
.button {
  text-align: right;
  margin: 20px 50px 20px;
}
</style>
