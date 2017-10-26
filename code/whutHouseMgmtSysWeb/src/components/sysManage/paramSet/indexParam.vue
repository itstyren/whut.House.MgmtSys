<template>
<el-row >
  <el-col :span="24" class="warp-breadcrum">
    <!-- 面包屑导航 -->
    <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }"><b>首页</b></el-breadcrumb-item>
        <el-breadcrumb-item>系统管理</el-breadcrumb-item>
        <el-breadcrumb-item>参数设置</el-breadcrumb-item>
      </el-breadcrumb>
  </el-col>
  <!-- 下方主体内容 -->
  <el-row class="warp-main" >
    <!-- 左侧树形菜单 -->
    <el-col :span="4">
      <el-form :inline="true" style="margin-bottom:15px">
        <el-input placeholder="输入参数关键词" v-model="filterText" icon="search"></el-input>
      </el-form>
      <el-tree :data="paramData" :props="props" ref="paramData" :filter-node-method="filterNode"   @node-click="handleNodeClick"></el-tree>
    </el-col>
    <el-col :span="20">
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
             }
           ]
         },
         // 租金参数
         {
           label:'租金参数',
           children:[
             {
               id:'ordORnew',
               label:'新老职工时间分界点'
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
        this.componentId=data.id
      }  
   },
   components: {
     houseType
   }
 }
</script>

<style scoped lang="scss">
.el-tree{
  text-align: left;
  padding-left: 20px;
  padding-top: 10px;
}
</style>
