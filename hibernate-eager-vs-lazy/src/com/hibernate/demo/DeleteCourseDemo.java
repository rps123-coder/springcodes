package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();

			int theCourseId=10;
			Course course=session.get(Course.class, theCourseId);
			
			System.out.println(course);
			
			session.delete(course);			
			
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
