import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)

const ADMIN = 0,DEPADMIN=1,STAFF = 3 

Vue.use(Router)

import layout from '@/views/layout'
import home from '@/views/home'

export const constantRouterMap = [
    { path: '/login', component: _import('login/index') },
    { path: '/404', component: _import('errorPage/404') },
    {
        path: '/',
        component: layout,
        redirect: '/index',
        children: [{path: 'index',component: home,name: 'index',meta: { title: 'index',  noCache: true }
        }]
    },
]

export default new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRouterMap,
    mode: 'history',
    
})

export const asyncRouterMap = [
    /* 参数设置 */
    {
        path: '/sysmanage',
        component: layout,
        redirect: '/sysmanage/paramSet',
        name: 'sysmanage',
        meta: { roles: [ADMIN, STAFF], title: 'sysManage'  }, // you can set roles in root nav
        children: [{
            path: 'paramSet',
            component: _import('sysManage/paramSet/indexParam'),
            name: 'paramSet',
            meta: { title: 'paramSet' },            
            children:[
                { path: 'houseLayout', component: _import('sysManage/paramSet/houseParam/houseLayout'), name: 'houseLayout', meta: { title: 'houseLayout' } },
                { path: 'houseType', component: _import('sysManage/paramSet/houseParam/houseType'), name: 'houseType', meta: { title: 'houseType' } },
                { path: 'houseStatus', component: _import('sysManage/paramSet/houseParam/houseStatus'), name: 'houseStatus', meta: { title: 'houseStatus' } },
                { path: 'houseStruct', component: _import('sysManage/paramSet/houseParam/houseStruct'), name: 'houseStruct', meta: { title: 'houseStruct' } },
                { path: 'staffDept', component: _import('sysManage/paramSet/staffParam/staffDept'), name: 'staffDept', meta: { title: 'staffDept' } },
                { path: 'staffPost', component: _import('sysManage/paramSet/staffParam/staffPost'), name: 'staffPost', meta: { title: 'staffPost' } },
                { path: 'staffTitle', component: _import('sysManage/paramSet/staffParam/staffTitle'), name: 'staffTitle', meta: { title: 'staffTitle' } },
                { path: 'staffClass', component: _import('sysManage/paramSet/staffParam/staffClass'), name: 'staffClass', meta: { title: 'staffClass' } },
                { path: 'staffStatus', component: _import('sysManage/paramSet/staffParam/staffStatus'), name: 'staffStatus', meta: { title: 'staffStatus' } },
                { path: 'staffSpouse', component: _import('sysManage/paramSet/staffParam/staffSpouse'), name: 'staffSpouse', meta: { title: 'staffSpouse' } },
                { path: 'rentOption', component: _import('sysManage/paramSet/rentParam/rentOption'), name: 'rentOption', meta: { title: 'rentOption' } },
                { path: 'rentPostArea', component: _import('sysManage/paramSet/rentParam/rentPostArea'), name: 'rentPostArea', meta: { title: 'rentPostArea' } },
                { path: 'rentPostVal', component: _import('sysManage/paramSet/rentParam/rentPostVal'), name: 'rentPostVal', meta: { title: 'rentPostVal' } },
                { path: 'rentTitleArea', component: _import('sysManage/paramSet/rentParam/rentTitleArea'), name: 'rentTitleArea', meta: { title: 'rentTitleArea' } },
                { path: 'rentTitleVal', component: _import('sysManage/paramSet/rentParam/rentTitleVal'), name: 'rentTitleVal', meta: { title: 'rentTitleVal' } },
                { path: 'fixContent', component: _import('sysManage/paramSet/fixParam/fixContent'), name: 'fixContent', meta: { title: 'fixContent' } },
                { path: 'rentalOption', component: _import('sysManage/paramSet/rentalParam/rentalOption'), name: 'rentalOption', meta: { title: 'rentalOption' } },
                { path: 'residentRel', component: _import('sysManage/paramSet/rentalParam/residentRel'), name: 'residentRel', meta: { title: 'residentRel' } },
            ]
        }]
    },
    /* 基础数据 */
    {
        path: '/basic',
        component: layout,
        redirect: '/sysmanage/paramSet',
        name: 'basic',        
        meta: { roles: [ADMIN, STAFF], noCache: true, title: 'basiceData'  }, // you can set roles in root nav
        children: [
            // 区域楼栋
            {
            path: 'buildingArea',
            component: _import('basiceData/buildingRegionData/indexNav'),
            name: 'indexbldgRgn',
            redirect: '/basic/buildingArea/region',
            meta: { title: 'region'},          
            children: [
                { path: 'region', component: _import('basiceData/buildingRegionData/regionData'), name: 'region', meta: { title: 'region' } },
                { path: 'building/:id', component: _import('basiceData/buildingRegionData/buildingData'), name: 'building', meta: { title: 'building' } },
            ]
        },
        // 房屋
        {
            path: 'house',
            component: _import('basiceData/houseData/indexNav'),
            name: 'indexHouse',
            redirect: '/basic/house/byBuilding/1',
            meta: { title: 'house' },                      
            children: [
                { path: 'byBuilding/:id', component: _import('basiceData/houseData/houseData'), name: 'house', meta: { title: 'house' } },
            ]
        },
        // 职工
        {
            path: 'staff',
            component: _import('basiceData/staffData/indexNav'),
            name: 'indexStaff',
            meta: { title: 'staff' },                      
            children: [
                { path: 'byDept/:id', component: _import('basiceData/staffData/staffData'), name: 'staffData', meta: { title: 'staffData' } },
                { path: 'byId/:id', component: _import('basiceData/staffData/singleStaffData'), name: 'singleStaffData', meta: { title: 'singleStaffData' } },
                { path: 'add', component: _import('basiceData/staffData/addStaff'), name: 'addStaff', meta: { title: 'addStaff' } },
            ]
        },
        // 住房登记
        {
            path: 'houseResident',
            component: _import('basiceData/houseResident/indexNav'),
            name: 'indexResident',
            meta: { title: 'resident' },
            children: [
                { path: ':id', component: _import('basiceData/houseResident/resident'), name: 'houseResident', meta: { title: 'houseResident' } },
            ]
        },
        // 数据导入
        {
            path: 'importData',
            component: _import('basiceData/importData/importData'),
            name: 'importData',
            meta: { title: 'import' },
        },

    ]
    },
    /* 维修管理 */ 
    {
        path: '/fixManage',
        component: layout,
        name: 'fixManage',                
        meta: { roles: [ADMIN, STAFF], title: 'fixManage'  }, // you can set roles in root nav
        children: [
            { path: 'fixAccept', component: _import('fixManage/fixAccept'), name: 'fixAccept', meta: { title: 'fixAccept' } },
            { path: 'fixAgree', component: _import('fixManage/fixAgree'), name: 'fixAgree', meta: { title: 'fixAgree' } },
            { path: 'fixSuper', component: _import('fixManage/fixSuper'), name: 'fixSuper', meta: { title: 'fixSuper' } },
            { path: 'fixApplyManager', component: _import('fixManage/fixApplyManager'), name: 'fixApplyManager', meta: { title: 'fixApplyManager' } },
            { path: 'fixBalance', component: _import('fixManage/fixBalance'), name: 'fixBalance', meta: { title: 'fixBalance' } },   
            { path: 'fixApply', component: _import('fixManage/fixApply'), name: 'fixApply', meta: { title: 'fixApply' } },
        ]
    },
    /* 租赁管理 */
    {
        path: '/leaseManage',
        component: layout,
        name: 'leaseManage',                        
        meta: { roles: [ADMIN, STAFF], title: 'leaseManage'  }, // you can set roles in root nav
        children: [
            { path: 'hireAccept', component: _import('leaseManage/hireAccept'), name: 'hireAccept', meta: { title: 'hireAccept' } },
            { path: 'hireAgree', component: _import('leaseManage/hireAgree'), name: 'hireAgree', meta: { title: 'hireAgree' } },
            { path: 'hireApprove', component: _import('leaseManage/hireApprove'), name: 'hireApprove', meta: { title: 'hireApprove' } },
            { path: 'hireSuper', component: _import('leaseManage/hireSuper'), name: 'hireSuper', meta: { title: 'hireSuper' } },
            { path: 'hireContract', component: _import('leaseManage/hireContract'), name: 'hireContract', meta: { title: 'hireContract' } },
            { path: 'hireApplyManage', component: _import('leaseManage/hireApplyManage'), name: 'hireApplyManage', meta: { title: 'hireApplyManage' } },
            { path: 'rentGenerate', component: _import('leaseManage/rentGenerate'), name: 'rentGenerate', meta: { title: 'rentGenerate' } },
        ]
    },
    /* 网上选房 */
    {
        path: '/online',
        component: layout,
        name: 'online',                                
        meta: { roles: [ADMIN, STAFF], title: 'onilne'  }, // you can set roles in root nav
        children: [
            { path: 'hireStafferSet', component: _import('online/hireStafferSet'), name: 'hireStafferSet', meta: { title: 'hireStafferSet' } },
            { path: 'hireHouseSet', component: _import('online/hireHouseSet'), name: 'hireHouseSet', meta: { title: 'hireHouseSet' } },
            { path: 'selfService', component: _import('online/selfService/index'), name: 'selfService', meta: { title: 'selfService' } },
            { path: 'hireApply', component: _import('online/hireApply'), name: 'hireApply', meta: { title: 'hireApply' } },
        ]
    },
    /* 个人设置 */
    {
        path: '/user',
        component: layout,
        hidden:true,
        children: [
            { path: 'setting', component: _import('personal/index'), name: 'personal', meta: { title: 'personal' } },
        ]
    },
    /* 错误界面 */
    { path: '*', redirect: '/404', hidden: true }
]
