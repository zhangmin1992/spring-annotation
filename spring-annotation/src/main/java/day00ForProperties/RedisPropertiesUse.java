package day00ForProperties;

import org.springframework.stereotype.Component;

@Component
public class RedisPropertiesUse {

	public RedisPropertiesUse(RedisProperties redisProperties){
		System.out.println(redisProperties.getHost());
	}
}
