import Vuex from 'vuex'
import Vue from 'vue'
import * as types from './mutation-types.js'

// 调用
Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        access_token:'',
        RoleID:'',
        Name:'12',
        regionStatus:false,
        // 七牛云令牌和地址
        uploadToken:'GfDe7p6rupDyEHYhvHfO-NhXvJ0KtxVOBSKxiKtU:Zcw6ifNOcltho7BKwsamkdTgcjo=:eyJzY29wZSI6IndodXRob3VzZW1nbXRzeXMiLCJkZWFkbGluZSI6MTAxNTE0OTc3Njc0fQ==',
        uploadUrl: 'http://p1z72063k.bkt.clouddn.com/',
        // 单一职工信息
        staffData:{},
        // 职工信息编辑状态
        staffModify:false,
    },
    mutations:{
        // 登录时写入
        [types.LOGIN]:(state,resData)=>{
            localStorage.access_token=resData.data.access_token
            localStorage.RoleID=resData.data.RoleID
            localStorage.Name=resData.data.Name
            state.access_token=resData.data.access_token
            state.RoleID=resData.data.RoleID
            state.Name=resData.data.Name
        },
        // 登出时清空
        [types.LOGOUT]:(state)=>{
            localStorage.access_token=''
            localStorage.RoleID=''
            localStorage.Name=''
            state.access_token=''
            state.RoleID=''
            state.Name=''
        },
        // 刷新时重写
        [types.REFREST]:(state)=>{
            state.access_token=localStorage.access_token,
            state.RoleID=localStorage.RoleID
            state.Name=localStorage.Name
        },
        // 401时
        [types.DENY]:(state)=>{
            state.access_token=''
        },
        // 区域变更时，写入
        [types.REGION_CHANGE]:(state)=>{
            state.regionStatus=!state.regionStatus
        },
        // 写入新的职工信息
        [types.STAFF_DATA]:(state,staff)=>{
            state.staffData=staff
        },
        //职工是否处于编辑状态
        [types.STAFF_MODIFY]: (state,status) => {
            state.staffModify = status
        }
    }
})


