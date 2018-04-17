package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySub;
import com.computerdesign.whutHouseMgmt.bean.housesub.OneTimeMonetarySubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OneTimeMonetarySubMapper {
    long countByExample(OneTimeMonetarySubExample example);

    int deleteByExample(OneTimeMonetarySubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OneTimeMonetarySub record);

    int insertSelective(OneTimeMonetarySub record);

    List<OneTimeMonetarySub> selectByExample(OneTimeMonetarySubExample example);

    OneTimeMonetarySub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OneTimeMonetarySub record, @Param("example") OneTimeMonetarySubExample example);

    int updateByExample(@Param("record") OneTimeMonetarySub record, @Param("example") OneTimeMonetarySubExample example);

    int updateByPrimaryKeySelective(OneTimeMonetarySub record);

    int updateByPrimaryKey(OneTimeMonetarySub record);
}