package com.computerdesign.whutHouseMgmt.service.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.rule.Rule;
import com.computerdesign.whutHouseMgmt.bean.rule.RuleExample;
import com.computerdesign.whutHouseMgmt.bean.rule.RuleExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.rule.RuleMapper;

@Service
public class RuleService {

	@Autowired
	private RuleMapper ruleMapper;
	
	/**
	 * 获取全部的rule
	 * @return
	 */
	public List<Rule> getAll() {
		return ruleMapper.selectByExample(null);
	}
	
	/**
	 * 根据角色获取权限
	 * @param roleId
	 * @return
	 */
	public List<Rule> getRulesByRole(Integer roleId) {
		RuleExample example = new RuleExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		return ruleMapper.selectByExample(example);
	}
	
	/**
	 * 增加一个rule
	 * @param rule
	 */
	public void addRule(Rule rule) {
		ruleMapper.insertSelective(rule);
	}
	
	/**
	 * 删除一个rule
	 * @param id
	 */
	public void deleteRule(Integer id) {
		ruleMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 修改一个rule
	 * @param rule
	 */
	public void update(Rule rule){
		ruleMapper.updateByPrimaryKeySelective(rule);
	}
}
