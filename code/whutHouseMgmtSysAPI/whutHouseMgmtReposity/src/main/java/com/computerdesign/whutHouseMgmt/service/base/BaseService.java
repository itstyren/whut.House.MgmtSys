package com.computerdesign.whutHouseMgmt.service.base;

import java.util.List;


public interface BaseService<T> {
	
	public List<T> getAll();
	
	public void delete(Integer id);
	
	public void add(T entities);
	
	public void update(T entities);

	
}
