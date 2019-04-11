package day44springioc.ApplicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println(event.getSource()+"==== "+event.getTimestamp());
	}

}
