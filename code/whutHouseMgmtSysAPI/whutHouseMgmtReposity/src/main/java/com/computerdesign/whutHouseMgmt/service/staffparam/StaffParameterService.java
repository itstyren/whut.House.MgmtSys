package com.computerdesign.whutHouseMgmt.service.staffparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSub;
import com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSubExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.staffparam.HouseSubMapper;
import com.computerdesign.whutHouseMgmt.dao.staffparam.StaffParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class StaffParameterService implements BaseService<StaffParameter> {
	
	@Autowired
	private StaffParameterMapper staffParameterMapper;
	
	@Autowired
	private HouseSubMapper houseSubMapper;
	
	/**
	 * 获取所有住房补贴参数
	 * @return
	 */
	public List<HouseSub> getAllHouseSub(){
		HouseSubExample example = new HouseSubExample();
		com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSubExample.Criteria criteria = example.createCriteria();
		return houseSubMapper.selectByExample(example);
	}
	
	/**
	 * 根据id删除一条住房补贴记录
	 * @param id
	 */
	public void deleteHouseSub(Integer id){
		houseSubMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 添加一条住房补贴记录
	 * @param houseSub
	 */
	public void addHouseSub(HouseSub houseSub){
		houseSubMapper.insertSelective(houseSub);
	}
	
	/**
	 * 更新一条住房补贴记录
	 * @param houseSub
	 */
	public void updateHouseSub(HouseSub houseSub){
		houseSubMapper.updateByPrimaryKeySelective(houseSub);
	}
	
	public List<StaffParameter> getAllByParamTypeId(Integer paramTypeId){
		StaffParameterExample example = new StaffParameterExample();
		Criteria criteria= example.createCriteria();
		criteria.andParamTypeIdEqualTo(paramTypeId);
		criteria.andIsDeleteEqualTo(false);
		return staffParameterMapper.selectByExample(example);
	}
	
	/**
	 * 根据staffParamId获取一个职工参数
	 * @return
	 */
	public StaffParameter get(Integer staffParamId){
		return staffParameterMapper.selectByPrimaryKey(staffParamId);
	}

	@Override
	public List<StaffParameter> getAll() {
		List<StaffParameter> empParams = staffParameterMapper.selectByExample(null);
	
		return empParams;
	}

	@Override
	public void delete(Integer staffParamId) {
		staffParameterMapper.deleteByPrimaryKey(staffParamId);
	}

	@Override
	public void add(StaffParameter staffParameter) {
		staffParameterMapper.insertSelective(staffParameter);
	}

	@Override
	public void update(StaffParameter staffParameter) {
		staffParameterMapper.updateByPrimaryKeySelective(staffParameter);
		
	}
	

	/**
	 * 通过staffParamId获取该职称或职务的分数
	 * @param staffParamId
	 * @return
	 */
	public Integer getValByStaffParamId(Integer staffParamId){
		StaffParameterExample example = new StaffParameterExample();
		Criteria criteria= example.createCriteria();
		criteria.andStaffParamIdEqualTo(staffParamId);
		criteria.andIsDeleteEqualTo(false);
		return staffParameterMapper.selectByPrimaryKey(staffParamId).getStaffParamVal();
	}

}
