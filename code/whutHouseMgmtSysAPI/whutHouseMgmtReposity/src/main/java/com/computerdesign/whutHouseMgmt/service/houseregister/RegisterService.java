package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameterExample;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentModel;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseparam.HouseParameterMapper;
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

	@Autowired
	private HouseParameterMapper houseParameterMapper;
	
	/**
	 * 登记关系设置，提交修改的登记关系
	 * @return
	 */
	public void updateRegisterRel(HouseParameter houseParameter){
		houseParameterMapper.updateByPrimaryKeySelective(houseParameter);
	}
	
	/**
	 * 登记关系设置，获取所有登记关系，使用pm_housetype表，paramTypeId为1
	 * @return
	 */
	public List<HouseParameter> getRegisterRel(){
		HouseParameterExample example = new HouseParameterExample();
		Criteria criteria = example.createCriteria();
		criteria.andParamTypeIdEqualTo(1);
		criteria.andIsDeleteEqualTo(false);
		return houseParameterMapper.selectByExample(example);
	}
	
	/**
	 * 住房登记
	 * @param resident
	 */
	public void register(Resident resident){
		residentMapper.insertSelective(resident);
	}
	
	/**
	 * 获取数据库记录数，方便id自增
	 * @return
	 */
	public int getCount(){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		return residentMapper.selectByExample(example).size();
	}
	
}
