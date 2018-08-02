package day25Transaction.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 功能1：测试ImportBeanDefinitionRegistrar 接口动态注入bean-dog，import的第三种用法
 * 功能2：测试方法拦截器，在自定义注解@MyLoginRequired的方法上加上日志拦截
 */
public class App {

	public static void main(String[] args) {
		/**
		 * 测试import第三种用法向spring容器中注入bean，需要打开配置类中的这行话//@Import(MyImportBeanDefinitionRegistrar.class)
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		//System.out.println(context.getBean(Dog.class));
		/**
		 * 测试方法拦截器，在自定义注解的方法上加上日志拦截
		 * 需要 beans.xml中的配置
		 */
		MethodBean methodBean = context.getBean(MethodBean.class);
		methodBean.show();
		methodBean.show2();
		
	}
}
