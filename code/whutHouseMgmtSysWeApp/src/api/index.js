import fly from "@/utils/request";
// 首次登录使用
export function postLoginWX(data) {
  return fly.post("/userLogin/loginWX", { ...data
  })

}
// 微信id登录使用
export function postLoginByUnionID(data) {
  return fly.post("/userLogin/loginByUnionId", { ...data
  })
}
// 根据token获取信息
export function getTokenLogin(token) {
  return fly.get(`/userLogin/tokenLogin?token=${token}`, )
}

// 向服务器发送code
export function getWXCode(code) {
  return fly.get(`/userLogin/code?code=${code}`, )
}

// 向服务器解密信息
export function getdecodeInfo(data) {
  return fly.post(`/userLogin/decodeUserInfo`, { ...data
  })
}

// 获取职工个人信息及已有住房
export function getStaffInfo(staffID) {
  return fly.get(`/fix/getApply/${staffID}`, )
}

// 维修参数获取
export function getFixParam(params, paramClass) {
  return fly.get(`/fixParam/get/${paramClass}`, { ...params
  })
}

// 维修申请提交
export function postFixApply(data) {
  return fly.post(`/fix/addApply`, { ...data
  })
}

// 个人维修处理查看
export function getFixByStaffID(staffID) {
  return fly.get(`/fix/getByStaffId/${staffID}`, )
}

// 解除登录绑定
export function getUnbindUnionID(staffID) {
  return fly.get(`/staff/unbind/${staffID}`, )
}

//维修评分
export function putFixComment(data) {
  return fly.put(`/fixRatings/fixEvaluation`, { ...data
  })
}

// 租赁申请提交
export function postHireApply(data) {
  return fly.post(`/hire/addApply`, { ...data
  })
}

// 返回租赁申请前信息
export function getStaffHireInfo(staffID) {
  return fly.get(`/hire/getApply/${staffID}`, )
}

// 根据职工id获取租赁申请情况
export function getHireByStaffID(staffID) {
  return fly.get(`/hire/getAllByStaffId/${staffID}`, )
}

// 职工选房开始界面
export function getSelectInfoByName(staffID) {
  return fly.get(`/selfHelpSelectHouse/isSelectingHouse/${staffID}`, )
}

// 初始获取已设置房源房屋
export function getSetHouse(data) {
  return fly.get(`/housingSet/canselectHouseShow`, { ...data
  })
}

// 获取个人年度补贴额
export function getStaffMonetaryByNO(params, staffNO) {
  return fly.get(`/staffMonetarySub/getMonetarySubByStaffNo/${staffNO}`, { ...params
})
}

// 获取个人一次性补贴额
export function getStaffLumpMonetaryByNO(staffNO) {
  return fly.get(`/oneTimeMonetarySub/getOneTimeMonetarySubByStaffNo/${staffNO}`,)
}

// 获取今年货币化参数
export function getStaffMonetaryParameter(staffID) {
  return fly.get(`/staffMonetarySub/getFormulaParameter/${staffID}`, )
}

// 提交选房申请
export function getSubmitSelectHouseApply(params) {
  return fly.get(`/selfHelpSelectHouse/submitSelectHouseApplication`, { ...params
  })
}
// 获取方法--根据员工id获取单一员工信息
export function getStaff(staffID) {
  return fly.get(`/staff/getByID/${staffID}`)
}