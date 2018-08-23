package day11ForJidong;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import day00ForProperties.RedisProperties;

/**
 * springboot项目可以自动加载application.properties文件，并且赋值到Environment中
 * spring项目需要指定加载application.properties文件，并且Environment中没有加载的值
 * 不知道怎么用实现注解方式启动的时候加载资源文件
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		
		
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("day11ForJidong");
		
		/**
		 * xml方式下让spring加载application.properties文件并获取资源值
		 */
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		PropertiesBean bean = context.getBean(PropertiesBean.class);
		System.out.println("-----"+bean.getRedis());
		System.out.println("-----"+context.getBean(Environment.class).getProperty("my.chooice.redis"));
		
		//context.getBean(PropertyPlaceholderConfigurer.class).setLocation(new Resource().createRelative(""));
		context.close();
		System.out.println("----end-----");
	}
}
