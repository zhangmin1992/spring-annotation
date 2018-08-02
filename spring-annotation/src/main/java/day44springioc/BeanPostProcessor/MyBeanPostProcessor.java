package day44springioc.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor,Ordered {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+"************** MyBeanPostProcessor  postProcessBeforeInitialization **************");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(beanName+ "************** MyBeanPostProcessor  postProcessAfterInitialization **************");
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}

}
