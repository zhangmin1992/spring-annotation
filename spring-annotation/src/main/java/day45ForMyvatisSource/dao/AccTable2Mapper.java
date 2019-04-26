package day45ForMyvatisSource.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import day45ForMyvatisSource.entity.AccTable2;

public interface AccTable2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccTable2 record);

    int insertSelective(AccTable2 record);

    AccTable2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccTable2 record);

    int updateByPrimaryKey(AccTable2 record);
    
    @Select("select * from acc_table2 where activity_name=#{activityName} and id=#{id}")
    AccTable2 selectByActivityName(@Param("activityName") String activityName,@Param("id") Integer id);
    
    /**
     * String[] 类型的
     */
    //List<AccTable2> selectByIds(@Param("ids") String[] ids);
    
    /**
     * ArrayList 类型的
     */
    List<AccTable2> selectByIds(@Param("ids") ArrayList<String> ids);
    
    /**
     * 批量插入
     */
    int batchInsert(@Param("lists") ArrayList<AccTable2> lists);
    
    /**
     * 要想返回批量插入主键的条件
     * 1.dao 层不能有@param注解
     */
    int batchInsert2(ArrayList<AccTable2> lists);

}