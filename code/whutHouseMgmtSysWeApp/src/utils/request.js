import axios from 'axios'
import store from '../store/store'
//import store_counter from '../pages/counter/store'


//配置axios 适应小程序发起请求   相关博客：https://m.poorren.com/mpvue-mini-program-ajax-axios
axios.defaults.adapter = function (config) {
  return new Promise((resolve, reject) => {
    //console.log(config)
    // TODO wx.request(...)
    resolve();
  })
}

// create an axios instance
const service = axios.create({
  //baseURL: 'http://localhost:8787/whutHouseMgmtReposity', // api的base_url
  baseURL: 'http://118.126.117.96:8080/whutHouseMgmtReposity', // api的base_url  
  
  // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
  // 如果请求花费超过 `timeout` 的时间，请求将被中断
  timeout: 5000 // request timeout
})

// request interceptor
service.interceptors.request.use(config => {
  // Do something before request is sent
  if (store.token) {
    //console.log(2)
    config.headers['X-Token'] = store.token // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
  }
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

export default service
