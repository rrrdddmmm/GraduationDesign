package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseTask;
import java.util.Date;
import org.apache.ibatis.annotations.Param;

public interface BaseTaskMapper {
    int deleteByPrimaryKey(@Param("projectid") String projectid, @Param("email") String email, @Param("startuptime") Date startuptime);

    int insert(BaseTask record);

    int insertSelective(BaseTask record);

    BaseTask selectByPrimaryKey(@Param("projectid") String projectid, @Param("email") String email, @Param("startuptime") Date startuptime);

    int updateByPrimaryKeySelective(BaseTask record);

    int updateByPrimaryKey(BaseTask record);
}