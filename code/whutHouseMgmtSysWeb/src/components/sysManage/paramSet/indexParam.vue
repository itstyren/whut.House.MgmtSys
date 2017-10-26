<template>
<el-row  class="warp" >
  <el-row>
  <el-col :span="24" class="warp-breadcrum">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }"><b>首页</b></el-breadcrumb-item>
        <el-breadcrumb-item>系统管理</el-breadcrumb-item>
        <el-breadcrumb-item>参数设置</el-breadcrumb-item>
      </el-breadcrumb>
  </el-col>
  </el-row>
  <!-- 下方主体内容 -->
  <el-row class="main-body" >
    <!-- 左侧树形菜单 -->
    <el-col :span="5" class="left-tree">
      <div class="left-body">
      <el-form :inline="true" style="text-align:center;margin-bottom:20px">
        <el-input placeholder="输入参数关键词" v-model="filterText" icon="search" type="text" size="small"></el-input>
      </el-form>
      <el-tree :data="paramData" :props="props" ref="paramData" :filter-node-method="filterNode"   @node-click="handleNodeClick" :highlight-current="true"></el-tree>
    </div>
    </el-col>
    <!-- 右侧内容区域 -->
    <el-col :span="19" >
      <transition name="fade" model="out-in" >
        <component :is="componentId"></component>
      </transition>
    </el-col>
  </el-row>
</el-row>
</template>

<script type="text/ecmascript-6">
import houseType from './houseType'
 export default {
   // 监视输入框参数值
    watch: {
      filterText(val) {
        this.$refs.paramData.filter(val);
      }
    },
   data() {
     return {
       filterText:'',
       componentId:'',
       paramData:[
         // 住房参数
         {
           label:'住房参数',
           disabled:true,
           children:[
            {
              id:'houseType',
              label:'住房类型'             
            },
            {
              id:'houseLayout',
              label:'住房户型'
            },
            {
              id:'houseStatus',
              label:'使用状态'
            },
            {
              id:'housestruct',
              label:'住房结构'
            }]
          },
         // 职工参数
         {
           label:'职工参数',
           children:[
             {
               id:'department',
               label:'工作部门'
             }
           ]
         },
         // 租赁参数
         {
           label:'租赁参数',
           children:[
             {
               id:'position',
               label:'职务分'
             },
             {
               id:'mianji',
               label:'享受 面积'
             },
             {
               id:'111',
               label:'测试长度'
             }
           ]
         },
         // 维修参数
         {
           label:'维修参数',
           children:[
             {
               id:'fixContent',
               label:'维修内容'
             },
             {
               id:'fixContent',
               label:'维修内容'
             },
              {
               id:'fixContent',
               label:'维修内容'
             },
                          {
               id:'fixContent',
               label:'维修内容'
             },
                          {
               id:'fixContent',
               label:'维修内容'
             },            
           ]
         },
         // 租金参数
         {
           label:'租金参数',
           children:[
             {
               id:'ordORnew',
               label:'新老职工分界点'
             },
                          {
               id:'ordORnew',
               label:'新老职工分界点'
             },
                          {
               id:'ordORnew',
               label:'新老职工分界点'
             }
           ]
         }
       ],
       props:{
         children: 'children',
         label: 'label'
        }
     }

   },
   methods:{
     // 过滤函数
     filterNode(value, data, node){
       if (!value) return true;
       return data.label.indexOf(value) !== -1;
      },
      handleNodeClick(data,node,vuecomponent){
        if(data.label=='住房参数'||data.label=='职工参数'||data.label=='租赁参数'||data.label=='维修参数'||data.label=='租金参数')  return 
        this.componentId=data.id
      }  
   },
   components: {
     houseType
   }
 }
</script>

<style scoped lang="scss">
.el-input{
  width: 140px;
}
.main-body{
  position: relative;
  height: 90%;
  border-radius: 5px;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 5px #cac6c6;
}

.el-tree{
  position: relative;
  max-height: 100%;
  width: 100%;
  text-align: left;
  padding-left: 20px;

}
.left-body{
  position: relative;
  height: 500px;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  padding: 15px 0px 0 0px;
   border: 2px solid #333744;
   border-radius: 5px
   
}
.warp{
  height: inherit;
}
</style>
