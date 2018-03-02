package com.computerdesign.whutHouseMgmt.dao.internetselecthouse;

import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HireRecent;
import com.computerdesign.whutHouseMgmt.bean.internetselecthouse.HireRecentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HireRecentMapper {
    long countByExample(HireRecentExample example);

    int deleteByExample(HireRecentExample example);

    int insert(HireRecent record);

    int insertSelective(HireRecent record);

    List<HireRecent> selectByExample(HireRecentExample example);

    int updateByExampleSelective(@Param("record") HireRecent record, @Param("example") HireRecentExample example);

    int updateByExample(@Param("record") HireRecent record, @Param("example") HireRecentExample example);
}