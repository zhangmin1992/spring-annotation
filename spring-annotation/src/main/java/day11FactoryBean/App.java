package day11FactoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class App {

	public static void main(String[] args) {
		/**
		 * spring给容器中注入bean的方式
		 * 1.在可扫描的包下有注解 @Service @Controller @Component @Repository
		 * 2.在配置类中 @Bean 定义某个组件
		 * 
		 * 3.import第三方组件,注意这种时候默认注入的beanname不相同
		 * 方式一：直接引入需要的类：
		 * spring中 @Import(Dog.class)这个不能放到启动类中（会报错容器还没有初始化完成），需要放到配置文件类中，注入bean的名称是day09import.Dog
		 * 但是springboot可以放到启动类中，待思考
		 * 
		 * 方式二：引入一个MyImportSelector类，这个类的返回值的bean会被注入进去,注入的bean的名称是day09import.Dog
		 * 注意这个MyImportSelector中返回的bean如果已经在配置文件中被注入过了,同时企图用@bean注入，会有2个同类型对象，getBean(Dog.class)的时候会报错
		 * 为解决2个同类型的对象存在的问题，可以结合@Conditional，或者@primay或者@profile环境或者@Resource(name="")
		 * MyCondition当前上下文环境中是否已经存在beanName=day09import.Dog的对象，如果不存在就创建，存在就不创建@Bean
		 * 
		 * 方式三：手工注册MyImportBeanDefinitionRegistrar
		 * 
		 * 4.factoryBean
		 * 虽然我们在配置类中定义的是createMyFactoryBean，但是他的类型确是Dog对象，可以直接调用Dog对象的方法
		 * 如果我们想获取facatoryBean 本事的对象，用这个applicationContext.getBean("&createMyFactoryBean");
		 */
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		String[] beanNames =  applicationContext.getBeanNamesForType(Dog.class);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		
		/*Object bean = applicationContext.getBean("createMyFactoryBean");
		System.out.println(bean.getClass());
		Dog bean2 = (Dog)bean;
		bean2.jiao();*/
		
//		Dog bean = applicationContext.getBean(Dog.class);
//		bean.jiao();
		
		Object bean = applicationContext.getBean("&createMyFactoryBean");
		System.out.println(bean.getClass());
		
	}

}
