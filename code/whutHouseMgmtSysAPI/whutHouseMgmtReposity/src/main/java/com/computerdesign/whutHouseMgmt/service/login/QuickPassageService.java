package com.computerdesign.whutHouseMgmt.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.login.QuickPassage;
import com.computerdesign.whutHouseMgmt.bean.login.QuickPassageExample;
import com.computerdesign.whutHouseMgmt.bean.login.QuickPassageExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.login.QuickPassageMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年3月29日 下午7:44:05
 * 
 */
@Service
public class QuickPassageService {

	@Autowired
	private QuickPassageMapper quickPassageMapper;
	
	/**
	 * 获取员工的quickPassage
	 * @param staffId
	 * @return
	 */
	public List<QuickPassage> getQuickPassage(Integer staffId) {
		QuickPassageExample example = new QuickPassageExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return quickPassageMapper.selectByExample(example);
	}
	
	public Integer addQuickPassage(QuickPassage quickPassage) {
		return quickPassageMapper.insertSelective(quickPassage);
	}
	
	public Integer updateQuickPassage(QuickPassage quickPassage) {
		return quickPassageMapper.updateByPrimaryKeySelective(quickPassage);
		
	}
}
