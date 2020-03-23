package com.fullJava.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FullJavaDemo {

	public static void main(String[] args) {
	
	    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);
		Coach tennisCoach=context.getBean("theTennisCoach", TennisCoach.class);
		Coach footballCoach=context.getBean("footBallCoach", FootBallCoach.class);
		Coach hockeyCoach=context.getBean("hockeyCoach", HockeyCoach.class);
		Coach swimCoach=context.getBean("swimCoach", SwimCoach.class);
		System.out.println("--------Constructor Injection-----------");
		System.out.println(tennisCoach.getDailyWorkOut());
		System.out.println("--------Setter Injection----------------");
		System.out.println(footballCoach.getDailyWorkOut());
		System.out.println("--------Field Injection-----------------");
		System.out.println(hockeyCoach.getDailyWorkOut());
		System.out.println("---------Java configuration-------------");
		System.out.println(swimCoach.getDailyWorkOut());
		
		
		context.close();

	}

}
