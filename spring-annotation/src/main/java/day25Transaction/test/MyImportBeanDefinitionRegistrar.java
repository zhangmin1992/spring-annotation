package day25Transaction.test;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

//不需要@compoent注入，在配置类中import
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,BeanDefinitionRegistry registry) {
		//得到源数据的注解，就是MyImportBeanDefinitionRegistrar被import的地方上的注解
		Set<String> annoTypes = importingClassMetadata.getAnnotationTypes();
		for (String annoType : annoTypes) {
			//得到注解的属性
			AnnotationAttributes candidate = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(annoType, false));
			Object mode = candidate.get("basePackages");
			//注册一个bean-dog
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Dog.class);
			beanDefinition.setSource(null);
			beanDefinition.getPropertyValues().add("name","youname"+UUID.randomUUID().toString().replaceAll("-", ""));
			beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
			registry.registerBeanDefinition("mydogher", beanDefinition);
		}
	}
}
