package com.practice.spring;

public class TrackCoach implements Coach {
	
	private String coachName;
	private String coachEmail;
	private FortuneService myFortune;
	
	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachEmail() {
		return coachEmail;
	}

	public void setCoachEmail(String coachEmail) {
		this.coachEmail = coachEmail;
	}
		
	public void setMyFortune(FortuneService myFortune) {
		this.myFortune = myFortune;
	}

	@Override
	public String getDailWorkout() {
		System.out.println(this.myFortune.getFortune());
		System.out.println("Coach Name:"+getCoachName());
		System.out.println("Coach Email:"+getCoachEmail());
		return "Run a hard 5k";
	}

}
