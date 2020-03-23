package com.practice.spring;

public class BaseballCoach implements Coach{
	
	private FortuneService myFortune;
	
	public BaseballCoach() {

	}

	public BaseballCoach(FortuneService myFortune) {
		this.myFortune = myFortune;
	}

	@Override
	public String getDailWorkout() {
		System.out.println(this.myFortune.getFortune());
		return "Spend 30 minutes on batting practice";
	}

}
