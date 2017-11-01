package com.computerdesign.whutHouseMgmt.dao.rentalparam;

import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameter;
import com.computerdesign.whutHouseMgmt.bean.rentalparam.RentalParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentalParameterMapper {
    long countByExample(RentalParameterExample example);

    int deleteByExample(RentalParameterExample example);

    int deleteByPrimaryKey(Integer rentalParamId);

    int insert(RentalParameter record);

    int insertSelective(RentalParameter record);

    List<RentalParameter> selectByExample(RentalParameterExample example);

    RentalParameter selectByPrimaryKey(Integer rentalParamId);

    int updateByExampleSelective(@Param("record") RentalParameter record, @Param("example") RentalParameterExample example);

    int updateByExample(@Param("record") RentalParameter record, @Param("example") RentalParameterExample example);

    int updateByPrimaryKeySelective(RentalParameter record);

    int updateByPrimaryKey(RentalParameter record);
}