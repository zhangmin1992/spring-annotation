package day02bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 Dog构造方法
 bean实现了BeanNameAware接口，就调用回调方法
 bean实现了BeanFactoryAware接口，就调用回调方法
 bean实现了ApplicationContextAware接口，就调用回调方法
 调用BeanPostProcessor的初始化预处理方法postProcessBeforeInitialization方法
 @PostConstruct 标注的方法
 bean 实现了 InitializingBean 就调用 afterPropertiesSet 方法
 bean被定义的时候自定义的初始化方法
 调用BeanPostProcessor的初始化后置处理方法postProcessAfterInitialization方法
 bean可以被使用了
 容器关闭后的方法
 @PreDestroy 标记的销毁方法
 DisposableBean 的销毁方法
 bean被定义的时候自定义的销毁方法
 */
public class Dog implements InitializingBean,DisposableBean,BeanNameAware,BeanFactoryAware,ApplicationContextAware {
	
	public void destroy() throws Exception {
		System.out.println("----DisposableBean -destroy-------");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("---InitializingBean--afterPropertiesSet-------");
	}
	
	public Dog() {
		System.out.println("---Dog----");
	}
	
	public void init() {
		System.out.println("-----Dog init----");
	}
	
	public void destory() {
		System.out.println("-----Dog destory----");
	}
	
	public void hello(){
		System.out.println("------Dog hello-----");
	}
	
	@PostConstruct
	public void PostConstruct() {
		System.out.println("------Dog PostConstruct-----");
	}
	
	@PreDestroy
	public void PreDestroy() {
		System.out.println("------Dog PreDestroy-----");
	}

	public void setBeanName(String name) {
		System.out.println("-----BeanNameAware----");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("----BeanFactoryAware---");
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("------ApplicationContextAware---");
	}
}
