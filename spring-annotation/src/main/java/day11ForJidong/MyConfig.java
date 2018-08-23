package day11ForJidong;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("day11ForJidong")
public class MyConfig {

	/**
	 * @Bean(name="redisProperties2") 结合@PropertySource不可用,一定要用@Component
	 * @return
	 */
	//@Bean(name="redisProperties2")
//	public RedisProperties2 redisProperties2() {
//		System.out.println("***********");
//		return new RedisProperties2();
//	}
	
}
