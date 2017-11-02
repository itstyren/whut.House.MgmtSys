import {getStaffParam,deleteStaffParam,postStaffParam,putStaffParam} from '@/api/api'
export default {
    //公共提示方法，传入当前的vue以及res.data。 返回状态判断并给出提示
    statusinfo(vue,data){
        if(data.status=='success'){
            vue.$message({
            type: 'success',
            message: data.message
          })}else{ 
            vue.$message({
            type: 'error',
            message: data.message
          })             
          }
      },
          
}