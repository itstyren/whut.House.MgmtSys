package com.computerdesign.whutHouseMgmt.service.login;
/**
 *
 * @author wanhaoran
 * @date 2018年3月20日 下午4:50:15
 * 
 */

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecordExample;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecordExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.login.LoginRecordMapper;

@Service
public class LoginRecordService {

	@Autowired
	private LoginRecordMapper loginRecordMapper;
	
	/**
	 * 添加登陆信息
	 * @param loginRecord
	 */
	public void addLoginRecord(LoginRecord loginRecord) {
		loginRecordMapper.insertSelective(loginRecord);
	}
	
	/**
	 * 获取全部的登陆信息
	 * @return
	 */
	public List<LoginRecord> getAllLoginRecord() {
		return loginRecordMapper.selectByExample(null);
	}
	
	/**
	 * 获取用户最后一次登录记录
	 * @param staffId
	 * @return
	 */
	public LoginRecord getStaffLoginRecord(Integer staffId) {
		LoginRecordExample example = new LoginRecordExample();
		example.setOrderByClause("LoginTime DESC");
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		List<LoginRecord> list= loginRecordMapper.selectByExample(example);
		if (list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
		
	}
	
	/**
	 * 根据时间获取登陆信息
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public long getLoginRecord(Date startTime,Date endTime) {
		LoginRecordExample example = new LoginRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginTimeBetween(startTime, endTime);
		return loginRecordMapper.countByExample(example);
	}
}
