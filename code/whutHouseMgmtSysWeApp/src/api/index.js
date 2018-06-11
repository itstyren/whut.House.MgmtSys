import fly from "@/utils/request";
// 首次登录使用
export function postLoginWX(data) {
  return fly.post("/userLogin/loginWX", { ...data})

}
// 微信id登录使用
export function postLoginByUnionID(data) {
  return fly.post("/userLogin/loginByUnionId", { ...data })
}
// 根据token获取信息
export function getTokenLogin(token) {
  return fly.get(`/userLogin/tokenLogin?token=${token}`,)
}

// 向服务器发送code
export function getWXCode(code) {
  return fly.get(`/userLogin/code?code=${code}`, )
}