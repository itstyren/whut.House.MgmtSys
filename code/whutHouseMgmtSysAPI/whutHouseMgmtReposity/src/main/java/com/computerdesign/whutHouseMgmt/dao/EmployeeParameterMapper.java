package com.computerdesign.whutHouseMgmt.dao;

import com.computerdesign.whutHouseMgmt.bean.EmployeeParameter;
import com.computerdesign.whutHouseMgmt.bean.EmployeeParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeParameterMapper {
    long countByExample(EmployeeParameterExample example);

    int deleteByExample(EmployeeParameterExample example);

    int deleteByPrimaryKey(Integer employeeParamId);

    int insert(EmployeeParameter record);

    int insertSelective(EmployeeParameter record);

    List<EmployeeParameter> selectByExample(EmployeeParameterExample example);

    EmployeeParameter selectByPrimaryKey(Integer employeeParamId);

    int updateByExampleSelective(@Param("record") EmployeeParameter record, @Param("example") EmployeeParameterExample example);

    int updateByExample(@Param("record") EmployeeParameter record, @Param("example") EmployeeParameterExample example);

    int updateByPrimaryKeySelective(EmployeeParameter record);

    int updateByPrimaryKey(EmployeeParameter record);
}