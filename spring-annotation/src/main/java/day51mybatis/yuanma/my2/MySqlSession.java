package day51mybatis.yuanma.my2;

import java.lang.reflect.Proxy;

import day51mybatis.yuanma.my2.MapperRegistroy.MapperData;

public class MySqlSession {

	private MyExcutor excutor;
	
	private MyConfiguration configuration;
	
	
	public MySqlSession(MyConfiguration configuration,MyExcutor excutor) {
		this.excutor = excutor;
		this.configuration = configuration;
	}

	public <T> T selectOne(MapperRegistroy.MapperData<T> mapperData,Object param){
		return excutor.query(mapperData, param);
	}
	
	public <T> T getMapper(Class<T> clas){
		return (T)Proxy.newProxyInstance(
				clas.getClassLoader(),
				new Class[]{clas},
				new MyMapperProxy(this));
	}
}
