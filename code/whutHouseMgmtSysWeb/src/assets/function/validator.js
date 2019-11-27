// 匹配0——3000的整数
export const checkNum = (rule, value, callback) => {
  const RULES = /^\d{0,3000}$/
  if (!value) {
    callback();
  } else if (!RULES.test(value)) {
    callback(new Error("必须为整数"));
  } else {
    callback();
  }
};

// 匹配整数或者小数
export const checkIntOrDecimal = (rule, value, callback) => {
  const RULES = /^\d+(\.\d+)?$/
  if (!value) {
    callback();
  } else if (!RULES.test(value)) {
    callback(new Error("必须为整数或者小数"));
  } else {
    callback();
  }
};

export const checkTel = (rule, value, callback) => {
  const RULES = /^1\d{10}$/
  if (!value) {
    callback();
  } else if (!RULES.test(value)) {
    callback(new Error("手机号码格式不正确"));
  } else {
    callback();
  }
};

export const checkNULL = (rule, value, callback) => {
  if (!value) {
    callback(new Error(`选项不能为空`));
  } else {
    callback();
  }
};

export const checkEmail = (rule, value, callback) => {
  const RULES = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
  if (!value) {
    callback();
  } else if (!RULES.test(value)) {
    callback(new Error("邮箱格式不正确"));
  } else {
    callback();
  }
};

export const checkCode = (rule, value, callback) => {
  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X 
  const RULES = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
  if (!value) {
    callback();
  } else if (!RULES.test(value)) {
    callback(new Error("身份证格式不正确"));
  } else {
    callback();
  }
}
