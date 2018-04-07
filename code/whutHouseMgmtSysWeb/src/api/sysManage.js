import request from '@/utils/request'

// 参数设置--职工参数
// 获取方法
export function getStaffParam(params, paramClass) {
  return request({
    url: `/staffParam/get/${paramClass}`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteStaffParam(staffParamId) {
  return request({
    url: `/staffParam/delete/${staffParamId}`,
    method: 'delete',
  })
}
// 新增方法
export function postStaffParam(data) {
  return request({
    url: `/staffParam/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putStaffParam(data) {
  return request({
    url: `/staffParam/modify`,
    method: 'put',
    data: data
  })
}

// 参数设置--房屋参数
// 获取方法
export function getHouseParam(params, paramClass) {
  return request({
    url: `/houseParam/get/${paramClass}`,
    method: 'get',
    params: params

  })
}
// 删除方法
export function deleteHouseParam(staffParamId) {
  return request({
    url: `/houseParam/delete/${staffParamId}`,
    method: 'delete',
  })
}
// 新增方法
export function postHouseParam(data) {
  return request({
    url: `/houseParam/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putHouseParam(data) {
  return request({
    url: `/houseParam/modify`,
    method: 'put',
    data: data
  })
}
// 参数设置--租赁参数
// 获取方法【与职工相关】
export function getRentParamAboutStaff(params, paramClass) {
  return request({
    url: `/rentParamAboutStaff/get/${paramClass}`,
    method: 'get',
    params: params

  })
}
// 修改方法【与职工相关】
export function putRentParamAboutStaff(data) {
  return request({
    url: `/rentParamAboutStaff/modify`,
    method: 'put',
    data: data
  })
}
// 获取方法【选房选项】
export function getRentParamAboutEvent(params) {
  return request({
    url: `/rentEvent/get`,
    method: 'get',
    params: params

  })
}
// 删除方法【选房选项】
export function deleteRentParamAboutEvent(rentEventId) {
  return request({
    url: `/rentEvent/delete/${rentEventId}`,
    method: 'delete',
  })
}
// 新增方法【选房选项】
export function postRentParamAboutEvent(data) {
  return request({
    url: `/rentEvent/add`,
    method: 'post',
    data: data
  })
}
// 修改方法【选房选项】
export function putRentParamAboutEvent(data) {
  return request({
    url: `/rentEvent/modify`,
    method: 'put',
    data: data
  })
}
// 参数设置--维修参数
// 获取方法
export function getFixParam(params, paramClass) {
  return request({
    url: `/fixParam/get/${paramClass}`,
    method: 'get',
    params: params

  })
}
// 删除方法
export function deleteFixParam(fixParamId) {
  return request({
    url: `/fixParam/delete/${fixParamId}`,
    method: 'delete',
  })
}
// 新增方法
export function postFixParam(data) {
  return request({
    url: `/fixParam/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putFixParam(data) {
  return request({
    url: `/fixParam/modify`,
    method: 'put',
    data: data
  })
}

// 参数设置--租金参数
// 获取方法
export function getRentalParam(params) {
  return request({
    url: `/rentalParam/get`,
    method: 'get',
    params: params

  })
}
// 编辑方法
export function putRentalParam(data) {
  return request({
    url: `/rentalParam/modify`,
    method: 'put',
    data: data
  })
}

// 参数设置--登记关系
// 获取方法
export function getResident(params) {
  return request({
    url: `/houseRegister/getRegisterRel`,
    method: 'get',
    params: params

  })
}
// 新增方法
export function postResident(data) {
  return request({
    url: `/houseRegister/updateRegisterRel`,
    method: 'post',
    data: data
  })
}
// 参数设置--系统参数
// 获取方法
export function getSysParam(params) {
  return request({
    url: `/systemParam/get`,
    method: 'get',
    params: params

  })
}
// 更新方法
export function putSysParam(data) {
  return request({
    url: `/systemParam/update`,
    method: 'put',
    data: data
  })
}