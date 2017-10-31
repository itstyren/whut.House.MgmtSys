package com.computerdesign.whutHouseMgmt.dao.staffparam;

import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameter;
import com.computerdesign.whutHouseMgmt.bean.staffparam.StaffParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffParameterMapper {
    long countByExample(StaffParameterExample example);

    int deleteByExample(StaffParameterExample example);

    int deleteByPrimaryKey(Integer staffParamId);

    int insert(StaffParameter record);

    int insertSelective(StaffParameter record);

    List<StaffParameter> selectByExample(StaffParameterExample example);

    StaffParameter selectByPrimaryKey(Integer staffParamId);

    int updateByExampleSelective(@Param("record") StaffParameter record, @Param("example") StaffParameterExample example);

    int updateByExample(@Param("record") StaffParameter record, @Param("example") StaffParameterExample example);

    int updateByPrimaryKeySelective(StaffParameter record);

    int updateByPrimaryKey(StaffParameter record);
}