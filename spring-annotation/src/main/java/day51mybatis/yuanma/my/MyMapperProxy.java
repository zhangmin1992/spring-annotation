package day51mybatis.yuanma.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy<T> implements InvocationHandler {

	private MySqlSession mySqlSession;
	
	public MyMapperProxy(MySqlSession mySqlSession) {
		this.mySqlSession = mySqlSession;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getDeclaringClass().getName().equals(AccTable2MapperXml.nameSpace)){
			String sql = AccTable2MapperXml.methodSqlMapping.get(method.getName());
			System.out.println(sql);
		    return mySqlSession.selectOne(sql, args[0]);
		}
		return null;
	}

}
