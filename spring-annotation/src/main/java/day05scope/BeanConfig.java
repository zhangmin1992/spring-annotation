package day05scope;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import day02bean.Person;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
public class BeanConfig {

	//@Scope("singleton")
	//@Scope("prototype")
	//reuest web环境下一个reuest一个对象
	//session web换将下一个session一个对象
	@Bean
	public Person myperson() {
		System.out.println("给容器添加person");
		return new Person("zhangmin");
	}
}
