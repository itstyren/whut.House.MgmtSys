package com.computerdesign.whutHouseMgmt.dao.right;

import com.computerdesign.whutHouseMgmt.bean.right.RightClass;
import com.computerdesign.whutHouseMgmt.bean.right.RightClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightClassMapper {
    long countByExample(RightClassExample example);

    int deleteByExample(RightClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RightClass record);

    int insertSelective(RightClass record);

    List<RightClass> selectByExample(RightClassExample example);

    RightClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RightClass record, @Param("example") RightClassExample example);

    int updateByExample(@Param("record") RightClass record, @Param("example") RightClassExample example);

    int updateByPrimaryKeySelective(RightClass record);

    int updateByPrimaryKey(RightClass record);
}