package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResidentMapper {
    long countByExample(ResidentExample example);

    int deleteByExample(ResidentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Resident record);

    int insertSelective(Resident record);

    List<Resident> selectByExample(ResidentExample example);

    Resident selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Resident record, @Param("example") ResidentExample example);

    int updateByExample(@Param("record") Resident record, @Param("example") ResidentExample example);

    int updateByPrimaryKeySelective(Resident record);

    int updateByPrimaryKey(Resident record);
}