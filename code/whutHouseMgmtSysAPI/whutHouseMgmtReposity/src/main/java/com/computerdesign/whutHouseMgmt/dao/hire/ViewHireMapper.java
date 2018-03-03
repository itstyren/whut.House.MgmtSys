package com.computerdesign.whutHouseMgmt.dao.hire;

import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHire;
import com.computerdesign.whutHouseMgmt.bean.hire.common.ViewHireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewHireMapper {
    long countByExample(ViewHireExample example);

    int deleteByExample(ViewHireExample example);

    int insert(ViewHire record);

    int insertSelective(ViewHire record);

    List<ViewHire> selectByExample(ViewHireExample example);

    int updateByExampleSelective(@Param("record") ViewHire record, @Param("example") ViewHireExample example);

    int updateByExample(@Param("record") ViewHire record, @Param("example") ViewHireExample example);
}