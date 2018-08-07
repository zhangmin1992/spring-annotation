package day39BeanFactoryProcess;

import org.springframework.stereotype.Component;

@Component
public class Dog {

	public Dog() {
		System.out.println("---------Dog------");
	}
	
	public void init() {
		System.out.println("---------init------");
	}
	
	public void destory() {
		System.out.println("---------destory------");
	}
	
	public void jiao() {
		System.out.println("-----Dog is jiao---");
	}
}
