package day00ForRedisCacheStarter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.my.springboot.spring_boot_starter_redis.bean.RedisCacheAspect;
import com.my.springboot.spring_boot_starter_redis.bean.RedisClient;
import com.my.springboot.spring_boot_starter_redis.bean.RedisProperties;
import com.my.springboot.spring_boot_starter_redis.bean.RedisToolUtils;
import com.my.springboot.spring_boot_starter_redis.testservice.TestServiceImpl;

public class App2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
		System.out.println(context.getBean(RedisProperties.class));
		System.out.println(context.getBean(RedisCacheAspect.class));
		System.out.println(context.getBean(RedisClient.class));
		
		Environment environment = context.getBean(Environment.class);
		System.out.println("-----"+environment.getProperty("my.redis.host"));
		
		System.out.println("---" + context.getBean(RedisProperties.class).getPort());
		
		System.out.println("准备插入redis数据");
		
		RedisToolUtils.set("qq", "qq");
		
		RedisToolUtils.set("day00ForProperties.TestServiceImpl2.testServiceMethod.[]", "hahaha");
		
		TestServiceImpl2 testServiceImpl = context.getBean(TestServiceImpl2.class);
		testServiceImpl.testServiceMethod();
		testServiceImpl.testServiceMethod();
		testServiceImpl.testServiceMethod();
		context.close();
		System.out.println("----end-----");
	}
}
