var Fly = require("flyio/dist/npm/wx") //npm引入方式
var fly = new Fly(); //创建fly实例
import store from "../store";

//配置请求基地址
fly.config = {
  // baseURL: "http://localhost:8787/whutHouseMgmtReposity",
  baseURL: 'https://www.terryren.com/whutHouseMgmtReposity', // api的base_url
  // baseURL: 'http://120.78.226.24:8080/whutHouseMgmtReposity', // api的base_url
  timeout: '5000',
}

//添加请求拦截器
fly.interceptors.request.use((config, promise) => {
    //给所有请求添加自定义header
      if (store.getters.token) {
        //console.log(store.getters.token)
        config.headers['X-Token'] = store.getters.token // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
      }
    //可以通过promise.reject／resolve直接中止请求
    //promise.resolve("fake data")
    return config;
})

//添加响应拦截器，响应拦截器会在then/catch处理之前执行
fly.interceptors.response.use(
  (response, promise) => {
    //只将请求结果的data字段返回
    return response.data
  },
  (err, promise) => {
    //发生网络错误后会走到这里
    //promise.resolve("ssss")
  }
)
export default fly

