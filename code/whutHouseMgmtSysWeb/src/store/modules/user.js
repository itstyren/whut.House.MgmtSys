import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  loginByUsername, getUserInfo
} from '@/api/login'
import * as types from '../mutation-types.js'

const user = {
  state: {
    token: getToken(),
    name: '',
    roleId: -1,
  },
  mutations: {
    // 设置token
    [types.SET_TOKEN]: (state, token) => {
      state.token = token
    },
    // set  login staff name
    [types.SET_NAME]: (state, name) => {
      state.name = name
    },
    // set login staff role ID
    [types.SET_ROLEID]: (state, roleId) => {
      state.roleId = roleId
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
            commit(types.SET_TOKEN, data.token)
            setToken(data.token) //将登录成功的保存在cookie
            resolve(res.data.message)
          } else {
            reject(res.data.message)
          }
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 获取用户信息
    GetUserInfo({commit,state}) {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(res => {
          if (res.data.status == 'erroe') { 
            reject('error')
          }
          const data = res.data.data
          commit(types.SET_ROLEID, data.roles)
          commit(types.SET_NAME, data.name)
          // commit('SET_AVATAR', data.avatar)
          // commit('SET_INTRODUCTION', data.introduction)
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit(types.SET_TOKEN, '')
        removeToken()
        resolve()
      })
    },
  }

}

export default user
