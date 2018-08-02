package day02bean;

public class Person {

	/**
	 * 默认构造函数需要有，否则会报错
	 *  org.springframework.beans.BeanInstantiationException: Failed to instantiate [com.zm.spring.annotation.day02.Person]: 
	 * No default constructor found; nested exception is java.lang.NoSuchMethodException: 
	 * com.zm.spring.annotation.day02.Person.<init>()
	 */
	public Person() {
		
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void sayName() {
		System.out.println("-------sayName------");
	}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	public void init() {
		System.out.println("person在初始化");
	}
	
}
