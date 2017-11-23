import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'

import paramSetText from '@/components/sysManage/paramSet/indexParam1'

import buildingData from '@/components/basiceData/buildingData'
import region from '@/components/basiceData/regionData'

import Text1 from '@/views/Home1'

// 住房参数
import paramSet from '@/components/sysManage/paramSet/indexParam'
import houseType from '@/components/sysManage/paramSet/houseParam/houseType'
import houseLayout from '@/components/sysManage/paramSet/houseParam/houseLayout'
import houseStatus from '@/components/sysManage/paramSet/houseParam/houseStatus'
import houseStruct from '@/components/sysManage/paramSet/houseParam/houseStruct'
// 职工参数
import staffDept from '@/components/sysManage/paramSet/staffParam/staffDept'
import staffPost from '@/components/sysManage/paramSet/staffParam/staffPost'
import staffTitle from '@/components/sysManage/paramSet/staffParam/staffTitle'
import staffClass from '@/components/sysManage/paramSet/staffParam/staffClass'
import staffStatus from '@/components/sysManage/paramSet/staffParam/staffStatus'
import staffSpouse from '@/components/sysManage/paramSet/staffParam/staffSpouse'
// 租赁参数
import rentOption from '@/components/sysManage/paramSet/rentParam/rentOption'
import rentPostArea from '@/components/sysManage/paramSet/rentParam/rentPostArea'
import rentPostVal from '@/components/sysManage/paramSet/rentParam/rentPostVal'
import rentTitleArea from '@/components/sysManage/paramSet/rentParam/rentTitleArea'
import rentTitleVal from '@/components/sysManage/paramSet/rentParam/rentTitleVal'
// 维修参数
import fixContent from '@/components/sysManage/paramSet/fixParam/fixContent'
// 租金参数
import rentalOption from '@/components/sysManage/paramSet/rentalParam/rentalOption'

// 基础数据
// 楼栋区域
import indexbldgRgn from '@/components/basiceData/buildingRegionData/indexbldgRgn'

Vue.use(Router)

// 定义路由数据
const routes = [
// 首页
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      requireAuth: true
    },
    redirect: '/index',
    children: [
      {path: '/index', component: HelloWorld, name: 'index', menuShow: true}
    ]
  },
  // 测试
  {
    path: '/text',
    component: Text1,
    children: [
      { path: '/paramSet1',
        component: paramSetText,
        name: 'paramSetText',
        children: [
          { path: '/paramSet1/houseType1', component: houseType, name: 'houseType1', menuShow: true }
        ]

      }
    ]
  },
  // 系统管理
  {
    path: '/sysmanage',
    component: Home,
    name: 'sysManage',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [
      { path: 'paramSet',
        component: paramSet,
        name: 'paramSet',
        children: [
          // 住房参数
          { path: 'houseType', component: houseType, name: 'houseType', menuShow: true },
          { path: 'houseLayout', component: houseLayout, name: 'houseLayout', menuShow: true },
          { path: 'houseStatus', component: houseStatus, name: 'houseStatus', menuShow: true },
          { path: 'houseStruct', component: houseStruct, name: 'houseStruct', menuShow: true },
          // 职工参数
          { path: 'staffDept', component: staffDept, name: 'staffDept', menuShow: true },
          { path: 'staffPost', component: staffPost, name: 'staffPost', menuShow: true },
          { path: 'staffTitle', component: staffTitle, name: 'staffTitle', menuShow: true },
          { path: 'staffClass', component: staffClass, name: 'staffClass', menuShow: true },
          { path: 'staffStatus', component: staffStatus, name: 'staffStatus', menuShow: true },
          { path: 'staffSpouse', component: staffSpouse, name: 'staffSpouse', menuShow: true },
          // 租赁参数
          { path: 'rentOption', component: rentOption, name: 'rentOption', menuShow: true },
          { path: 'rentPostArea', component: rentPostArea, name: 'rentPostArea', menuShow: true },
          { path: 'rentPostVal', component: rentPostVal, name: 'rentPostVal', menuShow: true },
          { path: 'rentTitleArea', component: rentTitleArea, name: 'rentTitleArea', menuShow: true },
          { path: 'rentTitleVal', component: rentTitleVal, name: 'rentTitleVal', menuShow: true },
          // 维修参数
          { path: 'fixContent', component: fixContent, name: 'fixContent', menuShow: true },
          // 租金参数
          { path: 'rentalOption', component: rentalOption, name: 'rentalOption', menuShow: true }
        ]
      }
    ]
  },
  // 基础数据
  {
    path: '/basic',
    component: Home,
    name: 'basiceData',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [
      { path: '/basic/building', component: buildingData, name: 'buildingData', menuShow: true },
      { path: '/basic/region', component: region, name: 'region', menuShow: true },
      { path: 'buildingArea', component: indexbldgRgn, name: 'indexbldgRgn', menuShow: true }
    ]
  }
]

// 声明路由
const router = new Router({
  mode: 'history',
  routes: routes
})

export default router
