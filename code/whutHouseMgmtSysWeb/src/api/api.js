import axios from 'axios'

let base = 'http://localhost:8787/whutHouseMgmtReposity/'

// 参数设置--职工参数
//
export const getStaffDept = params => { return axios.get(`${base}getEmployeeParameter/5`, { params: params }) }
