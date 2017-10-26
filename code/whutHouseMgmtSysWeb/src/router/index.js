import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Home from '@/views/Home'
import paramSet from '@/components/sysManage/paramSet/indexParam'

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
        menuShow: true
      }
    ]
  }
]

// 声明路由
const router = new Router({
  mode: 'history',
  routes: routes
})

export default router
