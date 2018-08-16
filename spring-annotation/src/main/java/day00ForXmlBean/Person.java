package day00ForXmlBean;

public class Person {

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
	
	public void destory() {
		System.out.println("person在被销毁中");
	}
	
}
