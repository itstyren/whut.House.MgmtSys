package com.computerdesign.whutHouseMgmt.dao.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouse;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.SelfHelpSelectHouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelfHelpSelectHouseMapper {
    long countByExample(SelfHelpSelectHouseExample example);

    int deleteByExample(SelfHelpSelectHouseExample example);

    int insert(SelfHelpSelectHouse record);

    int insertSelective(SelfHelpSelectHouse record);

    List<SelfHelpSelectHouse> selectByExample(SelfHelpSelectHouseExample example);

    int updateByExampleSelective(@Param("record") SelfHelpSelectHouse record, @Param("example") SelfHelpSelectHouseExample example);

    int updateByExample(@Param("record") SelfHelpSelectHouse record, @Param("example") SelfHelpSelectHouseExample example);
}