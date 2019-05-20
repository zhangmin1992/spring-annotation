package day46ForMybatisLog4jPrintSql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSONObject;

import day46ForMybatisLog4jPrintSql.entity.AccTable;


/**
 *  功能点1:mybatis 整合 log4j 打印sql语句
 *  1.编写配置文件mybatisConfig.xml，指定数据库连接，要加载的mapper.xml
 *  <property name="configLocation" value="classpath:mybatisConfig.xml"/> 
 *  2.配置文件引入 log4j.properties，设置日志级别是DEBUG:log4j.logger.day46ForMybatisLog4jPrintSql.dao =TRACE
 *  3.app 测试
 *    3.1读取配置文件
 *    3.2创建SqlSessionFactoryBuilder
 *    3.3通过SqlSessionFactoryBuilder创建SqlSession
 *    3.4SqlSession 的增删改查操作,注意，修改操作没有这句话是不会入库的！！！！！sqlSession.commit();
 *    
 *  功能点2:避免数据库新增字段后，实体新增后，还需要修改xml文件？
 *  在mybatis配置文件中加上这句话，<setting name="mapUnderscoreToCamelCase" value="true" />，
 *  可以避免数据库新增字段后，实体新增后，还需要修改xml文件的查询，删除修改等东西
 *  
 *   功能点3:mybatis插入或者insertSelective插入后，需要返回主健
 *   在mapper.xml配置文件中加入keyColumn="id" keyProperty="id" useGeneratedKeys="true"
 *   返回的int始终会是1！！，返回的主建在实体的id中！！只适用于支持主建自增的情况
 *   
 *   功能点4:不自增的数据库怎么返回主建--xml方式
 *   修改mapper.xml文件的insert 添加这么一段即可
 *   <selectKey keyColumn="id" resultType="int" keyProperty="id" order="AFTER" >
		SELECT LAST_INSERT_ID()
	  </selectKey>
	 mysql数据库是AFTER（当前序列值要insert语句成功后才能获取到），
	 oracle数据库是BEFORE（先从序列获取值，然后将值作为主键插入到数据库中 ）
	 
	 功能点4:注解方式在接口上，插入的时候返回主键
	 @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	 
	 功能点4:注解方式-非自增
	 非自增数据库的插入返回主键的注解方式--mysql
     @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty ="id",resultType = Integer.class,before = false)
	 
	 功能点5:mybatis 使用注解sql的时候自动转化驼峰模式
	 在加载的mybatisConfig文件中加一句话即可
	 
	 功能点6:mybatis 一级缓存，
	 在一个sqlSession中，相同2次查询只会执行一次
	 accTable2 的值随着accTable赋值的改变而改变！！
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 19, 2019 2:40:59 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		//1.读取配置文件，从配置文件获取数据库链接信息，创造一个SqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml"); 
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  
        SqlSessionFactory factory = builder.build(inputStream);  
          
         //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作  
          SqlSession sqlSession = factory.openSession();
//        AccTable accTable = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByPrimaryKey", 1);
//        System.out.println(JSONObject.toJSONString(accTable));
//        
//        //3.增加
//        AccTable accTable2 = new AccTable(new Date(), "888");
//        int result = sqlSession.insert("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.insertSelective",accTable2);
//        System.out.println(JSONObject.toJSONString(accTable2));
//		  System.out.println("返回的数据是"+result);
//		
//		//4.mybatis 使用返回自增的主建的xml方式
//		AccTable accTable3 = new AccTable(new Date(), "00000");
//        int result3 = sqlSession.insert("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.insert",accTable3);
//        System.out.println(JSONObject.toJSONString(accTable3));
//		System.out.println("返回的数据是"+result3);
//		
//		//5.使用注解方式操作主建
//		AccTable accTable4 = new AccTable(new Date(), "00000");
//        int result4 = sqlSession.insert("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.insertOneTest",accTable4);
//        System.out.println(JSONObject.toJSONString(accTable4));
//		System.out.println("返回的数据是"+result4);
//		
//		//6.mybatis 使用返回非自增的主建的注解方式
//		AccTable accTable5 = new AccTable(new Date(), "9919191");
//        int result5 = sqlSession.insert("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.insertOneTest2",accTable5);
//        System.out.println(JSONObject.toJSONString(accTable5));
//		System.out.println("返回的数据是"+result5);
//		
//		//7.多参数查询
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("activityName", "888");
//		map.put("id", 19);
//		AccTable accTable6 = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByActivityName",map);
//	    System.out.println(JSONObject.toJSONString(accTable6));
//	    
//	    //7.provider方式提供
//	    AccTable accTable7 = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByActivityName2",map);
//	    System.out.println(JSONObject.toJSONString(accTable7));
//	    
//	    AccTable accTable8 = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByActivityName3",map);
//	    System.out.println(JSONObject.toJSONString(accTable8));
	    
	    /**
	     * mybatis 一级缓存，在一个sqlSession中，相同2次查询只会执行一次
	     * accTable2 的值随着accTable赋值的改变而改变！！
	     */
	    AccTable accTable = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByPrimaryKey", 20);
        System.out.println(JSONObject.toJSONString(accTable));
        
        accTable.setActivityName("测试和我一样");
        AccTable accTable2 = sqlSession.selectOne("day46ForMybatisLog4jPrintSql.dao.AccTableMapper.selectByPrimaryKey", 20);
        System.out.println(JSONObject.toJSONString(accTable2));
        
		//4.修改操作没有这句话是不会入库的
		sqlSession.commit();
        sqlSession.close();
        
	}
}
