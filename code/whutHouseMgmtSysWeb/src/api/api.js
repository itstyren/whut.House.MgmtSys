import axios from 'axios'

let base = 'http://localhost:8787/whutHouseMgmtReposity/'

// 参数设置--职工参数
// 获取方法
export const getStaffParam = (params, paramClass) => { return axios.get(`${base}staffParam/get/${paramClass}`, { params: params }) }
// 删除方法
export const deleteStaffParam = (staffParamId) => { return axios.delete(`${base}staffParam/delete/${staffParamId}`) }
// 新增方法
export const postStaffParam = (params) => { return axios.post(`${base}staffParam/add`, params) }
// 编辑方法
export const putStaffParam = (params) => { return axios.put(`${base}staffParam/modify`, params) }

// 参数设置--房屋参数
// 获取方法
export const getHouseParam = (params, paramClass) => { return axios.get(`${base}houseParam/get/${paramClass}`, { params: params }) }
// 删除方法
export const deleteHouseParam = (houseParamsId) => { return axios.delete(`${base}houseParam/delete/${houseParamsId}`) }
// 新增方法
export const postHouseParam = (params) => { return axios.post(`${base}houseParam/add`, params) }
// 编辑方法
export const putHouseParam = (params) => { return axios.put(`${base}houseParam/modify`, params) }

// 参数设置--租赁参数
// 获取方法【与职工相关】
export const getRentParamAboutStaff = (params, paramClass) => { return axios.get(`${base}rentParamAboutStaff/get/${paramClass}`, { params: params }) }
// 修改方法【与职工相关】
export const putRentParamAboutStaff = (params) => { return axios.put(`${base}rentParamAboutStaff/modify`, params) }

// 参数设置--维修参数
// 获取方法
export const getFixParam = (params, paramClass) => { return axios.get(`${base}fixParam/get/${paramClass}`, { params: params }) }
// 删除方法
export const deleteFixParam = (paramsId) => { return axios.delete(`${base}fixParam/delete/${paramsId}`) }
// 新增方法
export const postFixParam = (params) => { return axios.post(`${base}fixParam/add`, params) }
// 编辑方法
export const putFixParam = (params) => { return axios.put(`${base}fixParam/modify`, params) }
