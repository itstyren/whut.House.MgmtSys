package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVw;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OneTimeMonetarySubVwMapper {
    long countByExample(OneTimeMonetarySubVwExample example);

    int deleteByExample(OneTimeMonetarySubVwExample example);

    int insert(OneTimeMonetarySubVw record);

    int insertSelective(OneTimeMonetarySubVw record);

    List<OneTimeMonetarySubVw> selectByExample(OneTimeMonetarySubVwExample example);

    int updateByExampleSelective(@Param("record") OneTimeMonetarySubVw record, @Param("example") OneTimeMonetarySubVwExample example);

    int updateByExample(@Param("record") OneTimeMonetarySubVw record, @Param("example") OneTimeMonetarySubVwExample example);
}