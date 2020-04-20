package com.springaop.aspect.before;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PointCutDeclarativeAspect {
	
	/*This annoation use to define common execution pattern rather than writing multiples time*/
	@Pointcut("execution(* com.springaop.dao.*.add*(..))")
	private void getCommonDeclaration(){}
	
	@Before("getCommonDeclaration()")
	public void beforeAccountAdvice(){
		
		System.out.println("\n=======>>>>  @Before advice on Account() <<<<========");
	}
	
	@Before("getCommonDeclaration()")
	public void beforeAddAdvice(){
		
		System.out.println("\n=======>>>>  @Before advice on addAccount() <<<<========");
	}
	
	/*we can use && , !, || expression in Multiple pointcut expression for one advice means at combine expression*/
	//@Before("expression1 && expressio2 ")
	
	
	/*JointPoint demo. use to access method signature and their arguments*/
	@Before("getCommonDeclaration()")
	public void beforeAddAccountDetails(JoinPoint theJoinPoint){
				
		System.out.println("\n=======>>>>  @Before advice on AddAccountDetails(String name,boolean value) <<<<========");
		
		//Display method signature
		MethodSignature methSig=(MethodSignature) theJoinPoint.getSignature();
		System.out.println(methSig);
		
		//Display method arguments
		Object[] args=theJoinPoint.getArgs();
		
		for(Object theArgs:args){
			System.out.println(theArgs);
		}
	}
	

}
