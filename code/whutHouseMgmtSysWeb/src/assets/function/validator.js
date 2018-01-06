export const checkNum = (rule, value, callback) => {
  const RULES = /^\d{0,13}$/
  if (!value) {
    callback(new Error('该选项不能为空'));
  } else if (!RULES.test(value)) {
    callback(new Error("必须为数字"));
  } else {
    callback();
  }
};

export const checkNULL = (rule, value, callback) => {
  console.log(value)
  if (!value) {
    callback(new Error(`选项不能为空`));
  } else {
    callback();
  }
};
