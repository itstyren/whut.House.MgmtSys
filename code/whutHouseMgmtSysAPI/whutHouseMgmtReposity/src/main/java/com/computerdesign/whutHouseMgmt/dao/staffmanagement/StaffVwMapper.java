package com.computerdesign.whutHouseMgmt.dao.staffmanagement;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffVwMapper {
    long countByExample(StaffVwExample example);

    int deleteByExample(StaffVwExample example);

    int insert(StaffVw record);

    int insertSelective(StaffVw record);

    List<StaffVw> selectByExample(StaffVwExample example);

    int updateByExampleSelective(@Param("record") StaffVw record, @Param("example") StaffVwExample example);

    int updateByExample(@Param("record") StaffVw record, @Param("example") StaffVwExample example);
}