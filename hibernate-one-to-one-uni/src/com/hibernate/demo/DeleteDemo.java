package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();

			int instructorId=2;
			
			Instructor instructor=session.get(Instructor.class, instructorId);
			
			//Note : will also delete assosiated "details" object because of CascadeType.ALL
			session.delete(instructor);
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
