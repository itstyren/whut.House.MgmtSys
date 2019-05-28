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
import {
  getQiniuToken
} from '@/api/user'
import * as types from '../mutation-types.js'

/**
 * 递归后台返回的路由表，将component属性改成完整的.vue文件路径
 * @param {Array}   array
 * @returns {Array}  
 */
const addComponentDir = (array) => {
  if (Object.prototype.toString.call(array) === "[object Array]" && array.length !== 0) {
    array.forEach(element => {
      if (element.component) {
        let component = element.component
        delete element.component
        element.component = () => import('@/views/' + component + '.vue')
      }
      if (element.children && element.children.length !== 0) {
        addComponentDir(element.children)
      }
    })
  } else {
    array = []
  }
}

const user = {
  state: {
    token: getToken(),
    name: '',
    roles: [],
    no: -1,
    id: -1,
    ip: -1,
    loginTime: -1,
    qiniuToken: '',
    hasGetUserInfo: false,
    userRouters: [],
    property: ''
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
    SET_QINIU_TOKEN: (state, token) => {
      state.qiniuToken = token
    },
    [types.SET_HASGETUSERINFO]: (state, status) => {
      state.hasGetUserInfo = status
    },
    [types.SET_USERROUTERS]: (state, routers) => {
      state.userRouters = routers
    },
    [types.SET_PROPERTY]: (state, property) => {
      state.property = property
    },
  },

  actions: {
    // 用户名登录
    LoginByUsername({
      commit
    }, userInfo) {
      // const username = userInfo.no.trim()
      return new Promise((resolve, reject) => {
        loginByUsername(userInfo).then(res => {
          if (res.data.status === 'success') {
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
          const data = res.data.data
          const userRouters = JSON.parse(data.userRouters)

          addComponentDir(userRouters)
          const userData = res.data.data.data[0]
          const logindata = res.data.data.logindata
          commit(types.SET_ROLEID, userData.roleId)
          commit(types.SET_NAME, userData.name)
          commit(types.SET_USERNO, userData.no)
          commit(types.SET_USERID, userData.id)
          commit(types.SET_PROPERTY, res.data.data.property)
          commit(types.SET_HASGETUSERINFO, true)
          commit(types.SET_USERROUTERS, userRouters)
          if (logindata != null) {
            commit(types.SET_USERIP, logindata.ip)
            commit(types.SET_USERLASTLOGIN, logindata.loginTime)

          }
          resolve(res)
          getQiniuToken().then(res => {
            commit('SET_QINIU_TOKEN', res.data.message)
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
