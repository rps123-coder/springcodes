package com.fullJava.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theTennisCoach")
public class TennisCoach implements Coach {
	
	private FortuneServices fortuneServices;
	
	@Autowired
	public TennisCoach(@Qualifier("myFortuneService") FortuneServices fortuneServices) {
		this.fortuneServices = fortuneServices;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println(this.fortuneServices.getFortune());
		return "Practice your backhand volley";
	}

}
