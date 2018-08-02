package day25Transaction;

import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 注意事项:这个注解EnableTransactionManagement要放在配置类中，不能放在启动类中
 *1.开启事务管理功能 EnableTransactionManagement
 *2.数据源 事务管理器 jdbcTeplate 配置
 *3.Transactional注解标注
 *需要@EnableTransactionManagement注解才可以，表明开启事务管理器功能
 *
 *1.EnableTransactionManagement的import会导入2个组件AutoProxyRegistrar，ProxyTransactionManagementConfiguration
 *2.1.AutoProxyRegistrar做了什么呢？
 *AutoProxyRegistrar实现了ImportBeanDefinitionRegistrar接口，它会会调用registerBeanDefinitions方法给容器中注册bean，
 *注册的是InfrastructureAdvisorAutoProxyCreator 组件，跟spring aop的后置处理器一样，他也是后置处理器SmartInstantiationAwareBeanPostProcessor，
 *我们分析InfrastructureAdvisorAutoProxyCreator的功能就行了,利用后置处理器，在对象创建以后包装对象，返回一个代理对象，代理对象执行方法的时候利用拦截器链进行调用
 *
 *2.2ProxyTransactionManagementConfiguration做了什么呢?
 * 他是一个配置类，给容器中注册各种组件，
 * 比如事务增强器 transactionAdvisor
 * 事务增强器需要的事务属性，也是一个bean transactionAttributeSource，属性比如 rollbanckfor等属性
 * 事务拦截器 transactionInterceptor
 * 
 * transactionInterceptor拦截器实现了MethodInterceptor接口，会在目标方法执行的时候执行拦截器链-invokeWithinTransaction
 *  2.2.1事务相关属性
 *  2.2.2 获取事务管理器-PlatformTransactionManager，如果你没有添加指定任何事务管理器，最终会从ioc容器中按照类型获取一个事务管理器
 *  this.beanFactory.getBean(PlatformTransactionManager.class);
 *  2.2.3 方法先执行目标方法，如果异常获取到事务管理器，利用事务管理器回滚这次操作（completeTransactionAfterThrowing）
 *  方法执行一切正常，commitTransactionAfterReturning，拿到事务管理器，提交事务
 */
@EnableTransactionManagement
public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("day25Transaction");
//		JdbcOperator jdbcOperator = context.getBean(JdbcOperator.class);
//		String dateString = jdbcOperator.searchUserName(3);
//		System.out.println(dateString);
//		jdbcOperator.delete(3);
//		jdbcOperator.insertInfo();
//		jdbcOperator.update("2018-08-08", 88);
//		try {
//			jdbcOperator.testTransactional();
//		} catch (Exception e) {
//			System.out.println("发生未知异常！！！！！");
//		}
		
		jdbcService jdbcService = context.getBean(jdbcService.class);
		jdbcService.processDeamonWriteBackOutFee();
		
	}
}
