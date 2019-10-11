package day53ForTair.two;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("day53ForTair.two")
public class BeanConfig {

	@ConditionalOnBean(TairClientProperties.class)
	@Bean
	public GetTairClientProperties getTairClientProperties(TairClientProperties tairClientProperties) {
		return new GetTairClientProperties(tairClientProperties);
	}
	
	@ConditionalOnBean(TairClientProperties.class)
	@Bean
	public SimpleTairClientImpl simpleTairClientImpl(TairClientProperties tairClientProperties) {
		return new SimpleTairClientImpl(tairClientProperties);
	}
}
