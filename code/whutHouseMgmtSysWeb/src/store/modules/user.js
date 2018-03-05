import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  loginByUsername
} from '@/api/login'
import * as types from '../mutation-types.js'

const user = {
  state: {
    token: getToken(),
    name: '',
    roles: '',
  },
  mutations: {
    // 设置token
    [types.SET_TOKEN]: (state, token) => {
      state.token = token
    }
  },

  actions: {
    // 用户名登录
    LoginByUsername({
      commit
    }, userInfo) {
      //const username = userInfo.no.trim()
      return new Promise((resolve, reject) => {
        loginByUsername(userInfo).then(res => {
          if (res.data.status == 'success') {
            const data = res.data.data
            commit('setToken', data.token) 
            setToken(data.token)           //将登录成功的保存在cookie
            resolve(res.data.message)
          } else {
            reject(res.data.message)
          }
        }).catch(error => {
          reject(error)
        })
      })
    },
  }

}

export default user
