package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			 //Create session object 
			Student theStudent=new Student("Anukul",
			 "Singh", "anukul@gmail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			//Save Student object session.save(theStudent);
			session.save(theStudent);

			//Read object based on Primary key
			Student student = session.get(Student.class, theStudent.getId());
			System.out.println(student);
			
			//Querying objects
			List<Student> studentList=session.createQuery("from Student").getResultList();
			
			for(Student tmpStudent:studentList){
				System.out.println(tmpStudent);
			}
			
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
