package day00ForCicleDependOn;

import org.springframework.stereotype.Component;

@Component
public class C {

	private A A;
	
	private String name = "C";

	public A getA() {
		return A;
	}

	public void setA(A a) {
		A = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	/*public C(A a) {
		System.out.println("执行C的构造器");
		this.A = a;
	}*/
	
	
}
