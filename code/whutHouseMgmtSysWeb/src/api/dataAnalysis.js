import request from '@/utils/request'

// 获取x天的维修数量分析
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
// 住房参数统计分析接口
export function getHouseParamCount(params) {
    return request({
        url: `/houseRecord/Content`,
        method: 'get',
        params: params
    })
}