package day11ForJidong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 根据资源文件属性决定加载哪个bean
 * @author yp-tc-m-7129
 *
 */
@Conditional(MyConditional.class)
@Component("redisProperties")
@PropertySource(value="classpath:application.properties")
public class RedisProperties {

	@Value(value="${my.redis.host}")
	private String url;
	
	@Value(value="${my.redis.port}")
	private String port;

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
	
}
