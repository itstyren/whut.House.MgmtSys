import request from '@/utils/request'

// 获取x天的维修数量分析
export function getFixContentByDay(params, roleId) {
  return request({
    url: `/fixRecord/Content/${roleId}`,
    method: 'get',
    params: params
  })
}
// 获取一周维修处理情况分析
export function getFixContentCount(roleId) {
  return request({
    url: `/fixRecord/contentCount/${roleId}`,
    method: 'get',
  })
}
// 获取周访问量
export function getVisitRecord(params) {
  return request({
    url: `/record/login`,
    method: 'get',
    params: params
  })
}
// 获取7日访问量
export function getVisitCapacity(params) {
  return request({
    url: `/record/visitCapacity`,
    method: 'get',
    params: params
  })
}
// 住房参数统计分析接口
export function postHouseParamCount(params, data, roleId) {
  return request({
    url: `/houseRecord/Content/${roleId}`,
    method: 'post',
    params: params,
    data: data
  })
}
// 获取住房总数据
export function postHouseRecordTotal(data, roleId) {
  return request({
    url: `/houseRecord/houseTotal/${roleId}`,
    method: 'post',
    data: data
  })
}
// 住房户型及使用量
export function postHouseRecordLayout(data, roleId) {
  return request({
    url: `/houseRecord/houseLayout/${roleId}`,
    method: 'post',
    data: data
  })
}
//  校区入住量统计
export function postHouseRecordCampus(data, roleId) {
  return request({
    url: `/houseRecord/houseCampus/${roleId}`,
    method: 'post',
    data: data
  })
}

// 住房住户表格统计
export function postHouseStaffRecord(params, data, roleId) {
  return request({
    url: `/houseRecord/relationByHouse/${roleId}`,
    method: 'post',
    params: params,
    data: data
  })
}

// 获取
// 多套住房查询接口--详细查询
export function postStaffMultiplyHouse(params, data) {
  return request({
    url: `/moreHouseQuery/staffMoreHouseQuery`,
    method: 'post',
    params: params,
    data: data
  })
}
// 多套住房查询-查询职工多几套
export function postStaffMultiplyHouseNum(params, data) {
  return request({
    url: `/moreHouseQuery/staffMoreHouseSta`,
    method: 'post',
    params: params,
    data: data
  })
}

// 维修情况数据统计
export function postFixFormTotalRecord(data, roleId) {
  return request({
    url: `/fixRecord/total/${roleId}`,
    method: 'post',
    data: data
  })
}

// 返回进行维修类型趋势变动
export function postFixTypeRecord(data, roleId) {
  return request({
    url: `/fixRecord/contentCount/${roleId}`,
    method: 'post',
    data: data
  })
}
// 维修反馈情况表格统计
export function postFixFormRecord(params, data, roleId) {
  return request({
    url: `/fixRecord/multilQueryContent/${roleId}`,
    method: 'post',
    params: params,
    data: data
  })
}



// 维修评价雷达图统计
export function postFixCommentRadar(data, roleId) {
  return request({
    url: `/fixRecord/getFixRatingsRecord/${roleId}`,
    method: 'post',
    data: data
  })
}

// 维修类型饼图
export function postFixTypeBar(data, roleId) {
  return request({
    url: `/fixRecord/getFixType/${roleId}`,
    method: 'post',
    data: data
  })
}
