package day44springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("----MyBeanDefinitionRegistryPostProcessor  postProcessBeanFactory 回调");
	}

	//添加定义bean
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("-----MyBeanDefinitionRegistryPostProcessor --- 添加bean了---");
		RootBeanDefinition helloBean = new RootBeanDefinition(Dog.class);
		registry.registerBeanDefinition("hei", helloBean);
	}

}
