// https://vuex.vuejs.org/zh-cn/intro.html
// make sure to call Vue.use(Vuex) if using a module system
import Vue from 'vue'
import Vuex from 'vuex'
import getters from './getters'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    API_URL: 'http://118.126.117.96:8080/whutHouseMgmtReposity',
    access_token: '',
    count: 0,
    userinfo: []
  },
  getters,
  mutations: {
    increment: (state) => {
      state.count += 1
    },
    decrement: (state) => {
      obstatej.count -= 1
    },
    login: (state, data) => {
      state.access_token = data
    },
    setUserInfo: (state, data) => {
      state.userinfo = data
    },
  }
})

export default store
