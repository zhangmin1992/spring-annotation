package day11ForJidong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 根据资源文件属性决定加载哪个bean
 * @author yp-tc-m-7129
 *
 */
/**
 * 同一个bean名字根据环境变量决定加载哪个bean的方式一，需要些2个额外的类比较麻烦
 * @author yp-tc-m-7129
 *
 */
/*@Conditional(MyConditional.class)
@Component("redisProperties")*/

//@ConditionalOnProperty(value="redis",havingValue="1",matchIfMissing=false)
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
