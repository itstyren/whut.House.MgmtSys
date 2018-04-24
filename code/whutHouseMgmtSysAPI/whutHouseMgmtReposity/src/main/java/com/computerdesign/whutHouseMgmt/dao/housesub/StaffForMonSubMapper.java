package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffForMonSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffForMonSubMapper {
    long countByExample(StaffForMonSubExample example);

    int deleteByExample(StaffForMonSubExample example);

    int insert(StaffForMonSub record);

    int insertSelective(StaffForMonSub record);

    List<StaffForMonSub> selectByExample(StaffForMonSubExample example);

    int updateByExampleSelective(@Param("record") StaffForMonSub record, @Param("example") StaffForMonSubExample example);

    int updateByExample(@Param("record") StaffForMonSub record, @Param("example") StaffForMonSubExample example);
}