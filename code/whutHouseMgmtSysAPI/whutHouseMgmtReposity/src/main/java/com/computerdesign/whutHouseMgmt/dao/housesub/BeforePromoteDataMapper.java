package com.computerdesign.whutHouseMgmt.dao.housesub;

import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteData;
import com.computerdesign.whutHouseMgmt.bean.housesub.BeforePromoteDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeforePromoteDataMapper {
    long countByExample(BeforePromoteDataExample example);

    int deleteByExample(BeforePromoteDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BeforePromoteData record);

    int insertSelective(BeforePromoteData record);

    List<BeforePromoteData> selectByExample(BeforePromoteDataExample example);

    BeforePromoteData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BeforePromoteData record, @Param("example") BeforePromoteDataExample example);

    int updateByExample(@Param("record") BeforePromoteData record, @Param("example") BeforePromoteDataExample example);

    int updateByPrimaryKeySelective(BeforePromoteData record);

    int updateByPrimaryKey(BeforePromoteData record);
}