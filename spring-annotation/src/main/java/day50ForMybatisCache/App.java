package day50ForMybatisCache;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import day45ForMyvatisSource.dao.AccTable2Mapper;
import day45ForMyvatisSource.entity.AccTable2;
import day46ForMybatisLog4jPrintSql.entity.AccTable;

/**
 *   功能点6:mybatis 一级缓存，
	 在一个sqlSession中，相同2次查询只会执行一次
	 
	 功能点7:使用ClassPathXmlApplicationContext方式下
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 3:48:19 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(JSONObject.toJSONString(context.getBeanDefinitionNames()));
		AccTable2Mapper accTable2Mapper = context.getBean(AccTable2Mapper.class);
		AccTable2 accTable2 = accTable2Mapper.selectByPrimaryKey(10);
		System.out.println(JSONObject.toJSONString(accTable2));
		accTable2.setActivityName("测试和我一样");
		AccTable2 accTable3 = accTable2Mapper.selectByPrimaryKey(10);
		System.out.println(JSONObject.toJSONString(accTable3));
		context.close();
		
//		InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml"); 
//		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  
//        SqlSessionFactory factory = builder.build(inputStream);  
//          
//        //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作  
//        SqlSession sqlSession = factory.openSession();
//        AccTable accTable = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByPrimaryKey", 10);
//        System.out.println(JSONObject.toJSONString(accTable));
//        
//        accTable.setActivityName("测试和我一样");
//        AccTable accTable2 = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByPrimaryKey", 10);
//        System.out.println(JSONObject.toJSONString(accTable2));
//        sqlSession.close();
        
	}
}
