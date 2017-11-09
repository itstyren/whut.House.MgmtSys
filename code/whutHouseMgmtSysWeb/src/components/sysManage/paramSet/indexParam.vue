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
    <el-col :span="24" >
      <el-card class="left-body">
      <el-form :inline="true" style="text-align:center;margin-bottom:20px">
        <el-input placeholder="输入参数关键词" v-model="filterText" icon="search" type="text" size="small"></el-input>
      </el-form>
      <el-tree :data="paramData" :props="props" ref="paramData" :filter-node-method="filterNode"   @node-click="handleNodeClick" :highlight-current="true"></el-tree>
    </el-card>
    <!-- 右侧内容区域 -->
    <section class="right-body">
        <component :is="componentId"></component>
    </section>
    </el-col>
  </el-row>
</el-row>
</template>

<script type="text/ecmascript-6">
// 异步加载--住房参数
const houseType = () => import(/* webpackChunkName: "houseParam" */ './houseParam/houseType')
const houseLayout = () => import(/* webpackChunkName: "houseParam" */ './houseParam/houseLayout')
const houseStatus = () => import(/* webpackChunkName: "houseParam" */ './houseParam/houseStatus')
const houseStruct = () => import(/* webpackChunkName: "houseParam" */ './houseParam/houseStruct')
// 异步加载--职工参数
const staffDept = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffDept')
const staffPost = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffPost')
const staffTitle = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffTitle')
const staffClass = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffClass')
const staffStatus = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffStatus')
const staffSpouse = () => import(/* webpackChunkName: "staffParam" */ './staffParam/staffSpouse')
// 异步加载--租赁参数
const rentPostVal = () => import(/* webpackChunkName: "rentParam" */ './rentParam/rentPostVal')
const rentTitleVal = () => import(/* webpackChunkName: "rentParam" */ './rentParam/rentTitleVal')
const rentPostArea = () => import(/* webpackChunkName: "rentParam" */ './rentParam/rentPostArea')
const rentTitleArea = () => import(/* webpackChunkName: "rentParam" */ './rentParam/rentTitleArea')
const rentOption = () => import(/* webpackChunkName: "rentParam" */ './rentParam/rentOption')

import rentalOption from './rentalParam/rentalOption'  

import fixContent from './fixParam/fixContent'
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
              id:'houseStruct',
              label:'住房结构'
            }]
          },
         // 职工参数
         {
           label:'职工参数',
           children:[
             {
               id:'staffDept',
               label:'工作部门'
             },
             {
               id:'staffPost',
               label:'职务'
             },
             {
               id:'staffTitle',
               label:'职称'
             },
             {
               id:'staffClass',
               label:'职工类别'
             },
             {
               id:'staffStatus',
               label:'工作状态'
             },
             {
               id:'staffSpouse',
               label:'配偶单位性质'
             },             
           ]
         },
         // 租赁参数
         {
           label:'租赁参数',
           children:[
             {
               id:'rentPostVal',
               label:'职务分'
             },
             {
               id:'rentTitleVal',
               label:'职称分'
             },
             {
               id:'rentPostArea',
               label:'职务面积'
             },             
             {
               id:'rentTitleArea',
               label:'职称面积'
             },
             {
               id:'rentOption',
               label:'选房选项'
             },            
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
               id:'rentalOption',
               label:'租金选项'
             },
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
     // 住房参数组件
     houseType,houseLayout,houseStatus,houseStruct,
     // 职工参数组件
     staffDept,staffPost,staffTitle,staffClass,staffStatus,staffSpouse,
     // 租赁参数组件
     rentPostVal,rentTitleVal,rentPostArea,rentTitleArea,rentOption,
     // 维修参数组件
     fixContent,
     // 租金参数组件
     rentalOption,
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
  height: 100%; 
  width: 100%;
  text-align: left;
  padding-left: 20px;

}
.left-body{
  position: absolute;
  top:20px;
  bottom: 20px;
  width: 20%;
  overflow-y: auto;
  overflow-x: hidden;
  margin: 18px;
  padding: 15px 0px 0 0px;
  //  border: 2px solid #333744;
  // -moz-box-shadow:-4px 7px 5px #878787, 0px 2px 3px #333333; -webkit-box-shadow:-4px 7px 5px #878787, 0px 2px 3px #333333; box-shadow:-4px 7px 5px #878787, 0px 2px 3px #333333;
   border-radius: 5px
   
}
.right-body{
  position: absolute;
  top:20px;
  bottom: 20px;
  right: 0px;
  width: 80%
}
.warp{
  height: inherit;
}
</style>
