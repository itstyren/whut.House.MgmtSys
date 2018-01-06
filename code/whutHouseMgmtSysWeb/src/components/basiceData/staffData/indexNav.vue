<template>
  <div class="second-container">
    <aside :class="{showSidebar:!isCollapse}">
      <!-- 展开关闭按钮 -->
      <div class="asid-button">
       <el-input v-model="filterText" placeholder="输入职工搜索" class="filter"></el-input>
      </div>
            <!-- 主菜单 -->
            <el-tree :data="depData"></el-tree>
    </aside>
  </div>
</template>

<script type="text/ecmascript-6">
export default {
  data() {
    return {
      isCollapse: false,
      depData: [
        {
          id: 1,
          label: "一级 1",
          children: [
            {
              id: 4,
              label: "二级 1-1",
              children: [
                {
                  id: 9,
                  label: "三级 1-1-1"
                },
                {
                  id: 10,
                  label: "三级 1-1-2"
                }
              ]
            }
          ]
        },
        {
          id: 2,
          label: "一级 2",
          children: [
            {
              id: 5,
              label: "二级 2-1"
            },
            {
              id: 6,
              label: "二级 2-2"
            }
          ]
        },
        {
          id: 3,
          label: "一级 3",
          children: [
            {
              id: 7,
              label: "二级 3-1"
            },
            {
              id: 8,
              label: "二级 3-2"
            }
          ]
        }
      ]
    };
  },
  components: {},
  methods: {
    //折叠
    collapse: function() {
      this.isCollapse = !this.isCollapse;
    }
  }
};
</script>

<style scoped lang="scss">
aside {
    .asid-button{
        margin: 10px auto 10px;
        width: 70%
    }
    .el-input__inner{
        background: #4A5064
    }
  > .el-tree {
    width: 250px;
    height: auto;
  }

  span {
    padding-left: 20px;
  }
}
</style>
