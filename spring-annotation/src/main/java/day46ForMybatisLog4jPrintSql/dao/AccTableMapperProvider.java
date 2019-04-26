package day46ForMybatisLog4jPrintSql.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
/**
 * 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 7:30:07 PM
 */
public class AccTableMapperProvider {

	public String selectByActivityNameForProvider3(@Param("activityName") final String activityName, 
			@Param("id") final Integer id) {
		return new  SQL() {
			{
				SELECT("*");
				FROM("acc_table");
	            WHERE("activity_name = " + activityName + " and id = " + id);
			}
		}.toString();
	}
	public String selectByActivityNameForProvider2(Map<String, Object> map) {
		final String activityName = (String) map.get("activityName");
		final Integer id = (Integer) map.get("id");
		return new  SQL() {
			{
				SELECT("*");
				FROM("acc_table");
				WHERE("activity_name = " + activityName + " and id = " + id);
			}
		}.toString();
	}
}
