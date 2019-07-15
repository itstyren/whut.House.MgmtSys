import {
  constantRouterMap
} from '@/router'
const getters = {
  language: state => state.app.language,
  token: state => state.user.token,
  roleId: state => state.user.roleId,
  property: state => state.user.property,
  userName: state => state.user.name,
  userNO: state => state.user.no,
  userID: state => state.user.id,
  addRouters: state => state.permission.addRouters,
  permission_routers: state => constantRouterMap.concat(state.user.userRouters),
  seachVisible: state => state.app.seachVisible,
  qiniuURL: state => state.uploadUrl,
  qiniuToken: state => state.user.qiniuToken,
  campusList: state => state.user.campusList
}
export default getters
