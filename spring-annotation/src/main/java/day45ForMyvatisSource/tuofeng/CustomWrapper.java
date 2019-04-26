package day45ForMyvatisSource.tuofeng;

import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.MapWrapper;

/**
 *   不加@Component！！！
 *   字段一个个转化转驼峰的操作
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 2:55:31 PM
 */
public class CustomWrapper extends MapWrapper {

	public CustomWrapper(MetaObject metaObject, Map<String, Object> map) {
		super(metaObject, map);
	}
	
    public String findProperty(String name, boolean useCamelCaseMapping) {
    	System.out.println("--"+name);
        if (name.indexOf("_") >= 0) {
            return underlineToCamelhump(name);
        }
        return name;
    }
	
	/**
     * 将下划线风格替换为驼峰风格
     *
     * @param inputString
     * @return
     */
    public static String underlineToCamelhump(String inputString) {
       
    	StringBuilder sb = new StringBuilder();
        //下一个字符是否大写的标记
        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    	
        /**
    	 * google自带的比较麻烦不看了
    	 */
    	//return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,inputString);
    }
    
    public static void main(String[] args) {
    	System.out.println(underlineToCamelhump("my__name_hh"));
    }
	
}
