package day51mybatis.yuanma.my2;

import java.lang.reflect.Proxy;

public class MySqlSession {

	private MyExcutor excutor  = new MySimapleExcutor();
	
	private MyConfiguration configuration;
	
	
	public MySqlSession(MyConfiguration configuration,MyExcutor excutor) {
		super();
		this.excutor = excutor;
		this.configuration = configuration;
	}

	public <T> T selectOne(MapperRegistroy.MapperData<T> mapperData,Object parameter){
		return excutor.query(mapperData, parameter);
	}
	
	public <T> T getMapper(Class<T> clas){
		return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas}, new MyMapperProxy(this));
	}
}
