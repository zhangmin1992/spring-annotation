package day00ForCicleDependOn;

import org.springframework.stereotype.Component;

@Component
public class A {

	private B B;
	
	private String name = "A";

	public B getB() {
		return B;
	}

	public void setB(B b) {
		B = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*public A(B b) {
		System.out.println("执行A的构造器");
		this.B = b;
	}*/
	
	
}
