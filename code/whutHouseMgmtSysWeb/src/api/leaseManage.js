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
        params: params
    })
}