package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//Delete object using primary key
			session.delete(student);
			
			//Delete Querying objects
			session.createQuery("delete from Student where id=2").executeUpdate();
						
			// Commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
