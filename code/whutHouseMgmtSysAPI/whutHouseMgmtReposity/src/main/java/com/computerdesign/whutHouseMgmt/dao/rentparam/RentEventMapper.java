package com.computerdesign.whutHouseMgmt.dao.rentparam;

import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEvent;
import com.computerdesign.whutHouseMgmt.bean.rentparam.RentEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentEventMapper {
    long countByExample(RentEventExample example);

    int deleteByExample(RentEventExample example);

    int deleteByPrimaryKey(Integer rentEventId);

    int insert(RentEvent record);

    int insertSelective(RentEvent record);

    List<RentEvent> selectByExample(RentEventExample example);

    RentEvent selectByPrimaryKey(Integer rentEventId);

    int updateByExampleSelective(@Param("record") RentEvent record, @Param("example") RentEventExample example);

    int updateByExample(@Param("record") RentEvent record, @Param("example") RentEventExample example);

    int updateByPrimaryKeySelective(RentEvent record);

    int updateByPrimaryKey(RentEvent record);
}