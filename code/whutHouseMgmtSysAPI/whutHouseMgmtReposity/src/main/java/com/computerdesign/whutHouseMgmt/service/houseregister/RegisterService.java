package com.computerdesign.whutHouseMgmt.service.houseregister;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistory;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistoryExample;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameterExample;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.house.HouseMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentHistoryMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentVwMapper;
import com.computerdesign.whutHouseMgmt.dao.param.houseparam.HouseParameterMapper;

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
	
	@Autowired
	private ResidentHistoryMapper residentHistoryMapper;
	
	@Autowired
	private ResidentVwMapper residentVwMapper;
	
	/**
	 * 根据staffId获取全部的resident
	 * @param staffId
	 * @return
	 */
	public List<Resident> getResidentsByStaffId(Integer staffId) {
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsDeleteEqualTo(false);
		return residentMapper.selectByExample(example);
	}

	
	/**
	 * 删除住房登记历史记录
	 * @param residentId
	 */
	public void deleteResidentHistory(Integer residentId){
		//删除住房登记历史记录
		ResidentHistoryExample example = new ResidentHistoryExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistoryExample.Criteria criteria = example.createCriteria();
		criteria.andResidentIdEqualTo(residentId);
		residentHistoryMapper.deleteByExample(example);
	}
	
	/**
	 * 删除住房记录，即设置isDelete字段为1
	 * @param resident
	 */
	public void deleteResident(Resident resident){
		residentMapper.updateByPrimaryKey(resident);
	}
	public Resident getResident(Integer residentId){
		return residentMapper.selectByPrimaryKey(residentId);
	}
	
	/**
	 * 根据所有条件定位到某一个resident记录，
	 * 用于获取hs_resident数据库自增生成的主键，方便residentHistory的residentId对应
	 * @param resident
	 * @return
	 */
	public Resident getByAllField(Resident resident){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(resident.getStaffId());
		criteria.andHouseIdEqualTo(resident.getHouseId());
		criteria.andHouseRelEqualTo(resident.getHouseRel());
		criteria.andBookTimeEqualTo(resident.getBookTime());
		criteria.andIsDeleteEqualTo(resident.getIsDelete());
		if(resident.getRentType() != null){			
			criteria.andRentTypeEqualTo(resident.getRentType());
		}
		criteria.andFamilyCodeEqualTo(resident.getFamilyCode());
		return residentMapper.selectByExample(example).get(0); 
	}
	
	/**
	 * 使用hs_resident,根据houseId获取该房屋的所有居民，用于住房登记，判断是否重复登记
	 * @param houseId
	 * @return
	 */
	public List<Resident> getResidentByHouseId(Integer houseId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andHouseIdEqualTo(houseId);
		return residentMapper.selectByExample(example); 
	}
	
	/**
	 * 使用view_hs_resident,根据houseId获取该房屋的所有居民，用于住房登记，当住房已有人登记时显示提示信息
	 * @param houseId
	 * @return
	 */
	public List<ResidentVw> getResidentVwByHouseId(Integer houseId){
		ResidentVwExample example = new ResidentVwExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample.Criteria criteria = example.createCriteria();
		criteria.andHouseIdEqualTo(houseId);
		return residentVwMapper.selectByExample(example);
	}
	
	/**
	 * XieHao新增
	 * 使用view_hs_resident,根据staffId获取信息,判断该员工是否已租赁住房
	 * @param staffId
	 * @return
	 * 2018.08.13
	 */
	public boolean isRentByStaffId(Integer staffId) {
		ResidentVwExample example = new ResidentVwExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andHouseRelEqualTo("租赁");
		criteria.andIsDeleteEqualTo(false);
		if(residentVwMapper.selectByExample(example)!= null && residentVwMapper.selectByExample(example).size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * R新增
	 * 使用view_hs_resident,根据staffId获取信息
	 * @param staffId
	 * @return
	 */
	public List<ResidentVw> getResidentVwByStaffId(Integer staffId) {
		ResidentVwExample example = new ResidentVwExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		criteria.andIsDeleteEqualTo(false);
		return residentVwMapper.selectByExample(example);
	}
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
	 * 插入登记历史
	 */
	public void registerHistory(ResidentHistory residentHistory){
		residentHistoryMapper.insertSelective(residentHistory);
	}
	
	/**
	 * 根据houseId查找记录数，用于确认住房是否已有人入住
	 * @param houseId
	 * @return
	 */
	public long getCountByHouseId(Integer houseId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andHouseIdEqualTo(houseId);
		return residentMapper.countByExample(example);
	}
	
	/**
	 * 根据staffId查找记录数，用于判断该职工是否已有房登记过
	 * @param staffId
	 * @return
	 */
	public long getCountByStaffId(Integer staffId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		return residentMapper.countByExample(example);
	}
	
	/**
	 * 根据房屋租赁的情况登记住房
	 * @author wanhaoran
	 * @param hire
	 */
	public void registerByHire(Hire hire) {
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
	
	/**
	 * 获取数据库记录数，方便id自增
	 * @return
	 */
//	public int getCount(){
//		ResidentExample example = new ResidentExample();
//		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
//		return residentMapper.selectByExample(example).size();
//	}
	
}
