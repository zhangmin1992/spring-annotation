package day41ApplicationListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener2 {

	/**
	 * @EventListener方式发布所有事件
	 * @param event
	 */
	/*@EventListener(classes={ApplicationEvent.class})
	public void show(ApplicationEvent event) {
		System.out.println("MyApplicationListener2 注解的事件监听器"+event);
	}*/
	
	/**
	 * @EventListener方法发布指定类型的事件
	 * @param event
	 */
	@EventListener(classes=MyApplicationEvent.class)
	public void show(MyApplicationEvent event) {
		System.out.println("MyApplicationListener2 注解的事件监听器"+event);
	}

}
