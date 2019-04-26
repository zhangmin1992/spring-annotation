package day46ForMybatisLog4jPrintSql.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;

import day46ForMybatisLog4jPrintSql.entity.AccTable;

public interface AccTableMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(AccTable record);

    int insertSelective(AccTable record);

    AccTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccTable record);

    int updateByPrimaryKey(AccTable record);
    
    //自增数据库的插入返回主键的注解方式
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into acc_table (holiday_date, activity_name ) values (CURRENT_DATE, '110100101' )")
    Integer insertOneTest(AccTable test);
    
    //非自增数据库的插入返回主键的注解方式--mysql
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty ="id",resultType = Integer.class,before = false)
    @Insert("insert into acc_table (holiday_date, activity_name ) values (CURRENT_DATE, '110100101' )")
    Integer insertOneTest2(AccTable test);
    
//    @Select("select * from acc_table where activity_name=#{activityName} and id=#{id}")
//    AccTable selectByActivityName(@Param("activityName") String activityName,@Param("id") Integer id);
    
    @Select("select * from acc_table where activity_name=#{activityName} and id=#{id}")
    AccTable selectByActivityName(String activityName,Integer id);
    
    @SelectProvider(method = "selectByActivityNameForProvider2", type = AccTableMapperProvider.class )
    AccTable selectByActivityName2(String activityName,Integer id);
    
    @SelectProvider(method = "selectByActivityNameForProvider3", type = AccTableMapperProvider.class )
    AccTable selectByActivityName3(String activityName,Integer id);
}