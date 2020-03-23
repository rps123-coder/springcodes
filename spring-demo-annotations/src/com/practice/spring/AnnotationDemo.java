package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemo {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach tennisCoach=context.getBean("theTennisCoach", TennisCoach.class);
		Coach footballCoach=context.getBean("footBallCoach", FootBallCoach.class);
		Coach hockeyCoach=context.getBean("hockeyCoach", HockeyCoach.class);
		System.out.println("--------Constructor Injection-----------");
		System.out.println(tennisCoach.getDailyWorkOut());
		System.out.println("--------Setter Injection----------------");
		System.out.println(footballCoach.getDailyWorkOut());
		System.out.println("--------Field Injection-----------------");
		System.out.println(hockeyCoach.getDailyWorkOut());
		
		context.close();

	}

}
