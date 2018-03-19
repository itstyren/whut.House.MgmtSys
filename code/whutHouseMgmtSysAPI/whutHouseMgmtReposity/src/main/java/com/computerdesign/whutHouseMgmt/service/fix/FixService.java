package com.computerdesign.whutHouseMgmt.service.fix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.fix.common.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.common.FixExample;
import com.computerdesign.whutHouseMgmt.bean.fix.common.FixExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.dao.fix.FixMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;

@Service
public class FixService {

	@Autowired
	private FixMapper fixMapper;
	@Autowired
	private ResidentMapper residentMapper;
	

	/**
	 * 根据id获取一个fix
	 * @param id
	 * @return
	 */
	public Fix get(Integer id) {
		return fixMapper.selectByPrimaryKey(id);
	}
	/**
	 * 增加一个fix
	 * @param fix
	 */
	public void add(Fix fix) {
		fixMapper.insertSelective(fix);
	}
	
	/**
	 * 通过PrimaryKey修改
	 * @param fix
	 */
	public void update(Fix fix){
		fixMapper.updateByPrimaryKeySelective(fix);
	}
	
	public void updateStrict(Fix fix){
		fixMapper.updateByPrimaryKey(fix);
	}
	
	/**
	 * 通过员工id查询指定员工维修信息
	 * @param staffId
	 * @return
	 */
	public List<Fix> getByStaffId(Integer staffId){
		FixExample example = new FixExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return fixMapper.selectByExample(example);
	}
	
	
	public void getResident(String staffId) {
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		//等待谢豪修改数据库
		
		residentMapper.selectByExample(example);
	}
}
