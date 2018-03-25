import request from '@/utils/request'

// 租赁管理-租赁受理
// 获取需要受理的表单
export function getHireAccept(params, type) {
  return request({
    url: `/hire/getAccept/${type}`,
    method: 'get',
    params: params
  })
}
// 申请受理
export function putHireAccept(data) {
  return request({
    url: `/hire/addAccept`,
    method: 'put',
    data: data
  })
}
// 租赁管理-租赁审核
// 获取需要审核的
export function getHireAgree(params, type) {
  return request({
    url: `/hire/getAgree/${type}`,
    method: 'get',
  })
}
// 申请审核
export function putHireAgree(data) {
  return request({
    url: `/hire/addAgree`,
    method: 'put',
    data: data
  })
}
// 租赁管理-租赁审批
// 获取需要审批的
export function getHireApprove(params, type) {
  return request({
    url: `/hire/getApprove/${type}`,
    method: 'get',
  })
}
// 申请审批
export function putHireApprove(data) {
  return request({
    url: `/hire/addApprove`,
    method: 'put',
    data: data
  })
}
// 租赁管理-租赁直批
// 直批通过
export function putHireSuper(data) {
  return request({
    url: `/hire/addDirectApply`,
    method: 'post',
    data: data
  })
}
// 租赁管理-合同签订
// 获取需要签订的合同
export function getHireContract(params) {
  return request({
    url: `/hire/getSignContract`,
    method: 'get',
  })
}
// 签订合同
export function putHireContract(data) {
  return request({
    url: `/hire/addSignContract`,
    method: 'post',
    data: data
  })
}

// 租赁管理-申请书管理
// 获取所有申请书
export function getHireForm(params) {
  return request({
    url: `/hire/getManagement`,
    method: 'get',
    params:params
  })
}
// 重新受理
export function getHireReAccept(formID) {
  return request({
    url: `/hire/reAccept/${formID}`,
    method: 'get',
  })
}
// 重新审核
export function getHireReAgree(formID) {
  return request({
    url: `/hire/reAgree/${formID}`,
    method: 'get',
  })
}
// 重新审批
export function getHireReApprove(formID) {
  return request({
    url: `/hire/reApprove/${formID}`,
    method: 'get',
  })
}
// 直接删除
export function deleteHireForm(formID) {
  return request({
    url: `/hire/delete/${formID}`,
    method: 'delete',
  })
}
// 租赁管理-租金生成
// 根据id或者姓名查询
export function getHireRenter(params) {
  return request({
    url: `/rentGenerate/selectRentByStaffNoOrName`,
    method: 'get',
    params:params
  })
}
// 多条件查询
export function postHireRenterMultiply(params,data) {
    return request({
        url: `/rentGenerate/selectRentByMultiCondition?page=${params.page}&size=${params.size}`,
        method: 'post',
        data: data
    })
}
// 生成租金
export function postHireGenerateRental(params,data) {
  return request({
    url: `/rentGenerate/rentGen`,
    method: 'post',
    data: data,
    params:params
  })
}
// 已生成租金查询
export function postHireRentalQuery(params, data) {
  return request({
    url: `/rentGenerate/queryRent?page=${params.page}&size=${params.size}`,
    method: 'post',
    data: data
  })
}

// 根据职工获取租赁信息
export function getHireByStaffID(staffID) {
  return request({
    url: `/hire/getAllByStaffId/${staffID}`,
    method: 'get',
  })
}
