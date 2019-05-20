package day48ForMybatisLayzyLoad;

import org.apache.ibatis.annotations.Param;

import day48ForMybatisLayzyLoad.AccUser;

public interface AccUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccUser record);

    int insertSelective(AccUser record);

    AccUser selectByPrimaryKey(Integer id);
    
    AccUser selectByName(@Param("id") Integer id,@Param("name") String name);

    int updateByPrimaryKeySelective(AccUser record);

    int updateByPrimaryKey(AccUser record);
}