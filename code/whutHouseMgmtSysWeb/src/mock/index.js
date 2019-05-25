import Mock from 'mockjs'
import {
  getHouseList

} from './userInfo'
import {
  getUserInfo,
  loginByUsername,
  getAuthList,
  delAuthList,
  addAuthPermission,
  getOneAuth,
  editAuth,
  getStaffList
} from './permission'
// 网上选房相关
Mock.mock(/\/text\/text/, 'get', {
  "number|123.1-10": 1
})

Mock.mock(/\/user\/getHouseList/, 'get', getHouseList)
Mock.mock(/\/userLogin\/tokenLogin/, 'get', getUserInfo)
Mock.mock(/\/userLogin\/login/, 'post', loginByUsername)
Mock.mock(/\/auth\/authList/, 'get', getAuthList)
Mock.mock(/\/auth\/delAuthList/, 'post', delAuthList)
Mock.mock(/\/auth\/addAuth/, 'post', addAuthPermission)
Mock.mock(/\/auth\/getOneAuth/, 'get', getOneAuth)
Mock.mock(/\/auth\/editAuth/, 'post', editAuth)
Mock.mock(/\/auth\/staffList/, 'post', getStaffList)
export default Mock
