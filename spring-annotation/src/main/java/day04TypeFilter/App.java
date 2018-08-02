package day04TypeFilter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import day03ComponentScan.BeanConfig;
import day03ComponentScan.BookDao;
import day03ComponentScan.PersonDao;
import day03ComponentScan.PersonService;


public class App {

	public static void main(String[] args) {
		/**
		 * day03包扫描xml方式
		 */
		/*ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
		BookDao bean = (BookDao) applicationContext.getBean(BookDao.class);
		bean.test();*/
		
		/**
		 * day03注解方式
		 * applicationContext.getBeanDefinitionNames()用来获取容器中的注入的bean名字
		 */
		/*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		BookDao bean = (BookDao) applicationContext.getBean(BookDao.class);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		bean.test();
		
		PersonDao bean2 = (PersonDao) applicationContext.getBean(PersonDao.class);
		bean2.test();
		
		OtherDao bean3 = (OtherDao) applicationContext.getBean(OtherDao.class);
		bean3.test();*/
		
		/**
		 * day04详细解释MyTypeFilter，需要自己编写自定义类型过滤器MyTypeFilter
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("----"+beanName);
		}
//		BookDao bean = (BookDao) applicationContext.getBean(BookDao.class);
//		bean.test();
//		
//		PersonDao bean2 = (PersonDao) applicationContext.getBean(PersonDao.class);
//		bean2.test();
//		
//		PersonService bean3 = (PersonService) applicationContext.getBean(PersonService.class);
//		bean3.test();
	}

}
