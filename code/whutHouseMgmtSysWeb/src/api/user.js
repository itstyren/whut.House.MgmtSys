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
