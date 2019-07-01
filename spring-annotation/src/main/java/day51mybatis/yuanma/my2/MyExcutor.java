package day51mybatis.yuanma.my2;

public interface MyExcutor {

	//public <T> T query(String sql,Object param);
	
	public <T> T query(MapperRegistroy.MapperData<T> mapperData,Object param);
}
