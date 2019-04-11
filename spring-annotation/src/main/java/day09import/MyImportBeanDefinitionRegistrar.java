package day09import;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata 当前类注解信息
	 * BeanDefinitionRegistry bean定义的注册类
	 */
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,BeanDefinitionRegistry registry) {
		boolean result =  registry.containsBeanDefinition("haha");
		boolean result2 =  registry.containsBeanDefinition("dog");
		System.out.println("当钱容器中有haha对象或者dog对象吗？" + result);
		if(!result && !result2) {
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Dog.class);
			registry.registerBeanDefinition("haha", beanDefinition);
		}
		
	}

}
