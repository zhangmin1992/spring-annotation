package day52ForElasticSearch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.fastjson.JSONObject;

public class App {

	public static void main(String[] args) {
 
		/**
		 * day03注解方式
		 * applicationContext.getBeanDefinitionNames()用来获取容器中的注入的bean名字
		 */
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
		Student student = applicationContext.getBean(Student.class);
		student.sayName();
		NoticeController noticeController = applicationContext.getBean(NoticeController.class);
		noticeController.getContent("爸爸", 1, 10);
	}

}
