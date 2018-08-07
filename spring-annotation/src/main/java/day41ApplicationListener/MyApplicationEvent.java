package day41ApplicationListener;

import org.springframework.context.ApplicationEvent;


public class MyApplicationEvent extends ApplicationEvent{

	public MyApplicationEvent(Object source) {
		super(source);
	}

}
