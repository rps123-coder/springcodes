package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
					
			// Start a transaction
			session.beginTransaction();

			int studentId=1;

			//Read object based on Primary key
			Student student = session.get(Student.class, studentId);
			
			//Update Last Name
			student.setLastName("Singh");
			
			//Update Querying objects
			session.createQuery("Update Student set email='abc@gamil.com'").executeUpdate();
						
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
