import request from '@/utils/request'
// 获取用户组列表
export const getAuthList = () => {
  return request({
    url: '/auth/authList',
    method: 'get'
  })
}

// 批量删除用户组
export const delAuthList = (list) => {
  return request({
    url: '/auth/delAuthList',
    method: 'delete',
    data: list
  })
}
// 获取某一用户组的信息
export const getOneAuth = (id) => {
  return request({
    url: `/auth/getOneAuth/${id}`,
    method: 'get'
  })
}

// 修改用户组
export const editAuth = (data) => {
  return request({
    url: '/auth/editAuth',
    method: 'put',
    data: data
  })
}

// 增加用户组
export const addAuth = (data) => {
  return request({
    url: '/auth/addAuth',
    method: 'post',
    data: data
  })
}

// 获取员工列表
export const getStaffList = (group_name) => {
  return request({
    url: '/auth/staffList',
    method: 'post',
    data: group_name
  })
}
// 获取用户组的部分信息（id、用户组名称）
export const getPartAuthList = () => {
  return request({
    url: '/auth/partAuthList',
    method: 'get'
  })
}
