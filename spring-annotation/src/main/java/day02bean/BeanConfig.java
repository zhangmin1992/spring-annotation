package day02bean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
@ComponentScan("day02bean")
public class BeanConfig {

	@Bean(name="myperson01",initMethod="init")
	public Person myperson() {
		return new Person("zhangmin");
	}
	
	//@Scope("prototype")
	/*@Bean(initMethod="init",destroyMethod="destory")
	public Dog Dog() {
		return new Dog();
	}*/
}
