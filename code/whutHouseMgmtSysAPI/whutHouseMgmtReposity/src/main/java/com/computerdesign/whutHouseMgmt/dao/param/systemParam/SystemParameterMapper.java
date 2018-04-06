package com.computerdesign.whutHouseMgmt.dao.param.systemParam;

import com.computerdesign.whutHouseMgmt.bean.param.systemParam.SystemParameter;
import com.computerdesign.whutHouseMgmt.bean.param.systemParam.SystemParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParameterMapper {
    long countByExample(SystemParameterExample example);

    int deleteByExample(SystemParameterExample example);

    int deleteByPrimaryKey(Integer sysParamId);

    int insert(SystemParameter record);

    int insertSelective(SystemParameter record);

    List<SystemParameter> selectByExampleWithBLOBs(SystemParameterExample example);

    List<SystemParameter> selectByExample(SystemParameterExample example);

    SystemParameter selectByPrimaryKey(Integer sysParamId);

    int updateByExampleSelective(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByExample(@Param("record") SystemParameter record, @Param("example") SystemParameterExample example);

    int updateByPrimaryKeySelective(SystemParameter record);

    int updateByPrimaryKeyWithBLOBs(SystemParameter record);

    int updateByPrimaryKey(SystemParameter record);
}