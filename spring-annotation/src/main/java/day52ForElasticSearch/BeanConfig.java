package day52ForElasticSearch;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.network.InetAddresses;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
@ComponentScan(value="day52ForElasticSearch")
public class BeanConfig {
 
	@Bean
	public TransportClient client() throws UnknownHostException {
		Settings settings = Settings.builder().put("cluster.name", "wali").build();
        //我用6.3.2版本的时候这里一直报异常说找不到InetSocketTransportAddress类，这应该和jar有关，当我改成5.6.8就不报错了
        TransportClient client = new PreBuiltTransportClient(settings);//6.3.2这里TransportAddress代替InetSocketTransportAddress
        client.addTransportAddress(new InetSocketTransportAddress(
                new InetSocketAddress(InetAddresses.forString("127.0.0.1"), 9300)));
        return client;
	}
	 
}
