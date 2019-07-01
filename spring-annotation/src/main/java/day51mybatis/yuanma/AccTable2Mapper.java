package day51mybatis.yuanma;

import day51mybatis.yuanma.AccTable2;

public interface AccTable2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccTable2 record);

    int insertSelective(AccTable2 record);

    AccTable2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccTable2 record);

    int updateByPrimaryKey(AccTable2 record);
}