package com.practice.spring;

import org.springframework.stereotype.Component;

@Component
public class MyFortuneService implements FortuneServices {

	@Override
	public String getFortune() {
		
		return "Today is your special day!";
	}

}
