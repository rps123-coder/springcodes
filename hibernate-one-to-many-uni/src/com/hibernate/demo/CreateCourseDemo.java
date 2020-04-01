package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;

public class CreateCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();

			//get the instructor from db
			int instId=1;
			Instructor instructor=session.get(Instructor.class, instId);
			
			// create some course
			Course course1=new Course("The Tinball");
			Course course2=new Course("Magic ball open");
			
			//add course to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			//save the courses
			session.save(course1);
			session.save(course2);

			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
