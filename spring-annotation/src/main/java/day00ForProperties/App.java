//package day00ForProperties;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
///**
// * 注解的方式：spring在某类就加载资源文件的内容
// * @author yp-tc-m-7129
// *
// */
//public class App {
//
//	public static void main(String[] args) {
//		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("day00ForProperties");
//		RedisProperties redisProperties = context.getBean(RedisProperties.class);
//		System.out.println(redisProperties.getHost());
//		context.close();
//		System.out.println("----end-----");
//	}
//}
