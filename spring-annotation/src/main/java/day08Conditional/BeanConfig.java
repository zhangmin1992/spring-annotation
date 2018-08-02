package day08Conditional;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import day02bean.Person;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
public class BeanConfig {

	/**
	 * @Conditional可以标记在类上或者方法上
	 * @return
	 */
	@Conditional(MyCondition.class)
	@Bean(name="mac")
	public Person myperson() {
		return new Person("mac");
	}
	
	@Conditional(MyCondition2.class)
	@Bean(name="windows")
	public Person myperson2() {
		return new Person("windows");
	}
}
