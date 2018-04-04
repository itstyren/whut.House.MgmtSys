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
            <div class="editor">
              <quill-editor></quill-editor>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
  import quillEditor from '@/components/QuillEditor'
  export default {
    data() {
      return {

      }

    },
    components: {
      quillEditor
    }
  }

</script>

<style scoped lang="scss">
.editor{
    height: 80vh;
    padding: 20px;
}

</style>
