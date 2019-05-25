package com.computerdesign.whutHouseMgmt.dao.authority;

import com.computerdesign.whutHouseMgmt.bean.authority.AuthList;
import com.computerdesign.whutHouseMgmt.bean.authority.AuthListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthListMapper {
    long countByExample(AuthListExample example);

    int deleteByExample(AuthListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthList record);

    int insertSelective(AuthList record);

    List<AuthList> selectByExampleWithBLOBs(AuthListExample example);

    List<AuthList> selectByExample(AuthListExample example);

    AuthList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthList record, @Param("example") AuthListExample example);

    int updateByExampleWithBLOBs(@Param("record") AuthList record, @Param("example") AuthListExample example);

    int updateByExample(@Param("record") AuthList record, @Param("example") AuthListExample example);

    int updateByPrimaryKeySelective(AuthList record);

    int updateByPrimaryKeyWithBLOBs(AuthList record);

    int updateByPrimaryKey(AuthList record);
}