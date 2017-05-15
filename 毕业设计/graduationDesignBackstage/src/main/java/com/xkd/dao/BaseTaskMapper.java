package com.xkd.dao;

import com.xkd.entity.BaseTask;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

public interface BaseTaskMapper {
    int deleteByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email, @Param("startuptime") Date startuptime);

    int insert(BaseTask record);

    int insertSelective(BaseTask record);

    BaseTask selectByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email, @Param("startuptime") Date startuptime);

    int updateByPrimaryKeySelective(BaseTask record);

    int updateByPrimaryKey(BaseTask record);
}