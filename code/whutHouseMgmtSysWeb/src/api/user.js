import request from '@/utils/request'

export function getUserHouse(staffID) {
  return request({
    url: '/user/getHouseList',
    method: 'get',
    params: {
      staffID
    }
  })
}
// 个人信息界面维修更新信息
export function getUserFix(staffID) {
  return request({
    url: `/staffHomePage/getFixProcessStateChangeInfo/${staffID}`,
    method: 'get',
  })
}
//个人信息界面租赁更新信息
export function getUserHire(staffID) {
  return request({
    url: `/staffHomePage/getHireProcessStateChangeInfo/${staffID}`,
    method: 'get',
  })
}