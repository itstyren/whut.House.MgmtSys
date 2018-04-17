package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.MonetarySubVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonetarySubVwMapper {
    long countByExample(MonetarySubVwExample example);

    int deleteByExample(MonetarySubVwExample example);

    int insert(MonetarySubVw record);

    int insertSelective(MonetarySubVw record);

    List<MonetarySubVw> selectByExample(MonetarySubVwExample example);

    int updateByExampleSelective(@Param("record") MonetarySubVw record, @Param("example") MonetarySubVwExample example);

    int updateByExample(@Param("record") MonetarySubVw record, @Param("example") MonetarySubVwExample example);
}