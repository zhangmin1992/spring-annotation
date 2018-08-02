package day25Transaction.test;

import org.springframework.stereotype.Component;

@Component
public class MethodBean {

	@MyLoginRequired
	public void show() {
		System.out.println("小猫在叫");
	}
	
	public void show2() {
		System.out.println("show2在叫");
	}
}
