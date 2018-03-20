package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutSchoolHouseVwMapper {
    long countByExample(OutSchoolHouseVwExample example);

    int deleteByExample(OutSchoolHouseVwExample example);

    int insert(OutSchoolHouseVw record);

    int insertSelective(OutSchoolHouseVw record);

    List<OutSchoolHouseVw> selectByExample(OutSchoolHouseVwExample example);

    int updateByExampleSelective(@Param("record") OutSchoolHouseVw record, @Param("example") OutSchoolHouseVwExample example);

    int updateByExample(@Param("record") OutSchoolHouseVw record, @Param("example") OutSchoolHouseVwExample example);
}