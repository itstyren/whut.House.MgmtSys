import {
  login,
  USER_INFO,
  authList,
  staffList
} from './authData'

// 获取用户信息
export const getUserInfo = token => {
  return USER_INFO
}
// 登录
export const loginByUsername = userInfo => {
  return login
}
// 获取用户组列表
export const getAuthList = () => {
  return {
    data: {
      data: {
        list: authList
      }
    },
    status: 'success'
  }
}

// 批量删除行
export const delAuthList = (request) => {

  let list = JSON.parse(request.body)

  list.forEach(id => {
    let index = authList.findIndex(auth => auth.id === id)
    authList.splice(index, 1)
  });
  return {
    data: {
      data: {
        status: 'success',
        msg: '删除成功'
      }
    }
  }
}

// 增加用户组
export const addAuthPermission = (req) => {
  let list = JSON.parse(req.body)
  authList.push(list)
  return {
    data: {
      data: {
        status: 'success',
        msg: '添加成功！'
      }
    }
  }
}

// 获取某一用户组的信息
export const getOneAuth = (req) => {
  let id = JSON.parse(req.body).id
  let data = authList.find(item => item.id === id)
  if (data) {
    return {
      data: {
        data: {
          data: data,
          status: 'success'
        },
      }
    }
  } else {
    return {
      data: {
        data: {
          status: 'error',
          msg: '该用户组不存在！'
        }
      }
    }
  }
}
// 修改某一用户组信息
export const editAuth = (req) => {
  let auth = JSON.parse(req.body)
  oneAuth = auth
  return {
    data: {
      data: {
        status: 'success',
        msg: '修改成功！'
      }
    }
  }
}

// 获取员工列表
export const getStaffList = (req) => {
  let name = req.body
  if (staffList.group_name === name) {
    return {
      data: {
        data: {
          staffList: staffList.staff
        }
      }
    }
  } else {
    return {
      data: {
        data: {
          msg: '获取员工列表失败！',
          status: 'error'
        }
      }
    }
  }
}
