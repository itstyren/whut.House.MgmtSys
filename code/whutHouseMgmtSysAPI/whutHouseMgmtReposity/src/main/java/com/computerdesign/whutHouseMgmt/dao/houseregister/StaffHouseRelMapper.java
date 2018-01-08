package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffHouseRelMapper {
    long countByExample(StaffHouseRelExample example);

    int deleteByExample(StaffHouseRelExample example);

    int insert(StaffHouseRel record);

    int insertSelective(StaffHouseRel record);

    List<StaffHouseRel> selectByExample(StaffHouseRelExample example);

    int updateByExampleSelective(@Param("record") StaffHouseRel record, @Param("example") StaffHouseRelExample example);

    int updateByExample(@Param("record") StaffHouseRel record, @Param("example") StaffHouseRelExample example);
}