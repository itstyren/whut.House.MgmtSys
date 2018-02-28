package com.computerdesign.whutHouseMgmt.dao.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.StaffSelectHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffSelectHouseMapper {
    long countByExample(StaffSelectHouseExample example);

    int deleteByExample(StaffSelectHouseExample example);

    int deleteByPrimaryKey(Integer selectId);

    int insert(StaffSelectHouse record);

    int insertSelective(StaffSelectHouse record);

    List<StaffSelectHouse> selectByExample(StaffSelectHouseExample example);

    StaffSelectHouse selectByPrimaryKey(Integer selectId);

    int updateByExampleSelective(@Param("record") StaffSelectHouse record, @Param("example") StaffSelectHouseExample example);

    int updateByExample(@Param("record") StaffSelectHouse record, @Param("example") StaffSelectHouseExample example);

    int updateByPrimaryKeySelective(StaffSelectHouse record);

    int updateByPrimaryKey(StaffSelectHouse record);
}