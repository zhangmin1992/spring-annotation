package day39BeanFactoryProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryProcess implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("--------------postProcessBeanFactory---------------");
		System.out.println("当前容器中有几个bean" + beanFactory.getBeanDefinitionCount());
		//bean工厂中获取这个类型的beanname的数组
		String[] names = beanFactory.getBeanNamesForType(Dog.class, true, true);
		//String[] names = beanFactory.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		
	}

}
