package com.computerdesign.whutHouseMgmt.service.rentalparam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameter;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameterExample;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameterExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.rentalparam.RentalParameterMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class RentalParamService {

	@Autowired
	private RentalParameterMapper rentalParameterMapper;

	// 将原数据的IsDelete设置为1，并增添新数据
	public void update(RentalParameter rentalParameterPre) {
			rentalParameterMapper.updateByPrimaryKeySelective(rentalParameterPre);
	}

	public void add(RentalParameter rentalParameter) {
		rentalParameterMapper.insertSelective(rentalParameter);
	}
	
	public List<RentalParameter> getPresentOne() {
		RentalParameterExample example = new RentalParameterExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(false);
		return rentalParameterMapper.selectByExample(example);
	}
}
