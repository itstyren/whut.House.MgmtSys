package com.computerdesign.whutHouseMgmt.dao.fixparam;

import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameter;
import com.computerdesign.whutHouseMgmt.bean.fixparam.FixParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FixParameterMapper {
    long countByExample(FixParameterExample example);

    int deleteByExample(FixParameterExample example);

    int deleteByPrimaryKey(Integer fixParamId);

    int insert(FixParameter record);

    int insertSelective(FixParameter record);

    List<FixParameter> selectByExample(FixParameterExample example);

    FixParameter selectByPrimaryKey(Integer fixParamId);

    int updateByExampleSelective(@Param("record") FixParameter record, @Param("example") FixParameterExample example);

    int updateByExample(@Param("record") FixParameter record, @Param("example") FixParameterExample example);

    int updateByPrimaryKeySelective(FixParameter record);

    int updateByPrimaryKey(FixParameter record);
}