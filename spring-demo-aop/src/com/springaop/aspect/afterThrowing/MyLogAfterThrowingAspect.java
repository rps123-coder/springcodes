package com.springaop.aspect.afterThrowing;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogAfterThrowingAspect {
	
	@AfterThrowing("execution(* com.springaop.dao.AccountDAO.showAccount())")
	public void afterThrowingAdvice(){
		
		System.out.println("\n=======>>>>  @After throwing advice on show Account() <<<<========");
		
	}
	
	/*  "returning" is used to access return value from method */
	
	@AfterThrowing(pointcut="execution(* com.springaop.dao.AccountDAO.showAccount(..))",throwing="theErr")
	public void afterThrowingAdvice(JoinPoint theJointPoint, Throwable theErr){
		
		System.out.println("\n=======>>>>  @After thowing advice on show Account() details<<<<========");
		System.out.println(theJointPoint.getSignature());
		
		System.out.println(theErr);
		
	}


}
