package com.computerdesign.whutHouseMgmt.dao.house;

import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewHouseMapper {
    long countByExample(ViewHouseExample example);

    int deleteByExample(ViewHouseExample example);

    int insert(ViewHouse record);

    int insertSelective(ViewHouse record);

    List<ViewHouse> selectByExample(ViewHouseExample example);

    int updateByExampleSelective(@Param("record") ViewHouse record, @Param("example") ViewHouseExample example);

    int updateByExample(@Param("record") ViewHouse record, @Param("example") ViewHouseExample example);
}