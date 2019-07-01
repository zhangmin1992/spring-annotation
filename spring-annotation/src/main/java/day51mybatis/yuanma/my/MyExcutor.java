package day51mybatis.yuanma.my;

public interface MyExcutor {

	public <T> T query(String sql,Object param);
}
