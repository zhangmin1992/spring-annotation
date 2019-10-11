package day53ForTair.one;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("applicationContextForDay53one.xml");
		bizImpl bizImpl = applicationContext.getBean(bizImpl.class);
		bizImpl.show();
		bizImpl.put();
		System.out.println(bizImpl.get());
	}
}
