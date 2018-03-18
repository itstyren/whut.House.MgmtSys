import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  loginByUsername, getUserInfo, logout
} from '@/api/login'
import * as types from '../mutation-types.js'

const user = {
  state: {
    token: getToken(),
    name: '',
    roles: [],
    no:-1
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
      state.roles.push(roleId) 
    },
    // set login staff NO
    [types.SET_USERNO]:(state,staffNO)=>{
      state.no=staffNO
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
          if (res.data.status == 'error') { 
            reject('error')
          }
          const data = res.data.data.data[0]
          commit(types.SET_ROLEID, data.roleId)
          commit(types.SET_NAME, data.name)
          commit(types.SET_USERNO,data.no)
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 前端 登出，当登录令牌有误时使用
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        commit(types.SET_TOKEN, '')
        removeToken()
        resolve()
      })
    },
    LogOut({commit}){
     // console.log(1)
      return new Promise((resolve, reject) => {
        logout().then(() => {
          commit(types.SET_TOKEN, '')
          commit(types.SET_ROLEID, -1)
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }

}

export default user
