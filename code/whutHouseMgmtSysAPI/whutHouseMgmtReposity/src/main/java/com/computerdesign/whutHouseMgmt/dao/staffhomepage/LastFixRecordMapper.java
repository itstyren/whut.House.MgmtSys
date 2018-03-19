package com.computerdesign.whutHouseMgmt.dao.staffhomepage;

import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecord;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.LastFixRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LastFixRecordMapper {
    long countByExample(LastFixRecordExample example);

    int deleteByExample(LastFixRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LastFixRecord record);

    int insertSelective(LastFixRecord record);

    List<LastFixRecord> selectByExample(LastFixRecordExample example);

    LastFixRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LastFixRecord record, @Param("example") LastFixRecordExample example);

    int updateByExample(@Param("record") LastFixRecord record, @Param("example") LastFixRecordExample example);

    int updateByPrimaryKeySelective(LastFixRecord record);

    int updateByPrimaryKey(LastFixRecord record);
}