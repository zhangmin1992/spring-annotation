package day02bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 的注入和生命周期
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {
		/**
		 * 使用xml方式来获取bean，bean的名字和xml中定义的名字要一致
		 */
		/*ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("beans.xml");
		Person bean = (Person) applicationContext.getBean("xmlPersonName");
		bean.sayName();*/
		
		/**
		 * 使用注解的方式,可以通过类名(bean名称默认是配置类中的方法名称可以通过@Bean(name="myperson01")修改bean名称)或者类型获取
		 */
		/*ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		//Person bean = (Person) applicationContext.getBean(Person.class);
		//Person bean = (Person) applicationContext.getBean("myperson");
		Person bean = (Person) applicationContext.getBean("myperson01");
		bean.sayName();*/
		
		/**
		 * bean的生命周期是指创建》 初始化-》销毁
		 * 单实例方式下，在容器启动的时候就会调用方法创建对象到容器中，下次用就直接从容器中获取,
		 * 多实例下，容器启动并不会创建对象调用方法放入容器中，而是每次获取都会重新创建对象放入容器中
		 * 单实例方式下，在容器关闭的时候就会调用方法销毁bean，
		 * 多实例方式下，容器关闭的时候不会管理销毁bean，只能你手动销毁
		 */
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		/*Dog dog = applicationContext.getBean(Dog.class);
		dog.hello();*/
		
		/**
		 * 当Student继承了Person，并且两个bean都在容器中的时候，person类型的bean也可以找到他的子类Student 所实例化的student对象
		 */
		String[] names = applicationContext.getBeanNamesForType(Person.class);
		for (String name : names) {
			System.out.println("name----"+name);
		}
		applicationContext.close();
	}

}
