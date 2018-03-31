package com.computerdesign.whutHouseMgmt.dao.houseregister;

import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResidentVwMapper {
    long countByExample(ResidentVwExample example);

    int deleteByExample(ResidentVwExample example);

    int insert(ResidentVw record);

    int insertSelective(ResidentVw record);

    List<ResidentVw> selectByExample(ResidentVwExample example);
    
    /**
     * 多住房统计：查询具有多个住房的住户信息
     * @param example
     * @return
     */
//    List<ResidentVw> selectMoreHouseInfo(ResidentVwExample example);
    
    /**
     * 获取拥有多套住房的职工staffId的List
     * @return
     */
    List<Integer> selectMoreHouseStaffId();

    int updateByExampleSelective(@Param("record") ResidentVw record, @Param("example") ResidentVwExample example);

    int updateByExample(@Param("record") ResidentVw record, @Param("example") ResidentVwExample example);
}