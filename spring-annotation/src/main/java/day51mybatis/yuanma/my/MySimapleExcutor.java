package day51mybatis.yuanma.my;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import day51mybatis.yuanma.AccTable2;

public class MySimapleExcutor implements MyExcutor {

	public <T> T query(String sql,Object param) {
		try {
			Connection connection = getConnection();
			String formatSql = String.format(sql, Integer.parseInt(String.valueOf(param.toString())));
			PreparedStatement pstmt = connection.prepareStatement(formatSql);
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
			System.out.println("异常"+e);
			return null;
		}
	}
	
	private Connection getConnection() {
		String driver = "com.mysql.jdbc.Driver";
		String url ="jdbc:mysql://rm-2ze707l6b0440gg1pxo.mysql.rds.aliyuncs.com:3306/mercury_test_01";
		String username = "heimdallr";
		String password = "7HGDeJLnH8a3";
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
