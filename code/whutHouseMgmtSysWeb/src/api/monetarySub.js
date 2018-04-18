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
export function postAllStaffMonetarySub(params) {
    return request({
        url: `/staffMonetarySub/getAllMonetarySub`,
        method: 'get',
        params: params
    })
}

// 获取所有一次性补贴统计
export function postAllStaffLumpMonetarySub(params) {
    return request({
        url: `/oneTimeMonetarySub/getAllOneTimeMonetarySub`,
        method: 'get',
        params: params
    })
}
