package day53ForTair.three;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.meituan.service.movie.tair.service.exception.MTairConfigException;
import com.taobao.tair3.client.config.impl.ClientParameters;
import com.taobao.tair3.client.config.impl.SimpleTairConfig;
import com.taobao.tair3.client.config.impl.TairConfig;
import com.taobao.tair3.client.impl.MultiTairClient;

/**
 * 这里因为tair3.8以上的配置支持重试配置，因为更新了一个NewMTairConfig的属性配置文件
 * 多了一个只针对3.8做连接配置的类NewMTairClient，这个类只负责连接
 * BaseMTairClient 类负责连接后的各种数据工作，因为这个类继承了BaseMTairClient，
 * 因此统一入口都是NewMTairClient
	* @author zhangmin 
	* @date Oct 11, 2019 6:06:09 PM
 */
public class NewMTairClient extends BaseMTairClient {

	private static final Logger logger = LoggerFactory.getLogger(NewMTairClient.class);

	/**
	 * bean构造函数属性注入，需要get set方法
	 * 并且NewMTairClient 没有@service注解
	 */
    private NewMTairConfig mTairConfig;
    
    public NewMTairClient(NewMTairConfig mTairConfig) {
    	try {
    		if (mTairConfig == null) {
                throw new MTairConfigException("NewTairConfig is null,please check!!");
            }
            ClientParameters clientParameters = new ClientParameters(mTairConfig.getRetryPercent(), mTairConfig.getBatchReturnPercent());
            TairConfig tairConfig = new SimpleTairConfig(mTairConfig.getLocalAppKey(), mTairConfig.getRemoteAppKey(), clientParameters);
            this.area = mTairConfig.getArea();
            tairClient = new MultiTairClient(tairConfig);
            tairClient.init();
		} catch (Exception e) {
			logger.info("NewMTairClient e={}",e);
		}
    }

	public NewMTairConfig getmTairConfig() {
		return mTairConfig;
	}

	public void setmTairConfig(NewMTairConfig mTairConfig) {
		this.mTairConfig = mTairConfig;
	}    
    
}
