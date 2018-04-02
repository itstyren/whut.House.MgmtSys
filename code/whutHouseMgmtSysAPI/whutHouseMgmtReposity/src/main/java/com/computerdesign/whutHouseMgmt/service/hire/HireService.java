package com.computerdesign.whutHouseMgmt.service.hire;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample;
import com.computerdesign.whutHouseMgmt.bean.hire.common.HireExample.Criteria;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
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

	/**
	 * 获取全部待处理的租赁信息的数目
	 * 
	 * @return
	 */
	public Long getCountToHandle() {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andApproveStateIsNull();
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内受理拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasAcceptRefused(Date startTime, Date endTime) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andAcceptStateEqualTo("拒绝");
		criteria.andAcceptTimeBetween(startTime, endTime);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内受理拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasAcceptRefused(Date time) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andAcceptStateEqualTo("拒绝");
		criteria.andAcceptTimeEqualTo(time);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内审核拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasAgreeRefused(Date startTime, Date endTime) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andAgreeStateEqualTo("拒绝");
		criteria.andAgreeTimeBetween(startTime, endTime);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内审核拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasAgreeRefused(Date time) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andAgreeStateEqualTo("拒绝");
		criteria.andAgreeTimeEqualTo(time);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内审批拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasApproveRefused(Date startTime, Date endTime) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andApproveStateEqualTo("拒绝");
		criteria.andApproveTimeBetween(startTime, endTime);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期内审批拒绝的数量
	 * 
	 * @param date
	 * @return
	 */
	public Long getCountHasApproveRefused(Date time) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andApproveStateEqualTo("拒绝");
		criteria.andApproveTimeEqualTo(time);
		criteria.andIsOverEqualTo(false);
		return hireMapper.countByExample(example);
	}

	/**
	 * 返回指定日期内所有类型拒绝的租信息
	 * @param time
	 * @return
	 */
	public Long getTotalCountRefuse(Date time) {
		HireExample acceptExample = new HireExample();
		Criteria acceptCriteria = acceptExample.createCriteria();
		acceptCriteria.andApproveStateEqualTo("拒绝");
		acceptCriteria.andApproveTimeEqualTo(time);
		acceptCriteria.andIsOverEqualTo(false);
		hireMapper.countByExample(acceptExample);
		
		HireExample agreeExample = new HireExample();
		Criteria agreeCriteria = agreeExample.createCriteria();
		agreeCriteria.andApproveStateEqualTo("拒绝");
		agreeCriteria.andApproveTimeEqualTo(time);
		agreeCriteria.andIsOverEqualTo(false);
		hireMapper.countByExample(agreeExample);
		
		HireExample approveExample = new HireExample();
		Criteria approveCriteria = approveExample.createCriteria();
		approveCriteria.andApproveStateEqualTo("拒绝");
		approveCriteria.andApproveTimeEqualTo(time);
		approveCriteria.andIsOverEqualTo(false);
		hireMapper.countByExample(approveExample);
		
		return hireMapper.countByExample(acceptExample)+hireMapper.countByExample(agreeExample)+hireMapper.countByExample(approveExample);
		
		
	}
	
	/**
	 * 给定日期审批成功的数量
	 * 
	 * @param time
	 * @return
	 */
	public Long getCountHasBeenApprove(Date time) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andApproveTimeEqualTo(time);
		criteria.andHireStateEqualTo("已审批");
		return hireMapper.countByExample(example);
	}

	/**
	 * 给定日期申请的数量
	 * @param time
	 * @return
	 */
	public Long getCountApply(Date time) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyTimeEqualTo(time);
		return hireMapper.countByExample(example);
	}
	
	/**
	 * 获取全部待签订合同的租赁信息的数目
	 * 
	 * @return
	 */
	public Long getCountToSign() {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		criteria.andHireStateEqualTo("已审批");
		return hireMapper.countByExample(example);
	}

	/**
	 * 查看租赁信息中该houseId的有几套房子
	 * 
	 * @param houseId
	 * @return
	 */
	public Long getCountByHouseId(Integer houseId) {
		HireExample example = new HireExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsOverEqualTo(false);
		criteria.andHouseIdEqualTo(houseId);
		return hireMapper.countByExample(example);
	}
}
