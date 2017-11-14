package com.computerdesign.whutHouseMgmt.dao.building_region;

import com.computerdesign.whutHouseMgmt.bean.building_region.Building_Region;
import com.computerdesign.whutHouseMgmt.bean.building_region.Building_RegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Building_RegionMapper {
    long countByExample(Building_RegionExample example);

    int deleteByExample(Building_RegionExample example);

    int insert(Building_Region record);

    int insertSelective(Building_Region record);

    List<Building_Region> selectByExample(Building_RegionExample example);

    int updateByExampleSelective(@Param("record") Building_Region record, @Param("example") Building_RegionExample example);

    int updateByExample(@Param("record") Building_Region record, @Param("example") Building_RegionExample example);
}