package day39BeanFactoryProcess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanFactoryPostProcessor执行的时机是工厂已经标准初始化完成，bean定义完成但是没有实例化的时候执行的
 * 是在组件的构造器执行之前创建的
 * 同时，实现PriorityOrdered 接口的>order接口的>没有排序接口的，排序数值越小越先执行
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("day39BeanFactoryProcess");
		System.out.println("----end-----");
    	
    	
	}
}
