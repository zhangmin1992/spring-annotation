package day44springioc.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("------MyMergedBeanDefinitionPostProcessor---MergedBeanDefinitionPostProcessor");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("------MyMergedBeanDefinitionPostProcessor---postProcessAfterInitialization");
		return bean;
	}

	@Override
	public void postProcessMergedBeanDefinition(
			RootBeanDefinition beanDefinition, Class<?> beanType,
			String beanName) {
		System.out.println("------MyMergedBeanDefinitionPostProcessor---postProcessMergedBeanDefinition");
	}

}
