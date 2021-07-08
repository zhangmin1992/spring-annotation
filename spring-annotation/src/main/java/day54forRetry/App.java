package day54forRetry;

import day02bean.BeanConfig;
import day02bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean 的注入和生命周期
 * @author yp-tc-m-7129
 *
 */
public class App {

	public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ApplicationContext context = new AnnotationConfigApplicationContext("day54forRetry");
        BizImpl biz = context.getBean(BizImpl.class);
        biz.get();
	}

}
