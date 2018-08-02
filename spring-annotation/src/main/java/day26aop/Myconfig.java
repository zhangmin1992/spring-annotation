package day26aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("day26aop")
@EnableAspectJAutoProxy
public class Myconfig {

	@Bean
	public MethodBean MethodBean() {
		return new MethodBean();
	}
	
	@Bean
	public LogAspect LogAspect() {
		return new LogAspect();
	}
}
