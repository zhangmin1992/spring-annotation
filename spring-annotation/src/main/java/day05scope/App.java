package day05scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import day02bean.Person;

public class App {

	public static void main(String[] args) {
		/**
		 * 单实例方式下，在容器启动的时候就会调用方法创建对象到容器中，下次用就直接从容器中获取,
		 * 多实例下，容器启动并不会创建对象调用方法放入容器中，而是每次获取都会重新创建对象放入容器中
		 * 单实例方式下，在容器关闭的时候就会调用方法销毁bean，
		 * 多实例方式下，容器关闭的时候不会管理销毁bean，只能你手动销毁
		 *  给容器添加person
			com.zm.spring.annotation.day02bean.Person@51e2adc7
			com.zm.spring.annotation.day02bean.Person@51e2adc7
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		System.out.println(applicationContext.getBean("myperson"));
		System.out.println(applicationContext.getBean("myperson"));
	}

}
