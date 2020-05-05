package org.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value="INSTUCTOR") required in "SINGLE_TABLE" type
public class Instructor extends User {

	@Column(name="salary")
	private Double salary;
	
	public Instructor() {
	}

	public Instructor(String firstName, String lastName, String email,Double salary) {
		super(firstName, lastName, email);
		this.salary=salary;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
