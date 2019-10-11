package day53ForTair.three;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
 

@Configurable
@ComponentScan("day53ForTair.three")
public class BeanConfig {

	@ConditionalOnBean(NewMTairConfig.class)
	@Bean
	public NewMTairClient simpleTairClientImpl(NewMTairConfig newMTairConfig) {
		return new NewMTairClient(newMTairConfig);
	}

}
