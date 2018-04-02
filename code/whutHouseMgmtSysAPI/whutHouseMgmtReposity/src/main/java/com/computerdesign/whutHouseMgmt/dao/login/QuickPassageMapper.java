package com.computerdesign.whutHouseMgmt.dao.login;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.computerdesign.whutHouseMgmt.bean.login.QuickPassage;
import com.computerdesign.whutHouseMgmt.bean.login.QuickPassageExample;

public interface QuickPassageMapper {
    long countByExample(QuickPassageExample example);

    int deleteByExample(QuickPassageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuickPassage record);

    int insertSelective(QuickPassage record);

    List<QuickPassage> selectByExample(QuickPassageExample example);

    QuickPassage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuickPassage record, @Param("example") QuickPassageExample example);

    int updateByExample(@Param("record") QuickPassage record, @Param("example") QuickPassageExample example);

    int updateByPrimaryKeySelective(QuickPassage record);

    int updateByPrimaryKey(QuickPassage record);
}