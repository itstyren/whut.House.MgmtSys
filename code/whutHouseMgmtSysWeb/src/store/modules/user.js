import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  loginByUsername,
  getUserInfo,
  logout,
} from '@/api/login'
import { getQiniuToken} from '@/api/user'
import * as types from '../mutation-types.js'

const user = {
  state: {
    token: getToken(),
    name: '',
    roles: [],
    no: -1,
    id: -1,
    ip: -1,
    loginTime: -1,
    qiniuToken:''
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
    [types.SET_USERNO]: (state, staffNO) => {
      state.no = staffNO
    },
    // set login staff ID
    [types.SET_USERID]: (state, staffID) => {
      state.id = staffID
    },
    [types.SET_USERIP]: (state, ip) => {
      state.ip = ip
    },
    [types.SET_USERLASTLOGIN]: (state, loginTime) => {
      state.loginTime = loginTime
    },
    SET_QINIU_TOKEN:(state,token)=>{
      state.qiniuToken=token
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
    GetUserInfo({
      commit,
      state
    }) {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(res => {
          if (res.data.status == 'error') {
            reject('error')
          }
          const data = res.data.data.data[0]
          const logindata = res.data.data.logindata
          commit(types.SET_ROLEID, data.roleId)
          commit(types.SET_NAME, data.name)
          commit(types.SET_USERNO, data.no)
          commit(types.SET_USERID, data.id)
          commit(types.SET_USERIP, logindata.ip)
          commit(types.SET_USERLASTLOGIN, logindata.loginTime)
          resolve(res)          
          getQiniuToken().then(res => {
            commit('SET_QINIU_TOKEN',res.data.message)
            resolve(res)
          }).catch(error => {
            reject(error)
            console.log(error)
          })
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 前端 登出，当登录令牌有误时使用
    FedLogOut({
      commit
    }) {
      return new Promise(resolve => {
        commit(types.SET_TOKEN, '')
        removeToken()
        resolve()
      })
    },
    LogOut({
      commit
    }) {
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
