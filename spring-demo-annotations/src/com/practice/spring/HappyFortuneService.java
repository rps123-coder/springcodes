package com.practice.spring;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneServices {

	@Override
	public String getFortune() {
	    return "Every Day is a Special day !";
	}

}
