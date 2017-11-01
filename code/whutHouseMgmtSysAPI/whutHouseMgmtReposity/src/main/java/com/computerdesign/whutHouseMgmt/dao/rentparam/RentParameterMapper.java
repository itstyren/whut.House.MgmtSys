package com.computerdesign.whutHouseMgmt.dao.rentparam;

import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameter;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentParameterMapper {
    long countByExample(RentParameterExample example);

    int deleteByExample(RentParameterExample example);

    int deleteByPrimaryKey(Integer rentParamId);

    int insert(RentParameter record);

    int insertSelective(RentParameter record);

    List<RentParameter> selectByExample(RentParameterExample example);

    RentParameter selectByPrimaryKey(Integer rentParamId);

    int updateByExampleSelective(@Param("record") RentParameter record, @Param("example") RentParameterExample example);

    int updateByExample(@Param("record") RentParameter record, @Param("example") RentParameterExample example);

    int updateByPrimaryKeySelective(RentParameter record);

    int updateByPrimaryKey(RentParameter record);
}