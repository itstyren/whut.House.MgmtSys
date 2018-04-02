package com.computerdesign.whutHouseMgmt.dao.region;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegion;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.region.ViewRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewRegionMapper {
    long countByExample(ViewRegionExample example);

    int deleteByExample(ViewRegionExample example);

    int insert(ViewRegion record);

    int insertSelective(ViewRegion record);

    List<ViewRegion> selectByExample(ViewRegionExample example);

    int updateByExampleSelective(@Param("record") ViewRegion record, @Param("example") ViewRegionExample example);

    int updateByExample(@Param("record") ViewRegion record, @Param("example") ViewRegionExample example);
}