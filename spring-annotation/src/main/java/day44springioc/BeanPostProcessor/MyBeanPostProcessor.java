package day44springioc.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor,Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+"************** MyBeanPostProcessor  postProcessBeforeInitialization **************");
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+ "************** MyBeanPostProcessor  postProcessAfterInitialization **************");
		return bean;
	}

	public int getOrder() {
		return 1;
	}

}
