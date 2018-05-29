import store from '../store/index'

const root_url = 'http://118.126.117.96:8080/whutHouseMgmtReposity';



//发起 网络请求
// wx.request({
//     url: root_url + "/userLogin/login", //仅为示例，并非真实的接口地址
//     data: param,
//     method: "POST",
//     header: {
//         "content-type": "application/json" // 默认值
//     },
//     success: function (res) {
//         console.log(res.data.status);
//         if (res.data.status === "success") {
//             store.commit("login", res.data.data.token);
//             wx.request({
//                 url:
//                     "http://118.126.117.96:8080/whutHouseMgmtReposity/userLogin/tokenLogin",
//                 method: "GET",
//                 data: {
//                     token: res.data.data.token
//                 },
//                 header: {
//                     "content-type": "application/json", // 默认值
//                     "X-token": res.data.data.token
//                 },
//                 success: function (_res) {
//                     console.log(res.data);
//                     const url = "../index/main";
//                     wx.switchTab({ url });
//                 }
//             });
//         } else {
//             //登录失败 处理
//         }
//     }
// });
