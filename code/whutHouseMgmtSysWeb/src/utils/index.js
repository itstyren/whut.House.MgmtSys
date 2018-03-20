export default {
  //公共提示方法，传入当前的vue以及res.data。 返回状态判断并给出提示
  statusinfo(vue, data) {
    if (data.status == 'success') {
      vue.$message({
        type: 'success',
        message: data.message,
        duration: 2000
      })
    } else {
      vue.$message({
        type: 'error',
        message: data.message,
        duration: 2000

      })
    }
  },

  transfOpenStatus(row) {
    return row.rentIsOpenSel == true ? '正在选房' : '日期已过'
  }
}

