package com.computerdesign.whutHouseMgmt.service.campus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.campus.Campus;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.campus.CampusExample;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.campus.CampusExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.campus.CampusMapper;

/**
 *
 * @author wanhaoran
 * @date 2018年4月1日 下午5:15:07
 * 
 */
@Service
public class CampusService {

	@Autowired
	private CampusMapper campusMapper;
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	public Campus getById(Integer id) {
		return campusMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取全部的campus
	 * @return
	 */
	public List<Campus> getAll() {
		return campusMapper.selectByExample(null);
	}
	
	/**
	 * 增加一个campus
	 * @param campus
	 * @return
	 */
	public int add(Campus campus) {
		return campusMapper.insertSelective(campus);
	}
	
	/**
	 * 根据名字获取数量
	 * @param name
	 * @return
	 */
	public Long countByName(String name) {
		CampusExample campusExample = new CampusExample();
		Criteria criteria = campusExample.createCriteria();
		criteria.andNameEqualTo(name);
		return campusMapper.countByExample(campusExample);
	}
	
	/**
	 * 修改一个校区
	 * @param campus
	 * @return
	 */
	public int update(Campus campus) {
		return campusMapper.updateByPrimaryKeySelective(campus);
	}
	
	/**
	 * 根据id删除一个校区
	 * @param id
	 * @return
	 */
	public int delete(Integer id) {
		return campusMapper.deleteByPrimaryKey(id);
	}
}
