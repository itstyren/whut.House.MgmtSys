package com.computerdesign.whutHouseMgmt.dao.staffparam;

import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParam;
import com.computerdesign.whutHouseMgmt.bean.staffparam.MonetarySubParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonetarySubParamMapper {
    long countByExample(MonetarySubParamExample example);

    int deleteByExample(MonetarySubParamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonetarySubParam record);

    int insertSelective(MonetarySubParam record);

    List<MonetarySubParam> selectByExample(MonetarySubParamExample example);

    MonetarySubParam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonetarySubParam record, @Param("example") MonetarySubParamExample example);

    int updateByExample(@Param("record") MonetarySubParam record, @Param("example") MonetarySubParamExample example);

    int updateByPrimaryKeySelective(MonetarySubParam record);

    int updateByPrimaryKey(MonetarySubParam record);
}