package com.computerdesign.whutHouseMgmt.dao.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaff;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HouseStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseStaffMapper {
    long countByExample(HouseStaffExample example);

    int deleteByExample(HouseStaffExample example);

    int insert(HouseStaff record);

    int insertSelective(HouseStaff record);

    List<HouseStaff> selectByExample(HouseStaffExample example);

    int updateByExampleSelective(@Param("record") HouseStaff record, @Param("example") HouseStaffExample example);

    int updateByExample(@Param("record") HouseStaff record, @Param("example") HouseStaffExample example);
}