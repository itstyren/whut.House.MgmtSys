package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResidentVwMapper {
    long countByExample(ResidentVwExample example);

    int deleteByExample(ResidentVwExample example);

    int insert(ResidentVw record);

    int insertSelective(ResidentVw record);

    List<ResidentVw> selectByExample(ResidentVwExample example);

    int updateByExampleSelective(@Param("record") ResidentVw record, @Param("example") ResidentVwExample example);

    int updateByExample(@Param("record") ResidentVw record, @Param("example") ResidentVwExample example);
}