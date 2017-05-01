package com.xkd.mybatisgenerator.dao;

import com.xkd.mybatisgenerator.model.BaseHomeinformation;
import org.apache.ibatis.annotations.Param;

public interface BaseHomeinformationMapper {
    int deleteByPrimaryKey(@Param("projectNo") Integer projectNo, @Param("email") String email);

    int insert(BaseHomeinformation record);

    int insertSelective(BaseHomeinformation record);
}