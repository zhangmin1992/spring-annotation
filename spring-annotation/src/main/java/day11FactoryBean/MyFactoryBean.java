package day11FactoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Dog> {

	public Dog getObject() throws Exception {
		return new Dog();
	}

	public Class<?> getObjectType() {
		return Dog.class;
	}

	/**
	 * 是单例还是多例
	 */
	public boolean isSingleton() {
		return true;
	}

}
