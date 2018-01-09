package com.computerdesign.whutHouseMgmt.dao.fix;

import com.computerdesign.whutHouseMgmt.bean.fix.Fix;
import com.computerdesign.whutHouseMgmt.bean.fix.FixExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FixMapper {
    long countByExample(FixExample example);

    int deleteByExample(FixExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Fix record);

    int insertSelective(Fix record);

    List<Fix> selectByExample(FixExample example);

    Fix selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Fix record, @Param("example") FixExample example);

    int updateByExample(@Param("record") Fix record, @Param("example") FixExample example);

    int updateByPrimaryKeySelective(Fix record);

    int updateByPrimaryKey(Fix record);
}