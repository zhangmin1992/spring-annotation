package day40BeanDefinitionRegistryPostProcessor;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanDefinitionRegistryPostProcessor 可以向容器中定义bean，beanfoctory就是按照BeanDefinitionRegistry保存的信息来创建bean实例的
 * 他优先于BeanFactoryPostProcessor的执行，为什么说优先于他执行呢，跟ioc容器的加载过程有关
 * 看PostProcessorRegistrationDelegate 下，先找到BeanDefinitionRegistryPostProcessor类型的，
 * 实现PriorityOrdered 接口的>order接口的>没有排序接口的，排序数值越小越先执行
 * 先触发postProcessBeanDefinitionRegistry ，后触发postProcessBeanFactory
 * 再找到的是BeanFactoryPostProcessor类型的
 * 
 * BeanFactoryPostProcessor执行的时机是工厂已经标准初始化完成，bean定义完成但是没有实例化的时候执行的
 * 是在组件的构造器执行之前创建的
 * 同时，实现PriorityOrdered 接口的>order接口的>没有排序接口的，排序数值越小越先执行
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("day40BeanDefinitionRegistryPostProcessor");
		System.out.println("----end-----");
    	
    	
	}
}
