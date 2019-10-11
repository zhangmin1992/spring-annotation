package day53ForTair.two;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;


public class App {

	public static void main(String[] args) {
		/**
		 * xml方式
		 */
		/*ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("applicationContextForDay53two.xml");
		bizImpl bizImpl = applicationContext.getBean(bizImpl.class);
		bizImpl.show();
		bizImpl.put();
		System.out.println(bizImpl.get());
		bizImpl.put2();
		System.out.println(JSONObject.toJSONString(bizImpl.get2()));
		*/
		
		/**
		 * 注解方式,加载的时候用的是默认的构造方法，有参构造方法不会执行
		 */
		ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(BeanConfig.class);
		TairClientProperties tairClientProperties = applicationContext.getBean(TairClientProperties.class);
		System.out.println("----"+tairClientProperties.getLocalAppKey());
		GetTairClientProperties getTairClientProperties = applicationContext.getBean(GetTairClientProperties.class);
		getTairClientProperties.show();
		bizImpl bizImpl = applicationContext.getBean(bizImpl.class);
		bizImpl.show();
		bizImpl.put();
		System.out.println(bizImpl.get());
		bizImpl.put2();
		System.out.println(JSONObject.toJSONString(bizImpl.get2()));
	}
}
