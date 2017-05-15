package com.xkd.dao;

import com.xkd.entity.BaseHome;
import org.apache.ibatis.annotations.Param;

public interface BaseHomeMapper {
    int deleteByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email);

    int insert(BaseHome record);

    int insertSelective(BaseHome record);

    BaseHome selectByPrimaryKey(@Param("projectid") Integer projectid, @Param("email") String email);

    int updateByPrimaryKeySelective(BaseHome record);

    int updateByPrimaryKey(BaseHome record);
}