package com.springaop.aspect.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAspect {

	@Around("execution(* com.springaop.dao.TrafficFortuneDAO.getFortune())")
	public Object getFortune(ProceedingJoinPoint proJoinPoint) throws Throwable{
		
		String method=proJoinPoint.getSignature().toShortString();
		System.out.println(method);
		
		long begin=System.currentTimeMillis();
		Object result=proJoinPoint.proceed();
		long end=System.currentTimeMillis();
		long duration=end-begin;
		
		System.out.println("Duration : "+duration);
		
		return result;
	}
}
