const getters = {
  token: state => state.user.token,
  roles: state => state.user.roles,
  userName: state => state.user.name,
  userNO:state=>state.user.no,
  addRouters: state => state.permission.addRouters,

}
export default getters
