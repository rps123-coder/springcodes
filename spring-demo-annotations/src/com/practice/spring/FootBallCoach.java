package com.practice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {
	
	@Value("${demo.coachName}")
	private String coachName;
	@Value("${demo.coachEmail}")
	private String coachEmail;	
	private FortuneServices fortuneServices;
	
	public String getCoachName() {
		return coachName;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	@Autowired
	@Qualifier("myFortuneService")
	public void setFortuneServices(FortuneServices fortuneServices) {
		this.fortuneServices = fortuneServices;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println(this.fortuneServices.getFortune());
		System.out.println("Coach Name:" +getCoachName());
		System.out.println("Coach Email:" +getCoachEmail());
		return "Practice dribbling perfectly";
	}

}
