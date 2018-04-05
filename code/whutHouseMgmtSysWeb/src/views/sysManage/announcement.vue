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
              <quill-editor  :content="content" @emit-content="emitContent"></quill-editor>
            </div>
            <div class="button">
            <el-button type="primary">提交</el-button>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import quillEditor from "@/components/QuillEditor";
export default {
  data() {
    return {
      content:
        "<p>&nbsp;各位教职工：</p><p><br></p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你们使用武汉理工大学高校房屋管理与货币化补贴系统，本系统，符合湖北省房改政策条例中的相关规定，集住房管理功能、住房维修申请功能、住房租赁功能于一体，全面实现了高校房屋租赁与货币化补贴等业务的信息化。如您在使用本系统中遇到了任何问题，请及时与我们取得联系。</p><p><br></p><p><br></p><p><br></p><p>联系方式：</p><p>系统管理员联系邮箱：terry_Ren@whut.edu.cn</p><p><br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;住房办办公电话：13129917437</p><p><br></p><p><br></p><p><br></p><p><br></p><p>注（备注部分）：</p><p>本系统中各项参数符合湖北省房改政策相关文件（湖北省房改政策续编2009.12）。</p>"
    };
  },
  components: {
    quillEditor
  },
  methods: {
    emitContent(newval) {
      this.content=newval
    }
  }
};
</script>

<style scoped lang="scss">

.editor {
  margin: 50px;
}
.button{
  text-align: right;
  margin: 20px 50px 20px ;
}
</style>
