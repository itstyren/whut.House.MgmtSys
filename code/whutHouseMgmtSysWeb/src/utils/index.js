export default {
  //公共提示方法，传入当前的vue以及res.data。 返回状态判断并给出提示
  statusinfo(vue, data) {
    if (data.status == 'success') {
      vue.$message({
        type: 'success',
        message: data.message,
        duration: 1500
      })
    } else {
      vue.$message({
        type: 'error',
        message: data.message,
        duration: 1500

      })
    }
  },

  transfOpenStatus(row) {
    return row.rentIsOpenSel == true ? '正在选房' : '日期已过'
  },

  // 移除数组中的指定值
  arrayRemove(array, val) {
    Array.prototype.indexOf = function (val) {
      for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
      }
      return -1;
    };

    Array.prototype.remove = function (val) {
      var index = this.indexOf(val);
      if (index > -1) {
        this.splice(index, 1);
      }
    }
    array.remove(val)
    return array
  },
  arrayindexOf(array, val) {
    Array.prototype.indexOf = function (val) {
      for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
      }
      return -1;
    };

    return array.indexOf(val)
  }


}
