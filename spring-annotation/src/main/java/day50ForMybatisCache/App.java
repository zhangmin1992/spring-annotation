package day50ForMybatisCache;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;

import day49ForMybatisDiscriminator.AccDiscriminatorMapper;

/**
 *   功能点6:mybatis 一级缓存，
	 在一个sqlSession中，相同2次查询只会执行一次
	 
	 功能点7:使用二级缓存，作用域是整个sqlsessionFactory
	 
	 功能点8：mybatis整合enchache二级缓存
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 3:48:19 PM
 */
public class App {

	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextForDay51.xml");
		AccEncacheMapper accEncacheMapper = context.getBean(AccEncacheMapper.class);
		List<AccEncache> AccEncache1 = accEncacheMapper.selectAll();
		System.out.println(JSONObject.toJSONString(AccEncache1));
		List<AccEncache> AccEncache2 = accEncacheMapper.selectAll();
		System.out.println(JSONObject.toJSONString(AccEncache2));
	}
}
