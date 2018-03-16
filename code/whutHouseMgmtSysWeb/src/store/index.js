import Vuex from 'vuex'
import Vue from 'vue'
import user from './modules/user'
import permission from './modules/permission'
import * as types from './mutation-types.js'
import getters from './getters'


// 调用
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    regionStatus: false,
    // 七牛云令牌和地址
    uploadToken: 'GfDe7p6rupDyEHYhvHfO-NhXvJ0KtxVOBSKxiKtU:Zcw6ifNOcltho7BKwsamkdTgcjo=:eyJzY29wZSI6IndodXRob3VzZW1nbXRzeXMiLCJkZWFkbGluZSI6MTAxNTE0OTc3Njc0fQ==',
    uploadUrl: 'http://p1z72063k.bkt.clouddn.com/',
    // 单一职工信息
    staffData: {},
    // 职工信息编辑状态
    staffModify: false,
    residentStaffData: {},
    // 登记成功标志
    residentSuccess: false,
    // 维修直批数据查询
    fixHouselist: [],
  },
  modules: {
    user, permission
  },
  getters,
  mutations: {
    // 区域变更时，写入
    [types.REGION_CHANGE]: (state) => {
      state.regionStatus = !state.regionStatus
    },
    // 写入新的职工信息
    [types.STAFF_DATA]: (state, staff) => {
      state.staffData = staff
    },
    // 职工是否处于编辑状态
    [types.STAFF_MODIFY]: (state, status) => {
      state.staffModify = status
    },
    // 房屋登记将点击的员工的简单信息存储
    [types.RESIDENT_STAFF]: (state, staffData) => {
      state.residentStaffData = staffData
    },
    // 房屋登记成功后状态改变供登记表区域检测变化重新获取
    [types.RESIDENT_SUCCESS]: (state) => {
      state.residentSuccess = !state.residentSuccess
    },
    // 维修直批获取职工拥有的房屋
    [types.FIX_GETHOUSE]: (state, houseList) => {
      state.fixHouselist = houseList
    }
  }
})
