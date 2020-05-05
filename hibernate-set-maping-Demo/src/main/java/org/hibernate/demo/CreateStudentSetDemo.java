package org.hibernate.demo;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Student;

public class CreateStudentSetDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				                                         .addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try{
			Student theStudent=new Student("Luv", "Singh", "luvsingh@gmail.com");
			Set<String> image=theStudent.getImages();
			
			image.add("photo1.png");
			image.add("photo2.png");
			image.add("photo3.png");
			image.add("photo4.png");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
		}finally {
			sessionFactory.close();
		}
	}

}
