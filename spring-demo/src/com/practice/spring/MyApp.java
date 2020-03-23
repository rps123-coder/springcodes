package com.practice.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach trackCoach=context.getBean("myTrackCoach", Coach.class);
		Coach baseBallCoach=context.getBean("myBaseBallCoach", Coach.class);
		System.out.println("-----------Setter injection-----------");
		System.out.println(trackCoach.getDailWorkout());
		System.out.println("-----------Constructor injection-------");
		System.out.println(baseBallCoach.getDailWorkout());
		context.close();

	}

}
