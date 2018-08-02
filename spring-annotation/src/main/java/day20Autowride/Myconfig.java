package day20Autowride;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("day20Autowride")
public class Myconfig {

	@Primary
	@Bean
	public UserDao createUserDao() {
		return new UserDao();
	}
	
	@Bean
	public UserDao createUserDao2() {
		return new UserDao();
	}
}
