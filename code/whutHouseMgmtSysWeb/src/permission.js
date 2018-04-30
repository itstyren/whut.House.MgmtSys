import router from './router'
import store from './store'
import {
  Message
} from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import {
  getToken
} from '@/utils/auth' // getToken from cookie

NProgress.configure({
  showSpinner: false
}) // NProgress Configuration

const whiteList = ['/login'] // no redirect whitelist

router.beforeEach((to, from, next) => {
  NProgress.start() // start progress bar
  if (getToken()) { // determine if there has token
    /* has token*/
    if (to.path === '/login') {
      next({
        path: '/'
      })
      NProgress.done() // if current page is dashboard will not trigger	afterEach hook, so manually handle it
    }
    //如果不是指向login
    else {
      if (store.getters.roles.length === 0) { // 判断当前用户是否已拉取完user_info信息
        store.dispatch('GetUserInfo').then(res => { // 拉取user_info
          const roles = store.getters.roles // note: roles must be a array! such as: ['editor','develop'] 
          if (store.getters.roles[0] == 0)
            store.getters.roles[0] = 'ADMIN'
          else if (store.getters.roles[0] == 1)
            store.getters.roles[0] = 'OFFICER'
          else if (store.getters.roles[0] == 3)
            store.getters.roles[0] = 'STAFF'
          store.dispatch('GenerateRoutes', {
              roles
            }).then(() => { // 根据roles权限生成可访问的路由表
              router.addRoutes(store.getters.addRouters) // 动态添加可访问路由表
          next({ ...to,
            replace: true
          }) // hack方法 确保addRoutes已完成 ,set the replace: true so the navigation will not leave a history record
            })
        }).catch((e) => {
          console.log(e)
          store.dispatch('FedLogOut').then(() => {
            Message.error('身份验证失败，请重新登录')
            next({
              path: '/login'
            })
          })
        })
      } else {
        // 没有动态改变权限的需求可直接next() 删除下方权限判断 ↓
        // if (hasPermission(store.getters.roles, to.meta.roles)) {
        //   next() //
        // } else {
        //   next({
        //     path: '/401',
        //     replace: true,
        //     query: {
        //       noGoBack: true
        //     }
        //   })
        // }
        // 可删 ↑
        //console.log(store.getters.rolses)
        next()
      }
    }
  } else {
    /* has no token*/
    if (whiteList.indexOf(to.path) !== -1) { // 在免登录白名单，直接进入
      next()
    } else {
      next({
        path: '/login',
        query: {
          redirect: to.fullPath  //同时记录下当前页面路由方便下次直接跳转。
        }
      }) // 否则全部重定向到登录页
      NProgress.done() // if current page is login will not trigger afterEach hook, so manually handle it
    }
  }
})

router.afterEach(() => {
  NProgress.done() // finish progress bar
})
