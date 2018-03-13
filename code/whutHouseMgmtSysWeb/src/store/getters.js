const getters = {
  token: state => state.user.token,
  roleID: state => state.user.roleId,
  userName: state => state.user.name,
  userNO:state=>state.user.no,
}
export default getters
