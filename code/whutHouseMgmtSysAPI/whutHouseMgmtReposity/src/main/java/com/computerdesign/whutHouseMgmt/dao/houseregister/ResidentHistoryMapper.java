package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistory;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResidentHistoryMapper {
    long countByExample(ResidentHistoryExample example);

    int deleteByExample(ResidentHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResidentHistory record);

    int insertSelective(ResidentHistory record);

    List<ResidentHistory> selectByExample(ResidentHistoryExample example);

    ResidentHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResidentHistory record, @Param("example") ResidentHistoryExample example);

    int updateByExample(@Param("record") ResidentHistory record, @Param("example") ResidentHistoryExample example);

    int updateByPrimaryKeySelective(ResidentHistory record);

    int updateByPrimaryKey(ResidentHistory record);
}