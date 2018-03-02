import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'
import login from '@/views/login/index'
import noPageFound from '@/views/errorPage/404'

// 住房参数
import paramSet from '@/views/sysManage/paramSet/indexParam'
import houseType from '@/views/sysManage/paramSet/houseParam/houseType'
import houseLayout from '@/views/sysManage/paramSet/houseParam/houseLayout'
import houseStatus from '@/views/sysManage/paramSet/houseParam/houseStatus'
import houseStruct from '@/views/sysManage/paramSet/houseParam/houseStruct'
// 职工参数
import staffDept from '@/views/sysManage/paramSet/staffParam/staffDept'
import staffPost from '@/views/sysManage/paramSet/staffParam/staffPost'
import staffTitle from '@/views/sysManage/paramSet/staffParam/staffTitle'
import staffClass from '@/views/sysManage/paramSet/staffParam/staffClass'
import staffStatus from '@/views/sysManage/paramSet/staffParam/staffStatus'
import staffSpouse from '@/views/sysManage/paramSet/staffParam/staffSpouse'
// 租赁参数
import rentOption from '@/views/sysManage/paramSet/rentParam/rentOption'
import rentPostArea from '@/views/sysManage/paramSet/rentParam/rentPostArea'
import rentPostVal from '@/views/sysManage/paramSet/rentParam/rentPostVal'
import rentTitleArea from '@/views/sysManage/paramSet/rentParam/rentTitleArea'
import rentTitleVal from '@/views/sysManage/paramSet/rentParam/rentTitleVal'
// 维修参数
import fixContent from '@/views/sysManage/paramSet/fixParam/fixContent'
// 租金参数
import rentalOption from '@/views/sysManage/paramSet/rentalParam/rentalOption'
import residentRel from '@/views/sysManage/paramSet/rentalParam/residentRel'

// 基础数据
// 楼栋区域
import indexbldgRgn from '@/views/basiceData/buildingRegionData/indexNav'
import region from '@/views/basiceData/buildingRegionData/regionData'
import building from '@/views/basiceData/buildingRegionData/buildingData'
// 房屋参数
import indexHouse from '@/views/basiceData/houseData/indexNav'
import house from '@/views/basiceData/houseData/houseData'
// 职工管理
import indexStaff from '@/views/basiceData/staffData/indexNav'
import staffData from '@/views/basiceData/staffData/staffData'
import singleStaffData from '@/views/basiceData/staffData/singleStaffData'
import addStaff from '@/views/basiceData/staffData/addStaff'
// 住房登记
import indexResident from '@/views/basiceData/houseResident/indexNav'
import houseResident from '@/views/basiceData/houseResident/resident'

// 维修管理
// 维修申请
import fixApply from '@/views/fixManage/fixApply'
// 维修受理
import fixHanding from '@/views/fixManage/fixHanding'
// 维修审核
import fixReview from '@/views/fixManage/fixReview'
// 维修直批
import fixSuper from '@/views/fixManage/fixSuper'
// 维修申请管理
import fixApplyManager from '@/views/fixManage/fixApplyManager'
// 维修结算
import fixBalance from '@/views/fixManage/fixBalance'

// 租赁管理
import hireAccept from '@/views/leaseManage/hireAccept'

// 网上选房
// 选房资格认定
import hireStafferSet from '@/views/onlie/hireStafferSet'
// 房源设置
import hireHouseSet from '@/views/onlie/hireHouseSet'
// 住房申请
import hireApply from '@/views/onlie/hireApply'


Vue.use(Router)

// 定义路由数据
const routes = [
  // 404页面
  {
    path: '*',
    name: 'Error',
    component: noPageFound
  },

  // 登录
  {
    path: '/login',
    name: 'login',
    component: login,
    meta: {
      requireAuth: true
    }
  },
  // 首页
  {
    path: '/',
    name: 'Home',
    component: Home,
    meta: {
      requireAuth: true
    },
    redirect: '/index',
    children: [{
      path: '/index',
      component: HelloWorld,
      name: 'index',
      menuShow: true
    }]
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
    children: [{
      path: 'paramSet',
      component: paramSet,
      name: 'paramSet',
      children: [
        // 住房参数
        {
          path: 'houseType',
          component: houseType,
          name: 'houseType',
          menuShow: true
        },
        {
          path: 'houseLayout',
          component: houseLayout,
          name: 'houseLayout',
          menuShow: true
        },
        {
          path: 'houseStatus',
          component: houseStatus,
          name: 'houseStatus',
          menuShow: true
        },
        {
          path: 'houseStruct',
          component: houseStruct,
          name: 'houseStruct',
          menuShow: true
        },
        // 职工参数
        {
          path: 'staffDept',
          component: staffDept,
          name: 'staffDept',
          menuShow: true
        },
        {
          path: 'staffPost',
          component: staffPost,
          name: 'staffPost',
          menuShow: true
        },
        {
          path: 'staffTitle',
          component: staffTitle,
          name: 'staffTitle',
          menuShow: true
        },
        {
          path: 'staffClass',
          component: staffClass,
          name: 'staffClass',
          menuShow: true
        },
        {
          path: 'staffStatus',
          component: staffStatus,
          name: 'staffStatus',
          menuShow: true
        },
        {
          path: 'staffSpouse',
          component: staffSpouse,
          name: 'staffSpouse',
          menuShow: true
        },
        // 租赁参数
        {
          path: 'rentOption',
          component: rentOption,
          name: 'rentOption',
          menuShow: true
        },
        {
          path: 'rentPostArea',
          component: rentPostArea,
          name: 'rentPostArea',
          menuShow: true
        },
        {
          path: 'rentPostVal',
          component: rentPostVal,
          name: 'rentPostVal',
          menuShow: true
        },
        {
          path: 'rentTitleArea',
          component: rentTitleArea,
          name: 'rentTitleArea',
          menuShow: true
        },
        {
          path: 'rentTitleVal',
          component: rentTitleVal,
          name: 'rentTitleVal',
          menuShow: true
        },
        // 维修参数
        {
          path: 'fixContent',
          component: fixContent,
          name: 'fixContent',
          menuShow: true
        },
        // 租金参数
        {
          path: 'rentalOption',
          component: rentalOption,
          name: 'rentalOption',
          menuShow: true
        },
        {
          path: 'residentRel',
          component: residentRel,
          name: 'residentRel',
          menuShow: true
        }
      ]
    }]
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
      // 区域楼栋
      {
        path: 'buildingArea',
        component: indexbldgRgn,
        name: 'indexbldgRgn',
        children: [{
            path: 'region',
            component: region,
            name: 'region',
            menuShow: true
          },
          {
            path: 'building/:id',
            component: building,
            name: 'building',
            menuShow: true
          }
        ],
        menuShow: true
      },
      // 房屋
      {
        path: 'house',
        component: indexHouse,
        name: 'indexHouse',
        children: [{
          path: 'byBuilding/:id',
          component: house,
          name: 'house',
          menuShow: true
        }]
      },
      // 职工
      {
        path: 'staff',
        component: indexStaff,
        name: 'indexStaff',
        children: [{
          path: 'byDept/:id',
          component: staffData,
          name: 'staffData',
          menuShow: true
        }, {
          path: 'byId/:id',
          component: singleStaffData,
          name: 'singleStaffData',
          menuShow: true
        }, {
          path: 'add',
          component: addStaff,
          name: 'addStaff',
          menuShow: true
        }]
      },
      // 住房登记
      {
        path: 'houseResident',
        component: indexResident,
        name: 'indexResident',
        children: [{
          path: ':id',
          component: houseResident,
          name: 'houseResident',
          menuShow: true
        }]
      }
    ]
  },
  // 维修管理
  {
    path: '/fixManage',
    component: Home,
    name: 'fixManage',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [{
        path: 'fixApply',
        component: fixApply,
        name: 'fixApply',
        menuShow: true
      },
      {
        path: 'fixHanding',
        component: fixHanding,
        name: 'fixHanding',
        menuShow: true,
      }, {
        path: 'fixReview',
        component: fixReview,
        name: 'fixReview',
        menuShow: true,
      },
      {
        path: 'fixSuper',
        component: fixSuper,
        name: 'fixSuper',
        menuShow: true,
      },
      {
        path: 'fixApplyManager',
        component: fixApplyManager,
        name: 'fixApplyManager',
        menuShow: true,
      },
      {
        path: 'fixBalance',
        component: fixBalance,
        name: 'fixBalance',
        menuShow: true,
      }
    ]
  },
    // 租赁管理
  {
    path: '/leaseManage',
    component: Home,
    name: 'leaseManage',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [{
        path: 'hireAccept',
        component: hireAccept,
        name: 'hireAccept',
        menuShow: true
      },
    ]
  },
  // 网上选房
  {
    path: '/online',
    component: Home,
    name: 'online',
    meta: {
      requireAuth: true
    },
    menuShow: true,
    children: [{
        path: 'hireStafferSet',
        component: hireStafferSet,
        name: 'hireStafferSet',
        menuShow: true
      },
      {
        path: 'hireHouseSet',
        component: hireHouseSet,
        name: 'hireHouseSet',
        menuShow: true
      },
      {
        path: 'hireApply',
        component: hireApply,
        name: 'hireApply',
        menuShow: true
      },
    ]
  }
]

// 声明路由
const router = new Router({
  mode: 'history',
  routes: routes
})

export default router
