package com.computerdesign.whutHouseMgmt.dao.fixratings;

import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatings;
import com.computerdesign.whutHouseMgmt.bean.fixratings.FixRatingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FixRatingsMapper {
    long countByExample(FixRatingsExample example);

    int deleteByExample(FixRatingsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FixRatings record);

    int insertSelective(FixRatings record);

    List<FixRatings> selectByExample(FixRatingsExample example);

    FixRatings selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FixRatings record, @Param("example") FixRatingsExample example);

    int updateByExample(@Param("record") FixRatings record, @Param("example") FixRatingsExample example);

    int updateByPrimaryKeySelective(FixRatings record);

    int updateByPrimaryKey(FixRatings record);
}