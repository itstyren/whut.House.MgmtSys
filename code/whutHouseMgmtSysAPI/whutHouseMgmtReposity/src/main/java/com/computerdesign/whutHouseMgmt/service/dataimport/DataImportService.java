package com.computerdesign.whutHouseMgmt.service.dataimport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.Building;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.building.BuildingExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameterExample;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.building.BuildingMapper;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;
import com.computerdesign.whutHouseMgmt.dao.param.houseparam.HouseParameterMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;
import com.computerdesign.whutHouseMgmt.dao.staffparam.StaffParameterMapper;

@Service
public class DataImportService {

	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private StaffParameterMapper staffParameterMapper;
	
	@Autowired
	private HouseParameterMapper houseParameterMapper;
	
	@Autowired
	private BuildingMapper buildingMapper;
	
	@Autowired
	private HouseMapper houseMapper;
	
	@Autowired
	private ResidentMapper residentMapper;
	
	/**
	 * 保存住房数据
	 * @param house
	 */
	public void insertHouse(House house){
		houseMapper.insertSelective(house);
	}
	
	/**
	 * 根据楼栋名称获取楼栋id(Excel表中传入名称，数据库存入id)
	 * @param buildingParamName
	 * @return
	 */
	public Integer getBuildingParamId(String buildingParamName){
		BuildingExample example = new BuildingExample();
		com.computerdesign.whutHouseMgmt.bean.houseManagement.building.BuildingExample.Criteria criteria= example.createCriteria();
		criteria.andNameEqualTo(buildingParamName);
		Building building = buildingMapper.selectByExample(example).get(0);
		return building.getId();
	}
	
	/**
	 * 根据住房参数名称获取住房参数id(Excel表中传入名称，数据库存入id)
	 * @param houseParamName
	 * @return
	 */
	public Integer getHouseParamId(String houseParamName){
		HouseParameterExample example = new HouseParameterExample();
		com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameterExample.Criteria criteria= example.createCriteria();
		criteria.andHouseParamNameEqualTo(houseParamName);
		criteria.andIsDeleteEqualTo(false);
		HouseParameter houseParameter = houseParameterMapper.selectByExample(example).get(0);
		return houseParameter.getHouseParamId();
	}
	
	/**
	 * 根据职工参数名称获取职工参数id(Excel表中传入名称，数据库存入id)
	 * @param staffParamName
	 * @return
	 */
	public Integer getStaffParamId(String staffParamName,Integer paramTypeId){
		StaffParameterExample example = new StaffParameterExample();
		Criteria criteria= example.createCriteria();
		criteria.andStaffParamNameEqualTo(staffParamName);
		criteria.andParamTypeIdEqualTo(paramTypeId);
		criteria.andIsDeleteEqualTo(false);
		StaffParameter staffParameter = staffParameterMapper.selectByExample(example).get(0);
		return staffParameter.getStaffParamId();
	}
	
//	//批量插入
//	public void batchInsertStaff(List<Staff> list){
//		staffMapper.batchInsertSelective(list);
//	}
	
	public void insertStaff(Staff staff){
		staffMapper.insertSelective(staff);
	}
	
	public void updateStaff(Staff staff, String no){
		StaffExample example = new StaffExample();
		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		staffMapper.updateByExampleSelective(staff,example);
	}
	
	public void insertResident(Resident resident){
		residentMapper.insertSelective(resident);
	}
	
	/**
	 * 根据staffId和houseId获取Resident对象
	 * @param staffId
	 * @param houseId
	 * @return
	 */
	public List<Resident> getResidentByStaffIdAndHouseId(Integer staffId, Integer houseId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andHouseIdEqualTo(houseId);
		return residentMapper.selectByExample(example);
	}
	
	/**
	 * 根据staffId和houseId更新Resident对象
	 * @param resident
	 * @param staffId
	 * @param houseId
	 */
	public void updateResidentByStaffIdAndHouseId(Resident resident, Integer staffId, Integer houseId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andHouseIdEqualTo(houseId);
		residentMapper.updateByExampleSelective(resident, example);
	}
	
}
