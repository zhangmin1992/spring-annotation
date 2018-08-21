package day00ForRedisCacheStarter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@ComponentScan(value={"com.my.springboot.spring_boot_starter_redis","day00ForRedisCacheStarter"})
@EnableAspectJAutoProxy
public class MyConfig {

}
