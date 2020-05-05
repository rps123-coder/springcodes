package org.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Instructor;
import org.hibernate.demo.entity.Student;

public class CreateUserDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				                                         .addAnnotatedClass(Student.class)
				                                         .addAnnotatedClass(Instructor.class)
				                                         .buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try{
			Student theStudent=new Student("Luv", "Singh", "luvsingh@gmail.com","Hibernate");
		    Instructor theInstructor=new Instructor("Van-vihar road","Jaunpur","222002",20000.00);
		 
			session.beginTransaction();
			
			session.save(theStudent);
			session.save(theInstructor);
			
			session.getTransaction().commit();
			
		}finally {
			sessionFactory.close();
		}
	}

}
