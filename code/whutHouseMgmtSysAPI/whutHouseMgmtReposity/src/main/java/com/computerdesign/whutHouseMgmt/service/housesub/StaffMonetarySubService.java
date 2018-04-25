package com.computerdesign.whutHouseMgmt.service.housesub;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySubExample;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySubExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample;
import com.computerdesign.whutHouseMgmt.dao.houseregister.ResidentMapper;
import com.computerdesign.whutHouseMgmt.dao.housesub.MonetarySubVwMapper;
import com.computerdesign.whutHouseMgmt.dao.housesub.StaffMonetarySubMapper;
import com.computerdesign.whutHouseMgmt.dao.staffmanagement.StaffMapper;

/**
 * 货币化补贴Service
 * @author Administrator
 *
 */
@Service
public class StaffMonetarySubService {
	
	@Autowired
	private StaffMonetarySubMapper staffMonetarySubMapper;
	
	@Autowired
	private ResidentMapper residentMapper;
	
	@Autowired
	private StaffMapper staffMapper;
	
	@Autowired
	private MonetarySubVwMapper monetarySubVwMapper;
	
//	public boolean isOldStaff(Integer staffId){
//		StaffExample example = new StaffExample();
//		com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffExample.Criteria criteria = example.createCriteria();
//		criteria.andIdEqualTo(staffId);
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(1999, 0, 1, 0, 0, 0);
//		criteria.andJoinTimeLessThan(calendar.getTime());
//		System.out.println(calendar.getTime());
//		return false;
//	}
	
	/**
	 * 根据职工编号和年份更新对应的补贴记录
	 * @param staffMonetarySub
	 * @param staffNo
	 * @param year
	 */
	public void updateStaffMonetarySubByStaffNoAndYear(StaffMonetarySub staffMonetarySub, String staffNo, String year){
		StaffMonetarySubExample example = new StaffMonetarySubExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
		criteria.andYearEqualTo(year);
		staffMonetarySubMapper.updateByExampleSelective(staffMonetarySub, example);
	}
	
	/**
	 * 通过职工编号和年份获取货币化补贴数据，用于导入重复验证
	 * @param staffNo
	 * @param year
	 * @return
	 */
	public List<StaffMonetarySub> getStaffMonetarySubByStaffNoAndYear(String staffNo, String year){
		StaffMonetarySubExample example = new StaffMonetarySubExample();
		Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
		criteria.andYearEqualTo(year);
		return staffMonetarySubMapper.selectByExample(example);
	}
	
	/**
	 * 判断是否是无房职工
	 * @param staffId
	 * @return
	 */
	public boolean isOwnHouse(Integer staffId){
		ResidentExample example = new ResidentExample();
		com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample.Criteria criteria = example.createCriteria();
		criteria.andStaffIdEqualTo(staffId);
		List<Integer> params = new ArrayList<Integer>();
		//购买
		params.add(26);
		//租赁
		params.add(78);
		//房屋是购买的或租赁的
		criteria.andHouseRelIn(params);
		criteria.andIsDeleteEqualTo(false);
		if(residentMapper.selectByExample(example).size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取所有补贴记录
	 * @return
	 */
	public List<MonetarySubVw> getAllMonetarySub(){
//		StaffMonetarySubExample example = new StaffMonetarySubExample();
//		Criteria criteria = example.createCriteria();
//		return staffMonetarySubMapper.selectByExample(example);
		MonetarySubVwExample example = new MonetarySubVwExample();
		com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample.Criteria criteria = example.createCriteria();
		return monetarySubVwMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工编号获取其所有补贴记录
	 * @param staffNo
	 * @return
	 */
	public List<MonetarySubVw> getMonetarySubByStaffNo(String staffNo){
//		StaffMonetarySubExample example = new StaffMonetarySubExample();
//		Criteria criteria = example.createCriteria();
//		criteria.andStaffNoEqualTo(staffNo);
//		return staffMonetarySubMapper.selectByExample(example);
		MonetarySubVwExample example = new MonetarySubVwExample();
		com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample.Criteria criteria = example.createCriteria();
		criteria.andStaffNoEqualTo(staffNo);
		return monetarySubVwMapper.selectByExample(example);
	}
	
	/**
	 * 根据ID删除一条补贴记录
	 * @param id
	 */
	public void delete(Integer id){
		staffMonetarySubMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 添加一条补贴记录
	 * @param staffMonetarySub
	 */
	public void add(StaffMonetarySub staffMonetarySub){
		staffMonetarySubMapper.insertSelective(staffMonetarySub);
	}
	
}
