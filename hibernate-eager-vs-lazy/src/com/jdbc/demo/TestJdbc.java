package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try{
			Connection myConn=DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("conection succesful!");
		}catch(Exception ex){

	}

 }
}
