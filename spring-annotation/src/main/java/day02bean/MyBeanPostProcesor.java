package day02bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcesor implements BeanPostProcessor {

	/**
	 * 刚创建的实例，实例在容器中的名字
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("---MyBeanPostProcesor --postProcessBeforeInitialization-----"+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("---MyBeanPostProcesor --postProcessAfterInitialization-----"+beanName);
		return bean;
	}

}
