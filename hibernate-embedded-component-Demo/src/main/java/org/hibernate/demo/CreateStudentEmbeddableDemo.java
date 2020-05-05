package org.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.demo.entity.Address;
import org.hibernate.demo.entity.Student;

public class CreateStudentEmbeddableDemo {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				                                         .addAnnotatedClass(Student.class)
				                                         .addAnnotatedClass(Address.class)
				                                         .buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		try{
			Student theStudent=new Student("Luv", "Singh", "luvsingh@gmail.com");
		    Address homeAddress=new Address("Van-vihar road","Jaunpur","222002");
		    Address billingAddress=new Address("choudhary park","Pune","411057");
			
			theStudent.setTheAddress(homeAddress);
			theStudent.setBillingAddress(billingAddress);
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
		}finally {
			sessionFactory.close();
		}
	}

}
