package com.computerdesign.whutHouseMgmt.dao.fix;

import com.computerdesign.whutHouseMgmt.bean.fix.ViewFix;
import com.computerdesign.whutHouseMgmt.bean.fix.ViewFixExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewFixMapper {
    long countByExample(ViewFixExample example);

    int deleteByExample(ViewFixExample example);

    int insert(ViewFix record);

    int insertSelective(ViewFix record);

    List<ViewFix> selectByExample(ViewFixExample example);

    int updateByExampleSelective(@Param("record") ViewFix record, @Param("example") ViewFixExample example);

    int updateByExample(@Param("record") ViewFix record, @Param("example") ViewFixExample example);
}