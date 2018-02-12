package com.computerdesign.whutHouseMgmt.dao.hire;

import com.computerdesign.whutHouseMgmt.bean.hire.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.HireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HireMapper {
    long countByExample(HireExample example);

    int deleteByExample(HireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Hire record);

    int insertSelective(Hire record);

    List<Hire> selectByExample(HireExample example);

    Hire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Hire record, @Param("example") HireExample example);

    int updateByExample(@Param("record") Hire record, @Param("example") HireExample example);

    int updateByPrimaryKeySelective(Hire record);

    int updateByPrimaryKey(Hire record);
}