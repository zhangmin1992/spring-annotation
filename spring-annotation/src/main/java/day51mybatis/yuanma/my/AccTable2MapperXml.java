package day51mybatis.yuanma.my;

import java.util.HashMap;
import java.util.Map;

/**
 *   AccTable2MapperXml 对应生成的实体
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Jun 28, 2019 6:15:16 PM
 */
public class AccTable2MapperXml {

	/**
	 * 设置final 是变量不可变
	 */
	public static final String nameSpace = "day51mybatis.yuanma.my.AccTable2Mapper";
	
	public static final Map<String, String> methodSqlMapping = new HashMap<String, String>();
	
	static {
		methodSqlMapping.put("selectByPrimaryKey", "select * from acc_table2  where id = %d");
	}
}
