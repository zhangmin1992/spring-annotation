package day51mybatis.yuanma.my2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import day51mybatis.yuanma.AccTable2;

public class SatatementHandler {

	private MyConfiguration configuration;
	
	private ResultSetHandler resultSetHandler;

	public SatatementHandler(MyConfiguration configuration) {
		this.configuration = configuration;
		this.resultSetHandler = new ResultSetHandler(configuration);
	}
	
	public <T> T query(MapperRegistroy.MapperData<T> mapperData,Object param) {
		try {
			Connection connection = getConnection();
			String sql = mapperData.getKey(); 
			System.out.println("SatatementHandler执行 " + sql);
			String formatSql = String.format(sql, Integer.parseInt(String.valueOf(param.toString())));
			System.out.println("SatatementHandler执行 " + formatSql);
			PreparedStatement pstmt = connection.prepareStatement(formatSql);
			return resultSetHandler.handleResultSets(pstmt, mapperData);
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
