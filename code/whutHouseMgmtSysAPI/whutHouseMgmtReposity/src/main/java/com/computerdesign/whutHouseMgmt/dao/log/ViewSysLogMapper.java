package com.computerdesign.whutHouseMgmt.dao.log;

import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLog;
import com.computerdesign.whutHouseMgmt.bean.log.ViewSysLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewSysLogMapper {
    long countByExample(ViewSysLogExample example);

    int deleteByExample(ViewSysLogExample example);

    int insert(ViewSysLog record);

    int insertSelective(ViewSysLog record);

    List<ViewSysLog> selectByExample(ViewSysLogExample example);

    int updateByExampleSelective(@Param("record") ViewSysLog record, @Param("example") ViewSysLogExample example);

    int updateByExample(@Param("record") ViewSysLog record, @Param("example") ViewSysLogExample example);
}