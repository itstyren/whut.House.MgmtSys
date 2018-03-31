import request from '@/utils/request'

// export function getUserHouse(staffID) {
//   return request({
//     url: '/user/getHouseList',
//     method: 'get',
//     params: {
//       staffID
//     }
//   })
// }
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
// 修改密码
export function putChangePassword(params) {
  return request({
    url: `/staff/updatePassword`,
    method: 'put',
    params: params
  })
}
// 维修结果评价
export function putFixComment(data) {
  return request({
    url: `/fixRatings/fixEvaluation`,
    method: 'put',
    data:data
  })
}

// 获取职工房屋数据
export function getUserHouse(staffID) {
  return request({
    url: `/houseInfo/getResidentHouseByStaffId/${staffID}`,
    method: 'get',
  })
}

// 工作清单
export function getJobList(staffID) {
  return request({
    url: `/record/jobList`,
    method: 'get',
  })
}

// 快速通道添加
export function postQuickPass(data) {
  return request({
    url: '/record/quickPassage',
    method: 'post',
    data: data
  })
}

// 快速通道获取
export function getQuickPass(staffID) {
  return request({
    url: `/record/quickPassage`,
    method: 'get',
    params: staffID
  })
}