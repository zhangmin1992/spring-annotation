package day47ForMybatisMapperAgent;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AccLegalTableMapper { 
	
    @Select("select * from acc_legal_table where activity_name=#{activityName} and id=#{id}")
    AccLegalTable selectByActivityName(@Param("activityName") String activityName,@Param("id") Integer id);
    
    @Select("select * from acc_legal_table where activity_name=#{activityName}")
    List<AccLegalTable> selectByActivityName2(String activityName);
    
    @Insert("insert into acc_legal_table (holiday_date, activity_name ) values (#{holidayDate}, #{activityName})")
    int myinsert(@Param("holidayDate") String holidayDate,@Param("activityName") String activityName);
}