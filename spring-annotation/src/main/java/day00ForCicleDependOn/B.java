package day00ForCicleDependOn;

import org.springframework.stereotype.Component;

@Component
public class B {
	
	private C c;
	
	private String name = "B";

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*public B(C c) {
		System.out.println("执行B的构造器");
		this.c = c;
	}*/
	
	
}
