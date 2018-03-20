const getters = {
  language: state => state.app.language,
  token: state => state.user.token,
  roles: state => state.user.roles,
  userName: state => state.user.name,
  userNO:state=>state.user.no,
  userID:state=>state.user.id,
  addRouters: state => state.permission.addRouters,
  permission_routers: state => state.permission.routers,
}
export default getters
