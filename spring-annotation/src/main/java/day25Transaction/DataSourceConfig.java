package day25Transaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据库连接的配置类，相当于之前xml中的
 * <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="username" value="root"></property>
        <property name="password" value="密码"></property>
        <property name="url" value="jdbc:mysql://localhost:3306/newtest"></property>
        <property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
 * @author yp-tc-m-7129
 *
 */
@EnableTransactionManagement
@Configuration
public class DataSourceConfig {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://rm-2ze707l6b0440gg1pxo.mysql.rds.aliyuncs.com:3306/mercury_test_01?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull");
        dataSource.setUsername("mercury_test_01");
        dataSource.setPassword("Qamo16mRYqnA4GTY");
        return dataSource;
	}
	
	@Bean 
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		//这里的调用是从容器中找组件，只会创建一次bean
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
