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
// 维修参数
import fixContent from '@/components/sysManage/paramSet/fixParam/fixContent'

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
      {path: '/index', component: HelloWorld, name: 'index', menuShow: true},
      { path: '/paramSet',
        component: paramSet,
        name: 'paramSet',
        children: [
          // 住房参数
          { path: '/paramSet/houseType', component: houseType, name: 'houseType', menuShow: true },
          { path: '/paramSet/houseLayout', component: houseLayout, name: 'houseLayout', menuShow: true },
          { path: '/paramSet/houseStatus', component: houseStatus, name: 'houseStatus', menuShow: true },
          { path: '/paramSet/houseStruct', component: houseStruct, name: 'houseStruct', menuShow: true },
          // 维修参数
          { path: '/paramSet/fixContent', component: fixContent, name: 'fixContent', menuShow: true }
        ]
      }
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
          // 维修参数
          { path: 'fixContent', component: fixContent, name: 'fixContent', menuShow: true }
        ]
      }
    ]
    // caseSensitive: false // 匹配规则是否大小写敏感？(默认值：false)
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
