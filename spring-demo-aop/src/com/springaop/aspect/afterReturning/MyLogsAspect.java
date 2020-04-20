package com.springaop.aspect.afterReturning;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.springaop.dao.Account;

@Aspect
@Component
public class MyLogsAspect {
	
	@AfterReturning("execution(* com.springaop.dao.AccountDAO.findAccount())")
	public void afterReturningAdvice(){
		
		System.out.println("\n=======>>>>  @After returning advice on find Account() <<<<========");
		
	}
	
	/*  "returning" is used to access return value from method */
	
	@AfterReturning(pointcut="execution(* com.springaop.dao.AccountDAO.findAccount(..))",returning="result")
	public void afterReturningAdvice(JoinPoint theJointPoint, List<Account> result){
		
		System.out.println("\n=======>>>>  @After returning advice on find Account() details<<<<========");
		System.out.println(theJointPoint.getSignature());
		System.out.println(result);
		
	}

}
