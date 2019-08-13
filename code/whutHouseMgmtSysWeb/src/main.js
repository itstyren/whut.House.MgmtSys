// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
// 引用elementUI
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VCharts from 'v-charts'
import VueAMap from 'vue-amap';
// 全局组件引入
import myIcon from '@/components/SvgIcon'
// 引入vue全家桶
import App from './App'
import router from './router'
import store from './store/index'
// simulation data
// permission control
import './permission'
// global filters
import * as filters from './filters'
// 引入样式库
import './styles/index.scss'
// 引入图标库
import './assets/icons/iconfont'
// 引入国际化
import i18n from './lang' // Internationalization

import VueQuillEditor from 'vue-quill-editor'
// require styles
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'

// if (process.env.NODE_ENV !== 'production') require('./mock')
// register global utility filters.
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})

Vue.use(Element, {
  //size: 'medium', // set element-ui default size
  i18n: (key, value) => i18n.t(key, value)
})
Vue.use(VCharts)
Vue.use(VueQuillEditor, /* { default global options } */ )
Vue.use(VueAMap);
Vue.config.productionTip = false
VueAMap.initAMapApiLoader({
  key: '25eb288ee358a8196bd9704f22dd4ec7',
  plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
  // 默认高德 sdk 版本为 1.4.4
  v: '1.4.4'
});

Vue.prototype.$message1 = function (option) {
  this.$message(Object.assign({
    showClose: true,
    duration: 1500
  }, option))
}
Vue.component('my-icon', myIcon)
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  i18n,
  template: '<App/>',
  components: {
    App
  }
})
