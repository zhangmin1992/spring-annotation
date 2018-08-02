package day44springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import day44springioc.BeanPostProcessor.Person;
@ComponentScan("day44springioc")
@Configuration
public class Myconfig {
	
	@Bean
	public Person Person() {
		System.out.println("---@Bean----");
		return new Person();
	}
}
