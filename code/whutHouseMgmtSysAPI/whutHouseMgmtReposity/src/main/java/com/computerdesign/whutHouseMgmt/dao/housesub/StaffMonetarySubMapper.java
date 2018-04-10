package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.StaffMonetarySubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StaffMonetarySubMapper {
    long countByExample(StaffMonetarySubExample example);

    int deleteByExample(StaffMonetarySubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StaffMonetarySub record);

    int insertSelective(StaffMonetarySub record);

    List<StaffMonetarySub> selectByExample(StaffMonetarySubExample example);

    StaffMonetarySub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StaffMonetarySub record, @Param("example") StaffMonetarySubExample example);

    int updateByExample(@Param("record") StaffMonetarySub record, @Param("example") StaffMonetarySubExample example);

    int updateByPrimaryKeySelective(StaffMonetarySub record);

    int updateByPrimaryKey(StaffMonetarySub record);
}