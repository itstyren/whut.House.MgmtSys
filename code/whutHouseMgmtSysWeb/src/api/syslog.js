import request from '@/utils/request'
// 多条件获取日志信息
export function getAllSysLog(params, data) {
  return request({
    url: `/syslog/getAllByCondition?page=${params.page}&size=${params.size}`,
    method: 'post',
    data: data
  })
}
// 批量删除日志记录
export function delMultiSysLog(data) {
  return request({
    url: '/syslog/delete',
    method: 'delete',
    data: data
  })
}
