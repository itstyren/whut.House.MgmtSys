// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// 引用elementUI
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// 全局组件引入
import myIcon from '@/components/SvgIcon'
// 引入vue全家桶
import App from './App'
import router from './router'
import store from './store/index'
// simulation data
import './mock'
// permission control
import './permission'

import './styles/index.scss'
// 引入图标库
import './assets/icons/iconfont'

Vue.use(ElementUI)
Vue.config.productionTip = false

Vue.component('my-icon', myIcon)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {
    App
  }
})
