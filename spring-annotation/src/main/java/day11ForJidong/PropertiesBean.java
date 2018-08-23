package day11ForJidong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("propertiesBean")
public class PropertiesBean {

	@Value("${my.chooice.redis}")
	private String redis;

	public String getRedis() {
		return redis;
	}

	public void setRedis(String redis) {
		this.redis = redis;
	}
	
}
