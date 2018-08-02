package day23Aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class MyAware implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware {

	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("ee");
		this.applicationContext = applicationContext;
	}

	/**
	 * 解析器
	 */
	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String value = resolver.resolveStringValue("您好，我是${my.name},我今年 #{20*8} 岁了");
		System.out.println(value);
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("当前bean的名称"+name);
	}

}
