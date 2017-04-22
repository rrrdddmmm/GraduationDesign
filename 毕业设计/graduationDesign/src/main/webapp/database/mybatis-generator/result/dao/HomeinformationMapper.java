package dao;

import model.HomeinformationKey;

public interface HomeinformationMapper {
    int deleteByPrimaryKey(HomeinformationKey key);

    int insert(HomeinformationKey record);

    int insertSelective(HomeinformationKey record);
}