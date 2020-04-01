package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();

			int instructorDetailId=6;
			
			InstructorDetail instructorDetail=session.get(InstructorDetail.class, instructorDetailId);
			
			//Note : will also delete assosiated "instructor" object because of CascadeType.ALL
			session.delete(instructorDetail);
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
