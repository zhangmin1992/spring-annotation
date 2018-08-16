package day26aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.alibaba.fastjson.JSONObject;

@Aspect
public class LogAspect2 {

	@Pointcut("execution(* day26aop.MethodBean2.*(..))")
	public void pointcut() {
		
	}
	
	@Before("pointcut()")
	public void logStart(JoinPoint joinPoint) {
		String[] nameArray = joinPoint.getSignature().toString().split(" ");
		String name = nameArray[1];
		int num = name.lastIndexOf(".");
		name = name.substring(0, num);
		System.out.println("--------logStart------类地址--"+name +"--方法名-"+joinPoint.getSignature().getName()+"---参数是"+JSONObject.toJSONString(joinPoint.getArgs()));
	}
	
	@After("pointcut()")
	public void logAfter() {
		System.out.println("--------logAfter---------");
	}
	
	@AfterReturning(value="pointcut()",returning="result")
	public void logReturn(Object result) {
		System.out.println("--------logReturn--------方法返回值是:"+result);
	}
	
	@AfterThrowing(throwing="exception",value="pointcut()")
	public void logException(Exception exception) {
		System.out.println("--------logException----异常是-----"+exception.getMessage());
	}
}
