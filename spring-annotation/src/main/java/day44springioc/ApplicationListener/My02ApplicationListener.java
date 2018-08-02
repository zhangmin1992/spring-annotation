package day44springioc.ApplicationListener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

public class My02ApplicationListener implements ApplicationListener<MyApplicationEvent> {

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		System.out.println("--------"+event.getSource()+"==== "+event.getTimestamp());
	}

}
