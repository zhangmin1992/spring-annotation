package day25Transaction.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyMethodInterceptor implements MethodInterceptor {

	/**
	 * 如果目标方法上有MyLoginRequired这个注解就打印日志拦截，否则执行目标方法
	 * @param mi
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		 if(mi.getMethod().isAnnotationPresent(MyLoginRequired.class)) {
			 System.out.println("我被拦截了，打印一行日志");
		 }
		 return mi.proceed();
	}

}
