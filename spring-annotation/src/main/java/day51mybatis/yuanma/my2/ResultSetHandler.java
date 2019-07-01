package day51mybatis.yuanma.my2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import day51mybatis.yuanma.AccTable2;

/**
 * 数据库操作和结果处理分发
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 1, 2019 11:46:23 AM
 */
public class ResultSetHandler {

	private MyConfiguration configuration;
	
	public ResultSetHandler(MyConfiguration configuration) {
		this.configuration = configuration;
	}

	<T> T handleResultSets(PreparedStatement pstmt,MapperRegistroy.MapperData<T> mapperData) {
		try {
			ResultSet resultSet = pstmt.executeQuery();
			AccTable2 accTable2 = new AccTable2();
			while(resultSet.next()) {
				//id, holiday_date, activity_name, activity_name2
				accTable2.setId(resultSet.getInt(1));
				accTable2.setHolidayDate(new Date());
				accTable2.setActivityName(resultSet.getString(3));
				accTable2.setActivityName2(resultSet.getString(4));
			}
			return (T)accTable2;
		} catch (Exception e) {
			return null;
		}
	}
}
