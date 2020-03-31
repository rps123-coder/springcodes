package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// Create session object
			Instructor instructor = new Instructor("Raj", "Singh", "rajsingh@gmail.com");

			InstructorDetail instructorDetail = new InstructorDetail("https://www.xyz.com/youtube",
					"Making youTube videos!!");

			instructor.setInstructorDetail(instructorDetail);

			// Start a transaction
			session.beginTransaction();

			// Save object
			// This will also save the details object because of CascadeType.ALL
			session.save(instructor);

			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
