import axios from 'axios'

let base = 'http://localhost:8787/whutHouseMgmtReposity/'

// 参数设置--职工参数
// 获取方法
export const getStaffParam = (params, paramClass) => { return axios.get(`${base}staffParam/get/${paramClass}`, { params: params }) }
// 删除方法
export const deleteStaffParam = (params, staffParamId) => { return axios.delete(`${base}staffParam/delete/${staffParamId}`, { params: params }) }
// 新增方法
export const postStaffParam = (params, paramClass) => { return axios.post(`${base}staffParam/add/${paramClass}`, params) }
// 编辑方法
export const putStaffParam = (params, staffParamId) => { return axios.put(`${base}staffParam/modify/${staffParamId}`, params) }

// 参数设置--房屋参数
// 获取方法
export const getHouseParam = (params, paramClass) => { return axios.get(`${base}houseParam/get/${paramClass}`, { params: params }) }
// 删除方法
export const deleteHouseParam = (params, houseParamId) => { return axios.delete(`${base}houseParam/delete/${houseParamId}`, { params: params }) }
// 新增方法
export const postHouseParam = (params, paramClass) => { return axios.post(`${base}houseParam/add/${paramClass}`, params) }
// 编辑方法
export const putHouseParam = (params, houseParamId) => { return axios.put(`${base}houseParam/modify/${houseParamId}`, params) }
