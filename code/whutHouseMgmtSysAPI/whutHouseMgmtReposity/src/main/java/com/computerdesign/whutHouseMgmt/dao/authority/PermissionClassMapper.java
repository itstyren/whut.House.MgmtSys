package com.computerdesign.whutHouseMgmt.dao.authority;

import com.computerdesign.whutHouseMgmt.bean.authority.PermissionClass;
import com.computerdesign.whutHouseMgmt.bean.authority.PermissionClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionClassMapper {
    long countByExample(PermissionClassExample example);

    int deleteByExample(PermissionClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionClass record);

    int insertSelective(PermissionClass record);

    List<PermissionClass> selectByExample(PermissionClassExample example);

    PermissionClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionClass record, @Param("example") PermissionClassExample example);

    int updateByExample(@Param("record") PermissionClass record, @Param("example") PermissionClassExample example);

    int updateByPrimaryKeySelective(PermissionClass record);

    int updateByPrimaryKey(PermissionClass record);
}