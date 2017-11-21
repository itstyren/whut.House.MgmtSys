package com.computerdesign.whutHouseMgmt.dao.houseparam;

import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseParameterMapper {
	
	//自己写的Mapper
	List<Integer> selectHouseParamId(Integer paramTypeId);
	
    long countByExample(HouseParameterExample example);

    int deleteByExample(HouseParameterExample example);

    int deleteByPrimaryKey(Integer houseParamId);

    int insert(HouseParameter record);

    int insertSelective(HouseParameter record);

    List<HouseParameter> selectByExample(HouseParameterExample example);

    HouseParameter selectByPrimaryKey(Integer houseParamId);

    int updateByExampleSelective(@Param("record") HouseParameter record, @Param("example") HouseParameterExample example);

    int updateByExample(@Param("record") HouseParameter record, @Param("example") HouseParameterExample example);

    int updateByPrimaryKeySelective(HouseParameter record);

    int updateByPrimaryKey(HouseParameter record);
}