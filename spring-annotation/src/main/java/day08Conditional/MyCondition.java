package day08Conditional;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import day02bean.Person;

@Component
public class MyCondition implements Condition{

	/**
	 * 根据上下文决定是否装配bean
	 * ConditionContext 表示应用上下文
	 * AnnotatedTypeMetadata 注释信息
	 */
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		//得到容器使用的beanFactory
		BeanFactory beanFactory = context.getBeanFactory();
		
		//获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		
		//可以查看或移除或者注入一个bean的定义
		BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();
		boolean result = beanDefinitionRegistry.containsBeanDefinition("haha");
		System.out.println("当前环境中是否存在 haha对象:"+result);
		
		//向容器中注入haha对象
		BeanDefinitionBuilder beanBuilder = BeanDefinitionBuilder.rootBeanDefinition(Person.class);
		BeanDefinition beanDefinition = beanBuilder.getBeanDefinition();
		beanDefinitionRegistry.registerBeanDefinition("haha",beanDefinition);
		
		String value = context.getEnvironment().getProperty("os.name");
		if("Mac OS X".equals(value)) {
			return true;
		}else {
			return false;
		}
	}
}
