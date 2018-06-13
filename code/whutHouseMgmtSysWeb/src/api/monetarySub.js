import request from '@/utils/request'

// 获取个人一次性补贴额
export function getStaffLumpMonetaryByNO(staffNO) {
    return request({
        url: `/oneTimeMonetarySub/getOneTimeMonetarySubByStaffNo/${staffNO}`,
        method: 'get',
    })
}

// 获取个人年度补贴额
export function getStaffMonetaryByNO(params,staffNO) {
    return request({
        url: `/staffMonetarySub/getMonetarySubByStaffNo/${staffNO}`,
        method: 'get',
        params: params
    })
}

// 获取所有的年度补贴统计
export function postAllStaffMonetarySub(params,data) {
    return request({
        url: `/staffMonetarySub/getAllMonetarySubByCondition?page=${params.page}&size=${params.size}`,
        method: 'post',
        data:data
    })
}

// 获取所有一次性补贴统计
export function postAllStaffLumpMonetarySub(params,data) {
    return request({
        url: `/oneTimeMonetarySub/getAllOneTimeMonetarySubByCondition?page=${params.page}&size=${params.size}`,
        method: 'post',
        data:data,
    })
}

// 监听职称的变动
export function postPromoteSubStaffID(staffID) {
    return request({
        url: `/oneTimeMonetarySub/addPromoteSub/${staffID}`,
        method: 'post',
    })
}