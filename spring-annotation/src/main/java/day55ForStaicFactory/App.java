package day55ForStaicFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {

	public static void main(String[] args) {
		/**
		 * 静态工厂注入bean
		 */
//        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
//		Person bean = (Person) applicationContext.getBean("car1");
//		System.out.println(bean.getName());

        /**
         * 实例工厂注入bean
         */
        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
        Person bean = (Person) applicationContext.getBean("car1");
        System.out.println(bean.getName());
		
	}

}
