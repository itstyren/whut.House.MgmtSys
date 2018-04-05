import request from '@/utils/request'

// 获取x天的维修数量分析
export function getFixContentByDay(params) {
  return request({
    url: `/fixRecord/Content`,
    method: 'get',
    params: params
  })
}
// 获取一周维修处理情况分析
export function getFixContentCount() {
  return request({
    url: `/fixRecord/contentCount`,
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
export function postHouseParamCount(params, data) {
  return request({
    url: `/houseRecord/Content`,
    method: 'post',
    params: params,
    data: data
  })
}
// 获取住房总数据
export function postHouseRecordTotal(data) {
    return request({
        url: `/houseRecord/houseTotal`,
        method: 'post',
        data: data
    })
}
// 住房户型及使用量
export function postHouseRecordLayout(data) {
    return request({
        url: `/houseRecord/houseLayout`,
        method: 'post',
        data: data
    })
}
//  校区入住量统计
export function postHouseRecordCampus(data) {
    return request({
        url: `/houseRecord/houseCampus`,
        method: 'post',
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
