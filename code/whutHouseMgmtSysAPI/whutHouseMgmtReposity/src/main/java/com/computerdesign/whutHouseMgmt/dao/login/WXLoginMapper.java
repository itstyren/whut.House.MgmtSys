package com.computerdesign.whutHouseMgmt.dao.login;

import com.computerdesign.whutHouseMgmt.bean.login.WXLogin;
import com.computerdesign.whutHouseMgmt.bean.login.WXLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WXLoginMapper {
    long countByExample(WXLoginExample example);

    int deleteByExample(WXLoginExample example);

    int insert(WXLogin record);

    int insertSelective(WXLogin record);

    List<WXLogin> selectByExample(WXLoginExample example);

    int updateByExampleSelective(@Param("record") WXLogin record, @Param("example") WXLoginExample example);

    int updateByExample(@Param("record") WXLogin record, @Param("example") WXLoginExample example);
}