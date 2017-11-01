package com.computerdesign.whutHouseMgmt.service.paramclass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.paramclass.ParamClass;
import com.computerdesign.whutHouseMgmt.dao.paramclass.ParamClassMapper;
import com.computerdesign.whutHouseMgmt.service.base.BaseService;

@Service
public class ParamClassService implements BaseService<ParamClass>{

	@Autowired
	private ParamClassMapper paramClassMapper;
	
	public ParamClass get(Integer paramTypeId){
		return paramClassMapper.selectByPrimaryKey(paramTypeId);
	}
	
	@Override
	public List<ParamClass> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(ParamClass entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ParamClass entities) {
		// TODO Auto-generated method stub
		
	}

}
