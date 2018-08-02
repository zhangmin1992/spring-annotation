package day44springioc;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import day44springioc.ApplicationListener.My02ApplicationListener;
import day44springioc.ApplicationListener.MyApplicationEvent;
import day44springioc.BeanPostProcessor.Person;
import day44springioc.ResourceBundleMessageSource.MyResourceBundleMessageSource;


public class App {

	public static void main(String[] args) {
		/**
		 * 包扫描方式测试spring容器加载顺序
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
		context.addApplicationListener(new My02ApplicationListener());
		context.publishEvent(new MyApplicationEvent("init-bean"));
		Dog Dog = context.getBean(Dog.class);
		context.getBean(Dog.class);
		Dog.jiao();
		Person Person = context.getBean(Person.class);
		Person.jiao();
		
		
		/**
		 * xml方式 测试资源文件国际化
		 */
		/*System.out.println("-----------测试资源文件国际化--------------");
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
		MessageSource messageSource = applicationContext.getBean(MessageSource.class);
		String msgUs  = messageSource.getMessage("foo.test", new Object[]{"jerry,{one}"}, Locale.US);
		System.out.println(msgUs);
		String msgChines  = messageSource.getMessage("foo.test", new Object[]{"小明,{1}"}, Locale.CHINESE);
		System.out.println(msgChines);*/
		
		/**
		 * 
		 *  注解方式 测试资源文件国际化
		 */
		/*MyResourceBundleMessageSource messageSource = context.getBean(MyResourceBundleMessageSource.class);
		messageSource.setBasenames("test_en_US","test_zh_CN");
		String msgUs  = messageSource.getMessage("foo.test", new Object[]{"jerry"}, Locale.US);
		System.out.println(msgUs);
		String msgChines  = messageSource.getMessage("foo.test", new Object[]{"小明"}, Locale.CHINESE);
		System.out.println(msgChines);*/
	}
}
