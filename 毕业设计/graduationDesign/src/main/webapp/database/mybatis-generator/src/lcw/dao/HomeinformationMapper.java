package lcw.dao;

import lcw.model.HomeinformationKey;

public interface HomeinformationMapper {
    int deleteByPrimaryKey(HomeinformationKey key);

    int insert(HomeinformationKey record);

    int insertSelective(HomeinformationKey record);
}