package com.computerdesign.whutHouseMgmt.dao.hire;

import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVw;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentVwMapper {
    long countByExample(RentVwExample example);

    int deleteByExample(RentVwExample example);

    int insert(RentVw record);

    int insertSelective(RentVw record);

    List<RentVw> selectByExample(RentVwExample example);

    int updateByExampleSelective(@Param("record") RentVw record, @Param("example") RentVwExample example);

    int updateByExample(@Param("record") RentVw record, @Param("example") RentVwExample example);
}