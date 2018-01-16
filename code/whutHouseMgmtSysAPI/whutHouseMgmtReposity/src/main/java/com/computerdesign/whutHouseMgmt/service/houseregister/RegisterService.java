package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentModel;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;

/**
 * 住房登记，使用hs_resident表
 * @author Administrator
 *
 */
@Service
public class RegisterService{

	@Autowired
	private ResidentMapper residentMapper;

	public void register(Resident resident){
		residentMapper.insertSelective(resident);
	}
	
	/**
	 * 获取数据库记录数，方便id自增
	 * @return
	 */
	public int getCount(){
		ResidentExample example = new ResidentExample();
		Criteria criteria = example.createCriteria();
		return residentMapper.selectByExample(example).size();
	}
	
}
