package day53ForTair.three;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class NewMTairConfig {

	private String localAppKey = "com.sankuai.movie.orderpay.gprice";

	private String remoteAppKey = "com.sankuai.tair.qa.function";

	// 默认重试20%
	private int retryPercent = 20;

	// 默认全部key拿到结果才返回
	private int batchReturnPercent = 100;
	
	//桶
	private short area = 14;
}
