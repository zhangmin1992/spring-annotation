package day11FactoryBean;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

/**
 * 配置类==配置文件，注意要在spring容器加载的包下
 * @author yp-tc-m-7129
 *
 */
@Configurable
public class BeanConfig {

	/**
	 * 注入bean工厂
	 * @return
	 */
	@Bean
	public MyFactoryBean createMyFactoryBean() {
		return new MyFactoryBean();
	}
}
