package day51mybatis.yuanma.my;

import java.lang.reflect.Proxy;

import org.apache.ibatis.session.Configuration;

public class MySqlSession {

	private MyExcutor excutor  = new MySimapleExcutor();
	
	//private Configuration configuration;
	
	public <T> T selectOne(String statement,Object parameter){
		return excutor.query(statement, parameter);
	}
	
	public <T> T getMapper(Class<T> clas){
		return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas}, new MyMapperProxy(this));
	}
}
