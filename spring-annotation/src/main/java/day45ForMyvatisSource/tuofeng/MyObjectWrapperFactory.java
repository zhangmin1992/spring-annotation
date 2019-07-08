package day45ForMyvatisSource.tuofeng;

import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.springframework.stereotype.Component;

/**
 *  数据库字段转化驼峰的对象处理工厂操作
 *  加Component注解！！！！，注入myObjectWrapperFactory的bean
 *  和xml这句话相互对应<property name="objectWrapperFactory" ref="myObjectWrapperFactory"></property>
	* @Description: TODO(这里用一句话描述这个类的作用) 
	* @author zhangmin 
	* @date Apr 22, 2019 2:53:45 PM
 */
@Component
public class MyObjectWrapperFactory implements ObjectWrapperFactory {

	//判断当object 是 Map 类型时，返回 true
	public boolean hasWrapperFor(Object object) {
		boolean result =  object != null && object instanceof Map;
		return result;
	}

	//返回一个可以处理 key 为驼峰的 Wrapper
	public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
		return new CustomWrapper(metaObject, (Map) object);
	}
}
