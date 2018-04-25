package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.Rent;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentExample;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentTimeRange;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVw;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.hire.RentMapper;
import com.computerdesign.whutHouseMgmt.dao.hire.RentVwMapper;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.StaffHouseMapper;

@Service
public class RentGenerateService {

	@Autowired
	private StaffHouseMapper staffHouseMapper;
	
	@Autowired
	private RentMapper rentMapper;
	
	@Autowired
	private RentVwMapper rentVwMapper;
	
	/**
	 * 获取所有租赁信息
	 * @return
	 */
	public List<Rent> getAllRent(){
		RentExample example = new RentExample();
		com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentExample.Criteria criteria = example.createCriteria();
		return rentMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工号或职工姓名模糊查找
	 * 
	 * @param conditionName
	 * @param conditionValue
	 * @return
	 */
	public List<StaffHouse> selectByNoOrName(String conditionValue) {
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		try {
			int test = Integer.parseInt(conditionValue);
			criteria.andStaffNoLike("%" + conditionValue + "%");
		} catch (NumberFormatException e) {
			criteria.andStaffNameLike("%" + conditionValue + "%");
		}
		criteria.andHouseRelNameEqualTo("租赁");
		
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 根据租赁开始时间查询租金信息
	 * @param rentTimeRange
	 * @return
	 */
	public List<RentVw> queryRent(RentTimeRange rentTimeRange){
		RentVwExample example = new RentVwExample();
		com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwExample.Criteria criteria = example.createCriteria();
		if(rentTimeRange != null){
			if(rentTimeRange.getStartTime() != null){
				//开始时间和结束时间均不为空，则查询包含在该时间范围内的数据
				if(rentTimeRange.getEndTime() != null){					
					criteria.andRentBeginTimeBetween(rentTimeRange.getStartTime(), rentTimeRange.getEndTime());
				}else{
					//开始时间不为空，结束时间为空，则查询至开始时间以后的数据
					criteria.andRentBeginTimeGreaterThanOrEqualTo(rentTimeRange.getStartTime());
				}
			}
		}
		return rentVwMapper.selectByExample(example);
	}
	
	/**
	 * 租金生成
	 * @param rent
	 */
	public void rentGenerate(Rent rent){
		rentMapper.insertSelective(rent);
	}
	
	/**
	 * 根据HouseId查询StaffHouse视图中数据
	 * @param houseId
	 * @return
	 */
	public StaffHouse getByHouseId(Integer houseId){
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andHouseIdEqualTo(houseId);
		if(staffHouseMapper.selectByExample(example).size() > 0){
			return staffHouseMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 根据HouseNo查询StaffHouse视图中数据
	 * @param houseNo
	 * @return
	 */
	public StaffHouse getByHouseNo(String houseNo){
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andHouseNoEqualTo(houseNo);
		if(staffHouseMapper.selectByExample(example).size() > 0){
			return staffHouseMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 多条件查询
	 * 
	 * @return
	 */
	public List<StaffHouse> selectRentByMultiCondition(StaffSelectModel staffSelectModel) {
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		//部门
		if (staffSelectModel.getDept() != null) {
			criteria.andStaffDeptNameEqualTo(staffSelectModel.getDept());
		}

		//职务
		if (staffSelectModel.getPost() != null) {
			criteria.andStaffPostNameEqualTo(staffSelectModel.getPost());
		}

		//职称
		if (staffSelectModel.getTitle() != null) {
			criteria.andStaffTitleNameEqualTo(staffSelectModel.getTitle());
		}

		//职工类别
		if (staffSelectModel.getType() != null) {
			criteria.andStaffTypeNameEqualTo(staffSelectModel.getType());
		}

		//工作状态
		if (staffSelectModel.getStatus() != null) {
			criteria.andStaffStatusNameEqualTo(staffSelectModel.getStatus());
		}

		//住房类型
		if(staffSelectModel.getHouseTypeName() != null){
			criteria.andHouseTypeNameEqualTo(staffSelectModel.getHouseTypeName());
		}
		
		//婚姻状况
		if (staffSelectModel.getMarriageState() != null) {
			criteria.andStaffMarriageStateEqualTo(staffSelectModel.getMarriageState());
		}

		//性别
		if (staffSelectModel.getSex() != null) {
			criteria.andStaffSexEqualTo(staffSelectModel.getSex());
		}
		
		//是否到期
		if(staffSelectModel.getIsExpire() != null){
			System.out.println(staffSelectModel.getIsExpire());
			if(staffSelectModel.getIsExpire()){
				System.out.println(new Date());
				criteria.andExpireTimeLessThanOrEqualTo(new Date());
			}else{
				criteria.andExpireTimeGreaterThan(new Date());				
			}
		}

		//参加工作时间
		if (staffSelectModel.getJoinTime() != null) {
			Date startTime = staffSelectModel.getJoinTime().getStartTime();
			Date endTime = staffSelectModel.getJoinTime().getEndTime();
			criteria.andStaffJoinTimeBetween(startTime, endTime);
		}
		
		//上大学时间
//		if(staffSelectModel.getGoUniversityTimeRange() != null){
//			Date startTime = staffSelectModel.getGoUniversityTimeRange().getStartTime();
//			Date endTime = staffSelectModel.getGoUniversityTimeRange().getEndTime();
//			criteria.andStaffGoUniversityTimeBetween(startTime, endTime);
//		}
		
		if(staffSelectModel.getRegionName() != null){
			criteria.andRegionNameEqualTo(staffSelectModel.getRegionName());
		}
		
		criteria.andHouseRelNameEqualTo("租赁");

		return staffHouseMapper.selectByExample(example);
	}
	
}
