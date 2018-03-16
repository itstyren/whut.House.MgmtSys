import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)

Vue.use(Router)

import Home from '@/views/Home'
import HelloWorld from '@/components/HelloWorld'

export const constantRouterMap = [
    { path: '/login', component: _import('login/index') },
    { path: '/404', component: _import('errorPage/404') },
    {
        path: '/',
        component: Home,
        redirect: '/index',
        children: [{
            path: 'index',
            component: HelloWorld,
            name: 'index',
        }]
    },
]

export default new Router({
    // mode: 'history', // require service support
    scrollBehavior: () => ({ y: 0 }),
    routes: constantRouterMap
})

export const asyncRouterMap = [
    {
        path: '/sysmanage',
        component: Home,
        redirect: '/sysmanage/paramSet',
        meta: { roles: [3] }, // you can set roles in root nav
        children: [{
            path: 'paramSet',
            component: _import('sysManage/paramSet/indexParam'),
            name: 'paramSet',
            children:[
                { path: 'houseType', component: _import('sysManage/paramSet/houseParam/houseType'), name: 'houseType', meta: { title: 'houseType' } },
                { path: 'houseLayout', component: _import('sysManage/paramSet/houseParam/houseLayout'), name: 'houseLayout', meta: { title: 'houseLayout' } },
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
    { path: '*', redirect: '/404', hidden: true }
]
