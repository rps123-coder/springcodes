package com.springaop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.dao.TrafficFortuneDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		/*------------>Demo for @Before advice<-------------
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		theAccountDAO.addAccount();
		theAccountDAO.addAccountDetails("Raj", true);*/
		
		
		/*------------->Demo for @AfterReturning advice<----------------
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAcc=theAccountDAO.findAccount();
		
		System.out.println("\n-->Display account at main method<--");
		System.out.println(theAcc);*/
		
		
		/*-------------->Demo for @AfterThrowing advice<------------------
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAcc=null;
		try{
			theAcc=theAccountDAO.showAccount();
		}catch (Exception ex) {
			System.out.println("\n\nMain Program ....caught exception: "+ex);
		}
		
		System.out.println("\n-->Display account at main method<--");
		System.out.println(theAcc);		
		*/
		
		/*------------------->Demo for @After advice<-------------
		AccountDAO theAccountDAO=context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAcc=null;
		try{
			theAcc=theAccountDAO.showAccount();
		}catch (Exception ex) {
			System.out.println("\n\nMain Program ....caught exception: "+ex);
		}*/
				
		//---------------->Demo for @Around advice<-----------------
		TrafficFortuneDAO theTraffDao=context.getBean("trafficFortuneDAO", TrafficFortuneDAO.class);
		System.out.println("Main program");
		String data=theTraffDao.getFortune();
		System.out.println("\nMy fortune: "+data);
		
		
		context.close();
	}

}
