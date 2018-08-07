package day02bean;

import org.springframework.stereotype.Component;

@Component
public class Student extends Person {

	public Student() {
		
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

	public Student(String name) {
		super();
		this.name = name;
	}
	
	public void init() {
		System.out.println("Student在初始化");
	}
	
}
