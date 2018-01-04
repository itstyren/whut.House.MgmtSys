package com.computerdesign.whutHouseMgmt.dao.user;

import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturn;
import com.computerdesign.whutHouseMgmt.bean.user.UserLoginReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLoginReturnMapper {
    long countByExample(UserLoginReturnExample example);

    int deleteByExample(UserLoginReturnExample example);

    int insert(UserLoginReturn record);

    int insertSelective(UserLoginReturn record);

    List<UserLoginReturn> selectByExample(UserLoginReturnExample example);

    int updateByExampleSelective(@Param("record") UserLoginReturn record, @Param("example") UserLoginReturnExample example);

    int updateByExample(@Param("record") UserLoginReturn record, @Param("example") UserLoginReturnExample example);
}