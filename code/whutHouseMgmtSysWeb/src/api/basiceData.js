import request from '@/utils/request'
// 基础数据--校区管理
// 获取方法
export function getCampusData(params) {
  return request({
    url: `/campus/all`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteCompusData(compusData) {
  return request({
    url: `/campus/${compusData}`,
    method: 'delete',
  })
}
// 新增方法
export function postCompusData(data) {
  return request({
    url: `/campus/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putCompusData(data) {
  return request({
    url: `/campus/update`,
    method: 'put',
    data: data
  })
}
// 基础数据--区域管理
// 获取方法with楼栋
export function getRegionWithBuildings(params) {
  return request({
    url: `/region/getRegionWithBuildings`,
    method: 'get',
    params: params
  })
}
// 获取方法
export function getRegionData(params, roleId) {
  return request({
    url: `/region/getRegionsWithMP/${roleId}`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteRegionData(regionID) {
  return request({
    url: `/region/delete/${regionID}`,
    method: 'delete',
  })
}
// 新增方法
export function postRegionData(data) {
  return request({
    url: `/region/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putRegionData(data) {
  return request({
    url: `/region/modify`,
    method: 'put',
    data: data
  })
}

// 基础数据-楼栋管理
// 获取方法
export function getbuildingDataByID(params, regionID) {
  return request({
    url: `/building/getAllByRegionId/${regionID}`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteBuildingData(buildingID) {
  return request({
    url: `/building/delete/${buildingID}`,
    method: 'delete',
  })
}
// 新增方法
export function postBuildingData(data) {
  return request({
    url: `/building/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putBuildingData(data) {
  return request({
    url: `/building/modify`,
    method: 'put',
    data: data
  })
}

// 基础数据-房屋管理
// 获取方法--可以获取全部的
export function getHouse(params) {
  return request({
    url: `/house/get`,
    method: 'get',
    params: params
  })
}
// 获取方法--根据house的id获取一个house
export function getOneHouseData(houseId) {
  return request({
    url: `/house/get/${houseId}`,
    method: 'get'
  })
}

// 获取方法--根据楼栋id
export function getHouseByBuildingID(params, buildingID) {
  return request({
    url: `/house/getViewHousesByBuildingId/${buildingID}`,
    method: 'get',
    params: params
  })
}
// 获取方法--根据区域id
export function getHouseByRegionID(params, regionId) {
  return request({
    url: `/house/getViewHousesByRegionId/${regionId}`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteHouseData(houseID) {
  return request({
    url: `/house/delete/${houseID}`,
    method: 'delete',
  })
}
// 新增方法
export function postHouseData(data) {
  return request({
    url: `/house/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putHouseData(data) {
  return request({
    url: `/house/modify`,
    method: 'put',
    data: data
  })
}

// 基础数据-职工管理
// 获取方法--获取全部部门带员工信息
export function getDept(params) {
  return request({
    url: `/staff/getDepts`,
    method: 'get',
    params: params
  })
}
// 获取方法--获取单一部门的详细员工信息
export function getSingleDept(params, deptID) {
  return request({
    url: `/staff/get/${deptID}`,
    method: 'get',
    params: params
  })
}
// 获取方法--根据员工id获取单一员工信息
export function getStaff(params, staffID) {
  return request({
    url: `/staff/getByID/${staffID}`,
    method: 'get',
    params: params
  })
}
// 删除方法
export function deleteStaffData(staffID) {
  return request({
    url: `/staff/delete/${staffID}`,
    method: 'delete',
  })
}
// 新增方法
export function postStaffData(data) {
  return request({
    url: `/staff/add`,
    method: 'post',
    data: data
  })
}
// 编辑方法
export function putStaffData(data) {
  return request({
    url: `/staff/modify`,
    method: 'put',
    data: data
  })
}
// 重置密码
export function putResetStaffPwd(data, staffID) {
  return request({
    url: `/staff/resetPassword/${staffID}`,
    method: 'put',
    data: data
  })
}

// 基础数据-房屋登记
// 获取方法--获取职工房屋关系
export function getStaffHouseRel(params, staffID) {
  return request({
    url: `/houseRegister/getStaffHouseRel/${staffID}`,
    method: 'get',
    params: params
  })
}
// 房屋关系解除--不保留历史记录
export function removeResidentLog(staffID) {
  return request({
    url: `/houseRegister/relieveHouseRel/${staffID}`,
    method: 'delete',
  })
}
// 房屋关系解除--不保留历史记录
export function deleteResidentLog(staffID) {
  return request({
    url: `/houseRegister/deleteHouseRel/${staffID}`,
    method: 'delete',
  })
}
// 简单条件获取
export function getHouseByMultiCondition(data) {
  return request({
    url: `/houseRegister/getByMultiCondition`,
    method: 'post',
    data: data
  })
}
// 全面多条件查找
export function postHouseByComplexMultiCondition(params, data) {
  return request({
    url: `/houseRegister/getByAllMultiCondition`,
    method: 'post',
    params: params,
    data: data
  })
}
// 住房登记
export function putHouseRegister(data) {
  return request({
    url: `/houseRegister/register`,
    method: 'put',
    data: data
  })
}

// 数据导入
export function postStaffImport(data) {
  return request({
    url: `/dataImport/staffDataImport`,
    method: 'post',
    data: data
  })
}
export function postHouseImport(data) {
  return request({
    url: `/dataImport/houseDataImport`,
    method: 'post',
    data: data
  })
}
export function postHouseRelImport(data) {
  return request({
    url: `/dataImport/residentDataImport`,
    method: 'post',
    data: data
  })
}
// 根据文件名下载附件
export function downloadFileByFileName(fileName) {
  return request({
    url: '/fileUpload/fileDownLoad',
    method: 'get',
    params: {
      fileName: fileName
    }
  })
}

// 获取某一职工与其所有房子的住房关系的数据
export function getAllHouseRelByStaffId(staffId) {
  return request({
    url: `/houseRegister/getAllResidentDataByStaffId/${staffId}`,
    method: 'get'
  })
}
// 获取某一住房与职工的关系
export function getAllResidentDataByHouseId(houseId) {
  return request({
    url: `/houseRegister/getAllResidentDataByHouseId/${houseId}`,
    method: 'get'
  })
}
