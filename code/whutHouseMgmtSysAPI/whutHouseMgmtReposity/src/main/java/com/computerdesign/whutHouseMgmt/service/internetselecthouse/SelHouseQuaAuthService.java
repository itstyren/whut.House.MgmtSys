package com.computerdesign.whutHouseMgmt.service.internetselecthouse;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectModel;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.dao.internetselecthouse.StaffHouseMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffVwMapper;

@Service
public class SelHouseQuaAuthService {
	
	@Autowired
	private StaffVwMapper staffVwMapper;
	
	@Autowired
	private StaffHouseMapper staffHouseMapper;
	
	@Autowired
	private StaffMapper staffMapper;

	/**
	 * 根据职工号和职工姓名模糊查找
	 * @param conditionName
	 * @param conditionValue
	 * @return
	 */
	public List<StaffHouse> selectByNoOrName(String conditionName, String conditionValue){
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		if(conditionName.equals("职工号")){
			criteria.andStaffNoLike(conditionValue);
		}else if(conditionName.equals("职工姓名")){
			criteria.andStaffNameLike(conditionValue);
		}
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 初始显示未设置选房职工
	 * @return
	 */
	public List<StaffHouse> activeShow(){
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffRelationEqualTo("active");
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 初始显示已设置选房职工
	 * @return
	 */
	public List<StaffHouse> canselectShow(){
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffRelationEqualTo("canselect");
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 多条件查询未设置选房资格的职工，用于选房资格认定
	 * @return
	 */
	public List<StaffHouse> selectActiveStaffMultiCondition(StaffSelectModel staffSelectModel){
//		StaffVwExample example = new StaffVwExample();
//		Criteria criteria = example.createCriteria();
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		if(staffSelectModel.getDept() != null){
			criteria.andStaffDeptNameEqualTo(staffSelectModel.getDept());
		}
		
		if(staffSelectModel.getPost() != null){
			criteria.andStaffPostNameEqualTo(staffSelectModel.getPost());
		}
		
		if(staffSelectModel.getTitle() != null){
			criteria.andStaffTitleNameEqualTo(staffSelectModel.getTitle());
		}
		
		if(staffSelectModel.getType() != null){
			criteria.andStaffTypeNameEqualTo(staffSelectModel.getType());
		}
		
		if(staffSelectModel.getStatus() != null){
			criteria.andStaffStatusNameEqualTo(staffSelectModel.getStatus());
		}
		
		if(staffSelectModel.getMarriageState() != null){
			criteria.andStaffMarriageStateEqualTo(staffSelectModel.getMarriageState());
		}
		
		if(staffSelectModel.getJoinTime() != null){
			Date startTime = staffSelectModel.getJoinTime().getStartTime();
			Date endTime = staffSelectModel.getJoinTime().getEndTime();
			criteria.andStaffJoinTimeBetween(startTime, endTime);
		}
		
		if(staffSelectModel.getSex() != null){
			criteria.andStaffSexEqualTo(staffSelectModel.getSex());
		}
		
		criteria.andStaffRelationEqualTo("active");
		
		return staffHouseMapper.selectByExample(example);
	}
	
	/**
	 * 多条件查询已设置选房资格的职工，用于选房资格认定
	 * @return
	 */
	public List<StaffHouse> selectCanselectStaffMultiCondition(StaffSelectModel staffSelectModel){
//		StaffVwExample example = new StaffVwExample();
//		Criteria criteria = example.createCriteria();
		StaffHouseExample example = new StaffHouseExample();
		Criteria criteria = example.createCriteria();
		if(staffSelectModel.getDept() != null){
			criteria.andStaffDeptNameEqualTo(staffSelectModel.getDept());
		}
		
		if(staffSelectModel.getPost() != null){
			criteria.andStaffPostNameEqualTo(staffSelectModel.getPost());
		}
		
		if(staffSelectModel.getTitle() != null){
			criteria.andStaffTitleNameEqualTo(staffSelectModel.getTitle());
		}
		
		if(staffSelectModel.getType() != null){
			criteria.andStaffTypeNameEqualTo(staffSelectModel.getType());
		}
		
		if(staffSelectModel.getStatus() != null){
			criteria.andStaffStatusNameEqualTo(staffSelectModel.getStatus());
		}
		
		if(staffSelectModel.getMarriageState() != null){
			criteria.andStaffMarriageStateEqualTo(staffSelectModel.getMarriageState());
		}
		
		if(staffSelectModel.getJoinTime() != null){
			Date startTime = staffSelectModel.getJoinTime().getStartTime();
			Date endTime = staffSelectModel.getJoinTime().getEndTime();
			criteria.andStaffJoinTimeBetween(startTime, endTime);
		}
		
		if(staffSelectModel.getSex() != null){
			criteria.andStaffSexEqualTo(staffSelectModel.getSex());
		}
		
		criteria.andStaffRelationEqualTo("canselect");
		
		return staffHouseMapper.selectByExample(example);
	}
	
}
