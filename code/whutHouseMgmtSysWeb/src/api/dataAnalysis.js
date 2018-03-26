import request from '@/utils/request'

// 获取x天的维修类型
export function getFixNameByDay(params) {
    return request({
        url: `/fixRecord/Name`,
        method: 'get',
        params: params
    })
}
// 获取x天的维修数量
export function getFixContentByDay(params) {
    return request({
        url: `/fixRecord/Content`,
        method: 'get',
        params: params
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