package org.hibernate.demo;

import java.util.Map;

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
			 Map<String,String> image=theStudent.getImages();
			
			image.put("photo1.png","My first image");
			image.put("photo2.png","My second image");
			image.put("photo3.png","My third image");
			image.put("photo4.png","My fourth image");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
		}finally {
			sessionFactory.close();
		}
	}

}
