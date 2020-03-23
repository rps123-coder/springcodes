package com.practice.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach {
	
	@Autowired
	@Qualifier("myFortuneService")
	private FortuneServices fortuneServices;
	
	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneServices hfServices;

	@Override
	public String getDailyWorkOut() {
		System.out.println(fortuneServices.getFortune());
		System.out.println(hfServices.getFortune());
		return "Practice penalty stroke perfectly";
	}

}
