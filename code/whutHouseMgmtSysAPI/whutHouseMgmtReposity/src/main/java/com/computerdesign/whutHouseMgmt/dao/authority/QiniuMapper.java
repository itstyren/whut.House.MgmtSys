package com.computerdesign.whutHouseMgmt.dao.authority;

import com.computerdesign.whutHouseMgmt.bean.authority.Qiniu;
import com.computerdesign.whutHouseMgmt.bean.authority.QiniuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QiniuMapper {
    long countByExample(QiniuExample example);

    int deleteByExample(QiniuExample example);

    int insert(Qiniu record);

    int insertSelective(Qiniu record);

    List<Qiniu> selectByExample(QiniuExample example);

    int updateByExampleSelective(@Param("record") Qiniu record, @Param("example") QiniuExample example);

    int updateByExample(@Param("record") Qiniu record, @Param("example") QiniuExample example);
}