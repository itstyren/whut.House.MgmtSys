import Cookies from 'js-cookie'

const TokenKey = 'X-Token'
export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

/**
 *@description 根据校区-编号对应表（idList, nameList），将校区编号组成的字符串转化成校区名称的数组
 *@param {String} 用中划线拼接的校区编号，如：'1-3-4'
 *@returns {Array} 由校区名称组成的数组，如：['西院', '马房山东院校区', '余家头北区'] 
 */
export function numberToCampus(campusNumberString, idList, nameList) {
  let numberArr = campusNumberString.split('-')
  let campusArr = []
  numberArr.forEach(element => {
    let index = idList.indexOf(Number(element))
    campusArr.push(nameList[index])
  })
  return campusArr
}

/**
 *@description 根据校区-编号对应表（idList, nameList），将校区名称的数组转化成用-拼接的校区编号的字符串
 *@param {Array} 由校区名称组成的数组，如：['西院', '马房山东院校区', '余家头北区'] 
 *@returns {String} 用中划线拼接的校区编号，如：'1-3-4'
 */
export function campusToNumber(campusArr, idList, nameList) {
  let numberArr = []
  campusArr.forEach(element => {
    let index = nameList.indexOf(element)
    numberArr.push(idList[index])
  })
  return numberArr.join('-')
}
