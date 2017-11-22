import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'

import paramSet from '@/components/sysManage/paramSet/indexParam'

import buildingData from '@/components/basiceData/buildingData'
import region from '@/components/basiceData/regionData'

import Text1 from '@/views/Home1'
import paramSetText from '@/components/sysManage/paramSet/indexParam1'
import houseType from '@/components/sysManage/paramSet/houseParam/houseType'

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
          { path: '/paramSet1/houseType', component: houseType, name: 'houseType', menuShow: true }
        ]

      }
    ]
  },
  // 系统管理
  {
    path: '/',
    component: Home,
    name: 'sysManage',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [
      {path: '/paramSet', component: paramSet, name: 'paramSet', menuShow: true}
    ]
  },
  // 基础数据
  {
    path: '/',
    component: Home,
    name: 'basiceData',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [
      { path: '/basic/building', component: buildingData, name: 'buildingData', menuShow: true },
      { path: '/basic/region', component: region, name: 'region', menuShow: true }
    ]
  }
]

// 声明路由
const router = new Router({
  mode: 'history',
  routes: routes
})

export default router
