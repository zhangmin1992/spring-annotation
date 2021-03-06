package day11ForJidong;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * springboot项目可以自动加载application.properties文件，并且赋值到Environment中
 * spring项目需要指定加载application.properties文件，并且Environment中没有加载的值
 * 不知道怎么用实现注解方式启动的时候加载资源文件
 * 
 * spring注解加载资源文件，把资源文件的值放到bean中要用comment不能用bean
 * spring使用@Component+@PropertySource+@Value可以获取属性值${my.name}的值，怎么使用@Bean+@PropertySource+@Value获取的确实${my.name}！！！
 * 
 * 
	spring不可以直接用ConditionalOnProperty的原因的是spring不会再bean加载前就加载资源文件
	1.实现了根据资源环境配置来决定加载哪个bean这里用了@@Conditional没有直接用ConditionalOnProperty，因为资源文件还没加载
	2.xml方式加载资源文件并且将属性值赋值到bean中
	3.@PropertySource+@value+@bean不可用！！！！！要用@@Component才可以得到属性值
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		
		/**
		 * xml方式下让spring加载application.properties文件并获取资源值
		 */
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("name----"+name);
		}
		PropertiesBean bean = context.getBean(PropertiesBean.class);
		System.out.println("-----"+bean.getRedis());
		System.out.println("-----"+context.getBean(Environment.class).getProperty("my.chooice.redis"));
		context.close();
		System.out.println("----end-----");*/
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("name----"+name);
		}
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
		Properties  prop = new Properties();
        try {
			prop.load(is);
			String masterName = prop.getProperty("redis");
			System.out.println(masterName);
			System.out.println("-----"+context.getBean(Environment.class).getProperty("redis"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(context.getBean("redisProperties"));
		
		RedisProperties beanProperties = (RedisProperties) context.getBean("redisProperties");
		System.out.println("-----"+beanProperties.getPort());
		System.out.println("-----"+context.getBean(Environment.class).getProperty("redis"));
		
		context.close();
		System.out.println("----end-----");
	}
}
