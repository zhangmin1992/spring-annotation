package day09import;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * 针对//@Import(MyImportSelector.class) 和 @Bean同时存在的解决方案
 * 当前上下文环境中是否已经存在beanName=day09import.Dog的对象，如果不存在就创建，存在就不创建@Bean
 * @author yp-tc-m-7129
 *
 */
@Component
public class MyCondition implements Condition{

	/**
	 * 根据上下文决定是否装配bean
	 * ConditionContext 表示应用上下文
	 * AnnotatedTypeMetadata 注释信息
	 */
	
	public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
		BeanDefinitionRegistry beanDefinitionRegistry = context.getRegistry();
		boolean result = beanDefinitionRegistry.containsBeanDefinition("day09import.Dog");
		//boolean result = beanDefinitionRegistry.containsBeanDefinition("haha");
		System.out.println("当前环境中是否存在 day09import.Dog对象:"+result);
		if(result) {
			return false;
		}else {
			return true;
		}
		
	}
}
