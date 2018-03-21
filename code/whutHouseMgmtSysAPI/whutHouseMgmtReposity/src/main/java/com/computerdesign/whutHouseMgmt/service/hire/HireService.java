package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.dao.hire.HireMapper;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;

@Service
public class HireService {

	@Autowired
	private HireMapper hireMapper;

	@Autowired
	private HouseMapper houseMapper;

	@Autowired
	private ResidentMapper residentMapper;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Hire getHireById(Integer id) {
		return hireMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据staffId获取该职工所有相关hire信息
	 * 
	 * @param staffId
	 * @return
	 */
	public List<Hire> getAllByStaffId(Integer staffId) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return hireMapper.selectByExample(example);
	}

	/**
	 * 根据staffId获取hire信息
	 * 
	 * @param staffId
	 * @return
	 */
	public List<Hire> getByStaffId(Integer staffId) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsOverEqualTo(false);
		return hireMapper.selectByExample(example);
	}

	/**
	 * 增加一个Hire
	 * 
	 * @param hire
	 */
	public void add(Hire hire) {
		hireMapper.insertSelective(hire);
	}

	/**
	 * 修改一个Hire
	 * 
	 * @param hire
	 */
	public void update(Hire hire) {
		hireMapper.updateByPrimaryKeySelective(hire);
	}

	/**
	 * 严格的修改一个hire
	 * 
	 * @param hire
	 */
	public void updateStrict(Hire hire) {
		hireMapper.updateByPrimaryKey(hire);
	}

	/**
	 * 根据hireId删除一条hire数据
	 * 
	 * @param hireId
	 */
	public void delete(Integer hireId) {
		hireMapper.deleteByPrimaryKey(hireId);
	}

	/**
	 * 签订合同
	 * 
	 * @param hire
	 */
	public void addSignContract(Hire hire) {

		hireMapper.updateByPrimaryKeySelective(hire);
		House house = houseMapper.selectByPrimaryKey(hire.getHouseId());
		// TODO
		house.setStatus(78);
		houseMapper.updateByPrimaryKeySelective(house);

		// 住房登记信息
		Resident resident = new Resident();
		resident.setBookTime(new Date());
		resident.setStaffId(hire.getStaffId());
		resident.setHouseId(hire.getHouseId());
		resident.setIsDelete(false);

		// 设置ExpireTime时间为两年后
		Calendar bookTime = Calendar.getInstance();
		bookTime.setTime(new Date());
		bookTime.add(Calendar.YEAR, +1);
		Date expireTime = bookTime.getTime();
		resident.setExpireTime(expireTime);

		resident.setRentType("工资");
		// TODO 这里的HouseRel应该是租赁，修改数据库后注意审查
		resident.setHouseRel(78);
		residentMapper.insertSelective(resident);

	}
}
