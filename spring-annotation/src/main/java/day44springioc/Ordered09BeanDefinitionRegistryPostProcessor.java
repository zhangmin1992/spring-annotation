package day44springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class Ordered09BeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,Ordered {

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("----Ordered09BeanDefinitionRegistryPostProcessor --- postProcessBeanFactory 回调");
	}

	@Override
	//添加定义bean
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("----999999999--Ordered09BeanDefinitionRegistryPostProcessor--添加bean了");
	}

	@Override
	public int getOrder() {
		return 9;
	}

}
