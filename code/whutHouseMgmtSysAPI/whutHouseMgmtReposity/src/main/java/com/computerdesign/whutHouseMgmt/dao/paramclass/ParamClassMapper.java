package com.computerdesign.whutHouseMgmt.dao.paramclass;

import com.computerdesign.whutHouseMgmt.bean.paramclass.ParamClass;
import com.computerdesign.whutHouseMgmt.bean.paramclass.ParamClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParamClassMapper {
    long countByExample(ParamClassExample example);

    int deleteByExample(ParamClassExample example);

    int deleteByPrimaryKey(Integer paramTypeId);

    int insert(ParamClass record);

    int insertSelective(ParamClass record);

    List<ParamClass> selectByExample(ParamClassExample example);

    ParamClass selectByPrimaryKey(Integer paramTypeId);

    int updateByExampleSelective(@Param("record") ParamClass record, @Param("example") ParamClassExample example);

    int updateByExample(@Param("record") ParamClass record, @Param("example") ParamClassExample example);

    int updateByPrimaryKeySelective(ParamClass record);

    int updateByPrimaryKey(ParamClass record);
}