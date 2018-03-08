package com.computerdesign.whutHouseMgmt.dao.hire;

import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.Rent;
import com.computerdesign.whutHouseMgmt.bean.hire.rentgenerate.RentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentMapper {
    long countByExample(RentExample example);

    int deleteByExample(RentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Rent record);

    int insertSelective(Rent record);

    List<Rent> selectByExample(RentExample example);

    Rent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Rent record, @Param("example") RentExample example);

    int updateByExample(@Param("record") Rent record, @Param("example") RentExample example);

    int updateByPrimaryKeySelective(Rent record);

    int updateByPrimaryKey(Rent record);
}