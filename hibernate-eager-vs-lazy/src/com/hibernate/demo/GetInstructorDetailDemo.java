package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			int instructorDetailId = 3;

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

			System.out.println("Get instructor details:" + instructorDetail);

			System.out.println("\nGet instructor:" + instructorDetail.getInstructor());
			// Commit transaction
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
