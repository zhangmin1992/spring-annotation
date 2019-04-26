package day47ForMybatisMapperAgent;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 3:48:19 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		//1.读取配置文件，从配置文件获取数据库链接信息，创造一个SqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml"); 
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();  
        SqlSessionFactory factory = builder.build(inputStream);  
          
        //2. 从SqlSession工厂 SqlSessionFactory中创建一个SqlSession，进行数据库操作  
        SqlSession sqlSession = factory.openSession();
        
        //3.xml方式查询1条记录的功能
        //Map<String, Object> map = new HashMap<String, Object>();
		//map.put("activityName", "888");
		//map.put("id", "19");
		//AccLegalTable accTable6 = sqlSession.selectOne("day47ForMybatisMapperAgent.AccLegalTableMapper.selectByActivityName",map);
	    //System.out.println(JSONObject.toJSONString("---"+accTable6));
        
        //4.xml方式查询多条记录的功能
        //List<AccLegalTable> accTable7 = sqlSession.selectList("day47ForMybatisMapperAgent.AccLegalTableMapper.selectByActivityName2","888");
        //System.out.println("---"+JSONObject.toJSONString(accTable7));
        
        //5.测试插入字符串时间
        Map<String, Object> map = new HashMap<String, Object>();
      	map.put("activityName", "888");
      	map.put("holidayDate", "2019-05-01");
        int result = sqlSession.insert("day47ForMybatisMapperAgent.AccLegalTableMapper.myinsert", map);
        System.out.println(result);
        
        //5.动态代理查询多条记录的功能
//        MyMapperProxy myMapperProxy = new MyMapperProxy(AccLegalTableMapper.class,sqlSession);
//        AccLegalTableMapper accLegalTable = (AccLegalTableMapper) Proxy.newProxyInstance (
//        		Thread.currentThread().getContextClassLoader(),
//        		new Class[]{AccLegalTableMapper.class},
//        		myMapperProxy);
//        List<AccLegalTable> accTable3 = accLegalTable.selectByActivityName2("888");
//        System.out.println("---"+JSONObject.toJSONString(accTable3));
		sqlSession.commit();
        sqlSession.close();
        
	}
}
