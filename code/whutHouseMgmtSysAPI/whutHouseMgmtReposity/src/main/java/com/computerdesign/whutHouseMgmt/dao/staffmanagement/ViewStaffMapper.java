package com.computerdesign.whutHouseMgmt.dao.staffmanagement;

import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewStaffMapper {
    long countByExample(ViewStaffExample example);

    int deleteByExample(ViewStaffExample example);

    int insert(ViewStaff record);

    int insertSelective(ViewStaff record);

    List<ViewStaff> selectByExample(ViewStaffExample example);

    int updateByExampleSelective(@Param("record") ViewStaff record, @Param("example") ViewStaffExample example);

    int updateByExample(@Param("record") ViewStaff record, @Param("example") ViewStaffExample example);
}