package com.computerdesign.whutHouseMgmt.dao.login;

import com.computerdesign.whutHouseMgmt.bean.login.LoginRecord;
import com.computerdesign.whutHouseMgmt.bean.login.LoginRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginRecordMapper {
    long countByExample(LoginRecordExample example);

    int deleteByExample(LoginRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LoginRecord record);

    int insertSelective(LoginRecord record);

    List<LoginRecord> selectByExample(LoginRecordExample example);

    LoginRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LoginRecord record, @Param("example") LoginRecordExample example);

    int updateByExample(@Param("record") LoginRecord record, @Param("example") LoginRecordExample example);

    int updateByPrimaryKeySelective(LoginRecord record);

    int updateByPrimaryKey(LoginRecord record);
}