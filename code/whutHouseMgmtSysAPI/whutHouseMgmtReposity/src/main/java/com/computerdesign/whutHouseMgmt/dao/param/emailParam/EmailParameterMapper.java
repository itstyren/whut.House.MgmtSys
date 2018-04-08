package com.computerdesign.whutHouseMgmt.dao.param.emailParam;

import com.computerdesign.whutHouseMgmt.bean.param.emailParam.EmailParameter;
import com.computerdesign.whutHouseMgmt.bean.param.emailParam.EmailParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailParameterMapper {
    long countByExample(EmailParameterExample example);

    int deleteByExample(EmailParameterExample example);

    int deleteByPrimaryKey(String host);

    int insert(EmailParameter record);

    int insertSelective(EmailParameter record);

    List<EmailParameter> selectByExample(EmailParameterExample example);

    EmailParameter selectByPrimaryKey(String host);

    int updateByExampleSelective(@Param("record") EmailParameter record, @Param("example") EmailParameterExample example);

    int updateByExample(@Param("record") EmailParameter record, @Param("example") EmailParameterExample example);

    int updateByPrimaryKeySelective(EmailParameter record);

    int updateByPrimaryKey(EmailParameter record);
}