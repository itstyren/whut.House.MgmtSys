import request from '@/utils/request'

export function loginByUsername(userInfo) {
  return request({
    url: 'userLogin/login',
    method: 'post',
    data: userInfo
  })
}
