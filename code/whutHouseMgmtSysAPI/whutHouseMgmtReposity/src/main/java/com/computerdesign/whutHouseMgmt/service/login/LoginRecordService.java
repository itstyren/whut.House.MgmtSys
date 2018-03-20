package com.computerdesign.whutHouseMgmt.service.login;
/**
 *
 * @author wanhaoran
 * @date 2018年3月20日 下午4:50:15
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.dao.login.LoginRecordMapper;

@Service
public class LoginRecordService {

	@Autowired
	private LoginRecordMapper loginRecordMapper;
	
	
	public void addLoginRecord(LoginRecord loginRecord) {
		loginRecordMapper.insertSelective(loginRecord);
	}
	
	public List<LoginRecord> getAllLoginRecord() {
		return loginRecordMapper.selectByExample(null);
	}
}
