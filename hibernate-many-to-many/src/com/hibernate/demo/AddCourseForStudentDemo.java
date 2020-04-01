package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class AddCourseForStudentDemo {

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
			
			int stuId=1;
			
			Student student=session.get(Student.class, stuId);
			
			Course tempCourse1 = new Course("Data Structure-How to score 1 million points!!");
			Course tempCourse2 = new Course("Java-How to score 1 million points!!");
			
			student.addCourse(tempCourse1);
			student.addCourse(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);


			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
