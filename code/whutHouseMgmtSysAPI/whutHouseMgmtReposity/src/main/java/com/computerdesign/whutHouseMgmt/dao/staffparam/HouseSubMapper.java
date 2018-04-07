package com.computerdesign.whutHouseMgmt.dao.staffparam;

import com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSub;
import com.computerdesign.whutHouseMgmt.bean.staffparam.HouseSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseSubMapper {
    long countByExample(HouseSubExample example);

    int deleteByExample(HouseSubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HouseSub record);

    int insertSelective(HouseSub record);

    List<HouseSub> selectByExample(HouseSubExample example);

    HouseSub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HouseSub record, @Param("example") HouseSubExample example);

    int updateByExample(@Param("record") HouseSub record, @Param("example") HouseSubExample example);

    int updateByPrimaryKeySelective(HouseSub record);

    int updateByPrimaryKey(HouseSub record);
}