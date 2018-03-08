package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.Rent;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentTimeRange;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVw;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
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
	 * 根据租赁开始时间查询租金信息
	 * @param rentTimeRange
	 * @return
	 */
	public List<RentVw> queryRent(RentTimeRange rentTimeRange){
		RentVwExample example = new RentVwExample();
		com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwExample.Criteria criteria = example.createCriteria();
		if(rentTimeRange != null){
			criteria.andRentBeginTimeBetween(rentTimeRange.getStartTime(), rentTimeRange.getEndTime());
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
		if(staffSelectModel.getGoUniversityTimeRange() != null){
			Date startTime = staffSelectModel.getGoUniversityTimeRange().getStartTime();
			Date endTime = staffSelectModel.getGoUniversityTimeRange().getEndTime();
			criteria.andStaffGoUniversityTimeBetween(startTime, endTime);
		}
		
		if(staffSelectModel.getRegionName() != null){
			criteria.andRegionNameEqualTo(staffSelectModel.getRegionName());
		}
		
		criteria.andHouseRelNameEqualTo("租赁");

		return staffHouseMapper.selectByExample(example);
	}
	
}
