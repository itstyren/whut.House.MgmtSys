import Mock from 'mockjs'
import userinfoAPI from './userInfo'
// 网上选房相关
Mock.mock(/\/text\/text/, 'get', {
  "number|123.1-10": 1
})
export default Mock

Mock.mock(/\/user\/getHouseList/, 'get', userinfoAPI.getHouseList)
