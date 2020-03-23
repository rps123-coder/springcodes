package com.practice.spring;

public class MyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your special day!";
	}

}
