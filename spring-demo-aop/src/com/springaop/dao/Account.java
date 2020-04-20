package com.springaop.dao;

public class Account {
	
	private String accName;
	private String accType;
	
	public Account(){
		
	}
	
	public Account(String accName, String accType) {
		this.accName = accName;
		this.accType = accType;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	@Override
	public String toString() {
		return "Account [accName=" + accName + ", accType=" + accType + "]";
	}
	
}
