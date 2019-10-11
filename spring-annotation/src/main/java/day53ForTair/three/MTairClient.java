package day53ForTair.three;

import java.util.List;

public interface MTairClient {

	public boolean put(String key, Object object, long timeOut, int expireTime);
	
	public <T> T get(String key, Class<T> clazz, long timeOut);
	
	public <T> boolean putList(String key, List<T> list, long timeOut, int expireTime);
}
