package com.computerdesign.whutHouseMgmt.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.login.WXLogin;
import com.computerdesign.whutHouseMgmt.dao.login.WXLoginMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年5月30日 下午11:54:59
 * 
 */
@Service
public class WXService {

	@Autowired
	private WXLoginMapper wxLoginMapper;
	
	public WXLogin get() {
		return wxLoginMapper.selectByExample(null).get(0);
	}
}
