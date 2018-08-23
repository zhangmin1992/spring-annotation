package day11ForJidong;

import org.springframework.context.annotation.PropertySource;

public class RedisProperties {

	private String url;
	
	private Integer host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getHost() {
		return host;
	}

	public void setHost(Integer host) {
		this.host = host;
	}
	
	public void show(){
		System.out.println("------RedisProperties-----show---------");
	}
	
	
}
