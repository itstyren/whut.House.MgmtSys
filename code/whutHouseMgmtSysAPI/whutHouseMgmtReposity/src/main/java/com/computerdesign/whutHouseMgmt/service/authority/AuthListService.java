package com.computerdesign.whutHouseMgmt.service.authority;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.authority.AuthList;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthListExample;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthListExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.authority.AuthListMapper;

@Service
public class AuthListService {
	
	@Autowired
	private AuthListMapper authListMapper;
	
	/**
	 * 根据用户组ID获取用户组权限路由信息
	 * @param id
	 * @return
	 */
	public String getAuthListById(Integer id){
		AuthList authList = authListMapper.selectByPrimaryKey(id);
		if(authList != null){
			return authList.getUserRouters();
		}else{
			return null;
		}
	}
	
	/**
	 * 根据ID获取一组用户组信息
	 * @param id
	 * @return
	 */
	public AuthList getOneAuth(Integer id){
		return authListMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 根据用户组名称获取一条记录
	 * @param groupName
	 * @return
	 */
	public AuthList getAuthListByGroupName(String groupName){
		AuthListExample example = new AuthListExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupNameEqualTo(groupName);
		if(authListMapper.selectByExample(example).size() > 0){			
			return authListMapper.selectByExample(example).get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 获取所有的用户组信息
	 * @return
	 */
	public List<AuthList> getAllAuthList(){
		AuthListExample example = new AuthListExample();
		Criteria criteria = example.createCriteria();
		return authListMapper.selectByExampleWithBLOBs(example);
	}
	
	/**
	 * 获取所有的用户组信息
	 * @return
	 */
	public List<AuthList> getPartAuthList(){
		AuthListExample example = new AuthListExample();
		Criteria criteria = example.createCriteria();
		criteria.andStateEqualTo(true);
		return authListMapper.selectByExampleWithBLOBs(example);
	}
	
	
	/**
	 * 根据用户组名称列表删除用户组信息
	 * @param groupNameList
	 * @return
	 */
	public boolean deleteAuthListByGroupName(List<String> groupNameList){
		if(groupNameList != null){
			AuthListExample example = new AuthListExample();
			Criteria criteria = example.createCriteria();
			criteria.andGroupNameIn(groupNameList);
//			criteria.andIdIn(groupNameList);
//			System.out.println(groupNameList);
			authListMapper.deleteByExample(example);
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 增加一条用户组信息
	 * @param authList
	 * @return
	 */
	public boolean addAuthList(AuthList authList){
		if(authList != null){
			AuthList auth = getAuthListByGroupName(authList.getGroupName());
			if(auth == null){				
				authListMapper.insert(authList);
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * 修改用户组信息
	 * @param authList
	 * @return
	 */
	public boolean editAuthList(AuthList authList){
		if (authList != null){
//			AuthListExample example = new AuthListExample();
//			Criteria criteria = example.createCriteria();
//			criteria.andGroupNameEqualTo(authList.getGroupName());
//			authListMapper.updateByExample(authList, example);
//			authListMapper.updateByPrimaryKey(authList);
			authListMapper.updateByPrimaryKeySelective(authList);
			return true;
		}else{
			return false;
		}
	}

}
