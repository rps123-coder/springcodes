package com.springaop.aspect.before;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n=======>>>> Executing @Before advice on addAccount() <<<<========");
	}
	
	/*We can give pattern in mny types for advice.
	1)public void addAccount()
	2)public void add*()
	3)public void com.springaop.dao.AccountDAO.addAccount()
	4)* void addAccount()
	5)void addAccount()
	6)* addAccount()
	7)* add*()
	All are same type of pattern. * used for any type to hust remove restriction of particular type*/
	
	/*if want to define pattern for all method then use package syntax
	(* com.springaop.dao.*.*(..))*/
	
	/*for param-pattern
	() - matches a method with no arguments
	(*) - matches a method with one arguments of any type ..always give full classified class name in parameter
	(. .) - matches a method with 0 or more arguments of any type*/
	

}
