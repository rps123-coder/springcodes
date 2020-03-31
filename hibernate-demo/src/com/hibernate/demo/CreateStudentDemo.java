package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//Create session 
		Session session=factory.getCurrentSession();
		
		try{
			//Create session object
			Student theStudent=new Student("Luv", "Singh", "luvsingh@gmail.com");
			
			//Start a transaction
			session.beginTransaction();
			
			//Save Student object
			session.save(theStudent);
			
			//Commit transaction
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
