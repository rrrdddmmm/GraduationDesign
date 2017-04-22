package dao;

import model.Project;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer projectNo);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer projectNo);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}