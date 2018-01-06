package com.computerdesign.whutHouseMgmt.service.token;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computerdesign.whutHouseMgmt.bean.token.Token;
import com.computerdesign.whutHouseMgmt.bean.token.TokenExample;
import com.computerdesign.whutHouseMgmt.bean.token.TokenExample.Criteria;
import com.computerdesign.whutHouseMgmt.dao.token.TokenMapper;

@Service
public class TokenService {

	@Autowired
	private TokenMapper tokenMapper;
	
	public List<Token> get(String no) {
		TokenExample example = new TokenExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(no);
		return tokenMapper.selectByExample(example);
	}
	
	/**
	 * 添加token信息
	 * @param token
	 */
	public void add(Token token) {
		tokenMapper.insertSelective(token);
	}
	/**
	 * 修改token信息
	 * @param token
	 */
	public void update(Token token) {
		TokenExample example = new TokenExample();
		Criteria criteria = example.createCriteria();
		criteria.andNoEqualTo(token.getNo());
		Token tokenRecord = new Token();
		tokenRecord.setToken(token.getToken());
		tokenRecord.setLastLoginTime(token.getLastLoginTime());
		tokenMapper.updateByExampleSelective(tokenRecord, example);
	}
}
