package day25Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import day20Autowride.UserDao;

@Configuration
@ComponentScan("day25Profile,day20Autowride")
public class Myconfig {

	@Profile("test")
	@Bean
	public UserDao createUserDao() {
		System.out.println("----test----");
		return new UserDao();
	}
	
	@Profile("qa")
	@Bean
	public UserDao createUserDao2() {
		System.out.println("----qa----");
		return new UserDao();
	}
	
	@Profile("default")
	@Bean
	public UserDao createUserDao3() {
		System.out.println("----default----");
		return new UserDao();
	}
}
