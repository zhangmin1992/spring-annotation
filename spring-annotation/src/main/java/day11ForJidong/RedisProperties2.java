package day11ForJidong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Bean(name="redisProperties2") 结合@PropertySource不可用,一定要用@Component！！！
 * @author yp-tc-m-7129
 *
 */
/*@Conditional(MyConditional2.class)
@Component("redisProperties")*/
@ConditionalOnProperty(value="redis",havingValue="2",matchIfMissing=false)
@PropertySource(value="classpath:application.properties")
public class RedisProperties2 {

	@Value(value="${my.redis.host}")
	public String url;
	
	@Value(value="${my.redis.port}")
	public String port;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
	
	public void show(){
		System.out.println(port+"---");
	}
	
}
