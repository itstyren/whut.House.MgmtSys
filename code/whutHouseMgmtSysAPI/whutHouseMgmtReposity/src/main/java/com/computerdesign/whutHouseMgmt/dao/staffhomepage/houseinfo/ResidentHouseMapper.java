package com.computerdesign.whutHouseMgmt.dao.staffhomepage.houseinfo;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouse;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResidentHouseMapper {
    long countByExample(ResidentHouseExample example);

    int deleteByExample(ResidentHouseExample example);

    int insert(ResidentHouse record);

    int insertSelective(ResidentHouse record);

    List<ResidentHouse> selectByExample(ResidentHouseExample example);

    int updateByExampleSelective(@Param("record") ResidentHouse record, @Param("example") ResidentHouseExample example);

    int updateByExample(@Param("record") ResidentHouse record, @Param("example") ResidentHouseExample example);
}