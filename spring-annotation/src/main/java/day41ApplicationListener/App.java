package day41ApplicationListener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import day44springioc.ApplicationListener.MyApplicationEvent;

/**
 * 事件声明的时候不用@Component注解
 * 事件监听器注册的时候需要@Component注解
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		/**
		 * 监听时间注册监听器的时候可以继承ApplicationListener<ApplicationEvent> 接口 或者 使用@EventListener
		 * MyApplicationListener 发布所有时间
		 * MyApplicationListener2  使用注解发布事件
		 * MyApplicationListener3 接口发布指定类型的事件
		 * 容器中有两个事件，
		 * org.springframework.context.event.ContextRefreshedEvent
		 * org.springframework.context.event.ContextClosedEvent
		 * 
		 * 1.容器创建refresh
		 * 2.容器创建的这一步finishRefresh()容器刷新完成
		 * 2.1publishEvent(new ContextRefreshedEvent(this));
		 * 事件发布流程：
		 * 2.2获取事件的多波器(派发器) getApplicationEventMulticaster()，然后执行事件派发multicastEvent
		 * 2.2.1获取所有的applicationlistner，如果有Executor，使用Executor进行一步派发
		 * 2.2.2 执行监听的方法invokeListener，回调他的listener.onApplicationEvent(event);方法
		 * 
		 * 容器初始化完成会发布事件publishEvent(new ContextRefreshedEvent(this));
		 * 容器关闭会发布这个时间publishEvent(new ContextClosedEvent(this));
		 * 
		 * 使用EventListenerMethodProcessor来解析@EventListener注解的，实现了一个接口SmartInitializingSingleton
		 * 里面有个afterSingletonsInstantiated方法，看注释说的是这个方法在所有单实例bean已经初始化完成后执行，这个回调类似于容器刷新完成的事件的顺序
		 * 具体位置在finishBeanFactoryInitialization-》的preInstantiateSingleton-》的afterSingletonsInstantiated
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("day41ApplicationListener");
		context.publishEvent(new MyApplicationEvent("我发布的事件"));
		//context.addApplicationListener(new MyApplicationListener());
		context.close();
		System.out.println("----end-----");
    	
    	
	}
}
