package day11FactoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Dog> {

	@Override
	public Dog getObject() throws Exception {
		return new Dog();
	}

	@Override
	public Class<?> getObjectType() {
		return Dog.class;
	}

	/**
	 * 是单例还是多例
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

}
