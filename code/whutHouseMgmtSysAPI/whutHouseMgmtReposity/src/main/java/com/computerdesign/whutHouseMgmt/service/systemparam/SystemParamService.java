package com.computerdesign.whutHouseMgmt.service.systemparam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.param.systemParam.SystemParameter;
import com.computerdesign.whutHouseMgmt.dao.param.systemParam.SystemParameterMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年4月5日 下午5:41:31
 * 
 */
@Service
public class SystemParamService {

	@Autowired
	private SystemParameterMapper systemParameterMapper;
	
	/**
	 * 获取系统参数
	 * @return
	 */
	public SystemParameter get(Integer sysParamId) {
		return systemParameterMapper.selectByPrimaryKey(sysParamId);
	}
	
	/**
	 * 增加一个系统参数
	 * @param systemParameter
	 * @return
	 */
	public int add(SystemParameter systemParameter) {
		return systemParameterMapper.insertSelective(systemParameter);		
	}
	
	/**
	 * 修改系统参数
	 * @param systemParameter
	 * @return
	 */
	public int update(SystemParameter systemParameter) {
		return systemParameterMapper.updateByPrimaryKeySelective(systemParameter);
	}
}
