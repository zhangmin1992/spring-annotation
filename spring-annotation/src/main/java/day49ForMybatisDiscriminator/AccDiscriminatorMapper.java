package day49ForMybatisDiscriminator;

import day49ForMybatisDiscriminator.AccDiscriminator;

public interface AccDiscriminatorMapper {
    
    AccDiscriminator selectByPrimaryKey(Long id);
}