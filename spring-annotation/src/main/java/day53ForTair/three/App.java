package day53ForTair.three;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  one包的源码解析
	* @author zhangmin 
	* @date Oct 11, 2019 6:22:44 PM
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(BeanConfig.class);
		bizImpl bizImpl = applicationContext.getBean(bizImpl.class);
		bizImpl.show();
		bizImpl.put();
		System.out.println(bizImpl.get());
	}
}
