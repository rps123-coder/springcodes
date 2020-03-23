package com.fullJava.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
	
	private FortuneServices fortuneServices;
	
	@Autowired
	@Qualifier("myFortuneService")
	public void setFortuneServices(FortuneServices fortuneServices) {
		this.fortuneServices = fortuneServices;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println(this.fortuneServices.getFortune());
		return "Practice dribbling perfectly";
	}

}
