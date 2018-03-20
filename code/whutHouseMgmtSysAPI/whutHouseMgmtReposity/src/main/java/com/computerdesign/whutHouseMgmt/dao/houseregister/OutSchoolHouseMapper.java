package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OutSchoolHouseMapper {
    long countByExample(OutSchoolHouseExample example);

    int deleteByExample(OutSchoolHouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OutSchoolHouse record);

    int insertSelective(OutSchoolHouse record);

    List<OutSchoolHouse> selectByExample(OutSchoolHouseExample example);

    OutSchoolHouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OutSchoolHouse record, @Param("example") OutSchoolHouseExample example);

    int updateByExample(@Param("record") OutSchoolHouse record, @Param("example") OutSchoolHouseExample example);

    int updateByPrimaryKeySelective(OutSchoolHouse record);

    int updateByPrimaryKey(OutSchoolHouse record);
}