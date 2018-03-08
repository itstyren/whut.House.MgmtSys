import request from '@/utils/request'

export function loginByUsername(userInfo) {
  return request({
    url: '/userLogin/login',
    method: 'post',
    data: userInfo
  })
}
export function getUserInfo(token) {
  return request({
    url: '/userLogin/tokenLogin',
    method: 'get',
    params: {
      token
    }
  })
}

export function logout() {
  return request({
    url: '/userLogin/logout',
    method: 'get'
  })
}
