package day00ForImportBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring 可以在包扫描的情况下注入@Component 标记的bean
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("day00ForImportBean");
    	System.out.println("---"+context.getBean(MyBean.class));
    	String[] namesString = context.getBeanDefinitionNames();
    	for (String name : namesString) {
			System.out.println("----------"+name);
		}
    	
		
	}

}
