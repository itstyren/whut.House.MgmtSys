import Vue from 'vue'
import Router from 'vue-router'
const _import = require('./_import_' + process.env.NODE_ENV)


Vue.use(Router)

import layout from '@/views/layout'
import home from '@/views/home'

export const constantRouterMap = [{
    path: '/login',
    component: _import('login/index')
  },
  {
    path: '/404',
    component: _import('errorPage/404')
  },
  {
    path: '',
    redirect: '/index',
    component: layout,
    children: [{
      path: 'index',
      component: home,
      name: 'index',
      meta: {
        title: 'index',
        noCache: true
      }
    }]
  }
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRouterMap,
  //mode: 'history',

})
