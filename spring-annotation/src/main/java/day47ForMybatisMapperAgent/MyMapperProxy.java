package day47ForMybatisMapperAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;

/**
 * 功能点1:mybatis为什么没有实现类就可以调用成功呢？
 *  mybatis用了动态代理
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 19, 2019 7:22:39 PM
 */
public class MyMapperProxy<T> implements InvocationHandler {

	private Class<T> mapperinterface;
	
	private SqlSession sqlSession;
	 
	public MyMapperProxy(Class<T> mapperinterface, SqlSession sqlSession ) {
		this.mapperinterface = mapperinterface;
		this.sqlSession = sqlSession; 
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String addr = mapperinterface.getCanonicalName() + "." + method .getName();
		System.out.println("addr="+addr);
		List<T> list = sqlSession.selectList(addr,args[0]);
		System.out.println(JSONObject.toJSONString(list));
		return list;
	}

}
