package com.springaop.aspect.after;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAfterAdvice {
	
	@After("execution(* com.springaop.dao.AccountDAO.showAccount())")
	public void afterThrowingAdvice(){
		
		System.out.println("\n=======>>>>  @After advice (finally) on show Account() <<<<========");
		
	}
	
	@After("execution(* com.springaop.dao.AccountDAO.showAccount())")
	public void afterThrowingAdvice(JoinPoint theJointPoint){
		
		System.out.println("\n=======>>>>  @After advice (finally) on show Account() <<<<========");
		System.out.println(theJointPoint.getSignature());
		
	}

}
