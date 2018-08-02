package day07lazyload;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import day02bean.Person;

public class App {

	public static void main(String[] args) {
		/**
		 * 默认单例模式下，我们在ioc容器启动的时候就会创建对象放入容器中
		 * 下面我们用懒加载的方式，在使用的时候再调用构造方法放入对象，以后每次获取直接从容器中取对象
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		System.out.println(applicationContext.getBean("myperson"));
		System.out.println(applicationContext.getBean("myperson"));
	}

}
