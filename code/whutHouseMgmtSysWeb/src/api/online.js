import request from '@/utils/request'

// 网上选房-选房资格认定
// 初始获取可选房员工
export function getCanSelectStaff(params) {
  return request({
    url: `/selHouseQuaAuth/activeShow`,
    method: 'get',
    params: params
  })
}
// 初始获已设置选房员工
export function getHaveSelectStaff(params) {
  return request({
    url: `/selHouseQuaAuth/canselectShow`,
    method: 'get',
    params: params
  })
}
// 在线选房-选房资格认定
// 根据id或者姓名查询员工
export function getStaffByNoOrName(params) {
  return request({
    url: `/selHouseQuaAuth/selectByNoOrName`,
    method: 'get',
    params: params
  })
}
// 多条件查询后可选房员工
export function postCanSelectmulticondition(params, data) {
  return request({
    url: `/selHouseQuaAuth/selectActiveStaffMultiCondition?page=${params.page}&size=${params.size}`,
    method: 'post',
    data: data
  })
}
// 员工设为可选房
export function postSetCanSelect(data) {
  return request({
    url: `/selHouseQuaAuth/setCanselect`,
    method: 'post',
    data: data
  })
}
// 员工取消可选房
export function postcancelCanSelect(data) {
  return request({
    url: `/selHouseQuaAuth/cancelCanselect`,
    method: 'post',
    data: data
  })
}

// 网上选房-房源设置
// 初始获取未设置房源房屋
export function getActiveHouse(params) {
  return request({
    url: `/housingSet/activeHouseShow`,
    method: 'get',
    params: params
  })
}
// 初始获取已设置房源房屋
export function getSetHouse(params) {
  return request({
    url: `/housingSet/canselectHouseShow`,
    method: 'get',
    params: params
  })
}
// 多条件查询未设置房源

export function postActiveHousemulticondition(params, data) {
  return request({
    url: `/housingSet/activeHouseShowByMultiCondition?page=${params.page}&size=${params.size}`,
    method: 'post',
    data: data
  })
}
// 多条件查询已设置房源
export function postSetHousemulticondition(params, data) {
  return request({
    url: `/housingSet/canselectHouseShowByMultiCondition?page=${params.page}&size=${params.size}`,
    method: 'post',
    data: data
  })
}
// 设置房源
export function postSetHouse(data) {
  return request({
    url: `/housingSet/setHousing`,
    method: 'post',
    data: data
  })
}
// 撤销房源
export function postcancelHouse(data) {
  return request({
    url: `/housingSet/cancelSetHousing`,
    method: 'post',
    data: data
  })
}

// 网上选房-自助选房
// 职工选房开始界面
export function getSelectInfoByName(staffID) {
  return request({
    url: `/selfHelpSelectHouse/isSelectingHouse/${staffID}`,
    method: 'get',
  })
}
// 获取未选房职工
export function getAllCanselectHouseStaff(params) {
  return request({
    url: `/selfHelpSelectHouse/getAllCanselectHouse`,
    method: 'get',
    params: params
  })
}
// 提交选房申请
export function getSubmitSelectHouseApply(params) {
  return request({
    url: `/selfHelpSelectHouse/submitSelectHouseApplication`,
    method: 'get',
    params: params
  })
}

// 网上选房-住房申请
// 获取相关信息
export function getStaffHireInfo(params, staffID) {
  return request({
    url: `/hire/getApply/${staffID}`,
    method: 'get',
    params: params
  })
}
// 提交申请
export function postHireApply(data) {
  return request({
    url: `/hire/addApply`,
    method: 'post',
    data: data
  })
}
// 在线访问统计
export function getOnLineCount() {
  return request({
    url: '/online/onLineCount',
    method: 'get'
  })
}
