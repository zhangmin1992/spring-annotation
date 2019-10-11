package day53ForTair.two;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import day53ForTair.two.TairClient;
import com.google.common.base.Charsets;
import com.taobao.tair3.client.Result;
import com.taobao.tair3.client.TairClient.TairOption;
import com.taobao.tair3.client.config.impl.SimpleTairConfig;
import com.taobao.tair3.client.config.impl.TairConfig;
import com.taobao.tair3.client.error.TairException;
import com.taobao.tair3.client.impl.MultiTairClient;

/**
 * @author xuqinpeng
 */
public class SimpleTairClientImpl implements TairClient {

    protected MultiTairClient tairClient;
    
    protected short defaultNamespace = 11;
    
    protected long defaultTimeout = 5000L;
    
    protected int defaultExpiretime = 5000;
    
    protected short defaultVersion = 0;
    
    private TairClientProperties tairClientProperties;

    /**
     * 自动注解的时候会自动调用构造方法，
     * 但是这个SimpleTairClientImpl(short namespace, String master, String slave, String group, String localAppKey, String remoteAppKey)
     * 不会调用
     * @throws TairException
     */
	public SimpleTairClientImpl(TairClientProperties tairClientProperties) {
		try {
			defaultNamespace = 14;
			String localAppKey = tairClientProperties.getLocalAppKey();
			String remoteAppKey = tairClientProperties.getRemoteAppKey();
//			String localAppKey = "com.sankuai.movie.orderpay.gprice";
//			String remoteAppKey = "com.sankuai.tair.qa.function";
			TairConfig config = new SimpleTairConfig(localAppKey, remoteAppKey);
			tairClient = new MultiTairClient(config);
			tairClient.init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 直接放值 传值方式
	 */
	public boolean put(String key, Object object, long timeOut, int expireTime) {
		TairOption option = new TairOption(timeOut, (short) 0, expireTime);
		try {
			Result<Void> result = tairClient.putObj(defaultNamespace, key, object, option);
			if (!Result.ResultCode.OK.equals(result.getCode())) {
				throw new RuntimeException(result.toString());
			}
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	
	/**
     * 获取缓存对象，超时时间为timeOut（单位：毫秒）
     *
     * @param key
     * @param clazz
     * @param timeOut 超时时间（单位：毫秒）
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz, long timeOut) {
        try {
            TairOption option = new TairOption(timeOut, (short) 0, 0);
            Result<Object> result = tairClient.getObj(defaultNamespace, key, clazz, option);
            return (T) result.getResult();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 序列化方式
     */
    public void put(String key, Serializable value, int expires) {
        try {
            Result<Void> result = tairClient.put(defaultNamespace, key.getBytes(Charsets.UTF_8), FSTSerializationUtils.jdkserialize(value), new TairOption(defaultTimeout, defaultVersion, expires));
            if(!Result.ResultCode.OK.equals(result.getCode())) {
                throw new RuntimeException(result.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public <T> T get(String key, Class<T> type) {
        try {
            Result<byte[]> result = tairClient.get(defaultNamespace, key.getBytes(Charsets.UTF_8), new TairOption(defaultTimeout,
                    defaultVersion));
            if(Result.ResultCode.OK.equals(result.getCode())) {
                return result.getResult() == null ? null : (T) FSTSerializationUtils.jdkdeserialize(result.getResult());
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@Override
	public void close() {
		tairClient.close();
	}

}
