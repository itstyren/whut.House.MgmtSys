package com.computerdesign.whutHouseMgmt.service.param.emailparam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.param.emailParam.EmailParameter;
import com.computerdesign.whutHouseMgmt.dao.param.emailParam.EmailParameterMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年4月8日 上午10:37:19
 * 
 */
@Service
public class EmailParameterService {

	@Autowired
	private EmailParameterMapper emailParameterMapper;
	
	public EmailParameter get() {
		
		return emailParameterMapper.selectByExample(null).get(0);
	}
}
