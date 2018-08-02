package day44springioc.BeanPostProcessor;

import org.springframework.stereotype.Component;

//@Component
public class Person {

	public Person() {
		System.out.println("------Person--------");
	}
	
	public void jiao() {
		System.out.println("什么人在鬼叫！！！");
	}
}
