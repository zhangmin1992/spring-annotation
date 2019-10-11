package day53ForTair.two;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:spring/tairClient.properties")
public class TairClientProperties {
	
	@Value("${my.localAppKey}")
    private String localAppKey; 
	
	@Value("${my.remoteAppKey}")
	private String remoteAppKey;

	public String getLocalAppKey() {
		return localAppKey;
	}

	public void setLocalAppKey(String localAppKey) {
		this.localAppKey = localAppKey;
	}

	public String getRemoteAppKey() {
		return remoteAppKey;
	}

	public void setRemoteAppKey(String remoteAppKey) {
		this.remoteAppKey = remoteAppKey;
	}

	public TairClientProperties() {
		System.out.println("TairClientProperties构造函数执行");
	}
	

}
