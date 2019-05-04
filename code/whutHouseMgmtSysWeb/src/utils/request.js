import axios from 'axios'
import router from '../router'
import {
  Message,MessageBox
} from 'element-ui'
import store from '@/store'
import {
  getToken
} from '@/utils/auth'

// create an axios instance
const service = axios.create({
  baseURL: 'http://172.16.65.105:8080/whutHouseMgmtReposity', // api的base_url
  // baseURL: 'http://118.126.117.96:8080/whutHouseMgmtReposity', // api的base_url  
  // baseURL: 'http://120.78.226.24:8080/whutHouseMgmtReposity', // api的base_url  
  // baseURL: 'https://www.terryren.com/whutHouseMgmtReposity', // api的base_url

  // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
  // 如果请求花费超过 `timeout` 的时间，请求将被中断
  timeout: 5000 // request timeout
})

// request interceptor
service.interceptors.request.use(config => {
  // Do something before request is sent
  if (store.getters.token) {
    //console.log(2)
    config.headers['X-Token'] = getToken() // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
  }
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// respone interceptor
service.interceptors.response.use(
  response => {
    /**
     * 下面的注释为通过response自定义code来标示请求状态，当code返回如下情况为权限有问题，登出并返回到登录页
     * 如通过xmlhttprequest 状态码标识 逻辑可写在下面error中
     */
    const res = response;
    if (res.status !== 200) {
      Message({
        message: res.message,
        type: 'error',
        duration: 5 * 1000
      });
      return Promise.reject('error');
    } else {
      return response;
    }
  },
  error => {
    console.log('err' + error) // for debug
    //  401:Token 过期了;
    const err =error.response
    console.log('出现错误')
    if (err.code == 401) {
      MessageBox.confirm('你已被登出，可以取消继续留在该页面，或者重新登录', '确定登出', {
        confirmButtonText: '重新登录',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        store.dispatch('FedLogOut').then(() => {
          location.reload(); // 为了重新实例化vue-router对象 避免bug
        });
      })
    }
    // 403: 用户分发
    if (err.status === 403) {
      MessageBox.confirm('你没有访问当前页面权限，如有疑问请联系管理员', '无权限', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        router.go(-1);
      })
    }
    return Promise.reject("网络异常，请检查链接")
  })

export default service
