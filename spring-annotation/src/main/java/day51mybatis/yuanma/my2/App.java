package day51mybatis.yuanma.my2;

import java.io.IOException;

import day51mybatis.yuanma.AccTable2;

/**
 *  1.0版本 缺点，配置文件的数据库配置写死的
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 1, 2019 10:58:51 AM
 */
public class App {

	public static void main(String[] args) throws IOException {
		MyConfiguration configuration = new MyConfiguration();
		configuration.setScanPath("day51mybatis.yuanma.my2.AccTable2Mapper");
		configuration.build();
        MySqlSession sqlSession = new MySqlSession(configuration,new MySimapleExcutor());
        AccTable2Mapper accTable2Mapper = sqlSession.getMapper(AccTable2Mapper.class);
        AccTable2 accTable2 = accTable2Mapper.selectByPrimaryKey(10);
        System.out.println(accTable2.getActivityName());
	}
}
