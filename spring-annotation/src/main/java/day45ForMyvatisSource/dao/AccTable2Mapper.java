package day45ForMyvatisSource.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import day45ForMyvatisSource.entity.AccTable2;
import day45ForMyvatisSource.entity.AccTableTemp;
import day46ForMybatisLog4jPrintSql.dao.AccTableMapperProvider;

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
    List<AccTable2> selectByIds(@Param("ids") String[] ids);
    
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
    
    List<Map<String,String>> groupByAndReturnMap();
    

    @MapKey("holiday_date")
    @Select("SELECT mm.holiday_date,mm.activity_name FROM acc_table2 mm\n" + 
    		"	WHERE 1=1\n" + 
    		"	group by mm.activity_name")
    Map<Date,Map<Date,String>> groupByAndReturnMap2();
    
    @MapKey("date")
    @Select("SELECT mm.holiday_date as date,mm.activity_name as name FROM acc_table2 mm\n" + 
    		"	WHERE 1=1\n" + 
    		"	group by mm.activity_name")
    Map<Date,AccTableTemp> groupByAndReturnMap3();
    
    int batchUpdateByPrimaryKey(@Param("lists") List<AccTable2> lists);

}