package com.springaop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(){
		System.out.println(getClass()+" : Doing my DB work: adding an account");
	}
	
	public void addAccountDetails(String name, boolean value){
		System.out.println(getClass()+" : Displaying the account details");
	}
	
	public List<Account> findAccount(){
		System.out.println(getClass()+" : Get account list details");
		
		List<Account> theList=new ArrayList<Account>();
		
		Account acc1=new Account("Raj", "Gold");
		Account acc2=new Account("Vikas", "Platinum");
		
		theList.add(acc1);
		theList.add(acc2);
		
		return theList;
	}
	
	public List<Account> showAccount(){
		System.out.println(getClass()+" : show account list details");
					
		throw new RuntimeException("An exception has occur!!!");
		
	}
	

}
