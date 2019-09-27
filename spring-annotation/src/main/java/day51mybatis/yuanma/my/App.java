package day51mybatis.yuanma.my;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import day51mybatis.yuanma.AccTable2;

/**
 *  1.0版本 缺点，
 *    配置文件的数据库连接配置写死的
 *    MySimapleExcutor的数据库连接和结果执行和结果赋值没有分开
 *  步骤：
 *  1.MyExcutor接口-public <T> T query(String sql,Object param);
 *  2.MySimapleExcutor实现类：有数据库连接，有sql执行
 *  3.MySqlSession类，注入了excutor，有个getMapper方法获取mapper的代理对象
 *  4.MyMapperProxy类，注入了MySqlSession，回调用MySqlSession的方法
 *  5.AccTable2MapperXml类-AccTable2MapperXml 对应生成的实体
 *  6.app测试类
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 1, 2019 10:58:51 AM
 */
public class App {

	public static void main(String[] args) throws IOException {
		 
        MySqlSession sqlSession = new MySqlSession();
        AccTable2Mapper accTable2Mapper = sqlSession.getMapper(AccTable2Mapper.class);
        AccTable2 accTable2 = accTable2Mapper.selectByPrimaryKey(10);
        System.out.println(accTable2.getActivityName());
	}
}
