package day44springioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

@Component
public class PriorityOrdered01BeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor,PriorityOrdered {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("----PriorityOrdered01BeanDefinitionRegistryPostProcessor  postProcessBeanFactory 回调");
	}

	//添加定义bean
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("---PriorityOrdered01BeanDefinitionRegistryPostProcessor-111111111----添加bean了");
	}

	public int getOrder() {
		return 1;
	}

}
