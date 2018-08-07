package day40BeanDefinitionRegistryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * BeanDefinitionRegistry bean定义信息的保存中心，beanfoctory就是按照BeanDefinitionRegistry保存的信息来创建bean实例的
	 * 因此我们在这里注册的bean会在后期被加入到spring容器中
	 */
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println(registry.getBeanDefinitionCount());
		RootBeanDefinition beanDefinition = new RootBeanDefinition(Dog.class);
		registry.registerBeanDefinition("myDog", beanDefinition);
	}

}
