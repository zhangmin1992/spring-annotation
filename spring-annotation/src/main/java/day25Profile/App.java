package day25Profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alibaba.fastjson.JSONObject;

import day20Autowride.UserDao;

/**
 *@Profile("default") Profile 表示环境别激活的时候加载某个bean，默认是default,没有指定环境的时候会加载
 *
 *激活环境的方式：
 *1.环境变量 spring.profiles.active  test
 *2无参构造函数 激活环境 注册配置类 刷新容器，发现只有qa的被加载了
 */
public class App {

	public static void main(String[] args) {
		/**
		 * 有参构造器包含了3步骤
		 *  this();
			register(annotatedClasses);
			refresh();
		 */
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		//激活环境
		context.getEnvironment().setActiveProfiles("qa");
		//注册配置类
		context.register(Myconfig.class);
		//刷新容器
		context.refresh();
		JSONObject.toJSONString(context.getBeanNamesForType(UserDao.class));
		UserDao UserDao = context.getBean(UserDao.class);
		UserDao.hello();
	}
}
