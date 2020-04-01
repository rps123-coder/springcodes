package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			Course tempCourse = new Course("Pacman-How to score 1 million points!!");

			Student theStudent1=new Student("Luv", "Singh", "luvsingh@gmail.com");
			Student theStudent2=new Student("Raj", "Singh", "rajsingh@gmail.com");
			
			tempCourse.addStudent(theStudent1);
			tempCourse.addStudent(theStudent2);

			session.save(tempCourse);
			session.save(theStudent1);
			session.save(theStudent2);

			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
