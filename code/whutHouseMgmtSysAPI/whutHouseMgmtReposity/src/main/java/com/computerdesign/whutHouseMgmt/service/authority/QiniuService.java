package com.computerdesign.whutHouseMgmt.service.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.authority.Qiniu;
import com.computerdesign.whutHouseMgmt.dao.authority.QiniuMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年3月29日 下午10:39:59
 * 
 */
@Service
public class QiniuService {

	@Autowired
	private QiniuMapper qiniuMapper;
	
	public Qiniu get() {
		return qiniuMapper.selectByExample(null).get(0);
	}
}
