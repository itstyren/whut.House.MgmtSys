package com.computerdesign.whutHouseMgmt.dao.building;

import com.computerdesign.whutHouseMgmt.bean.building.ViewBuilding;
import com.computerdesign.whutHouseMgmt.bean.building.ViewBuildingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewBuildingMapper {
    long countByExample(ViewBuildingExample example);

    int deleteByExample(ViewBuildingExample example);

    int insert(ViewBuilding record);

    int insertSelective(ViewBuilding record);

    List<ViewBuilding> selectByExample(ViewBuildingExample example);

    int updateByExampleSelective(@Param("record") ViewBuilding record, @Param("example") ViewBuildingExample example);

    int updateByExample(@Param("record") ViewBuilding record, @Param("example") ViewBuildingExample example);
}