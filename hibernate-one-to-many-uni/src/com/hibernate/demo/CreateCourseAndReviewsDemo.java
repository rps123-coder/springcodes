package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();

			Course tempCourse=new Course("Pacman-How to score 1 million points!!");
			
			tempCourse.addReview(new Review("Great game ... loved it!!"));
			tempCourse.addReview(new Review("Cool game ... loved it!!"));
			tempCourse.addReview(new Review("Best game ... loved it!!"));
			
			//save the courses
			session.save(tempCourse);
			
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
