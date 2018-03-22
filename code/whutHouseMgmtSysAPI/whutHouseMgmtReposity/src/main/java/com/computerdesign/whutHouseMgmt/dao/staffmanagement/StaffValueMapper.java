package com.computerdesign.whutHouseMgmt.dao.staffmanagement;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValue;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.StaffValueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffValueMapper {
    long countByExample(StaffValueExample example);

    int deleteByExample(StaffValueExample example);

    int insert(StaffValue record);

    int insertSelective(StaffValue record);

    List<StaffValue> selectByExample(StaffValueExample example);

    int updateByExampleSelective(@Param("record") StaffValue record, @Param("example") StaffValueExample example);

    int updateByExample(@Param("record") StaffValue record, @Param("example") StaffValueExample example);
}