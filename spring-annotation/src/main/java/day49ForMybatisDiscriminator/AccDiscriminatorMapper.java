package day49ForMybatisDiscriminator;

import day49ForMybatisDiscriminator.entity.AccDiscriminator;

public interface AccDiscriminatorMapper {
    
    AccDiscriminator selectByPrimaryKey(Long id);
    
    int updateByPrimaryKeySelective(AccDiscriminator record);
}