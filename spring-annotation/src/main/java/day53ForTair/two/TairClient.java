package day53ForTair.two;

import java.io.Serializable;

/**
 * @author xuqinpeng
 */
public interface TairClient {

    void close();

    boolean put(String key, Object object, long timeOut, int expireTime);

    <T> T get(String key, Class<T> clazz, long timeOut); 

    void put(String key, Serializable value, int expires);
    
    <T> T get(String key, Class<T> type);
    
    
}
