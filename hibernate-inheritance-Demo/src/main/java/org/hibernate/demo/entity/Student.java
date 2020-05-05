package org.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="STUDENT")  required in "SINGLE_TABLE" type
public class Student extends User {

	@Column(name="courseName")
	private String courseName;
	
	
	public Student() {
		
	}

	public Student(String firstName, String lastName, String email,String courseName) {
		super(firstName, lastName, email);
		this.courseName=courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	

}
