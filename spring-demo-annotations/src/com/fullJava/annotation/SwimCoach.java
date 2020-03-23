package com.fullJava.annotation;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
	@Value("${demo.coachName}")
	private String coachName;
	@Value("${demo.coachEmail}")
	private String coachEmail;	
	private FortuneServices fortuneServices;

	public SwimCoach(FortuneServices fortuneServices) {
		this.fortuneServices = fortuneServices;
	}
	
	public String getCoachName() {
		return coachName;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	@Override
	public String getDailyWorkOut() {
		System.out.println(this.fortuneServices.getFortune());
		System.out.println("Coach Name:" +getCoachName());
		System.out.println("Coach Email:" +getCoachEmail());
		return "Practice for butterfly properly" ;
	}

}
