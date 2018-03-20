package com.computerdesign.whutHouseMgmt.dao.staffhomepage;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastHireRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LastHireRecordMapper {
    long countByExample(LastHireRecordExample example);

    int deleteByExample(LastHireRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LastHireRecord record);

    int insertSelective(LastHireRecord record);

    List<LastHireRecord> selectByExample(LastHireRecordExample example);

    LastHireRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LastHireRecord record, @Param("example") LastHireRecordExample example);

    int updateByExample(@Param("record") LastHireRecord record, @Param("example") LastHireRecordExample example);

    int updateByPrimaryKeySelective(LastHireRecord record);

    int updateByPrimaryKey(LastHireRecord record);
}