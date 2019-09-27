package day51mybatis.yuanma.my2;

import java.util.HashMap;
import java.util.Map;

import day51mybatis.yuanma.AccTable2;

/**
 *   注册你的mapper
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jul 1, 2019 11:31:03 AM
 */
public class MapperRegistroy {
	
	public static final Map<String, MapperData> methodSqlMapping = new HashMap<String, MapperData>();
	
	public MapperRegistroy() {
		methodSqlMapping.put("selectByPrimaryKey", 
				new MapperData("select * from acc_table2  where id = %d ",AccTable2.class));
	}
	
	class MapperData<T> {
		private String key;
		
		private Class<T> type;
		
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Class<T> getType() {
			return type;
		}
		public void setType(Class<T> type) {
			this.type = type;
		}
		public MapperData(String key, Class<T> type) {
			super();
			this.key = key;
			this.type = type;
		}
	}
}
