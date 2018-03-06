import request from '@/utils/request'

// 基础数据--区域管理
// 获取方法with楼栋
export function getRegionWithBuildings(params, paramClass) {
  return request({
    url: `/region/getRegionWithBuildings`,
    method: 'get',
    params: params
  })
}
// 获取方法
export function getRegionData(params, paramClass) {
  return request({
    url: `/region/get`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteRegionData(staffParamId) {
  return request({
    url: `/region/delete/${staffParamId}`,
    method: 'delete',
  })
}
// 新增方法
export function postRegionData(data) {
  return request({
    url: `/region/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putRegionData(data) {
  return request({
    url: `/region/modify`,
    method: 'put',
    data: data
  })
}
