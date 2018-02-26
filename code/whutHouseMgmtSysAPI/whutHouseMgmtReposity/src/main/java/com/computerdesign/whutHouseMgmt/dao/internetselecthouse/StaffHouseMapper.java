package com.computerdesign.whutHouseMgmt.dao.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffHouseMapper {
    long countByExample(StaffHouseExample example);

    int deleteByExample(StaffHouseExample example);

    int insert(StaffHouse record);

    int insertSelective(StaffHouse record);

    List<StaffHouse> selectByExample(StaffHouseExample example);

    int updateByExampleSelective(@Param("record") StaffHouse record, @Param("example") StaffHouseExample example);

    int updateByExample(@Param("record") StaffHouse record, @Param("example") StaffHouseExample example);
}