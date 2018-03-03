package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HireRecent;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HireRecentExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HireRecentExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.HireRecentMapper;

/**
 * 对自助选房模块已选房职工及房子视图（HireRecent）操作
 * @author Administrator
 *
 */
@Service
public class HireRecentService {
	
	@Autowired
	private HireRecentMapper hireRecentMapper;
	
	/**
	 * 获取所有已选房职工及房子信息
	 * @return
	 */
	public List<HireRecent> getAll(){
		HireRecentExample example = new HireRecentExample();
		Criteria criteria = example.createCriteria();
		return hireRecentMapper.selectByExample(example);
	}
	
}
