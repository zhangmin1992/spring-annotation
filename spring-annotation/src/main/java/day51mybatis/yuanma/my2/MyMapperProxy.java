package day51mybatis.yuanma.my2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import day51mybatis.yuanma.my2.MapperRegistroy.MapperData;

public class MyMapperProxy<T> implements InvocationHandler {

	private MySqlSession mySqlSession;
	
	public MyMapperProxy(MySqlSession mySqlSession) {
		this.mySqlSession = mySqlSession;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(method.getDeclaringClass().getName());
		if(method.getDeclaringClass().getName().equals(AccTable2MapperXml.nameSpace)){
			MapperData mapperData = MapperRegistroy.methodSqlMapping.get(method.getName());
			System.out.println("MyMapperProxy执行 "+ method.getDeclaringClass().getName() + "sql:" + mapperData.getKey());
			return mySqlSession.selectOne(mapperData, args[0]);
		}
		return null;
	}

}
